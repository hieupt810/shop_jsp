package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class UserDAO {

	public static void addUser(User u) {
		Connection con = DBConnect.getConnecttion();
		String sql = "insert into user value(?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, u.getUser_id());
			ps.setString(2, u.getUsername());
			ps.setString(3, u.getPassword());
			ps.setDate(4, u.getNgaysinh());
			ps.setString(5, u.getGioitinh());
			ps.setString(6, u.getEmail());
			ps.setString(7, u.getSdt());
			ps.setString(8, u.getDiachi());
			ps.setString(9, u.getRole());
			ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static boolean checkUser(String username) {
		Connection con = DBConnect.getConnecttion();
		String sql = "select * from user where username='" + username + "'";
		PreparedStatement ps;
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				con.close();
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void main(String[] args) {
	}

	public static boolean login(String username, String password) {
		Connection con = null;
		String sql = "select * from user where username='" + username
				+ "' and password='" + password + "'";
		PreparedStatement ps;
		try {
			con = DBConnect.getConnecttion();
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				con.close();
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void updateUser(User u) {
		Connection con = DBConnect.getConnecttion();
		String sql = "update user set user_id=?, password=?, date_of_birth=?, sex=?, email=?, phone_number=?, address=?, role=? where username=?";
		try {
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement(sql);
			ps.setInt(1, u.getUser_id());
			ps.setString(2, u.getPassword());
			ps.setDate(3, u.getNgaysinh());
			ps.setString(4, u.getGioitinh());
			ps.setString(5, u.getEmail());
			ps.setString(6, u.getSdt());
			ps.setString(7, u.getDiachi());
			ps.setString(8, u.getRole());
			ps.setString(9, u.getUsername());
			ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static User getUser(String name) {
		Connection con = DBConnect.getConnecttion();
		String sql = "select * from user where username='" + name + "'";
		User u = new User();
		try {
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int user_id = rs.getInt("user_id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				Date date_of_birth = rs.getDate("date_of_birth");
				String sex = rs.getString("sex");
				String email = rs.getString("email");
				String phone_number = rs.getString("phone_number");
				String address = rs.getString("address");
				String role = rs.getString("role");
				u = new User(user_id, username, password, date_of_birth, sex, email, phone_number, address, role);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

}
