
/****************************************************************************** 
 *   Exercise 1.3.11
 * 
 *   This file is released under the GNU General Public License, 
 *   version 3 (GPLv3).
 * 
 *   This file is based on these files: 
 *   
 *
 *   Compilation:  javac EvaluatePostfix.java
 *   Execution:    java EvaluatePostfix 1 2 3 + 4 5 x x +
 * 
 *   @author Koldo González
 *             
 *****************************************************************************/

import java.util.Iterator;

public class EvaluatePostfix {
    
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
    
    private Queue<String> expr = new Queue<String>();
   
    // Constructor
    public EvaluatePostfix( String str){
         String[] array = str.split(" ");
         for ( int i = 0; i < array.length; i++){
             expr.enqueue(array[i]);
         } 
    }
    
    // Proceess a Posrfiz ecpresion
    public void proccess_postfix(){
      
      Iterator<String> itr = expr.iterator();
      Stack<String> numbers = new Stack<String>();
      String s;
      double result;
      
      while ( itr.hasNext() ) {
        
          s = itr.next();   
          // Operations
          if ( s.equals(PLUS) || s.equals(MINUS) || s.equals(MULT) || s.equals(DIV) ) { 
              double b = Double.parseDouble( numbers.pop() );
              double a = Double.parseDouble( numbers.pop() );
              result = operation( a, b, s );
              numbers.push( Double.toString(result) );
          }
          else if( s.equals(SQRT) ){
              double b = Double.parseDouble( numbers.pop() );
              result = Math.sqrt( b );
              numbers.push( Double.toString(result) );
          }
          else{
              numbers.push(s);
          }
          
      }
      
      // Error 
      if ( numbers.size() > 1 ) {  throw new IllegalArgumentException("The expression has not been evaluated correctly"); }
      
      // Print
      String p = numbers.pop();
      StdOut.println( "Result is: " + p );
  
    }
 
    // Calculate the basis operations
    public double operation( double a, double b, String op ){
        
        double result = 0;
        
        if ( op.equals(PLUS) )
            result = a + b;
        
        else if ( op.equals(MINUS) )
            result = a - b;
        
        else if ( op.equals(MULT) )
            result = a * b;
        
        else if ( op.equals(DIV) )
            result = a / b;
        
        return result;
    } 
    
    
  /*
   * Test function
  */
  public static void main(String[] args) { 
      
      String str = "";
      for(int i = 0; i < args.length; i++)
          str = str + args[i] + " ";
      
      EvaluatePostfix ep = new EvaluatePostfix(str);
      ep.proccess_postfix();
  }
}