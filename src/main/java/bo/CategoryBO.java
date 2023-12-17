package bo;

import java.util.List;

import dao.CategoryDAO;
import model.Category;

public class CategoryBO {
	public static void addCategory(Category c) {
		CategoryDAO.addCategory(c);
	}

	public static List<Category> getList() {
		return CategoryDAO.getList();
	}

	public static Category getCategory(int category_id) {
		return CategoryDAO.getCategory(category_id);
	}

	public static void updateCategory(Category c) {
		CategoryDAO.updateCategory(c);
	}

	public static void deleteCategory(int category_id) {
		CategoryDAO.deleteCategory(category_id);
	}
}
