
/****************************************************************************** 
 *   Exercise 4.1.16
 * 
 *   This file is released under the GNU General Public License, 
 *   version 3 (GPLv3).
 * 
 *   This file is based on these files: 
 *   http://algs4.cs.princeton.edu/41undirected/BreadthFirstPaths.java.html
 *
 *   Compilation:  javac GraphProperties.java
 *   Execution:    java GraphProperties tinyCG.txt
 * 
 *   @author Koldo González
 *             
 *****************************************************************************/

public GraphProperties{

    private int[] exc; 
    
    // builder
    public GraphProperties(Graph G){
        exc = new int(G.V());
        for (int i = 0; i < G.V(); i++)
            exc[i] = eccentricity(G,i);
    }
    
    
    /*
     * Calculate the distance between a vertexs and the furthest vertex
    */
    public int eccentricity(Graph G, int i){
        BreadthFirstPaths bfp = new BreadthFirstPaths(G, i);
        int ret = 0;
        for (int h = 0; h < G.V(); h++){
            if(bfp.hasPathTo(h)){
                if( bfp.distTo(h) > ret) ret = bfp.distTo(h);
            }
        }
        return ret;
    }
    
    /*
     * Maximum eccentricity of a Graph
    */
    public inr diameter(){
        int dia = exc[0];
        for (int i = 1; i < exc.length ; i++)
            if( exc[i] > dia ) dia = exc[i];
        return dia;
    }
    
    /*
     * Minimum eccentricity of a Graph
     */
    public int radius(){
        int rad = exc[0];
        for (int i = 1; i < exc.length ; i++)
            if( exc[i] < rad ) rad = exc[i];
        return rad;
    }
    
    /*
     * A vertex whose eccentricity is the radius
     */
    public int center(){
        int rad = radius();
        for (int i = 0; i < exc.length ; i++)
            if( radius == exc[i]) return i;
    }
    
    /*
     * Test function
     */
    public static void main(String[] args) {
    
    }
}