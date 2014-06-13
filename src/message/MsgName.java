package message;

import table.Action;
import table.Table;

public class MsgName extends AbstractMessage {

	private String name;

	public MsgName(String name) {
		this.name = name;
	}

	@Override
	public Action getAction() {
		return new Action() {
			public void apply(Table localTable, Table remoteTable) {
				System.out.println( "The name of the opponent is: " + name );
			}
		};
	}

}
