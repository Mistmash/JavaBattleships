public class Board {

	private enum tileState {
		HIDDEN, EMPTY, HIT
	}

	int belongsToPlayer;
	tileState[][] tile;

	Board(int belongsToPlayer, int xSize, int ySize) {
		// Initialise the board
		this.belongsToPlayer = belongsToPlayer;
		tile = new tileState[xSize][ySize];
		for (int x = 0; x < xSize; x++) {
			for (int y = 0; y < ySize; y++) {
				// Set all tiles to hidden
				tile[x][y] = tileState.HIDDEN;
			}
		}
	}

	public void showBoard() {
		System.out.print("Player " + belongsToPlayer + " Board\n");
		// Display the X values
		for (int y = 1; y <= tile[0].length; y++) {
			System.out.print("\t" + y);
		}
		System.out.print("\n");
		for (int x = 0; x < tile.length; x++) {
			// Display the Y values
			System.out.print(x + 1);
			for (int y = 0; y < tile[0].length; y++) {
				switch (tile[x][y]) {
				case HIDDEN:
					// Print hidden tiles as ~
					System.out.print("\t~");
					break;
				case EMPTY:
					// Print empty tiles as #
					System.out.print("\t#");
					break;
				case HIT:
					// Print hit tiles as !
					System.out.print("\t!");
					break;
				}
			}
			System.out.print("\n");
		}

		System.out.print("\n");
	}

	public void registerShot(boolean isHit, int xCoordinate, int yCoordinate) {
		// Set values of the tile that has been shot depending on if a part was
		// hit
		if (isHit) {
			tile[xCoordinate][yCoordinate] = tileState.HIT;
		} else {
			tile[xCoordinate][yCoordinate] = tileState.EMPTY;
		}
	}
}
