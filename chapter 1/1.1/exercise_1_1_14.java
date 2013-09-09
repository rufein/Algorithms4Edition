/*  
 *  Exercise 1.1.14
 */

public class exercise_1_1_14{

    /*
     * Function that calculates the largest int not larger
     * than the base-2 log of n
    */
    public static int lg(int n){
        int result = 0;
        if( n > 0){
            while( n >= 2){
                n /= 2;
                result ++;
            }    
            return result - 1;
        }else{
            return -2;
        }
    }
    
    /*
     *  Function to print the values
    */
    public static void print_value(int n, int result){
        if(result >= -1 && n > 0){
            System.out.println( "I send - " + n + " - like argument. The largest int not larger than the base-2 log is " + result );
        }else{
            System.out.println("Number: " + n + " // We can't calculate the logarithm of negative numbers ot the number - 0 -" );
        }
    }
    
    /*
     * Test function 
    */
    public static void main(String[] args) {
       print_value(3, lg(3));
       print_value(-2, lg(-2));
       print_value(5, lg(5));
       print_value(0, lg(0));
    }
}