/*  
 *  Exercise 1.1.06
 */

public class exercise_1_1_06{
  
    /*
     * Function that print fibonacci serie
    */
    public static void fibonacci_series(){
        int f = 0;
        int g = 1;
        
        for(int i = 0; i <= 15; i++){
            StdOut.println(f);
            f = f + g;
            g = f - g;
        }
    }

    /*
     * Test function 
    */
    public static void main(String[] args) {
         fibonacci_series();
    }
}