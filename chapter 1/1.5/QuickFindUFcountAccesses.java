
/****************************************************************************** 
 *   Exercise 1.5.1
 * 
 *   This file is released under the GNU General Public License, 
 *   version 3 (GPLv3).
 * 
 *   This file is based on these files: 
 *   http://algs4.cs.princeton.edu/15uf/QuickFindUF.java.html
 *
 *   Compilation:  javac QuickFindUFcountAccesses.java
 *   Execution:    java QuickFindUFcountAccesses < tinyUF.txt
 *                
 * 
 *   @author Koldo González
 *             
 *****************************************************************************/


public class QuickFindUFcountAccesses {
    
    private int[] id;    // id[i] = component identifier of i
    private int count;   // number of components
    private int accesses;

    /**
     * Initializes an empty union-find data structure with N isolated components 0 through N-1.
     * @throws java.lang.IllegalArgumentException if N < 0
     * @param N the number of objects
     */
    public QuickFindUFcountAccesses(int N) {
        count = N;
        id = new int[N];
        accesses = 0;
        for (int i = 0; i < N; i++)
            id[i] = i;
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
        accesses++;
        return id[p];
    }

    /**
     * Are the two sites <tt>p</tt> and <tt>q/tt> in the same component?
     * @param p the integer representing one site
     * @param q the integer representing the other site
     * @return <tt>true</tt> if the two sites <tt>p</tt> and <tt>q</tt> are in
     *    the same component, and <tt>false</tt> otherwise
     * @throws java.lang.IndexOutOfBoundsException unless both 0 <= p < N and 0 <= q < N
     */
    public boolean connected(int p, int q) {
        accesses += 2;
        return id[p] == id[q];
    }
  
    /**
     * Merges the component containing site<tt>p</tt> with the component
     * containing site <tt>q</tt>.
     * @param p the integer representing one site
     * @param q the integer representing the other site
     * @throws java.lang.IndexOutOfBoundsException unless both 0 <= p < N and 0 <= q < N
     */
    public void union(int p, int q) {
        if (connected(p, q)) return;
        accesses++;
        int pid = id[p];
        for (int i = 0; i < id.length; i++){
            accesses++;
            if (id[i] == pid){ 
                id[i] = id[q]; 
                accesses += 2; 
            }
        }
        count--;
    }
        
    /**
     * Test function
     */
    public static void main(String[] args)  { 
        int N = StdIn.readInt();
        QuickFindUFcountAccesses uf = new QuickFindUFcountAccesses(N);
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