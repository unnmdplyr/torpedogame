package network;

import java.util.NoSuchElementException;

import table.Reactor;
import table.Table;
import message.MessageObjectifier;

public class TcpConnectionFactory
{
	public TcpConnection create(NetworkRole networkRule)
	{
		if ( networkRule != NetworkRole.SERVER  ||  networkRule != NetworkRole.CLIENT )
			throw new NoSuchElementException("The network role must be either server or client.");

		Receiver receiver = new NetworkReader();
		Sender sender = new NetworkWriter();
		
		Table localTable = new Table();
		Table remoteTable = new Table();
		MessageObjectifier messageObjectifier = new MessageObjectifier();
		Reactor reactor = new Reactor(localTable, remoteTable, messageObjectifier);
		
		return	networkRule == NetworkRole.SERVER
											?  new Server(receiver, sender)
											:  new Client(receiver, sender, reactor); 
	}
}
