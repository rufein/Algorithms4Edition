
/****************************************************************************** 
 *   Exercise 1.1.08
 * 
 *   This file is released under the GNU General Public License, 
 *   version 3 (GPLv3).
 * 
 *   This file is based on these files: 
 *   
 *
 *   Compilation:  javac exercise_1_1_08.java
 *   Execution:    java exercise_1_1_08
 * 
 *   @author Koldo González
 *             
 *****************************************************************************/

public class exercise_1_1_08{
  
    /*
     * Section "a" of the exercise
    */
    public static void a_section(){
        System.out.println("------- A Section -------");
        System.out.println('b');
    }
    
    /*
     *  Section "b" of the exercise
    */
    public static void b_section(){
        System.out.println("------- B Section -------");
        System.out.println('b' + 'c');
    }
     
    /*
     * Explanation of section "b" 
    */
    public static void b_explanation(){
        System.out.println("------ Explanation B section ---------");
        
        // FIST STATEMENT   
        // Note the difference between both statements
        System.out.println("First statement with single quotes: \'b\' + \'c\'" );
        System.out.println('b' + 'c'); 
        System.out.println("They are -char- primitive type that has been converted to a -byte- primitive type to make the sum");
        
        // Check if the sentence is correct
        char b = 'b';
        char c = 'c';
        System.out.println("Cast from a -char- type to a -byte- type: ");
        System.out.println((byte) b);
        System.out.println((byte) c);
        System.out.println("Sum of both values: ");
        System.out.println((byte) b + (byte) c);
        System.out.println(" ");
        
        // SECOND STATEMENT 
        System.out.println("Second statement with doubled quotes: \"b\" + \"c\"" );
        System.out.println("b" + "c");
        System.out.println("They are string type and they have been concatenated");
        
        // Check if the sentence is correct
        if ("b" + "c" instanceof String){
            System.out.println("It's a String type");
        }else{
            System.out.println("It's not a String type");
        }
    }
    
    /*
     * Section "c" of the exercise
    */
    public static void c_section(){
       System.out.println("------- C Section -------");
       System.out.println((char)('a' + 4));
    }
    
    /*
     * Explanation Section "b" 
    */
    public static void c_explanation(){
        System.out.println("------- C Explanation -------");
        System.out.println("First, the \'a\' is converted to a -byte- primitive type: ");
        System.out.println((byte)'a');
        System.out.println("After that, the sum is procesed: ");
        System.out.println('a' + 4);
        System.out.println("Finally, a casting from -byte- type to -char- type: ");
        System.out.println((char)('a' + 4));
    }
     
    /*
     * Test function 
    */
    public static void main(String[] args) {
        a_section();
        b_section();
        b_explanation();
        c_section();
        c_explanation();
    }
}