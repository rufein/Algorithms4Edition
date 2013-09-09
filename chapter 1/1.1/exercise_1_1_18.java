/*  
 *  Exercise 1.1.18
 */

public class exercise_1_1_18{

    /*
     * Function that has been given by the exercise 
    */
    public static int mystery(int a, int b){
        if(b == 0) return 0;
        if(b % 2 == 0) return mystery (a+a, b/2);
        return mystery(a+a, b/2) + a;
    }
    
    /*
     * Function that has been given by the exercise 
    */
    public static int mystery2(int a, int b){
        if(b == 0) return 1;
        if(b % 2 == 0) return mystery2 (a*a, b/2);
        return mystery2 (a*a, b/2) * a;
    }
     
    /*
     * Test function 
    */
    public static void main(String[] args) {
       System.out.println(mystery(2, 25));
       System.out.println(mystery(3, 11));
       System.out.println(mystery2(2, 25));
       System.out.println(mystery2(3, 11));
    }
}