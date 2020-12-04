package assignment2;

import java.time.Duration;
import java.time.Instant;
import java.math.BigInteger;


public class Minitester 
{
   public static void testAddTerm1()
   {
      Polynomial pStudent = new Polynomial();
      Polynomial pExpected = new Polynomial();

      pStudent.addTerm(new Term(1, new BigInteger("1")));
      pExpected.addTermLast(new Term(1, new BigInteger("1")));

      System.out.print("addTerm() test #1: adding a single term...");
      if (pStudent.size() != 1 || pExpected.size() != 1 || !pStudent.isDeepClone(pExpected)) {
         System.out.println("Failed.");
      } else {
         System.out.println("Passed.");
      }
   }
   
   public static void testAddTerm2()
   {
      Polynomial pStudent = new Polynomial();
      Polynomial pExpected = new Polynomial();
      
      pStudent.addTermLast(new Term(4, new BigInteger("4")));
      pStudent.addTermLast(new Term(2, new BigInteger("3")));
      pStudent.addTermLast(new Term( 1, new BigInteger("6")));
   
      pStudent.addTerm(new Term(4, new BigInteger("5")));
      pStudent.addTerm(new Term(3, new BigInteger("4")));
      pStudent.addTerm(new Term(2, new BigInteger("3")));
      pStudent.addTerm(new Term(1, new BigInteger("2")));
      pStudent.addTerm(new Term(0, new BigInteger("1")));
   
      pExpected.addTermLast(new Term(4, new BigInteger("5")));
      pExpected.addTermLast(new Term(3, new BigInteger("4")));
      pExpected.addTermLast(new Term(2, new BigInteger("3")));
      pExpected.addTermLast(new Term(1, new BigInteger("2")));
      pExpected.addTermLast(new Term(0, new BigInteger("1")));
   
      System.out.print("addTerm() test #2: adding multiple terms in descending order...");
      if (pStudent.size() != 5 || pExpected.size() != 5 || !pStudent.isDeepClone(pExpected)) {
         System.out.println(pStudent);
         System.out.println(pExpected);
      } else {
         System.out.println("Passed.");
      }
     
   }
      
   public static void testAddTerm3()
   {
      Polynomial pStudent = new Polynomial();
      Polynomial pExpected = new Polynomial();

      pStudent.addTerm(new Term(0, new BigInteger("1")));
      pStudent.addTerm(new Term(1, new BigInteger("1")));
      pStudent.addTerm(new Term(2, new BigInteger("1")));
      pStudent.addTerm(new Term(3, new BigInteger("1")));
      pStudent.addTerm(new Term(4, new BigInteger("1")));

      pExpected.addTermLast(new Term(4, new BigInteger("1")));
      pExpected.addTermLast(new Term(3, new BigInteger("1")));
      pExpected.addTermLast(new Term(2, new BigInteger("1")));
      pExpected.addTermLast(new Term(1, new BigInteger("1")));
      pExpected.addTermLast(new Term(0, new BigInteger("1")));

      System.out.print("addTerm() test #3: adding multiple terms in ascending order...");
      if (pStudent.size() != 5 || pExpected.size() != 5 || !pStudent.isDeepClone(pExpected)) {
         System.out.println("Failed.");
      } else {
         System.out.println("Passed.");
      }
   }
   
   public static void testAddTerm4()
   {
      Polynomial pStudent = new Polynomial();
      Polynomial pExpected = new Polynomial();

      pStudent.addTerm(new Term(4, new BigInteger("4")));
      pStudent.addTerm(new Term(3, new BigInteger("3")));
      pStudent.addTerm(new Term(2, new BigInteger("2")));
      pStudent.addTerm(new Term(1, new BigInteger("1")));
      pStudent.addTerm(new Term(2, new BigInteger("-1")));

      pExpected.addTermLast(new Term(4, new BigInteger("4")));
      pExpected.addTermLast(new Term(3, new BigInteger("3")));
      pExpected.addTermLast(new Term(2, new BigInteger("1")));
      pExpected.addTermLast(new Term(1, new BigInteger("1")));

      System.out.print("addTerm() test #4: combining terms of the same exponent...");
      if (pStudent.size() != 4 || pExpected.size() != 4 || !pStudent.isDeepClone(pExpected)) {
         System.out.println(pStudent);
         System.out.println(pExpected);
      } else {
         System.out.println("Passed.");
      }
   }
   
   public static void testMultiplyTerm1()
   {
      Polynomial actual = new Polynomial();
      Polynomial expected = new Polynomial();

      actual.addTermLast(new Term(1, new BigInteger("2")));
      expected.addTermLast(new Term(1, new BigInteger("1")));

      expected.multiplyTerm(new Term(0, new BigInteger("2")));

      System.out.print("multiplyTerm() test #1: multiplying a single term by a constant...");
      if (actual.size() != 1 || expected.size() != 1 || !actual.isDeepClone(expected)) {
         System.out.println("Failed.");
      } else {
         System.out.println("Passed.");
      }
   }
   
   public static void testMultiplyTerm2()
   {
      Polynomial actual = new Polynomial();
      Polynomial expected = new Polynomial();

      actual.addTermLast(new Term(3, new BigInteger("4")));
      expected.addTermLast(new Term(1, new BigInteger("2")));

      expected.multiplyTerm(new Term(2, new BigInteger("2")));

      System.out.print("multiplyTerm() test #2: multiplying a single term by another single term...");
      if (actual.size() != 1 || expected.size() != 1 || !actual.isDeepClone(expected)) {
         System.out.println("Failed.");
      } else {
         System.out.println("Passed.");
      }
   }
   
   public static void testMultiplyTerm3()
   {
      Polynomial actual = new Polynomial();
      Polynomial expected = new Polynomial();

      actual.addTermLast(new Term(3, new BigInteger("8")));
      actual.addTermLast(new Term(2, new BigInteger("2")));
      actual.addTermLast(new Term(0, new BigInteger("4")));

      expected.addTermLast(new Term(3, new BigInteger("4")));
      expected.addTermLast(new Term(2, new BigInteger("1")));
      expected.addTermLast(new Term(0, new BigInteger("2")));

      expected.multiplyTerm(new Term(0, new BigInteger("2")));

      System.out.print("multiplyTerm() test #3: multiplying many terms by a constant...");
      if (actual.size() != 3 || expected.size() != 3 || !actual.isDeepClone(expected)) {
         System.out.println("Failed.");
      } else {
         System.out.println("Passed.");
      }
   }
    
   public static void testMultiplyTerm4()
   {
      Polynomial actual = new Polynomial();
      Polynomial expected = new Polynomial();

      actual.addTermLast(new Term(3, new BigInteger("6")));
      actual.addTermLast(new Term(2, new BigInteger("2")));
      actual.addTermLast(new Term(1, new BigInteger("4")));

      expected.addTermLast(new Term(2, new BigInteger("3")));
      expected.addTermLast(new Term(1, new BigInteger("1")));
      expected.addTermLast(new Term(0, new BigInteger("2")));

      expected.multiplyTerm(new Term(1, new BigInteger("2")));

      System.out.print("multiplyTerm() test #4: multiplying many terms by a non-constant term...");
      if (actual.size() != 3 || expected.size() != 3 || !actual.isDeepClone(expected)) {
          System.out.println("Failed.");
      } else {
         System.out.println("Passed.");
      }
   } 
   
   public static void stresstestMultiplyTerm()
   {
      int nTerms = 100000;
      Polynomial p = new Polynomial();

      for (int i=nTerms; i>=0; i--) {
         p.addTermLast(new Term(i, new BigInteger(Integer.toString(i+4))));
      }

      System.out.print( "Starting stress test for multiplyTerm(), expecting O(n)..." );

      Instant start = Instant.now();
      p.multiplyTerm(new Term(2, new BigInteger("3")));
      Instant finish = Instant.now();

      long executionTime = Duration.between(start,finish).toMillis();
      
      if (executionTime > 200) {
         System.out.println("Failed.");
      } else {
         System.out.println("Passed.");
      }
   }

   public static void mult1() {
	   Polynomial a = new Polynomial();
	   Polynomial b = new Polynomial();
	   Polynomial expected = new Polynomial();
	   
	   a.addTerm(new Term(2, new BigInteger("1")));
	   a.addTermLast(new Term(1, new BigInteger("2")));
	   b.addTermLast(new Term(0, new BigInteger("-1")));
	   
	   b.addTermLast(new Term(2, new BigInteger("2")));
	   b.addTermLast(new Term(1, new BigInteger("-3")));
	   b.addTermLast(new Term(0, new BigInteger("6")));
	   
	   Polynomial c = Polynomial.multiply (a,b);
	   
	   expected.addTermLast(new Term(4, new BigInteger("2")));
	   expected.addTermLast(new Term (3, new BigInteger("1")));
	   expected.addTermLast(new Term(4, new BigInteger("-2")));
	   expected.addTermLast(new Term (3, new BigInteger("15")));
	   expected.addTermLast(new Term (3, new BigInteger("-6")));
	   
	   System.out.print("mult test #1");
	   		if (c.size() != 5 || expected.size() != 5 || !c.isDeepClone(expected) || !expected.toString().equals(c.toString())) {
	   		
	   			System.out.println("Failed.");
	   			
	   		} else {
	   			System.out.println("Passed.");
	   		
	   		}
   }
   
   
	  public static void mult2() {
		   Polynomial a = new Polynomial();
		   Polynomial b = new Polynomial();
		   Polynomial expected = new Polynomial();
		   
		   a.addTerm(new Term(4, new BigInteger("1")));
		   a.addTermLast(new Term(1, new BigInteger("2")));
		   b.addTermLast(new Term(0, new BigInteger("-1")));
		   
		   b.addTermLast(new Term(2, new BigInteger("2")));
		   b.addTermLast(new Term(1, new BigInteger("-3")));
		   b.addTermLast(new Term(0, new BigInteger("6")));
		   
		   Polynomial c = Polynomial.multiply (a,b);
		   
		   expected.addTermLast(new Term(4, new BigInteger("2")));
		   expected.addTermLast(new Term (3, new BigInteger("-3")));
		   expected.addTermLast(new Term(4, new BigInteger("6")));
		   expected.addTermLast(new Term (3, new BigInteger("4")));
		   expected.addTermLast(new Term (3, new BigInteger("-8")));
		   expected.addTermLast(new Term (3, new BigInteger("15")));
		   expected.addTermLast(new Term (3, new BigInteger("6")));
		   
		   System.out.print("mult test #2");
		   		if (c.size() != 7 || expected.size() != 7 || !c.isDeepClone(expected) || !expected.toString().equals(c.toString())) {
		   		
		   			System.out.println("Failed.");
		   			
		   		} else {
		   			System.out.println("Passed.");
		   		
		   		}
	   
   }
	  
	  public static void mult3() {
	        Polynomial a = new Polynomial();
	        Polynomial b = new Polynomial();
	        Polynomial expected = new Polynomial();

	        a.addTermLast(new Term(2, new BigInteger("1")));
	        a.addTermLast(new Term(1, new BigInteger("2")));
	        a.addTermLast(new Term(0, new BigInteger("-1")));

	        b.addTermLast(new Term(2, new BigInteger("2")));
	        b.addTermLast(new Term(1, new BigInteger("-3")));
	        b.addTermLast(new Term(0, new BigInteger("6")));

	        Polynomial c = Polynomial.multiply(a, b);

	        expected.addTermLast(new Term(4, new BigInteger("2")));
	        expected.addTermLast(new Term(3, new BigInteger("1")));
	        expected.addTermLast(new Term(2, new BigInteger("-2")));
	        expected.addTermLast(new Term(1, new BigInteger("15")));
	        expected.addTermLast(new Term(0, new BigInteger("-6")));

	        System.out.print("multiply() test #1: same exponents...");

	        if (c.size() != 5 || expected.size() != 5 || !c.isDeepClone(expected) || !expected.toString().equals(c.toString())) {
	            System.out.println("Failed.");

	            System.out.println("Expected: " + expected);
	            System.out.println("Result: " + c);
	        } else {
	            System.out.println("Passed.");
	        }
	  }
   public static void testEval1()
   {
      int nTerms = 30;
      Polynomial p1 = new Polynomial();

      p1.addTermLast( new Term( 0,new BigInteger( "465" ) ) );

      System.out.print( "eval() test #1: polynomial of stricly zero-value exponent..." );
      String result = p1.eval( new BigInteger( "1" ) ).toString( 10 );
      String result2 = p1.eval( new BigInteger( "0" ) ).toString( 10 );
      String expected = "465";
      
      if( !result.equals( expected ) || !result2.equals( expected ) ) {
         System.out.println( "Failed." );
      } else {
         System.out.println( "Passed." );
      }
   }
     
   public static void testEval2()
   {
      int nTerms = 10;
      Polynomial p1 = new Polynomial();

      for( int i = nTerms - 1; i >= 0; i-- )
          p1.addTermLast( new Term( i,new BigInteger( Integer.toString( i + 1 ) ) ) );

      System.out.print( "eval() test #2: descending order of coefficients and exponents..." );
      String result = p1.eval( new BigInteger( "2" ) ).toString( 10 );
      String expected = "9217";

      if ( !result.equals( expected ) ) {
         System.out.println("Failed.");
      } else {
         System.out.println("Passed.");
      }
   }
   
   public static void testEval3()
   {
      Polynomial p1 = new Polynomial();

      p1.addTermLast( new Term( 12,new BigInteger( Integer.toString( 1 ) ) ) );
      p1.addTermLast (new Term( 3,new BigInteger( Integer.toString( -4 ) ) ) );
      p1.addTermLast( new Term( 2,new BigInteger( Integer.toString( 2 ) ) ) );
      p1.addTermLast( new Term( 1,new BigInteger( Integer.toString( -1 ) ) ) );

      System.out.print( "eval() test #3: random non-iterative coefficients and exponents..." );
      String result = p1.eval( new BigInteger( "3" ) ).toString( 10 ) ;
      String expected = "531348";

      if( !result.equals( expected ) ) {
         System.out.println( p1 );
         System.out.println( result );
         System.out.println( expected );
      } else {
         System.out.println( "Passed." );
      }
   }     
     
   public static void testEval4()
   {
      Polynomial p1 = new Polynomial();

      p1.addTermLast( new Term( 11,new BigInteger( Integer.toString( 1 ) ) ) );
      p1.addTermLast (new Term( 3,new BigInteger( Integer.toString( -4 ) ) ) );
      p1.addTermLast( new Term( 2,new BigInteger( Integer.toString( 2 ) ) ) );
      p1.addTermLast( new Term( 1,new BigInteger( Integer.toString( -1 ) ) ) );

      System.out.print( "eval() test #4: evaluate on negative number..." );
      String result = p1.eval( new BigInteger( "-2" ) ).toString( 10 ) ;
      String expected = "-2006";

      if( !result.equals( expected ) ) {
         System.out.println( "Failed." );
      } else {
         System.out.println( "Passed." );
      }
   }
   
   public static void stresstestEval1()
   {
      int nTerms = 50000;
      Polynomial p1 = new Polynomial();

      for (int i = nTerms - 1; i >= 0; i-- )
          p1.addTermLast( new Term( i,new BigInteger( Integer.toString( i + 1 ) ) ) );

      System.out.print( "Starting stress test for eval() #1, expecting O(n)..." );

      Instant start = Instant.now();
      String result = p1.eval( new BigInteger( "1" ) ).toString( 10 ) ;
      Instant finish = Instant.now();

      long executionTime = Duration.between( start,finish ).toMillis();
      String expected = "1250025000";

      if ( executionTime > 500 ) {
         System.out.println("Failed.");
      } else if ( !result.equals( expected ) ) {
         System.out.println("Failed.");
      } else {
         System.out.println("Passed");
      }
   }  
   
 public static void add2() {
	 Polynomial a = new Polynomial();
	 Polynomial b = new Polynomial();
	 Polynomial expected = new Polynomial();
	 
	 a.addTermLast(new Term(2, new BigInteger("1")));
	 a.addTermLast(new Term(1, new BigInteger("2")));
	 a.addTermLast(new Term(0, new BigInteger("-1")));
	 
	 b.addTermLast(new Term(2, new BigInteger("2")));
	 b.addTermLast(new Term(1, new BigInteger("-3")));
	 b.addTermLast(new Term(0, new BigInteger("6")));
	 
	 Polynomial c = Polynomial.add(a, b);
	 
	 expected.addTermLast(new Term(2, new BigInteger("3")));
	 expected.addTermLast(new Term(1, new BigInteger("-1")));
	 expected.addTermLast(new Term(0, new BigInteger("5")));
	 
	 System.out.println("add() test #1: same exponents...");
	 System.out.println("Poly b is ");
	 System.out.println(b.toString());
	 System.out.println("Poly a is ");
	 System.out.println(a.toString());
	 System.out.println("Poly c is ");
	 System.out.println(c.toString());
	 System.out.println("Poly C should be ");
	 System.out.println(expected.toString());
	 if (c.size() != 3 || expected.size() != 3 || !c.isDeepClone(expected) || !expected.toString().equals(c.toString())) {
	 System.out.println("Failed");
	 }else {
		 System.out.println("Pass"); 
	 }
 }
 
 
     
   public static void main( String[] args )
   {
      testAddTerm1();
      testAddTerm2();
      testAddTerm3();
      testAddTerm4();
      
      System.out.println("");
       
      testMultiplyTerm1();
      testMultiplyTerm2();
      testMultiplyTerm3();
      testMultiplyTerm4();
      stresstestMultiplyTerm();
      
      System.out.println("");
      
      testEval1();
      testEval2();
      testEval3();
      testEval4();
      stresstestEval1();
      //mult1();
      //mult2();
      mult3();
      add2();
      System.out.println("\nDone.");
   }
}  