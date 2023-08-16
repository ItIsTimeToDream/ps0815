package Exceptions;

public abstract class PointOfSalesServiceException extends Exception{

	private static final long serialVersionUID = -3459909185932509252L;

	public PointOfSalesServiceException() {
		super();
	}

	public PointOfSalesServiceException(String message) {
		super(message);
	}
	
	public PointOfSalesServiceException(Throwable cause) {
		super(cause);
	}
	
	public PointOfSalesServiceException(String message, Throwable cause) {
		super(message, cause);
	}
}
