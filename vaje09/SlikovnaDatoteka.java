public class SlikovnaDatoteka extends Datoteka {
    protected int sirina;
    protected int visina;

    public SlikovnaDatoteka(String ime, int sirina, int visina) {
        super(ime);
        this.sirina = sirina;
        this.visina = visina;
    }
    public int vrniSirino(){
        return this.sirina;
    }
    public int vrniVisino(){
        return this.visina;
    }

    @Override
    public int velikost(){
        return (3 * this.sirina * this.visina + 54);
    }

    @Override
    public String toString(){
        return String.format("%s [s %d x %d]", this.ime, this.sirina, this.visina);
    }
}