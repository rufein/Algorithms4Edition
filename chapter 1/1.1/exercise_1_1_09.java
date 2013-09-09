/*  
 *  Exercise 1.1.09
 */

public class exercise_1_1_09{
    
    public static String integer_to_binary(int i){
        String s = "";
        for(int I = i ; I > 0 ; I /= 2){
            s= (I%2) + s;
        }
        return s;
    }
    
    /*
     * Test function 
    */
    public static void main(String[] args) {
        String binary =integer_to_binary(456);
        System.out.println("The binary of 456 is " + binary);
    }
}