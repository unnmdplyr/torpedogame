package table;

import java.util.Random;

public class PositionGenerator {

	final Random rand = new Random();

	public Point genereateNewPosition(Point extent)
	{
		final int posX = rand.nextInt(tableSize.getX() - extent.getX() + 1);
		final int posY = rand.nextInt(tableSize.getY() - extent.getY() + 1);

		return new Point( posX, posY );
	}
	
	final Point tableSize;

	public PositionGenerator(final Point tableSize) {
		this.tableSize = tableSize;
	}
	
	
}
