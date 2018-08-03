package by.epam.carrent.dao;

public class DAOFactory {
	
	private static final DAOFactory instance = new DAOFactory();
	
	private final iDAO iDao = new DAO();

	public static DAOFactory getInstance() {
		return instance;
	}

	public iDAO getiDao() {
		return iDao;
	}
}