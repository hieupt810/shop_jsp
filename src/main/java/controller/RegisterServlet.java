package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import model.Cart;
import model.User;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Cart> cart = new ArrayList<Cart>();

	public RegisterServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		java.sql.Date ngaysinh = null;
		try {
			ngaysinh = new java.sql.Date(
					(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("ngaysinh"))).getTime());
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		String gioitinh = request.getParameter("gioitinh");
		String email = request.getParameter("email");
		String sdt = request.getParameter("sdt");
		String diachi = request.getParameter("diachi");
		System.out.println(username);
		String err = "";
		String url = "/register.jsp";
		if (username.equals("") || password.equals("") || email.equals("") || diachi.equals("") || sdt.equals("")) {
			err += "Phải nhập đầy đủ thông tin!";
		} else {
			if (UserDAO.checkUser(username) == true) {
				err += "Tài khoản đã tồn tại!";
			} else {
				Pattern pattenObj = Pattern
						.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
								+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
				Matcher matcherObj = pattenObj.matcher(email);
				if (!matcherObj.matches()) {
					err += "Email sai định dạng!";
				}
			}
		}
		if (err.length() > 0) {
			request.setAttribute("err", err);
		}
		try {
			if (err.length() == 0) {
				HttpSession session = request.getSession();
				session.setAttribute("cart", cart);
				UserDAO.addUser(new User(0, username, password, ngaysinh, gioitinh, email, sdt, diachi, "2"));
				UserDAO.login(username, password);
				Cookie loginCookie = new Cookie("username", username);
				loginCookie.setMaxAge(30 * 60);
				response.addCookie(loginCookie);
				response.sendRedirect("index.jsp");

			} else {
				url = "/register.jsp";
				RequestDispatcher rd = getServletContext()
						.getRequestDispatcher(url);
				rd.forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("/register.jsp");
		}
	}
}
