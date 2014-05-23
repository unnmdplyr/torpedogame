package table;

import java.util.Random;

public class PositionGenerator {

	final Random rand = new Random();

	public Point genereateNewPosition()
	{
		final int posX = rand.nextInt(tableSize-1);
		final int posY = rand.nextInt(tableSize-1);

		return new Point( posX, posY );
	}
	
	final int tableSize;

	public PositionGenerator(final int tableSize) {
		this.tableSize = tableSize;
	}
	
	
}
