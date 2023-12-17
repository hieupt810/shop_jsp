package model;

public class Product {

	private int product_id;
	private int category_id;
	private String product_name;
	private String hinh_anh;
	private Double gia_ban;
	private String hang_san_xuat;
	private String thong_tin;

	public Product() {
	}

	public Product(int product_id, int category_id, String product_name,
			String hinh_anh, Double gia_ban, String hang_san_xuat,
			String thong_tin) {
		this.product_id = product_id;
		this.category_id = category_id;
		this.product_name = product_name;
		this.hinh_anh = hinh_anh;
		this.gia_ban = gia_ban;
		this.hang_san_xuat = hang_san_xuat;
		this.thong_tin = thong_tin;
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
		return hinh_anh;
	}

	public void setHinh_anh(String hinh_anh) {
		this.hinh_anh = hinh_anh;
	}

	public Double getGia_ban() {
		return gia_ban;
	}

	public void setGia_ban(Double gia_ban) {
		this.gia_ban = gia_ban;
	}

	public String getHang_san_xuat() {
		return hang_san_xuat;
	}

	public void setHang_san_xuat(String hang_san_xuat) {
		this.hang_san_xuat = hang_san_xuat;
	}

	public String getThong_tin() {
		return thong_tin;
	}

	public void getThong_tin(String thong_tin) {
		this.thong_tin = thong_tin;
	}

	public int getMa_the_loai() {
		return category_id;
	}

	public void setMa_the_loai(int category_id) {
		this.category_id = category_id;
	}

}
