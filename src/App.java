import java.sql.*;
import java.util.Scanner;
import java.util.ArrayList;

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

    static vehicle createVehicle() {
        String make, model;
        int engineCapacity, yearOfManufacture, price;

        Scanner input = new Scanner(System.in);
        System.out.println("Insert make");
        make = input.nextLine();

        System.out.println("Insert Model");
        model = input.nextLine();

        System.out.println("Insert Engine Capacity");
        engineCapacity = Integer.valueOf(input.nextLine());

        System.out.println("Insert Year of Manufacture");
        yearOfManufacture = Integer.valueOf(input.nextLine());

        System.out.println("Insert price");
        price = Integer.valueOf(input.nextLine());

        input.close();

        vehicle v = new vehicle(make, model, engineCapacity, yearOfManufacture, price);
        return v;

    }

    public static void main(String[] args) throws Exception {

        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            Statement current = conn.createStatement();
            try {
                ArrayList<cardict> cars = new ArrayList<cardict>();
                for(int i = 0; i < 5; i++){
                    vehicle v;
                    v = createVehicle();

                    cardict a = new cardict(v, i);
                    cars.add(a);
                }                





                vehicle newCar1 = new vehicle("Vauxhall", "Corsa", 200, 2004, 3000);
                System.out.print(addRow(newCar1, 0));
                current.executeUpdate("insert into cars values (1, 'Vauxhall', 'Corsa', 200, 2004, 300)");

            } catch (SQLException e) {
                throw new Error("Problem", e);
            }
        } catch (SQLException e) {
            throw new Error("Problem", e);
        }
    }
}
