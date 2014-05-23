package table;

public class Cell implements Cloneable {

	private int x;
	private int y;

	private int value;

	@Override
	public Cell clone() {
		return new Cell(value, x, y);
	}
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int posX) {
		this.x = posX;
	}

	public int getY() {
		return y;
	}

	public void setY(int posY) {
		this.y = posY;
	}

	
	public Cell(int value, int posX, int posY) {
		this.value = value;
		this.x = posX;
		this.y = posY;
	}
	
	public boolean isPositionCovered( int posX, int posY )
	{
		return this.x == posX  &&  this.y == posY; 
	}
	
}
