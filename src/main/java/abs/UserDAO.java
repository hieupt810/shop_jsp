package abs;

import model.User;

public interface UserDAO {
	public void addUser(User u);

	public User getUser(String username);

	public void updateUser(User u);

	public boolean checkUser(String username);

	public boolean login(String username, String password);
}
