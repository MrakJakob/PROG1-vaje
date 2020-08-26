import java.util.Scanner;

public class piramida {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int stPresledkov = n;
        int stZvezdic = 1;
        int replica = 0;

        for (int i = 1; i <= n; i++){
            stPresledkov = n - i;
            while (stPresledkov != 0){
                System.out.print(" ");
                stPresledkov--;
            }
            replica = stZvezdic;
            while (stZvezdic != 0){
                System.out.print("*");
                stZvezdic--;
            }
            System.out.println();
            stZvezdic = replica + 2;
        }
    }
}
