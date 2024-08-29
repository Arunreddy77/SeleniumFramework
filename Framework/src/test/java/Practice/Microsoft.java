package Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.poi.ss.formula.functions.Count;
import org.testng.annotations.Test;

public class Microsoft {


	@Test
	public void Rstring() {
		String name = "Arun";

		for(int i=name.length()-1; i>=0; i--) {
			System.out.print(name.charAt(i));
		}
	}

	@Test
	public void palindrome() {
		String name = "radar";
		String rname = "";

		for(int i=name.length()-1; i>=0; i--) {
			rname += name.charAt(i);
		}
		System.out.println(rname);
		if(name.equalsIgnoreCase(rname)) {
			System.out.println("palindrome matched");
		}
	}

	@Test
	public void fibonacci() {
		int first = 0;
		int second =1;
		int next = 0;
		for (int i = 0; i < 10; i++) {
			next = first + second;
			System.out.println(next);
			first =second;
			second = next;

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
			System.out.println();
		}
	}

	@Test
	public void stars() {
		for(int i=0; i<4; i++) {
			for(int j=0; j<=i; j++) {
				System.out.print("*");

			}
			System.out.println();
		}
	}

	@Test
	public void stringOccurance() {
		String name = "arunkumarreddy";
		int count[] = new int[256];


		for(int i=0; i<name.length(); i++) {
			count[(int) name.charAt(i)]++;  
		}
		for(int i=0; i<256; i++) {
			if (count[i] != 0)   
			{  
				//prints frequency of characters      
				System.out.println((char) i + " --> " + count[i]);  
			}
		}
	}

	@Test
	public void RemoveIntDuplicates() {
	ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,2,3,1,5,6,2,5,3));
	System.out.println("original"+ numbers);
	Set<Integer> set = new HashSet<>();
	set.addAll(numbers);
	numbers.clear();
	numbers.addAll(set);
	System.out.println("updated"+numbers);
	}
	
	@Test
	public void RemoveStringDuplicates() {
	ArrayList<String> numbers = new ArrayList<>(Arrays.asList("Arun", "Kumar","reddy", "Arunn", "Arun", "Kumarr", "Kumar"));
	System.out.println("original"+ numbers);
	Set<String> set = new HashSet<>();
	set.addAll(numbers);
	numbers.clear();
	numbers.addAll(set);
	System.out.println("updated"+numbers);
	}

	@Test
	public void max() {
		int[] num = {2,5,4,1,3,9,6,7,8,10,15,11};

		int max = num[0];

		for(int i=0; i<num.length; i++) {
			if(max<num[i]) {
				max=num[i];
			}
		}
		System.out.println(max);
	}

	@Test
	public void secondMax() {
		int a[]={1,2,5,6,3,2};  
		Arrays.sort(a);
		System.out.println(a[a.length-2]);
	}





}
