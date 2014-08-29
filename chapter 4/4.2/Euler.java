
/****************************************************************************** 
 *   Exercise 4.2.20
 * 
 *   This file is released under the GNU General Public License, 
 *   version 3 (GPLv3).
 * 
 *   This file is based on these files: 
 *   
 *
 *   Compilation:  javac Euler.java
 *   Execution:    java Euler 15
 * 
 *   @author Koldo González
 *             
 *****************************************************************************/

public class Euler{

    private Digraph d;
    private boolean[] marked;
    private DirectedCycle dc;
    
    // Builder
    public Euler( Digraph G ){
         d = G;
         marked = new boolean[G.V()];
         DirectedCycle dc = new DirectedCycle(G);
    }
    
    // Check if a digrapg has an euclerian cycle
    public boolean is_euclerian_cycle(){
        if( d.V() != d.E() ) return false; // They have the same number of vertexs and edges
        if(!dc.hasCycle()) return false; // No cycle found
        for( int a : dc.cycle() )
            marked[a] = true;
        for( int i = 0; i < d.V(); i++ )
            if(!marked[i]) return false;
        return true;
    }
    
    /*
     * Test function 
    */
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        Digraph d = DigraphGenerator.cycle(a);
        Euler eu = new Euler(d);
        StdOut.println(d); // Print Digraph
        if(eu.is_euclerian_cycle())
            StdOut.println("There are a euclidean cycle");
        else
            StdOut.println("No euclidean cycle");
    }
}