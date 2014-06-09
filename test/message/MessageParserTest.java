package message;

import table.Point;
import junit.framework.TestCase;


public class MessageParserTest extends TestCase {

	public void testParseInit()
	{
		String message = MessageTypes.INIT_PREFIX + " 8, 9";
		
		Point dimensions = new MessageParser().parseInit(message);
		
		assertEquals(8, dimensions.getX());
		assertEquals(9, dimensions.getY());
	}

	public void testParseInitWithoutWhitespaceBetweenTheInitAndTheWidth()
	{
		try {
			String message = MessageTypes.INIT_PREFIX + "8, 9";
			
			new MessageParser().parseInit(message);
		}
		catch ( IllegalArgumentException e ) {
			return;
		}
		fail("The expected exception wasn't thrown.");
	}

	public void testParseInitOnlyWithComma()
	{
		String message = MessageTypes.INIT_PREFIX + " 8,9";
		
		Point dimensions = new MessageParser().parseInit(message);
		
		assertEquals(8, dimensions.getX());
		assertEquals(9, dimensions.getY());
	}
	
	public void testParseInitOnlyWithWhiteSpace()
	{
		String message = MessageTypes.INIT_PREFIX + " 8  9";
		
		Point dimensions = new MessageParser().parseInit(message);
		
		assertEquals(8, dimensions.getX());
		assertEquals(9, dimensions.getY());
	}
	
	
	public void testParseTableSizeWithoutComma()
	{
		Point dimensions = new MessageParser().parseTableSize( "8 9" );
		
		assertEquals( dimensions.getX(), 8 );
		assertEquals( dimensions.getY(), 9 );
	}
	
	public void testParseTableSizeWithoutCommaWithMoreSpace()
	{
		Point dimensions = new MessageParser().parseTableSize( " 8  9 " );
		
		assertEquals( dimensions.getX(), 8 );
		assertEquals( dimensions.getY(), 9 );
	}
	
	public void testParseTableSizeWithCommaWithMoreSpace()
	{
		Point dimensions = new MessageParser().parseTableSize( " 8, 9 " );
		
		assertEquals( dimensions.getX(), 8 );
		assertEquals( dimensions.getY(), 9 );
	}
	
	public void testParseTableSizeWithComma()
	{
		Point dimensions = new MessageParser().parseTableSize( "8, 9" );
		
		assertEquals( dimensions.getX(), 8 );
		assertEquals( dimensions.getY(), 9 );
	}
	
	public void testParseTableSizeWithOnlyOneNumber()
	{
		Point dimensions = new MessageParser().parseTableSize( " 8 " );
		
		assertEquals( dimensions.getX(), 8 );
		assertEquals( dimensions.getY(), 0 );
	}
}


