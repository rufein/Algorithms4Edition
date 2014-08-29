
/****************************************************************************** 
 *   Exercise 1.4.24
 * 
 *   This file is released under the GNU General Public License, 
 *   version 3 (GPLv3).
 * 
 *   This file is based on these files: 
 *   
 *
 *   Compilation:  javac ThrowingEggs.java
 *   Execution:    java ThrowingEggs 
 *                
 * 
 *   @author Koldo González
 *             
 *****************************************************************************/


public class ThrowingEggs {
    
    
    /**
     * Test function
     */
    public static void main(String[] args)  { 
       
        // Building with 100 storys
        int[] building = new int[100];
        int flats = StdRandom.uniform(10) + 1 ; // Result between 1 : 10 ;
        for (int i = 0; i < 100; i++){
            if( i <= flats ) building[i] = 1;
            else building[i] = 0;
        }
            
        // Search in 2 Log F
        int i = 1;
        int exp = 0;
        for (; i < building.length ; i++ ){
            exp = (int) Math.pow (2, i);
            if ( building[exp] == 0 ) break;
        }
                    
        // Applying the Binary Search for the final search
        int lo = (int) Math.pow (2, i-1);
        int hi = exp;
        int mid = 0;
        
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            mid = lo + (hi - lo) / 2;
            if      ( building[mid] == 0 ) hi = mid - 1;
            else if ( building[mid] == 1 && building[mid+1] == 1 ) lo = mid + 1;
            else break;
        }      
        
        // Print text
        StdOut.println("The number selected by Random is " + flats);
        StdOut.println("The search in 2 lg F give a resutl of " + mid);
              
    } 
} 