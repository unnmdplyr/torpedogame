package network;

import java.io.OutputStream;
import java.io.PrintWriter;


public class NetworkWriter implements Sender {

	public NetworkWriter() {
	}

	private PrintWriter writer;

	
	public PrintWriter getWriter() {
		return writer;
	}

	public void setWriter(PrintWriter printer) {
		this.writer = printer;
	}

	
	public void sendMessage(final String message)
	{
		getWriter().println(message + "\n");	//	The line end denotes the end of the transmission.
		getWriter().flush();
		System.out.println("Message sent: " + message);
	}

	
	public void init( OutputStream outputStream )
	{
		setWriter( new PrintWriter(outputStream, true) );
	}
	
	public void close()
	{
		getWriter().close();
	}
}
