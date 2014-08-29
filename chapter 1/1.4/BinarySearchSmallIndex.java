
/****************************************************************************** 
 *   Exercise 1.4.10
 * 
 *   This file is released under the GNU General Public License, 
 *   version 3 (GPLv3).
 * 
 *   This file is based on these files: 
 *   http://algs4.cs.princeton.edu/11model/BinarySearch.java.html
 *
 *   Compilation:  javac BinarySearchSmallIndex.java
 *   Execution:    java BinarySearchSmallIndex tinyW.txt < tinyT.txt 
 *                
 * 
 *   @author Koldo González
 *             
 *****************************************************************************/

import java.util.Arrays;

public class BinarySearchSmallIndex {

    /**
     * This class should not be instantiated.
     */
    private BinarySearchSmallIndex() { }

    /**
     * Searches for the integer key in the sorted array a[].
     * @param key the search key
     * @param a the array of integers, must be sorted in ascending order
     * @return index of key in array a[] if present; -1 if not present
     */
    public static int rank(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if      (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else {
                // This snippet of code solve the problem
                while ( mid > 0 && a[mid] == a[mid - 1] ){
                    mid -= 1;
                }
                return mid;
            }
        }
        return -1;
    }

    /**
     * Reads in a sequence of integers from the whitelist file, specified as
     * a command-line argument. Reads in integers from standard input and
     * prints to standard output those integers that also appear in the file.
     */
    public static void main(String[] args) {

        // read in the integers from a file
        In in = new In(args[0]);
        int[] whitelist = in.readAllInts();

        // sort the array
        Arrays.sort(whitelist);

        // read key; print if not in whitelist
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if (rank(key, whitelist) == -1)
                StdOut.println(key);
        }
    }
} 