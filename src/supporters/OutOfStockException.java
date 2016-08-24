package supporters;

public class OutOfStockException extends RuntimeException {
	private String message;

	public OutOfStockException() {

	}

	public OutOfStockException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
