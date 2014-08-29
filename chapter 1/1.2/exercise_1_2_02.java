/****************************************************************************** 
 *   Exercise 1.2.02
 * 
 *   This file is released under the GNU General Public License, 
 *   version 3 (GPLv3).
 * 
 *   This file is based on these files: 
 * 
 *
 *   Compilation:  javac exercise_1_2_02.java
 *   Execution:    java exercise_1_2_02 10
 * 
 *   @author Koldo González
 *             
 *****************************************************************************/
 

public class exercise_1_2_02 {
   
   
  /*
   * Test function
  */
  public static void main(String[] args) {
      
      int n = Integer.parseInt(args[0]);
       
      Interval1D[] intervals = new Interval1D[n];
      
      // Generate intervals
      for (int i = 0; i < n; i++){
          double x = StdRandom.uniform(); // x
          double y  = StdRandom.uniform(); // y
          double max = Math.max(x, y);
          double min = Math.min(x, y);
          Interval1D ni = new Interval1D(min, max);
          intervals[i] = ni;
      }
      
      for ( int i = 0; i < intervals.length; i++ ){
          Interval1D first = intervals[i];
          for ( int h = ( intervals.length - 1 )- i; h > 0 ; h--){
              Interval1D second = intervals[h];
              if ( first.intersects(second)){
                  // Screen print
                  StdOut.println( "Intersect between: [ " + first.left() + " , " + first.right() + " ] and [" +  second.left() + " , " + second.right() + "]"  );
                   
                  // draw
                  StdDraw.line( first.left(), first.right(), second.left(), second.right() );
              }
              
          }
      }
      
      
  }
}