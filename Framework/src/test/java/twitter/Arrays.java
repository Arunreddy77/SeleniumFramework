package twitter;

public class Arrays {

	public static void main(String[] args) {
		int[] a1 = {1,2,3,4,5};
		int[] a2 = {1,2,3,4,5,6,7};
		
		
		for(int i=0; i<a1.length; i++) {
			a2[i] = a1[i]+a2[i];
			
		}
		System.out.println(java.util.Arrays.toString(a2));
		
	}
}
