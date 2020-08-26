public class Inverz extends Zaporedje {
    private Interval interval;
    private Zaporedje z;

    public Inverz(Zaporedje z, Interval i1) {
        this.z = z;
        this.interval = i1;
    }

    public Integer y(int x) {
        int zacetek = this.interval.vrniZacetek();
        int konec = this.interval.vrniKonec();

        for (int i = zacetek; i <= konec; i++) {
            Integer value = z.y(i);

            if (value != null && value == x) {
                return i;
            }
        }
        return null;
    }
}