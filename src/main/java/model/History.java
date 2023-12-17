package model;

import java.sql.Timestamp;

public class History {
	private int id_history;
	private int user_id;
	private int product_id;
	private Timestamp ngay_mua;
	private int so_luong;
	private double thanh_tien;

	public History() {
	}

	public History(int id_history, int user_id, int product_id, Timestamp ngay_mua,
			int so_luong, double thanh_tien) {

		this.id_history = id_history;
		this.user_id = user_id;
		this.product_id = product_id;
		this.ngay_mua = ngay_mua;
		this.so_luong = so_luong;
		this.thanh_tien = thanh_tien;
	}

	public int getId_history() {
		return id_history;
	}

	public void setId_history(int id_history) {
		this.id_history = id_history;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getMa_san_pham() {
		return product_id;
	}

	public void setMa_san_pham(int product_id) {
		this.product_id = product_id;
	}

	public Timestamp getNgay_mua() {
		return ngay_mua;
	}

	public void setNgay_mua(Timestamp ngay_mua) {
		this.ngay_mua = ngay_mua;
	}

	public int getSo_luong() {
		return so_luong;
	}

	public void setSo_luong(int so_luong) {
		this.so_luong = so_luong;
	}

	public double getThanh_tien() {
		return thanh_tien;
	}

	public void setThanh_tien(double thanh_tien) {
		this.thanh_tien = thanh_tien;
	}

}
