package model;

import java.sql.Timestamp;

public class History {
	private int id_history;
	private int user_id;
	private int product_id;
	private Timestamp bought_date;
	private int quantity;
	private double price;

	public History() {
	}

	public History(int id_history, int user_id, int product_id, Timestamp bought_date,
			int quantity, double price) {

		this.id_history = id_history;
		this.user_id = user_id;
		this.product_id = product_id;
		this.bought_date = bought_date;
		this.quantity = quantity;
		this.price = price;
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
		return bought_date;
	}

	public void setNgay_mua(Timestamp bought_date) {
		this.bought_date = bought_date;
	}

	public int getSo_luong() {
		return quantity;
	}

	public void setSo_luong(int quantity) {
		this.quantity = quantity;
	}

	public double getThanh_tien() {
		return price;
	}

	public void setThanh_tien(double price) {
		this.price = price;
	}

}
