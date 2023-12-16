<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="css/register.css" rel='stylesheet' type='text/css' />
	<title>Đăng kí tài khoản</title>
</head>
<body>
<%
	String err = "";
	if (request.getAttribute("err") != null) {
		err = (String) request.getAttribute("err");
	}
%>
<form action="RegisterServlet" method="post" class="register">
	<h2>Đăng ký</h2>
	<h4 style="color:red"><%=err%></h4>
	<input type="text" class="text" value="" placeholder="Tên người dùng"
		   name="username">

	<input type="password" value="" placeholder="Mật khẩu"
		   name="password">

	<input type="date" value="" placeholder="Ngày sinh"
		   name="ngaysinh">

	<input type="text" value="" list="exampleList" placeholder="Giới tính"
		   name="gioitinh">
	<datalist id="exampleList">
		<option value="Nam">
		<option value="Nữ">
	</datalist>

	<input type="text" value="" placeholder="Email"
		   name="email">

	<input type="text" value="" placeholder="Số điện thoại"
		   name="sdt">

	<input type="text" value="" placeholder="Địa chỉ"
		   name="diachi">
	<button type="submit" value="ĐĂNG KÝ">Đăng ký </button>
	<div class="recommend-login">
		Đã có tài khoản?<a href="login.jsp"> Đăng nhập </a>
		<div class="blob"></div>
	</div>
</form>
</body>
</html>