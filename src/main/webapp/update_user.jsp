<%@page import="abs.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="bo.UserBO"%>
<%@page import="model.User"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/update-user.css" rel='stylesheet' type='text/css' />
<title>Cập nhật tài khoản</title>
</head>
<body>
	<%
		String err = "";
			if (request.getAttribute("err") != null) {
		err = (String) request.getAttribute("err");
			}
			String username= request.getParameter("username");
			User u= UserBO.getUser(username);
	%>
			<form action="UpdateUser" method="post" class="update">
				<h2>CẬP NHẬT TÀI KHOẢN</h2>
				<h3 style="color: red"><%=err%></h3>

				<input type="text" class="text"
					value="<%=u.getUsername()%>" readonly name="username">

				<input type="password" value=""  placeholder="Mật khẩu"
					name="password">

				<input type="date" value="<%=u.getNgaysinh()%>" placeholder="Ngày sinh"
					onfocus="this.value = '';"
					onblur="if (this.value == '') {this.value = '<%=u.getNgaysinh() %>';}"
					name="ngaysinh">

				<input type="text" value="<%=u.getGioitinh() %>" placeholder="Giới tính"
					list="exampleList" onfocus="this.value = '';"
					onblur="if (this.value == '') {this.value = '<%=u.getGioitinh() %>';}"
					name="gioitinh"> <datalist id="exampleList">
					<option value="Nam">
					<option value="Nữ">
					</datalist>

				<input type="text" value="<%= u.getEmail() %>" placeholder="Email" onfocus="this.value = '';"
					onblur="if (this.value == '') {this.value = '<%=u.getEmail() %>';}" name="email">

				<input type="text" placeholder="Số điện thoại" value="<%=u.getSdt() %>"
					onfocus="this.value = '';"
					onblur="if (this.value == '') {this.value = '<%=u.getSdt() %>';}" name="sdt">

				<input type="text" placeholder="Địa chỉ" value="<%=u.getDiachi() %>"
					onfocus="this.value = '';"
					onblur="if (this.value == '') {this.value = '<%=u.getDiachi() %>';}"
					name="diachi">
				<button type="submit" value="CẬP NHẬT">CẬP NHẬT</button>
				<input type="hidden" value="<%=u.getUser_id()%>" name="id">
				<div class="return-to-index">
					<a href="index.jsp">Trở về</a>
					<div class="blob"></div>
				</div>
			</form>
</body>
</html>