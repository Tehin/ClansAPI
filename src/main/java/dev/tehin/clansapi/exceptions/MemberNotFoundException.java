package dev.tehin.clansapi.exceptions;

public class MemberNotFoundException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8933955677449615016L;

	public MemberNotFoundException(String message) {
		super(message);
	}
	
	public MemberNotFoundException() {
		super("That clan already reached the members limit.");
	}

}
