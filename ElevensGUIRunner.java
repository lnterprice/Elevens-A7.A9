/**
 * This is a class that plays the GUI version of the Elevens game.
 * See accompanying documents for a description of how Elevens is played.
 */
public class ElevensGUIRunner {
  
  /**
   * Plays the GUI version of Elevens.
   * @param args is not used.
   */
  public static void main(String[] args){
    int[] pointValues = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0};
    int boardSize = 9;
    Board board = new ElevensBoard(pointValues, boardSize);
    CardGameGUI gui = new CardGameGUI(board);
    gui.displayGame();
  }
}
