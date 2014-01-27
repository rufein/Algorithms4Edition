
/****************************************************************************** 
 *   Exercise 1.1.12
 * 
 *   This file is released under the GNU General Public License, 
 *   version 3 (GPLv3).
 * 
 *   This file is based on these files: 
 *   
 *
 *   Compilation:  javac exercise_1_1_12.java
 *   Execution:    java exercise_1_1_12
 * 
 *   @author Koldo González
 *             
 *****************************************************************************/

public class exercise_1_1_12{

    /*
     * Code fragment in the bookint[] 
     */
    public static void code_fragment(){
        int[] a = new int[10];
        for(int i = 0; i < 10 ; i++){
            a[i] = 9 - i;
            // Custom code to print values
            print_value(i, a[i]);
        }
        for(int i = 0; i < 10 ; i++){
            a[i] = a[a[i]];
            // Custom code to print values
            print_value(i, a[i]);
        }
        for(int i = 0; i < 10 ; i++){
            System.out.println(i);
        }
    }
    
    public static void print_value(int key, int value){
        System.out.println("Key: " + key + " ; Value: " + value);
    }
    
    /*
     * Explanation 
    */
    public static void explanation(){
        System.out.println("In the first loop, the code assing values form 9 to 0");
        System.out.println("Example: array[0] => 9 ;  array[1] => 8 ; ...");
        System.out.println("In the second loop, the code invert the values. and last value becomes the first");
        System.out.println("Example: array[0] => 0 ;  array[1] => 1 ; ...");
        System.out.println("In the third loop, the code prints the variable -i-");
    }
    
    /*
     * Test function 
    */
    public static void main(String[] args) {
      explanation();
      code_fragment();
    }
}