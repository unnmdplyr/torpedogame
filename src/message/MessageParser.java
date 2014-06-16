package message;

import java.util.StringTokenizer;

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
				width  = Integer.parseInt(parts[i].trim());
			else
				height = Integer.parseInt(parts[i].trim());
		}
		
		return new Point(width, height);
	}
	
	//	Accepted formats: " 8 ", "8 9", "8, 9", " 8 , 9 " " 8 9 "
	public Point parseTableSize(String message)
	{
		StringTokenizer tokenizer = new StringTokenizer(message, ", ");
		String widthStr = null;
		while ( tokenizer.hasMoreTokens() )
			if ( !( widthStr = tokenizer.nextToken()).equals("") )
				break;

		String heightStr = null;
		while ( tokenizer.hasMoreTokens() )
			if ( !( heightStr = tokenizer.nextToken()).equals("") )
				break;

		return new Point( Integer.parseInt(widthStr)
						, Integer.parseInt(heightStr != null  ?  heightStr  :  widthStr) );
	}

	public String parseName(String message) {

		int index = message.indexOf(MessageTypes.NAME_PREFIX);

		if ( index < 0 )
			throw new IllegalArgumentException( MessageTypes.NAME_MSG );

		String[] parts = message.split(" ");

		if ( !parts[0].equals(MessageTypes.NAME_PREFIX) )
			throw new IllegalArgumentException("This is not NAME message: " + message);

		for ( int i=1; i < parts.length; ++i )
			if ( !parts[i].isEmpty() )
				return parts[i];

		throw new IllegalArgumentException("NAME message doesn't contain name.");
	}
}
