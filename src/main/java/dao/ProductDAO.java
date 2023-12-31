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
				String product_image = rs.getString("product_image");
				Double product_price = rs.getDouble("product_price");
				String manufactor = rs.getString("manufactor");
				String information = rs.getString("information");
				list.add(new Product(product_id, category_id, product_name,
						product_image, product_price, manufactor, information));
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
				String product_image = rs.getString("product_image");
				Double product_price = rs.getDouble("product_price");
				String manufactor = rs.getString("manufactor");
				String information = rs.getString("information");
				list.add(new Product(product_id, category_id, product_name,
						product_image, product_price, manufactor, information));
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
				String product_image = rs.getString("product_image");
				Double product_price = rs.getDouble("product_price");
				String manufactor = rs.getString("manufactor");
				String information = rs.getString("information");
				p = new Product(product_id, category_id, product_name,
						product_image, product_price, manufactor, information);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}

	public static void main(String[] args) {
		System.out.println(ProductDAO.getListByCategory(1));
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
				String product_image = rs.getString("product_image");
				Double product_price = rs.getDouble("product_price");
				String manufactor = rs.getString("manufactor");
				String information = rs.getString("information");
				list.add(new Product(product_id, category_id, product_name,
						product_image, product_price, manufactor, information));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}
}
