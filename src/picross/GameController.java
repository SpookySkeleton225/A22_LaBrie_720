/**
 * Class package.
 */
package picross;

/**
 * Importing action event.
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class designed to handle user inputs, and make changes to the model class.
 * 
 * @author Spencer
 * 
 */
public class GameController implements ActionListener {

	/**
	 * Reference to GameModel class.
	 */
	private GameModel model;

	/**
	 * Reference to GameView class.
	 */
	private GameView view;

	/**
	 * Reference to ControllableTimer class.
	 */
	private ControllableTimer timer = new ControllableTimer(view);

	/**
	 * 
	 */
	private boolean mrkMode = false;

	/**
	 * Constructor for GameController class.
	 * 
	 * @param model Constructor takes in a reference to the GameModel class.
	 * @param view  Constructor takes in a reference to the GameView class.
	 */
	public GameController(GameModel model, GameView view) {
		System.out.println("TestModel");
		this.model = model;
		System.out.println("TestModel");
		System.out.println("TestView");
		this.view = view;
		view.setController(this);
		view.ViewStart();
		System.out.println("TestView");
		this.timer = new ControllableTimer(view);

		/**
		 * Starting timer. (Seemingly nonfunctional. Or perhaps I am not using it
		 * right.)
		 */
		timer.start();
		start(timer);
		this.model.configureGame();
	}

	/**
	 * Default Constructor for GameController class.
	 */
	public GameController() {
	}

	/**
	 * Method to start the timer upon the beginning of the game.
	 * 
	 * @param timer A reference to the timer class.
	 */
	public static void start(ControllableTimer timer) {
		timer.setStatus(ControllableTimer.START);
	}

	/**
	 * The overridden action performed method. When it is complete, it will take
	 * action commands from the View class Use them to update the Model class, and
	 * then the model class will tell the View class changes have been made.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		if (e.getActionCommand().equals("btn[0][0]")) {
			view.setPoints(model.move(0, 0, mrkMode));
		} else if (e.getActionCommand().equals("btn[0][1]")) {
			view.setPoints(model.move(0, 1, mrkMode));
		} else if (e.getActionCommand().equals("btn[0][2]")) {
			view.setPoints(model.move(0, 2, mrkMode));
		} else if (e.getActionCommand().equals("btn[0][3]")) {
			view.setPoints(model.move(0, 3, mrkMode));
		} else if (e.getActionCommand().equals("btn[0][4]")) {
			view.setPoints(model.move(0, 4, mrkMode));
		} else if (e.getActionCommand().equals("btn[1][0]")) {
			view.setPoints(model.move(1, 0, mrkMode));
		} else if (e.getActionCommand().equals("btn[1][1]")) {
			view.setPoints(model.move(1, 1, mrkMode));
		} else if (e.getActionCommand().equals("btn[1][2]")) {
			view.setPoints(model.move(1, 2, mrkMode));
		} else if (e.getActionCommand().equals("btn[1][3]")) {
			view.setPoints(model.move(1, 3, mrkMode));
		} else if (e.getActionCommand().equals("btn[1][4]")) {
			view.setPoints(model.move(1, 4, mrkMode));
		} else if (e.getActionCommand().equals("btn[2][0]")) {
			view.setPoints(model.move(2, 0, mrkMode));
		} else if (e.getActionCommand().equals("btn[2][1]")) {
			view.setPoints(model.move(2, 1, mrkMode));
		} else if (e.getActionCommand().equals("btn[2][2]")) {
			view.setPoints(model.move(2, 2, mrkMode));
		} else if (e.getActionCommand().equals("btn[2][3]")) {
			view.setPoints(model.move(2, 3, mrkMode));
		} else if (e.getActionCommand().equals("btn[2][4]")) {
			view.setPoints(model.move(2, 4, mrkMode));
		} else if (e.getActionCommand().equals("btn[3][0]")) {
			view.setPoints(model.move(3, 0, mrkMode));
		} else if (e.getActionCommand().equals("btn[3][1]")) {
			view.setPoints(model.move(3, 1, mrkMode));
		} else if (e.getActionCommand().equals("btn[3][2]")) {
			view.setPoints(model.move(3, 2, mrkMode));
		} else if (e.getActionCommand().equals("btn[3][3]")) {
			view.setPoints(model.move(3, 3, mrkMode));
		} else if (e.getActionCommand().equals("btn[3][4]")) {
			view.setPoints(model.move(3, 4, mrkMode));
		} else if (e.getActionCommand().equals("btn[4][0]")) {
			view.setPoints(model.move(4, 0, mrkMode));
		} else if (e.getActionCommand().equals("btn[4][1]")) {
			view.setPoints(model.move(4, 1, mrkMode));
		} else if (e.getActionCommand().equals("btn[4][2]")) {
			view.setPoints(model.move(4, 2, mrkMode));
		} else if (e.getActionCommand().equals("btn[4][3]")) {
			view.setPoints(model.move(4, 3, mrkMode));
		} else if (e.getActionCommand().equals("btn[4][4]")) {
			view.setPoints(model.move(4, 4, mrkMode));
		} else if (e.getActionCommand().equals("TimerReset")) {
			timer.setStatus(ControllableTimer.RESET);
			//System.out.print("test");
		}
	}
}