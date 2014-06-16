package message;

import table.Point;

public class MessageAssembler {


	public String createInit(final Point dimensions) {
		
		if ( dimensions.getX() < 8 )
			System.out.println( "WARNING: The width is too small. " +
											"(" + dimensions.getX() + ") It must be at least 8." );
		if ( dimensions.getY() < 8 )
			System.out.println( "WARNING: The height is too small. " +
											"(" + dimensions.getY() + ") It must be at least 8." );

		return new StringBuilder()	.append(MessageTypes.INIT_PREFIX).append(" ")
									.append(dimensions.getX()).append(", ").append(dimensions.getY())
									.toString();
	}
	
	public String createName( String name )
	{
		return new StringBuilder()	.append(MessageTypes.NAME_PREFIX).append(" ").append(name)
									.toString();
	}
}
