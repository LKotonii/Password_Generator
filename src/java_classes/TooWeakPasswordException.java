package java_classes;

public class TooWeakPasswordException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TooWeakPasswordException(){
		System.out.println("Your password will be too short and unsecure");
	}
	
	
}
