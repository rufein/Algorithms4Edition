
/****************************************************************************** 
 *   Exercise 1.1.28
 * 
 *   This file is released under the GNU General Public License, 
 *   version 3 (GPLv3).
 * 
 *   This file is based on these files: 
 *   http://algs4.cs.princeton.edu/11model/BinarySearch.java.html
 *
 *   Compilation:  javac exercise_1_1_28.java
 *   Execution:    java exercise_1_1_28 tinyT.txt
 *                 
 * 
 *   @author Koldo González
 *             
 *****************************************************************************/

import java.util.Arrays;

public class exercise_1_1_28 {
   
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
    
    /*
     * Function to calculate repetitions in array
     */
    public static int[] delete_repeated( int[] whitelist ){
        int repeated = 0;
        boolean[] state = new boolean[whitelist.length];
        state[0] = false;
        
        // Calculate number of times of repeated ints
        for (int i = 1; i < whitelist.length ; i++ ){
            if( whitelist[i-1] == whitelist[i] ){
                state[i] = true;
                repeated++;
            }else{
                state[i] = false;
            }
        }
        
        // Build a new array
        int[] shorter_whitelist = new int[( whitelist.length - repeated)];
        int index = 0;
        for (int i = 0; i < whitelist.length ; i++ ){
            if(!state[i]){
                shorter_whitelist[ index ] = whitelist[i];
                index++;
            }
        }
        
        return shorter_whitelist;  
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        int[] whitelist = in.readAllInts();

        Arrays.sort(whitelist);
        whitelist = delete_repeated(whitelist);

        // print whitelist
        for (int i = 0; i < whitelist.length ; i++ ){
             System.out.println(whitelist[i]);
        }
    }
}