package bo;

import java.util.List;

import model.Product;
import dao.ProductDAO;

public class ProductBO {

	// thêm sản phẩm mới
	public static void addProduct(Product p) {
		ProductDAO.addProduct(p);
	};

	// hiển thị danh sách sản phẩm
	public static List<Product> getList(){
		return ProductDAO.getList();
	}

	// lấy danh sách sản phẩm dựa vào thể loại
	public static List<Product> getListByCategory(int ma_the_loai){
		return ProductDAO.getListByCategory(ma_the_loai);
	};
	
	public static Product getProduct(int ma_san_pham) {
		return ProductDAO.getProduct(ma_san_pham);
	};
	
	public static List<Product> searchList(String ten_san_pham, String ten_the_loai){
		return ProductDAO.searchList(ten_san_pham, ten_the_loai);
	};

}
