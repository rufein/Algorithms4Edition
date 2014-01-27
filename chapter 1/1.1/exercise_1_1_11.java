
/****************************************************************************** 
 *   Exercise 1.1.11
 * 
 *   This file is released under the GNU General Public License, 
 *   version 3 (GPLv3).
 * 
 *   This file is based on these files: 
 *   
 *
 *   Compilation:  javac exercise_1_1_11.java
 *   Execution:    java exercise_1_1_11
 * 
 *   @author Koldo González
 *             
 *****************************************************************************/

public class exercise_1_1_11{
    
    /*
     * Function that build a 2  dimensional boolean array
     * 
     * The array is filled with random boolean values
    */
    public static boolean[][] two_dimensional_array(int x, int y){
       boolean[][] a = new boolean[x][y];

       for(int i = 0; i < a.length; i++){
          int length = a[i].length;
          for(int h = 0; h < length; h++){
              // Random number between 0 and 1
              int number = StdRandom.uniform(2);
              if(number == 1){
                  a[i][h] = true;
              }else{
                  a[i][h] = false;
              } 
          }
       }
       return a;
    }
    
    /*
     * Function that print a boolean array
     */
    public static void boolean_array_print( boolean[][] a){
        for (int i = 0; i < a.length; i++){
            for(int h = 0; h < a[i].length; h++){
                String symbol = "";
                if( a[i][h] ){
                    symbol = "*";
                }else{
                    symbol = " ";
                }
                System.out.println( "Raw: " + i + " ; Column: " + h + " ; Value: " + symbol);
            }
        }
    }
    
    /*
     * Function that print a visual map of values
    */
    public static String visual_map( boolean[][] a){
        String map = "";
        for (int i = 0; i < a.length; i++){
            for(int h = 0; h < a[i].length; h++){
                if( a[i][h] ){
                    map += "*";
                }else{
                    map += " ";
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
       boolean[][] a = two_dimensional_array(10,10);
       System.out.println(visual_map(a));
       boolean_array_print(a);
    }
}