package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Category;

public class CategoryDAO {

	public static void addCategory(Category c) {
		Connection con = DBConnect.getConnecttion();
		String sql = "insert into category value(?,?,?)";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, c.getMa_the_loai());
			ps.setString(2, c.getTen_the_loai());
			ps.setString(3, c.getMo_ta());
			ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static List<Category> getList() {
		Connection con = DBConnect.getConnecttion();
		String sql = "select * from category";
		List<Category> list = new ArrayList<Category>();
		try {
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int category_id = rs.getInt("category_id");
				String category_name = rs.getString("category_name");
				String description = rs.getString("description");
				list.add(new Category(category_id, category_name, description));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static void main(String[] args) {
		CategoryDAO dao = new CategoryDAO();
		Category c = new Category(8, "Samsung", "DT");
		dao.updateCategory(c);
	}

	public static void deleteCategory(int category_id) {
		Connection con = DBConnect.getConnecttion();
		String sql = "delete from category where category_id='" + category_id
				+ "'";
		try {
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement(sql);
			ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static Category getCategory(int id) {
		Connection con = DBConnect.getConnecttion();
		String sql = "select * from category where category_id='" + id + "'";
		Category c = new Category();
		try {
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int category_id = rs.getInt("category_id");
				String category_name = rs.getString("category_name");
				String description = rs.getString("description");
				c = new Category(category_id, category_name, description);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	public static void updateCategory(Category c) {
		Connection con = DBConnect.getConnecttion();
		String sql = "update category set category_name=?, description=? where category_id=?";
		try {
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement(sql);
			ps.setString(1, c.getTen_the_loai());
			ps.setString(2, c.getMo_ta());
			ps.setInt(3, c.getMa_the_loai());
			ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
