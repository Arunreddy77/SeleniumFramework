package Practice;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;

import org.testng.annotations.Test;

public class Fibonacci {

	
	@Test
	public void fib() {
		int firstNumber = 0;
		int secondNumber =1;
		int nextNumber = 0;
		
		for (int i = 0; i < 10; i++) {
			nextNumber = firstNumber+secondNumber;
			firstNumber=secondNumber;
			secondNumber=nextNumber;
			System.out.println(nextNumber);
		}
		
	}
	
	
	@Test
	public void name() {
		String name = "Arun";
		
		for (int i = 0; i < name.length(); i++) {
			for(int j=0; j<=i; j++) {
				System.out.print(name.charAt(i));
			}
			
		}
	}
	
	@Test
	public void servicenow() {
		
		String name = "servicenow";
		int k=0;
		for(int i=0; i<4; i++) {
			for(int j=0; j<=i; j++) {
				System.out.print(name.charAt(k));
				k++;
			}
			System.out.println("");
		}
	}
	
	@Test
	public void test() {
		String count = "10101010";
		
		for (int i = 0; i < count.length(); i++) {
			
			if (count.charAt(i)=='1') {
				System.out.print(count.charAt(i));
				
			}
		}
			
			for (int j = 0; j < count.length(); j++) {
				
				if (count.charAt(j)=='0') {
					System.out.print(count.charAt(j));
					
				}
		}
	}
	
	@Test
	public void stringreverse() {
		String name = "ArunKumarReddy";
		
		for(int i=name.length()-1; i>=0; i--) {
			System.out.print(name.charAt(i));
		}
	}
	
	@Test
	public void rev() {
		String name = "ArunKumarReddy";
		String reversed = "";
		for(int i=0; i<name.length(); i++) {
			reversed = name.charAt(i) + reversed;
			
		}
		System.out.print(reversed);
	}
	
	@Test
	public void StrToArray() {
		String str = "Hello";
		char[] c= str.toCharArray();
		
		System.out.println(Arrays.toString(c));
	}
	
	
	@Test
	public void sort() {
		int[] num = {5,3,8,6,9,1,2,7,4};
		Arrays.sort(num);
			System.out.println(Arrays.toString(num));
		
	}
	
	@Test
	public void palindrome() {
		
		String name = "radar";
		String rname = "";
		for(int i=name.length()-1; i>=0; i--) {
			rname= rname+name.charAt(i);
			if(name.equalsIgnoreCase(rname)) {
				System.out.println("palindrome matched");
			}
		}
	}
	
	
	
	
	
	
}







