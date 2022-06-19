package exception;

public class Notwordexception extends Exception{
	public Notwordexception() {};
	
	public Notwordexception(String msg) {
		System.out.println(msg);
	}
}
