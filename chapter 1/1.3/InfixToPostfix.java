
/****************************************************************************** 
 *   Exercise 1.3.10
 * 
 *   This file is released under the GNU General Public License, 
 *   version 3 (GPLv3).
 * 
 *   This file is based on these files: 
 *   
 *
 *   Compilation:  javac InfixToPostfix.java
 *   Execution:    java InfixToPostfix ( 1 + ( ( 2 + 3 ) x ( 4 x 5 ) ) )
 *                 java InfixToPostfix ( ( 1 + 2 ) x ( ( 3 - 4 ) x ( 5 - 6 ) ) )
 * 
 *   @author Koldo González
 *             
 *****************************************************************************/

import java.util.Iterator;
import java.util.NoSuchElementException;

public class InfixToPostfix {
 
  // Parenthesis signs
  private final String OPEN_PARENTHESES = "(";
  private final String CLOSE_PARENTHESES = ")";
  private final String OPEN_SQUARE_BRACKET = "[";
  private final String CLOSE_SQUARE_BRACKET = "]";
  private final String OPEN_BRACE = "{";
  private final String CLOSE_BRACE = "}"; 
    
  // Arithmetic signs
  private final String PLUS = "+";
  private final String MINUS = "-";
  // private final String MULT = "*";
  //----------------------------------
  // I've had some problems with the command line arguments. The asterisk -*-
  // passes as arguments the name of every class in my folder that have been
  // compiled. 
  //___________________________________
  private final String MULT = "x";
  private final String DIV = "/";
  private final String SQRT = "sqrt";
  
  private Queue<String> expr = new Queue<String>(); // expresion 
  
  // Constructor
  public InfixToPostfix(String str){
      String[] array = str.split(" ");
      for ( int i = 0; i < array.length; i++){
          expr.enqueue(array[i]);
      } 
  }
  
  // 
  public void conversion_to_postfix(){
      
      Queue<String> postfix = new Queue<String>();   // Final postfix
      Stack<String> ops = new Stack<String>();       // Operators -> Temporal Stack to save the operators
      Iterator<String> itr = expr.iterator();
      
      while ( itr.hasNext() ) {
          
          String s = itr.next();
      
          if ( s.equals(OPEN_PARENTHESES) )      ops.push(s); 
          else if ( s.equals(PLUS) )             ops.push(s); 
          else if ( s.equals(MINUS) )            ops.push(s); 
          else if ( s.equals(MULT) )             ops.push(s); 
          else if ( s.equals(DIV) )              ops.push(s); 
          else if ( s.equals(CLOSE_PARENTHESES) ) { 
              
              // Throw error in case the expression has no closing parenthesis
              if( ops.isEmpty() )
                  throw new IllegalArgumentException("Parenthesis are not closed");
                 
              String o = ops.pop();
              while ( !ops.isEmpty() && !o.equals(OPEN_PARENTHESES)){
                  postfix.enqueue(o);  // Push to the final expresion    
                  o = ops.pop(); 
              }
              
              
          }else{
              postfix.enqueue(s);
          }  
      }
      
      if(!ops.isEmpty())
          throw new IllegalArgumentException("The operators Queue should be empty.");
      
      // Print
      StdOut.println(postfix.toString());
  }
  
  
  /*
   * Test function
  */
  public static void main(String[] args) { 
      
      String str = "";
      for(int i = 0; i < args.length; i++)
          str = str + args[i] + " ";
      
      InfixToPostfix itp = new InfixToPostfix(str);
      itp.conversion_to_postfix();
  }
  
}
  