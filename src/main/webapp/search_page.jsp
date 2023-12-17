<%@page import="java.util.ArrayList"%>
<%@page import="model.Product"%>
<%@page import="java.util.List"%>
<%@page import="dao.ProductDAO"%>
<%@page import="java.text.NumberFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
        box-sizing: border-box;
      }

      .banner-container {
        display: flex;
        align-items: center;
        justify-content: center;
        border-bottom: 1px solid #e4e4e7;
      }

      .banner {
        width: 1200px;
        object-fit: cover;
      }

      .nav-container {
        border-bottom: 1px solid #e4e4e7;
      }

      .footer-container {
        border-top: 1px solid #e4e4e7;
      }

      nav {
        margin: auto;
        width: 1200px;
        display: flex;
        align-items: center;
        justify-content: space-between;
      }

      nav > div {
        display: flex;
      }

      nav > div > a {
        padding: 12px 20px;
        list-style: none;
      }

      main {
        margin: auto;
        padding: 32px 0;
        width: 1200px;
        display: flex;
        flex-direction: row;
        justify-content: space-between;
      }

      footer {
        margin: auto;
        width: 1200px;
        display: flex;
        align-items: flex-start;
        justify-content: space-between;
      }

      footer > div {
        width: 50%;
        padding: 24px 0;
        display: flex;
        align-items: center;
        flex-direction: column;
      }

      footer > div > h5 {
        font-weight: 700;
        margin-bottom: 12px;
      }

      footer > div > span {
        margin-bottom: 6px;
      }

      .left {
        width: 20%;
      }

      .right {
        width: 75%;
      }

      .list {
        display: flex;
        flex-wrap: wrap;
        flex-direction: row;
        justify-content: space-between;
      }

      .item {
        overflow: hidden;
        margin-bottom: 20px;
        border-radius: 12px;
        border: 1px solid #e4e4e7;
      }

      .item-text {
        padding: 8px;
      }

      .item-text h3 {
        font-size: 18px;
        font-weight: 700;
      }
      
      .img-container > img {
        width: 250px;
        height: 250px;
        object-fit: cover;
      }
    </style>
</head>
<body>
	<div class="nav-container">
		<nav>
		  <div>
			<a href="index.jsp">Trang chủ</a>
			<a href="cart.jsp">Giỏ hàng</a>
			<a href="search_page.jsp">Tìm kiếm</a>
		  </div>
  
		  <div>
			<%
					String username = null;
					  Cookie[] cookies = request.getCookies();
			  if (cookies !=null)
			  {
				for (Cookie cookie : cookies)
				{
				  if (cookie.getName().equals("username")) 
					username = cookie.getValue();
				}
			  }
			  if (username != null) {
				  %>
			<a href="update_user.jsp?username=<%=username%>">
			  Xin chào, <%=username%>
			</a>
			<a href="LogoutServlet"><span>Đăng xuất</span></a>
			<%
					  } else {
				  %>
			<a href="login.jsp"><span>Đăng nhập</span></a>
			<%
					  }
				  %>
		  </div>
		</nav>
	  </div>
  
	  <div class="banner-container">
		<img src="images/banner.jpg" class="banner" />
	  </div>

		<main id="content">
			<div class="left"><jsp:include page="search_menu.jsp"></jsp:include></div>
			<div class="right">
				<%
					ProductDAO productDAO = new ProductDAO();
								List<Product> list = new ArrayList<Product>();
								list = productDAO.getList();
								String product_name = "";
								String category_name = "";
								if (request.getParameter("category_name") != null && request.getParameter("product_name")!= null) {
							category_name = request.getParameter("category_name");
							product_name = request.getParameter("product_name");
								}
								NumberFormat nf = NumberFormat.getInstance();
								nf.setMinimumFractionDigits(0);
				%>
				<% String err = "";
				if (request.getAttribute("err") != null) {
					err = (String) request.getAttribute("err");%>
					<h3><%=err %></h3>
				<% } %>
				
				<%if(productDAO.searchList(product_name, category_name).size()==0 && err=="") {%>
					<h3>Không tìm thấy sản phẩm nào phù hợp</h3>
					<%} %>
				<div id="site-wrapper" style="float: left">
					<ul class="products homepage">
					
						<%
							if (category_name != null || product_name != null) {
									for (Product p : productDAO.searchList(product_name, category_name)) {
						%>

						<div class="item">
							<a
							href="detail.jsp?product_id=<%=p.getMa_san_pham()%>"> 
								<div class="img-container">
									<img src="sanpham/<%=p.getHinh_anh()%>"/>
								</div>
								<div class="item-text">
								<h3><%=p.getTen_san_pham()%></h3>
								<h4>
									Giá:
									<%=nf.format(p.getGia_ban())%>
									VNĐ
								</h4>
								</div>
							</a>
						</div>
						<%
							}
								} else {%>
									<h3> Nhập thông tin tìm kiếm </h3>
								<%}
						%>
					</ul>
				</div>
	</main>
	<div class="footer-container">
		<footer>
		  <div>
			<h5>Học phần</h5>
			<span>Công nghệ Web</span>
		  </div>
  
		  <div>
			<h5>Sinh viên thực hiện</h5>
			<span>Phạm Trung Hiếu - 21TCLC_Nhat1</span>
			<span>Đặng Ngọc Nam - 21TCLC_Nhat1</span>
			<span>Nguyễn Văn Bách - 21TCLC_Nhat1</span>
		  </div>
		</footer>
	  </div>
</body>
</html>