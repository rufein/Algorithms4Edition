
/****************************************************************************** 
 *   Exercise 1.5.13
 * 
 *   This file is released under the GNU General Public License, 
 *   version 3 (GPLv3).
 * 
 *   This file is based on these files: 
 *   
 *
 *   Compilation:  javac WeightedQuickUnionUFpathCompression.java
 *   Execution:    java WeightedQuickUnionUFpathCompression < tinyUF.txt
 *                
 * 
 *   @author Koldo González
 *             
 *****************************************************************************/


public class WeightedQuickUnionUFpathCompression {
    
    private int[] id;    // id[i] = parent of i
    private int[] sz;    // sz[i] = number of objects in subtree rooted at i
    private int count;   // number of components
    private int accesses;

    /**
     * Initializes an empty union-find data structure with N isolated components 0 through N-1.
     * @throws java.lang.IllegalArgumentException if N < 0
     * @param N the number of objects
     */
    public WeightedQuickUnionUFpathCompression(int N) {
        count = N;
        id = new int[N];
        sz = new int[N];
        accesses = 0;
        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    /**
     * Returns the number of components.
     * @return the number of components (between 1 and N)
     */
    public int count() {
        return count;
    }
    
    /**
     * Returns the number of accesses.
     * @return the number of accesses (between 1 and N)
     */
    public int accesses(){
        return accesses;
    }

    /**
     * Returns the component identifier for the component containing site <tt>p</tt>.
     * @param p the integer representing one site
     * @return the component identifier for the component containing site <tt>p</tt>
     * @throws java.lang.IndexOutOfBoundsException unless 0 <= p < N
     */
    public int find(int p) {
        while (p != id[p]){
            accesses += 2;
            p = id[p];
        }
        accesses++;
        return p;
    }

    /**
     * Are the two sites <tt>p</tt> and <tt>q</tt> in the same component?
     * @param p the integer representing one site
     * @param q the integer representing the other site
     * @return <tt>true</tt> if the two sites <tt>p</tt> and <tt>q</tt>
     *    are in the same component, and <tt>false</tt> otherwise
     * @throws java.lang.IndexOutOfBoundsException unless both 0 <= p < N and 0 <= q < N
     */
    public boolean connected(int p, int q) {
        accesses += 2;
        return find(p) == find(q);
    }

  
    /**
     * Merges the component containing site<tt>p</tt> with the component
     * containing site <tt>q</tt>.
     * @param p the integer representing one site
     * @param q the integer representing the other site
     * @throws java.lang.IndexOutOfBoundsException unless both 0 <= p < N and 0 <= q < N
     */
    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) return;

        // make smaller root point to larger one
        if   (sz[i] < sz[j]) {
            // Path compression based on find() method
            int h = p;
            while( h != id[h]){
                int temp = id[h];
                id[h] = j;
                h = temp;
                accesses++;
            }
            // The root
            id[i] = j; 
            sz[j] += sz[i];  
        }
        else{
            // Path compression based ont find() method
            int h = q;
            while( h != id[h]){
                int temp = id[h];
                id[h] = i;
                h = temp;
                accesses++;
            }
            // The root
            id[j] = i; 
            sz[i] += sz[j];   
        }
        accesses++;
        count--;
    }
    
    /*
     * Print arrays 
    */
    public void print_arrays(){
    
        // Id array
        StdOut.println("ID array:");
        for(int i = 0; i < sz.length ; i++){
            StdOut.println("index: " + i + " // value : " + id[i]);
        }
        
        // Size array
        StdOut.println("Size array:");
        for(int i = 0; i < sz.length ; i++){
            StdOut.println("index: " + i + " // value : " + sz[i]);
        }
        
    }

    
    /**
     * Test function
     */
    public static void main(String[] args)  { 
        int N = StdIn.readInt();
        WeightedQuickUnionUFpathCompression uf = new WeightedQuickUnionUFpathCompression(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        uf.print_arrays();
        StdOut.println(uf.count() + " components");
        StdOut.println(uf.accesses() + " accesses");
    } 
} 