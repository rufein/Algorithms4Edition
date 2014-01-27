
/****************************************************************************** 
 *   Exercise 1.1.16
 * 
 *   This file is released under the GNU General Public License, 
 *   version 3 (GPLv3).
 * 
 *   This file is based on these files: 
 *   
 *
 *   Compilation:  javac exercise_1_1_16.java
 *   Execution:    java exercise_1_1_16
 * 
 *   @author Koldo González
 *             
 *****************************************************************************/

public class exercise_1_1_16{

    /*
     * Function that has been given by the exercise 
    */
    public static String exR1(int n){
        if( n <= 0) return "";
        return exR1(n-3) + n + exR1(n-2) + n;
    }
    
    /*
     * Test function 
    */
    public static void main(String[] args) {
       System.out.println(exR1(6));
    }
}