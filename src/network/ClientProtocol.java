package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import table.Table;


public class ClientProtocol implements Participant
{
	private int portNumber;
	private String hostName;
	private String userName;
	
	public ClientProtocol(final int portNumber, final String hostName, final String userName) {
		this.portNumber = portNumber;
		this.hostName = hostName;
		this.userName = userName;
	}

	public static final String INIT_MSG = "The 1st message from the server must be INIT .";
	public static final String NAME_MSG = "The 2nd message from the server must be NAME .";
	public static final String SHIPS_MSG = "The 3rd message from the server must be SHIPS .";
	public static final String READY_MSG = "The 5th message from the server must be READY .";

	
	public void establishCommunication()
	{
		try (	Socket clientSocket = new Socket(hostName, portNumber);

				PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader( clientSocket.getInputStream() ));
			)
		{
			//	Size
			String inputLine = in.readLine();
			int index = inputLine.indexOf(INIT_PREFIX);

			if ( index < 0 )
				throw new IllegalArgumentException( INIT_MSG );

			int size = Integer.parseInt( inputLine.substring(index + INIT_PREFIX.length()) );

			System.out.println("\nTable size came from the server: " + size );

//			Table table = new Table(size);


			//	Name
			inputLine = in.readLine();
			index = inputLine.indexOf(NAME_PREFIX);

			if ( index < 0 )
				throw new IllegalArgumentException( NAME_MSG );

			String serverUserName = inputLine.substring(index + NAME_PREFIX.length());

			System.out.println("\nName of the player at the server side: " + serverUserName );


			//	Name (sending)
			out.println( NAME_PREFIX.concat( userName ) );
//			out.flush();
//
//			
//			//	Ships
//			StringBuilder sb = new StringBuilder();
//			while ( in.ready() )
//			{
//				inputLine = in.readLine();
//				if ( inputLine != null )
//					sb.append(inputLine).append("\n");
//				else
//					break;
//			}
//
//
//			index = sb.toString().indexOf(SHIPS_PREFIX);
//			
//			if ( index < 0 )
//				throw new IllegalArgumentException( SHIPS_MSG );
//			
//			String arrivedShipData = sb.toString().substring( index + SHIPS_PREFIX.length() );
//
//			table.loadShipData(arrivedShipData);
//			
//			System.out.println("\nShip content:\n" + arrivedShipData);
//
//
//			//	Ready	(sending)
//			out.println( READY_PREFIX );
//			
//			System.out.println("\nReady sent.");
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

			
			
			
			
			
			
//			BufferedReader stdIn = new BufferedReader(new InputStreamReader( System.in));
//			String fromServer;
//			String fromUser;
//
//			while ((fromServer = in.readLine()) != null) {
//				System.out.println("Server: " + fromServer);
//				if (fromServer.equals("Bye."))
//					break;
//
//				fromUser = stdIn.readLine();
//				if (fromUser != null) {
//					System.out.println("Client: " + fromUser);
//					out.println(fromUser);
//				}
//			}
		} catch (UnknownHostException e) {
			System.err.println("Don't know about host " + hostName);
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for the connection to "
					+ hostName);
			System.exit(1);
		}
	}
}
