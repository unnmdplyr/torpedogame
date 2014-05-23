package ship;

public class OneLengthShip extends Ship {

	public OneLengthShip(ShipContainer shipContainer) {
		super(shipContainer);
	}

	@Override
	public int getXExtent() {
		return 1;
	}

	@Override
	public int getYExtent() {
		return 1;
	}


}
