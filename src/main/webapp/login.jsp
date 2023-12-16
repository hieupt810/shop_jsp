<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/login.css" rel='stylesheet'/>
<title>Đăng nhập hệ thống</title>
</head>
<body>
	<%
		String err = "";
	if (request.getAttribute("err") != null) {
		err = (String) request.getAttribute("err");
	}
	%>
			<form action="LoginServlet" method="post" class="login">
				<h2>Đăng nhập</h2>
				<h4 style="color: red"><%=err%></h4>
				<input type="text" class="text" value="" name="username" placeholder="Username">
					<input type="password" value="" name="password" placeholder="Password">
					<button type="submit" value="SIGN IN">SIGN IN</button>
				<div class="recommend-register">
					Bạn muốn đăng ký tài khoản?<a href="register.jsp"> Đăng ký </a>
				</div>
			</form>

</body>
</html>