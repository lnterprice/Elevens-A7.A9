import java.util.ArrayList;
/**
 * This class provides a convenient way to test shuffling methods.
 */
public class Shuffler {
  
  /**
   * The number of consecutive shuffle steps to be performed in each call
   * to each sorting procedure.
   */
  
  
  /**
   * Tests shuffling methods.
   * @param args is not used.
   */
  public static void main(String[] args) {
  }
  
  
  /**
   * Apply a "perfect shuffle" to the argument.
   * The perfect shuffle algorithm splits the deck in half, then interleaves
   * the cards in one half with the cards in the other.
   * @param values is an array of integers simulating cards to be shuffled.
   */
  public static void perfectShuffle(ArrayList<Card> values) {
    ArrayList<Card> newValues = new ArrayList<Card>();
    for(int i = 0; i < values.size(); i++){
      newValues.add(i, null);
    }
    int counter = 0;
    for(int i = 0; i < values.size(); i += 2){
      newValues.set(i, values.get(counter));
      counter++;
    }
    for(int i = 1; i < values.size(); i += 2){
      newValues.set(i, values.get(counter));
      counter++;
    }
    for(int i = 0; i < values.size(); i++){
      newValues.set(i, values.get(counter));
    }
    
    
  }
  
  /**
   * Apply an "efficient selection shuffle" to the argument.
   * The selection shuffle algorithm conceptually maintains two sequences
   * of cards: the selected cards (initially empty) and the not-yet-selected
   * cards (initially the entire deck). It repeatedly does the following until
   * all cards have been selected: randomly remove a card from those not yet
   * selected and add it to the selected cards.
   * An efficient version of this algorithm makes use of arrays to avoid
   * searching for an as-yet-unselected card.
   * @param values is an array of integers simulating cards to be shuffled.
   */
  public static ArrayList<Card> selectionShuffle(ArrayList<Card> values) {
    ArrayList<Card> newValues = new ArrayList<Card>();
    for(int i = 0; i < values.size(); i++){
      newValues.add(values.get(i));
    }
    for(int i = 0; i < values.size(); i++){
      int placeholder = (int)(Math.random() * values.size());
      while(newValues.get(placeholder) == null){
        placeholder = (int)(Math.random() * values.size());
      }
      values.set(i, newValues.get(placeholder));
      newValues.set(placeholder, null);
    }
    return newValues;
  }
  
  public static String flip(){
    int i = (int)(Math.random() * 3);
    if(i >= 1){
      return "heads";
    }
    else
      return "tails";
  }
  
  public static boolean arePermutations(String[] first, String[] second){
    String[] a = new String[first.length];
    String[] b = new String[second.length];
    int isActuallyPermCounter = 0;
    for(int i = 0; i < first.length; i++){
      a[i] = first[i];
      b[i] = second[i];
      if(a[i].equals(b[i])){
        isActuallyPermCounter++;
      }
    }
    if(isActuallyPermCounter == a.length){
      return false;
    }
    for(int i = 0; i < a.length; i++){
      int counter = 0;
      boolean charNF = true;
      int placeholder = 0;
      while(charNF && counter != a.length){
        if(!a[counter].equals("") || !b[i].equals("") && !charNF){
          if(a[counter].equals(b[i])){
            placeholder = counter;
            charNF = false;
          }
        }
        counter++;
      }
      if(!charNF){
        if(placeholder == a.length)
          a[placeholder-1] = "";
        else
          a[placeholder] = "";
        b[i] = "";
      }
      else
        return false;
    }
    return true;
  }
}