/****************************************************************************** 
 *   Exercise 1.1.38
 * 
 *   This file is released under the GNU General Public License, 
 *   version 3 (GPLv3).
 * 
 *   This file is based on these files: 
 *
 *   Compilation:  javac exercise_1_1_38.java
 *   Execution:    java exercise_1_1_38 largeT.txt
 *  
 *   @author Koldo González
 *             
 *****************************************************************************/

/*
 *  Execution:
 * 
 *  java exercise_1_1_38 largeT.txt
 */

import java.util.Arrays;

public class exercise_1_1_38 {
   
 /*
  * Dice simulation   
  */
    public static int rank_brute_force(int key, int[] a){
    
        for(int i = 0; i < a.length ; i++){
            if( a[i] == key ) return i;
        }
        return -1;
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

        // read key; print if not in whitelist
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            
            long start = System.nanoTime();
            int rank = BinarySearch.rank(key, whitelist);
            long elapsedTime = System.nanoTime() - start;
            StdOut.println( "Rank without brute force : " + elapsedTime);
            
            long start2 = System.nanoTime();
            int rank2 = rank_brute_force(key, whitelist);
            long elapsedTime2 = System.nanoTime() - start2;
            StdOut.println( "Brute force : " + elapsedTime2);
            
            StdOut.println("---------------------------------------");
        }
  }
}