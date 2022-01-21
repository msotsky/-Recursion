/**
Seq.java
A utility class that provide methods to compute elements of the
recursive sequence.
@author Maxime Sotsky 3637964
*/
import java.util.*;
public class Seq{
	/**
	 * arraylist used in seqM to recursively compute sequence
	 */
	
	private static ArrayList<Integer> cashe;
	/**
	Recursively computes seq(n)
	@param n Non-negative integer.
	@return int Element n in the recursive sequence.
	*/
	public static int seqR(int n){
		if(n == 0){
			return 1;
		}
		else if(n == 1){
			return 3;
		}else{
			return seqR(n -1) - seqR(n-2) * 2;
		}
	}

	/**
	Recursively computes seq(n) using an ArrayList
	@param n Non-negative integer.
	@return int Element n in the recursive sequence.
	*/
	public static int seqM(int n){
		if(cashe == null){
			cashe = new ArrayList<Integer>(n + 1);
			cashe.add(1);
			cashe.add(3);
		}
		if(n < cashe.size()){
			return cashe.get(n);
		}
		int value = seqM(n -1) - seqM(n-2) * 2;
		cashe.add(value);
		return value;
	}
	/**
	Iteratively computes seq(n)
	@param n Non-negative integer.
	@return int Element n in the iterative sequence.
	*/
	public static int seqI(int n) {
		int[] arr = new int[n+1];
		arr[0] = 1;
		if(n == 0){
			return arr[0];
		}
		arr[1] = 3;
		for(int i = 2; i < arr.length; i++){
			arr[i] = arr[i-1] - arr[i-2] * 2;
		}
		return arr[n];
		
	}
	
}
