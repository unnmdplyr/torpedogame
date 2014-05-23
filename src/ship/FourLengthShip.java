package ship;

public class FourLengthShip extends Ship {

	public FourLengthShip(ShipContainer shipContainer) {
		super(shipContainer);
	}

	@Override
	public int getXExtent() {
		return 4;
	}

	@Override
	public int getYExtent() {
		return 1;
	}

}
