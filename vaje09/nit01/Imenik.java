import java.nio.file.Path;

public class Imenik extends Datoteka {
    private Datoteka[] datoteke;

    Imenik(String ime, Datoteka[] datoteke) {
        super(ime);
        this.datoteke = datoteke;
    }

    public int steviloVecjihSlik(int prag) {
        Datoteka[] datoteke = this.datoteke;
        int stSlik = 0;
        for (Datoteka d : datoteke) {
            if (d instanceof SlikovnaDatoteka) {
                SlikovnaDatoteka slika = (SlikovnaDatoteka) d;

                if (slika.vrniSirino() >= prag && slika.vrniVisino() >= prag) {
                    stSlik++;
                }
            }
        }
        return stSlik;
    }

    public String poisci(String ime) {
        String pot = "./";

        for (Datoteka d : datoteke) {
            if (d.vrniIme().equals(ime)) {
                return pot + ime;
            } else {
                if (d instanceof Imenik) {
                    Imenik kurac = (Imenik) d;

                    if (kurac.vsebuje(ime)) {
                        pot = kurac.poisci(pot, ime);
                    }
                }
            }
        }
        if (pot == "./") {
            return null;
        }
        return pot;

    }

    private String poisci(String pot, String ime) {
        pot += super.vrniIme() + "/";

        for (Datoteka d : datoteke) {
            if (d.vrniIme().equals(ime)) {
                return pot + ime;
            } else if (d instanceof Imenik) {
                Imenik kurac = (Imenik) d;

                if (kurac.vsebuje(ime)) {
                    pot = kurac.poisci(pot, ime);
                }
            }
        }
        return pot;
    }

    public boolean vsebuje(String ime) {
        for (Datoteka d : datoteke) {
            if (d.vrniIme().equals(ime)) {
                return true;
            }

            else if (d instanceof Imenik) {
                Imenik kurac = (Imenik) d;
                if (kurac.vsebuje(ime)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public int velikost() {
        int velikost = 0;
        Datoteka[] datoteke = this.datoteke;
        for (Datoteka d : datoteke) {
            velikost += d.velikost();
        }
        velikost += 256;

        return velikost;
    }

    @Override
    public String toString() {
        Datoteka[] datoteke = this.datoteke;
        int stDatotek = 0;

        for (Datoteka d : datoteke) {
            d.toString();
            stDatotek++;
        }
        return String.format("%s [i %d]", this.ime, stDatotek);
    }
}