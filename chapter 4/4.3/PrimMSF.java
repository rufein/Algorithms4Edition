
/****************************************************************************** 
 *   Exercise 4.3.22
 * 
 *   This file is released under the GNU General Public License, 
 *   version 3 (GPLv3).
 * 
 *   This file is based on these files: 
 *   http://algs4.cs.princeton.edu/43mst/PrimMST.java.html
 *
 *   Compilation:  javac PrimMSF.java
 *   Execution:    java PrimMSF tinyEWG.txt
 * 
 *   @author Koldo González
 *             
 *****************************************************************************/

public class PrimMSF {
   
    /**
     * Unit tests the <tt>PrimMSF</tt> data type.
     */
    public static void main(String[] args) {
        In in = new In(args[0]);
        EdgeWeightedGraph G = new EdgeWeightedGraph(in);
        EWGCC con = new EWGCC(G);
        
         
        
        PrimMST mst = new PrimMST(G);
        for (Edge e : mst.edges()) {
            StdOut.println(e);
        }
        StdOut.printf("%.5f\n", mst.weight());
    }
}