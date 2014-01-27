
/****************************************************************************** 
 *   Exercise 1.1.19
 * 
 *   This file is released under the GNU General Public License, 
 *   version 3 (GPLv3).
 * 
 *   This file is based on these files: 
 *   
 *
 *   Compilation:  javac exercise_1_1_19.java
 *   Execution:    java exercise_1_1_19
 * 
 *   @author Koldo González
 *             
 *****************************************************************************/

import java.math.BigInteger;

public class exercise_1_1_19{

    /*
     * Function that has been given by the exercise 
    */
    public static long F(int n){
        if( n == 0) return 0;
        if( n == 1) return 1;
        return F(n-1) + F(n-2);
    }
    
    /*
     * A better implemention of the previous function 
    */
    public static long better_F(long[] sequence, int index){
        return sequence[index - 1] + sequence[index - 2];
    }
    
    /*
     * A better implemention of the previous function 
    */
    public static BigInteger much_better_F(BigInteger[] sequence, int index){
        return sequence[index - 1].add(sequence[index - 2]);
    }
     
    /*
     * Test function 
    */
    public static void main(String[] args) {
        long[] sequence = new long[100];
        for(int n = 0; n < 100; n++){
            long result = (n > 1) ? better_F(sequence, n) : F(n);
            sequence[n] = result;
            StdOut.println(n + " " + result);
        }
        
        StdOut.println(" \n Big Integer results: ");
        
        BigInteger[] sequence2 = new BigInteger[100];
        for(int n = 0; n < 100; n++){
            BigInteger result;
            if((n > 1)){
                result = much_better_F(sequence2, n);
            }else{
                String value = String.valueOf(F(n)) ;
                result =  new BigInteger( value );
            }
            sequence2[n] = result;
            StdOut.println(n + " " + result);
        }
    }
}