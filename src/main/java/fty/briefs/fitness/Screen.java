package fty.briefs.fitness;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class defining the menu display part
 *
 * @author Franck THERY
 */
public class Screen {

    private static final String HEAD = "------------------- Fitness Coach -------------------";
    private static final String FOOT = "------------------- ############# -------------------";
    private static final String ASK = "Entrez votre choix : ";

    /**
     * Main menu display
     *
     * @return
     */
    public static int getPrincipal() {
        System.out.println(HEAD);
        System.out.println("1. --> Ajouter un set");
        System.out.println("2. --> Afficher les performances sur un exercice");
        System.out.println("3. --> Quitter le programme");
        System.out.println(FOOT);
        System.out.println(ASK);
        return inputInteger(new Scanner(System.in), 1, 3);
    }

    /**
     * Displays the selection menu for available stats
     *
     * @return
     */
    public static int getStatistic() {
        System.out.println(HEAD);
        System.out.println("1. --> Stats de poids (/ répétitions)");
        System.out.println("2. --> Stats de nombre de répétitions");
        System.out.println("3. --> Stats de poids (/ set)");
        System.out.println(FOOT);
        System.out.println(ASK);
        return inputInteger(new Scanner(System.in), 1, 3);
    }

    /**
     * Shows the weight / repetition stats
     *
     * @param weightMedian
     * @param weightAverage
     * @param weightMax
     */
    public static void getStatsWeightByCycle(double weightMedian, double weightAverage, double weightMax) {
        System.out.println("Poids moyen levé  : " + String.format( "%.2f", weightAverage ));
        System.out.println("Poids médian levé : " + String.format( "%.2f", weightMedian ));
        System.out.println("Poids max levé    : " + String.format( "%.2f", weightMax ));
        System.out.println();
    }

    /**
     * Shows the repetition stats
     *
     * @param weightMedian
     * @param weightAverage
     * @param weightMax
     */
    public static void getStatsByCycle(double weightMedian, double weightAverage, double weightMax) {
        System.out.println("Nombre moyen de répétitions  : " + String.format( "%.2f", weightAverage ));
        System.out.println("Nombre médian de répétitions : " + String.format( "%.2f", weightMedian ));
        System.out.println("Nombre max de répétitions    : " + String.format( "%.2f", weightMax ));
        System.out.println();
    }

    /**
     * Displays the weight / set stats
     *
     * @param weightMedian
     * @param weightAverage
     * @param weightMax
     */
    public static void getStatsWeightBySet(double weightMedian, double weightAverage, double weightMax) {
        System.out.println("Poids moyen levé par set  : " + String.format( "%.2f", weightAverage ));
        System.out.println("Poids médian levé par set : " + String.format( "%.2f", weightMedian ));
        System.out.println("Poids max levé par set    : " + String.format( "%.2f", weightMax ));
        System.out.println();
    }

    /**
     * Display of the coaching menu
     *
     * @return
     */
    public static int getCoaching() {
        System.out.println(HEAD);
        int n = 1;
        for (String disc : Coach.DISCIPLINS) {
            System.out.println(n++ + ". --> " + disc);
        }
        System.out.println(FOOT);
        System.out.println(ASK);
        return inputInteger(new Scanner(System.in), 1, Coach.DISCIPLINS.length);
    }

    /**
     * Entering a new setting
     *
     * @param set
     */
    public static void setSetting(Set set) {
        System.out.println("Nombre de répétions ? :  ");
        set.setNbIter(inputInteger(new Scanner(System.in), 0, Integer.MAX_VALUE));
        System.out.println("Entrez le poid ? :  ");
        set.setWeight(inputDouble(new Scanner(System.in), 0.0, Double.MAX_VALUE));
    }

    /**
     * Alert message
     *
     * @param discipline
     */
    public static void emptySetting(String discipline) {
        System.out.println("Aucune donnée pour " + discipline);
    }

    /**
     * Filters entering a double between min and max
     *
     * @param kb
     * @param min
     * @param max
     * @return double min<=saisie<=mmmax
     */
    private static double inputDouble(Scanner kb, double min, double max) {
        boolean valid = false;
        double in = -1.0;
        String msgError = "Veuillez saisir un double entre " + min + " et " + max;
        do {
            try {
                in = kb.nextDouble();
                if (in >= min && in <= max) {
                    valid = true;
                } else {
                    System.out.println(msgError);
                    System.out.println(ASK);
                }
            } catch (InputMismatchException ie) {
                System.out.println(msgError);
                System.out.println(ASK);
                if (kb.hasNext()) {
                    kb.next();
                }
            }
        } while (!valid);
        return in;
    }

    /**
     * Filters the entry of an integer between min and max
     *
     * @param kb
     * @param min
     * @param max
     * @return entier min<=saisie<=mmmax
     */
    private static int inputInteger(Scanner kb, int min, int max) {
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
                    System.out.println(ASK);
                }
            } catch (InputMismatchException ie) {
                System.out.println(msgError);
                System.out.println(ASK);
                if (kb.hasNext()) {
                    kb.next();
                }
            }
        } while (!valid);
        return in;
    }

}
