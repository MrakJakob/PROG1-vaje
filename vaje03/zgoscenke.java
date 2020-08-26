import java.util.Scanner;

public class zgoscenke {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int replicaK = k;
        int count = 1;
        int file = 0;

        while (sc.hasNextInt() && n != 0) {
            file = sc.nextInt();
            if (replicaK >= file) {
                replicaK -= file;
                System.out.printf("%d EP -> zgoscenka %d (%d EP)\n", file, count, k - replicaK);
            } else if (replicaK < file) {
                count++;
                n--;
                if (n != 0) {
                    replicaK = k;
                    replicaK -= file;
                    System.out.printf("%d EP -> zgoscenka %d (%d EP)\n", file, count, k - replicaK);
                }
            }
        }
    }
}
