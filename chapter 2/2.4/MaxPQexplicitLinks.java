

/****************************************************************************** 
 *   Exercise 2.4.24
 * 
 *   This file is released under the GNU General Public License, 
 *   version 3 (GPLv3).
 * 
 *   This file is based on these files: 
 *   http://algs4.cs.princeton.edu/24pq/MaxPQ.java.html
 *
 *   Compilation:  javac MaxPQexplicitLinks.java
 *   Execution:    java MaxPQexplicitLinks < tinyPQ.txt  java MaxPQ < tinyPQ.txt
 * 
 *   @author Koldo González
 *             
 *****************************************************************************/


import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class MaxPQexplicitLinks<Key> implements Iterable<Key> {
    private Node<Key> first;             // Top Node in the piramid
    private int N;                       // number of items on priority queue
    private Comparator<Key> comparator;  // optional Comparator

    // helper linked list class
    private static class Node<Key> {
        public Key k;
        public Node<Key> parent;
        public Node<Key> child1;
        public Node<Key> child2;
    }

    /**
     * Initializes an empty priority queue.
     */
    public MaxPQexplicitLinks() {
        N = 0;
    }

    /**
     * Initializes an empty priority queue using the given comparator.
     * @param comparator the order in which to compare the keys
     */
    public MaxPQexplicitLinks(Comparator<Key> comparator) {
        N = 0;
        this.comparator = comparator;
    }

    /**
     * Initializes a priority queue from the array of keys.
     * Takes time proportional to the number of keys, using sink-based heap construction.
     * @param keys the array of keys
     */
    public MaxPQexplicitLinks(Key[] keys) {
        for (int i = 0; i < keys.length; i++)
            insert(keys[i]);
        
        assert isMaxHeap();
    }
      
    /**
     * Is the priority queue empty?
     * @return true if the priority queue is empty; false otherwise
     */
    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * Returns the number of keys on the priority queue.
     * @return the number of keys on the priority queue
     */
    public int size() {
        return N;
    }

    /**
     * Returns a largest key on the priority queue.
     * @return a largest key on the priority queue
     * @throws java.util.NoSuchElementException if the priority queue is empty
     */
    public Key max() {
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        return first.k ;
    }

    /**
     * Adds a new key to the priority queue.
     * @param x the new key to add to the priority queue
     */
    public void insert(Key x) {

        if ( isEmpty() ){
            first = new Node<Key>();
            first.k = x;
        }
        else{ 
            insert_node(x);
            swim(get_node(N+1));
        }
        
         N++;
        
        assert isMaxHeap();
    }
    
    private void insert_node(Key x){ 
        Node<Key> n = first;
        int lg = log(N+1); // Logarithm base 2
        // StdOut.println("lg: " + lg);
        
        // Create Node
        Node<Key> a = new Node<Key>();
        
        // Path until the last branch
        while( lg > 1 ) { 
            n = ( left_child(N+1, lg--) ) ? n.child1 : n.child2 ; 
        }
        
        a.k = x; // key
        a.parent = n; // Point to the parent Node 
        if(left_child(N+1, 1)){ n.child1 = a;}else{ n.child2 = a;} // Point to the children
    }

    /**
     * Removes and returns a largest key on the priority queue.
     * @return a largest key on the priority queue
     * @throws java.util.NoSuchElementException if priority queue is empty.
     */
    public Key delMax() {
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        Key max = first.k;
        Node<Key> n = get_node(N--);
        exch( first, n);
        sink(first);
        // Delete the node
        n = null; // to avoid loiterig and help with garbage collection
        assert isMaxHeap();
        return max;
    }


   /***********************************************************************
    * Helper functions to restore the heap invariant.
    **********************************************************************/

    private void swim(Node<Key> n) {
        // StdOut.println(n.k);
        while ( !eq(n, first) && less(n.parent, n) ) {
            // StdOut.println("Called");
            exch(n, n.parent);
            n = n.parent;
        }
    }

    private void sink(Node<Key> n) {
        int index = 2; // Child index
        sink(n, index);
    }
    
    private void sink(Node<Key> n, int index) {
        while (index <= N/2) {
            Node<Key> child; 
            if( (N/2 == index) && (N%2) == 0){ child = n.child1; }
            else if (less(n.child1, n.child2)){ child = n.child2; index++;}
            else{ child = n.child1; }
            if (!less(n, child)) break;
            exch(n, child);
            index *= 2;
        }
    }
    
    // Calculate the logarithm of a nummer withb base 2
    private int log(int j){
        double z = Math.log(j)/Math.log(2);
        return (int) z;
    }
    
    // Decide if the left children or the right children
    // in the way to a Node that is in last positions
    private boolean left_child(int j, int exp){
        int e = (int) Math.pow(2, exp); // casting to int
        int f = e/2; // if e = 2pow4 , then f = 2pow3
        if( j%e < f){ return true;}else{ return false;}
    }
    
    // Get a node from the piramyd. The argument is the index number in that piramid.
    // For example, the index == 2 would be the child1 of the first Node (and the Node
    // with the greatest key)
    private Node<Key> get_node(int index){
        Node<Key> n = first;
        int lg = log(index);
        while( lg > 0 ){
             n = ( left_child(index, lg--) ) ?  n.child1 : n.child2;
        }
        return n;
    }

   /***********************************************************************
    * Helper functions for compares and swaps.
    **********************************************************************/
    private boolean less(Node<Key> i, Node<Key> j) {
        if (comparator == null) {
            return ((Comparable<Key>) i.k).compareTo(j.k) < 0;
        }
        else {
            return comparator.compare(i.k, j.k) < 0;
        }
    }
    
    private boolean eq(Node<Key> i, Node<Key> j){
         // StdOut.println(i.k + " // " + j.k);
         return ((Comparable<Key>) i.k ).compareTo(j.k) == 0;
    }

    private void exch(Node<Key> par, Node<Key> ch) {
        Key temp = par.k;
        par.k = ch.k;
        ch.k = temp;
    }

    // is pq[1..N] a max heap?
    private boolean isMaxHeap() {
        return isMaxHeap(1);
    }

    // is subtree of pq[1..N] rooted at k a max heap?
    private boolean isMaxHeap(int k) {
        if (k > N) return true;
        int left = 2*k, right = 2*k + 1;
        Node<Key> n = get_node(k);
        Node<Key> l = get_node(left); 
        Node<Key> r = get_node(right);
        if (left  <= N && less(n, l))  return false;
        if (right <= N && less(n, r)) return false;
        return isMaxHeap(left) && isMaxHeap(right);
    }

   /***********************************************************************
    * Iterator
    **********************************************************************/

    /**
     * Returns an iterator that iterates over the keys on the priority queue
     * in descending order.
     * The iterator doesn't implement <tt>remove()</tt> since it's optional.
     * @return an iterator that iterates over the keys in descending order
     */
    public Iterator<Key> iterator() { return new HeapIterator(); }

    private class HeapIterator implements Iterator<Key> {

        int M = 1;
        public HeapIterator() { M = 1; }

        public boolean hasNext()  { return M <= N;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Key next() {
            if (!hasNext()) throw new NoSuchElementException();
            Node<Key> t = get_node(M++);
            return t.k;
        }
    }

    /**
     * Unit tests the <tt>MaxPQ</tt> data type.
     */
    public static void main(String[] args) {
        MaxPQexplicitLinks<String> pq = new MaxPQexplicitLinks<String>();
        
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")){
                pq.insert(item);
                
            } 
            else if (!pq.isEmpty()) StdOut.print(pq.delMax() + " ");
        }
        
        /*
        pq.insert("Z");
        pq.insert("X");
        pq.insert("T");
        */
        
        StdOut.println("(" + pq.size() + " left on pq)");
        
        Iterator itr = pq.iterator();
        while(itr.hasNext()){
            StdOut.print(itr.next() + " ");
        }
        
        
    }

}
