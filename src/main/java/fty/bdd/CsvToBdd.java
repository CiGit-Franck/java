package fty.bdd;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

/**
 *
 * @author utilisateur
 */
public class CsvToBdd {

    private static final Map<String, String> env = new HashMap<String, String>();
    private static Connection cnx = null;

    static {
        env.put("URL", "jdbc:postgresql://localhost:5432/postgres");
        env.put("USER", "franck");
        env.put("PASS", "thery");
    }

    private static Connection getConnection() {
        if (cnx == null) {
            try {
                cnx = DriverManager.getConnection(env.get("URL"), env.get("USER"), env.get("PASS"));
            } catch (SQLException ex) {
                Logger.getLogger(CsvToBdd.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return cnx;
    }

    private static boolean checkTableExist(String table) {
        boolean exist = true;
        try (Statement stmt = getConnection().createStatement()) {
            String sql = "select count(*) as raws from " + table;
//            System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int count = rs.getInt("raws");
            }
            stmt.close();
        } catch (SQLException e) {
            Logger.getLogger(CsvToBdd.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
        return exist;
    }

    private static boolean createTable(String table, String[] columns) {
        boolean result = true;
        String sql = "";
        try (Statement stmt = getConnection().createStatement()) {
            if (checkTableExist(table)) {
                sql = "drop table " + table;
                System.out.println(sql);
                stmt.executeUpdate(sql);
            }
            sql = "create table " + table + " (";
            for (String column : columns) {
                sql += column + " varchar, ";
            }
            sql = sql.trim().substring(0, sql.length() - 2) + ")";
            System.out.println(sql);
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException e) {
            Logger.getLogger(CsvToBdd.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
        return result;
    }

    private static void createRecord(String table, CSVRecord record) {
        try (Statement stmt = getConnection().createStatement()) {
            if (record.get(0) != null && !record.get(0).isEmpty()) {
                String sql = "insert into " + table + " values ("
                        + "\'" + record.get(0)+ "\'" + ", "
                        + "\'"+ ((record.get(1) != null) ? record.get(1) : "")+ "\'" + ", "
                        + "\'"+ ((record.get(2) != null) ? record.get(2) : "")+ "\'" + ")";
                System.out.println(sql);
                stmt.executeUpdate(sql);
                stmt.close();
            }
        } catch (SQLException e) {
            Logger.getLogger(CsvToBdd.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    private static String[] getHeader(Iterable<CSVRecord> records) {
        String[] header = null;
        CSVRecord record = records.iterator().next();
        List<String> list = record.getParser().getHeaderNames();
        header = list.toArray(new String[0]);
        return header;
    }

    public static void main(String[] args) throws IOException {
        Reader in = new FileReader("C:\\devpt\\tmp\\Communes.csv");
        CSVFormat csv = CSVFormat.RFC4180
                .withDelimiter(';')
                .withFirstRecordAsHeader();
        String[] header = getHeader(csv.parse(in));

        Iterable<CSVRecord> records = csv.parse(in);
        if (header != null && createTable("cities.communes", header)) {
            for (CSVRecord record : records) {
//                System.out.println(record.get(0) + "\t" + Double.parseDouble(record.get(1)));
                createRecord("cities.communes", record);
            }
        }
        in.close();
    }
}
