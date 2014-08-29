
/****************************************************************************** 
 *   Exercise 1.2.01
 * 
 *   This file is released under the GNU General Public License, 
 *   version 3 (GPLv3).
 * 
 *   This file is based on these files: 
 * 
 *
 *   Compilation:  javac exercise_1_2_01.java
 *   Execution:    java exercise_1_2_01 10
 * 
 *   @author Koldo González
 *             
 *****************************************************************************/


public class exercise_1_2_01 {
   
   /*
    * Print the points
   */
   public static void print_points( double[][] p , double[][] c_p ){
       for( int i = 0; i < p.length; i++){
           StdDraw.point( p[i][0], p[i][1] );
       }
       
       StdDraw.line( c_p[0][0], c_p[0][1], c_p[1][0], c_p[1][1] );
      
   }
   
  /*
   * Test function
  */
  public static void main(String[] args) {
      
      int n = Integer.parseInt(args[0]);
      
      double[][] points = new double[n][2];
      
      // Generate Points
      for (int i = 0; i < n; i++){
          points[i][0] = StdRandom.uniform(); // x
          points[i][1]  = StdRandom.uniform(); // y
      }
      
      // Calculate distance between points
      double distance = 2;
      double[][] closest_points = new double[2][2];
      
      for ( int i = 0; i < points.length; i++ ){
          Point2D first = new Point2D( points[i][0], points[i][1]);
          for ( int h = ( points.length - 1 )- i; h > 0 ; h--){
              Point2D second = new Point2D( points[h][0], points[h][1]);
              double d = first.distanceTo( second );
              if ( d < distance ){
                  closest_points[0] = points[i];
                  closest_points[1] = points[h];
              }
          }
      }
      
      // Screen print
      StdOut.println( "Point 1 => x = " + closest_points[0][0] + " / y = " +  closest_points[0][1] );
      StdOut.println( "Point 2 => x = " + closest_points[1][0] + " / y = " +  closest_points[1][1] );
      
      // Print points
      print_points( points, closest_points );
  }
}