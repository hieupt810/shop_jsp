package model;

public class Product {

	private int product_id;
	private int category_id;
	private String product_name;
	private String product_image;
	private Double product_price;
	private String manufactor;
	private String information;

	public Product() {
	}

	public Product(int product_id, int category_id, String product_name,
			String product_image, Double product_price, String manufactor,
			String information) {
		this.product_id = product_id;
		this.category_id = category_id;
		this.product_name = product_name;
		this.product_image = product_image;
		this.product_price = product_price;
		this.manufactor = manufactor;
		this.information = information;
	}

	public int getMa_san_pham() {
		return product_id;
	}

	public void setMa_san_pham(int product_id) {
		this.product_id = product_id;
	}

	public String getTen_san_pham() {
		return product_name;
	}

	public void setTen_san_pham(String product_name) {
		this.product_name = product_name;
	}

	public String getHinh_anh() {
		return product_image;
	}

	public void setHinh_anh(String product_image) {
		this.product_image = product_image;
	}

	public Double getGia_ban() {
		return product_price;
	}

	public void setGia_ban(Double product_price) {
		this.product_price = product_price;
	}

	public String getHang_san_xuat() {
		return manufactor;
	}

	public void setHang_san_xuat(String manufactor) {
		this.manufactor = manufactor;
	}

	public String getThong_tin() {
		return information;
	}

	public void getThong_tin(String information) {
		this.information = information;
	}

	public int getMa_the_loai() {
		return category_id;
	}

	public void setMa_the_loai(int category_id) {
		this.category_id = category_id;
	}

}
