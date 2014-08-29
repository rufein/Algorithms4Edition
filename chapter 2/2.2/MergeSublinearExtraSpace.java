
/****************************************************************************** 
 *   Exercise 2.2.12
 * 
 *   This file is released under the GNU General Public License, 
 *   version 3 (GPLv3).
 * 
 *   This file is based on these files: 
 *   http://algs4.cs.princeton.edu/22mergesort/Merge.java.html
 *
 *   Compilation:  javac MergeSublinearExtraSpace.java
 *   Execution:    java MergeSublinearExtraSpace < tiny.txt
 * 
 *   @author Koldo González
 *             
 *****************************************************************************/


public class MergeSublinearExtraSpace {

    // This class should not be instantiated.
    private MergeSublinearExtraSpace() { }

    // stably merge a[lo .. mid] with a[mid+1 ..hi] using aux[lo .. hi]
    private static void merge(Comparable[] a, int lo, int mid, int hi) {

        // precondition: a[lo .. mid] and a[mid+1 .. hi] are sorted subarrays
        assert isSorted(a, lo, mid);
        assert isSorted(a, mid+1, hi);

        // Building an AD HOC aux[] 
        Comparable[] aux = new Comparable[hi - lo + 1];
        for (int k = 0; k <= hi - lo; k++) {
            aux[k] = a[lo + k]; 
        }

        // merge back to a[]
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)   { a[k] = aux[j - lo];  j++; } // this copying is unnecessary
            else if (j > hi)    { a[k] = aux[i - lo]; i++;  }
            else if (less(aux[j - lo], aux[i - lo])) {
                a[k] = aux[j - lo];  j++;
            }
            else                { a[k] = aux[i - lo]; i++;   }
        }

        // postcondition: a[lo .. hi] is sorted
        assert isSorted(a, lo, hi);
    }

    // mergesort a[lo..hi] using auxiliary array aux[lo..hi]
    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param a the array to be sorted
     */
    public static void sort(Comparable[] a) {
        sort(a, 0, a.length-1);
        assert isSorted(a);
    }


   /***********************************************************************
    *  Helper sorting functions
    ***********************************************************************/
    
    // is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        return (v.compareTo(w) < 0);
    }
        
    // exchange a[i] and a[j]
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }


   /***********************************************************************
    *  Check if array is sorted - useful for debugging
    ***********************************************************************/
    private static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }


    // print array to standard output
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
    }

    /**
     * Reads in a sequence of strings from standard input; mergesorts them; 
     * and prints them to standard output in ascending order. 
     */
    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        MergeSublinearExtraSpace.sort(a);
        show(a);
    }
}