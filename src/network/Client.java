package network;

import game.ClientInitData;
import game.InitData;

import java.io.IOException;
import java.net.Socket;

import message.MessageObjectifier;
import message.MessageParser;
import message.MessageTypes;
import table.Point;
import table.Reactor;

public class Client extends TcpConnection
{
	private Reactor reactor;

	public Client(Receiver reader, Sender writer, Reactor reactor) {
		super(reader, writer);
		this.reactor = reactor;
	}

	@Override
	protected void networkRoleSpecificInit(InitData initD) throws IOException
	{
		ClientInitData initData = (ClientInitData)initD;

		if ( initData.hostName == null  ||  initData.hostName.isEmpty() )
			throw new IllegalArgumentException("The given hostname is invalid. " + initData.hostName );

		setClientSocket( new Socket(initData.hostName, initData.portNumber) );		
	}

	@Override
	protected void networkRoleSpecificNegotiation() throws IOException {
		
		//	Init
		String message = getReceiver().receiveMessage();
		reactor.reactToMessage(message, MessageTypes.INIT_PREFIX);
		
	
		
	}
}
