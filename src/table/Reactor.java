package table;

import message.AbstractMessage;
import message.MessageObjectifier;
import message.MessageType;

public class Reactor {

	private Table localTable;
	private Table remoteTable;
	private MessageObjectifier messageObjectifier;

	public Reactor( Table localTable, Table remoteTable, MessageObjectifier messageObjectifier ) {
		this.localTable = localTable;
		this.remoteTable = remoteTable;
		this.messageObjectifier = messageObjectifier;
	}
	
	public void reactToMessage( String messageStr, MessageType expectedType )
	{
		AbstractMessage message = messageObjectifier.objectifyMessage(messageStr, expectedType);
		
		message.getAction().apply( localTable, remoteTable );
	}

	public void initTables(Point tableSize)
	{
		localTable .setSize(tableSize);
		remoteTable.setSize(tableSize);
	}

	public String initShips(String shipFile)
	{
		String shipData = localTable.loadShipDataFromFile( shipFile );
		System.out.println("Ship number: " + localTable.getShipNumber());
		return shipData;
	}

}
