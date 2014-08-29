
/****************************************************************************** 
 *   Exercise 1.4.14
 * 
 *   This file is released under the GNU General Public License, 
 *   version 3 (GPLv3).
 * 
 *   This file is based on these files: 
 *   http://algs4.cs.princeton.edu/14analysis/ThreeSum.java.html
 *   http://algs4.cs.princeton.edu/14analysis/ThreeSumFast.java.html
 *
 *   Compilation:  javac FourSum.java
 *   Execution:    java FourSum 1Kints.txt
 *                
 * 
 *   @author Koldo González
 *             
 *****************************************************************************/

import java.util.Arrays;

public class FourSum {

    
    // returns true if the sorted array a[] contains any duplicated integers
    private static boolean containsDuplicates(int[] a) {
        for (int i = 1; i < a.length; i++)
            if (a[i] == a[i-1]) return true;
        return false;
    }
    
    
    /**
     * Prints to standard output the (i, j, k, l) with i < j < k < l such that a[i] + a[j] + a[k] + a[l] == 0.
     * @param a the array of integers
     */
    public static void printAll(int[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                for (int k = j+1; k < N; k++) {
                    for(int l = k+1; l < N; l++){
                        if (a[i] + a[j] + a[k] == 0) {
                            StdOut.println(a[i] + " " + a[j] + " " + a[k]);
                        }
                    }
                }
            }
        }
    } 

    /**
     * Returns the number of triples (i, j, k, l) with i < j < k < l such that a[i] + a[j] + a[k] + a[l] == 0.
     * @param a the array of integers
     * @return the number of triples (i, j, k) with i < j < k < l such that a[i] + a[j] + a[k]+ a[l]  == 0
     */
    public static int brute_force_count(int[] a) {
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                for (int k = j+1; k < N; k++) {
                    for(int l = k+1; l < N; l++) {
                        if (a[i] + a[j] + a[k] + a[l] == 0) {
                            cnt++;
                        }
                    }
                }
            }
        }
        return cnt;
    } 
    
    // A faster way to count
     public static int count(int[] a) {
        int N = a.length;
        Arrays.sort(a);
        if (containsDuplicates(a)) throw new IllegalArgumentException("array contains duplicate integers");
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                for (int l = j+1; j < N; l++) {
                    int k = Arrays.binarySearch(a, -(a[i] + a[j] + a[l]));
                    if (k > l) cnt++;
                }
            }
        }
        return cnt;
    } 

    /**
     * Reads in a sequence of integers from a file, specified as a command-line argument;
     * counts the number of triples sum to exactly zero; prints out the time to perform
     * the computation.
     */
    public static void main(String[] args)  { 
        In in = new In(args[0]);
        int[] a = in.readAllInts();

        Stopwatch timer = new Stopwatch();
        StdOut.println("Please, be patient. A brute force algorithm is in progress");
        int cnt = brute_force_count(a);
        StdOut.println("Elapsed time = " + timer.elapsedTime());
        StdOut.println("The result is: " + cnt);
        
        Stopwatch timer2 = new Stopwatch();
        StdOut.println("Please, be patient. Now, a faster algorithm is in progress");
        int cnt2 = count(a);
        StdOut.println("Elapsed time = " + timer2.elapsedTime());
        StdOut.println("The result is: " + cnt2);
    } 
} 
