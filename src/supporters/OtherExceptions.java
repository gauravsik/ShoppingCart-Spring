package supporters;

public class OtherExceptions extends RuntimeException {
	private String message;

	public OtherExceptions(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
