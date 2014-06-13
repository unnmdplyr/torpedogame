package message;

public class MessageAssembler {


	public String createInit(final int width, final int height) {
		
		if ( width != height )
			System.out.println( "WARNIG: The width and height do not match. " +
						"(" + width + " != " + height + ") Only width will be used." );

		return new StringBuilder()	.append(MessageTypes.INIT_PREFIX).append(" ")
									.append(width).append(", ").append(height)
									.toString();
	}
	
	public String createName( String name )
	{
		return new StringBuilder()	.append(MessageTypes.NAME_PREFIX).append(" ").append(name)
									.toString();
	}
}
