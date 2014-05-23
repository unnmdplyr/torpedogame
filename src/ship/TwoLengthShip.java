package ship;

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

}
