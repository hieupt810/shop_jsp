package model;

public class Category {

	private int category_id;
	private String category_name;
	private String description;

	public Category() {
	}

	public Category(int category_id, String category_name, String description) {
		this.category_id = category_id;
		this.category_name = category_name;
		this.description = description;
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
		return description;
	}

	public void setMo_ta(String description) {
		this.description = description;
	}

}
