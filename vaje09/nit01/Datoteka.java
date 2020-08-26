public abstract class Datoteka {
    protected String ime;
    protected int velikost;

    public Datoteka (String ime){
        this.ime = ime;
    }

    public abstract int velikost();
    public abstract String toString();

    public String vrniIme() {
        return this.ime;
    }
}