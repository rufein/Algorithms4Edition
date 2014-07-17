/****************************************************************************** 
 *   Exercise 1.1.30
 * 
 *   This file is released under the GNU General Public License, 
 *   version 3 (GPLv3).
 * 
 *   This file is based on these files: 
 *
 *   Compilation:  javac exercise_1_1_30.java
 *   Execution:    java exercise_1_1_30 10 10
 * 
 *   @author Koldo González
 *             
 *****************************************************************************/

import java.util.Arrays;

public class exercise_1_1_30 {
   
    /*
     * Function that create an array with boolean values
     * 
     * 
    */
    public static boolean[][] create_array(int x, int y){
        boolean[][] array = new boolean[x][y];
        for(int i = 0; i < x; i++){
            for( int h = 0; h < y ; h++){
                int result = 1;
                if( i > h ) result = euclid_alg(i + 1, h + 1);
                if( i < h ) result = euclid_alg(h + 1, i + 1);
               
                // System.out.println("i: " + (i + 1) + " / h: " + (h + 1) + " / gcd: " + result );
                if( result > 1 ){
                    array[i][h] = false;
                }else{
                    array[i][h] = true;
                }
            }
        }
        return array;
    }
    
    /*
     * Function to calculate the greatest common divisor
     */
     public static int euclid_alg(int hi, int lo) {
        int result = -1;
        if( hi > lo){
            int remainder = hi % lo;
            if( remainder == 0 ){
                result = lo;
            }
            else if( remainder != 0 ){
                result = euclid_alg( lo, remainder );
            }    
        }
        return result;
    }
    
     /*
     * Function that print a visual map of values
    */
    public static String visual_map( boolean[][] a){
        String map = "";
        for (int i = 0; i < a.length; i++){
            for(int h = 0; h < a[i].length; h++){
                if( a[i][h] ){
                    map += "O";
                }else{
                    map += "X";
                }
                if(h == ( a[i].length - 1 )){
                    map += "\n";
                }
            } 
        }
        return map;
    }
  

  /*
   * Test function
  */
  public static void main(String[] args) {
      
      int a = Integer.parseInt(args[0]);
      int b = Integer.parseInt(args[1]);
      
      boolean[][] array = create_array(a, b);
      System.out.println(visual_map(array));
       
  }
}