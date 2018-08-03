package by.epam.carrent.service;

public class ServiceFactory {
	
	private static final ServiceFactory instance = new ServiceFactory();
	
	private final iService iService = new Service();

	public static ServiceFactory getInstance() {
		return instance;
	}

	public iService getiService() {
		return iService;
	}
}