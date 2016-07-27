public class Ship {

	int belongsToPlayer;
	String typeOfShip;
	int sizeOfShip;
	ShipPart[] shipParts;
	int originXCoordinate;
	int originYCoordinate;
	int directionalAlignment;
	Ocean ocean;

	Ship(int belongsToPlayer, String typeOfShip, int sizeOfShip,
			int originXCoordinate, int originYCoordinate,
			int directionalAlignment, Ocean ocean) {

		this.belongsToPlayer = belongsToPlayer;
		this.typeOfShip = typeOfShip;
		this.sizeOfShip = sizeOfShip;
		shipParts = new ShipPart[sizeOfShip];
		this.originXCoordinate = originXCoordinate;
		this.originYCoordinate = originYCoordinate;
		this.directionalAlignment = directionalAlignment;
		// Initialise ship parts
		// Create first origin part
		shipParts[0] = new ShipPart(typeOfShip, originXCoordinate,
				originYCoordinate);
		// Depending on alignment, build ships around origin
		switch (directionalAlignment) {
		case 0:
			// east
			for (int i = 1; i < sizeOfShip; i++) {
				shipParts[i] = new ShipPart(typeOfShip, originXCoordinate,
						(originYCoordinate + i));
			}
			break;
		case 1:
			// south
			for (int i = 1; i < sizeOfShip; i++) {
				shipParts[i] = new ShipPart(typeOfShip,
						(originXCoordinate + i), originYCoordinate);
			}
			break;
		case 2:
			// west
			for (int i = 1; i < sizeOfShip; i++) {
				shipParts[i] = new ShipPart(typeOfShip, originXCoordinate,
						(originYCoordinate - i));
			}
			break;
		case 3:
			// north
			for (int i = 1; i < sizeOfShip; i++) {
				shipParts[i] = new ShipPart(typeOfShip,
						(originXCoordinate - i), originYCoordinate);
			}
			break;
		}
	}

	public boolean isDestroyed() {
		// Test each ship part to see if it is hit
		for (ShipPart p : shipParts) {
			if (!p.isHit()) {
				return false;
			}
		}
		return true;
	}

	public ShipPart[] getShipParts() {
		return shipParts;
	}

	public int belongsToPlayer() {
		return belongsToPlayer;
	}
}
