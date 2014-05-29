package message;

public abstract class MessageTypes {


	public static final String INIT_PREFIX	= "INIT";
	public static final String NAME_PREFIX	= "NAME";
	public static final String SHIPS_PREFIX	= "SHIPS";
	public static final String READY_PREFIX	= "READY";
	
	public static final String FIRE_PREFIX	= "FIRE";
	public static final String SUNK			= "SUNK";
	public static final String MISS			= "MISS";
	public static final String WIN			= "WIN";



	public static final String INIT_MSG = "The 1st message from the server must be INIT .";
	public static final String NAME_MSG = "The 2nd message from the server must be NAME .";
	public static final String SHIPS_MSG = "The 3rd message from the server must be SHIPS .";
	public static final String READY_MSG = "The 5th message from the server must be READY .";

}
