package fty.briefs.puissance4;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class that manages the display of the app
 *
 * @author Franck THERY
 */
public class Screen {

    final static String FOOT = " - ";
    private static final String ASK = "Quelle colonne pour ce nouveau coup : ";
    public static final String FULL = "Cette colonne est déjà pleine (͡°͜ʖ͡°)";
    final static String AGAIN = "Voulez-vous rejouer (Oui = 1 ou Non = 0) ? : ";

    /**
     * Message new part
     *
     * @return
     */
    public static boolean again() {
        System.out.print(AGAIN);
        return (inputInteger(new Scanner(System.in), 0, 1, AGAIN) == 1);
    }

    /**
     * Message of equality
     */
    public static void matchNull() {
        System.out.println("Partie terminée sans gagnant !");
    }

    /**
     * Congratulate the winner
     *
     * @param player
     */
    public static void winner(char player) {
        System.out.println("Partie gagnante pour " + player);
    }

    /**
     * Recapture
     *
     * @param player
     * @return colonne
     */
    public static int showReplay(char player) {
        System.out.println(FULL);
        return showPlay(player);
    }

    /**
     * Entering the choice of the column
     *
     * @param player
     * @return colonne
     */
    public static int showPlay(char player) {
        System.out.print("Joueur " + player + " à vous de jouer : ");
        return inputInteger(new Scanner(System.in), 1, Puissance4.COLUMS, ASK);
    }

    /**
     * Shows the game board
     *
     * @param board
     */
    public static void showBoard(char[][] board) {
        for (int i = 1; i <= board[0].length; i++) {
            System.out.print(" " + i + " ");
        }
        System.out.println();
        for (char[] row : board) {
            for (char piece : row) {
                System.out.print("[" + piece + "]");
            }
            System.out.println();
        }
        for (int i = 0; i < board[0].length; i++) {
            System.out.print(FOOT);
        }
        System.out.println();
    }

    /**
     * Filters the entry of an integer between min and max
     *
     * @param kb
     * @param min
     * @param max
     * @param ask
     * @return entier min<=saisie<=mmmax
     */
    private static int inputInteger(Scanner kb, int min, int max, String ask) {
        boolean valid = false;
        int in = -1;
        String msgError = "Veuillez saisir un entier entre " + min + " et " + max;
        do {
            try {
                in = kb.nextInt();
                if (in >= min && in <= max) {
                    valid = true;
                } else {
                    System.out.println(msgError);
                    System.out.print(ask);
                }
            } catch (InputMismatchException ie) {
                System.out.println(msgError);
                System.out.print(ask);
                if (kb.hasNext()) {
                    kb.next();
                }
            }
        } while (!valid);
        return in;
    }
}
