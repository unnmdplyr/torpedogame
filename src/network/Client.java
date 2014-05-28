package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client extends TcpConnection
{
	private String hostName;
	
	public Client() {
	}

	public Client(String hostName) {
		this.hostName = hostName;
	}

	public void start()
	{
		try {
			final String defaultHostName = "127.0.0.1";

			if ( hostName.isEmpty()  ||  hostName == null )
				hostName = defaultHostName;

			setClientSocket( new Socket(hostName, getPortNumber()) );
			getClientSocket().setTcpNoDelay(true);
			
			setPrinter( new PrintWriter(getClientSocket().getOutputStream(), true) );
			setReader( new BufferedReader(new InputStreamReader( getClientSocket().getInputStream() )));
		}
		catch (IOException e) {
			e.printStackTrace();
		}

	}
}
