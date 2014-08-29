
/****************************************************************************** 
 *   Exercise 3.4.18
 * 
 *   This file is released under the GNU General Public License, 
 *   version 3 (GPLv3).
 * 
 *   This file is based on these files: 
 *   http://algs4.cs.princeton.edu/34hash/SeparateChainingHashST.java.html
 *
 *   Compilation:  javac SeparateChainingHashSTaverageSearches.java
 *   Execution:    java SeparateChainingHashSTaverageSearches
 * 
 *   @author Koldo González
 *             
 *****************************************************************************/


public class SeparateChainingHashSTaverageSearches<Key, Value> {
    private static final int INIT_CAPACITY = 4;

    // largest prime <= 2^i for i = 3 to 31
    // not currently used for doubling and shrinking
    private static final int[] PRIMES = {
        7, 13, 31, 61, 127, 251, 509, 1021, 2039, 4093, 8191, 16381,
        32749, 65521, 131071, 262139, 524287, 1048573, 2097143, 4194301,
        8388593, 16777213, 33554393, 67108859, 134217689, 268435399,
        536870909, 1073741789, 2147483647
     };

    private int N;                                // number of key-value pairs
    private int M;                                // hash table size
    private SequentialSearchST<Key, Value>[] st;  // array of linked-list symbol tables
    private int av;                               // Average searcches. If = 0 -> the average wont compute
    private int lgM;                              // Log2 M

    // create separate chaining hash table
    public SeparateChainingHashSTaverageSearches() {
        this(INIT_CAPACITY);
        av = 0; 
        lgM = 2;
    } 

    // create separate chaining hash table with M lists
    public SeparateChainingHashSTaverageSearches(int M) {
        this.M = M;
        Double d = Math.log(M) / Math.log(2);
        lgM = d.intValue();
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
        for (int i = 0; i < M; i++)
            st[i] = new SequentialSearchST<Key, Value>();
    } 
    
    public SeparateChainingHashSTaverageSearches(int M, int average) {
        this(M); // calling to the prevoius constructor
        av = average;
    }

    // resize the hash table to have the given number of chains b rehashing all of the keys
    private void resize(int chains) {
        SeparateChainingHashSTaverageSearches<Key, Value> temp = new SeparateChainingHashSTaverageSearches<Key, Value>(chains);
        for (int i = 0; i < M; i++) {
            for (Key key : st[i].keys()) {
                temp.put(key, st[i].get(key));
            }
        }
        this.M  = temp.M;
        this.N  = temp.N;
        this.st = temp.st;
    }

    // hash value between 0 and M-1
    private int hash(Key key) {
        int t = key.hashCode() & 0x7fffffff;
        if(lgM < 26) t = t % PRIMES[lgM+5];
        return t % M;
    } 

    // return number of key-value pairs in symbol table
    public int size() {
        return N;
    } 

    // is the symbol table empty?
    public boolean isEmpty() {
        return size() == 0;
    }

    // is the key in the symbol table?
    public boolean contains(Key key) {
        return get(key) != null;
    } 

    // return value associated with key, null if no such key
    public Value get(Key key) {
        int i = hash(key);
        return st[i].get(key);
    } 

    // insert key-value pair into the table
    public void put(Key key, Value val) {
        if (val == null) { delete(key); return; }

        // double table size if average length of list >= 10
        if ( !average(N,M) || (av == 0 && N >= 10*M) ){ resize(2*M); lgM++; }

        int i = hash(key);
        if (!st[i].contains(key)) N++;
        st[i].put(key, val);
    } 

    // delete key (and associated value) if key is in the table
    public void delete(Key key) {
        int i = hash(key);
        if (st[i].contains(key)) N--;
        st[i].delete(key);

        // halve table size if average length of list <= 2
        if ( av == 0 && M > INIT_CAPACITY && N <= 2*M){ resize(M/2); lgM--; }
        else if (average(N,M/2)){ resize(M/2); lgM--; }
    } 

    // return keys in symbol table as an Iterable
    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < M; i++) {
            for (Key key : st[i].keys())
                queue.enqueue(key);
        }
        return queue;
    }
    
    // calculate the average searches
    public boolean average(int n, int m){
        if ( n/m <= av ) return true;
        return false;
    }


   /***********************************************************************
    *  Unit test client.
    ***********************************************************************/
    public static void main(String[] args) { 
        SeparateChainingHashSTaverageSearches<String, Integer> st = new SeparateChainingHashSTaverageSearches<String, Integer>();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }

        // print keys
        for (String s : st.keys()) 
            StdOut.println(s + " " + st.get(s)); 

    }

}