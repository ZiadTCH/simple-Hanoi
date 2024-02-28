package Game;

import java.util.*;

/**
 * Ganz einfaches "Türme von Hanoi".
 */
public class Hanoi<T extends Comparable<T>> {

    protected List<Deque<T>> stapel = new ArrayList<>();

    /**
     * Initialisiert die Stapel und Steine für Türme von Hanoi.
     *
     * @param stapelzahl Anzahl der Stapel (typisch: 3)
     */
    public Hanoi(int stapelzahl) {
        for (int i = 0; i < stapelzahl; i++) {
            stapel.add(new ArrayDeque<>());
        }
    }

    /**
     * Überprüft, ob das Spiel zuende ist, d.h. ob alle Stapel außer dem zweiten leer sind.
     *
     * @return true, wenn nur der letzte Stapel noch Elemente enthält
     */
    private boolean beendet() {
        for (int i = 0; i < stapel.size(); i++) {
            if (i != 1 && !stapel.get(i).isEmpty()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Haupstschleife; fragt nach Zügen, bis das Spiel gewonnen ist.
     */
    public void spiele() {
        while (!beendet()) {
            gibStapelAus();

            int eingabe = frageStapelAb("Stapel zum Abheben? > ", stapel.size() - 1);
            Deque<T> vonStapel = stapel.get(eingabe);
            if (vonStapel.isEmpty()) {
                System.out.println("Der Stapel ist leer!");
                continue;
            }
            T stein = vonStapel.remove();

            eingabe = frageStapelAb("Stapel zum Ablegen? > ", stapel.size() - 1);
            Deque<T> zielStapel = stapel.get(eingabe);
            if (zielStapel.isEmpty()
                    || zielStapel.element().compareTo(stein) > 0) {
                zielStapel.addFirst(stein);
            } else {
                System.out.println("Ungültiger Zug!");
                vonStapel.addFirst(stein);
            }
        }
        gibStapelAus();
        System.out.println("Geschafft!");
    }

    /* =====================HILFSMETHODEN ZUR AUSGABE/EINGABE============================== */

    /**
     * Gibt die Stacks auf der Kommandozeile aus.
     */
    private void gibStapelAus() {
        System.out.println("-------------------------------------------------------");
        int maxSize = 0;
        for (Deque<T> aktuellerStapel : stapel) {
            maxSize = Math.max(maxSize, aktuellerStapel.size());
        }
        for (int i = maxSize; i >= 0; i--) {
            for (Deque<T> s : stapel) {
                if (i >= s.size()) {
                    System.out.print("            ");
                } else {
                    String stone = s.toArray()[s.size() - 1 - i].toString();
                    System.out.print("      ".substring(0, (13 - stone.length()) / 2));
                    System.out.print(stone);
                    System.out.print("      ".substring(0, (12 - stone.length()) / 2));

                }
            }
            System.out.println();
        }
        for (int i = 0; i < stapel.size(); i++) {
            System.out.print(" [Stapel " + i + "] ");
        }
        System.out.println();
    }

    Scanner in = new Scanner(System.in);

    /**
     * Interne Hilfsmethode zum Einlesen von Zahlen von der Konsole.
     *
     * @param abfrage   Prompt
     * @param maxValue maximal zulässiger Wert
     * @return Wert zwischen 0 und dem Maximum.
     */
    private int frageStapelAb(String abfrage, int maxValue) {
        Integer result = null;
        while (result == null || result < 0 || result > maxValue) {
            try {
                System.out.print(abfrage);
                result = Integer.parseInt(in.nextLine());
            } catch (NumberFormatException e) {
                //
            }
        }
        return result;
    }
}

