
/****************************************************************************** 
 *   Exercise 1.4.11
 * 
 *   This file is released under the GNU General Public License, 
 *   version 3 (GPLv3).
 * 
 *   This file is based on these files: 
 *   
 *
 *   Compilation:  javac StaticSETofInts.java
 *   Execution:    java StaticSETofInts tinyT.txt 
 *                
 * 
 *   @author Koldo González
 *             
 *****************************************************************************/

import java.util.Arrays;

public class StaticSETofInts {

    private int[] a;
    
    public StaticSETofInts( int[] keys ) { 
        a = new int[ keys.length ];
        for( int i = 0; i < keys.length; i++ ){
            a[i] = keys[i];
        }
        Arrays.sort(a);
    }
    
    public boolean contains( int key ){
        return rank(key) != -1 ;
    }
    
    public int rank(int key) {
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
    
    public int howMany(int key){
        
        int c = 0;     // Count how many times is repeated
        int lo = 0; 
        int edge_lo = 0;
        int hi = a.length - 1;
        int edge_hi = a.length - 1;
        
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if      (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else {
                int copy_mid = mid-1; // We have to substract -1 to avoid doubling counting
                                      // The index "mid" only will count in the second loop
                while ( edge_lo <= copy_mid && key == a[copy_mid--] )  c++;  
                while ( mid <= edge_hi && key == a[mid++] )            c++;
                return c;
            }
        }
        
        return 0;
    }

    
    public static void main(String[] args) {

        In in = new In(args[0]);
        int[] whitelist = in.readAllInts();
        StaticSETofInts set = new StaticSETofInts(whitelist);

        // read key; print if not in whitelist
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if (set.rank(key) == -1)
                StdOut.println(key + " is not present in whitelist");
            else{
                // Print how many times
                 StdOut.println("the key is repeated " + set.howMany(key) + " times");
            }
        }
    }
} 