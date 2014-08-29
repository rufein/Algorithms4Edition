
/****************************************************************************** 
 *   Exercise 2.2.15
 * 
 *   This file is released under the GNU General Public License, 
 *   version 3 (GPLv3).
 * 
 *   This file is based on these files: 
 *   http://algs4.cs.princeton.edu/22mergesort/Merge.java.html
 *
 *   Compilation:  javac QueueMergeSort.java
 *   Execution:    java QueueMergeSort < tiny.txt
 * 
 *   @author Koldo González
 *             
 *****************************************************************************/


/*
 *  Execution: java QueueMergeSort
 *             
 */

public class QueueMergeSort {

    // This class should not be instantiated.
    private QueueMergeSort() {}
    
    // merge queues
    public static void merge_queues( Queue<Comparable> a, Queue<Comparable> b){
        
        if ( a.isEmpty() || b.isEmpty()){ throw new IllegalArgumentException("Empty Queue"); }
        
        Comparable v =  a.dequeue();
        Comparable w = b.dequeue();
        
        Boolean empty_a = false;
        Boolean empty_b = false;
        
        int size = a.size();
        int i = 0;
        
        while ( true ){
            
            if( empty_b ){ 
                a.enqueue( v );
                if (i < size) { v =  a.dequeue(); i++ ; }
                else{ break; }   
            }
            else if( empty_a ){ 
                a.enqueue( w ) ;
                if ( !b.isEmpty() ) { w = b.dequeue(); }
                else{ break; }
            }
            else if( ! less(v , w) ){ 
                a.enqueue(w);
                if( !b.isEmpty() ) { w = b.dequeue(); }
                else{ empty_b = true; }
            }else{
                a.enqueue(v);
                if( i < size ) { v = a.dequeue(); i++; }
                else{ empty_a = true; }
            }
      
        }
    }
    
    // Sort
    public static Queue<Queue> sort_queue( Queue<Queue> q ){
        
        while ( q.size() > 1){
            Queue a = q.dequeue();
            Queue b = q.dequeue();
            merge_queues(a, b);
            q.enqueue(a);
        }     
        return q;
    }
    
     // is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        return (v.compareTo(w) < 0);
    }

    /**
     * Test function
     */
    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        Queue<Queue> q = new Queue<Queue>();
       
        for(int i = 0; i < a.length ; i++) {
            Queue<String> h = new Queue<String>();
            h.enqueue( a[i] );
            q.enqueue(h);
        }
             
        Queue<Queue> sorted = QueueMergeSort.sort_queue(q);
        Queue ordered_q = sorted.dequeue();
        StdOut.println(ordered_q.toString());
    }
}