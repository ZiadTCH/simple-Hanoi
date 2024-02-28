package Game.Karten;

import Game.Hanoi;

public class KartenHanoi extends Hanoi<Karte> {

    /**
     * Konstruktor.
     *
     * @param stapelzahl Anzahl der Stapel
     * @param kartenzahl Anzahl der Karten
     */
    public KartenHanoi(int stapelzahl, int kartenzahl) {
        super(stapelzahl);
        for (int i = kartenzahl; i > 0; i--) {
            stapel.get(0).addFirst(new Karte(Farbe.KARO, Kartenwert.values()[i]));
        }
    }
}
