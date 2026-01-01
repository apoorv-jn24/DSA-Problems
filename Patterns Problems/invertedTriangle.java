import java.util.*;
public class invertedTriangle {
    public static void main(String[] args) {
        java.util.Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=n; i>0; i--){
            for(int j=0; j<i; j++){
                System.out.print(" * ");
            }
            System.out.println();
        }
    }
}
