
public abstract class Zaporedje {

    public abstract Integer y(int x);

    public String vNiz(Interval interval) {
        StringBuilder sb = new StringBuilder("[");
        int zacetek = interval.vrniZacetek();
        int konec = interval.vrniKonec();
        boolean prvic = true;
        for (int x = zacetek; x <= konec; x++) {
            Integer y = this.y(x);
            if (y != null) {
                if (!prvic) {
                    sb.append(", ");
                }
                prvic = false;
                sb.append(String.format("%d -> %d", x, y));
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public Interval minMax(Interval interval) {
        // popravite / dopolnite ...
        int zacetek = interval.vrniZacetek();
        int konec = interval.vrniKonec();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = zacetek; i <= konec; i++) {
            Integer value = y(i);
            if (value == null) {
                continue;
            }
            if (value > max) {
                max = value;
            }
            if (value < min) {
                min = value;
            }
        }
        return new Interval(min, max);
    }

    public boolean jeMonotono(Interval interval) {
        // popravite / dopolnite ...
        int zacetek = interval.vrniZacetek();
        int konec = interval.vrniKonec();
        Integer prejsnje = 0;
        Integer zaporedje = null;

        for (int i = zacetek; i <= konec; i++) {
            if (i == zacetek) {
                prejsnje = y(i);
                if (prejsnje == null) {
                    continue;
                }
            } else if (prejsnje == null) {
                prejsnje = y(i);
                if (prejsnje == null) {
                    continue;
                }
            } else if (y(i) != null) {
                if (zaporedje == null) {
                    if (prejsnje > y(i)) {
                        zaporedje = 0;
                    } else if (prejsnje < y(i)) {
                        zaporedje = 1;
                    } else {
                        return false;
                    }
                    prejsnje = y(i);
                } else {
                    if (zaporedje == 0) {
                        if (prejsnje > y(i)) {
                            prejsnje = y(i);
                        } else {
                            return false;
                        }
                    }
                    if (zaporedje == 1) {
                        if (prejsnje < y(i)) {
                            prejsnje = y(i);
                        } else {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public Zaporedje vsota(Zaporedje drugo) {
        return new Vsota(this, drugo);
    }

    public Zaporedje inverz(Interval interval) {
        if (jeMonotono(interval)) {
            return new Inverz(this, interval);
        }
        return null;
    }

}
