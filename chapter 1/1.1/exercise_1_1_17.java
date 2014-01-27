
/****************************************************************************** 
 *   Exercise 1.1.17
 * 
 *   This file is released under the GNU General Public License, 
 *   version 3 (GPLv3).
 * 
 *   This file is based on these files: 
 *   
 *
 *   Compilation:  javac exercise_1_1_17.java
 *   Execution:    java exercise_1_1_17
 * 
 *   @author Koldo González
 *             
 *****************************************************************************/

public class exercise_1_1_17{

    /*
     * Function that has been given by the exercise 
    */
    public static String exR2(int n){
        String s = exR2(n-3) + n + exR2(n-2) + n;
        if( n <= 0) return "";
        return s;
    }
    
    /*
     * Test function 
    */
    public static void main(String[] args) {
       System.out.println(exR2(6));
    }
}