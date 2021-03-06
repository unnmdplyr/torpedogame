package ship;

import customship.CustomShip;
import table.Cell;

import junit.framework.TestCase;

public class ShipContainerTest extends TestCase {

	
	//  - - - - - - - -
	// |1			   |
	// |1			   |
	// |1			   |
	// |1			   |
	// |0			   |
	// |0			   |
	// |0			   |
	// |0			   |
	//  - - - - - - - -
	public void testIsPositionAlreadyCoveredInUpperLeftCornerAlongTheYAxis()
	{
		ShipContainer shipContainer = new ShipContainer();
		
		CustomShip ship = new CustomShip(shipContainer);
		
		for ( int y=0; y < 4; ++y ) {
			ship.addCoveredCell(new Cell(1, 0, y));
		}

		shipContainer.addShip(ship);

		for ( int y=0; y < 4; ++y ) {
			assertEquals(true, shipContainer.isPositionAlreadyCovered(0, y) );
		}
	}
	

	//  - - - - - - - -
	// |1 1 1 1		   |
	// |			   |
	// |			   |
	// |			   |
	// |			   |
	// |			   |
	// |			   |
	// |			   |
	//  - - - - - - - -
	public void testIsPositionAlreadyCoveredInUpperLeftCornerAlongTheXAxis()
	{
		ShipContainer shipContainer = new ShipContainer();
		
		CustomShip ship = new CustomShip(shipContainer);
		
		for ( int x=0; x < 4; ++x ) {
			ship.addCoveredCell(new Cell(1, x, 0));
		}

		shipContainer.addShip(ship);

		for ( int x=0; x < 4; ++x ) {
			assertEquals(true, shipContainer.isPositionAlreadyCovered(x,0) );
		}
	}
	
	//  - - - - - - - -
	// |		1 1 1 1|
	// |			   |
	// |			   |
	// |			   |
	// |			   |
	// |			   |
	// |			   |
	// |			   |
	//  - - - - - - - -
	public void testIsPositionAlreadyCoveredInUpperRightCornerAlongTheXAxis()
	{
		ShipContainer shipContainer = new ShipContainer();
		
		CustomShip ship = new CustomShip(shipContainer);
		
		for ( int x=4; x < 8; ++x ) {
			ship.addCoveredCell(new Cell(1, x, 0));
		}

		shipContainer.addShip(ship);

		for ( int x=4; x < 8; ++x ) {
			assertEquals(true, shipContainer.isPositionAlreadyCovered(x,0) );
		}
	}

	
	//  - - - - - - - -
	// |			  1|
	// |			  1|
	// |			  1|
	// |			  1|
	// |			   |
	// |			   |
	// |			   |
	// |			   |
	//  - - - - - - - -
	public void testIsPositionAlreadyCoveredInUpperRightCornerAlongTheYAxis()
	{
		ShipContainer shipContainer = new ShipContainer();
		
		CustomShip ship = new CustomShip(shipContainer);
		
		for ( int y=0; y < 4; ++y ) {
			ship.addCoveredCell(new Cell(1, 7, y));
		}

		shipContainer.addShip(ship);

		for ( int y=0; y < 4; ++y ) {
			assertEquals(true, shipContainer.isPositionAlreadyCovered(7, y) );
		}
	}


	//  - - - - - - - -
	// |			   |
	// |			   |
	// |			   |
	// |			   |
	// |			   |
	// |			   |
	// |			   |
	// |1 1 1 1		   |
	//  - - - - - - - -
	public void testIsPositionAlreadyCoveredInLowerLeftCornerAlongTheXAxis()
	{
		ShipContainer shipContainer = new ShipContainer();
		
		CustomShip ship = new CustomShip(shipContainer);
		
		for ( int x=0; x < 4; ++x ) {
			ship.addCoveredCell(new Cell(1, x, 7));
		}

		shipContainer.addShip(ship);

		for ( int x=0; x < 4; ++x ) {
			assertEquals(true, shipContainer.isPositionAlreadyCovered(x,7) );
		}
	}
	
	//  - - - - - - - -
	// |			   |
	// |			   |
	// |			   |
	// |			   |
	// |1			   |
	// |1			   |
	// |1			   |
	// |1			   |
	//  - - - - - - - -
	public void testIsPositionAlreadyCoveredInLowerLeftCornerAlongTheYAxis()
	{
		ShipContainer shipContainer = new ShipContainer();
		
		CustomShip ship = new CustomShip(shipContainer);
		
		for ( int y=4; y < 8; ++y ) {
			ship.addCoveredCell(new Cell(1, 0, y));
		}

		shipContainer.addShip(ship);

		for ( int y=4; y < 8; ++y ) {
			assertEquals(true, shipContainer.isPositionAlreadyCovered(0, y) );
		}
	}
	
	
	//  - - - - - - - -
	// |			   |
	// |			   |
	// |			   |
	// |			   |
	// |			   |
	// |			   |
	// |			   |
	// |		1 1 1 1|
	//  - - - - - - - -
	public void testIsPositionAlreadyCoveredInLowerRightCornerAlongTheXAxis()
	{
		ShipContainer shipContainer = new ShipContainer();
		
		CustomShip ship = new CustomShip(shipContainer);
		
		for ( int x=4; x < 8; ++x ) {
			ship.addCoveredCell(new Cell(1, x, 7));
		}

		shipContainer.addShip(ship);

		for ( int x=4; x < 8; ++x ) {
			assertEquals(true, shipContainer.isPositionAlreadyCovered(x,7) );
		}
	}

	
	//  - - - - - - - -
	// |			   |
	// |			   |
	// |			   |
	// |			   |
	// |			  1|
	// |			  1|
	// |			  1|
	// |			  1|
	//  - - - - - - - -
	public void testIsPositionAlreadyCoveredInLowerRightCornerAlongTheYAxis()
	{
		ShipContainer shipContainer = new ShipContainer();
		
		CustomShip ship = new CustomShip(shipContainer);
		
		for ( int y=4; y < 8; ++y ) {
			ship.addCoveredCell(new Cell(1, 7, y));
		}

		shipContainer.addShip(ship);

		for ( int y=4; y < 8; ++y ) {
			assertEquals(true, shipContainer.isPositionAlreadyCovered(7, y) );
		}
	}


//	public void testGiveShotToShipAtPosition()
//	{
//		//	missing
//	}
//	
//	public void testAreAnyNotSunkShip()
//	{
//		//	missing
//	}
	
	
}
