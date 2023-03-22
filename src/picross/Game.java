package picross;

/**
 * Driver class for picross game.
 * @author Spencer
 *
 */
public class Game {

	/**
	 * Main method.
	 * @param args
	 * Takes in arguments.
	 */
	public static void main(String[] args) {
		GameModel gameModel = new GameModel();
		GameView gameView = new GameView();
		GameController gameController = new GameController(gameModel, gameView);
		
		
	}

}
