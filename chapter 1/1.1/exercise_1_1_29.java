
/****************************************************************************** 
 *   Exercise 1.1.29
 * 
 *   This file is released under the GNU General Public License, 
 *   version 3 (GPLv3).
 * 
 *   This file is based on these files: 
 *   http://algs4.cs.princeton.edu/11model/BinarySearch.java.html
 *
 *   Compilation:  javac exercise_1_1_29.java
 *   Execution:    java exercise_1_1_29 tinyT.txt
 * 
 *   @author Koldo González
 *             
 *****************************************************************************/

import java.util.Arrays;

public class exercise_1_1_29 {
   
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
  *  Custom method assigned in the exercise to count
  *  the number of elements above that are smaller then the key
  */
  public static void count( int key, int value, int[] whitelist){
      
      // Check if there are same values
      int upper = 0;
      int lower = 0;
      int upper_key = key + 1;
      int lower_key = key - 1;
      
      if( upper_key <= whitelist.length - 1){
          while( whitelist[upper_key] == value ){
              upper++;
              if( upper_key >= ( whitelist.length - 1))
                  break;
              upper_key++;
          }
      }
      
      if( lower_key >= 0 ){
          while( whitelist[lower_key] == value ){
              lower++;
              if( upper_key <= 0 )
                  break;
              lower_key--;
          }
      }
      
      int sum = upper + lower;
      StdOut.println("The value " + value + " is repeated " + sum + " times (Total:" + ++sum + ")");
      StdOut.println("Lower elements: " + (lower_key + 1));
  }
  

  /*
   * Test function
  */
  public static void main(String[] args) {

        // read in the integers from a file
        In in = new In(args[0]);
        int[] whitelist = in.readAllInts();

        // sort the array
        Arrays.sort(whitelist);
        for(int i = 0; i < whitelist.length ; i++)
            StdOut.println(whitelist[i]);

        // read key; print if not in whitelist
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            int result = rank(key, whitelist);
            if ( result ==  -1){
                StdOut.println();
                StdOut.print("Not in array: ");
                StdOut.println(key);
            }else{
                count(result, key, whitelist);
            }
        }
  }
}