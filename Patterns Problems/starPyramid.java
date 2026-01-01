import java.util.*;
public class starPyramid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            // printing spaces
            for(int j=0; j<n-i-1; j++){
                System.out.print("  ");
            }
            // printing stars
            for(int k=0; k<=i; k++){
                System.out.print(" * ");
            }
            System.out.println();
        }
    }
}
