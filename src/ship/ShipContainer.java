package ship;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import table.Point;
import customship.CustomShipLoader;

public class ShipContainer implements Iterable<Ship> {

	private List<Ship> ships = new ArrayList<Ship>();
	

	
	public void loadShips(final int tableSize) {
		new CustomShipLoader("ships.txt", this, tableSize);
	}

	public void addShip(Ship ship) {
		ships.add(ship);
	}
	
	public boolean doesShipCollideWithOthers(Ship ship, Point offset )
	{
		Point extent = ship.determineExtent();

		for (int y = offset.getY(); y < offset.getY() + extent.getY(); ++y)
		for (int x = offset.getX(); x < offset.getX() + extent.getX(); ++x)
			if ( isPositionAlreadyCovered(x, y) )
				return true;

		return false;
	}

	public boolean isPositionAlreadyCovered(int posX, int posY)
	{	
		for ( Ship ship : ships )
		{
			if ( ship.doesShipCoverThePosition(posX, posY) )
				return true;
		}
		return false;
	}



	//	Test purpose only	
	public class ShipContainerIterator implements Iterator<Ship>
	{
		private int currentShip;

		@Override
		public boolean hasNext() {
			return currentShip < ships.size();
		}

		@Override
		public Ship next() {
			return ships.get(currentShip++);
		}

		@Override
		public void remove() {
		}
		
	}

	//	Test purpose only
	@Override
	public Iterator<Ship> iterator() {
		return new ShipContainerIterator();
	}
}
