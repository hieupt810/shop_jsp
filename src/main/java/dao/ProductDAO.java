package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Product;

public class ProductDAO {

	public static void addProduct(Product p) {
		Connection con = DBConnect.getConnecttion();
		String sql = "insert into product value(?,?,?,?,?,?)";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, p.getMa_san_pham());
			ps.setString(2, p.getTen_san_pham());
			ps.setString(3, p.getHinh_anh());
			ps.setDouble(4, p.getGia_ban());
			ps.setString(5, p.getHang_san_xuat());
			ps.setString(6, p.getThong_tin());
			ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static List<Product> getList() {
		Connection con = DBConnect.getConnecttion();
		String sql = "select * from product";
		List<Product> list = new ArrayList<Product>();
		try {
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int product_id = rs.getInt("product_id");
				int category_id = rs.getInt("category_id");
				String product_name = rs.getString("product_name");
				String hinh_anh = rs.getString("hinh_anh");
				Double gia_ban = rs.getDouble("gia_ban");
				String hang_san_xuat = rs.getString("hang_san_xuat");
				String thong_tin = rs.getString("thong_tin");
				list.add(new Product(product_id, category_id, product_name,
						hinh_anh, gia_ban, hang_san_xuat, thong_tin));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static List<Product> getListByCategory(int id) {
		Connection con = DBConnect.getConnecttion();
		String sql = "select * from product where category_id='" + id + "'";
		List<Product> list = new ArrayList<Product>();
		try {
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int product_id = rs.getInt("product_id");
				int category_id = rs.getInt("category_id");
				String product_name = rs.getString("product_name");
				String hinh_anh = rs.getString("hinh_anh");
				Double gia_ban = rs.getDouble("gia_ban");
				String hang_san_xuat = rs.getString("hang_san_xuat");
				String thong_tin = rs.getString("thong_tin");
				list.add(new Product(product_id, category_id, product_name,
						hinh_anh, gia_ban, hang_san_xuat, thong_tin));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static Product getProduct(int id) {
		Connection con = DBConnect.getConnecttion();
		String sql = "select * from product where product_id='" + id + "'";
		Product p = new Product();
		try {
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int product_id = rs.getInt("product_id");
				int category_id = rs.getInt("category_id");
				String product_name = rs.getString("product_name");
				String hinh_anh = rs.getString("hinh_anh");
				Double gia_ban = rs.getDouble("gia_ban");
				String hang_san_xuat = rs.getString("hang_san_xuat");
				String thong_tin = rs.getString("thong_tin");
				p = new Product(product_id, category_id, product_name,
						hinh_anh, gia_ban, hang_san_xuat, thong_tin);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}

	public static void main(String[] args) {
		Product p = new Product(0, 1, "S6", "da", 500000.0, "", "");
		ProductDAO productDAO = new ProductDAO();
		// productDAO.addProduct(p);
		// System.out.println(productDAO.getList());
		System.out.println(productDAO.getListByCategory(1));
	}

	public static List<Product> searchList(String product_name, String category_name) {
		Connection con = DBConnect.getConnecttion();
		String sql = null;
		if (!product_name.equals("") && !category_name.equals("")) {
			sql = "SELECT * FROM product, category WHERE product_name= N'" + product_name
					+ "' AND product.category_id = category.category_id AND category_name=N'" + category_name + "'";
		} else {
			if (product_name.equals("")) {
				sql = "SELECT * FROM product, category WHERE product.category_id = category.category_id AND category_name=N'"
						+ category_name + "'";
			} else {
				if (category_name.equals("")) {
					sql = "SELECT * FROM product, category WHERE product_name= N'" + product_name
							+ "' AND product.category_id = category.category_id";
				}
			}
		}
		List<Product> list = new ArrayList<Product>();
		try {
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int product_id = rs.getInt("product_id");
				int category_id = rs.getInt("category_id");
				product_name = rs.getString("product_name");
				String hinh_anh = rs.getString("hinh_anh");
				Double gia_ban = rs.getDouble("gia_ban");
				String hang_san_xuat = rs.getString("hang_san_xuat");
				String thong_tin = rs.getString("thong_tin");
				list.add(new Product(product_id, category_id, product_name,
						hinh_anh, gia_ban, hang_san_xuat, thong_tin));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}
}
