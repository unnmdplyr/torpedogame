package game;


import table.Table;

public class Game {

	public static void main(String[] args) {
		
		Table table = new Table(8);

		for ( int y=0; y < 8; ++y )
		{			
			for ( int x=0; x < 8; ++x )
			{
				int shipId = table.shotHitBy(x, y);
				
				System.out.print( ( shipId > -1 ? convertShipIdToChar(shipId) : '~') + " ");
			}
				

			System.out.print( "\n" );
		}
		
	}
	
	
	private static char convertShipIdToChar(int shipId)
	{
		if ( shipId < 10 )
			return (char)(48 + shipId);
		else
			return (char)(55 + shipId);
	}
}
