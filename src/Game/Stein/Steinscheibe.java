package Game.Stein;

public class Steinscheibe implements Comparable<Steinscheibe> {

    private final int radius; // Größe der Steinscheibe

    @Override
    public int compareTo(Steinscheibe o) {
        return radius - o.radius;
    }

    /**
     * Konstruktor.
     *
     * @param radius Radius der Scheibe, muss zwischen 1 und 5 liegen
     */
    public Steinscheibe(final int radius) {
        if (radius > 5 || radius < 1) {
            throw new IllegalArgumentException("Größe muss zwischen 1 und 5 liegen.");
        }
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "=".repeat(radius * 2);
    }

    public int getRadius() {
        return radius;
    }
}

