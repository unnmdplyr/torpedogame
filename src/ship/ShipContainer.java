package ship;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import customship.CustomShipLoader;

public class ShipContainer implements Iterable<Ship> {

	private List<Ship> ships = new ArrayList<Ship>();
	
//	public void generateShips( int tableSize )
//	{	
//		//final int[] shipTypes = {4, 3, 2, 2, 2};
//		final int[] shipTypes = {0, 3, 2, 2, 0 };
//
//		for ( int shipType=0; shipType < shipTypes.length; ++shipType )
//		{
//			switch ( shipType )
//			{
//			case 0:	//	OneLengthShip
//				for ( int i=0; i < shipTypes[shipType]; ++i )
//				{
//					Ship ship = new OneLengthShip(this);
//					ship.generateShip( tableSize );
//					
//					addShip(ship);
//				}
//				break;
//			case 1:	//	TwoLengthShip
//				for ( int i=0; i < shipTypes[shipType]; ++i )
//				{
//					Ship ship = new TwoLengthShip(this);
//					ship.generateShip( tableSize );
//					
//					addShip(ship);
//				}
//				break;
//			case 2:
//				for ( int i=0; i < shipTypes[shipType]; ++i )
//				{
//					Ship ship = new ThreeLengthShip(this);
//					ship.generateShip( tableSize );
//					
//					addShip(ship);
//				}
//				break;
//			case 3:
//				for ( int i=0; i < shipTypes[shipType]; ++i )
//				{
//					Ship ship = new FourLengthShip(this);
//					ship.generateShip( tableSize );
//					
//					addShip(ship);
//				}
//				break;
//			case 4:
//				for ( int i=0; i < shipTypes[shipType]; ++i )
//				{
//					Ship ship = new TetrisShip(this);
//					ship.generateShip( tableSize );
//					
//					addShip(ship);
//				}
//				break;
//			default: throw new IllegalArgumentException("");
//			}
//		}
//	}
	
	public void loadShips(final int tableSize) {
		new CustomShipLoader("ships.txt", this, tableSize);
	}

	public void addShip(Ship ship) {
		ships.add(ship);
	}
	
	public boolean isPositionAlreadyCovered(int posX, int posY)
	{	
		for ( Ship ship : ships )
		{
			if ( ship.isPositionAlreadyCovered(posX, posY) )
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


//final int numberOfOne	= 4;
//final int numberOfTwo	= 3;
//final int numberOfThree	= 2;
//final int numberOfFour	= 2;
//final int numberOfTetris= 2;