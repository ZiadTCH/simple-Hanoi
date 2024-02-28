package Game.Karten;

public enum Farbe {
    /**
     * Kartenfarben.
     */
    KARO("\u2666"), HERZ("\u2665"), PIK("\u2660"), KREUZ("\u2663"); // Unicode-Symbole

    private final String name;

    Farbe(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

