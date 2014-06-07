package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public abstract class TcpConnection {

	private Socket clientSocket;

	private PrintWriter printer;
	private BufferedReader reader;

	
	private static final int portNumber = 1146;

	public static int getPortNumber() {
		return portNumber;
	}

	
	public PrintWriter getPrinter() {
		return printer;
	}

	public void setPrinter(PrintWriter printer) {
		this.printer = printer;
	}

	public BufferedReader getReader() {
		return reader;
	}

	public void setReader(BufferedReader reader) {
		this.reader = reader;
	}


	
	public Socket getClientSocket() {
		return clientSocket;
	}

	public void setClientSocket(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}

	public void sendMessage(final String message)
	{
		printer.println(message);
		printer.flush();
		System.out.println("Message sent: " + message + "\n");
	}
	
	public String receiveMessage() throws IOException
	{
		StringBuilder stringBuilder = new StringBuilder();

		String line;

		while ( (line = reader.readLine()) != null ) {
			stringBuilder.append( line ).append("\n");
		}
		
		System.out.println("Message received: " + stringBuilder.toString() + "\n");
		return stringBuilder.toString();	
	}

	
	public void start() {
		try {
			networkRoleSpecificInit();
			getClientSocket().setTcpNoDelay(true);
			
			setPrinter( new PrintWriter(getClientSocket().getOutputStream(), true) );
			setReader( new BufferedReader(new InputStreamReader( getClientSocket().getInputStream() )));
		}
		catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	protected abstract void networkRoleSpecificInit() throws IOException;
	
	
	public void negotiation()
	{
		try {
			networkRoleSpecificNegotiation();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected abstract void networkRoleSpecificNegotiation() throws IOException;
	
	
	@Override
	public void finalize()
	{
		if ( !clientSocket.isClosed() )
			try {
				clientSocket.close();
				reader.close();
				printer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	
}
