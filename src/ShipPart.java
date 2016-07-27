public class ShipPart {

	int xCoordinate;
	int yCoordinate;
	boolean isHit;
	String typeOfShip;

	ShipPart(String typeOfShip, int xCoordinate, int yCoordinate) {
		this.typeOfShip = typeOfShip;
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
		isHit = false;
		// System.out.print("Yo i'm a ship part and i live at "+ (xCoordinate +
		// 1) + " " + (yCoordinate + 1) + "\n");
	}

	public int getXCoordinate() {
		return xCoordinate;
	}

	public int getYCoordinate() {
		return yCoordinate;
	}

	public boolean isHit() {
		return isHit;
	}

	public String getType() {
		return typeOfShip;
	}

	public void partShot() {
		isHit = true;
	}
}
