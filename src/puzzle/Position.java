package puzzle;

public class Position {

	private int x;
	private int y;
	private int traveledTo = -1;
	
	public Position(int x, int y, int traveledTo)
	{
		this.x = x;
		this.y = y;
		this.traveledTo = traveledTo;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getTraveledTo() {
		return traveledTo;
	}
	public void setTraveledTo(int traveledTo) {
		this.traveledTo = traveledTo;
	}

	@Override
	public String toString() {
		return "Position [x=" + x + ", y=" + y + ", traveledTo=" + traveledTo
				+ "]";
	}

	
	
	
}
