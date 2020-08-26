import java.util.Arrays;
import java.util.Scanner;

public class zgoscenkeII {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] zgoscenke = new int[n];

        int file = 0;
        while (sc.hasNextInt() && n != 0) {
            file = sc.nextInt();
            int min = k + 1;
            int indeksMin = 0;
            for (int i = 0; i < n; i++){
                if (zgoscenke[i] == 0){
                    indeksMin = i;
                    min = 0;
                    break;
                }
                else if (zgoscenke[i] < min){
                    indeksMin = i;
                    min = zgoscenke[i];
                }
            }
            if (min + file <= k){
                zgoscenke[indeksMin] += file;
                System.out.printf("%d EP -> zgoscenka %d %s\n", file, indeksMin + 1, Arrays.toString(zgoscenke));
            }
            else {
                break;
            }
        }
    }
}