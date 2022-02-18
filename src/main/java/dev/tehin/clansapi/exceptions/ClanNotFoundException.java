package dev.tehin.clansapi.exceptions;

public class ClanNotFoundException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8670166153485011035L;

	public ClanNotFoundException(String message) {
		super(message);
	}
	
	public ClanNotFoundException() {
		super("That clan does not exist.");
	}

}
