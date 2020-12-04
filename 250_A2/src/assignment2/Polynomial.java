package assignment2;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Iterator;

public class Polynomial implements DeepClone<Polynomial>
{
	private SLinkedList<Term> polynomial;
	public int size()
	{ 
		return polynomial.size();
	}
	private Polynomial(SLinkedList<Term> p)
	{
		polynomial = p;
	}

	public Polynomial()
	{
		polynomial = new SLinkedList<Term>();
	}

	// Returns a deep copy of the object.
	public Polynomial deepClone()
	{ 
		return new Polynomial(polynomial.deepClone());
	}


	/* 
	 * TODO: Add new term to the polynomial. Also ensure the polynomial is
	 * in decreasing order of exponent.
	 */
	public void addTerm(Term t) {

		//poly is empty
		if (this.polynomial.size() == 0) {
			this.polynomial.addLast(t);
			return;
		}

		//counter for prev
		int i=0;
		//
		Iterator<Term> iter1= polynomial.iterator();
		//returns head node
		Term current=iter1.next();


		if (t.getExponent() > current.getExponent()) {
			this.polynomial.addFirst(t);
			return;
		}
		
		for (Term cur: this.polynomial) {
		/*while (iter1.hasNext()) {
			System.err.println(i);
			System.err.println(current);
			System.err.println(t.getExponent());
			System.err.println(current.getExponent());
			System.err.println(this.polynomial);
			System.err.println( ""); 
*/
			if (t.getExponent() < cur.getExponent()) {
				i++;
				//cur = iter1.next();
				continue;

			}
			//if exponents are equal, update value of exponent with new index
			if (cur.getExponent() == t.getExponent()) {

				//replace element with addition of 2 coefficients at index i 
				cur.setCoefficient(t.getCoefficient().add(cur.getCoefficient()));
				if (cur.getCoefficient().equals(0)){
					this.polynomial.remove(i);
				}
				return;
			}

			else {
				this.polynomial.add(i,t);
				return;
			}
		}
		//if not equal, add 
		
		this.polynomial.addLast(t);

		System.out.println(this.polynomial);
	}
	
	public Term getTerm(int index)
	{
		return polynomial.get(index);
	}

	private static void ifHasNext(Polynomial p1, Polynomial p2) {

		Polynomial newPoly = new Polynomial();

		Iterator<Term> iter1= p1.polynomial.iterator();
		Iterator<Term> iter2= p2.polynomial.iterator();

		Term p1Term = iter1.next();
		Term p2Term = iter2.next();
		while(iter1.hasNext() || iter2.hasNext()) {
			if(iter1.hasNext() && iter2.hasNext()) {
				p1Term = iter1.next();
				p2Term = iter2.next();
			}
			else if(iter2.hasNext()) {
				p2Term = iter2.next();
				while(iter2.hasNext()) {
					newPoly.polynomial.addLast(p2Term);
					p2Term = iter2.next();
				}
				newPoly.polynomial.addLast(p2Term);
				break;
			}
			else if(iter1.hasNext()) {
				p1Term = iter1.next();
				while(iter1.hasNext()) {
					newPoly.polynomial.addLast(p1Term);
					p1Term = iter1.next();
				}
				newPoly.polynomial.addLast(p1Term);
				break;
			} 
			else {
				break;
			}
		}

	}

	//TODO: Add two polynomial without modifying either

	//make new linked list thats copy of p1 using deep clone
	public static Polynomial add(Polynomial p1, Polynomial p2){

		Polynomial newPoly = new Polynomial();

		Iterator<Term> iter1= p1.polynomial.iterator();
		Iterator<Term> iter2= p2.polynomial.iterator();

		Term p1Term = iter1.next();
		Term p2Term = iter2.next();

		while (true) {

			if (p1Term.getExponent() > p2Term.getExponent()) {
				newPoly.polynomial.addLast(p1Term);
				newPoly.polynomial.addLast(p2Term);
				ifHasNext(p1,p2);
			}

			else if (p2Term.getExponent()>p1Term.getExponent()) {
				newPoly.polynomial.addLast(p2Term);
				newPoly.polynomial.addLast(p1Term);
				ifHasNext(p1,p2);
			}
			else {
				BigInteger newC = (p1Term.getCoefficient().add(p2Term.getCoefficient()));
				if (newC==BigInteger.valueOf(0)) { 
					continue;}

				else {
					newPoly.polynomial.addLast(new Term(p1Term.getExponent(),newC));
				}
				if(iter1.hasNext() && iter2.hasNext()) {
					p1Term = iter1.next();
					p2Term = iter2.next();
				}
				else if(iter2.hasNext()) {
					p2Term = iter2.next();
					while(iter2.hasNext()) {
						newPoly.polynomial.addLast(p2Term);
						p2Term = iter2.next();
					}
					newPoly.polynomial.addLast(p2Term);
					break;
				}
				else if(iter1.hasNext()) {
					p1Term = iter1.next();
					while(iter1.hasNext()) {
						newPoly.polynomial.addLast(p1Term);
						p1Term = iter1.next();
					}
					newPoly.polynomial.addLast(p1Term);
					break;
				} 
				else {
					break;
				}

			}

		}

		return newPoly;
	}



	//TODO: multiply this polynomial by a given term.
	public void multiplyTerm(Term t)
	{

		//iterating through terms of this polynomial
		for (Term currentTerm: this.polynomial) {

			//update terms with addition of exponents of polynomial w/ term, and multiplies of coefficients
			currentTerm.setExponent(currentTerm.getExponent()+ t.getExponent());
			currentTerm.setCoefficient(currentTerm.getCoefficient().multiply(t.getCoefficient()));
		}

	}

	//TODO: multiply two polynomials
	public static Polynomial multiply(Polynomial p1, Polynomial p2)
	{
		//iterate thru linkedlist with enhanced for loop
		//put values into array and then convert back into linked list

		Iterator<Term> iter1= p1.polynomial.iterator();
		Iterator<Term> iter2= p2.polynomial.iterator();

		Term p1Term = iter1.next();
		Term p2Term = iter2.next();

		//get head Exponent of both poly to get size of array
		int m = p1Term.getExponent();
		int n = p2Term.getExponent();

		//create array and poly
		int[] prodArray = new int[m + n + 1]; 
		Polynomial prodLink = new Polynomial();

		// Multiply two polynomials term by term 
		// Take every term of first polynomial 
		for (Term t1: p1.polynomial)  
		{ 
			// Multiply the current term of first polynomial 
			// with every term of second polynomial. 
			for (Term t2: p2.polynomial)  
			{ 
				prodArray[t1.getExponent() + t2.getExponent()] += t1.getCoefficient().intValue() * t2.getCoefficient().intValue();
			} 
		} 
		//convert prodArray to prodLinked List
		for (int i = 0; i<(m + n + 1) ; i ++) {
			//if coefficient is != 0, add to polynomial
			if (prodArray[i] != 0) {
				//addFirst bc bigger exponents are at back of array, want to bring them to front of linked list
				prodLink.polynomial.addFirst(new Term(i,BigInteger.valueOf(prodArray[i])));
			}
		}
		System.out.println(Arrays.toString(prodArray));

		return prodLink;
	}

	// TODO: evaluate this polynomial.
	// Hint:  The time complexity of eval() must be order O(m), 
	// where m is the largest degree of the polynomial. Notice 
	// that the function SLinkedList.get(index) method is O(m), 
	// so if your eval() method were to call the get(index) 
	// method m times then your eval method would be O(m^2).
	// Instead, use a Java enhanced for loop to iterate through 
	// the terms of an SLinkedList.


	public BigInteger eval(BigInteger x)
	{

		Iterator<Term> iter1 = this.polynomial.iterator();
		Term p1Term = iter1.next();
		BigInteger value = p1Term.getCoefficient();
		BigInteger[] polyArray = new BigInteger[p1Term.getExponent()+1];

		if(iter1.hasNext()) {
			p1Term = iter1.next();

		}
		int index = 0;
		for(Term curTerm:this.polynomial) {
			if(polyArray.length != 0) {
				polyArray[index] = curTerm.getCoefficient();
			}
			index ++;
			int i = 1;
			if (curTerm.getExponent()- p1Term.getExponent() != 1 && curTerm.getExponent() - p1Term.getExponent() != 0) {
				while(i< curTerm.getExponent()-p1Term.getExponent()){
					polyArray[index] = BigInteger.valueOf(0);
					index ++;
					i++;
				}
			}
			if (iter1.hasNext()) {
				p1Term = iter1.next();
			}
			else {
				if(polyArray.length-1 != 0) {
					polyArray[index] = p1Term.getCoefficient();
					if(p1Term.getCoefficient()!= BigInteger.valueOf(0)); {
						index ++;
						int deg = p1Term.getExponent();
						while (deg != 0) {
							polyArray[index] = BigInteger.valueOf(0);
							index ++;
							deg --;
						}
					}
				}
				break;
			}
		}

		index = 0;
		for (BigInteger cur2:polyArray) {
			if(index == 0) {
				index ++;
				continue;
			}
			value = value.multiply(x).add(cur2);
		}
		return value;
	}

	
	// Checks if this polynomial is a clone of the input polynomial
	public boolean isDeepClone(Polynomial p)
	{ 
		if (p == null || polynomial == null || p.polynomial == null || this.size() != p.size())
			return false;

		int index = 0;
		for (Term term0 : polynomial)
		{
			Term term1 = p.getTerm(index);

			// making sure that p is a deep clone of this
			if (term0.getExponent() != term1.getExponent() ||
					term0.getCoefficient().compareTo(term1.getCoefficient()) != 0 || term1 == term0)  
				return false;

			index++;
		}
		return true;
	}

	// This method blindly adds a term to the end of LinkedList polynomial. 
	// Avoid using this method in your implementation as it is only used for testing.
	public void addTermLast(Term t)
	{ 
		polynomial.addLast(t);
	}


	@Override
	public String toString()
	{ 
		if (polynomial.size() == 0) return "0";
		return polynomial.toString();
	}


}
