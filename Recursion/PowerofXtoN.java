public class PowerofXtoN {
    public static void main(String[] args) {
        System.out.println(myPow(2.00000, 10));
    }
    public static double myPow(double x, int n) {
    if (n == 0) return 1;
    long N = n;  
    if (N < 0) {
        x = 1 / x;
        N = -N;
    }
    return power(x, N);
}
private static double power(double x, long n) {
    if (n == 0) return 1;
    double half = power(x, n / 2);
    if (n % 2 == 0) return half * half;
    else return half * half * x;
}

}
