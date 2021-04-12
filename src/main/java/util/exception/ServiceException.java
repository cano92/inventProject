package util.exception;

public class ServiceException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ServiceException() { }
	
	public ServiceException(String msg ) {
		super(msg);
	}
	
	public ServiceException(Throwable e ) {
		super(e);
	}
}
