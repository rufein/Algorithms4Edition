/*  
 *  Exercise 1.1.07
 */

public class exercise_1_1_07{
  
    /*
     * Section "a" of the exercise
    */
    public static void a_section(){
        double t = 9.0;
        while (Math.abs(t - 9.0/t) > .001)
            t = (9.0/t + t) / 2.0;
        StdOut.printf("%.5f\n", t);
    }
    
    /*
     *  Section "b" of the exercise
    */
    public static void b_section(){
        int sum = 0;
        for (int i = 1; i<1000 ; i++)
            for (int j = 0; j < i; j++)
                sum++;
        StdOut.println(sum);
    }
     
    /*
     * Section "c" of the exercise
    */
    public static void c_section(){
       int sum = 0;
        for (int i = 1; i<1000 ; i*=2)
            for (int j = 0; j < i; j++)
                sum++;
        StdOut.println(sum);
    }

    /*
     * Test function 
    */
    public static void main(String[] args) {
        a_section();
        b_section();
        c_section();
    }
}