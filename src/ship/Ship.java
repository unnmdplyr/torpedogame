package ship;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import table.Cell;
import table.Point;
import table.PositionGenerator;

public abstract class Ship implements Iterable<Cell> {

	//public enum ShipType { ONE, TWO, THREE, FOUR, TETRIS };

	protected List<Cell> coveredCells = new ArrayList<Cell>();
	
	protected ShipContainer shipContainer;
	

	public Ship(ShipContainer shipContainer) {
		this.shipContainer = shipContainer;
	}



	public boolean isPositionAlreadyCovered( final int posX, final int posY )
	{
		for ( final Cell cell : coveredCells )
		{
			if ( cell.isPositionCovered(posX, posY) )
				return true;
		}
		return false;
	}
	
	public Point getAlreadyNotYetCoveredPosition(final int tableSize)
	{
		final PositionGenerator posGenerator = new PositionGenerator(tableSize);
		Point point = null;

		boolean covered = true;

		while ( covered )
		{
			point = posGenerator.genereateNewPosition();
	
			if ( !shipContainer.isPositionAlreadyCovered(point.getX(), point.getY()) )
				covered = false;
		}

		return point;
	}
	
	public Point determineFreePlaceForShip(final int tableSize)
	{
		boolean placeIsNotGood = true;
		Point pt = null;
//		int i = 0;

		while (placeIsNotGood)
		{
//			if ( i > 0 )
//				System.out.println("Greater than 0. x: " + pt.getX() + " y: " + pt.getY());
			pt = getAlreadyNotYetCoveredPosition(tableSize);
			
			placeIsNotGood = !isShipStaysAtTable(tableSize, pt);
//			++i;
		}
		
		return pt;
	}

	public boolean isShipStaysAtTable(int tableSize, final Point pt)
	{
		if ( pt.getX() + getXExtent() >= tableSize )
			return false;
		
		if ( pt.getY() + getYExtent() >= tableSize )
			return false;
//		
//		for ( int i=pt.getX(); i < pt.getX() + getXExtent(); ++i )
//			for ( int j=pt.getY(); j < pt.getY() + getYExtent(); ++j )
//				if ( shipContainer.isPositionAlreadyCovered(i, j) )	
//					return false;
//		
		return true;
	}
	
	public abstract int getXExtent();
	public abstract int getYExtent();
	
	
	
	//	Test purpose only
	public class ShipIterator implements Iterator<Cell>
	{
		private int cellNum;

		@Override
		public boolean hasNext() {
			return coveredCells.size() > cellNum;
		}

		@Override
		public Cell next() {
			return coveredCells.get(cellNum++);
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException("Cannot remove cells from a ship!");
		}
	}

	//	Test purpose only
	@Override
	public Iterator<Cell> iterator() {
		return new ShipIterator();
	}
}
