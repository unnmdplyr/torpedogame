package ship;

import table.Cell;
import table.Point;
import customship.CustomShip;
import customship.CustomShipLoader;
import junit.framework.TestCase;


public class CustomShipTest extends TestCase {

	public void testCustomShips()
	{
		ShipContainer shipContainer = new ShipContainer();

		CustomShipLoader customShipLoader
							= new CustomShipLoader("test/ship/2_four_lenght_ships.txt", shipContainer, 8);
		
		for ( Ship ship : shipContainer )
		{
//			System.out.println("new Ship: ");
			for ( Cell cell : ship )
			{
//				System.out.println(" new Cell: ");
				checkCellsInShip(cell, 8);
			}
		}
		
		assertEquals(true, true);
	}

	//	Helper function. Not Test case
	private void checkCellsInShip(Cell cell, final int tableSize)
	{
//		System.out.println( "  x: " + cell.getX() + " y: " + cell.getY());
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
