package network;

public class TcpConnectionFactory
{
	public TcpConnection create(NetworkRole networkRule)
	{
		return	networkRule == NetworkRole.SERVER  ?  new Server()
			:  (networkRule == NetworkRole.CLIENT  ?  new Client()  :  null); 
	}
}
