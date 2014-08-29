
/****************************************************************************** 
 *   Exercise 2.3.19
 * 
 *   This file is released under the GNU General Public License, 
 *   version 3 (GPLv3).
 * 
 *   This file is based on these files: 
 *   http://algs4.cs.princeton.edu/23quicksort/Quick.java.html
 *
 *   Compilation:  javac Quick5median.java
 *   Execution:    java Quick5median < tiny.txt
 * 
 *   @author Koldo González
 *             
 *****************************************************************************/

public class Quick5median {

    private static final int CUTOFF = 8;  // cutoff to insertion sort, must be >= 1

    // This class should not be instantiated.
    private Quick5median() { }

    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param a the array to be sorted
     */
    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) { 
        int N = hi - lo + 1;

        // cutoff to insertion sort
        if (N <= CUTOFF) {
            insertionSort(a, lo, hi);
            return;
        }

        // use median-of-5 as partitioning element
        else if (N <= 75) {
            int eps = N/4;
            int m = median5(a, lo, lo + eps, lo + (eps * 2), hi - eps,  hi);
            exch(a, m, lo);
        }

        // use Tukey ninther as partitioning element
        else  {
            int eps = N/23;
            int mid = lo + N/4;
            int m1 = median5(a, lo, lo + eps, lo + (2*eps), lo+ (3*eps), lo+ (4*eps) );
            int m2 = median5(a, mid - (2*eps), mid - eps, mid, mid + eps, mid + (2*eps) );
            int m3 = median5(a, (2*mid) - (2*eps), (2*mid) - eps, (2*mid), (2*mid) + eps, (2*mid) + (2*eps) );
            int m4 = median5(a, (hi-mid) - (2*eps), (hi-mid) - eps, (hi-mid), (hi-mid) + eps, (hi-mid) + (2*eps) );
            int m5 = median5(a, hi - (4*eps), hi - (3*eps), hi - (2*eps), hi - eps, hi); 
            int ninther = median5(a, m1, m2, m3, m4, m5);
            exch(a, ninther, lo);
        }

        // Bentley-McIlroy 3-way partitioning
        int i = lo, j = hi+1;
        int p = lo, q = hi+1;
        while (true) {
            Comparable v = a[lo];
            while (less(a[++i], v))
                if (i == hi) break;
            while (less(v, a[--j]))
                if (j == lo) break;
            if (i >= j) break;
            exch(a, i, j);
            if (eq(a[i], v)) exch(a, ++p, i);
            if (eq(a[j], v)) exch(a, --q, j);
        }
        exch(a, lo, j);

        i = j + 1;
        j = j - 1;
        for (int k = lo+1; k <= p; k++) exch(a, k, j--);
        for (int k = hi  ; k >= q; k--) exch(a, k, i++);

        sort(a, lo, j);
        sort(a, i, hi);
    }


    // sort from a[lo] to a[hi] using insertion sort
    private static void insertionSort(Comparable[] a, int lo, int hi) {
        for (int i = lo; i <= hi; i++)
            for (int j = i; j > lo && less(a[j], a[j-1]); j--)
                exch(a, j, j-1);
    }


    // return the index of the median element among a[i], a[j], and a[k]
    private static int median5(Comparable[] a, int i, int j, int k, int l, int m) {
        Comparable[] z = new Comparable[]{a[i], a[j], a[k], a[l], a[m]};
        insertionSort(z, 0, 4);
       
        if(eq(z[2], a[i])) return i;
        else if(eq(z[2], a[j])) return j;
        else if(eq(z[2], a[k])) return k;
        else if(eq(z[2], a[l])) return l;
        else return m;
      
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
        for (int i = 1; i < a.length; i++)
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
     * Reads in a sequence of strings from standard input; quicksorts them
     * (using an optimized version of quicksort); 
     * and prints them to standard output in ascending order. 
     */
    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        Quick5median.sort(a);
        show(a);
    }

}