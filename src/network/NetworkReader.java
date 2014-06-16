package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class NetworkReader implements Receiver {

	public NetworkReader() {
	}

	private BufferedReader reader;

	public BufferedReader getReader() {
		return reader;
	}

	public void setReader(BufferedReader reader) {
		this.reader = reader;
	}

	
	public String receiveMessage() throws IOException
	{
		StringBuilder stringBuilder = new StringBuilder();

		String line;

		while ( (line = getReader().readLine()) != null ) {

			if ( line.isEmpty() )	//	This denotes the end of the transmission
				break;

			stringBuilder.append( line ).append("\n");
		}
		
		System.out.println("Message received: " + stringBuilder.toString() + "\n");
		return stringBuilder.toString();
	}
	
	public void init( InputStream inputStream )
	{
		setReader( new BufferedReader(new InputStreamReader( inputStream )));
	}
	
	public void close()
	{
		try {
			getReader().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
