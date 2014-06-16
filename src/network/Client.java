package network;

import game.ClientInitData;
import game.InitData;

import java.io.IOException;
import java.net.Socket;

import message.MessageAssembler;
import message.MessageType;
import table.Reactor;

public class Client extends TcpConnection
{
	private Reactor reactor;
	private MessageAssembler messageAssembler;
	private ClientInitData initData;

	public Client(Receiver reader, Sender writer, Reactor reactor, MessageAssembler messageAssembler) {
		super(reader, writer);
		this.reactor = reactor;
		this.messageAssembler = messageAssembler;
	}

	@Override
	protected void networkRoleSpecificInit(InitData initD) throws IOException
	{
		this.initData = (ClientInitData)initD;

		if ( initData.hostName == null  ||  initData.hostName.isEmpty() )
			throw new IllegalArgumentException("The given hostname is invalid. " + initData.hostName );

		setClientSocket( new Socket(initData.hostName, initData.portNumber) );		
	}

	@Override
	protected void networkRoleSpecificNegotiation() throws IOException {
		
		//	Init
		String message = getReceiver().receiveMessage();
		reactor.reactToMessage(message, MessageType.INIT);

		//	Opponent Name
		message = getReceiver().receiveMessage();
		reactor.reactToMessage(message, MessageType.NAME);
		
		//	Name
		getSender().sendMessage( messageAssembler.createName( initData.userName ) );

		//	Ships
		message = getReceiver().receiveMessage();
		reactor.reactToMessage(message, MessageType.SHIPS);
	}
}
