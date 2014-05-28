package table;

import java.util.ArrayList;
import java.util.List;

import customship.CustomShipLoader;
import ship.ShipContainer;


public class Table {

	private final int TABLE_WIDTH = 8;
	private int size;
	private ShipContainer shipContainer;
	private List<Cell> missedCells;
	private static final String shipsFile = "D:/Users/varallyay.viktor/Projects/torpedogame/ships.txt";
	private String shipData;

	
	public int getSize() {
		return size;
	}
	//	This is only allowed to call at the client side. After the empty constructor.
	public void setSize(int size) {
		this.size = size;
	}

	
	//	
	public Table() {
		size = TABLE_WIDTH;
		init();
	}
	
	

	public Table(int size) {
		if ( size < 1  ||  size > 8 )
			throw new IllegalArgumentException("Size is " + size
					+ ". However it should be between 1 and 8 inclusive.");
		this.size = size;
		init();
	}

	private void init() {
		this.shipContainer = new ShipContainer();
		missedCells = new ArrayList<>();
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
	
	//	@return	With the shipId or -1 if there is no any ship at the position or -2
	//			if the cell was already shoot and missed.
	public int giveShotToShipAtPosition(final int posX, final int posY)
	{
		checkPositions(posX, posY);
		
		int shipId = shipContainer.giveShotToShipAtPosition(posX, posY);

		if ( shipId < 0 )
		{
			if ( wasMissedAtPosition(posX, posY) )
				return -2;
			else
				missedCells.add(new Cell(0, posX, posY));
		}

		return shipId;
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
	
	private boolean wasMissedAtPosition( final int x, final int y )
	{
		for ( Cell missedCell : missedCells )
			if ( missedCell.isPositionCovered(x, y) )
				return true;
		return false;
	}
	
	private int shipStateAtPosition( final int x, final int y )
	{
		return shipContainer.isShipAtPosition(x, y);
	}

	public void printTable()
	{
		for (int y = 0; y < size; y++) {
		for (int x = 0; x < size; x++)
		{
			boolean alreadyPrintChar = false;
			if ( wasMissedAtPosition(x, y) ) {
				System.out.print( " M" );
				alreadyPrintChar = true;
			}

			if ( !alreadyPrintChar )
			{
				int shipState = shipStateAtPosition(x,y);
				if ( shipState > -1 )
				{
					if ( shipState == 1 ) {  
						System.out.print( " O" );
						alreadyPrintChar = true;
					}
					else if ( shipState == 2 ) {
						System.out.print( " X" );
						alreadyPrintChar = true;
					}
				}
			}

			if ( !alreadyPrintChar )
				System.out.print( " ~");

			if ( x == size - 1 )
				System.out.println( "" );
		}
		if ( y == size - 1 )
			System.out.println( "\n" );
		}
	}
	

	
	public void loadShipData()
	{
		CustomShipLoader shipLoader = new CustomShipLoader(shipContainer, size);
		
		shipData = shipLoader.readFileContent(shipsFile);
		
		shipLoader.loadShipsFromStream(new java.io.StringReader(shipData));
	}
	
	//	@prerequisite	Call the loadShipData() function before you call this function.
	public String getShipData() {
		return shipData;
	}
	
	public void loadShipData(String arrivedShipData)
	{
		CustomShipLoader shipLoader = new CustomShipLoader(shipContainer, size);
		
		shipLoader.loadShipsFromStream(new java.io.StringReader(arrivedShipData));
	}
}
