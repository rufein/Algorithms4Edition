/*  
 *  Exercise 1.1.02
 */

public class exercise_1_1_02{
  
    /*
     * Section "a" of the exercise
     */
    public static void a_section(){
       System.out.println ("A: " + ( ( 1 + 2.236) / 2));
       value_type(((1 + 2.236)/2));
    }
    
    /*
     *  Section "b" of the exercise
    */
    public static void b_section(){
       System.out.println ("B: " + ( 1 + 2 + 3 + 4.0 ));
        value_type( 1 + 2 + 3 + 4.0 );
    }
     
    /*
     * Section "c" of the exercise
    */
    public static void c_section(){
        System.out.println ("C: " + ( 4.1 >= 4 ));
        value_type( 4.1 >= 4 );
    }
    
     /*
     * Section "d" of the exercise
    */
    public static void d_section(){
        System.out.println ("D: " + ( 1 + 2 + "3" ));
        value_type( 1 + 2 + "3" );
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
    
     public static void value_type(String a){
        System.out.println ("The type of value is a String");
        System.out.println ("-------------------------------");
    }

    /*
     * Test function 
    */
    public static void main(String[] args) {
        a_section();
        b_section();
        c_section();
        d_section();
    }
}