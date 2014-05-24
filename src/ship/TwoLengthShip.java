package ship;

import table.Point;

public class TwoLengthShip extends Ship {

	public TwoLengthShip(ShipContainer shipContainer) {
		super(shipContainer);
	}

	@Override
	public int getXExtent() {
		return 2;
	}

	@Override
	public int getYExtent() {
		return 1;
	}

	@Override
	public Point determineExtent() {
		// TODO Auto-generated method stub
		return null;
	}

}
