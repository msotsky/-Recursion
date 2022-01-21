/**
TestSeq.java
A simple driver that uses the Seq class to compute the
nth element of the sequence.
@author Maxime Sotsky 3637964
*/

import java.text.NumberFormat;
import java.util.Scanner;

public class TestSeq{
	/**
	 * The driver method
	 * @param args - User input gathered through scanner
	 */

	public static void main(String[] args){

		int n, seqRec;
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter a positive integer: ");
		n = scan.nextInt();
		scan.close();
		
		//Testing seqR
		seqRec = Seq.seqR(n);
		System.out.println("seqR(" + n + ") is: " + seqRec);

		//Testing seqM
		seqRec = Seq.seqM(n);
		System.out.println("seqM(" + n + ") is: " + seqRec);
		
		//Testing seqI
		seqRec = Seq.seqI(n);
		System.out.println("seqI(" + n + ") is: " + seqRec);

		//Testing algorithm time
		NumberFormat form = NumberFormat.getInstance();
		form.setMaximumFractionDigits(7);
		form.setMinimumFractionDigits(7);

		System.out.println("Execution Times in Milliseconds (ms)");
		System.out.println("n\tRecursive\tSeq(n)\tMemoization" + "\tSeq(n)\tIterative\tSeq(n)");
		
		for(int i = 15; i <= 35; i += 10){

			//seqR time
			long start = System.nanoTime();
			int seqA = Seq.seqR(i);
			long end = System.nanoTime();
			double time = (double) (end - start)/1000000;
			System.out.print(i + "\t" + form.format(time) + "\t" + seqA);

			//seqM time
			start = System.nanoTime();
			seqA = Seq.seqM(i);
			end = System.nanoTime();
			time = (double) (end - start)/1000000;
			System.out.print("\t" + form.format(time) + "\t" + seqA);

			//seqI time
			start = System.nanoTime();
			seqA = Seq.seqI(i);
			end = System.nanoTime();
			time = (double) (end - start)/1000000;
			System.out.print("\t" + form.format(time) + "\t" + seqA);

			System.out.println();
		}
	

	}
} 