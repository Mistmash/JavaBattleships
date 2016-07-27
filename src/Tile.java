public class Tile {

	boolean hasShip;
	ShipPart shipPart;

	Tile() {
		hasShip = false;
		shipPart = null;
	}

	public boolean hasShipPart() {
		return hasShip;
	}

	public ShipPart getShipPart() {
		return shipPart;
	}

	public void addShipPart(ShipPart shipPart) {
		hasShip = true;
		this.shipPart = shipPart;
	}
}
