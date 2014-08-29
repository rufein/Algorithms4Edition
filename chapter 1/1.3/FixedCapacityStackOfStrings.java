
/****************************************************************************** 
 *   Exercise 1.3.01
 * 
 *   This file is released under the GNU General Public License, 
 *   version 3 (GPLv3).
 * 
 *   This file is based on these files: 
 *   http://algs4.cs.princeton.edu/13stacks/FixedCapacityStackOfStrings.java.html
 *
 *   Compilation:  javac FixedCapacityStackOfStrings.java
 *   Execution:    java FixedCapacityStackOfStrings 
 * 
 *   @author Koldo González
 *             
 *****************************************************************************/


public class FixedCapacityStackOfStrings {
  
  private String[] str; // Top of stack
  private int N; // Number of items
  
  // Constructor
  public FixedCapacityStackOfStrings( int N){
      // Fixed capacity
      this.str = new String[N];
  }
  
  public boolean isEmpty(){ return (N == 0); }
  public boolean isFull(){ return (N == str.length);}
  
  public void push( String string){
      int n = N++;
      str[n] = string;
  }
  
  public String pop(){
      N--;
      return str[N];
  }
   
  /*
   * Test function
  */
  public static void main(String[] args) {   
      
  }
}