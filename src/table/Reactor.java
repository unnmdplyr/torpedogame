package table;

import network.Sender;
import message.AbstractMessage;
import message.MessageObjectifier;
import message.MessageParser;
import message.MessageType;
import message.MessageTypes;

public class Reactor {

	private Table localTable;
	private Table remoteTable;
	private Sender writer;
	private MessageObjectifier messageObjectifier;

	public Reactor( Table localTable, Table remoteTable, Sender writer, MessageObjectifier messageObjectifier ) {
		this.localTable = localTable;
		this.remoteTable = remoteTable;
		this.writer = writer;
		this.messageObjectifier = messageObjectifier;
	}
	
	public void reactToMessage( String messageStr, MessageType expectedType )
	{
		AbstractMessage message = messageObjectifier.objectifyMessage(messageStr, expectedType);
		
		message.getAction().apply( localTable, remoteTable );
	}

}
