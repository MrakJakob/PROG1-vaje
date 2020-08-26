import java.util.Scanner;

public class Collatz {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int count = 1;
        while (num != 1){
            if (num % 2 == 0){  // je sodo
                num = num / 2;
                count++;
            }
            else {
                num = num * 3 + 1;
                count++;
            }
        }
        System.out.println(count);
    }
}