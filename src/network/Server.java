package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;


public class Server extends TcpConnection
{
	private ServerSocket serverSocket;

	public ServerSocket getServerSocket() {
		return serverSocket;
	}

	public void setServerSocket(ServerSocket serverSocket) {
		this.serverSocket = serverSocket;
	}

	public void start()
	{
		try {
			setServerSocket( new ServerSocket(getPortNumber()) );
			setClientSocket( getServerSocket().accept() );
			getClientSocket().setTcpNoDelay(true);
			
			setPrinter( new PrintWriter(getClientSocket().getOutputStream(), true) );
			setReader( new BufferedReader(new InputStreamReader( getClientSocket().getInputStream() )));
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
