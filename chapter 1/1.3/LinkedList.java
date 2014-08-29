
/****************************************************************************** 
 *   Exercise 1.3.20
 *   Exercise 1.3.21
 *   Exercise 1.3.24
 *   Exercise 1.3.25
 *   Exercise 1.3.26
 *   Exercise 1.3.27
 * 
 *   This file is released under the GNU General Public License, 
 *   version 3 (GPLv3).
 * 
 *   This file is based on these files:
 *   http://algs4.cs.princeton.edu/13stacks/LinkedQueue.java.html
 *   http://algs4.cs.princeton.edu/13stacks/LinkedStack.java.html
 *
 *   Compilation:  javac LinkedList.java
 *   Execution:    java LinkedList < tobe.txt         
 * 
 *   @author Koldo González
 *             
 *****************************************************************************/

 
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<Item> {
 
    //                         LinkedQueue  Impklementation
    ///////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////
    
    private int N;         // number of elements on queue
    private Node first;    // beginning of queue
    private Node last;     // end of queue

    // helper linked list class
    private class Node {
        private Item item;
        private Node next;
    }
    
    public LinkedList(){
        first = null;
        last  = null;
        N = 0;
        assert check();
    }
    
    /**
    * Is this queue empty?
    * @return true if this queue is empty; false otherwise
    */
    public boolean isEmpty() {
        return first == null;
    }

    /**
    * Returns the number of items in this queue.
    * @return the number of items in this queue
    */
    public int size() {
        return N;     
    }

   /**
   * Returns the item least recently added to this queue.
   * @return the item least recently added to this queue
   * @throws java.util.NoSuchElementException if this queue is empty
   */
    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        return first.item;
    }
    
    /**
    * Adds the item to this queue.
    * @param item the item to add
    */
    public void enqueue(Item item) {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else           oldlast.next = last;
        N++;
        assert check();
    }

    /**
    * Removes and returns the item on this queue that was least recently added.
    * @return the item on this queue that was least recently added
    * @throws java.util.NoSuchElementException if this queue is empty
    */
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item item = first.item;
        first = first.next;
        N--;
        if (isEmpty()) last = null;   // to avoid loitering
        assert check();
        return item;
    }

    /**
    * Returns a string representation of this queue.
    * @return the sequence of items in FIFO order, separated by spaces
    */
    public String toString() {
        StringBuilder s = new StringBuilder();
        Iterator itr = iterator();
        while ( itr.hasNext() )
            s.append( itr.next() + " ");
        return s.toString();
    } 
    
     // check internal invariants
    private boolean check() {
        if (N == 0) {
            if (first != null) return false;
            if (last  != null) return false;
        }
        else if (N == 1) {
            if (first == null || last == null) return false;
            if (first != last)                 return false;
            if (first.next != null)            return false;
        }
        else {
            if (first == last)      return false;
            if (first.next == null) return false;
            if (last.next  != null) return false;

            // check internal consistency of instance variable N
            int numberOfNodes = 0;
            for (Node x = first; x != null; x = x.next) {
               numberOfNodes++;
            }
            if (numberOfNodes != N) return false;

            // check internal consistency of instance variable last
            Node lastNode = first;
            while (lastNode.next != null) {
               lastNode = lastNode.next;
            }
            if (last != lastNode) return false;
        }

        return true;
    } 
 

    /**
     * Returns an iterator that iterates over the items in this queue in FIFO order.
     * @return an iterator that iterates over the items in this queue in FIFO order
     */
    public Iterator<Item> iterator()  {
        return new ListIterator();  
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next; 
            return item;
        }
    }
    
    //////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////
    
    /*
     * Exercise 1.3.20
     *
     * Delete an element 
    */
    public void delete( int n ){
        if ( n > size() ){ throw new IllegalArgumentException("Overflow exception"); }
        
        Node prev_item = null;
        Node item = null;
        Node post_item = null;
        for ( int h = 1; h < n ; h++ ){
             prev_item = first.next;
        }
        item =  prev_item.next;
        post_item = item.next;
        
        prev_item.next =  post_item;
        item = null;
    }
    
    /*
     * Exercise 1.3.21
     *
     * Find if a node exists
    */
    public boolean find ( String key ){
        
        boolean r = false;
        Node i = first;
        for ( int h = 1; h <= N ; h++ ){
            if ( i.item.equals( key ) ){
                r = true;
                break;
            }
            i = i.next; 
       }
       return r;
    }
    
    /*
     * Exercise 1.3.24
     *
     * Delete the node following the given one
    */
    public void removeAfter ( Node n ){
        
        Node item = n.next;
        
        if ( item != null ){
            Node post_item = item.next;
            n.next = post_item;
            item = null;
        }
    }
    
    /*
     * Exercise 1.3.25
     *
     * Insert the node following the given one
    */
    public void insertAfter ( Node n , Node m){
        
        Node item = n.next;
        n.next = m;
        m.next = item;
    }
    
    /*
     * Exercise 1.3.26
     *
     * Removes all the nodes has a given item
    */
    public void remove( LinkedList l, Item s ){
        
        LinkedList n = new LinkedList();
        
        Iterator itr = l.iterator();
        while ( itr.hasNext() ){
            Object element = itr.next();
            if( element instanceof String){
                if( element.equals(s) ){ n.enqueue(element); }
            }
            else{
                if( element != s ){ n.enqueue(element); }
            }
        }
        
        // Overwirte
        l = n;
        
    }
    
    /*
     * Exercise 1.3.27
     *
     * Return the max value ( Only for a linked list of Integers )
    */
    public int max ( Node f, int n){
        
        int max = (Integer) f.item;
        
        while ( f.next != null ){
            f = f.next;
            int a = (Integer) f.item;
            max = Math.max(max, a);
        }
        
        return max; 
    }
    
  /*
  * Test function
  */
  public static void main(String[] args) { 
      
     LinkedList<String> ll = new LinkedList<String>();
     
     while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) ll.enqueue(item);
            else if (!ll.isEmpty()) StdOut.print(ll.dequeue() + " ");
     }
        
        StdOut.println("(" + ll.size() + " left on queue)");
  }
}