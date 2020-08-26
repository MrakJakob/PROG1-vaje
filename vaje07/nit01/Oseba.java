public class Oseba {
    private String ime;
    private String priimek;
    private char spol;
    private int letoRojstva;
    private Oseba oce;
    private Oseba mati;
    private static int count = 0;

    public Oseba(String ime, String priimek, char spol, int letoRojstva, Oseba oce, Oseba mati) {
        /*
         * Oseba oce, Oseba mati) Izdela objekt, ki predstavlja osebo s podanim imenom,
         * priimkom, spolom (M: moški; Z: ženska), letom rojstva ter očetom in materjo.
         * Parametra oce in mati sta lahko tudi null; to pomeni, da o očetu oz. materi
         * nimamo podatkov.
         */
        this.ime = ime;
        this.priimek = priimek;
        this.spol = spol;
        this.letoRojstva = letoRojstva;
        this.oce = oce;
        this.mati = mati;
        count++;
    }

    public String vrniIme() {
        /* Vrne ime osebe this (torej osebe, ki jo predstavlja objekt this). */
        return this.ime;
    }

    public String toString() {
        /*
         * Vrne niz, ki vsebuje podatke o osebi this v sledeči obliki:
         * ime␣priimek␣(spol),␣letoRojstva Na primer: Jože␣Gorišek␣(M),␣1953
         */
        return String.format("%s %s (%c), %d", this.ime, this.priimek, this.spol, this.letoRojstva);
    }

    public int starost(int leto) {
        /* Vrne starost osebe this v podanem letu. */
        int starost = leto - this.letoRojstva;
        return starost;
    }

    public boolean jeStarejsaOd(Oseba os) {
        /* Vrne true natanko v primeru, če je oseba this starejša od osebe os. */
        if (this.letoRojstva < os.letoRojstva) {
            return true;
        }
        return false;
    }

    public String imeOceta() {
        /* Vrne ime očeta osebe this oziroma null, če oče ni znan. */
        Oseba oce = this.oce;
        if (oce != null) {
            return oce.ime;
        }
        return null;
    }

    public boolean jeBratAliSestraOd(Oseba os) {
        /* Vrne true natanko v primeru, če je oseba this brat ali sestra osebe os. */
        if (os.oce != null && this.oce != null && os.mati != null && this.mati != null) {
            if (os.oce.equals(this.oce) && os.mati.equals(this.mati) && !os.equals(this)) {
                return true;
            }
        }
        return false;
    }

    public boolean jeSestraOd(Oseba os) {
        /* Vrne true natanko v primeru, če je oseba this sestra osebe os. */
        if (os.oce != null && this.oce != null && os.mati != null && this.mati != null) {
            if (os.oce.equals(this.oce) && os.mati.equals(this.mati) && !os.equals(this) && this.spol == 'Z') {
                return true;
            }
        }
        return false;
    }

    public boolean jeTetaOd(Oseba os) {
        /* Vrne true natanko v primeru, če je oseba this teta osebe os. */
        if (this.jeSestraOd(os.oce) || this.jeSestraOd(os.mati)){
            return true;
        }
        return false;
    }

    public boolean jeOcetovskiPrednikOd(Oseba os) {
        /*
         * Vrne true natanko v primeru, če je oseba this očetovski prednik osebe os.
         * Oseba A je očetovski prednik osebe B, če od osebe B do osebe A vodi
         * netrivialna nepretrgana veriga očetov. (»Netrivialna« veriga pomeni samo to,
         * da oseba ni sama svoj očetovski prednik.)
         */
        while (os.oce != null){
            if (os.oce.equals(this)){
                return true;
            }
            os = os.oce;
        }
        return false;
    }

    public static int steviloUstvarjenih() {
        /* Vrne število doslej ustvarjenih objektov tipa Oseba. */
        return count;
    }
}