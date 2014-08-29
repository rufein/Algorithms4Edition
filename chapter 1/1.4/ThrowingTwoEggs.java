

/****************************************************************************** 
 *   Exercise 1.4.25
 * 
 *   This file is released under the GNU General Public License, 
 *   version 3 (GPLv3).
 * 
 *   This file is based on these files: 
 *   
 *
 *   Compilation:  javac ThrowingTwoEggs.java
 *   Execution:    java ThrowingTwoEggs 
 *                
 * 
 *   @author Koldo González
 *             
 *****************************************************************************/


public class ThrowingTwoEggs {
    
    
    /**
     * Test function
     */
    public static void main(String[] args)  { 
       
        // Building with 100 storys
        int[] building = new int[100];
        int flats = StdRandom.uniform(98) + 1 ; // Result between 1 : 10 ;
        for (int i = 0; i < 100; i++){
            if( i <= flats ) building[i] = 1;
            else building[i] = 0;
        }
            
        // First egg
        int egg1 = 0;
        int i = 1;
        int exp = 0;
        for (; exp <  building.length - 1 ; i++ ){
            // Increment in that way: 1 + 2 + 3 .....
            // First loop : 1      exp = 1
            // Second loop : 2     exp = 3
            // Third loop : 3      exp = 6
            exp += i;
            egg1++;
            if (building[exp] == 0){ break;}
        }
        
        // Second egg
        int egg2 = 0;
        for ( int h = exp - i + 1; h < exp; h++){
            egg2++;
            if (building[h] == 0){ break;}  
        }
                         
        
        // Print text
        StdOut.println("The number selected by Random is " + flats);
        StdOut.println("Result is: " + (exp - i + (egg2-1) ) );
        StdOut.println("Loops in egg 1: " + egg1 + " loops in egg2: " + egg2 );
              
    } 
} 