package Practice;

import org.testng.annotations.Test;

public class Arrays {

	
	@Test
	public void min() {
		int ages[] = {20, 22, 18, 16, 35, 48, 26, 87, 2, 70};
		int min = ages[0];
		
		for (int i = 0; i < ages.length; i++) {
			if(ages[i]<min) {
				min = ages[i];
			}
		}
		System.out.println(min);
	}
	
	@Test
	public void max() {
		int ages[] = {20, 22, 18, 16, 35, 48, 26, 87, 2, 70};
		int min = ages[0];
		
		for (int i = 0; i < ages.length; i++) {
			if(ages[i]>min) {
				min = ages[i];
			}
		}
		System.out.println(min);
	}
	
	@Test
	public void AvgArray() {
		int ages[] = {20, 22, 18, 35, 48, 26, 87, 70};
		int sum = 0;
		for (int i = 0; i < ages.length; i++) {
			sum += ages[i];
		}
		System.out.println(sum/ages.length + "  Avg of ages");
	}
	
	@Test
	public void EvenOdd() {
		int[] nums = {1,2,3,4,5,6,7,8,9,10};
		for (int i = 0; i < nums.length; i++) {
			if(nums[i]%2==0) {
				System.out.println(nums[i]+ "  Even");
			}
			else {
				System.out.println(nums[i]+ " Odd");
			}
			
			
		}
	}
	
	@Test
	public void nums() {
		int k =0;
		for(int i=0; i<5; i++) {
			for(int j=1; j<=i; j++) {
				System.out.print(j);
				k++;
			}
			System.out.println("");
		}
	}
	
	
	
	
	
	
}










