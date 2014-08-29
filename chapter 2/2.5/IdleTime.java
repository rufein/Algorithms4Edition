
/****************************************************************************** 
 *   Exercise 2.5.20
 * 
 *   This file is released under the GNU General Public License, 
 *   version 3 (GPLv3).
 * 
 *   This file is based on these files: 
 *   
 *
 *   Compilation:  javac IdleTime.java
 *   Execution:    java IdleTime 5 
 * 
 *   @author Koldo González
 *             
 *****************************************************************************/

/*
 *  Execution: java IdleTime 5
 *             
 */

import java.util.Arrays;

public class IdleTime {

    /*
     * Create Random Timestamps 
    */
    public static Integer[][] timestamps(int N){
        Integer[][] timestamps = new Integer[2][N];
        for (int i = 0; i < N; i++){
            timestamps[0][i] =  StdRandom.uniform( 1389342948, 1389642948) ;
            timestamps[1][i] =  timestamps[0][i] + StdRandom.uniform(2500) ;
        }
        return timestamps;
    }
    
    /*
     * Show the arrays 
    */
    public static void show(Integer[] a, Integer[] b, int[] ind_a){
        for (int i = 0; i < ind_a.length ; i++){
            StdOut.println( i + " / start: " + a[ind_a[i]] + " / end: " + b[ind_a[i]] );
        }
    }
    
    /*
     * Calculate the idle time 
    */
    public static int idle (Integer[] a, Integer[] b, int[] ind_a){
       
        int i = 0;
        int total = 0;
        int init = a[ind_a[i]];
        int end = b[ind_a[i]];
        
        while ( ++i < ind_a.length ){
            if ( end <  a[ind_a[i]] ){ 
                total = end - init;
                init = a[ind_a[i]];
            }
            if(  end < b[ind_a[i]]) end = b[ind_a[i]];
        }
        
        if( end - init > total) total = end - init;
        return total;    
    }
    
    /*
     * Calculate the not idle time 
    */
    public static int not_idle(Integer[] a, Integer[] b, int[] ind_a){
       
        int total = 0;
        int i = 0;
        int init = a[ind_a[i]];
        int end = b[ind_a[i]];
        
        while( ++i < ind_a.length ){
            if( a[ind_a[i]] > end ){
                init = a[ind_a[i]];
                total = init - end;
            }
            if(  end < b[ind_a[i]]) end = b[ind_a[i]];
        }
        
        return total;
    }

    /*
     * Test function 
    */
    public static void main(String[] args) {

        // two random permutation of size N
        int N = Integer.parseInt(args[0]);
        Integer[][] generate = timestamps(N);
        Integer[] a = generate[0]; // Array with 
        Integer[] b = generate[1];
        
        int[] ind_a = Merge.indexSort(a); // index Sort with merge sort
        int total_idle = idle(a, b, ind_a);
        int total_not_idle = not_idle(b, a, ind_a);

        show(a, b, ind_a);
        StdOut.println("The amount of time that the computer is idle ( in seconds ) = " + total_idle );
        StdOut.println("The amount of time that the computer is not idle ( in seconds ) = " + total_not_idle );
    }
}