package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import table.Table;


public class ServerProtocol implements Participant {
	
	final private int portNumber;
	final private int size;
	final private String name;

	public ServerProtocol(final int portNumber, final int size, final String name) {
		this.portNumber = portNumber;
		this.size		= size;
		this.name		= name;
	}
	
	public static final String NAME_MSG = "The 2nd message from the client must be NAME .";
	public static final String READY_MSG = "The 4th message from the client must be READY .";

	public void establishCommunication()
	{
		try (	ServerSocket serverSocket = new ServerSocket(portNumber);
				Socket clientSocket = serverSocket.accept();
				
				PrintWriter out = new PrintWriter( clientSocket.getOutputStream(), true );
				BufferedReader in = new BufferedReader(new InputStreamReader( clientSocket.getInputStream() ));
			)
		{
			System.out.println( "Client joined to the server." );
			out.println( INIT_PREFIX.concat(Integer.toString(size)) );
			out.println( NAME_PREFIX.concat( name ) );

			
			//	Name (income)
			StringBuilder stringBuilder = new StringBuilder();

			String line;
			while ( (line = in.readLine()) != null )
			{
				
//				if ( line == null )
//					break;
				stringBuilder.append( line ).append("\n");
			}
			String inputLine = stringBuilder.toString();
			System.out.println("read name: " + inputLine);
			
			int index = inputLine.indexOf(NAME_PREFIX);

			if ( index < 0 )
				throw new IllegalArgumentException( NAME_MSG );

			final String clientName = inputLine.substring(index + NAME_PREFIX.length());

			System.out.println("\nName of the player at the client side: " + clientName );
			
			
//			Table table = new Table(size);
//			table.loadShipData();
//			String shipData = table.getShipData();
//
//			out.println( SHIPS_PREFIX.concat(shipData) );
//			System.out.println("\nShipData sent.");
//
//			
//			//	Ready	(income)
//			inputLine = in.readLine();
//			
//			index = inputLine.indexOf(READY_PREFIX);
//
//			if ( index < 0 )
//				throw new IllegalArgumentException( READY_MSG );
//			
//			System.out.println("\nReady message arrived.");
//
//			
//			//	Ready	(sending)
//			out.println( READY_PREFIX );
//			
//			System.out.println("\nReady message sent.");


			
			
//			String inputLine, outputLine;
//
//			//	Initiate conversation with client
//			KnockKnockProtocol kkp = new KnockKnockProtocol();
//			outputLine = kkp.processInput(null);
//			out.println(outputLine);
//
//			while ((inputLine = in.readLine()) != null) {
//				outputLine = kkp.processInput(inputLine);
//				out.println(outputLine);
//				if (outputLine.equals("Bye."))
//					break;
//			}
		} catch (IOException e) {
			System.out
					.println("Exception caught when trying to listen on port "
							+ portNumber + " or listening for a connection");
			System.out.println(e.getMessage());
		}
	}
}
