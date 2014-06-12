package network;

import java.io.OutputStream;


public interface Sender {

	public void init( OutputStream outputStream );

	public void sendMessage(final String message);
	
	public void close();
}
