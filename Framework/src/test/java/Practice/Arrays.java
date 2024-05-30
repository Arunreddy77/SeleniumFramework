package Practice;

import org.testng.annotations.Test;

public class Arrays {

	
	@Test
	public void min() {
		int ages[] = {20, 22, 18, 35, 48, 26, 87, 70};
		int min = ages[0];
		
		for (int i = 0; i < ages.length; i++) {
			if(min<ages[i]) {
				System.out.println(ages[i]);
			}
		}
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
	
	
}










