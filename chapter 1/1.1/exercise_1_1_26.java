
/****************************************************************************** 
 *   Exercise 1.1.26
 * 
 *   This file is released under the GNU General Public License, 
 *   version 3 (GPLv3).
 * 
 *   This file is based on these files: 
 *
 *   Compilation:  javac exercise_1_1_26.java
 *   Execution:    java exercise_1_1_26 45 23 12
 * 
 *   @author Koldo González
 *             
 *****************************************************************************/

public class exercise_1_1_26 {

   /*
    * Function to sort 3 numbers
    */
    public static void sort_numbers(int a, int b, int c){
        int t;
        if (a > b){
            t = a;
            a = b;
            b = t;
        }
        if(a > c){
            t = a;
            a = c;
            c = t;
        }
        if(b > c){
            t = b;
            b = c;
            c = t;
        }
        
        print_values( 0, a);
        print_values( 1, b);
        print_values( 2, c);
    }
    
    /*
     * FUnction to printi the key and number
     */
    public static void print_values(int key, int value){
        StdOut.printf("key %s ; Number %s \n", key, value);
    }

    /*
     *  Test function
     */
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);
        sort_numbers(a, b, c);
    }
}