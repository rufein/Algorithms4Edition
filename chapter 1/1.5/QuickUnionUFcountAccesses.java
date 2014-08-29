

/****************************************************************************** 
 *   Exercise 1.5.2
 * 
 *   This file is released under the GNU General Public License, 
 *   version 3 (GPLv3).
 * 
 *   This file is based on these files: 
 *   http://algs4.cs.princeton.edu/15uf/QuickUnionUF.java.html
 *
 *   Compilation:  javac QuickUnionUFcountAccesses.java
 *   Execution:    java QuickUnionUFcountAccesses < tinyUF.txt
 *                
 * 
 *   @author Koldo González
 *             
 *****************************************************************************/


public class QuickUnionUFcountAccesses {
    
    private int[] id;    // id[i] = parent of i
    private int count;   // number of components
    private int accesses;

    /**
     * Initializes an empty union-find data structure with N isolated components 0 through N-1.
     * @throws java.lang.IllegalArgumentException if N < 0
     * @param N the number of objects
     */
    public QuickUnionUFcountAccesses (int N) {
        id = new int[N];
        count = N;
        accesses = 0;
        for (int i = 0; i < N; i++) {
            id[i] = i;
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
            accesses+= 2;
            p = id[p];
        }
        accesses++; // At least, is accesed 1 time
        return p;
    }

    /**
     * Are the two sites <tt>p</tt> and <tt>q</tt> in the same component?
     * @param p the integer representing one site
     * @param q the integer representing the other site
     * @return <tt>true</tt> if the sites <tt>p</tt> and <tt>q</tt> are in the same
     *    component, and <tt>false</tt> otherwise
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
        id[i] = j; 
        accesses++;
        count--;
    }

    
    /**
     * Test function
     */
    public static void main(String[] args)  { 
        int N = StdIn.readInt();
        QuickUnionUFcountAccesses uf = new QuickUnionUFcountAccesses(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " components");
        StdOut.println(uf.accesses() + " accesses");
    } 
} 