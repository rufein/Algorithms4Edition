
/****************************************************************************** 
 *   Exercise 1.1.10
 * 
 *   This file is released under the GNU General Public License, 
 *   version 3 (GPLv3).
 * 
 *   This file is based on these files: 
 *   
 *
 *   Compilation:  javac exercise_1_1_10.java
 *   Execution:    java exercise_1_1_10
 * 
 *   @author Koldo González
 *             
 *****************************************************************************/

public class exercise_1_1_10{
    
    public static void code_fragment(int M){
       int[] a = new int[M];
       for(int i = 0; i < M; i++){
           a[i] = i * 1;
       }  
    }
    
    /*
     * Test function 
    */
    public static void main(String[] args) {
        code_fragment(10);
    }
}