
/****************************************************************************** 
 *   Exercise 1.1.25
 * 
 *   This file is released under the GNU General Public License, 
 *   version 3 (GPLv3).
 * 
 *   This file is based on these files: 
 *
 *   Compilation:  javac exercise_1_1_25.java
 *   Execution:    java exercise_1_1_25 66 33
 *                 java exercise_1_1_25 67 31
 * 
 *   @author Koldo González
 *             
 *****************************************************************************/

public class exercise_1_1_25 {

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
    
    public static boolean demonstration(int hi, int lo, int gcd){
        boolean b = false;
        gcd++;
        for ( ; gcd < lo; gcd++ ){
            if( (hi % gcd) == 0 && (lo % gcd) == 0){
                b = true;
            }
        }
        return b;
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
       
       boolean demosntration = demonstration( hi , lo, result);
       if(!demosntration){
           System.out.println("Passed test");
       }else{
           System.out.println("NOT Passed test");
       }
    }
}