package network;

import java.util.NoSuchElementException;

public class TcpConnectionFactory
{
	public TcpConnection create(NetworkRole networkRule)
	{
		if ( networkRule != NetworkRole.SERVER  ||  networkRule != NetworkRole.CLIENT )
			throw new NoSuchElementException("The network role must be either server or client.");

		Receiver receiver = new NetworkReader();
		Sender sender = new NetworkWriter();
		
		return	networkRule == NetworkRole.SERVER  ?  new Server(receiver, sender)  :  new Client(receiver, sender); 
	}
}
