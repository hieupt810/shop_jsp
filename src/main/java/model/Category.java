package model;

public class Category {

	private int category_id;
	private String category_name;
	private String mo_ta;

	public Category() {
	}

	public Category(int category_id, String category_name, String mo_ta) {
		this.category_id = category_id;
		this.category_name = category_name;
		this.mo_ta = mo_ta;
	}

	public int getMa_the_loai() {
		return category_id;
	}

	public void setMa_the_loai(int category_id) {
		this.category_id = category_id;
	}

	public String getTen_the_loai() {
		return category_name;
	}

	public void setTen_the_loai(String category_name) {
		this.category_name = category_name;
	}

	public String getMo_ta() {
		return mo_ta;
	}

	public void setMo_ta(String mo_ta) {
		this.mo_ta = mo_ta;
	}

}
