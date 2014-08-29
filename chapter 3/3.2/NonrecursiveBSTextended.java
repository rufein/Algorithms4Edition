
/****************************************************************************** 
 *   Exercise 3.2.14
 * 
 *   This file is released under the GNU General Public License, 
 *   version 3 (GPLv3).
 * 
 *   This file is based on these files: 
 *   http://algs4.cs.princeton.edu/32bst/BST.java.html
 *
 *   Compilation:  javac NonrecursiveBSTextended.java
 *   Execution:    java NonrecursiveBSTextended < tinyST.txt
 * 
 *   @author Koldo González
 *             
 *****************************************************************************/

import java.util.NoSuchElementException;

public class NonrecursiveBSTextended<Key extends Comparable<Key>, Value> {

    // root of BST
    private Node root;  

    private class Node {
        private Key key;             // sorted by key
        private Value val;           // associated value
        private Node left, right;    // left and right subtrees
        private int N;             // number of nodes in subtree

        public Node(Key key, Value val, int N) {
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }

    // is the symbol table empty?
    public boolean isEmpty() {
        return size() == 0;
    }

    // return number of key-value pairs in BST
    public int size() {
        return size(root);
    }

    // return number of key-value pairs in BST rooted at x
    private int size(Node x) {
        if (x == null) return 0;
        else return x.N;
    }
      
   /***********************************************************************
    *  Insert key-value pair into symbol table (nonrecursive version)
    ***********************************************************************/
    public void put(Key key, Value val) {
        if (val == null) { delete(key); return; }
        put(root, key, val);
    }
    
    private void put(Node x, Key key, Value val) {
        Node z = new Node(key, val, 1);
        if (root == null) {
            root = z;
            return;
        }

        Node parent = null;
        while (x != null) {
            parent = x;
            int cmp = key.compareTo(x.key);
            if      (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else {
                x.val = val;
                return; 
            }
        }
        int cmp = key.compareTo(parent.key);
        if (cmp < 0) parent.left  = z;
        else         parent.right = z;
    }
   

   /***********************************************************************
    *  Search BST for given key, nonrecursive version
    ***********************************************************************/
    Value get(Key key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if      (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else return x.val;
        }
        return null;
    }
    
    /***********************************************************************
    *  Min, max, floor, and ceiling
    ***********************************************************************/
    public Key min() {
        if (isEmpty()) return null;
        return min(root).key;
    } 

    private Node min(Node x) { 
        while (x.left != null){ x = x.left; } // NON RECURSIVE
        return x;
    } 

    public Key max() {
        if (isEmpty()) return null;
        return max(root).key;
    } 

    private Node max(Node x) { 
        while (x.right != null){ x = x.right; } // NON RECURSIVE  <---------------
        return x;
    } 

    public Key floor(Key key) {
        Node x = floor(root, key);
        if (x == null) return null;
        else return x.key;
    } 

    private Node floor(Node x, Key key) {

        while (x != null){  // NON RECURSIVE <---------------------------------
            // Check left
            Key k= x.key;
            int cmp = k.compareTo(key);
            if( cmp == 0){ return x; }
            if( cmp > 0){ x = x.left; continue;}  
            // Check right
            Node right = x.right;
            Key r = right.key;
            cmp = r.compareTo(key);
            if (cmp == 0) return right;
            if (cmp <  0){ x = x.right; continue;}
            
            return x;
        }
        return null; 
    } 

    public Key ceiling(Key key) {
        Node x = ceiling(root, key);
        if (x == null) return null;
        else return x.key;
    }

    private Node ceiling(Node x, Key key) {
        
        Node greaterNode = null;
        while (x != null){  // NON RECURSIVE <---------------------------------
            // Check left
            Key k= x.key;
            int cmp = k.compareTo(key);
            if (cmp == 0) return x;
            if (cmp > 0) { x = x.left;  continue;}
            // Check left    
            Node right = x.right;
            Key r = right.key;
            cmp = r.compareTo(key);
            if (cmp == 0) return right;
            if (cmp <  0){ x = x.right; continue;} 
        } 
        return greaterNode; 
    } 

   /***********************************************************************
    *  Rank and selection
    ***********************************************************************/
    public Key select(int k) {
        if (k < 0 || k >= size())  return null;
        Node x = select(root, k);
        return x.key;
    }

    // Return key of rank k. 
    private Node select(Node x, int k) {
        while (x != null){
            int t = size(x.left); 
            if      (t > k) x = x.left; 
            else if (t < k){ x = x.right; k = k-t-1;}
            else            return x; 
        }
        return null; 
    } 

    public int rank(Key key) {
        return rank(key, root);
    } 

    // Number of keys in the subtree less than key.
    private int rank(Key key, Node x) {
        int total = 0;
        while (x != null){  // NON RECURSIVE  <---------------------------------
            int cmp = key.compareTo(x.key); 
            if      (cmp < 0) x = x.left; 
            else if (cmp > 0) { total += 1 + size(x.left); x = x.right; }
            else              { total += size(x.left); }
        }
        return total;
    } 
    
    // Clone a Node
    private Node clone_node (Node a){
        Node b = new Node(a.key, a.val, a.N);
        b.left = a.left;
        b.right = a.right;
        return b;
    }

   /***********************************************************************
    *  Level-order traversal - need to make nonrecursive.
    ***********************************************************************/
    public Iterable<Key> keys() {
        Stack<Node> stack = new Stack<Node>();
        Queue<Key> queue = new Queue<Key>();
        Node x = root;
        while (x != null || !stack.isEmpty()) {
            if (x != null) {
                stack.push(x);
                x = x.left;
            }
            else {
                x = stack.pop();
                queue.enqueue(x.key);
                x = x.right;
            }
        }
        return queue;
    }
    
    /***********************************************************************
    *  Delete
    ***********************************************************************/

    public void deleteMin() {
        if (isEmpty()) throw new NoSuchElementException("Symbol table underflow");
        root = deleteMin(root);
        // assert check();
    }

    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void deleteMax() {
        if (isEmpty()) throw new NoSuchElementException("Symbol table underflow");
        root = deleteMax(root);
        // assert check();
    }

    private Node deleteMax(Node x) {
        if (x.right == null) return x.left;
        x.right = deleteMax(x.right);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void delete(Key key) {
        root = delete(root, key);
        // assert check();
    }

    private Node delete(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = delete(x.left,  key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else { 
            if (x.right == null) return x.left;
            if (x.left  == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        } 
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    } 


   /*****************************************************************************
    *  Test client
    *****************************************************************************/
    public static void main(String[] args) { 
        String[] a = StdIn.readAllStrings();
        int N = a.length;
        NonrecursiveBSTextended<String, Integer> st = new NonrecursiveBSTextended<String, Integer>();
        for (int i = 0; i < N; i++)
            st.put(a[i], i);
        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));
    }

}