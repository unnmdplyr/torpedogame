package message;

import table.Action;
import table.Table;

public class MsgEmpty extends AbstractMessage {

	private String message;

	public MsgEmpty( String message ) {
		this.message = message;
	}

	@Override
	public Action getAction() {
		return new Action() {
			@Override
			public void apply(Table localTable, Table remoteTable) {
				System.out.println( "Empty message came: \"" + message + "\"" );
			}
		};
	}

}
