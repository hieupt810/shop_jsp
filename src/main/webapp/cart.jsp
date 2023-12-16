<%@page import="model.Cart"%>
<%@page import="java.util.List"%>
<%@page import="dao.ProductDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.NumberFormat"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

	  .list {
        display: flex;
        flex-wrap: wrap;
        flex-direction: column;
		margin: auto;
        justify-content: space-between;
      }

	  .item {
		margin: 5px;
		width: 100%;
        display: flex;
        flex-wrap: wrap;
        flex-direction: row;
		align-content: center;
        justify-content: space-between;
		padding: 5px;
        border: 1px solid #e4e4e7;
		border-radius: 10px;
      }

	  .item-text {
		height: max-content;
		width: 200px;
		text-align: center;
		text-align: center;
        padding: 8px;
      }

      .item-text h3 {
        font-size: 18px;
        font-weight: 700;
      }
      
      .img-container > img {
        width: 150px;
        height: 150px;
        object-fit: cover;
		border-radius: 10px;
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
		<main>
		<h1 style="color: orange; font-size: xx-large; font-weight: bolder; margin: 20px;">
			GIỎ HÀNG CỦA BẠN
		</h1>
		<div></div>
				<%
					ProductDAO productDAO = new ProductDAO();
						
											NumberFormat nf = NumberFormat.getInstance();
											nf.setMinimumIntegerDigits(0);
											double total = 0;
											ArrayList<Cart> cart=null;
											if(session.getAttribute("cart")!=null){
											cart = (ArrayList<Cart>) session
													.getAttribute("cart");}
				%>
				<%
					if (cart != null) {
										for (Cart c : cart) {
											total = total
													+ (c.getQuantity() * productDAO.getProduct(
															c.getP().getMa_san_pham()).getGia_ban());
				%>
			<div class="list">
				<div class="item">
					<div class="img-container">
						<img
							src="sanpham/<%=productDAO.getProduct(c.getP().getMa_san_pham())
							.getHinh_anh()%>">
					</div>
					<div class="item-text">
						<%=productDAO.getProduct(c.getP().getMa_san_pham())
						.getTen_san_pham()%>
					</div>
					<div class="item-text">
						<%=nf.format(productDAO.getProduct(c.getP()
						.getMa_san_pham()).getGia_ban())%>VNĐ
					</div>
					<div style="height: 30px;width: 120;text-align: center; border: 1px solid #e4e4e7;border-radius: 5px; display: flex;margin-top: 5px;">
						<div style="width: 30px;"><a class="cart_quantity_up" href="GioHangServlet?command=deleteCart&ma_san_pham=<%=c.getP().getMa_san_pham()%>"> - </a></div>
						<div style="width: 30px;border: 1px solid #e4e4e7;"><%=c.getQuantity()%></div>
						<div style="width: 30px;"><a class="cart_quantity_up" href="GioHangServlet?command=addCart&ma_san_pham=<%=c.getP().getMa_san_pham()%>"> + </a></div>
					</div>
					<div class="item-text">
						<%=nf.format(productDAO.getProduct(c.getP().getMa_san_pham())
						.getGia_ban()*c.getQuantity())%>VNĐ				
					<div style="background-color: crimson; border-radius: 25px;">
						<a
						href="GioHangServlet?command=removeCart&ma_san_pham=<%=c.getP().getMa_san_pham()%>" style="color: white;">Hủy</a>
					</div>
					</div>
					
				</div>
			</div>
				<%
					}
									}
				%>
				<div style="display: flex; align-items: center; justify-content: right; border-top: 1px solid #e4e4e7; margin-top: 20px;">
					<div>
						<div class="totals-value" id="cart-subtotal">Tổng thanh toán: <%=nf.format(total)%> VNĐ
						</div>
					</div>
					<%if(cart.size()>0){ %>
					<div style="background-color: orange; border-radius: 5px;padding: 5px; margin: 10px; width: fit-content;">
						<a class="checkout" href="ConfirmServlet?username=<%=username %>" style="color: white;">Thanh toán</a>
					</div>
					<%}else{ %>
					<div style="background-color: orange; border-radius: 5px; padding: 5px; margin: 10px; width: fit-content;">
						<a class="item-text" href="product.jsp" style="color: white;">Thanh toán</a>
					<div>
				<%} %>
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