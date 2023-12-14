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
				int ma_the_loai = rs.getInt("ma_the_loai");
				String ten_the_loai = rs.getString("ten_the_loai");
				String mo_ta = rs.getString("mo_ta");
				list.add(new Category(ma_the_loai, ten_the_loai, mo_ta));
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
		// dao.addCategory(c);
		// System.out.println(dao.getList());
		// dao.delCategory(10);
		dao.updateCategory(c);
	}


	public static void delCategory(int ma_the_loai) {
		Connection con = DBConnect.getConnecttion();
		String sql = "delete from category where ma_the_loai='" + ma_the_loai
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
		String sql = "select * from category where ma_the_loai='" + id + "'";
		Category c = new Category();
		try {
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int ma_the_loai = rs.getInt("ma_the_loai");
				String ten_the_loai = rs.getString("ten_the_loai");
				String mo_ta = rs.getString("mo_ta");
				c = new Category(ma_the_loai, ten_the_loai, mo_ta);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}


	public static void updateCategory(Category c) {
		Connection con = DBConnect.getConnecttion();
		String sql = "update category set ten_the_loai=?, mo_ta=? where ma_the_loai=?";
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
