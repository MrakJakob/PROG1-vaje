public class Vsota extends Zaporedje {
    private Zaporedje zaporedje1;
    private Zaporedje zaporedje2;

    public Vsota(Zaporedje z1, Zaporedje z2){
        this.zaporedje1 = z1;
        this.zaporedje2 = z2;
    }
    @Override
    public Integer y(int x){
        Integer y1 = zaporedje1.y(x);
        Integer y2 = zaporedje2.y(x);

        if (y1 != null && y2 != null){
            return y1 + y2;
        }
        return null;
    }

}