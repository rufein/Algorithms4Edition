
/****************************************************************************** 
 *   Exercise 1.1.27
 * 
 *   This file is released under the GNU General Public License, 
 *   version 3 (GPLv3).
 * 
 *   This file is based on these files:
 *   http://introcs.cs.princeton.edu/java/96optimization/Binomial.java.html
 *
 *   Compilation:  javac exercise_1_1_27.java
 *   Execution:    java exercise_1_1_27 100 50
 * 
 *   @author Koldo González
 *             
 *****************************************************************************/

public class exercise_1_1_27 {
    
  public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int K = Integer.parseInt(args[1]);

        long[][] binomial = new long[N+1][K+1];

        // base cases
        for (int k = 1; k <= K; k++) binomial[0][k] = 0;
        for (int n = 0; n <= N; n++) binomial[n][0] = 1;

        // bottom-up dynamic programming
        for (int n = 1; n <= N; n++)
            for (int k = 1; k <= K; k++)
                binomial[n][k] = binomial[n-1][k-1] + binomial[n-1][k];

        System.out.println(binomial[N][K]);
    }
}