package game;


import table.Point;
import table.PositionGenerator;
import table.Table;

public class Game {

	public static void main(String[] args) {
		
		Table table = new Table(8);
		
		PositionGenerator positionGenerator = new PositionGenerator(8);
		int round = 0;

		while ( table.areAnyNotSunkShip() )
		{
			Point pt = positionGenerator.genereateNewPosition(new Point(1,1));

			int shipId = table.giveShotToShipAtPosition(pt.getX(), pt.getY());
			
			System.out.print( ( shipId > -1 ? convertShipIdToChar(shipId) : '~') + " ");

			System.out.print( "\n" );

			++round;
		}

		System.out.println("ready. It took " + round + " rounds.");
	}
	
	
	private static char convertShipIdToChar(int shipId)
	{
		final int THE_ID_OF_THE_ZERO_SIGN_IN_THE_ACSII_TABLE = 48;
		final int THE_ID_OF_THE_LETTER_A_IN_THE_ACSII_TABLE = 65;

		if ( shipId < 10 )
			return (char)(THE_ID_OF_THE_ZERO_SIGN_IN_THE_ACSII_TABLE + shipId);
		else
			return (char)(THE_ID_OF_THE_LETTER_A_IN_THE_ACSII_TABLE - 10 + shipId);
	}
}
