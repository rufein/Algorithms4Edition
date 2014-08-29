
/****************************************************************************** 
 *   Exercise 2.3.15
 * 
 *   This file is released under the GNU General Public License, 
 *   version 3 (GPLv3).
 * 
 *   This file is based on these files: 
 *   
 *
 *   Compilation:  javac NutsAndBolts.java
 *   Execution:    java NutsAndBolts 
 * 
 *   @author Koldo González
 *             
 *****************************************************************************/


import java.util.Comparator;

public class NutsAndBolts {

    /**************************************************************
     *  Classes
    ***************************************************************/
    public class Tool implements Comparable<Tool>{
          
        public int id; // id and size
        
        public Tool( int id ){
            this.id = id;
        }
        
        public int compareTo(Tool other){
            if( this.id < other.id){ return -1 ;}
            else if( this.id == other.id){ return 0 ;}
            else{ return 1 ;}
        }
        
        public String toString(){
            return Integer.toString(id);
        }
    }
    
    public class Nut extends Tool {
        
        public Nut(int id){
            super(id);
        }
    }
    
    public class Bolt extends Tool {
    
        public Bolt(int id){
            super(id);
        }
    }
    
    /**************************************************************
     *  Intern code
     * 
     *  It's based on Quick Sort
    ***************************************************************/
    
    public Tool[] a;
    
    // Builder
    public NutsAndBolts( int N){
        a = new Tool[N];
        int h = 0;
        
        for (int i = 0; i < N/2 ; i++){
            Nut n = new Nut(i);
            Bolt b = new Bolt(i);
            
            a[h++] = n;
            a[h++] = b;
        }
    }
    
    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param a the array to be sorted
     */
    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    // quicksort the subarray from a[lo] to a[hi]
    private static void sort(Comparable[] a, int lo, int hi) { 
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
        // assert isSorted(a, lo, hi);
    }

    // partition the subarray a[lo..hi] so that a[lo..j-1] <= a[j] <= a[j+1..hi]
    // and return the index j.
    private static int partition(Comparable[] a, int lo, int hi) {
        StdOut.println("------------------------------");
        StdOut.println("---------- Variables ---------");
        StdOut.println(" Lo => " + lo + " //" + " Hi => " + hi);
        StdOut.println("------- Original Array -------");
        show(a);
        
        int i = lo;
        int j = hi + 1;
        
        int x = -1; // Position of the bolt
        
        Comparable v = a[lo];
        Boolean is_nut = v instanceof Nut;
        
        // First Halve
        while (true) { 

            // find item on lo to swap
            while (true){
                if ( (a[++i] instanceof Nut && is_nut == false) || (a[i] instanceof Nut == false &&  is_nut) ){
                   int z = less(a[i], v);
                   if (z == 0) x = i;
                   else if( z > 0) break;
                }  
                if (i == hi) break;
            }

            // find item on hi to swap
            while (true){
                if ( (a[--j] instanceof Nut && is_nut == false) || (a[j] instanceof Nut == false && is_nut) ){
                    int z = less(v, a[j]);
                    if (z == 0) x = j;
                   else if( z > 0) break;
                }
                if (j == lo) break;      // redundant since a[lo] acts as sentinel
            }

            // check if pointers cross
            if (i >= j) break;

            exch(a, i, j);
        }

        // put partitioning item v at a[j]
        exch(a, lo, j);
        
        
        while( lo < hi ){
            if (x == -1) break;
            if( (a[++lo] instanceof Nut && a[x] instanceof Bolt) || (a[lo] instanceof Bolt && a[x] instanceof Nut) ){
                exch(a, lo, x);
                break;
            }
        }
        
      
        StdOut.println();
        StdOut.println(" i => " + i + " // j => " + j);
        StdOut.println();
        
        StdOut.println("------- FISRT -------");
        show(a);

        ///////////////////////////////////////////////////////////
        // Second halve
        int k = lo;
        int l = hi + 1;
        v = a[lo]; // I am overwritting the variable to avoid declare a new one
        is_nut = v instanceof Nut; // I am overwritting the variable to avoid declare a new one
        
        while (true) { 

            // find item on lo to swap
            while (true){
                if ( (a[++k] instanceof Nut && is_nut == false) || (a[k] instanceof Nut == false &&  is_nut) ){
                   int z = less(a[k], v);
                   if( z > 0) break;
                }  
                if (k == hi) break;
            }

            // find item on hi to swap
            while (true){
                if ( (a[--l] instanceof Nut && is_nut == false) || (a[l] instanceof Nut == false && is_nut) ){
                    int z = less(v, a[l]);
                    if( z > 0) break;
                }
                if (l == lo) break;      
            }

            // check if pointers cross
            if (k >= l) break;

            exch(a, k, l);
        }
        
        // put partitioning item v at a[j]
        exch(a, lo, l);
        
        StdOut.println();
        StdOut.println(" k => " + k + " // l => " + l);
        StdOut.println();
        
        StdOut.println("------- SECOND -------");
        show(a);
        
        //////////////////////////////////////////////
        //// Reduce differences
        
        if( l < j){
            int temp = l;
            l = j;
            j = temp;
        }
        
        int m = j;
        int n = l;
        
        StdOut.println();
        StdOut.println( "Beginning: m => " + m + " // n => " + n);
        StdOut.println();
        
        while( (l - j) > 1){
            
            while ( (a[++m] instanceof Nut && a[j] instanceof Nut) || (a[m] instanceof Bolt && a[j] instanceof Bolt) ){
               exch(a, j, m); 
               StdOut.println("First Change "  + j + " // " + m);
               j = m;
            }
            
            while ( (a[--n] instanceof Nut && a[l] instanceof Nut) || (a[n] instanceof Bolt && a[l] instanceof Bolt) ){
               exch(a, l, n);
               StdOut.println("Second Change "  + l + " // " + n);
               l = n;
            }
            
            if( (n - m) <= 1 ) break;
            
            exch(a, m, n);
            
        }
        
        StdOut.println();
        StdOut.println(" m => " + m + " // n => " + n);
        StdOut.println();
        
        StdOut.println("------- Third -------");
        show(a);
        
        // now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
        return l;
    }
    
    
    /**
     * Rearranges the array so that a[k] contains the kth smallest key;
     * a[0] through a[k-1] are less than (or equal to) a[k]; and
     * a[k+1] through a[N-1] are greater than (or equal to) a[k].
     * @param a the array
     * @param k find the kth smallest
     */
    public static Comparable select(Comparable[] a, int k) {
        if (k < 0 || k >= a.length) {
            throw new IndexOutOfBoundsException("Selected element out of bounds");
        }
        StdRandom.shuffle(a);
        int lo = 0, hi = a.length - 1;
        while (hi > lo) {
            int i = partition(a, lo, hi);
            if      (i > k) hi = i - 1;
            else if (i < k) lo = i + 1;
            else return a[i];
        }
        return a[lo];
    }



   /***********************************************************************
    *  Helper sorting functions
    ***********************************************************************/
    
    // is v < w ?
    private static int less(Comparable v, Comparable w) {
        return v.compareTo(w);
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
    /*
    private static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }*/

    /*
    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }*/


    // print array to standard output
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            String type = "Nut";
            if( a[i] instanceof Bolt ) type = "Bolt";
            StdOut.println( "Type = " + type + " // id = " + a[i].toString() );
        }
    }

    /**
     *  Test function
     */
    public static void main(String[] args) {
        
        NutsAndBolts a = new NutsAndBolts(10);
        sort(a.a);
        show(a.a);
    }
}