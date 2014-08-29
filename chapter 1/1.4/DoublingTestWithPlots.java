
/****************************************************************************** 
 *   Exercise 1.4.3
 * 
 *   This file is released under the GNU General Public License, 
 *   version 3 (GPLv3).
 * 
 *   This file is based on these files: 
 *   http://algs4.cs.princeton.edu/14analysis/DoublingTest.java.html
 *
 *   Compilation:  javac DoublingTestWithPlots.java
 *   Execution:    java DoublingTestWithPlots 
 *                
 * 
 *   @author Koldo González
 *             
 *****************************************************************************/


public class DoublingTestWithPlots {

    // This class should not be instantiated.
    private DoublingTestWithPlots() { }

    /**
     * Returns the amount of time to call <tt>ThreeSum.count()</tt> with <em>N</em>
     * random 6-digit integers.
     * @param N the number of integers
     * @return amount of time (in seconds) to call <tt>ThreeSum.count()</tt>
     *   with <em>N</em> random 6-digit integers
     */
    public static double timeTrial(int N) {
        int MAX = 1000000;
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform(-MAX, MAX);
        }
        Stopwatch timer = new Stopwatch();
        int cnt = ThreeSum.count(a);
        return timer.elapsedTime();
    }
    
    /*
     * Function to plrint the plots 
    */
    public static void plot( int N , double[] c ){
        
        double height = c[c.length - 1];
        double width = N * Math.pow( 2,  c.length - 1);
        
        StdDraw.setXscale(0, width);
        StdDraw.setYscale(0, height);
        
        // Horizontal bar to measure the graphic ( Y axis )
        StdDraw.setPenRadius(.001);
        StdDraw.line( 0, 0, 0, height );
        
        double base = height / 10;
        for ( int i = 1; i <= 10; i++ ){
            double quantity =  base * i ;
            StdDraw.text( (width / 100 * 10) , quantity, String.valueOf(quantity) + " sec" );
        }
        
       // Graphic
        for (int i = 0; i < c.length; i++ ){
            StdDraw.setPenRadius(.02);
            double x = N * Math.pow( 2, i);
            double y = c[i];
            StdDraw.point(x, y);
            
            // Lines
            if( i > 0 ){
                StdDraw.setPenRadius(.01);
                double x1 = N * Math.pow( 2, i - 1);
                double y1 = c[i - 1];
                StdDraw.line( x1, y1, x, y);
            }
        }
    }
    
    /*
     * Function to draw a log - log plot 
    */
    public static void log_plot( int N , double[] c ){
        
        double height = 10;
        double width = N * c.length;
        
        StdDraw.setXscale(0, width);
        StdDraw.setYscale(0, height);
        
        // Horizontal bar to measure the graphic ( Y axis )
        StdDraw.setPenRadius(.001);
        StdDraw.line( 0, 0, 0, height );
        
        double base = height / 10;
        double[] log_base = new double[11];
        log_base[0] =  c[c.length - 1];
        
        for ( int i = 0; i < 10; i++ ){
            double position =  base * i ;
            StdDraw.text( (width / 100 * 10) , height - position, String.valueOf(log_base[i]) + " sec" );
            log_base[i+1] = log_base[i] / 2;
            
            // Round only to 2 decimals
            log_base[i+1] = (double) Math.round(log_base[i+1]*100)/100;
        }
        
       // Graphic
        for (int i = 0; i < c.length; i++ ){
            StdDraw.setPenRadius(.02);
            double x = N * (i + 1) ;
            double y = calc( log_base, c[i] );
            StdDraw.point(x, y);
            
            // Lines
            if( i > 0 ){
                StdDraw.setPenRadius(.01);
                double x1 = N * i;
                double y1 = calc( log_base, c[i - 1] );
                StdDraw.line( x1, y1, x, y);
            }
        }
    }
    
    /*
     * Function to calculate the y axis in a log log plot
    */
    public static double calc( double[] scale, double value){
        double r = 10;
        for ( int i = 0; i < scale.length; i++){
            if ( scale[i] > value ){ 
                r -= 1;
                continue; 
            }
            else if ( scale[i] == value){ 
                break;
            }
            else{
                // Break in case the value is upper of the greatest value in the scale
                if ( i == 0) { break; }
                
                double diff = scale[i - 1] - scale[i];
                double val_diff = value - scale[i];
                // Differente t obtain value betwwn 0 and 1
                r += val_diff / diff;
                
                break;
            }
        }
        return r;
    }

    /**
     * Prints table of running times to call <tt>ThreeSum.count()</tt>
     * for arrays of size 250, 500, 1000, 2000, and so forth.
     */
    public static void main(String[] args) {
        double[] c = new double[6];
        int M = 250;
        int index = 0;
        /*
        for (int N = M; N <= 8000; N += N) {
            double time = timeTrial(N);
            c[index] = time;
            StdOut.printf("%7d %5.1f\n", N, time);
            index++;
        }*/
        c[0] = 0.0;
        c[1] = 0.05;
        c[2] = 0.1;
        c[3] = 0.6;
        c[4] = 4.5;
        c[5] = 38.7;
        // plot( M, c );
        log_plot( M, c );
    } 
} 