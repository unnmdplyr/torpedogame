package network;

import java.io.BufferedReader;
import java.io.IOException;
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
	}
	
	public String receiveMessage() throws IOException
	{
		StringBuilder stringBuilder = new StringBuilder();

		String line;

		while ( (line = reader.readLine()) != null ) {
			stringBuilder.append( line ).append("\n");
		}
		
		return stringBuilder.toString();	
	}

}
