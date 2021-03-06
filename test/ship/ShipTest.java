package ship;

import table.Cell;
import table.Point;
import customship.CustomShip;
import junit.framework.TestCase;

public class ShipTest extends TestCase {


	//	Where to place.		What to place.
	//  - - - - - - - -    - - - - - - - - 
	// |			   |  |1 1 1 1	   	  |
	// |			   |  |			   	  |
	// |			   |  |			   	  |
	// |			   |  |			   	  |
	// |			  1|  |			   	  |
	// |			  1|  |			   	  |
	// |			  1|  |			   	  |
	// |			  1|  |			   	  |
	//  - - - - - - - -    - - - - - - - - 
//	public void testGetAlreadyNotYetCoveredPosition()
//	{
//		ShipContainer shipContainer = new ShipContainer();
//		CustomShip ship = new CustomShip(shipContainer);
//		
//		for ( int y=4; y < 8; ++y ) {
//			ship.addCoveredCell(new Cell(1, 7, y));
//		}
//
//		shipContainer.addShip(ship);
//
//		CustomShip shipToPlace = new CustomShip(shipContainer);
//		
//		for ( int x=0; x < 4; ++x ) {
//			shipToPlace.addCoveredCell(new Cell(1, x, 0));
//		}
//	
//		
//		for ( int i=0; i < 1000; ++i ) {
//			Point pt = shipToPlace.getAlreadyNotYetCoveredPosition(8);
//
//			assertEquals(true,
//					(pt.getX() > -1  &&  pt.getX() < 8  &&  pt.getY() < 4)
//					||
//					(pt.getX() > -1  &&  pt.getX() < 7  &&  pt.getY() > 3) );
//		}
//	}

	//	Where to place.		What to place.
	//  - - - - - - - -    - - - - - - - - 
	// |			   |  |1 1 1 1	   	  |
	// |			   |  |			   	  |
	// |			   |  |			   	  |
	// |			   |  |			   	  |
	// |			   |  |			   	  |
	// |			   |  |			   	  |
	// |			   |  |			   	  |
	// |		1 1 1 1|  |			   	  |
	//  - - - - - - - -    - - - - - - - - 
//	public void testGetAlreadyNotYetCoveredPositionShipIsAlreadyOnTableAlongXAxis()
//	{
//		ShipContainer shipContainer = new ShipContainer();
//		CustomShip ship = new CustomShip(shipContainer);
//		
//		for ( int x=4; x < 8; ++x ) {
//			ship.addCoveredCell(new Cell(1, x, 7));
//		}
//
//		shipContainer.addShip(ship);
//
//		CustomShip shipToPlace = new CustomShip(shipContainer);
//		
//		for ( int x=0; x < 4; ++x ) {
//			shipToPlace.addCoveredCell(new Cell(1, x, 0));
//		}
//	
//		
//		for ( int i=0; i < 1000; ++i ) {
//			Point pt = shipToPlace.getAlreadyNotYetCoveredPosition(8);
//
//			assertEquals(true,
//					(pt.getX() > -1  &&  pt.getX() < 8  &&  pt.getY() < 7)
//					||
//					(pt.getX() > -1  &&  pt.getX() < 1  &&  pt.getY() > 6) );
//		}
//	}
	
	//	Place this ship around the table.
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
//	public void testIsShipStayAtTable()
//	{
//		ShipContainer shipContainer = new ShipContainer();
//		CustomShip ship = new CustomShip(shipContainer);
//		
//		for ( int x=0; x < 4; ++x ) {
//			ship.addCoveredCell(new Cell(1, x, 0));
//		}
//
//		for ( int y=0; y < 9 ; ++y )
//		for ( int x=0; x < 9 ; ++x )
//		{
//			System.out.println( "x: " + x + " y: " + y);
//			if ( x > 4  ||  y > 7 )
//				assertEquals( false, ship.isShipStaysAtTable(8, new Point(x,y)) );
//			else
//				assertEquals(  true, ship.isShipStaysAtTable(8, new Point(x,y)) );
//		}
//	}
	
	
	//	Where to place.		What to place.
	//  - - - - - - - -    - - - - - - - - 
	// |			   |  |1 1 1 1	   	  |
	// |			   |  |			   	  |
	// |			   |  |			   	  |
	// |			   |  |			   	  |
	// |			  1|  |			   	  |
	// |			  1|  |			   	  |
	// |			  1|  |			   	  |
	// |			  1|  |			   	  |
	//  - - - - - - - -    - - - - - - - - 
//	public void testDetermineFreePlaceForShip()
//	{
//		ShipContainer shipContainer = new ShipContainer();
//		CustomShip ship = new CustomShip(shipContainer);
//		
//		for ( int y=4; y < 8; ++y ) {
//			ship.addCoveredCell(new Cell(1, 7, y));
//		}
//
//		shipContainer.addShip(ship);
//
//		CustomShip shipToPlace = new CustomShip(shipContainer);
//		
//		for ( int x=0; x < 4; ++x ) {
//			shipToPlace.addCoveredCell(new Cell(1, x, 0));
//		}
//	
//		
//		for ( int i=0; i < 1000; ++i ) {
//			Point pt = shipToPlace.determineFreePlaceForShip(8);
//
//			System.out.println("x: " + pt.getX() + " y: " + pt.getY() );
//			assertEquals(true,
//					(pt.getX() > -1  &&  pt.getX() < 5  &&  pt.getY() < 4)
//					||
//					(pt.getX() > -1  &&  pt.getX() < 4  &&  pt.getY() > 3) );
//		}
//	}
	
	public void testDoesShipCoverThePosition4LengthShipUpperLeft()
	{
		ShipContainer shipContainer = new ShipContainer();
		CustomShip ship = new CustomShip(shipContainer);
		
		for ( int x=0; x < 4; ++x ) {
			ship.addCoveredCell(new Cell(1, x, 0));
		}

		for ( int y=0; y < 8; ++y ) 
		for ( int x=0; x < 8; ++x )
			if ( x < 4  &&  y < 1 )
				assertEquals( true, ship.doesShipCoverThePosition(x, y) );
			else
				assertEquals(false, ship.doesShipCoverThePosition(x, y) );
	}
	
	public void testDoesShipCoverThePosition4LengthShipLowerRight()
	{
		ShipContainer shipContainer = new ShipContainer();
		CustomShip ship = new CustomShip(shipContainer);
		
		for ( int x=4; x < 8; ++x ) {
			ship.addCoveredCell(new Cell(1, x, 7));
		}

		for ( int y=0; y < 8; ++y ) 
		for ( int x=0; x < 8; ++x )
			if ( x > 3  &&  y > 6 )
				assertEquals( true, ship.doesShipCoverThePosition(x, y) );
			else
				assertEquals(false, ship.doesShipCoverThePosition(x, y) );
	}
	
	public void testDoesShipCoverThePositionTetrisShipLowerRight()
	{
		ShipContainer shipContainer = new ShipContainer();
		CustomShip ship = new CustomShip(shipContainer);
		
		for ( int x=5; x < 8; ++x ) {
			ship.addCoveredCell(new Cell(1, x, 7));
		}
		ship.addCoveredCell(new Cell(1, 6, 6));

		for ( int y=0; y < 8; ++y ) 
		for ( int x=0; x < 8; ++x )
			assertEquals( (x > 4  &&  y > 6)  ||  (x == 6  &&  y == 6),
							ship.doesShipCoverThePosition(x, y) );
	}
	
	
	

	//	Ship is already on		Place this ship
	//	the table.				on the table without
	//							collision.
	//  - - - - - - - -           - - - - - - - - 
	// |1 1 1 1		   |         |1 1 1 1		 |
	// |			   |         |			     |
	// |			   |         |			     |
	// |			   |         |			     |
	// |			   |         |			     |
	// |			   |         |			     |
	// |			   |         |			     |
	// |			   |         |			     |
	//  - - - - - - - -           - - - - - - - - 
	public void testDoesShipCollideWithOthers()
	{
		ShipContainer shipContainer = new ShipContainer();		
		CustomShip ship = new CustomShip(shipContainer);
		
		for ( int x=0; x < 4; ++x ) {
			ship.addCoveredCell(new Cell(1, x, 0));
		}

		shipContainer.addShip(ship);
		
		CustomShip shipToPlace = new CustomShip(shipContainer);
		
		for ( int x=0; x < 4; ++x ) {
			shipToPlace.addCoveredCell(new Cell(1, x, 0));
		}
		
		for (int y=0; y < 8; ++y)
		for (int x=0; x < 8; ++x) {
			Point offset = new Point(x, y);
			assertEquals( (x < 4  &&  y < 1),
							shipToPlace.doesShipCollideWithOthers(offset) );
		}
	}
	
	
	//	Ship is already on		Place this ship
	//	the table.				on the table without
	//							collision.
	//  - - - - - - - -           - - - - - - - - 
	// |			   |         |1 1 1 1		 |
	// |			   |         |			     |
	// |			   |         |			     |
	// |			   |         |			     |
	// |			  1|         |			     |
	// |			  1|         |			     |
	// |			  1|         |			     |
	// |			  1|         |			     |
	//  - - - - - - - -           - - - - - - - - 
	public void testDoesShipCollideWithOthersAnotherLowerRightAlongYAxis()
	{
		ShipContainer shipContainer = new ShipContainer();		
		CustomShip ship = new CustomShip(shipContainer);
		
		for ( int y=4; y < 8; ++y ) {
			ship.addCoveredCell(new Cell(1, 7, y));
		}

		shipContainer.addShip(ship);
		
		CustomShip shipToPlace = new CustomShip(shipContainer);
		
		for ( int x=0; x < 4; ++x ) {
			shipToPlace.addCoveredCell(new Cell(1, x, 0));
		}
		
		for (int y=0; y < 8; ++y)
		for (int x=0; x < 8; ++x) {
			Point offset = new Point(x, y);
			assertEquals( (x > 3  &&  y > 3),
							shipToPlace.doesShipCollideWithOthers(offset) );
		}
	}
	
	
	//	Ship is already on		Place this ship
	//	the table.				on the table without
	//							collision.
	//  - - - - - - - -           - - - - - - - - 
	// |			   |         |1 1 1 1		 |
	// |			   |         |			     |
	// |			   |         |			     |
	// |			   |         |			     |
	// |			  1|         |			     |
	// |			  1|         |			     |
	// |			  1|         |			     |
	// |			  1|         |			     |
	//  - - - - - - - -           - - - - - - - - 
	public void testDeterminePlaceForTheShip()
	{
		ShipContainer shipContainer = new ShipContainer();		
		CustomShip ship = new CustomShip(shipContainer);
		
		for ( int y=4; y < 8; ++y ) {
			ship.addCoveredCell(new Cell(1, 7, y));
		}

		shipContainer.addShip(ship);
		
		CustomShip shipToPlace = new CustomShip(shipContainer);
		
		for ( int x=0; x < 4; ++x ) {
			shipToPlace.addCoveredCell(new Cell(1, x, 0));
		}

		for (int i=0; i < 1000; i++)
		{
			Point offset = shipToPlace.determinePlaceForTheShip(new Point(8,8));
			assertEquals( true, (offset.getX() < 4  &&  offset.getY() > 3)
							||  (offset.getX() < 5  &&  offset.getY() < 4) );
		}
	}

	
	public void testGetShot()
	{
		ShipContainer shipContainer = new ShipContainer();		
		CustomShip ship = new CustomShip(shipContainer);
		
		for ( int y=4; y < 8; ++y ) {
			ship.addCoveredCell(new Cell(1, 7, y));
		}

		shipContainer.addShip(ship);

		for ( int y=0; y < 8; ++y )
		for ( int x=0; x < 8; ++x )
			assertEquals( x == 7 && y > 3 , ship.getShot(x, y) );
	}
	
	
	public void testIsAlreadySunk()
	{
		ShipContainer shipContainer = new ShipContainer();		
		CustomShip ship = new CustomShip(shipContainer);
		
		for ( int y=4; y < 8; ++y ) {
			ship.addCoveredCell(new Cell(2, 7, y));
		}

		shipContainer.addShip(ship);
		
		assertEquals( true, ship.isAlreadySunk() );
	}
	
	public void testIsAlreadySunkItIsNotYet()
	{
		ShipContainer shipContainer = new ShipContainer();		
		CustomShip ship = new CustomShip(shipContainer);
		
		for ( int y=4; y < 8; ++y ) {
			ship.addCoveredCell(new Cell(1, 7, y));
		}

		shipContainer.addShip(ship);

		for ( int y=0; y < 8; ++y ) {
			assertEquals( y > 3, ship.getShot(7, y) );
			assertEquals( y == 7, ship.isAlreadySunk() );
		}
	}
	
	
	
	
	
	
	
}
