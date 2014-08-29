

/****************************************************************************** 
 *   Exercise 2.3.22
 * 
 *   This file is released under the GNU General Public License, 
 *   version 3 (GPLv3).
 * 
 *   This file is based on these files: 
 *   http://algs4.cs.princeton.edu/23quicksort/Quick.java.html
 *
 *   Compilation:  javac Quick3wayFaster.java
 *   Execution:    java Quick3wayFaster < tiny.txt
 * 
 *   @author Koldo González
 *             
 *****************************************************************************/


public class Quick3wayFaster {

    // This class should not be instantiated.
    private Quick3wayFaster() { }

    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param a the array to be sorted
     */
    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
        assert isSorted(a);
    }

    // quicksort the subarray a[lo .. hi] using 3-way partitioning
    private static void sort(Comparable[] a, int lo, int hi) { 
        if (hi <= lo) return;
        int lt = lo, gt = hi; // p and q variables in the exercise explanation
        Comparable v = a[lo];
        int i = lo;
        int j = hi + 1;
        
        // Partition code
        while (true) {
            
            int cmp;
            while ( true ){ 
                cmp = a[++i].compareTo(v);
                if (cmp == 0) exch(a, lt++, i++);
                else if (cmp < 0) break;
            }
                
            while ( true ){
                cmp = v.compareTo(a[--j]);
                if (cmp == 0) exch(a, gt--, j--);
                else if (cmp < 0) break;
            }
            
            if (i >= j) break;

            exch(a, i, j); 
        }
        
        int k = j + 1; // Duplicate
        // Regroup
        while(--lt >= lo){
            exch(a, lt, j--);
        }
        while(++gt <= hi){
            exch(a, gt, k++);
        }

        // a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi]. 
        sort(a, lo, j);
        sort(a, k, hi);
        assert isSorted(a, lo, hi);
    }



   /***********************************************************************
    *  Helper sorting functions
    ***********************************************************************/
    
    // is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        return (v.compareTo(w) < 0);
    }

    // does v == w ?
    private static boolean eq(Comparable v, Comparable w) {
        return (v.compareTo(w) == 0);
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
     * Reads in a sequence of strings from standard input; 3-way
     * quicksorts them; and prints them to standard output in ascending order. 
     */
    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        Quick3way.sort(a);
        show(a);
    }

}