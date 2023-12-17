package abs;

import java.util.List;

import model.Category;

public interface CategoryDAO {
	public void addCategory(Category c);

	public List<Category> getList();

	public Category getCategory(int category_id);

	public void updateCategory(Category c);

	public void deleteCategory(int category_id);
}
