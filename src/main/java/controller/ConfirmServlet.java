package controller;

import java.io.IOException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.HistoryBO;
import bo.ProductBO;
import bo.UserBO;
import model.Cart;
import model.History;
import model.User;

public class ConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ConfirmServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		User u = UserBO.getUser(username);
		Calendar calendar = Calendar.getInstance();
		java.sql.Timestamp tdate = new java.sql.Timestamp(calendar.getTime().getTime());

		double total = 0;
		ArrayList<Cart> cart = (ArrayList<Cart>) request.getSession().getAttribute("cart");
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMinimumFractionDigits(0);

		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy 'at' hh:mm:ss a");

		final String fromMail = "trunghieupham03@gmail.com";
		final String password = "xxx";
		String to = u.getEmail();
		String subject = "Confirm Cart";
		String text = "<strong>Đơn Hàng - " + username + " - </strong><i> " + ft.format(dNow) + "</i> <ul>";
		if (cart != null) {
			for (Cart c : cart) {
				total = total + (c.getQuantity() * ProductBO.getProduct(c.getP().getMa_san_pham()).getGia_ban());
				text += "<li>" + ProductBO.getProduct(c.getP().getMa_san_pham()).getTen_san_pham() + ": "
						+ nf.format(ProductBO.getProduct(c.getP().getMa_san_pham()).getGia_ban()) + "VNĐ </li>";
				History h = new History(0, u.getUser_id(), c.getP().getMa_san_pham(), tdate, c.getQuantity(),
						(c.getQuantity() * ProductBO.getProduct(c.getP().getMa_san_pham()).getGia_ban()));
				HistoryBO.addHistory(h);
			}
		}
		text += "Tổng thanh toán: <strong>" + nf.format(total) + " VNĐ </strong>";
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		Session session_mail = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromMail, password);
			}
		});
		try {
			Message message = new MimeMessage(session_mail);
			message.setHeader("Content-Type", "text/plain; charset=UTF-8");
			message.setFrom(new InternetAddress(fromMail));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject(subject);
			message.setContent(text, "text/html; charset=utf-8");
			Transport.send(message);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		cart.clear();
		request.getSession().setAttribute("cart", cart);
		response.sendRedirect("index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
