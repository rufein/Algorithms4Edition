
/****************************************************************************** 
 *   Exercise 1.1.09
 * 
 *   This file is released under the GNU General Public License, 
 *   version 3 (GPLv3).
 * 
 *   This file is based on these files: 
 *   
 *
 *   Compilation:  javac exercise_1_1_09.java
 *   Execution:    java exercise_1_1_09
 * 
 *   @author Koldo González
 *             
 *****************************************************************************/

public class exercise_1_1_09{
    
    public static String integer_to_binary(int i){
        String s = "";
        for(int I = i ; I > 0 ; I /= 2){
            s= (I%2) + s;
        }
        return s;
    }
    
    /*
     * Test function 
    */
    public static void main(String[] args) {
        String binary =integer_to_binary(456);
        System.out.println("The binary of 456 is " + binary);
    }
}