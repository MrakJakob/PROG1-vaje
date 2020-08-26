import java.util.Scanner;

public class piramidaBrezZank {

    public static void izpisiPresledke(int presledki){
        if (presledki == 0){
            return;
        }
        System.out.print(" ");
        izpisiPresledke(presledki - 1);
    }
    public static void izpisiZvezdice(int zvezdice){
        if (zvezdice == 0){
            return;
        }
        System.out.print("*");
        izpisiZvezdice(zvezdice - 1);
    }

    public static void izrisiPiramido(int vrstica, int n){
        if (vrstica > n){
            return;
        }
        int presledki = n - vrstica;
        int zvezdice = vrstica + vrstica - 1;
        izpisiPresledke(presledki);
        izpisiZvezdice(zvezdice);
        System.out.println();

        izrisiPiramido(vrstica + 1, n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        izrisiPiramido(1, n);
   }
}