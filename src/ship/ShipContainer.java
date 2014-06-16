package ship;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import table.Point;
import customship.CustomShipLoader;

public class ShipContainer implements Iterable<Ship> {

	private List<Ship> ships = new ArrayList<Ship>();
	

	
	public void loadShips(final Point tableSize)
	{
		CustomShipLoader shipLoader = new CustomShipLoader(this, tableSize);
		
		try ( FileReader fil = new FileReader("D:/Users/varallyay.viktor/Projects/torpedogame/ships.txt"); )
		{
			shipLoader.loadShipsFromStream(fil );
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void addShip(Ship ship) {
		ship.setShipId(ships.size());
		ships.add(ship);
	}

	//	@return	With -1 if not covered by any ships. Otherwise with the id of the ship.
	public int isShipAtPosition(final int posX, final int posY)
	{	
		for ( Ship ship : ships )
		{
			int shipState = ship.shipStateAtPosition(posX, posY);
			if ( shipState > -1 )
				return shipState;
		}
		return -1;
	}


	public boolean isPositionAlreadyCovered(final int posX, final int posY)
	{	
		for ( Ship ship : ships )
		{
			if ( ship.doesShipCoverThePosition(posX, posY) )
				return true;
		}
		return false;
	}

	//	@return	With -1 if not covered by any ships. Otherwise with the id of the ship.
//	public int positionCoveredBy(final int posX, final int posY)
//	{	
//		for ( Ship ship : ships )
//		{
//			if ( ship.doesShipCoverThePosition(posX, posY) )
//				return ship.getShipId();
//		}
//		return -1;
//	}

	//	@return	With -1 if not covered by any ships. Otherwise with the id of the ship.
//	public int giveShotToShipAtPosition(final int posX, final int posY)
//	{	
//		for ( Ship ship : ships )
//		{
//			if ( ship.doesShipCoverThePosition(posX, posY) )
//			{
//				if ( ship.getShot(posX, posY) == false )
//					System.out.println("This shot shold be hit.");
//				return ship.getShipId();
//			}
//		}
//		return -1;
//	}
	
	public boolean areAnyNotSunkShip()
	{
		for ( Ship ship : ships )
			if ( !ship.isAlreadySunk() )
				return true;

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
