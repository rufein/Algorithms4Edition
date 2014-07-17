/****************************************************************************** 
 *   Exercise 1.1.33
 * 
 *   This file is released under the GNU General Public License, 
 *   version 3 (GPLv3).
 * 
 *   This file is based on these files: 
 *
 *   Compilation:  javac exercise_1_1_33.java
 *   Execution:    java exercise_1_1_33
 *  
 *   @author Koldo González
 *             
 *****************************************************************************/

public class exercise_1_1_33 {
   
    public static double dot(double[] x , double[] y){
        
        if( x.length != y.length ){
            throw new IllegalArgumentException("The vectors have different length");
        }
        
        double result = 0;
        
        for( int i = 0; i < x.length; i++ ){
            result += (x[i] * y[i]);
        }
       
        return result;
    }
    
    public static double[][] transpose(double[][] a){
    
        int x = a.length;
        int y = a[0].length;
        double[][] b = new double[y][x];
        
        for( int i = 0; i < a.length; i++ ){
            for( int h = 0; h < a[i].length; h++ ){
                b[h][i] = a[i][h];
            }
        }
        
        return b;   
    }
    
    public static double[][] mult( double[][] a , double[][] b){
    
        int x = a.length;
        int y = b[0].length;
        
        double[][] result = new double[x][y];
        
        for( int i = 0; i < a.length; i++ ){
                result[i] = mult( a[i], b );
        }
        
        return result;
        
    }
    
    public static double[] mult(double[][] a , double[] x){
        
        double[] result = new double[x.length];
        
        for( int i = 0; i < a.length; i++ ){
            result[i] = dot( x, a[i] );
        }
        
        return result;
        
    }
    
    public static double[] mult(double[] y, double[][] b){
        
        double[][] b_tran = transpose(b);
        
        double[] result = new double[b_tran.length];
        
        for( int i = 0; i < b_tran.length; i++ ){
            result[i] = dot( y, b_tran[i] );
        }
        
        return result;
    }
    
    /*
     * Print nested array 
    */
    public static void print_matrix( double[][] m){
    
        System.out.println("-----------------------------");
        
        for( int i = 0; i < m.length; i++ ){
          String s = "";
          for(int h = 0; h < m[i].length; h++){
              s += " " + m[i][h] ;
          }
          System.out.println(s);
      }
        
        System.out.println("-----------------------------");
    }
    
    public static void print_matrix( double[] m){
    
        System.out.println("-----------------------------");
        
          String s = "";
          for(int h = 0; h < m.length; h++){
              s += " " + m[h] ;
          }
          System.out.println(s);
        
        System.out.println("-----------------------------");
    }

  /*
   * Test function
  */
  public static void main(String[] args) {
      
      double[] a = { 1, 0, 0};
      double[] b = { 3, 4, 3};
      double[] c = { 2, 1};
      double[] d = { 0, 3};
      double[] e = { 1, 0};
      
      double[][] matrix_A = { a, b};
      double[][] matrix_B = { c, d, e};
      
      double[][] result = mult( matrix_A, matrix_B);
      double[][] result2 = mult( matrix_B, matrix_A);
      
      print_matrix( result );
      print_matrix( result2 );
  }
}