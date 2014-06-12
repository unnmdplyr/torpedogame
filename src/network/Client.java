package network;

import game.ClientInitData;
import game.InitData;

import java.io.IOException;
import java.net.Socket;

import message.MessageParser;
import table.Point;

public class Client extends TcpConnection
{
	public Client(Receiver reader, Sender writer) {
		super(reader, writer);
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
		Point tableDimensions = new MessageParser().parseInit(message);
	
		
	}
}
