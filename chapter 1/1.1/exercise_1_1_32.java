/****************************************************************************** 
 *   Exercise 1.1.32
 * 
 *   This file is released under the GNU General Public License, 
 *   version 3 (GPLv3).
 * 
 *   This file is based on these files: 
 *
 *   Compilation:  javac exercise_1_1_32.java
 *   Execution:    java exercise_1_1_32 4 4.12 92.54 tinyT.txt
 *  
 *   @author Koldo González
 *             
 *****************************************************************************/


public class exercise_1_1_32 {
   
  /*
   * Function to draw an histogram
   */
    public static void histogram( int N, double l, double r, int[] streaming ){
       
        
        int diff = (int) Math.ceil( Math.abs((r - l) / N ));
        
        double min = Math.min(r, l);
        double max = Math.max(r, l);
        
        int[] list = intervals( N, diff, min, max, streaming );
        
        double greatest_value = (double) greatest_value_array(list);
        
        for(int i = 0; i < diff; i++){
            double d = list[i] / greatest_value;
            double x = 1.0*i/diff;
            double y = d / 2.0;
            double rw = 0.5/diff;
            double rh = d / 2.0;
            
            StdDraw.filledRectangle( x, y, rw, rh);
        }    
    }
  
  /*
   * Count the times that an interval appear in an array
  */
    public static int[] intervals(int N, int diff, double min, double max, int[] streaming ){
    
      int[] list = new int[diff];  
      
      // Initial value
      for( int i = 0; i < list.length; i++){
          list[i] = 0;
      }
      
      // Count values
      for( int i = 0; i < streaming.length; i++){
          
          if( streaming[i] > min && streaming[i] < max ){
             int index = (int) Math.floor((streaming[i] - min )/ N);
             System.out.println( index + " // " +  streaming[i] );
             list[index]++;
          }
      }
      
      return list;
    }
    
  /*
   * Get the gratest value in array
   */
    public static int greatest_value_array(int[] list){
        int greatest_val = 0;
        for( int i = 0; i < list.length; i++ ){
            if( list[i] > greatest_val){
                greatest_val = list[i];
            }
        }
        return greatest_val;
    }

  /*
   * Test function
  */
  public static void main(String[] args) {
      
      int N = Integer.parseInt(args[0]);
      double l = Double.parseDouble(args[1]);
      double r = Double.parseDouble(args[2]);
      
      // Streaming
      In in = new In(args[3]);
      int[] list = in.readAllInts();
      
      histogram( N, l, r, list );
      
  }
}