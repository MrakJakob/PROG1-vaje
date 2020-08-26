
public class Knjiznica {
    private int stClanov;
    private int stNaslovov;
    private int stIzvodovNaNaslov;
    
    private int[][] clani; 
    private int[] knjige;
    private int[] najjaci;

    public Knjiznica(int stClanov, int stNaslovov, int stIzvodovNaNaslov) {
        // dopolnite ...
        this.stClanov = stClanov;
        this.stNaslovov = stNaslovov;
        this.stIzvodovNaNaslov = stIzvodovNaNaslov;

        knjige = new int[stNaslovov];

        for (int i = 0; i < stNaslovov; i++){
            knjige[i] = stIzvodovNaNaslov;
        }
        clani = new int[stClanov][stNaslovov];
        najjaci = new int[stNaslovov];
    }

    public boolean posodi(int clan, int naslov) {
        // popravite / dopolnite ...
        if (knjige[naslov] != 0 && clani[clan][naslov] == 0){
            knjige[naslov]--;
            najjaci[naslov]++;
            clani[clan][naslov]++;
            return true;
        }
        return false;
    }

    public void clanVrne(int clan) {
        // dopolnite ...
        for (int i = 0; i < clani[clan].length; i++){
            if (clani[clan][i] != 0){
                clani[clan][i]--;
                knjige[i]++;
            }
        }
    }

    public int posojeni(int naslov) {
        // popravite / dopolnite ...
        int posojeni = this.stIzvodovNaNaslov - knjige[naslov];
        return posojeni;
    }

    public int priClanu(int clan) {
        // popravite / dopolnite ...
        int brt = 0;
        for (int i = 0; i < clani[clan].length; i++){
            brt += clani[clan][i];
        }
        return brt;
    }

    public int najNaslov() {
        // popravite / dopolnite ...
        int najjak = 0;
        int indeks = 0;
        for (int i = 0; i < najjaci.length; i++){
            if (najjaci[i] > najjak){
                najjak = najjaci[i];
                indeks = i;
            }
        }
        return indeks;
    }
}
