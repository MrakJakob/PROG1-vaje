import java.util.Scanner;

public class gcd {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int g = sc.nextInt();

        for (int i = g; i <= n; i++){
            for (int j = i; j <=n; j++){
                if (gcdmethod(i, j) == g){
                    System.out.printf("(%d, %d)\n", i, j);
                }
            }
        }
    }

    public static int gcdmethod(int a, int b) {
        while (b > 0) {
            int t = a;
            a = b;
            b = t % b;
        }
        return a;
    }
}