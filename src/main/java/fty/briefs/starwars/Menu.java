package fty.briefs.starwars;

import fty.io.Scan;
import java.util.Scanner;

/**
 *
 * @author Franck THERY
 */
public class Menu {
    
    private static final String HEAD = "------------------- Star Wars -------------------";
    private static final String ASK = "Entrez votre choix : ";

    /**
     * Main menu display
     *
     * @return
     */
    public static int getPrincipal() {
        System.out.println(HEAD);
        return Scan.inputInteger(new Scanner(System.in), 1, 3, ASK);
    }
}
