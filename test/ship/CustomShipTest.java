package ship;

import table.Cell;
import customship.CustomShipLoader;
import junit.framework.TestCase;


public class CustomShipTest extends TestCase {

	public void testCustomShips()
	{
		ShipContainer shipContainer = new ShipContainer();

		CustomShipLoader customShipLoader
							= new CustomShipLoader("test\\ship\\2_four_lenght_ships.txt", shipContainer, 8);
		
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
	
}
