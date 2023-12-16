<%@page import="java.util.ArrayList"%>
<%@page import="model.Category"%>
<%@page import="java.util.List"%>
<%@page import="dao.CategoryDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  	<head>
    	<meta charset="UTF-8" />
    	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
    	<script src="https://cdn.tailwindcss.com"></script>
		<style>
			* {
				margin: 0;
				padding: 0;
			}

			.nav-category {
				display: flex;
				flex-direction: column;
			}

			.nav-category > div {
				padding: 8px;
        		border: 1px solid #e4e4e7;
			}

			.nav-category > div > a {
				display: flex;
				align-items: flex-start;
				flex-direction: column;
				justify-content: center;
			}

			.nav-category > div > a > strong {
				font-size: 20px;
			}
		</style>
  	</head>
  	<body>
    	<%
	  		CategoryDAO categoryDAO = new CategoryDAO();
	  		List<Category> list = new ArrayList<Category>();
	  		list = categoryDAO.getList();
    	%>
		<div class="nav-category">
			<%
				for (Category c : list) {		
			%>
			<div>
				<a href="index.jsp?ma_the_loai=<%=c.getMa_the_loai()%>">
					<strong><%=c.getTen_the_loai()%></strong>
					<small><%=c.getMo_ta()%></small>
				</a>
			</div>
			<%
				}
			%>
		</div>
  	</body>
</html>