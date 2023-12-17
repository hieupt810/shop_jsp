package bo;

import java.util.List;

import dao.ProductDAO;
import model.Product;

public class ProductBO {
	public static void addProduct(Product p) {
		ProductDAO.addProduct(p);
	};

	public static List<Product> getList() {
		return ProductDAO.getList();
	}

	public static List<Product> getListByCategory(int category_id) {
		return ProductDAO.getListByCategory(category_id);
	};

	public static Product getProduct(int product_id) {
		return ProductDAO.getProduct(product_id);
	};

	public static List<Product> searchList(String product_name, String category_name) {
		return ProductDAO.searchList(product_name, category_name);
	};
}
