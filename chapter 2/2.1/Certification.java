
/****************************************************************************** 
 *   Exercise 2.1.16
 * 
 *   This file is released under the GNU General Public License, 
 *   version 3 (GPLv3).
 * 
 *   This file is based on these files: 
 * 
 *
 *   Compilation:  javac Certification.java
 *   Execution:    java Certification
 * 
 *   @author Koldo González
 *             
 *****************************************************************************/


import java.util.Arrays;

public class Certification<Item>  {
    
    public Certification(){}
    
    public boolean check( int[] a){
        int[] b = Arrays.copyOf( a, a.length);
        Arrays.sort(b);
        
        for( int i = 0; i < a.length; i++ ){
            if( a[i] != b[i] ) return false;
        }
        return true;   
    }

    
    /**
     * Test function
     */
    public static void main(String[] args)  { 
        
        // Sorted array
        int[] a = new int[10];
        for( int i = 0; i < a.length; i++  ){
            a[i] = i;
        }
        
        // Unsorted array
        int[] b = new int[10];
        for( int i = 0; i < b.length; i++  ){
            b[i] = b.length - i;
        }
        
        Certification c = new Certification();
        StdOut.println("The result of array -A- is " + c.check(a) );
        StdOut.println("The result of array -B- is " + c.check(b) );
        
    } 
} 