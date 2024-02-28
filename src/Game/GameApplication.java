package Game;

import Game.Karten.KartenHanoi;

public class GameApplication {

    /**
     * Main-Methode. Startet das Spiel.
     *
     * @param args ignoriert.
     */
    public static void main(String[] args) {
        new KartenHanoi(3, 3).spiele();
    }
}
