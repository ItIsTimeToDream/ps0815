package Exceptions;

public class InvalidInputException extends PointOfSalesServiceException {

	private static final long serialVersionUID = -3838792189324216341L;

	public InvalidInputException() {
		// TODO Auto-generated constructor stub
	}

	public InvalidInputException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public InvalidInputException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidInputException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

}
