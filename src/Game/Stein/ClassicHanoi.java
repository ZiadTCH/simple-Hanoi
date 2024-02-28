package Game.Stein;

import Game.Hanoi;

public class ClassicHanoi extends Hanoi<Steinscheibe> {

    /**
     * Konstruktor.
     *
     * @param stapelzahl Anzahl der Stapel
     * @param steinzahl Anzahl der Steinscheiben
     */
    public ClassicHanoi(int stapelzahl, int steinzahl) {
        super(stapelzahl);
        for (int i = steinzahl; i > 0; i--) {
            stapel.get(0).addFirst(new Steinscheibe(i));
        }
    }
}