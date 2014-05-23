package ship;

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

}
