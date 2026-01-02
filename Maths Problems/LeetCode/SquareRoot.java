import java.util.*;

public class SquareRoot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        System.out.println(mySqrt(a));
    }
    public static int mySqrt(int x) {
        int start = 0;
        int end = x;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if ((long)mid * mid == (long)x) {
                return mid;
            } else if ((long)mid * mid > (long)x) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return end; 
    }
}
