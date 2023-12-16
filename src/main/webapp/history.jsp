<%@page import="model.History"%>
<%@page import="model.Cart"%>
<%@page import="bo.HistoryBO"%>
<%@page import="bo.ProductBO"%>
<%@page import="bo.UserBO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.NumberFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="model.User"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <script src="https://cdn.tailwindcss.com"></script>
    <title>Giỏ hàng</title>
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
        flex-direction: row;
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

      table {
        width: 100%;
        border-collapse: collapse;
      }

      td, th {
        width: 20%;
        font-weight: normal;
        border: 1px solid #e4e4e7;
      }

      .tr-title > * {
        padding: 4px;
        color: white;
        font-weight: 700 !important;
        background-color: #04AA6D;
      }

      tr:nth-child(odd) {
        background-color: #f2f2f2;
      }
    </style>
  </head>
  <body>
    <%
		String username = null;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("username"))
					username = cookie.getValue();
			}
		}
	%>
    <div class="nav-container">
      <nav>
        <div>
          <a href="index.jsp">Trang chủ</a>
          <a href="product.jsp">Sản phẩm</a>
          <a href="cart.jsp">Giỏ hàng</a>
        </div>

        <div>
          <a href="update_user.jsp?username=<%=username%>"
            >Xin chào, <%=username%></a
          >
          <a href="LogoutServlet"><span>Đăng xuất</span></a>
        </div>
      </nav>
    </div>

    <div class="banner-container">
      <img src="images/banner.jpg" class="banner" />
    </div>

    <main>
      <table>
        <tr class="tr-title">
          <th>Hình ảnh</th>
          <th>Sản phẩm</th>
          <th>Ngày mua</th>
          <th>Số lượng</th>
          <th>Đã thanh toán</th>
        </tr>

        <%
          User u = UserBO.getUser(username);
  
          List<History> L = HistoryBO.getList(u.getUser_id());
          NumberFormat nf = NumberFormat.getInstance();
          nf.setMinimumIntegerDigits(0);
        %>

        <%
          if (L != null) {
            for (History h : L) {
        %>
        <tr>
          <th>
            <img src="sanpham/<%=ProductBO.getProduct(h.getMa_san_pham()).getHinh_anh()%>">
          </th>
          <th>
            <%=ProductBO.getProduct(h.getMa_san_pham()).getTen_san_pham()%>
          </th>
          <th>
            <%=h.getNgay_mua()%>
          </th>
          <th>
            <%=h.getSo_luong()%>
          </th>
          <th>
            <%=nf.format(ProductBO.getProduct(h.getMa_san_pham()).getGia_ban())%> VNĐ
          </th>
        </tr>
        <% } } %>
      </table>
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
