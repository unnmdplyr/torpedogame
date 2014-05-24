package ship;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import table.Cell;
import table.Point;
import table.PositionGenerator;

public abstract class Ship implements Iterable<Cell>
{

	protected List<Cell> coveredCells = new ArrayList<Cell>();
	
	protected ShipContainer shipContainer;
	

	public Ship(ShipContainer shipContainer) {
		this.shipContainer = shipContainer;
	}

	
	public Point determinePlaceForTheShip(final int tableSize)
	{
		final PositionGenerator positionGenerator = new PositionGenerator(tableSize);
		final Point extent = determineExtent();
		Point offset = null;

		while ( true )
		{
			offset = positionGenerator.genereateNewPosition(extent);
			
			if ( !doesShipCollideWithOthers(offset) )
				return offset;
		}
	}
	
	public boolean doesShipCollideWithOthers( final Point offset )
	{
		final Point extent = determineExtent();

		for (int y = offset.getY(); y < offset.getY() + extent.getY(); ++y)
		for (int x = offset.getX(); x < offset.getX() + extent.getX(); ++x)
			if ( shipContainer.isPositionAlreadyCovered(x, y) )
				return true;

		return false;
	}

	public boolean doesShipCoverThePosition( final int posX, final int posY )
	{
		for ( final Cell cell : coveredCells )
		{
			if ( cell.isPositionCovered(posX, posY) )
				return true;
		}
		return false;
	}


	public abstract Point determineExtent();
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
