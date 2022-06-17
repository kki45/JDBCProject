package voca.exception;

public class ValidationException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2956383307852034952L;
	
	public ValidationException() {
		
	}
	
	public ValidationException(String msg) {
		System.out.println(msg);
	}
	
}
