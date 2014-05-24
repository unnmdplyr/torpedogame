package customship;

import ship.Ship;
import ship.ShipContainer;
import table.Cell;
import table.Point;

public class CustomShip extends Ship implements Cloneable{

	public CustomShip(ShipContainer shipContainer) {
		super(shipContainer);
	}
	
	@Override
	public CustomShip clone() {
		CustomShip ship = new CustomShip(shipContainer);
		cloneShipCellsTo(ship);
		return ship;
	}

	private void cloneShipCellsTo(CustomShip ship) {
		for (Cell cell : coveredCells) {
			ship.addCoveredCell(cell.clone());
		}
	}

	@Override
	public int getXExtent() {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for (Cell cell : coveredCells) {
			if (cell.getX() < min) {
				min = cell.getX();
			}
			
			if (cell.getX() > max) {
				max = cell.getX();
			}
		}
		
		return max - min + 1;
	}

	@Override
	public int getYExtent() {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for (Cell cell : coveredCells) {
			if (cell.getY() < min) {
				min = cell.getY();
			}
			
			if (cell.getY() > max) {
				max = cell.getY();
			}
		}
		
		return max - min + 1;
	}
	
	public Point determineExtent()
	{
		return new Point(getXExtent(), getYExtent());
	}

	public void addCoveredCell(Cell cell) {
		coveredCells.add(cell);
	}
	
	public void moveToPosition(Point upperLeft) {
		for (Cell coveredCell : coveredCells) {
			coveredCell.setX(coveredCell.getX() + upperLeft.getX() );
			coveredCell.setY(coveredCell.getY() + upperLeft.getY() );
		}
	}

}
