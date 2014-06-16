package message;

import table.Action;
import table.Point;
import table.Table;

public class MsgInit extends AbstractMessage {

	private Point tableSize;

	public MsgInit( Point tableSize ) {
		this.tableSize = tableSize;
	}

	@Override
	public Action getAction() {
		return new Action() {
			public void apply(Table localTable, Table remoteTable) {
				localTable .setSize( tableSize );
				remoteTable.setSize( tableSize );
				System.out.println("The server sent the init message.");
			}
		};
	}
	
}
