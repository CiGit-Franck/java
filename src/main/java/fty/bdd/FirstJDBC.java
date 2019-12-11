package fty.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author utilisateur
 */
public class FirstJDBC {

    private static final Map<String, String> env = new HashMap<String, String>();

    public FirstJDBC() {
        env.put("URL", "jdbc:postgresql://localhost:5432/postgres");
        env.put("USER", "franck");
        env.put("PASS", "thery");
    }

    public static Connection getConnection() {
        Connection cnx = null;
        if (cnx == null) {
            try {
                cnx = DriverManager.getConnection(env.get("URL"), env.get("USER"), env.get("PASS"));
            } catch (SQLException ex) {
                Logger.getLogger(FirstJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return cnx;
    }

    private static void printCity() {
        try (Statement stmt = getConnection().createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT ville_code_postal, ville_nom_reel, ville_latitude_deg, ville_longitude_deg from cities.villes_france");
            while (rs.next()) {
                System.out.println(String.format("ville_code_postal: %s, ville_nom_reel: %s, ville_latitude_deg: %f, ville_longitude_deg: %f",
                        rs.getString("ville_code_postal"),
                        rs.getString("ville_nom_reel"),
                        rs.getDouble("ville_latitude_deg"),
                        rs.getDouble("ville_longitude_deg")));
            }
        } catch (SQLException e) {
            Logger.getLogger(FirstJDBC.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public static void main(String[] args) {
        new FirstJDBC();
        try {
            printCity();
            getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(FirstJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
