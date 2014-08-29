
/****************************************************************************** 
 *   Exercise 1.5.17
 * 
 *   This file is released under the GNU General Public License, 
 *   version 3 (GPLv3).
 * 
 *   This file is based on these files: 
 *   http://algs4.cs.princeton.edu/15uf/UF.java.html
 *   http://algs4.cs.princeton.edu/15uf/ErdosRenyi.java.html
 *
 *   Compilation:  javac ErdosRenyi.java
 *   Execution:    java ErdosRenyi 1657
 *                
 * 
 *   @author Koldo González
 *             
 *****************************************************************************/


public class ErdosRenyi {
    
    /*
     * Function to generate pairs of integer and
     * count he number of conection that has been
     * created to join all elements.
    */
    public static int count(int N){
    
        UF uf = new UF(N);
        int conections = 0;
       
        while( uf.count() > 1 ){
            int r1 = StdRandom.uniform(N);
            int r2 = StdRandom.uniform(N);
            
            if ( !uf.connected(r1, r2) ){
                uf.union(r1, r2);
            }
            conections++;
        }
        
        return conections;
    }
   
    
    /**
     * Test function
     */
    public static void main(String[] args)  { 
        
        int N = Integer.parseInt(args[0]);
        
        StdOut.println( "The program has generated " + count(N) + " conections" );
        
    } 
} 