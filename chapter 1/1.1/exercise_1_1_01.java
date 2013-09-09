/*  
 *  Exercise 1.1.01
 */

public class exercise_1_1_01{
  
    /*
     * Section "a" of the exercise
     */
    public static void a_section(){
       System.out.println ("A: " + (0+15) / 2);
       value_type((0+15) / 2);
    }
    
    /*
     *  Section "b" of the exercise
    */
    public static void b_section(){
       System.out.println ("B: " + 2.0e-6 * 100000000.1);
        value_type(2.0e-6 * 100000000.1);
    }
     
    /*
     * Section "c" of the exercise
    */
    public static void c_section(){
        System.out.println ("C: " + (true && false || true && true));
        value_type(true && false || true && true);
    }

    /*
     * Function to know type of value
     */
    public static void value_type(int a){
        System.out.println ("The type of value is an Integer");
        System.out.println ("-------------------------------");
    }

    public static void value_type(double a){
        System.out.println ("The type of value is a Double");
        System.out.println ("-------------------------------");
    }

    public static void value_type(boolean a){
        System.out.println ("The type of value is a Boolean");
        System.out.println ("-------------------------------");
    }

    /*
     * Test function 
    */
    public static void main(String[] args) {
        a_section();
        b_section();
        c_section();
    }
}