/****************************************************************************** 
 *   Exercise 1.1.31
 * 
 *   This file is released under the GNU General Public License, 
 *   version 3 (GPLv3).
 * 
 *   This file is based on these files: 
 *
 *   Compilation:  javac exercise_1_1_31.java
 *   Execution:    java exercise_1_1_31 10 0.8
 *                 java exercise_1_1_31 15 0.2
 * 
 *   @author Koldo González
 *             
 *****************************************************************************/

public class exercise_1_1_31 {
   
  /* 
  * Function to draw a circle
  */
  public static void draw_circle( int N, double p){
      double center_x = .5;
      double center_y = .5;
      double radius = .5;
      
      StdDraw.circle( center_x, center_y, radius);
      
      double interval = 360 / N;
      double radians = (Math.PI / 180) * interval;
      double[][] coordenates = new double[N][2];
      
      // Draw points
      StdDraw.setPenColor(StdDraw.MAGENTA);
      for(int i = 0; i < N ; i++ ){
          double degrees = i * radians;
          double c[] = coordenates( center_x, center_y, radius, degrees );
          coordenates[i][0] = c[0];
          coordenates[i][1] = c[1];
          StdDraw.circle(c[0], c[1], .02);
      }
      
      // Draw lines
      StdDraw.setPenColor(StdDraw.GRAY);
      for(int i = 0; i < N ; i++ ){
          for( int h = N - 1; h > i; h--){
              if( probability(p) ) StdDraw.line( coordenates[i][0], coordenates[i][1], coordenates[h][0], coordenates[h][1]);
          }
      }
  }
  
  /*
   * 
  */
  public static double[] coordenates(double center_x, double center_y, double radius, double degrees){
      
      double x = radius * Math.cos(degrees) + center_x;
      double y = radius * Math.sin(degrees) + center_y;
      
      double[] result = new double[2];
      result[0] = x;
      result[1] = y;
      
      return result;
  }
  
  /*
   * 
   */
  public static boolean probability(double p){
     
      double random = StdRandom.random();
      if( p >= random) return true;
      else return false;
  }

  /*
   * Test function
  */
  public static void main(String[] args) {
      
     int N = Integer.parseInt(args[0]);
     double p = Double.parseDouble(args[1]);
     
     draw_circle(N, p);
     
  }
}