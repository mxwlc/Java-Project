import java.sql.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class App {
    static final String url = "jdbc:mysql://localhost:3306/vehicle?autoCorrect=true";
    static final String user = "root";
    static final String password = "root";
    static int maxID;
    static final int pad = 30;

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
                        maxID = 99;
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

    static void UpdateSql(String ma, String mo, double ec, int ye, double pr, Statement curr) {
        try {
            vehicle tempV = new vehicle(ma, mo, ec, ye, pr);
            int maxID = findMaxID(curr) + 1;
            String sql = addRow(tempV, maxID);

            curr.executeUpdate(sql);
        } catch (Exception e) {
            throw new Error("Problem", e);
        }

    }

    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame();
        ImageIcon carIcon = new ImageIcon("src/car-xxl.png");

        JPanel border = new JPanel();
        Border padding = BorderFactory.createEmptyBorder(pad, pad, pad, pad);
        border.setBorder(padding);

        frame.setIconImage(carIcon.getImage());
        frame.setSize(700, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(border);

        JLabel title = new JLabel("Car Database");
        title.setFont(new Font("sansserif", Font.PLAIN, 24));
        frame.getContentPane().add(title);
        title.setHorizontalAlignment(JLabel.CENTER);

        JLabel blank = new JLabel("");
        frame.getContentPane().add(blank);

        JLabel makeLabel = new JLabel("Make: ");
        frame.getContentPane().add(makeLabel);

        JTextField inputMake = new JTextField();
        frame.getContentPane().add(inputMake);

        JLabel modelLabel = new JLabel("Model: ");
        frame.getContentPane().add(modelLabel);

        JTextField inputModel = new JTextField();
        frame.getContentPane().add(inputModel);

        JLabel EngineCapacityLabel = new JLabel("Engine Capacity: ");
        frame.getContentPane().add(EngineCapacityLabel);

        JTextField inputEngineCapacity = new JTextField();
        frame.getContentPane().add(inputEngineCapacity);

        JLabel YearLabel = new JLabel("Year Of Manufactoring: ");
        frame.getContentPane().add(YearLabel);

        JTextField inputYear = new JTextField();
        frame.getContentPane().add(inputYear);

        JLabel PriceLabel = new JLabel("Price: ");
        frame.getContentPane().add(PriceLabel);

        JTextField inputPrice = new JTextField();
        frame.getContentPane().add(inputPrice);

        frame.setLayout(new GridLayout(7, 2));
        frame.setVisible(true);
        JButton submit = new JButton("Submit");
        frame.getContentPane().add(submit);

        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            Statement current = conn.createStatement();
            submit.addActionListener(e -> UpdateSql(inputMake.getText(), inputModel.getText(),
                    Double.parseDouble(inputEngineCapacity.getText()), Integer.parseInt(inputYear.getText()),
                    Double.parseDouble(inputPrice.getText()),
                    current));
            
        } catch (SQLException e) {
            throw new Error("Problem", e);
        }
    }
}
