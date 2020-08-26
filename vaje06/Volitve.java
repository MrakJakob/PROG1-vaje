
public class Volitve {

    public static void main(String[] args) {
        // koda za ro"cno testiranje (po "zelji)
    }

    public static int steviloGlasov(int[][][] t, int leto, int stranka) {
        int stGlasov = 0;

        for (int i = 0; i < t[leto][stranka].length; i++){
            stGlasov += t[leto][stranka][i];
        }
        return stGlasov;
    }

    public static int[][] glasovi(int[][][] t) {
        int[][] tab = new int[t.length][];
        for (int i = 0; i < t.length; i++){
            tab[i] = new int[t[i].length];
            
            for (int j = 0; j < tab[i].length; j++) {
                tab[i][j] = steviloGlasov(t, i, j);
            }
        }
        return tab;
    }

    public static int najVolisce(int[][][] t, int stranka) {
        int najVol = 0;
        int indeks = 0;
        int[] volisca = new int[t[0][stranka].length];

        for (int i = 0; i < t.length; i++){
            for (int j = 0; j < t[i][stranka].length; j++){
                volisca[j] += t[i][stranka][j];
            }
        }
        for (int i = 0; i < volisca.length; i++){
            if (najVol < volisca[i]){
                indeks = i;
                najVol = volisca[i];
            }
        }
        return indeks;
    }

    public static int vsotaUvrstitev(int[][][] t, int stranka, int volisce) {
        int leta = t.length;
        int vsota = 0;
        for (int i = 0; i < leta; i++){
            vsota += uvrstitev(t, stranka, volisce, i);
        }
        return vsota;
    }
    public static int uvrstitev(int[][][] t, int stranka, int volisce, int leto){
        int place = 1;
        int strankGlasovi = t[leto][stranka][volisce];
        for (int i = 0; i < t[leto].length; i++){
            if (i == stranka){
                continue;
            }
            if (t[leto][i][volisce] > strankGlasovi){
                place++;
            }
        }

        return place;
    }
}
