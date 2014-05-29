package message;

import table.Point;

public class MessageParser {

	public Point parseInit(String message)
	{
		int index = message.indexOf(MessageTypes.INIT_PREFIX);

		if ( index < 0 )
			throw new IllegalArgumentException( MessageTypes.INIT_MSG );

		String[] parts = message.split("[ ,]");
		
		if ( !parts[0].equals(MessageTypes.INIT_PREFIX) )
			throw new IllegalArgumentException("This is not INIT message: " + message);
		
		if ( parts.length < 2 )
			throw new IllegalArgumentException("INIT message doesn't contain dimensions.");

		int width  = -1;
		int height = -1;
		
		for ( int i=1; i < parts.length; ++i )
		{
			if ( parts[i].isEmpty() )
				continue;
			
			if ( width < 0 )
				width  = Integer.parseInt(parts[i]);
			else
				height = Integer.parseInt(parts[i]);
		}
		
		return new Point(width, height);
	}
}
