package network;

import game.InitData;

import java.io.IOException;
import java.net.ServerSocket;

import message.MessageAssembler;


public class Server extends TcpConnection
{
	public Server(Receiver reader, Sender writer) {
		super(reader, writer);
	}

	private ServerSocket serverSocket;

	public ServerSocket getServerSocket() {
		return serverSocket;
	}

	public void setServerSocket(ServerSocket serverSocket) {
		this.serverSocket = serverSocket;
	}

	@Override
	protected void networkRoleSpecificInit(InitData initData) throws IOException
	{
		setServerSocket( new ServerSocket(initData.portNumber) );
		setClientSocket( getServerSocket().accept() );
		System.out.println( "Client joined to the server." );
	}

	@Override
	protected void networkRoleSpecificNegotiation() throws IOException
	{
		getSender().sendMessage( new MessageAssembler().createInit(8,8) );
	}
	
	@Override
	public void finalize()
	{
		super.finalize();
		
		if ( !getServerSocket().isClosed() )
			try {
				getServerSocket().close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
}
