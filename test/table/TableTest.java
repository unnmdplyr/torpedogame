package table;

import junit.framework.TestCase;

public class TableTest extends TestCase {

	public void testLoadShipDataFromFile_ShouldTableContainsMoreShips_WhenShipsLoadedFromFile()
	{
		Table table = new Table();
		table.setSize( new Point(8,8) );
		
		table.loadShipDataFromFile("ships.txt");
		
		assertTrue( table.getShipNumber() > 0 );
	}

}
