package dev.tehin.clansapi.exceptions;

public class NoLeaderException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5761371311270420369L;
	
	public NoLeaderException(String message) {
		super(message);
	}
	
	public NoLeaderException() {
		super("You cannot leave the clan without a leader.");
	}

}
