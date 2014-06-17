package network;

import game.InitData;

import java.io.IOException;
import java.net.Socket;

public abstract class TcpConnection
{
	private Receiver reader;
	private Sender writer;

	public Receiver getReceiver() {
		return reader;
	}
	public Sender getSender() {
		return writer;
	}
	
	public TcpConnection(Receiver reader, Sender writer) {
		this.reader = reader;
		this.writer = writer;
	}


	private Socket clientSocket;
	
	public Socket getClientSocket() {
		return clientSocket;
	}

	public void setClientSocket(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}
	
	
	public void start(InitData initData) {
		try {
			networkRoleSpecificInit(initData);
			getClientSocket().setTcpNoDelay(true);
			
			getReceiver().init( getClientSocket().getInputStream()  );
			getSender  ().init( getClientSocket().getOutputStream() );
		}
		catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	protected abstract void networkRoleSpecificInit(InitData initData) throws IOException;
	
	
	public void negotiation()
	{
		try {
			networkRoleSpecificNegotiation();
			networkRoleSpecificBattle();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected abstract void networkRoleSpecificNegotiation() throws IOException;
	protected abstract void networkRoleSpecificBattle() throws IOException;
	
	
	@Override
	public void finalize()
	{
		if ( !getClientSocket().isClosed() )
			try {
				getClientSocket().close();
				getReceiver().close();
				getSender().close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	
}
