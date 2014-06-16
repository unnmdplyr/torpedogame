package ship;

import java.io.FileReader;
import java.io.IOException;

import junit.framework.TestCase;
import table.Cell;
import table.Point;
import customship.CustomShip;
import customship.CustomShipLoader;


public class CustomShipTest extends TestCase {

	public void testCustomShips()
	{
		ShipContainer shipContainer = new ShipContainer();
		
		CustomShipLoader shipLoader = new CustomShipLoader(shipContainer, new Point(8,8));
		
		try ( FileReader fil = new FileReader("test/ship/2_four_lenght_ships.txt"); )
		{
			shipLoader.loadShipsFromStream(fil);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}

		
		for ( Ship ship : shipContainer )
		{
			for ( Cell cell : ship )
			{
				checkCellsInShip(cell, 8);
			}
		}
	}

	//	Helper function. Not Test case
	private void checkCellsInShip(Cell cell, final int tableSize)
	{
		assertEquals(true,	(cell.getX() > -1  &&  cell.getX() < tableSize)
						&&  (cell.getY() > -1  &&  cell.getY() < tableSize) );
	}
	
	public void testCustomShipsManyTimes()
	{
		for ( int i=0; i < 1000; ++i )
			testCustomShips();
	}
	
	
	public void testDetermineExtent4LengthShipUpperLeftAlongXAxis()
	{
		ShipContainer shipContainer = new ShipContainer();

		CustomShip ship = new CustomShip(shipContainer);
	
		for (int x = 0; x < 4; x++) {			
			ship.addCoveredCell(new Cell(1, x, 0));
		}
		
		Point pt = ship.determineExtent();
		
		assertEquals( true, pt.getX() == 4  &&  pt.getY() == 1 );
	}
	
	public void testDetermineExtent4LengthShipUpperLeftAlongYAxis()
	{
		ShipContainer shipContainer = new ShipContainer();

		CustomShip ship = new CustomShip(shipContainer);
	
		for (int y = 0; y < 4; y++) {			
			ship.addCoveredCell(new Cell(1, 0, y));
		}
		
		Point pt = ship.determineExtent();
		
		assertEquals( true, pt.getX() == 1  &&  pt.getY() == 4 );
	}
	
	public void testDetermineExtent4LengthShipLowerRightAlongYAxis()
	{
		ShipContainer shipContainer = new ShipContainer();

		CustomShip ship = new CustomShip(shipContainer);
	
		for (int y = 4; y < 8; y++) {			
			ship.addCoveredCell(new Cell(1, 7, y));
		}
		
		Point pt = ship.determineExtent();
		
		assertEquals( true, pt.getX() == 1  &&  pt.getY() == 4 );
	}
	
	public void testDetermineExtent4LengthShipLowerRightAlongXAxis()
	{
		ShipContainer shipContainer = new ShipContainer();

		CustomShip ship = new CustomShip(shipContainer);
	
		for (int x = 4; x < 8; x++) {			
			ship.addCoveredCell(new Cell(1, x, 7));
		}
		
		Point pt = ship.determineExtent();
		
		assertEquals( true, pt.getX() == 4  &&  pt.getY() == 1 );
	}
	
	public void testDetermineExtentTetrisShipLowerRightAlongXAxis()
	{
		ShipContainer shipContainer = new ShipContainer();

		CustomShip ship = new CustomShip(shipContainer);
	
		for (int x = 5; x < 8; x++) {			
			ship.addCoveredCell(new Cell(1, x, 7));
		}
		ship.addCoveredCell(new Cell(1, 6, 6));
		
		Point pt = ship.determineExtent();
		
		assertEquals( true, pt.getX() == 3  &&  pt.getY() == 2 );
	}
	
	//	Moving the ship			... to this position.
	//	from this position...
	//  - - - - - - - -           - - - - - - - - 
	// |1 1 1 1		   |         |				 |
	// |			   |         |			     |
	// |			   |         |			     |
	// |			   |         |			     |
	// |			   |         |		  1 1 1 1|
	// |			   |         |			     |
	// |			   |         |			     |
	// |			   |         |			     |
	//  - - - - - - - -           - - - - - - - - 
	public void testMoveToPosition()
	{
		ShipContainer shipContainer = new ShipContainer();
		CustomShip ship = new CustomShip(shipContainer);
	
		for (int x=0; x < 4; x++) {
			ship.addCoveredCell(new Cell(1, x, 0));
		}
		
		Point offset = new Point(4, 4);
		ship.moveToPosition(offset);
		
		for (int x=4; x < 8; x++) {
			assertEquals( true, ship.doesShipCoverThePosition(x, 4) );
		}
	}
}

