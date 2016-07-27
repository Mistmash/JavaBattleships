public class Shot {

	int xCoordinate;
	int yCoordinate;
	int targetPlayer;

	Shot(int targetPlayer, int xCoordinate, int yCoordinate) {
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
		this.targetPlayer = targetPlayer;
		//System.out.print("Shot " + xCoordinate + " " + yCoordinate
		//		+ " at Player " + targetPlayer + ".\n");
	}
	
	public int getXCoordinate() {
		return xCoordinate;
	}

	public int getYCoordinate() {
		return yCoordinate;
	}

	public int getTargetPlayer() {
		return targetPlayer;
	}
}
