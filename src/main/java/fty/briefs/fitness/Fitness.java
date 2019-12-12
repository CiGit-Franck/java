package fty.briefs.fitness;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Fitness program class that manages the settings of a body builder
 * <p>
 * Entering a Set
 * <p>
 * Shows the perf on a desired Set
 * <p>
 * Csv storage
 *
 * @see Coach, Set
 * @author Franck THERY
 */
public class Fitness {

    private final Coach coach = new Coach();

    /**
     * Init
     */
    public Fitness() {
    }

    /**
     * Program running
     */
    public void run() {
        try {
            coach.readData();
        } catch (IOException ex) {
            Logger.getLogger(Fitness.class.getName()).log(Level.SEVERE, null, ex);
        }
        do {
            doAction();
        } while (true);
    }

    /**
     * Program actions
     */
    private void doAction() {
        switch (Screen.getPrincipal()) {
            case 1: // Add one set
                Set set = new Set(Coach.DISCIPLINS[Screen.getCoaching() - 1]);
                Screen.setSetting(set);
                coach.getSets().add(set);
                break;
            case 2: // Show perf
                String discipline = Coach.DISCIPLINS[Screen.getCoaching() - 1];
                switch (Screen.getStatistic()) {
                    case 1://raised weight / repetition
                        coach.getStatsWeightByCycle(discipline);
                        break;
                    case 2://number of repetition
                        coach.getStatsByCycle(discipline);
                        break;
                    case 3://raised weight / setup 
                        coach.getStatsWeightBySet(discipline);
                        break;
                }
                break;
            case 3: // Exit
                try {
                    coach.saveData();
                } catch (IOException ex) {
                    Logger.getLogger(Fitness.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.exit(0);
                break;
        }
    }
}
