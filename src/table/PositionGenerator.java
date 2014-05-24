package table;

import java.util.Random;

public class PositionGenerator {

	final Random rand = new Random();

	public Point genereateNewPosition(Point extent)
	{
		final int posX = rand.nextInt(tableSize - extent.getX() + 1);
		final int posY = rand.nextInt(tableSize - extent.getY() + 1);

		return new Point( posX, posY );
	}
	
	final int tableSize;

	public PositionGenerator(final int tableSize) {
		this.tableSize = tableSize;
	}
	
	
}
