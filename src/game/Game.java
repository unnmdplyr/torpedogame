package game;


import table.Table;

public class Game {

	public static void main(String[] args) {
		
		Table table = new Table(8);

		for ( int y=0; y < 8; ++y )
		{			
			for ( int x=0; x < 8; ++x )
				System.out.print( (table.isShotHit(x, y) ? 'X' : '~') + " ");

			System.out.print( "\n" );
		}
		
	}
}
