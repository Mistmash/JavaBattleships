import java.util.ArrayList;

public class Ocean {

	int belongsToPlayer;
	Tile tile[][];
	int xSize;
	int ySize;
	Board board;
	ArrayList<Ship> ships = new ArrayList<Ship>();

	Ocean(int belongsToPlayer, int xSize, int ySize) {
		this.belongsToPlayer = belongsToPlayer;
		this.xSize = xSize;
		this.ySize = ySize;
		// Initialise the board
		tile = new Tile[xSize][ySize];
		for (int x = 0; x < xSize; x++) {
			for (int y = 0; y < ySize; y++) {
				// Set all tiles to hidden
				tile[x][y] = new Tile();
			}
		}
		this.board = new Board(belongsToPlayer, xSize, ySize);
	}

	public void showOcean() {
		// Oceans are shown during the development process to make debugging
		// easier
		/*
		 * System.out.print("Player " + belongsToPlayer + " Ocean\n"); //
		 * Display the X values for (int y = 1; y <= tile[0].length; y++) {
		 * System.out.print("\t" + y); } System.out.print("\n"); for (int x = 0;
		 * x < tile.length; x++) { // Display the Y values System.out.print(x +
		 * 1); for (int y = 0; y < tile[0].length; y++) { if
		 * (tile[x][y].hasShipPart()) { switch
		 * (tile[x][y].getShipPart().getType()) { case "Patrol Boat":
		 * System.out.print("\tP"); break; } } else { System.out.print("\t~"); }
		 * } System.out.print("\n"); }
		 * 
		 * System.out.print("\n");
		 */
		board.showBoard();
	}

	public void addShip(Ship ship) {
		ShipPart[] newParts = ship.getShipParts();
		for (ShipPart p : newParts) {
			tile[p.getXCoordinate()][p.getYCoordinate()].addShipPart(p);
		}
		ships.add(ship);
	}

	public boolean recieveShot(Shot shot) {
		// Check if ship part found on tile
		if (tile[shot.getXCoordinate()][shot.getYCoordinate()].hasShipPart()) {
			// If shot hits, update the board and the part to reflect this
			board.registerShot(true, shot.getXCoordinate(),
					shot.getYCoordinate());
			tile[shot.getXCoordinate()][shot.getYCoordinate()].getShipPart()
					.partShot();
		} else {
			// If shot misses, update the board
			board.registerShot(false, shot.getXCoordinate(),
					shot.getYCoordinate());
		}
		return false;
	}

	public boolean hasShips() {
		// Test each ship to see whether it is destroyed
		for (Ship s : ships) {
			if (!s.isDestroyed()) {
				return true;
			}
		}
		return false;
	}

	public int numberOfShips() {
		return ships.size();
	}

	public int getXSize() {
		return xSize;
	}

	public int getYSize() {
		return xSize;
	}

	public Tile getTile(int x, int y) {
		return tile[x][y];
	}
}
