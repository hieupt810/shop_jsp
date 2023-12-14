package bo;

import java.util.List;

import model.History;
import dao.HistoryDAO;

public class HistoryBO {
	

	public static void addHistory(History h) {
		HistoryDAO.addHistory(h);
	};
	
	//l�?c lịch sử của khách hàng.
	public static List<History> getList(int user_id){
		return HistoryDAO.getList(user_id);
	};

}
