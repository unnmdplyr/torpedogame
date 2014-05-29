package network;

import java.io.IOException;
import java.net.Socket;

public class Client extends TcpConnection
{
	private String hostName;
	
	public Client() {
	}

	public Client(String hostName) {
		this.hostName = hostName;
	}

	@Override
	protected void networkRoleSpecificInit() throws IOException
	{
		final String defaultHostName = "127.0.0.1";

		if ( hostName.isEmpty()  ||  hostName == null )
			hostName = defaultHostName;

		setClientSocket( new Socket(hostName, getPortNumber()) );		
	}

	@Override
	protected void networkRoleSpecificNegotiation() {
		
	}
}
