package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.UserBO;
import model.User;

public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateUser() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String user_id = request.getParameter("id");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		java.sql.Date date_of_birth = null;
		try {
			date_of_birth = new java.sql.Date(
					(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date_of_birth"))).getTime());
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		String sex = request.getParameter("sex");
		String email = request.getParameter("email");
		String phone_number = request.getParameter("phone_number");
		String address = request.getParameter("address");
		String err = "";
		String url = "/update_user.jsp";
		if (password.equals("") || email.equals("") || phone_number.equals("") || address.equals("")) {
			err += "Phải nhập đầy đủ thông tin!";
		} else {
			Pattern pattenObj = Pattern.compile(
					"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
			Matcher matcherObj = pattenObj.matcher(email);
			if (!matcherObj.matches()) {
				err += "Email sai định dạng!";
			} else {
				Pattern pattenObj2 = Pattern.compile("(09)\\d{8}|(01)\\d{9}");
				Matcher matcherObj2 = pattenObj2.matcher(phone_number);
				if (!matcherObj2.matches()) {
					err += "Sđt sai định dạng!";
				}
			}
		}
		if (err.length() > 0) {
			request.setAttribute("err", err);
		}
		try {
			if (err.length() == 0) {
				User u = new User(Integer.parseInt(user_id), username, password, date_of_birth, sex, email,
						phone_number,
						address,
						"2");
				UserBO.updateUser(u);
				url = "/index.jsp";
			} else {
				url = "/update_user.jsp";
			}
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("/register.jsp");
		}
	}
}
