import java.util.Scanner;

public class collatzII {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        int najdaljseZap = 0;
        int numMax = 0;
        for (int num = a; num <= b; num++) {
            int count = 1;
            int replica = num;
            while (num != 1) {
                if (num % 2 == 0) { // je sodo
                    num = num / 2;
                    count++;
                } else {
                    num = (num * 3) + 1;
                    count++;
                }
            }
            num = replica;
            if (najdaljseZap < count){
                najdaljseZap = count;
                numMax = num;
            }
        }
        System.out.printf("%d\n%d", numMax, najdaljseZap);
    }
}