
/****************************************************************************** 
 *   Exercise 1.1.04
 * 
 *   This file is released under the GNU General Public License, 
 *   version 3 (GPLv3).
 * 
 *   This file is based on these files: 
 *   
 *
 *   Compilation:  javac exercise_1_1_04.java
 *   Execution:    java exercise_1_1_04
 * 
 *   @author Koldo González
 *             
 *****************************************************************************/

public class exercise_1_1_04{
  
   /*
     * Section "a" of the exercise
     */
    public static int a_section(int a, int b){
        int c = 1;
        // Original statement: if(a > b) then c = 0;
        // Incorrect use of the word -then-
        if(a > b) c = 0; 
        return c;
    }
    
    /*
     *  Section "b" of the exercise
    */
    public static int b_section(int a, int b){
        int c = 1;
        // Original statement: a > b { c = 0; }
        if (a > b) { c = 0; }
        return c;
    }
     
    /*
     * Section "c" of the exercise
    */
    public static int c_section(int a, int b){
       int c = 1;
       if (a > b) c = 0; 
       return c;
    }
    
     /*
     * Section "d" of the exercise
    */
    public static int d_section(int a, int b){
       int c = 1;
       // Original statement: if (a > b) c = 0 else b = 0 
       if (a > b) c = 0; else b = 0; 
       return c;
    }

    /*
     * Function to print values
     */
    public static void print_value(int c){
        System.out.println ("Value is : " + c);
        System.out.println ("-------------------------------");
    }

    /*
     * Test function 
    */
    public static void main(String[] args) {
        print_value(a_section( 3 , 2 ));
        print_value(b_section( 2 , 3 ));
        print_value(c_section( 3 , 2 ));
        print_value(d_section( 2 , 3 ));
    }
}