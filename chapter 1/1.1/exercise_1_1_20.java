/*  
 *  Exercise 1.1.20
 */

import java.lang.Math;

public class exercise_1_1_20{
    
    /*
     * Recursive function that computes ln(N!)
     * 
     * Remember that property of logaritms with the same base:
     *  log(6 * 5) = log 6 + log 5
    */
    public static double recursive_ln(int n){ 
        double total = 0;
        total +=  recursive_ln(n, total);   
        return total;
        
    }

    public static double recursive_ln(int n, double sum){
        if( n > 0 ){
            double m = (double) n;
            sum +=  Math.log( m );
            double total = recursive_ln(--n, sum);
            return total;
        }else{
            return sum;
        }
    }
    
    
    /*
     * function that computes ln(N!) 
    */
    public static double quick_ln(int n){
        if( n > 0 ){
            int value = n;
            for( int h = (n - 1) ; h > 0; h--){
                value *= h;
            }
            double d = (double) value;
            return Math.log( d );
        }else{
            return 0;
        }
    }
     
    /*
     * Test function 
    */
    public static void main(String[] args) {
        System.out.println("Recursive method: " + recursive_ln(10));
        System.out.println("Quick method: " + quick_ln(10));
    }
}