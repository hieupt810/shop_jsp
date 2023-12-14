package bo;

import model.User;
import dao.UserDAO;

public class UserBO {

	public void addUser(User u) {
		UserDAO.addUser(u);
	};

	public static boolean checkUser(String username) {
		return UserDAO.checkUser(username);
	};

	public boolean login(String username, String password) {
		return UserDAO.login(username, password);
	};

	public static void updateUser(User u) {
		UserDAO.updateUser(u);
	};

	public static User getUser(String username) {
		return UserDAO.getUser(username);
	};

}
