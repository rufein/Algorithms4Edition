
/****************************************************************************** 
 *   Exercise 3.4.2
 * 
 *   This file is released under the GNU General Public License, 
 *   version 3 (GPLv3).
 * 
 *   This file is based on these files: 
 *   http://algs4.cs.princeton.edu/34hash/SeparateChainingHashST.java.html
 *
 *   Compilation:  javac SeparateChainingHashSTalternative.java
 *   Execution:    java SeparateChainingHashSTalternative
 * 
 *   @author Koldo González
 *             
 *****************************************************************************/


public class SeparateChainingHashSTalternative<Key, Value> {
    private static final int INIT_CAPACITY = 4;

    // largest prime <= 2^i for i = 3 to 31
    // not currently used for doubling and shrinking
    // private static final int[] PRIMES = {
    //    7, 13, 31, 61, 127, 251, 509, 1021, 2039, 4093, 8191, 16381,
    //    32749, 65521, 131071, 262139, 524287, 1048573, 2097143, 4194301,
    //    8388593, 16777213, 33554393, 67108859, 134217689, 268435399,
    //    536870909, 1073741789, 2147483647
    // };

    private int N;                                // number of key-value pairs
    private int M;                                // hash table size
    private Node<Key, Value>[] nd;                 // array of linked-list symbol tables

     // a helper linked list data type
    public class Node<Key, Value>{
        private Key key;
        private Value val;
        private Node<Key, Value> next;

        public Node(Key key, Value val, Node<Key, Value> next)  {
            this.key  = key;
            this.val  = val;
            this.next = next;
        }
    }

    // create separate chaining hash table
    public SeparateChainingHashSTalternative() {
        this(INIT_CAPACITY);
    } 

    // create separate chaining hash table with M lists
    public SeparateChainingHashSTalternative(int M) {
        this.M = M;
        this.nd =  new Node<Key, Value>[M];
    } 

    // resize the hash table to have the given number of chains b rehashing all of the keys
    private void resize(int chains) {
        SeparateChainingHashSTalternative<Key, Value> temp = new SeparateChainingHashSTalternative<Key, Value>(chains);
        for (int i = 0; i < M; i++) {
            Node<Key, Value> node_temp = nd[i];
            while ( node_temp != null ) {
                temp.put( node_temp.key, node_temp.val );
                node_temp = node_temp.next;
            }
        }
        this.M  = temp.M;
        this.N  = temp.N;
        this.nd = temp.nd;
    }

    // hash value between 0 and M-1
    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
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
        Node<Key, Value> temp = nd[hash(key)];
        while (temp != null) {
            if (key.equals(temp.key)) return temp.val;
            temp = temp.next;
        }
        return null;
    } 

    // insert key-value pair into the table
    public void put(Key key, Value val) {
        if (val == null) { delete(key); return; }

        // double table size if average length of list >= 10
        if (N >= 10*M) resize(2*M);

        int i = hash(key);
        if ( contains(key) ){ 
            Node<Key, Value> temp = nd[i];
            while(temp != null){
                if (key.equals(temp.key)) { temp.val = val; return; }
            }
        }
         
        nd[i] = new Node(key, val, nd[i]);
        N++;
    } 

    // delete key (and associated value) if key is in the table
    public void delete(Key key) {
        int i = hash(key);
        if ( contains(key)){ 
            if (nd[i] == null) return;
            Node<Key, Value> temp = nd[i];
            while ( temp != null){
                if (key.equals(temp.key)) { N--; break; }
                temp = temp.next;
            }
        }

        // halve table size if average length of list <= 2
        if (M > INIT_CAPACITY && N <= 2*M) resize(M/2);
    } 

    // return keys in symbol table as an Iterable
    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < M; i++) {
            Node<Key, Value> temp = nd[i];
            while (temp != null )
                queue.enqueue(temp.key);
                temp = temp.next;
        }
        return queue;
    } 


   /***********************************************************************
    *  Unit test client.
    ***********************************************************************/
    public static void main(String[] args) { 
        SeparateChainingHashSTalternative<String, Integer> st = new SeparateChainingHashSTalternative<String, Integer>();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }

        // print keys
        for (String s : st.keys()) 
            StdOut.println(s + " " + st.get(s)); 

    }

}