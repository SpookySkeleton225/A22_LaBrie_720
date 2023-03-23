/**
 * Class package.
 */
package picross;

/**
 * Importing utility functions.
 */
import java.util.*;
import java.util.stream.Stream;

/**
 * GameModel class purpose is to hold data about this program, 
 * and to instruct the GameView class when changes have been made.
 * @author Spencer
 *
 */
public class GameModel {
	
	/**
	 * Int to contain the current score.
	 */
	private int score = 0;
	
	/**
	 * Int to contain current dimension and size of board. Default 5x5.
	 */
	protected int dimension = 5;
	
	/**
	 * Random object to be used in the creation of randomly generated games.
	 */
	private Random rand = new Random();
	
	//private GameView = new GameView();
	
	/**
	 * Boolean to check if mrkMode is off. Off by default.
	 */
    //private boolean mrkMode = false;
	
    /**
     * A string to contain the current configuration of the board. 
     * In the future, this will be able to be exported and imported.
     */
    private String boardConfig = "01111,11100,10111,10110,01110";
    
    /**
     * A double array of booleans acting as a "virtualized" version of the game board. 
     * Containing what parts need to be selected, and what parts dont.
     */
    protected boolean[][] boardData = new boolean[dimension][dimension];
    
    /**
     * Worker method to set the current dimension.
     * @param dimension
     * Takes in the new dimension.
     */
    public void setDimension(int dimension) {
    	this.dimension = dimension;
    }
    
    /**
     * Worker method to set the current score.
     * @param score
     * Takes in the new score.
     */
    public void setPoints(int score) {
    	this.score = score;
    }
    
    public void modBtn(int x, int y, int flag) {
    	
    }
    
    /**
     * Worker method to randomly generate a game.
     * @param board
     * Method takes in a double array of booleans, and randomly sets each member to true or false.
     * @return
     * Returns the double boolean.
     */
    public boolean[][] genGame(boolean[][] board) {
    	for(int i = 0; i < dimension; i++) {
    		for(int j = 0; j < dimension; i++) {
    			board[i][j] = rand.nextBoolean();
    		}
    	}
    	
    	return board;
    }
    
    /**
     * Method to set up the game board.
     */
    public void configureGame() {
    	String[] config = boardConfig.split(",");
    	
    	
    	for(int i = 0; i < config.length; i++) {
    		for (int j = 0; j < config.length; j++) {
    			if(config[i].charAt(j) == '1') {
    				boardData[i][j] = true;
    			} else {
    				boardData[i][j] = false;
    			}
    		}
    	}
    }
    
    /**
     * Move method. takes in an x and y and sets parts of the virtual board to true or false.
     * Adding or taking away points as required. Currently incomplete.
     * @param x
     * Takes in the x coordinate of the virtual button.
     * @param y
     * Takes in the y coordinate of the virtual button.
     * @param mrkMode
     * takes in whether mrkMode is on.
     * @return
     * Returns the new point total.
     */
    public String move(int x, int y, boolean mrkMode) {
    	/**
    	 * The new score after method runs.
    	 */
    	System.out.println("Test4");
    	
    	String newScore = "0";
    	
    	/**
    	 * Checking if markmode is activated.
    	 */
    	if(mrkMode) {
    		return newScore;
    	} else {
    		
    		/**
    		 * Checking if the board data is true and incrementing score if yes.
    		 */
    		if(boardData[x][y])
    			/**
    			 * Incrementing score.
    			 */
    			score++;
    		else {
    			score--;
    		}
    		/**
    		 * Toggling part of boardData.
    		 */
    		toggle(boardData, x, y);
    		
    		/**
    		 * Setting new score to score, as a String.
    		 */
    		newScore = Integer.toString(score);
    		
    		/**
    		 * Returning the newScore.
    		 */
    		return newScore;
    	}
    }
    
    /**
     * Method to flip a boolean from true to false or vice versa.
     * @param b
     * Method takes in a boolean.
     * @return
     * Method returns a flipped boolean.
     */
    static void toggle(boolean[][] board, int x, int y) {
    	board[x][y] = !board[x][y];
    }
    
    /**
     * Default constructor for GameModel class.
     */
	public GameModel(){}
}
