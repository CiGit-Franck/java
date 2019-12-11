package fty.briefs.fitness;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.DoubleStream;

/**
 * Management of Fitness Settings
 *
 * @see Set
 * @author Franck THERY
 */
public class Coach {

    /**
     * Discipline managed by the coach
     */
    public final static String[] DISCIPLINS
            = {
                "SQUAT",
                "LEG_EXTENSION",
                "LEG_CURL",
                "LEG_PRESS",
                "CRUNCH",
                "PLANK",
                "BENCH_PRESS",
                "TRICEPS_EXTENSION",
                "BICEPS_CURL"
            };
    private final String DATA = "/fty/briefs/fitness/data/settings.csv";
    private final String HEAD = "EXERCISE;REP_NB;WEIGHT\n";
    private final ArrayList<Set> sets;

    /**
     * Init
     */
    public Coach() {
        this.sets = new ArrayList<>();
    }

    /**
     * Returns the settings
     *
     * @return Settings
     */
    public ArrayList<Set> getSets() {
        return sets;
    }

    /**
     * Stats calculations of weights / repetition
     *
     * @param discipline
     */
    public void getStatsWeightByCycle(String discipline) {
        if (sets.stream()
                .filter(s -> s.getName().equals(discipline))
                .count() == 0) {
            Screen.emptySetting(discipline);
            return;
        }
        double average = sets.stream()
                .filter(s -> s.getName().equals(discipline))
                .mapToDouble(s -> s.getWeight())
                .average()
                .getAsDouble();
        double max = sets.stream()
                .filter(s -> s.getName().equals(discipline))
                .mapToDouble(s -> s.getWeight())
                .max()
                .getAsDouble();
        long size = sets.stream()
                .filter(s -> s.getName().equals(discipline))
                .mapToDouble(s -> s.getWeight()).count();
        DoubleStream sortWeight = sets.stream()
                .filter(s -> s.getName().equals(discipline))
                .mapToDouble(s -> s.getWeight())
                .sorted();
        double median = size % 2 == 0
                ? sortWeight.skip(size / 2 - 1).limit(2).average().getAsDouble()
                : sortWeight.skip(size / 2).findFirst().getAsDouble();
        /**
         * ArrayList<Set> iter = new ArrayList<>(); for (Set set : sets) { if
         * (set.getName().equals(discipline)) { iter.add(set); } }
         * Collections.sort(iter, new SetWeightComparator()); // tri / poids
         *
         * double[] weights = new double[iter.size()]; int i = 0; for (Set set :
         * iter) { weights[i++] = set.getWeight(); } double weightAverage = 0.0;
         * double weightMedian = getMedian(weights); double weightMax = 0.0; int
         * sumCycle = 0; for (Set set : iter) { sumCycle += set.getNbIter();
         * weightMax = (weightMax < set.getWeight()) ? set.getWeight() :
         * weightMax; weightAverage += set.getNbIter() * set.getWeight(); }
         * weightAverage = weightAverage / sumCycle;
         */
        Screen.getStatsWeightByCycle(median, average, max);
    }

    /**
     * Repetition stats calculations
     *
     * @param discipline
     */
    public void getStatsByCycle(String discipline) {
        if (sets.stream()
                .filter(s -> s.getName().equals(discipline))
                .count() == 0) {
            Screen.emptySetting(discipline);
            return;
        }
        double average = sets.stream()
                .filter(s -> s.getName().equals(discipline))
                .mapToInt(s -> s.getNbIter())
                .average()
                .getAsDouble();
        double max = sets.stream()
                .filter(s -> s.getName().equals(discipline))
                .mapToDouble(s -> s.getNbIter())
                .max()
                .getAsDouble();
        long size = sets.stream()
                .filter(s -> s.getName().equals(discipline))
                .mapToDouble(s -> s.getNbIter()).count();
        DoubleStream sortWeight = sets.stream()
                .filter(s -> s.getName().equals(discipline))
                .mapToDouble(s -> s.getNbIter())
                .sorted();
        double median = size % 2 == 0
                ? sortWeight.skip(size / 2 - 1).limit(2).average().getAsDouble()
                : sortWeight.skip(size / 2).findFirst().getAsDouble();

        Screen.getStatsByCycle(median, average, max);
    }

    /**
     * Calculations of stats of the weights / set
     *
     * @param discipline
     */
    public void getStatsWeightBySet(String discipline) {
        if (sets.stream()
                .filter(s -> s.getName().equals(discipline))
                .count() == 0) {
            Screen.emptySetting(discipline);
            return;
        }
        double average = sets.stream()
                .filter(s -> s.getName().equals(discipline))
                .mapToDouble(s -> s.getWeight() * s.getNbIter())
                .average()
                .getAsDouble();
        double max = sets.stream()
                .filter(s -> s.getName().equals(discipline))
                .mapToDouble(s -> s.getWeight() * s.getNbIter())
                .max()
                .getAsDouble();
        long size = sets.stream()
                .filter(s -> s.getName().equals(discipline))
                .mapToDouble(s -> s.getWeight()).count();
        DoubleStream sortWeight = sets.stream()
                .filter(s -> s.getName().equals(discipline))
                .mapToDouble(s -> s.getWeight() * s.getNbIter())
                .sorted();
        double median = size % 2 == 0
                ? sortWeight.skip(size / 2 - 1).limit(2).average().getAsDouble()
                : sortWeight.skip(size / 2).findFirst().getAsDouble();

        Screen.getStatsWeightBySet(median, average, max);
    }

    /**
     * Load the settings of the csv
     *
     * @throws IOException
     */
    public void readData() throws IOException {
        String file = getClass().getResource(DATA).getPath();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = br.readLine(); // We do not set the header
            while ((line = br.readLine()) != null) {
                sets.add(stringToSet(line.split(";")));
            }
            br.close();
        } catch (FileNotFoundException e) {
            Logger.getLogger(Coach.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * Save the data
     *
     * @todo to save somewhere else than classes
     * @throws IOException
     */
    public void saveData() throws IOException {
        String file = getClass().getResource(DATA).getPath();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write(HEAD);
            for (Set set : sets) {
                bw.write(set.toString());
            }
            bw.close();
        } catch (FileNotFoundException e) {
            Logger.getLogger(Coach.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * Returns the median of a double list
     *
     * @param list
     * @return
     */
    private double getMedian(double[] list) {
        double median = 0;
        double pos1 = Math.floor((list.length - 1.0) / 2.0);
        double pos2 = Math.ceil((list.length - 1.0) / 2.0);
        if (pos1 == pos2) {
            median = list[(int) pos1];
        } else {
            median = (list[(int) pos1] + list[(int) pos2]) / 2.0;
        }
        return median;
    }

    /**
     * Returns the median of a list of int
     *
     * @param list
     * @return
     */
    private int getMedian(int[] list) {
        int median = 0;
        double pos1 = Math.floor((list.length - 1.0) / 2.0);
        double pos2 = Math.ceil((list.length - 1.0) / 2.0);
        if (pos1 == pos2) {
            median = list[(int) pos1];
        } else {
            median = (int) ((int) (list[(int) pos1] + list[(int) pos2]) / 2.0);
        }
        return median;
    }

    /**
     * Converts a String [] -> Set
     *
     * @param row
     * @return Set
     */
    private Set stringToSet(String[] row) {
        String discipline = row[0];
        int nb = Integer.parseInt(row[1]);
        double weight = Double.parseDouble(row[2]);
        return new Set(discipline, nb, weight);
    }

    /**
     * InerClass sorting by weight
     */
    class SetWeightComparator implements Comparator<Set> {

        @Override
        public int compare(Set set1, Set set2) {
            return (int) (set1.getWeight() - set2.getWeight());
        }
    }

    /**
     * InerClass sorting according to the number of iteration
     */
    class SetNbIterComparator implements Comparator<Set> {

        @Override
        public int compare(Set set1, Set set2) {
            return set1.getNbIter() - set2.getNbIter();
        }
    }
}
