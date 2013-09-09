
/*  
 *  Exercise 1.1.21
 */

public class exercise_1_1_21{
    
    /*
     * Function to print a line to separate the data 
    */
    public static void separator(){
        System.out.println("------------------------------------------");
    } 
    
    /*
     * Function to format the output
    */
    public static void format_arg(String[] args){
       
        String line = "|";
        
        // Build arguments
        for( int n = 0; n < args.length ; n++ ){
            line += "  " + args[n] + "  |";
        }
        
        // Calculate the division
        double arg1 = Double.parseDouble(args[1]);
        double arg2 = Double.parseDouble(args[2]);
        double value = arg1 / arg2;
        line += "  " + "%.3f%n";
        
        // Print foemated string
        System.out.printf( line , value );
        
        // Separator
        separator();
    }
    
    /*
     * Function to resize an array with +1 space 
    */
    public static String[] resize_array(String[] array, String new_value){
        int length = array.length;
        String[] new_array = new String[ (length + 1) ];
        for(int n = 0; n < length ; n++ ){
            new_array[n] =  array[n];
        }
        new_array[length] = new_value;
        return new_array;
    }
     
    /*
     * Test function 
    */
    public static void main(String[] args) {
        
        // Instructions
        System.out.println("Push -Enter- or write -end- to finish the program");
        
        String[] lines = new String[0];
            
        while( StdIn.hasNextLine() ){
            
            String line = StdIn.readLine();
            // Print the table is nothing is send
            // The data is stored in array -lines-
            if( line.equals("") || line.equals("end") ){
                 separator();
                 for(int n = 0; n < lines.length ; n++ ){
                     format_arg( lines[n].split(" ") );
                 }
                 break;
            }else{
                // Store data in array
                lines = resize_array( lines , line );
            }
        }     
    }
}