<%@page import="dao.ProductDAO"%> <%@page language="java"
contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@page
import="java.text.NumberFormat"%>
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
        width: 1200px;
        display: flex;
        flex-direction: column;
        padding: 32px 0;
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

      .info-container > h4 {
        text-transform: uppercase;
        font-size: 28px;
        font-weight: 700;
      }
    </style>
  </head>
  <body>
    <% String ma_san_pham = ""; if (request.getParameter("ma_san_pham") != null)
    { ma_san_pham = request.getParameter("ma_san_pham"); } ProductDAO productDAO
    = new ProductDAO(); NumberFormat nf = NumberFormat.getInstance();
    nf.setMinimumFractionDigits(0); %>
    <div class="nav-container">
      <nav>
        <div>
          <a href="index.jsp">Trang chủ</a>
          <a href="cart.jsp">Giỏ hàng</a>
        </div>
        <div>
          <% String username = null; Cookie[] cookies = request.getCookies(); if
          (cookies !=null) { for (Cookie cookie : cookies) { if
          (cookie.getName().equals("username")) username = cookie.getValue(); }
          } if (username != null) { %>
          <a href="update_user.jsp?username=<%=username%>">
            Xin chào, <%=username%>
          </a>
          <a href="LogoutServlet"><span>Đăng xuất</span></a>
          <% } else { %>
          <a href="login.jsp"><span>Đăng nhập</span></a>
          <% } %>
        </div>
      </nav>
    </div>

    <div class="banner-container">
      <img src="images/banner.jpg" class="banner" />
    </div>

    <main>
      <div class="img-container">
        <img
          src="sanpham/<%=productDAO.getProduct(Integer.parseInt(ma_san_pham)).getHinh_anh()%>"
        />
      </div>

      <div class="info-container">
        <h4>
          <%=productDAO.getProduct(Integer.parseInt(ma_san_pham)).getTen_san_pham()%>
        </h4>
        <h5>
          Hãng xuất xứ:
          <%=productDAO.getProduct(Integer.parseInt(ma_san_pham)).getHang_san_xuat()%>
        </h5>
        <h5>
          Giá hiện tại:
          <%=nf.format(productDAO.getProduct(Integer.parseInt(ma_san_pham)).getGia_ban())%>
          VNĐ
        </h5>
      </div>
    </main>
    <!-- <% if(username != null) { %>
      <div
        style="
          margin-left: auto;
          margin-right: auto;
          text-align: center;
          margin-top: 10px;
          padding: 10px;
          clear: both;
        "
      >
        <a href="#"><img src="images/giohang.png" /></a>
        <form action="GioHangServlet" method="post">
          <input type="number" min="1" value="1" name="soluong" />
          <input type="hidden" value="setCart" name="command" />
          <input type="hidden" value="<%=ma_san_pham %>" name="ma_san_pham" />
          <input type="submit" value="Thêm vào giỏ hàng" />
        </form>
      </div>
      <%} else { %>
      <div
        style="
          margin-left: auto;
          margin-right: auto;
          text-align: center;
          margin-top: 10px;
          padding: 10px;
          clear: both;
        "
      >
        <a href="login.jsp"><img src="images/giohang.png" /></a>
      </div>
      <%} %>
      <div class="left-3">
        <article>
          <input type="checkbox" id="read_more" role="button" />
          <label
            for="read_more"
            onclick=""
            style="width: 770px; margin-left: 150px; margin-right: auto"
            ><span>Xem thông tin chi tiết</span> <span>Đóng</span></label
          >
          <section>
            <table>
              <tr rowspan="2">
                <td class="detail-1">Thông chi tiết</td>
                <td class="detail-2">Đang cập nhật</td>
              </tr>
            </table>
          </section>
        </article>
      </div>
    </div> -->

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
