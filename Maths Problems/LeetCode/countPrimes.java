import java.util.*;
// LeetCode Problem: Count Primes-204
public class countPrimes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count=0;
        int n = sc.nextInt();
        if(n<=1) System.out.println(count);
        boolean [] isprime = new boolean[n+1];
        Arrays.fill(isprime, true);
        for(int i=2; i<n; i++){
            if(isprime[i]) {
                count++;
            for(int j=i*2; j<n; j+=i) {
                isprime[j]=false;
            }
        }
        }
        System.out.println(count);
        sc.close();
    }
}
