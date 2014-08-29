
/****************************************************************************** 
 *   Exercise 4.1.32
 * 
 *   This file is released under the GNU General Public License, 
 *   version 3 (GPLv3).
 * 
 *   This file is based on these files: 
 *   http://algs4.cs.princeton.edu/41undirected/DepthFirstPaths.java.html
 *
 *   Compilation:  javac DuplicatedPaths.java
 *   Execution:    java DuplicatedPaths tinyCG.txt
 * 
 *   @author Koldo González
 *             
 *****************************************************************************/

public class DuplicatedPaths {
    
    private int duplicates; // Count duplicates
    private RedBlackBST[] dpl; // duplicate Graph

    /**
     * Duplicate a Graph
     * @param G the graph
     */
    public DuplicatedPaths(Graph G) {
        int vr = G.V();
        dpl = (RedBlackBST[]) new RedBlackBST[vr];
        for ( int i = 0; i < vr; i++){
            for( int a : G.adj(i) ){
                String st = Integer.toString(a);
                if ( ! dpl[i].contains(st) ) dpl[i].put(st, 0);
                else{ duplicates++; }
            }
        }
    }
    
    /**
     * Return the duplicates
     */
    public int dupl(){
        return duplicates;
    }

    /**
     * Unit tests the <tt>DepthFirstPaths</tt> data type.
     */
    public static void main(String[] args) {
        In in = new In(args[0]);
        Graph G = new Graph(in);
        DuplicatedPaths dp = new DuplicatedPaths(G);
        StdOut.println("Duplicates edges: " + dp.dupl() );
    }

}