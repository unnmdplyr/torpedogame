package table;

import ship.ShipContainer;
import customship.CustomShip;
import junit.framework.TestCase;

public class PositionGeneratorTest extends TestCase {

	public void testPositionGenerator()
	{
		final int tableSize = 8;
		ShipContainer shipContainer = new ShipContainer();

		CustomShip ship = new CustomShip(shipContainer);
	
		for (int x = 4; x < tableSize; x++) {			
			ship.addCoveredCell(new Cell(1, x, 0));
		}
		
		Point extent = ship.determineExtent();
		
		PositionGenerator positionGenerator = new PositionGenerator(tableSize);
		
		for (int i = 0; i < 1000; i++) {
			Point offset = positionGenerator.genereateNewPosition(extent);
			
			assertEquals( true, offset.getX() > -1  &&  offset.getX() < 4
							&&  offset.getY() > -1  &&  offset.getY() < tableSize - 1 );
		}
		
	}
}
