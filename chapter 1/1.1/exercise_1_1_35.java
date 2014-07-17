/****************************************************************************** 
 *   Exercise 1.1.35
 * 
 *   This file is released under the GNU General Public License, 
 *   version 3 (GPLv3).
 * 
 *   This file is based on these files: 
 *
 *   Compilation:  javac exercise_1_1_35.java
 *   Execution:    java exercise_1_1_35
 *  
 *   @author Koldo González
 *             
 *****************************************************************************/


public class exercise_1_1_35 {
   
 /*
  * Dice simulation   
  */
    public static void dice_sim(){
    
        int sides = 6;
        double[] dist = new double[2*sides+1];
        for( int i = 0; i <= sides; i++){
            for( int j = 0; j <= sides; j++){
                dist[i+j] += 1.0;
            }
        }
        for( int k = 0; k <= 2*sides; k++){
            dist[k] /= 36.0;
        }
        
        print(dist);
    }
    
    /*
     * Print nested array 
    */
    public static void print( double[] m){
    
        System.out.println("-----------------------------");
       
          for(int h = 0; h < m.length; h++){
              System.out.println( h + "  =>  " + m[h]);
          }
           
        System.out.println("-----------------------------");
    }
    
  /*
   * Test function
  */
  public static void main(String[] args) {
      dice_sim();
    
  }
}