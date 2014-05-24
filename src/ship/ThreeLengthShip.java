package ship;

import table.Point;

public class ThreeLengthShip extends Ship {

	public ThreeLengthShip(ShipContainer shipContainer) {
		super(shipContainer);
	}

	@Override
	public int getXExtent() {
		return 3;
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
