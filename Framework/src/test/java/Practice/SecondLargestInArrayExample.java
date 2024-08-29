package Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import org.testng.annotations.Test;

public class SecondLargestInArrayExample{  


	public static void main(String args[]){
		int a[]={1,2,5,6,7,3,9,8,12,13};  
		int temp;
		for(int i=0; i<a.length; i++) {
			for(int j=i+1; j<a.length; j++) {
				if(a[i]>a[j]) {
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}

		System.out.println(a[a.length-2]);		

	}
	
	@Test
	public void duplicates() {
		
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,1,2,2,3,3,4,4,5,5,6,6,7,8,9,8));
		
		HashSet<Integer> set = new HashSet<>();
		set.addAll(list);
		
		list.clear();
		list.addAll(set);
		System.out.println(set);
		
	}
	
	@Test
	public void Stringoccurance() {
		
		String  name = "HarishChandupatla";
		int[] count = new int[256];
		for(int i=0; i<name.length(); i++) {
			count[(int) name.charAt(i)]++;
			
		}
		for(int i=0; i<256; i++) {
			if(count[i]!=0) {
				System.out.println((char) i +"-->"+ count[i] );
			}
		}
	}
	
	
	@Test
	public void intoccurance() {
		int nums[] = {1,1,1,0,0,0,1,1,1,1,0};
		int k=0;
		for(int i=0; i<nums.length; i++) {
			if(nums[i]==1) {
				k++;
			}
		}
		System.out.println(k);
	}
	
	
}









