package Game.Karten;

public class Karte implements Comparable<Karte> {
    private final Farbe farbe;
    private final Kartenwert wert;

    @Override
    public int compareTo(Karte o) {
        if (farbe.compareTo(o.farbe) != 0) {
            return farbe.compareTo(o.farbe);
        }
        return wert.compareTo(o.wert);
    }

    public Karte(Farbe farbe, Kartenwert wert) {
        this.farbe = farbe;
        this.wert = wert;
    }

    @Override
    public String toString() {
        return "  " + farbe.getName() + " " + wert.getName();
    }
}

