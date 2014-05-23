package ship;

import table.Cell;
import table.Point;

public class TetrisShip extends Ship {

	public TetrisShip(ShipContainer shipContainer) {
		super(shipContainer);
	}

	@Override
	public int getXExtent() {
		return 3;
	}

	@Override
	public int getYExtent() {
		return 2;
	}

//	@Override
//	public void generateCoveredCells(Point pt) {
//		coveredCells.add(new Cell(1, 0, pt.getY() + 1));
//		for ( int j=pt.getX(); j < pt.getX() + getXExtent(); ++j ) {
//			coveredCells.add(new Cell(1, j, 1));
//		}
//	}
}
