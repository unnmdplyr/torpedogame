package table;

import ship.ShipContainer;


public class Table {

	private final int TABLE_WIDTH = 8;
	private final int size;
	private ShipContainer shipContainer;

	
	public int getSize() {
		return size;
	}

	
	public Table() {
		size = TABLE_WIDTH;
		this.shipContainer = new ShipContainer();
		generateShips();
	}

	public Table(int size) {
		if ( size < 1  ||  size > 8 )
			throw new IllegalArgumentException("Size is " + size
					+ ". However it should be between 1 and 8 inclusive.");
		this.size = size;
		this.shipContainer = new ShipContainer();
		generateShips();
	}

	
	private void generateShips()
	{
		shipContainer.loadShips(size);
	}
	
	public boolean isShotHit(final int posX, final int posY)
	{
		checkPositions(posX, posY);

		return shipContainer.isPositionAlreadyCovered(posX, posY);
	}

	public int shotHitBy(final int posX, final int posY)
	{
		checkPositions(posX, posY);

		return shipContainer.positionCoveredBy(posX, posY);
	}
	
	public int giveShotToShipAtPosition(final int posX, final int posY)
	{
		checkPositions(posX, posY);
		
		return shipContainer.giveShotToShipAtPosition(posX, posY);
	}
	
	public boolean areAnyNotSunkShip()
	{
		return shipContainer.areAnyNotSunkShip();
	}
	
	private void checkPositions(final int posX, final int posY) {
		if ( posX < 0  ||  posX > size-1  ||  posY < 0  ||  posY > size-1 )
			throw new IllegalArgumentException("The widht and height: (" + posX
					+ "; " + posY + ")" );
	}

}
