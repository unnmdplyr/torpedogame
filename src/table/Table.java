package table;

import ship.ShipContainer;


public class Table {

	private final int TABLE_WIDTH = 8;
	private final int size;
	ShipContainer shipContainer;
//	private Cell[][] cells;
	
	public int getSize() {
		return size;
	}

	
	public Table() {
		size = TABLE_WIDTH;
		this.shipContainer = new ShipContainer();
		generateShips();
//		initCells();
	}

	public Table(int size) {
		if ( size < 1  ||  size > 8 )
			throw new IllegalArgumentException("Size is " + size
					+ ". However it should be between 1 and 8 inclusive.");
		this.size = size;
		this.shipContainer = new ShipContainer();
		generateShips();
//		initCells();
	}

	
	private void generateShips()
	{
//		shipContainer.generateShips(size);
		shipContainer.loadShips(size);
	}
	
	public boolean isShotHit(int posX, int posY)
	{
		if ( posX < 0  ||  posX > size-1  ||  posY < 0  ||  posY > size-1 )
			throw new IllegalArgumentException("The widht and height: (" + posX
					+ "; " + posY + ")" );

		return shipContainer.isPositionAlreadyCovered(posX, posY);
	}

	
}
