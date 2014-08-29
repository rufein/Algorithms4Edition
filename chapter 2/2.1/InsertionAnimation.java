
/****************************************************************************** 
 *   Exercise 2.1.17
 * 
 *   This file is released under the GNU General Public License, 
 *   version 3 (GPLv3).
 * 
 *   This file is based on these files: 
 *   http://algs4.cs.princeton.edu/21elementary/Insertion.java.html
 *
 *   Compilation:  javac InsertionAnimation.java
 *   Execution:    java InsertionAnimation < tinyT.txt
 *                 java InsertionAnimation < 1Kints.txt
 * 
 *   @author Koldo González
 *             
 *****************************************************************************/

import java.util.Comparator;

public class InsertionAnimation  {
    
    // This class should not be instantiated.
    private InsertionAnimation() { }

    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param a the array to be sorted
     */
    public static void sort(Comparable[] a, int[] edges) {
        int N = a.length;
        Object min = a[edges[0]];
        Object max = a[edges[1]];
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0 && less(a[j], a[j-1]); j--) {
                exch(a, j, j-1);
            }
            show_graph(a, min, max);
            assert isSorted(a, 0, i);
        }
        assert isSorted(a);
    }

    /**
     * Rearranges the array in ascending order, using a comparator.
     * @param a the array
     * @param c the comparator specifying the order
     */
    public static void sort(Object[] a, Comparator c, int[] edges) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0 && less(c, a[j], a[j-1]); j--) {
                exch(a, j, j-1);
            }
            assert isSorted(a, c, 0, i);
        }
        assert isSorted(a, c);
    }

    // return a permutation that gives the elements in a[] in ascending order
    // do not change the original array a[]
    /**
     * Returns a permutation that gives the elements in the array in ascending order.
     * @param a the array
     * @return a permutation <tt>p[]</tt> such that <tt>a[p[0]]</tt>, <tt>a[p[1]]</tt>,
     *    ..., <tt>a[p[N-1]]</tt> are in ascending order
     */
    public static int[] indexSort(Comparable[] a) {
        int N = a.length;
        int[] index = new int[N];
        for (int i = 0; i < N; i++)
            index[i] = i;

        for (int i = 0; i < N; i++)
            for (int j = i; j > 0 && less(a[index[j]], a[index[j-1]]); j--)
                exch(index, j, j-1);

        return index;
    }

   /***********************************************************************
    *  Helper sorting functions
    ***********************************************************************/
    
    // is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        return (v.compareTo(w) < 0);
    }

    // is v < w ?
    private static boolean less(Comparator c, Object v, Object w) {
        return (c.compare(v, w) < 0);
    }
        
    // exchange a[i] and a[j]
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    // exchange a[i] and a[j]  (for indirect sort)
    private static void exch(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

   /***********************************************************************
    *  Check if array is sorted - useful for debugging
    ***********************************************************************/
    private static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    // is the array sorted from a[lo] to a[hi]
    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }

    private static boolean isSorted(Object[] a, Comparator c) {
        return isSorted(a, c, 0, a.length - 1);
    }

    // is the array sorted from a[lo] to a[hi]
    private static boolean isSorted(Object[] a, Comparator c, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(c, a[i], a[i-1])) return false;
        return true;
    }

   // print array to standard output
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
    }
    
    /********************************************************************
      *  Draw a graphic
      *******************************************************************/
    
    /*
     * Function that find what it the greatest value and the smallest value
     */
    public static int[] get_edges( Comparable[] a ){
        int index_max = 0;
        int index_min = 0;
        for (int i = 1; i < a.length; i++) {
            if ( a[i].compareTo(a[index_max]) > 0 ){ index_max = i; }
            else if ( a[i].compareTo(a[index_min]) < 0 ){ index_min = i; }
        }
        // Build the array to return
        int[] r = new int[2];
        r[0] = index_min;
        r[1] = index_max;
       
        return r;
    }
    
    
    /*
     * Function that print a graphic with the real time evolution of
     *  the sort algorithm
    */
    public static void show_graph( Comparable[] a, Object min, Object max ){
        
        double diff = Double.parseDouble( max.toString() ) - Double.parseDouble( min.toString() ); 
        
        // Reset
        StdDraw.setPenColor(StdDraw.WHITE);                           
        StdDraw.filledRectangle(0.5, 0.5, 0.6, 0.6);
        
        // Print graphic
        StdDraw.setPenColor(StdDraw.BLACK);                                   
        for (int i = 0; i < a.length; i++) {
           
           double value = Double.parseDouble( a[i].toString() ) - Double.parseDouble( min.toString() );
 
           // StdOut.println( Double.parseDouble( a[i].toString() ) + " // " + value + " // " + Double.parseDouble( a[edges[0]].toString() )); 
           
           double x = 1.0*i / a.length;
           double y = 0.5;
           double rw = 1.0 / a.length;
           double rh = 0.5*value / diff;
           StdDraw.filledRectangle(x, y, rw, rh);
        }
    }
     
    /**
     * Reads in a sequence of strings from standard input; insertion sorts them;
     * and prints them to standard output in ascending order.
     */
    public static void main(String[] args) {
        
        int[] a = StdIn.readAllInts();
        Integer[] b = new Integer[a.length];
       
        for ( int i = 0; i < a.length; i++){
            b[i] = new Integer(a[i]);
        }
        
        int[] edges = get_edges( b );
        
        InsertionAnimation.sort(b, edges);
        InsertionAnimation.show(b);
    }
} 