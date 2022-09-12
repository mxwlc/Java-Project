import java.sql.*;
import java.util.Scanner;

public class App {
    static final String url = "jdbc:mysql://localhost:3306/vehicle?autoCorrect=true";
    static final String user = "root";
    static final String password = "root";

    static String addRow(vehicle v, int id) {
        // "insert into cars values (id, 'make', 'model', engineCapacity,
        // yearOfManufacture, price)
        String sql;
        String start = "insert into cars values( ";
        sql = start + id + ", '" + v.getMake() + "', '" + v.getModel() + "', "
                + v.getengineCapacity() + ", " + v.getyearOfManufacture() + ", " + v.getPrice() + ")";
        return sql;
    }

    static vehicle createVehicle() {
        String make, model;
        int yearOfManufacture;
        float engineCapacity, price;

        Scanner input = new Scanner(System.in);
        System.out.println("Insert make");
        make = input.nextLine();

        System.out.println("Insert Model");
        model = input.nextLine();

        System.out.println("Insert Engine Capacity");
        engineCapacity = Float.parseFloat(input.nextLine());

        System.out.println("Insert Year of Manufacture");
        yearOfManufacture = Integer.valueOf(input.nextLine());

        System.out.println("Insert price");
        price = Float.parseFloat(input.nextLine());

        input.close();

        vehicle v = new vehicle(make, model, engineCapacity, yearOfManufacture, price);
        return v;

    }

    public static void main(String[] args) throws Exception {

        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            Statement current = conn.createStatement();
            try {
                vehicle v = createVehicle();
                String sql = addRow(v, 0);
                current.executeUpdate(sql);


            } catch (SQLException e) {
                throw new Error("Problem", e);
            }
        } catch (SQLException e) {
            throw new Error("Problem", e);
        }
    }
}
