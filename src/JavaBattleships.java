public class JavaBattleships {

	public static void main(String[] args) {
		JavaBattleships jb = new JavaBattleships();
		jb.Task4();
		// hwc.speedCoding2();
	}

	public void Task4() {
		System.out.print("Welcome to Java Battleships!\n\n");
		GameController gameController = new GameController();
		gameController.startGame();
	}
}