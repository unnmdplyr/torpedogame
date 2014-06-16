package message;

import table.Action;
import table.Table;

public class MsgShips extends AbstractMessage {

	private String shipData;

	public MsgShips( String shipData ) {
		this.shipData = shipData;
	}

	@Override
	public Action getAction() {
		return new Action() {
			public void apply(Table localTable, Table remoteTable) {
				localTable.loadShipDataFromString(shipData);
				System.out.println("The server sent the ships message. " + localTable.getShipNumber());
			}
		};
	}

}
