/**
 * Class package.
 */
package picross;

/**
 * Importing borderLayout.
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * View class to control the UI and what the user sees.
 * @author Spencer
 *
 */
public class GameView extends JFrame {
	
	/**
	 * Serial version ID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Name String.
	 */
	private String NAME = "Picross!";
	
//	public void SetGameController(GameController controller) {
//		gameListener = controller.new ActionListener();
//	}
	
	/**
	 * Language 1 string.
	 */
	private static String LANG1 = "English";
	
	/**
	 * Language 2 string.
	 */
	private static String LANG2 = "French";
	
	/**
	 * btnMark string.
	 */
	private String btnMark = "Mark";
	
	/**
	 * Future btnReset string.
	 */
	//private String btnReset = "Reset";
	
	/**
	 * pointsLabel string.
	 */
	private String pointsLabel = "Points: ";
	
	/**
	 * points string.
	 */
	private String points = "0   ";
	
	/**
	 * btnBoard, to hold the buttons of the board.
	 */
	protected JButton[][] btnBoard;
	
	/**
	 * An array of Strings, to be used in future localization.
	 */
	private String[] languages = { LANG1, LANG2 };
	
	/**
	 * The current language. English by default.
	 */
	private String currentLang = "English";
	
	/**
	 * The url for the picross logo.
	 */
	private final String LOGOURL = "/images/logo.png";
	
	/**
	 * The size of the board.
	 */
	private int brdSize = 5;
	
	/**
	 * The label that holds the score.
	 */
	private JLabel score = new JLabel("Points");
	
	/**
	 * The label that points to the time.
	 */
	private JLabel timeLabel = new JLabel("Time:");
	
	/**
	 * The label that displays the time.
	 */
	private JLabel time = new JLabel("0");
	
	/**
	 * The log to print the events of the game.
	 */
	protected JTextArea log = new JTextArea();
	
	/**
	 * 
	 */
	//GameModel gameModel = new GameModel();
	
	/**
	 * 
	 */
	//GameView gameView = new GameView();
	
	/**
	 * 
	 */
	private GameController gameController = null;
	
	
	/**
	 * Constructor for GameView class.
	 */
	public GameView() {
		
	}
	
	public void ViewStart() {
		/**
		 * Image icon for the picture of the picross logo.
		 */
		ImageIcon picture = null;
		
		/**
		 * Main JFrame.
		 */
		JFrame picrossGame = new JFrame(NAME);
		
		/**
		 * The lftPanel for holding the left side coordinates.
		 */
		JPanel lftPanel = new JPanel();
		
		/**
		 * The tpPanel for holding the top coordinates.
		 */
		JPanel tpPanel = new JPanel();
		
		/**
		 * The mrkPanel for holding the mrkBtn.
		 */
		JPanel mrkPanel = new JPanel();
		
		/**
		 * The brdPanel that contains the buttons.
		 */
		JPanel brdPanel = new JPanel();
		
		/**
		 * The ctrlPanel to contain the logo, log, points, and timer.
		 */
		JPanel ctrlPanel = new JPanel();
		
		/**
		 * Logo label.
		 */
		JLabel logo = new JLabel();
		
		/**
		 * scoreLabel to point out the score.
		 */
		JLabel scoreLabel = new JLabel(pointsLabel);
		
		/**
		 * Label to display the score.
		 */
		//JLabel score = new JLabel(points);
		
		/**
		 * mrkBtn for turning mrkMode on or off.
		 */
		JCheckBox mrkBtn = new JCheckBox(btnMark);
		
		/**
		 * grid1, a gridlayout for the board.
		 */
		GridLayout grid1 = new GridLayout(brdSize, brdSize);
		
		/**
		 * A borderLayout for the GUI.
		 */
		BorderLayout border = new BorderLayout();
		
		/**
		 * menuBar to hold the menu of the JFrame.
		 */
		JMenuBar menuBar = new JMenuBar();
		
		/**
		 * The menu of the JFrame.
		 */
		JMenu menu = new JMenu("Menu");
		
		JMenuItem t1 = new JMenuItem("Reset Timer");
		
		/**
		 * Initializing btnBoard.
		 */
		btnBoard = new JButton[brdSize][brdSize];
		
		/**
		 * Setting bounds for lftPanel.
		 */
		lftPanel.setBounds(0, 70, 100, 400);
		
		/**
		 * Setting background color for lftPanel.
		 */
		lftPanel.setBackground(Color.LIGHT_GRAY);
		
		/**
		 * Try catch for getting logo.
		 */
		try {
			picture = new ImageIcon(getClass().getResource(LOGOURL));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		/**
		 * Setting layout for controlPanel.
		 */
		ctrlPanel.setLayout(new BoxLayout (ctrlPanel, BoxLayout.Y_AXIS));
		
		/**
		 * Setting logo label to the picture image icon.
		 */
		logo.setIcon(picture);
		
		/**
		 * Setting logo alignment to top.
		 */
		logo.setVerticalAlignment(JLabel.TOP);
		
		/**
		 * Setting ctrlPanel bounds and background color.
		 */
		ctrlPanel.setBounds(700, 0, 300, 470);
		ctrlPanel.setBackground(Color.LIGHT_GRAY);
		
		/**
		 * Adding ctrlPanel components, and setting background to gray.
		 */
		ctrlPanel.add(logo);
		ctrlPanel.add(scoreLabel);
		score.setBackground(Color.gray);
		ctrlPanel.add(score);
		ctrlPanel.add(timeLabel);
		ctrlPanel.add(time);
		/**
		 * Setting log to be non editable.
		 */
		log.setEditable(false);
		ctrlPanel.add(log);
		
		/**
		 * Setting top panel bounds and background color.
		 */
		tpPanel.setBounds(100, 0, 600, 70);
		tpPanel.setBackground(Color.LIGHT_GRAY);
		
		
		
		/**
		 * Setting board panel bounds and background color.
		 * As well as layout.
		 */
		brdPanel.setBounds(100, 70, 600, 400);
		brdPanel.setBackground(Color.gray);
		brdPanel.setLayout(grid1);
		
		fillBoard(gameController, brdPanel, brdSize, btnBoard);
		
		/**
		 * Setting background color for mrkBtn.
		 */
		mrkBtn.setBackground(Color.LIGHT_GRAY);
		
		/**
		 * Setting mrkPanel bounds and color. And adding mrkBtn.
		 */
		mrkPanel.setBounds(0, 0, 100, 70);
		mrkPanel.setBackground(Color.LIGHT_GRAY);
		//mrkPanel.add(mrkLabel);
		mrkPanel.add(mrkBtn);
		
		t1.addActionListener(gameController);
		t1.setActionCommand("TimerReset");
		
		menu.add(t1);
		
		/**
		 * Adding menu to the menu bar.
		 */
		menuBar.add(menu);
		
		/**
		 * Setting the JFrame menu bar to menuBar.
		 */
		picrossGame.setJMenuBar(menuBar);
		
		/**
		 * adding components, setting size, and setting the layout of picrossGame JFrame.
		 */
		picrossGame.add(lftPanel);
		picrossGame.add(tpPanel);
		picrossGame.add(brdPanel);
		picrossGame.add(mrkPanel);
		picrossGame.add(ctrlPanel);
		
		picrossGame.setSize(910, 520);
		
		picrossGame.setLayout(border);
		
		/**
		 * Setting default close, visibility. and sizeChanging.
		 */
		picrossGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		picrossGame.setVisible(true);
		picrossGame.setResizable(false);
	}
	
	/**
	 * Unused.
	 * @param controller
	 * Takes in controller.
	 */
	public void setController(GameController controller) {
		gameController = controller;
	}
	
	/**
	 * Method to set the time.
	 * @param elapsed
	 * Takes in the new time.
	 */
	public void setTime(int elapsed) {
		time.setText(Integer.toString(elapsed));
	}
	
	/**
	 * Method to set points.
	 * @param score
	 * Takes in the new score.
	 */
	public void setPoints(String newPoints) {
		System.out.println(newPoints);
		score.setText(newPoints);
		//score.paintImmediately(score.getVisibleRect());
		
	}
	
	/**
	 * Unused.
	 * @param btn
	 * Unused.
	 * @param listener
	 * Unused.
	 */
	public void register(JButton btn, ActionListener listener) {
		btn.addActionListener(listener);
	}
	
	/**
	 * Unused method.
	 * @param controller
	 * Unused.
	 * @param brdPanel
	 * unused.
	 */
	public static void fillBoard(GameController controller, JPanel brdPanel, int brdSize, JButton[][] btnBoard) {
		/**
		 * Populating the board with buttons. Works with different numbers but no option to change them
		 * is implemented yet.
		 */
		for(int i = 0; i < brdSize; i++) {
			for(int j = 0; j < brdSize; j++) {
				JButton btn = new JButton();
				btnBoard[i][j] = btn;
				btn.addActionListener(controller);
				btn.setActionCommand("btn[" + j + "]" + "[" + i + "]");
				brdPanel.add(btn);
			}
		}
	}
}
