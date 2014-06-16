package network;

import java.util.NoSuchElementException;

import table.Reactor;
import table.Table;
import message.MessageAssembler;
import message.MessageObjectifier;
import message.MessageParser;

public class TcpConnectionFactory
{
	public TcpConnection create(NetworkRole networkRule)
	{
		if ( networkRule != NetworkRole.SERVER  &&  networkRule != NetworkRole.CLIENT )
			throw new NoSuchElementException("The network role must be either server or client.");

		Receiver receiver = new NetworkReader();
		Sender sender = new NetworkWriter();
		
		Table localTable = new Table();
		Table remoteTable = new Table();
	
		MessageAssembler messageAssembler = new MessageAssembler(); 
		MessageParser messageParser = new MessageParser();
		MessageObjectifier messageObjectifier = new MessageObjectifier(messageParser);
		Reactor reactor = new Reactor(localTable, remoteTable, messageObjectifier);
		
		System.out.println( networkRule == NetworkRole.SERVER  ?  "Server created."  :  "Client created." );
		
		return	networkRule == NetworkRole.SERVER
											?  new Server(receiver, sender, reactor, messageAssembler)
											:  new Client(receiver, sender, reactor, messageAssembler);
	}
}
