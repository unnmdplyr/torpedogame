package ship;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import customship.CustomShipLoader;

public class ShipContainer implements Iterable<Ship> {

	private List<Ship> ships = new ArrayList<Ship>();
	

	
	public void loadShips(final int tableSize) {
		new CustomShipLoader("ships.txt", this, tableSize);
	}

	public void addShip(Ship ship) {
		ship.setShipId(ships.size());
		ships.add(ship);
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

	//	@return	With -1 if not covered by any ships. Otherwise with the id of the ship.
	public int positionCoveredBy(int posX, int posY)
	{	
		for ( Ship ship : ships )
		{
			if ( ship.doesShipCoverThePosition(posX, posY) )
				return ship.getShipId();
		}
		return -1;
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
