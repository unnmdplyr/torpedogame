package network;

import game.InitData;
import game.ServerInitData;

import java.io.IOException;
import java.net.ServerSocket;

import table.Reactor;
import message.MessageAssembler;
import message.MessageType;


public class Server extends TcpConnection
{
	private Reactor reactor;
	private MessageAssembler messageAssembler;
	private ServerInitData initData;

	public Server(Receiver reader, Sender writer, Reactor reactor, MessageAssembler messageAssembler) {
		super(reader, writer);
		this.reactor = reactor;
		this.messageAssembler = messageAssembler;
	}

	private ServerSocket serverSocket;

	public ServerSocket getServerSocket() {
		return serverSocket;
	}

	public void setServerSocket(ServerSocket serverSocket) {
		this.serverSocket = serverSocket;
	}

	@Override
	protected void networkRoleSpecificInit(InitData initD) throws IOException
	{
		this.initData = (ServerInitData)initD;

		setServerSocket( new ServerSocket(initData.portNumber) );
		setClientSocket( getServerSocket().accept() );
		System.out.println( "Client joined to the server." );
	}

	@Override
	protected void networkRoleSpecificNegotiation() throws IOException
	{
		//	Init
		getSender().sendMessage( messageAssembler.createInit( initData.tableSize ) );
		
		//	Opponent Name
		String message = getReceiver().receiveMessage();
		reactor.reactToMessage(message, MessageType.NAME);
		
		//	Name
		getSender().sendMessage( messageAssembler.createName( initData.userName ) );

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
