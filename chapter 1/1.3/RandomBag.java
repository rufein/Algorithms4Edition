

/****************************************************************************** 
 *   Exercise 1.3.34
 * 
 *   This file is released under the GNU General Public License, 
 *   version 3 (GPLv3).
 * 
 *   This file is based on these files: 
 *   http://algs4.cs.princeton.edu/13stacks/Bag.java.html
 *
 *   Compilation:  javac RandomBag.java
 *   Execution:    java RandomBag < tobe.txt
 * 
 *   @author Koldo González
 *             
 *****************************************************************************/

 
import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomBag<Item> {
 
    private int N;               // number of elements in bag
    private Node<Item> first;    // beginning of bag

    // helper linked list class
    private class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    /**
     * Initializes an empty bag.
     */
    public RandomBag() {
        first = null;
        N = 0;
    }

    /**
     * Is this bag empty?
     * @return true if this bag is empty; false otherwise
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Returns the number of items in this bag.
     * @return the number of items in this bag
     */
    public int size() {
        return N;
    }

    /**
     * Adds the item to this bag.
     * @param item the item to add to this bag
     */
    public void add(Item item) {
        Node<Item> oldfirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldfirst;
        N++;
    }


    /**
     * Returns an iterator that iterates over the items in the bag in arbitrary order.
     * @return an iterator that iterates over the items in the bag in arbitrary order
     */
    public Iterator<Item> iterator()  {
        return new ListIterator<Item>(first);  
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;
        private Item[] array;
        private int count;

        public ListIterator(Node<Item> first) {
            count = N;
            current = first;
            array = (Item[]) new Object[N];
            
            for ( int i = 0; i < N ; i++){
                array[i] = current.item;
                current = current.next; 
            }
        }

        public boolean hasNext()  { return count > 0;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            
            // To avoid building a new array, i symply let the same array stay,
            // but each loop, the highest item is set to NULL
            int random = StdRandom.uniform(count);
            Item item = array[random];
            array[random] = array[ count - 1];
            array[ count - 1] = null;
            
            count--;
            return item;
        }
    }

    /**
     * Unit tests the <tt>Bag</tt> data type.
     */
    public static void main(String[] args) {
        RandomBag<String> bag = new RandomBag<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            bag.add(item);
        }

        StdOut.println("size of bag = " + bag.size());
         StdOut.println("- Random iteration -");
        Iterator itr = bag.iterator();
        while ( itr.hasNext() ) {
            StdOut.println(itr.next());
        }
    }

    
}