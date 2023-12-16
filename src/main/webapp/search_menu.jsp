<%@page import="java.util.ArrayList"%>
<%@page import="model.Category"%>
<%@page import="java.util.List"%>
<%@page import="dao.CategoryDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
	<%
		CategoryDAO categoryDAO = new CategoryDAO();
			List<Category> list = new ArrayList<Category>();
			list = categoryDAO.getList();
			String err="";
	%>
	<div class="container">
		<nav>
		<ul class="mcd-menu">
		<li>
		<form accept-charset="utf-8" method="post" action="SearchServlet" name="SearchServlet">
                        <p>
                        <label for="tensp">Tên sản phẩm</label>
                        <br>
                        <input accept-charset="utf-8" type="text" name="ten_san_pham" style="width:97%; border: 1px solid #e4e4e7; border-radius: 2px;">
                        </p>
                        <p>
                        <label for="theloai">Thể loại</label>
                        <br>
                        <select accept-charset="utf-8" name="ten_the_loai" style="width:100%">
                        	<option style="border: 1px solid #e4e4e7; border-radius: 2px;" value="" selected="selected">--Chọn thể loại--</option>
                        	<%
				for (Category c : list) {
					
			%>
                        	<option accept-charset="utf-8"  value="<%=c.getTen_the_loai() %>"><%=c.getTen_the_loai() %></option>
                        	<%} %>
                        </select>
                        </p>
                        <input type="submit" value="Tìm kiếm" name="timKiem">
                	</form>
                	</li>
                	<li style="color: red"><%=err%></li>
                	</ul>
		</nav>
	</div>
</body>
</html>