package bo;

import java.util.List;

import model.Category;
import dao.CategoryDAO;

public class CategoryBO {

	public static void addCategory(Category c) {
		CategoryDAO.addCategory(c);
	}

	public static void delCategory(int ma_the_loai) {
		CategoryDAO.delCategory(ma_the_loai);
	}


	public static List<Category> getList(){
		return CategoryDAO.getList();
	}

	public static Category getCategory(int ma_the_loai) {
		return CategoryDAO.getCategory(ma_the_loai);
	}
	
	public static void updateCategory(Category c) {
		CategoryDAO.updateCategory(c);
	}

}
