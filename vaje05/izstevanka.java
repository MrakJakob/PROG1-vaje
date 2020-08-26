import java.util.Scanner;

public class izstevanka {

    public static String[] copytable(String[] kids, int loser, int counter) {
        String[] newKids = new String[counter];
        int newIndeks = 0;
        for (int i = 0; i < counter; i++) {
            if (i != loser) {
                newKids[newIndeks] = kids[i];
                newIndeks++;
            }
        }
        return newKids;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int num = sc.nextInt();

        String[] kids = new String[n];

        for (int i = 0; i < n; i++) {
            kids[i] = sc.next();
        }
        int counter = n;
        while (counter != 1) {
            int loser = (num % counter) - 1;
            if (loser == -1) {
                loser = counter - 1;
            }
            System.out.println(kids[loser]);

            kids = copytable(kids, loser, counter);
            counter--;
        }
    }

}