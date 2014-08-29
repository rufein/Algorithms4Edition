
/****************************************************************************** 
 *   Exercise 1.2.16
 * 
 *   This file is released under the GNU General Public License, 
 *   version 3 (GPLv3).
 * 
 *   This file is based on these files: 
 * 
 *
 *   Compilation:  java Rational.java
 *   Execution:    java Rational
 * 
 *   @author Koldo González
 *             
 *****************************************************************************/

 
public class Rational {
   
    // Variables
    private final long numerator;
    private final long denominator;
   
    
    // Coonstructor
    public Rational( long numerator, long denominator ){
        
        // Inital vales
        this.numerator = numerator;
        this.denominator = denominator;
    }
    
    // Getters
    public long numerator(){
        return this.numerator;
    }
    
    public long denominator(){
        return this.denominator;
    }
    
    // Add functions
    public Rational plus( Rational b ){
        long n = ( b.denominator() * this.numerator() ) + ( b.numerator() *  this.denominator() );
        long d = this.denominator() * b.denominator();
        return new Rational( n, d);
    }
    
    public Rational minus( Rational b ){
        Rational a = new Rational ( - b.numerator(), b.denominator() );
        return this.plus( a );
    }
    
    // Multiply funcitons
    public Rational times( Rational b ){
        long n = b.numerator() * this.numerator();
        long d = this.denominator() * b.denominator();
        return new Rational( n, d);
    }
    
    public Rational divide( Rational b ){
        long n = b.numerator() * this.denominator();
        long d = this.numerator() * b.denominator();
        return new Rational( d, n);
    }
    
    public long gcd( long p, long q){
        if ( q == 0) return p;
        long r = p % q;
        return gcd(q, r);
    }
    
    // Equals
    public boolean equals( Rational that ){
        if ( (this.numerator() / that.numerator() ) == ( this.denominator() / that.denominator()) ){
            return true;
        }
        return false;    
    }
    
    // to string
    public String tostring(){
        return this.numerator() + " / " + this.denominator();
    }
    
  /*
   * Test function
  */
  public static void main(String[] args) {
      
    Rational r1 = new Rational(1, 2);
    Rational r2 = new Rational(1, 4);
    Rational r3 = new Rational(2, 8);
    
    Rational sum = r1.plus(r2);
    Rational substract = r1.minus(r2);
    Rational substract2 = r2.minus(r1);
    Rational multiply  = r1.times(r2);
    Rational division = r2.divide(r1);
    boolean eq = r1.equals(r2);
    boolean eq2 = r1.equals(r3);
    
    StdOut.println("Rational number 1: " + r1.tostring() );
    StdOut.println("Rational number 2: " + r2.tostring() );
    StdOut.println("Rational number 3: " + r3.tostring() );
    
    StdOut.println("Sum r1 and r2: " + sum.tostring() );
    StdOut.println("Substract r1 and r2: " + substract.tostring() );
    StdOut.println("Substract r2 and r1: " + substract2.tostring() );
    StdOut.println("Multiply r1 and r2: " + multiply.tostring() );
    StdOut.println("Division r2 and r1: " + division.tostring() );
    StdOut.println("r1 and r2 are equal?: " + eq );
    StdOut.println("r1 and rr are equal?: " + eq2 );
        
  }  
      
 
}