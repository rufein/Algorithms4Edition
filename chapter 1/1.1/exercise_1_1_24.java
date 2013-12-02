/*  
 *  Exercise 1.1.24
 */

/*
 *  Execution:
 * 
 *  java exercise_1_1_24 105 24
*/

public class exercise_1_1_24 {

    public static int euclid_alg(int hi, int lo) {
        int result = -1;
        if( hi > lo){
            int remainder = hi % lo;
            if( remainder == 0 ){
                result = lo;
            }
            else if( remainder != 0 ){
                result = euclid_alg( lo, remainder );
            }    
        }
        return result;
    }

    /*
     *  Test function
     */
    public static void main(String[] args) {
       String high = args[0];
       String low = args[1];
       
       // Casting
       int hi = Integer.parseInt(high);
       int lo = Integer.parseInt(low);
       
       if( lo > hi){
           int temp = hi;
           hi = lo;
           lo =  temp;
       }
       
       int result = euclid_alg( hi , lo );
       System.out.println("Greatest common divisor: " + result);
    }
}