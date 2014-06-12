package network;

import java.io.IOException;
import java.io.InputStream;


public interface Receiver {
	
	public void init( InputStream inputStream );

	public String receiveMessage() throws IOException;

	public void close();
}
