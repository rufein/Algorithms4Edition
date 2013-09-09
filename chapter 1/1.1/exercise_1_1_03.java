/*  
 *  Exercise 1.1.03
 */

public class exercise_1_1_03{
  
   /*
    * Function to compare integers given by an user.
    * 
    * Arguments:
    * 
    * - max_times: An integer that indicates the maximum times that an user
    *   can insert a number.
   */
    public static void equal_integers(int max_times){
        // Variables
        int previous_number = 0;
        boolean equal = false; 
        
        // to make a comparison it's necessary that the input recieve al least 2 or more integers
        if(max_times <= 1 ){
            System.out.println("the mininmun value for -max_times- variable should be 2.");
        }
        else{
            // Input integer through command line interface
            for( int countdown_loop = max_times; (countdown_loop > 0) && !StdIn.isEmpty(); countdown_loop-- ) {
            
                //Get the value
                int value = StdIn.readInt();       
            
                // Operation in the first loop
                if(countdown_loop == max_times){
                    previous_number = value;
                }
            
                // Comparison from the second loop on
                else{
                    if (previous_number != value){
                        equal = false;
                        // Break the loop to avoid wasting resources
                        break;
                    }else{
                        equal = true;
                    }
                }
            }
            // Print results
            print_results(equal);  
        }        
    }
    
    /*
     * Function to print the results
     */
    public static void print_results(boolean equal){
         if(equal){
            System.out.println("equal");
        }else{
            System.out.println("not equal");
        }
    }
    
    /*
     * Test function 
    */
    public static void main(String[] args) {
        equal_integers(3);
    }
}