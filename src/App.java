import java.sql.*;

public class App {
    static final String url = "jdbc:mysql://localhost:3306/vehicle?autoCorrect=true";
    static final String user = "root";
    static final String password = "root";
    static int maxID;

    static String addRow(vehicle v, int id) {
        // "insert into cars values (id, 'make', 'model', engineCapacity,
        // yearOfManufacture, price)
        String sql;
        String start = "insert into cars values( ";
        sql = start + id + ", '" + v.getMake() + "', '" + v.getModel() + "', "
                + v.getengineCapacity() + ", " + v.getyearOfManufacture() + ", " + v.getPrice() + ")";
        return sql;
    }

    static int findMaxID(Statement stmnt) {
        try {
            ResultSet max_ID = stmnt.executeQuery("select MAX(id) as maxID from cars");

            if (max_ID != null) {
                while (max_ID.next()) {
                    String temp = max_ID.getString("maxID");
                    if (temp == null) {
                        maxID = -1;
                    } else {
                        maxID = Integer.parseInt(temp);
                    }
                }

            }

            return maxID;
        } catch (Exception e) {
            throw new Error("Problem", e);
        }

    }

    public static void main(String[] args) throws Exception {

        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            Statement current = conn.createStatement();
            try {
                maxID = findMaxID(current);

                vehicle v = new vehicle("vauxhall", "Corsa", 3.5, 2004, 3500.99);
                String sql = addRow(v, maxID + 1);
                current.executeUpdate(sql);

            } catch (SQLException e) {
                throw new Error("Problem", e);
            }
        } catch (SQLException e) {
            throw new Error("Problem", e);
        }
    }
}
