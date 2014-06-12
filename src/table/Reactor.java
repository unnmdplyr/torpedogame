package table;

import message.MessageObjectifier;
import message.MessageParser;
import message.MessageTypes;

public class Reactor {

	private Table localTable;
	private Table remoteTable;
	private MessageObjectifier messageObjectifier;

	public Reactor( Table localTable, Table remoteTable, MessageObjectifier messageObjectifier ) {
		this.localTable = localTable;
		this.remoteTable = remoteTable;
		this.messageObjectifier = messageObjectifier;
	}
	
	public void reactToMessage( String message, String expected )
	{
		switch (expected)
		{
		case MessageTypes.INIT_PREFIX:
			Point tableDimensions = new MessageParser().parseInit(message);
			localTable.setSize(tableDimensions.getX());
			break;
		}
		
	}

}
