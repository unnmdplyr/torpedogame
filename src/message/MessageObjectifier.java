package message;

import table.Point;

public class MessageObjectifier {

	private MessageParser messageParser;

	public MessageObjectifier(MessageParser messageParser) {
		this.messageParser = messageParser;
	}

	public AbstractMessage objectifyMessage( String message, MessageType messageType )
	{
		switch ( messageType )
		{
			case INIT:
				Point tableDimensions = messageParser.parseInit(message);
				return new MsgInit( tableDimensions );

			case NAME:
				String name = messageParser.parseName(message);
				return new MsgName( name );

			case SHIPS:
				String shipData = messageParser.parseShips(message);
				return new MsgShips(shipData);

			case READY:
				return new MsgEmpty(message);

			default:
				throw new IllegalArgumentException("The message couldn't be interpreted: " + message);
		}
	}
	
}
