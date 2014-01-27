
/****************************************************************************** 
 *   Exercise 1.1.13
 * 
 *   This file is released under the GNU General Public License, 
 *   version 3 (GPLv3).
 * 
 *   This file is based on these files: 
 *   
 *
 *   Compilation:  javac exercise_1_1_13.java
 *   Execution:    java exercise_1_1_13
 * 
 *   @author Koldo González
 *             
 *****************************************************************************/

public class exercise_1_1_13{

    /*
     * Function that build a 2  dimensional Integers array
     * 
     * The array is filled with random values
    */
    public static int[][] two_dimensional_array(int x, int y){
       int[][] a = new int[x][y];

       for(int i = 0; i < a.length; i++){
          int length = a[i].length;
          for(int h = 0; h < length; h++){
              // Random number between 0 and 9
              int number = StdRandom.uniform(10);
              a[i][h] = number; 
          }
       }
       return a;
    }
    
    /*
     * Function that print a visual map of values
    */
    public static String visual_map( int[][] a){
        String map = "";
        for (int i = 0; i < a.length; i++){
            for(int h = 0; h < a[i].length; h++){
               map +=  a[i][h];
               if(h == ( a[i].length - 1 )){
                    map += "\n";
               }
            } 
        }
        return map;
    }
    
    /*
     * Function that mmake the transposition of an array
    */
    public static int[][] transposition ( int[][] a ){
        int x = a.length;
        int y = a[0].length;
        int[][] tranposition =  new int[x][y];
        for(int i = 0; i < a.length; i++){
            for(int h = 0; h < a[i].length; h++){
                tranposition[h][i] = a[i][h];
            }
        }
        return tranposition;
    }
    
    /*
     * Test function 
    */
    public static void main(String[] args) {
        int[][] array = two_dimensional_array(10,10);
        System.out.println(visual_map(array));
        array = transposition (array);
        System.out.println(visual_map(array));
    }
}