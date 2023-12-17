package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import model.History;

public class HistoryDAO {

	public static void addHistory(History h) {
		Connection con = DBConnect.getConnecttion();
		String sql = "insert into history value(?,?,?,?,?,?)";
		PreparedStatement ps;

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, h.getId_history());
			ps.setInt(2, h.getUser_id());
			ps.setInt(3, h.getMa_san_pham());
			ps.setTimestamp(4, h.getNgay_mua());
			ps.setInt(5, h.getSo_luong());
			ps.setDouble(6, h.getThanh_tien());
			ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static List<History> getList(int id) {
		Connection con = DBConnect.getConnecttion();
		String sql = "select * from history where user_id='" + id + "'";
		List<History> list = new ArrayList<History>();
		try {
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id_history = rs.getInt("id_history");
				int user_id = rs.getInt("user_id");
				int product_id = rs.getInt("product_id");
				Timestamp bought_date = rs.getTimestamp("bought_date");
				int quantity = rs.getInt("quantity");
				double price = rs.getDouble("price");
				list.add(new History(id_history, user_id, product_id, bought_date, quantity, price));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
