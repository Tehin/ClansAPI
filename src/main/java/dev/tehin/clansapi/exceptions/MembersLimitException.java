package dev.tehin.clansapi.exceptions;

public class MembersLimitException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2146622247139160090L;

	public MembersLimitException(String message) {
		super(message);
	}
	
	public MembersLimitException() {
		super("That player does not belong to that clan.");
	}
	
	
}
