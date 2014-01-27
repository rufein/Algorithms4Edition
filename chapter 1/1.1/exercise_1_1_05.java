
/****************************************************************************** 
 *   Exercise 1.1.05
 * 
 *   This file is released under the GNU General Public License, 
 *   version 3 (GPLv3).
 * 
 *   This file is based on these files: 
 *   
 *
 *   Compilation:  javac exercise_1_1_05.java
 *   Execution:    java exercise_1_1_05
 * 
 *   @author Koldo González
 *             
 *****************************************************************************/

public class exercise_1_1_05{
  
    /*
     * Function that check if the input values are between 0 and 1 
    */
    public static boolean check_double ( double x, double y){
        if( (0 < x) && (x < 1) && (0 < y) && (y < 1) ){
            return true;
        }else{
            return false;
        }
    }
    
    /*
     * Function that print value
    */
    public static void print_value(boolean check) {
        if (check){
             System.out.println ("The input values are strictly between 0 and 1");
             System.out.println ("----------------------------");
        }else{
             System.out.println ("The input values are out of scope");
             System.out.println ("----------------------------");
        }
    }

    /*
     * Test function 
    */
    public static void main(String[] args) {
        print_value(check_double(0.24, 0.67));
        print_value(check_double(5.27, 0.67));
    }
}