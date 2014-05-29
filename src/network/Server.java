package network;

import java.io.IOException;
import java.net.ServerSocket;

import message.MessageAssembler;


public class Server extends TcpConnection
{
	private ServerSocket serverSocket;

	public ServerSocket getServerSocket() {
		return serverSocket;
	}

	public void setServerSocket(ServerSocket serverSocket) {
		this.serverSocket = serverSocket;
	}

	@Override
	protected void networkRoleSpecificInit() throws IOException
	{
		setServerSocket( new ServerSocket(getPortNumber()) );
		setClientSocket( getServerSocket().accept() );
		System.out.println( "Client joined to the server." );
	}

	@Override
	protected void networkRoleSpecificNegotiation() {
		
		getPrinter().println( new MessageAssembler().createInit(8,8) );
	}
}
