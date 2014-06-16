package game;


import message.MessageParser;
import network.NetworkRole;
import network.TcpConnection;
import network.TcpConnectionFactory;


public class Game {

	public static void main(String[] args) {
		
		if ( args.length < 1 ) {
			usage();
			return;
		}


		if ( args[0].equalsIgnoreCase("server") )
		{
			ServerInitData initData = new ServerInitData();

			if ( args.length > 1 ) initData.userName = args[1];
			if ( args.length > 2 ) initData.tableSize = new MessageParser().parseTableSize(args[2]); 
			if ( args.length > 3 ) initData.portNumber = Integer.parseInt(args[3]);

			TcpConnection server = new TcpConnectionFactory().create(NetworkRole.SERVER);
			server.start(initData);
			server.negotiation();
//			ServerProtocol server = new ServerProtocol( portNumber, tableSize, userName );
//			server.establishCommunication();
			return;
		}
		else if ( args[0].equalsIgnoreCase("client") )
		{
			ClientInitData initData = new ClientInitData();
			
			if ( args.length > 1 ) initData.userName = args[1];
			if ( args.length > 2 ) initData.hostName = args[2];
			if ( args.length > 3 ) initData.portNumber = Integer.parseInt(args[3]);

			TcpConnection client = new TcpConnectionFactory().create(NetworkRole.CLIENT);
			client.start(initData);
			client.negotiation();
//			ClientProtocol client = new ClientProtocol(portNumber, hostName, userName);
//			client.establishCommunication();
			return;
		}
		else {
			usage();
			return;
		}
		
		
		
			
		
//		Table table = new Table(8);
//		
//		PositionGenerator positionGenerator = new PositionGenerator(8);
//		int round = 0;
//
//		while ( table.areAnyNotSunkShip() )
//		{
//			Point pt = positionGenerator.genereateNewPosition(new Point(1,1));
//
//			int shipId = table.giveShotToShipAtPosition(pt.getX(), pt.getY());
//			if ( shipId == -2 )
//				continue;
//
//			table.printTable();
////			System.out.print( ( shipId > -1 ? convertShipIdToChar(shipId) : '~') + " ");
//
//			System.out.print( "\n" );
//
//			++round;
//		}
//
//		System.out.println("ready. It took " + round + " rounds.");
	}
	

	private static void usage() {
		
		System.out.println("The argument must contain at least one argument. Server or client.\n");
		System.out.println("Parameters in case of server:");
		System.out.println("\t[0]: server. Case is ignored.");
		System.out.println("\t[1]: user name. [defaultPlayer]");
		System.out.println("\t[2]: port number. [1146]\n");
		System.out.println("Parameters in case of client:");
		System.out.println("\t[0]: client. Case is ignored.");
		System.out.println("\t[1]: user name. [defaultPlayer]");
		System.out.println("\t[2]: host name. [127.0.0.1]");
		System.out.println("\t[2]: port number. [1146]\n");
	}
//	private static char convertShipIdToChar(int shipId)
//	{
//		final int THE_ID_OF_THE_ZERO_SIGN_IN_THE_ACSII_TABLE = 48;
//		final int THE_ID_OF_THE_LETTER_A_IN_THE_ACSII_TABLE = 65;
//
//		if ( shipId < 10 )
//			return (char)(THE_ID_OF_THE_ZERO_SIGN_IN_THE_ACSII_TABLE + shipId);
//		else
//			return (char)(THE_ID_OF_THE_LETTER_A_IN_THE_ACSII_TABLE - 10 + shipId);
//	}
}
