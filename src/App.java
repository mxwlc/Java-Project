import java.sql.*;
import java.util.Scanner;
// import java.util.ArrayList;

public class App {
    static final String url = "jdbc:mysql://localhost:3306/vehicle?autoCorrect=true";
    static final String user = "root";
    static final String password = "root";

    static String addRow(vehicle v, int id) {
        // "insert into cars values (id, 'make', 'model', engineCapacity,
        // yearOfManufacture, price)"
        String sql;
        String start = "insert into cars values( ";
        sql = start + id + ", '" + v.getMake() + "', '" + v.getModel() + "', "
                + v.getengineCapacity() + ", " + v.getyearOfManufacture() + ", " + v.getPrice() + ")";
        return sql;
    }

    static vehicle createVehicle(){
        String make, model;
        int engineCapacity, yearOfManufacture, price;

        Scanner input = new Scanner(System.in);
        System.out.println("Insert make");
        make = input.nextLine();

        System.out.println("Insert Model");
        model = input.nextLine();

        System.out.println("insert Engine Capacity");
        engineCapacity = 
    }

    public static void main(String[] args) throws Exception {

        // String add = "insert into cars values( ";
        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            String query = "select * from cars";
            Statement current = conn.createStatement();
            try {
                ResultSet answer = current.executeQuery(query);
                while (answer.next()) {
                    String make = answer.getString("make");
                    System.out.println(make);
                }

                // ArrayList<vehicle> cars = new ArrayList<vehicle>();

                
                vehicle newCar1 = new vehicle("Vauxhall", "Corsa", 200, 2004, 3000);
                System.out.print(addRow(newCar1, 0));
                current.executeUpdate("insert into cars values (1, 'Vauxhall', 'Corsa', 200, 2004, 300)");

            } catch (SQLException e) {
                throw new Error("Problem", e);
            }
            // System.out.println(focus.getMake());
        } catch (SQLException e) {
            throw new Error("Problem", e);
        }
    }
}
