
/****************************************************************************** 
 *   Exercise 3.1.22
 * 
 *   This file is released under the GNU General Public License, 
 *   version 3 (GPLv3).
 * 
 *   This file is based on these files: 
 *   http://algs4.cs.princeton.edu/31elementary/ArrayST.java.html
 *
 *   Compilation:  javac ArraySTmoveToFront.java
 *   Execution:    java ArraySTmoveToFront < tiny.txt
 * 
 *   @author Koldo González
 *             
 *****************************************************************************/

public class ArraySTmoveToFront<Key, Value> {
    private static final int INIT_SIZE = 8;

    private Value[] vals;   // symbol table values
    private Key[]   keys;   // symbol table keys
    private int N = 0;      // number of elements in symbol table

    public ArraySTmoveToFront() {
        keys = (Key[])   new Object[INIT_SIZE];
        vals = (Value[]) new Object[INIT_SIZE];
    }

    // return the number of key-value pairs in the symbol table
    public int size() { return N; }

    // is the symbol table empty?
    public boolean isEmpty() { return size() == 0; }

    // resize the parallel arrays to the given capacity
    private void resize(int capacity) {
        Key[]   tempk = (Key[])   new Object[capacity];
        Value[] tempv = (Value[]) new Object[capacity];
        for (int i = 0; i < N; i++) tempk[i] = keys[i];
        for (int i = 0; i < N; i++) tempv[i] = vals[i];
        keys = tempk;
        vals = tempv;
    }

    // insert the key-value pair into the symbol table
    public void put(Key key, Value val) {

        // to deal with duplicates
        if (val == null) { delete(key); return; }

        // double size of arrays if necessary
        if (N >= vals.length) resize(2*N);
        
        if( contains(key) ){ 
            int i = -1;
            while ( i++ < N ){ if (keys[i].equals(key)) break; }
            vals[i] = val; // Overwriting the value 
            while( i > 0) {
                exch(vals, i, i-1);
                exch(keys, i, i-1);
                i--;
            }  
        }else{
            // add new key and value at the end of array
            vals[N] = val;
            keys[N] = key;
            N++;
        }  
    }
    
    public boolean contains(Key key){
        return get(key) != null;
    }

    public Value get(Key key) {
        for (int i = 0; i < N; i++)
            if (keys[i].equals(key)) return vals[i];
        return null;
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < N; i++)
            queue.enqueue(keys[i]);
        return queue;
    }

    // remove given key (and associated value)
    public void delete(Key key) {
        for (int i = 0; i < N; i++) {
            if (key.equals(keys[i])) {
                keys[i] = keys[N-1];
                vals[i] = vals[N-1];
                keys[N-1] = null;
                vals[N-1] = null;
                N--;
                if (N > 0 && N == keys.length/4) resize(keys.length/2);
                return;
            }
        }
    }
    
    // exchange a[i] and a[j]
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

   /***********************************************************************
    * Test routine.
    **********************************************************************/
    public static void main(String[] args) {
        ArraySTmoveToFront<String, Integer> st = new ArraySTmoveToFront<String, Integer>();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }
        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));
    }
}
