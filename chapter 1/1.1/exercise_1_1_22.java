/*  
 *  Exercise 1.1.22
 */

import java.util.Arrays;

public class exercise_1_1_22{
    
    /*
     * Alternative function to bynary search 
    */
    public static int custom_rank( int key, int[] a ){
        return custom_rank( key , a , 0, a.length - 1,  0 );
    }
     
    public static int custom_rank( int key, int[] a, int lo, int hi, int depth){

        // Not found 
        if( lo >= hi ){
            return -1;
        }
        
        // Try finding
        int mid = lo + (hi - lo) / 2;
        if ( key < a[mid] ) {
           print_arguments( lo, hi, depth );
           return custom_rank( key, a, lo, mid - 1, ++depth );
        }else if( key > a[mid] ){
           print_arguments( lo, hi, depth );
           return custom_rank( key, a, mid + 1 , hi, ++depth );
        }else{
           print_arguments( lo, hi, depth );
           return mid;
        }
        
        
    }
    
    /*
     * Function to print arguments
     */
    public static void print_arguments(int lo, int hi, int depth){
        System.out.println("The low key is : " + lo + " ; The high key is" + hi + "; The depth is" + depth);
    }
    
    /*
     * Test function 
    */
    public static void main(String[] args) {
        // Read .txt file
        int[] whitelist = In.readInts();
        // Sort array for the binary search
        Arrays.sort(whitelist);
        
        // Print sorted array
        for(int i = 0; i < whitelist.length ; i++){
            System.out.println(whitelist[i]);
        }
        
        // Search a number
        custom_rank(11, whitelist);
    }
}