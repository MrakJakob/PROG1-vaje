import java.util.Scanner;

public class lock {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int m = sc.nextInt();
        int d = sc.nextInt();
        int count = 0;
        for (int i = 1; i < 10; i+=2){
            for (int j = m + 1; j < 10; j++){
                for (int k = 0; k < 10; k+=d){
                    System.out.printf("%d-%d-%d\n", i, j, k);
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
