
/****************************************************************************** 
 *   Exercise 1.3.04
 * 
 *   This file is released under the GNU General Public License, 
 *   version 3 (GPLv3).
 * 
 *   This file is based on these files: 
 *   
 *
 *   Compilation:  javac Parentheses.java
 *   Execution:    java Parentheses [()]{}{[()()]()}
 *                 java Parentheses [(])
 * 
 *   @author Koldo González
 *             
 *****************************************************************************/
 
import java.util.Iterator;

public class Parentheses {
    
  private final String OPEN_PARENTHESES = "(";
  private final String CLOSE_PARENTHESES = ")";
  private final String OPEN_SQUARE_BRACKET = "[";
  private final String CLOSE_SQUARE_BRACKET = "]";
  private final String OPEN_BRACE = "{";
  private final String CLOSE_BRACE = "}";
  
  private Stack<String> stack = new Stack<String>();
  
  // Constructor
  public Parentheses( String str ){
      for ( int i = 0; i < str.length(); i++){
          String temp = str.substring(i, i+1);
          if ( this.is_sign(temp) )   stack.push(temp);
      } 
  }

  // Filter char variable types to only acept the defined signs
  private boolean is_sign(String s){
      if ( s.equals( OPEN_PARENTHESES ) || s.equals(  CLOSE_PARENTHESES ) ||
           s.equals( OPEN_SQUARE_BRACKET ) || s.equals( CLOSE_SQUARE_BRACKET ) ||
           s.equals( OPEN_BRACE ) || s.equals( CLOSE_BRACE ) ) {
          return true;
      }
      return false;
  }
  
  // Checks if the signs have a logical order
  public boolean is_balanced(){
     
      Stack<String> temp = new Stack<String>();
      Iterator<String> itr = stack.iterator();
     
      while ( itr.hasNext() ) {
          
          String s = itr.next();
          if ( temp.isEmpty() ){ 
              temp.push( s );
              continue; 
          }
          
          String first = s;
          String last = temp.peek();
          
          if ( ( first.equals( OPEN_BRACE ) && last.equals( CLOSE_BRACE ) ) ||
               ( first.equals( OPEN_SQUARE_BRACKET ) && last.equals( CLOSE_SQUARE_BRACKET ) ) ||
               ( first.equals( OPEN_PARENTHESES ) && last.equals( CLOSE_PARENTHESES ) )
          ){
              temp.pop(); // Delete from temp
              continue;
          }else{
              temp.push(s);
          }
      }
      
      if ( temp.isEmpty() )
          return true;
      return false;
      
  }
    
  /*
   * Test function
  */
  public static void main(String[] args) {   
      String str = args[0];
      Parentheses a = new Parentheses(str);
      StdOut.println( str + " is balanced: " + a.is_balanced() );
  }
}