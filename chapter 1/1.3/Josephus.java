
/*************************************************************************
 *  Compilation:  javac Josephus.java
 *  Execution:    java Josephus M N
 *  Dependencies: Queue.java
 *
 *  Solves the Josephus problem.
 *
 *  % java Josephus 2 7
 *  1 3 5 0 4 2 6
 *
 *************************************************************************/

public class Josephus {
    public static void main(String[] args) {
        int M = 2;
        int N = 7;

        // initialize the queue
        Queue<Integer> q = new Queue<Integer>();
        for (int i = 0; i < N; i++)
            q.enqueue(i);

        while (!q.isEmpty()) {
            for (int i = 0; i < M-1; i++){
                StdOut.println("print i = " + i);
                q.enqueue(q.dequeue());
            }
            StdOut.print(q.dequeue() + " ");
        } 
        StdOut.println();
    }
}