package util.exception;

public class PersistenceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PersistenceException(){ }

	public PersistenceException(String msg) {
		super(msg);
	}
	
	public PersistenceException(Throwable e){
		super(e);
	}

}
