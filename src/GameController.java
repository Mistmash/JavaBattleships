import java.util.Scanner;

public class GameController {

	int turn;
	Ocean[] oceanArray;

	GameController() {
		turn = 1;
		oceanArray = new Ocean[2];
		// Create Oceans for each player
		oceanArray[0] = new Ocean(1, 12, 12);
		oceanArray[1] = new Ocean(2, 12, 12);
		// Add ships to each player's Ocean
		inputShip(1, "Patrol Boat", 2, 0, 0, 0, oceanArray[0]);
		inputShip(1, "Patrol Boat", 2, 11, 0, 3, oceanArray[0]);
		inputShip(1, "Battleship", 3, 3, 1, 1, oceanArray[0]);
		inputShip(1, "Battleship", 3, 3, 5, 0, oceanArray[0]);
		inputShip(1, "Submarine", 3, 11, 8, 0, oceanArray[0]);
		inputShip(1, "Destroyer", 4, 3, 10, 1, oceanArray[0]);
		inputShip(1, "Carrier", 5, 9, 2, 0, oceanArray[0]);
		inputShip(2, "Patrol Boat", 2, 2, 9, 0, oceanArray[1]);
		inputShip(2, "Patrol Boat", 2, 8, 3, 0, oceanArray[1]);
		inputShip(2, "Battleship", 3, 2, 5, 0, oceanArray[1]);
		inputShip(2, "Battleship", 3, 7, 10, 1, oceanArray[1]);
		inputShip(2, "Submarine", 3, 8, 8, 1, oceanArray[1]);
		inputShip(2, "Destroyer", 4, 10, 1, 0, oceanArray[1]);
		inputShip(2, "Carrier", 5, 1, 1, 1, oceanArray[1]);
	}

	public void setUpGame() {
		// In Progress
		for (int i = 0; i < 7; i++) {
			switch (i) {
			case 0: case1:
				System.out.print("Creating Patrol Boat, size 3.\n");
				break;
			case 2: case 3:
				
				break;
			}
			System.out.print("");
			// Alternate turns
			turn = 3 - turn;
		}
	}

	public void startGame() {
		while (oceanArray[turn - 1].hasShips()) {
			// Display GUI
			displayAllOceans(oceanArray);
			takeTurn(turn);
			// Alternate turns
			turn = 3 - turn;
		}
		System.out.print("Player " + (3 - turn) + " has won the game!\n");
	}

	private boolean inputShip(int belongsToPlayer, String typeOfShip,
			int sizeOfShip, int originXCoordinate, int originYCoordinate,
			int directionalAlignment, Ocean ocean) {
		Ship newShip = new Ship(belongsToPlayer, typeOfShip, sizeOfShip,
				originXCoordinate, originYCoordinate, directionalAlignment,
				ocean);
		// Test that the ship placement is valid
		if (legalShipPlacement(ocean, newShip)) {
			// Add Ship to ocean object
			ocean.addShip(newShip);
			return true;
		} else {
			return false;
		}
	}

	private boolean legalShipPlacement(Ocean ocean, Ship ship) {
		ShipPart[] testParts = ship.getShipParts();
		// Test if the part is within the ocean boundaries
		for (ShipPart p : testParts) {
			if (p.getXCoordinate() < 0
					|| p.getXCoordinate() >= ocean.getXSize()
					|| p.getYCoordinate() < 0
					|| p.getYCoordinate() >= ocean.getYSize()) {
				System.out.print("Ship has been placed outside of the grid.\n");
				return false;
			}
		}
		// Test if part is on a currently filled tile
		for (ShipPart p : testParts) {
			if (ocean.getTile(p.getXCoordinate(), p.getYCoordinate())
					.hasShipPart()) {
				System.out
						.print("Ship has been placed on top of another ship.\n");
				return false;
			}
		}
		return true;
	}

	private void takeTurn(int player) {
		System.out.print("Player " + player + ", it is your turn.\n");
		int xCoordinate;
		int yCoordinate;
		Shot shot;
		do {
			// Get row of the shot
			xCoordinate = getInt("Enter row of the shot.\n");
			// Change coordinate to array index
			xCoordinate--;
			// Get column of the shot
			yCoordinate = getInt("Enter column of the shot.\n");
			// Change coordinate to array index
			yCoordinate--;
			shot = new Shot((3 - player), xCoordinate, yCoordinate);
			// Loop until shot is within play area
		} while (!legalShot(shot));
		// Send shot to target player's ocean
		oceanArray[2 - player].recieveShot(shot);
	}

	int getInt(String prompt) {
		while (true) {
			System.out.print(prompt);
			try {
				// If an integer is read, return it
				return Integer.parseInt(new Scanner(System.in).next());
			} catch (NumberFormatException ne) {
				// Display error and loop if no integer detected
				System.out.print("Input must be an integer.\n");
			}
		}
	}

	boolean legalShot(Shot shot) {
		// Validate that shot index is within play area
		if (shot.getXCoordinate() < 0
				|| shot.getXCoordinate() >= oceanArray[(shot.getTargetPlayer() - 1)]
						.getXSize()
				|| shot.getYCoordinate() < 0
				|| shot.getYCoordinate() >= oceanArray[(shot.getTargetPlayer() - 1)]
						.getYSize()) {
			System.out.print("Shot is not within the play area.\n");
			return false;
		} else {
			return true;
		}
	}

	// For debugging we want to see oceans during development
	void displayAllOceans(Ocean[] oceanArray) {
		for (Ocean o : oceanArray) {
			o.showOcean();
		}
	}

	void displayAllBoards(Board[] boardArray) {
		for (Board b : boardArray) {
			b.showBoard();
		}
	}
}
