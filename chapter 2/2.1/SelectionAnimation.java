
/****************************************************************************** 
 *   Exercise 2.1.17
 * 
 *   This file is released under the GNU General Public License, 
 *   version 3 (GPLv3).
 * 
 *   This file is based on these files: 
 *   http://algs4.cs.princeton.edu/21elementary/Selection.java.html
 *
 *   Compilation:  javac SelectionAnimation.java
 *   Execution:    java SelectionAnimation < tinyT.txt
 *                 java SelectionAnimation < 1Kints.txt
 * 
 *   @author Koldo González
 *             
 *****************************************************************************/


import java.util.Comparator;

public class SelectionAnimation  {
    
    // This class should not be instantiated.
    private SelectionAnimation() { }

    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param a the array to be sorted
     */
    public static void sort(Comparable[] a, int[] edges) {
        int N = a.length;
        Object min_ed = a[edges[0]];
        Object max_ed = a[edges[1]];
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i+1; j < N; j++) {
                if (less(a[j], a[min])) min = j; 
            }
            exch(a, i, min);
            show_graph( a, min_ed, max_ed);
            assert isSorted(a, 0, i);
        }
        assert isSorted(a);
    }

    /**
     * Rearranges the array in ascending order, using a comparator.
     * @param a the array
     * @param c the comparator specifying the order
     */
    public static void sort(Object[] a, Comparator c) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i+1; j < N; j++) {
                if (less(c, a[j], a[min])) min = j;
            }
            exch(a, i, min);
            assert isSorted(a, c, 0, i);
        }
        assert isSorted(a, c);
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


   /***********************************************************************
    *  Check if array is sorted - useful for debugging
    ***********************************************************************/

    // is the array a[] sorted?
    private static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }
        
    // is the array sorted from a[lo] to a[hi]
    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }

    // is the array a[] sorted?
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
        
        SelectionAnimation.sort(b, edges);
        SelectionAnimation.show(b);
    }
} 