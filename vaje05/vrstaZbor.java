import java.util.Scanner;

public class vrstaZbor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int stVojakov = sc.nextInt();
        int[] vojaki = new int[stVojakov];

        for (int i = 0; i < stVojakov; i++){
            vojaki[i] = sc.nextInt();
        }
        int nobeden = 0;
        for (int i = 0; i < stVojakov; i++){
            if (i == 0){
                if (vojaki[i] <= vojaki[i + 1]){
                    System.out.println(i);
                    nobeden = 1;
                }
            }
            else if (i + 1 == stVojakov){
                if (vojaki[i - 1] < vojaki[i]){
                    nobeden = 1;
                    System.out.println(i);
                }
            }
            else {
                if (vojaki[i - 1] <= vojaki[i] && vojaki[i] <= vojaki[i + 1]){
                    nobeden = 1;
                    System.out.println(i);
                }
            }
        }
        if (nobeden == 0){
            System.out.println("NOBEDEN");
        }
    }
}