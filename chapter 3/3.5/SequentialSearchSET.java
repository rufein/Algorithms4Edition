import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.SortedSet;


public class SequentialSearchSET<Key extends Comparable<Key>> implements Iterable<Key> {
    private SequentialSearchST set;

    /**
     * Initializes an empty set.
     */
    public SequentialSearchSET() {
        set = new SequentialSearchST();
    }

    /**
     * Adds the key to the set if it is not already present.
     * @param key the key to add
     * @throws NullPointerException if <tt>key</tt> is <tt>null</tt>
     */
    public void add(Key key) {
        if (key == null) throw new NullPointerException("called add() with a null key");
        set.put(key, 0);
    }


    /**
     * Does the set contain the given key?
     * @param key the key
     * @return <tt>true</tt> if the set contains <tt>key</tt> and
     *     <tt>false</tt> otherwise
     * @throws NullPointerException if <tt>key</tt> is <tt>null</tt>
     */
    public boolean contains(Key key) {
        if (key == null) throw new NullPointerException("called contains() with a null key");
        return set.contains(key);
    }

    /**
     * Removes the key from the set if the key is present.
     * @param key the key
     * @throws NullPointerException if <tt>key</tt> is <tt>null</tt>
     */
    public void delete(Key key) {
        if (key == null) throw new NullPointerException("called delete() with a null key");
        set.delete(key);
    }

    /**
     * Returns the number of keys in the set.
     * @return the number of keys in the set
     */
    public int size() {
        return set.size();
    }

    /**
     * Is the set empty?
     * @return <tt>true</tt> if the set is empty, and <tt>false</tt> otherwise
     */
    public boolean isEmpty() {
        return size() == 0;
    }
 
    /**
     * Returns all of the keys in the set, as an iterator.
     * To iterate over all of the keys in a set named <tt>set</tt>, use the
     * foreach notation: <tt>for (Key key : set)</tt>.
     * @return an iterator to all of the keys in the set
     */
    public Iterator<Key> iterator() {
        Iterable keys = set.keys();
        return keys.iterator();
    }

    /**
     * Returns the union of this set and that set.
     * @param that the other set
     * @return the union of this set and that set
     * @throws NullPointerException if <tt>that</tt> is <tt>null</tt>
     */
    public SET<Key> union(SET<Key> that) {
        if (that == null) throw new NullPointerException("called union() with a null argument");
        SET<Key> c = new SET<Key>();
        for (Key x : this) { c.add(x); }
        for (Key x : that) { c.add(x); }
        return c;
    }

    /**
     * Returns the intersection of this set and that set.
     * @param that the other set
     * @return the intersection of this set and that set
     * @throws NullPointerException if <tt>that</tt> is <tt>null</tt>
     */
    public SET<Key> intersects(SET<Key> that) {
        if (that == null) throw new NullPointerException("called intersects() with a null argument");
        SET<Key> c = new SET<Key>();
        if (this.size() < that.size()) {
            for (Key x : this) {
                if (that.contains(x)) c.add(x);
            }
        }
        else {
            for (Key x : that) {
                if (this.contains(x)) c.add(x);
            }
        }
        return c;
    }

    /**
     * Does this set equal <tt>y</tt>?
     * Note that this method declares two empty sets to be equal
     * even if they are parameterized by different generic types.
     * This is consistent with the behavior of <tt>equals()</tt> 
     * within Java's Collections framework.
     * @param y the other set
     * @return <tt>true</tt> if the two sets are equal; <tt>false</tt> otherwise
     */
    public boolean equals(Object y) {
        if (y == this) return true;
        if (y == null) return false;
        if (y.getClass() != this.getClass()) return false;
        SET<Key> that = (SET<Key>) y;
        if (this.size() != that.size()) return false;
        try {
            for (Key k : this)
                if (!that.contains(k)) return false;
        }
        catch (ClassCastException exception) {
            return false;
        }
        return true;
    }

    /**
     * Returns a string representation of this set.
     * @return a string representation of this set, with the keys separated
     *   by single spaces
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Key key : this)
            s.append(key + " ");
        return s.toString();
    }

    /**
     * Unit tests the <tt>SET</tt> data type.
     */
    public static void main(String[] args) {
        SET<String> set = new SET<String>();


        // insert some keys
        set.add("www.cs.princeton.edu");
        set.add("www.cs.princeton.edu");    // overwrite old value
        set.add("www.princeton.edu");
        set.add("www.math.princeton.edu");
        set.add("www.yale.edu");
        set.add("www.amazon.com");
        set.add("www.simpsons.com");
        set.add("www.stanford.edu");
        set.add("www.google.com");
        set.add("www.ibm.com");
        set.add("www.apple.com");
        set.add("www.slashdot.com");
        set.add("www.whitehouse.gov");
        set.add("www.espn.com");
        set.add("www.snopes.com");
        set.add("www.movies.com");
        set.add("www.cnn.com");
        set.add("www.iitb.ac.in");


        StdOut.println(set.contains("www.cs.princeton.edu"));
        StdOut.println(!set.contains("www.harvardsucks.com"));
        StdOut.println(set.contains("www.simpsons.com"));
        StdOut.println();


        // print out all keys in the set in lexicographic order
        for (String s : set) {
            StdOut.println(s);
        }

    }

}