import java.util.Scanner;

public class RomanjeIII {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int d = sc.nextInt();
        int p = sc.nextInt();
        int z = sc.nextInt();
        int dan = 1;

        while (d != 0) {
            if (z >= p) {
                System.out.printf("%d. dan: %d -> %d (prehodil %d)\n", dan, d, d - p, p);
                break;
            } else if (d < p) {
                System.out.printf("%d. dan: %d -> 0 (prehodil %d)\n", dan, d, d);
                break;
            } else {
                System.out.printf("%d. dan: %d -> %d (prehodil %d)\n", dan, d, d - p, p);
                d = d - p;
                dan++;
                p = p - z;
            }
        }
    }
}