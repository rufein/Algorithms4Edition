/*  
 *  Exercise 1.1.23
 */

/*
 *  Execution:
 * 
 *  % java BinarySearch tinyW.txt + < tinyT.txt
 * 
 *  % java BinarySearch tinyW.txt - < tinyT.txt
*/


import java.util.Arrays;

public class exercise_1_1_23 {

    // precondition: array a[] is sorted
    public static int rank(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if      (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        int[] whitelist = in.readAllInts();

        Arrays.sort(whitelist);

        // read key; print if not in whitelist
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if ( rank(key, whitelist) == -1 && args[1].equals("+") ){
                StdOut.println(key);
            }
            else if( rank(key, whitelist) > 0 && args[1].equals("-") ){
                StdOut.println(key);
            }
        }
    }
}