package Game.Karten;

public enum Kartenwert {
    /**
     * Kartenwerte.
     */
    ZWEI("2"), DREI("3"), VIER("4"), FUENF("5"), SECHS("6"), SIEBEN("7"), ACHT("8"), NEUN("9"),
    /**
     * Kartenwerte.
     */
    ZEHN("10"), BUBE("Bube"), DAME("Dame"), KOENIG("König"), ASS("Ass");

    private final String name;

    Kartenwert(String name) {
        this.name = name;
    }

    public String getName() {
        return (name + "     ").substring(0, 6);
    }
}

