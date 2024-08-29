package Practice;

public class IncreasingOrderCheck {
    public static void main(String[] args) {
       
        System.out.println(IncreasingOrderCheck.num()); // should print true
    }

    public static boolean num() {
        int[] num = {1, 2, 3, 4, 5};

        if (num[0] < num[1] && num[1] < num[2] && num[2] < num[3] && num[3] < num[4]) {
            return true;
        } else {
            return false;
        }
    }
}
