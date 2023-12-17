package bo;

import java.util.List;

import dao.HistoryDAO;
import model.History;

public class HistoryBO {
	public static void addHistory(History h) {
		HistoryDAO.addHistory(h);
	};

	public static List<History> getList(int user_id) {
		return HistoryDAO.getList(user_id);
	};
}
