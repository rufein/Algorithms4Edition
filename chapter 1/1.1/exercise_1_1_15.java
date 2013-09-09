/*  
 *  Exercise 1.1.15
 */

public class exercise_1_1_15{

    /*
     * Function that create an array with random integers
     * 
     * Arguments:
     * - x => the lenght of the array
     * - range => The range of values between 0 and the argument (not inclusive)
     *   that fill the array randomly
     * 
    */
    public static int[] create_array(int x, int range){
        int[] array = new int[x];
        for(int i = 0; i < x; i++){
            array[i] = StdRandom.uniform(range);
        }
        return array;
    }
    
    /*
     * Function that returns the largest value in an array of integers
     */
    public static int largest_value(int[] a){
        int value = a[0];
        for(int i = 1; i < a.length; i++){
            if(value < a[i]){
                value = a[i];
            }
        }
        return value;
    }
    
    /*
     * Function to sort an array 
    */
    public static int[] sort_array(int[] a){
        int tmp;
        for ( int i = 0 ; i < a.length - 1 ; ) {
            if ( a[i] > a[i + 1] ) {
                tmp = a[i];
                a[i] = a[i + 1];
                a[i + 1] = tmp;
                if (i != 0) { i--; } 
            }else if( a[i] <= a[i + 1]){
                i++;
            }
        }
        return a;
    }
    
    
    /*
     * Create an histogram with the number of times that
     * appear a number in the argument array a.
     */
    public static int[] histogram(int[] a, int M){
        int[] histogram = new int[(M + 1)];
        int[] a_sort = sort_array( a );
        int a_sort_length = a_sort.length;
        int h = 0;
        for(int i = 0; i <= M  ; i++){
            int count = 0;
            while( ( h < a_sort_length - 1) && ( a_sort[h] < i ) ){
                h++;
            }
            while(a_sort[h] == i){
                count++;     
                if( h < a_sort_length - 1 ){h++;}else{break;}
            }
            histogram[i] = count;
        }
        return histogram;
    }
    
    /*
     * Function to print the values of an array
     */
    public static void print_array(int[] a){
        for(int i = 0; i < a.length; i++){
             System.out.println("key: " + i + " ; Value : " + a[i] + " ; ");
        }
        System.out.println("\n");
    }
    
    /*
     * Test function 
    */
    public static void main(String[] args) {
       int[] a = create_array(10, 20);
       print_array(a);
       int[] histogram = histogram(a, largest_value(a));
       print_array(histogram);
    }
}