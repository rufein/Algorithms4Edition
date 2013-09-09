/*  
 *  Exercise 1.1.16
 */

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