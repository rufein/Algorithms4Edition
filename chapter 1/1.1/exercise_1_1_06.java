
/****************************************************************************** 
 *   Exercise 1.1.06
 * 
 *   This file is released under the GNU General Public License, 
 *   version 3 (GPLv3).
 * 
 *   This file is based on these files: 
 *   
 *
 *   Compilation:  javac exercise_1_1_06.java
 *   Execution:    java exercise_1_1_06
 * 
 *   @author Koldo González
 *             
 *****************************************************************************/

public class exercise_1_1_06{
  
    /*
     * Function that print fibonacci serie
    */
    public static void fibonacci_series(){
        int f = 0;
        int g = 1;
        
        for(int i = 0; i <= 15; i++){
            StdOut.println(f);
            f = f + g;
            g = f - g;
        }
    }

    /*
     * Test function 
    */
    public static void main(String[] args) {
         fibonacci_series();
    }
}