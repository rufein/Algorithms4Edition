
/****************************************************************************** 
 *   Exercise 1.4.20
 * 
 *   This file is released under the GNU General Public License, 
 *   version 3 (GPLv3).
 * 
 *   This file is based on these files: 
 *   https://www.cs.princeton.edu/courses/archive/fall10/cos226/precepts/BitonicSearch-Tarjan.pdf
 *
 *   Compilation:  javac BitonicSearch.java
 *   Execution:    java BitonicSearch tinyW.txt
 *                
 * 
 *   @author Koldo González
 *             
 *****************************************************************************/


public class BitonicSearch {

   /**
     * Searches for the integer key in the sorted array a[].
     * @param a the array of integers, must be sorted in ascending order
     * @return index of key in array a[] if present; -1 if not present
     */
    public static int max(int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            
            int mid = lo + (hi - lo) / 2;
            if      ( a[mid+1] > a[mid] && a[mid-1] < a[mid]  ) { lo = mid + 1; }
            else if ( a[mid+1] < a[mid] && a[mid-1] > a[mid]  ) { hi = mid - 1; }
            else if ( a[mid+1] < a[mid] && a[mid-1] < a[mid]  ) { return mid; }
          
        }
        return -1;
    }
    
    /**
     * 
     */
    public static int rank(int key, int[] a, int lo, int hi) {
        
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if      (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }
    
    /**
     * 
     */
    public static int inverse_rank(int key, int[] a, int lo, int hi) {
        
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if      (key > a[mid]) hi = mid - 1;
            else if (key < a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    /**
     * Test function
     */
    public static void main(String[] args)  { 
       
         // read the integers from a file
        In in = new In(args[0]);
        int[] whitelist = in.readAllInts();
        int max = max(whitelist);

        // read integer key from standard input; print if not in whitelist
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            // rank
            int i = rank(key, whitelist, 0, max);
            if ( i != -1 )  StdOut.println(i);
            
            // inverse rank
            i = inverse_rank(key, whitelist, max+1, whitelist.length-1);
            if ( i != -1 )  StdOut.println(i);
        }
    } 
} 