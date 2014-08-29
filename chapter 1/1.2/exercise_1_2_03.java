/****************************************************************************** 
 *   Exercise 1.2.03
 * 
 *   This file is released under the GNU General Public License, 
 *   version 3 (GPLv3).
 * 
 *   This file is based on these files: 
 * 
 *
 *   Compilation:  javac exercise_1_2_03.java
 *   Execution:    java exercise_1_2_03 10 0.2 0.7
 * 
 *   @author Koldo González
 *             
 *****************************************************************************/
 

public class exercise_1_2_03 {
   
  /*
   * Compare 2 intervals.
  */
    public static boolean contains( Interval2D a, Interval1D bx, Interval1D by){
        
        Point2D corner_1 = new Point2D ( bx.left() , bx.right() );
        Point2D corner_2 = new Point2D ( by.left() , bx.right() );
        Point2D corner_3 = new Point2D ( bx.left() , by.right() );
        Point2D corner_4 = new Point2D ( by.left() , by.right() );
        
        if ( a.contains( corner_1 ) && a.contains( corner_2 ) && a.contains( corner_3 ) && a.contains( corner_4 ) ){
            return true;
        }else{
            return false;
        }
    
    }
    
  /*
   * Test function
  */
  public static void main(String[] args) {
      
      int n = Integer.parseInt(args[0]);
      double min = Double.parseDouble(args[1]);
      double max = Double.parseDouble(args[2]);
      
      Interval1D[][] interval1d = new Interval1D[n][2];
      Interval2D[] intervals = new Interval2D[n];
      
      // Generate 2d intervals
      for (int i = 0; i < n; i++){
          double x1 = StdRandom.uniform( min, max); // x
          double y1  = StdRandom.uniform(min, max); // y
          double x2 = StdRandom.uniform( min, max); // x
          double y2  = StdRandom.uniform(min, max); // y
          double max1 = Math.max(x1, y1);
          double min1 = Math.min(x1, y1);
          double max2 = Math.max(x2, y2);
          double min2 = Math.min(x2, y2);
          interval1d[i][0] = new Interval1D(min1, max1);
          interval1d[i][1] = new Interval1D(min2, max2);
          intervals[i] = new Interval2D( interval1d[i][0] , interval1d[i][1]);
      }
      
      // print intervals
      for (int i = 0; i < n; i++){
          Interval2D inter = intervals[i];
          inter.draw();
      }
      
      // Intersects
      for ( int i = 0; i < intervals.length; i++ ){
          Interval2D first = intervals[i];
          for ( int h = ( intervals.length - 1 )- i; h > 0 ; h--){
              Interval2D second = intervals[h];
              if ( first.intersects(second)){
                  // Screen print
                  StdOut.println( "Intersect between: [ " + first + " ] and [" + second + "]"  );
                   
              }
              
          }
      }
      
      // contains
      for ( int i = 0; i < intervals.length; i++ ){
          for ( int h = 0; h < intervals.length; h++ ){
              if( i == h ){ continue; }
              Interval2D first = intervals[i];
              if( contains( intervals[i], interval1d[h][0] , interval1d[h][1] ) ){
                  // Screen print
                  StdOut.println( first + " contains " + intervals[h] );
              }
          }
      }
      
      
  }
}