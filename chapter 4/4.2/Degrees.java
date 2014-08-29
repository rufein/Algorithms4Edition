
/****************************************************************************** 
 *   Exercise 4.2.7
 * 
 *   This file is released under the GNU General Public License, 
 *   version 3 (GPLv3).
 * 
 *   This file is based on these files: 
 *   
 *
 *   Compilation:  javac Degrees.java
 *   Execution:    java Degrees
 * 
 *   @author Koldo González
 *             
 *****************************************************************************/

public class Degrees{
    
    private int sz; // How many vertex in Digraph
    private Digraph d; // Digraph
    private Digraph rev; // Reverse digrapgh 
    
    /*  
     *  Build an instance of this class
     *  @param G : a dipgrah
     */
    public Degrees(Digraph G){
        sz = G.V();
        d = G;
        rev = G.reverse();
    }
    
    /*
     *  Number of directed edges that point to a given vertex
     *  @param v: the vertex
     */
    public int indegree(int v){
        return rev[v].size();
    }
    
    /*
     *  Number of directed edges that emanate form a givem vertex
     *  @param v: the vertex
    */
    public int outdegree(int v){
        return d[v].size(); 
    }
    
    /*
     * Iterate over the indegree vextexs in the digraph
    */
    public Iterable<Integer> sources(){
        Bag<Integer> sources = new Bag<Integer>();
        for( int i = 0; i < sz ; i++ )
            if ( indegree(i) == 0 ) sources.add(i);
        return sources;
    }
    
    /*
     * Iterate over the outdegree vextexs in the digraph
    */
    public Iterable<Integer> sinks(){
        Bag<Integer> sinks = new Bag<Integer>();
        for( int i = 0; i < sz ; i++ )
            if ( oudegree(i) == 0) sinks.add(i);
        return sinks;
    }
    
    /*
     * Test function 
    */
    public static void main(String[] args) {
        
    )

}