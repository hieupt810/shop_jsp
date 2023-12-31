package controller;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.UserBO;
import model.User;

public class ResetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ResetPassword() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String err = "";
		if (username.equals("")) {
			err += "Phải nhập đầy đủ thông tin!";
		} else {
			if (UserBO.checkUser(username) == false) {
				err += "Tên đăng nhập không tồn tại!";
			}
		}
		if (err.length() > 0) {
			request.setAttribute("err", err);
		}
		String url = "/resetpassword.jsp";
		try {
			if (err.length() == 0) {
				User u = UserBO.getUser(username);
				User new_user = new User(u.getUser_id(), username, "00000", u.getNgaysinh(), u.getGioitinh(),
						u.getEmail(), u.getSdt(), u.getDiachi(), u.getRole());
				UserBO.updateUser(new_user);
				url = "/login.jsp";
				String mess = "Kiểm tra email để nhận mật khẩu mới!";
				request.setAttribute("mess", mess);
				final String username_mail = "trunghieupham03@gmail.com";
				final String password = "xxx";
				String to = u.getEmail();
				String subject = "Reset Password";
				String text = "<i>Reset Password</i><br/>";
				text += "<p>User: <strong>";
				text += username;
				text += "</strong></p>";
				text += "<p>New password: <strong>00000</strong></p>";
				Properties props = new Properties();
				props.put("mail.smtp.auth", "true");
				props.put("mail.smtp.starttls.enable", "true");
				props.put("mail.smtp.host", "smtp.gmail.com");
				props.put("mail.smtp.port", "587");
				Session session_mail = Session.getInstance(props,
						new javax.mail.Authenticator() {
							protected PasswordAuthentication getPasswordAuthentication() {
								return new PasswordAuthentication(username_mail, password);
							}
						});
				try {
					Message message = new MimeMessage(session_mail);
					message.setHeader("Content-Type", "text/plain; charset=UTF-8");
					message.setFrom(new InternetAddress(username_mail));
					message.setRecipients(Message.RecipientType.TO,
							InternetAddress.parse(to));
					message.setSubject(subject);
					message.setContent(text, "text/html; charset=utf-8");
					Transport.send(message);
				} catch (MessagingException e) {
					throw new RuntimeException(e);
				}

			} else {
				url = "/resetpassword.jsp";

			}
			RequestDispatcher rd = getServletContext()
					.getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("/resetpassword.jsp");
		}
	}

}
