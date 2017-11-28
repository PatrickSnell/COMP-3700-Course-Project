import javax.swing.*;
import java.sql.*;

public class DataAdapter {
    private Connection connection;

    public DataAdapter(Connection connection) {
        this.connection = connection;
    }

    //changed double to int to match database

    /*private static DataAdapter instance;   // Singleton pattern

    public static DataAdapter getInstance() {
        if (instance == null) {
            instance = new DataAdapter();
        }
        return instance;
    }*/

    public Product loadProduct(int id) {
        try {
            String query = "SELECT * FROM Product WHERE Barcode_Number = " + id;

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                Product product = new Product();
                product.setProductID(resultSet.getInt(1));
                product.setName(resultSet.getString(2));
                product.setQuantity(resultSet.getInt(3));
                product.setPrice(resultSet.getDouble(4));
                product.setproviderName(resultSet.getString(5));
                product.setproviderContact(resultSet.getString(6));
                resultSet.close();
                statement.close();

                return product;
            }

        } catch (SQLException e) {
            System.out.println("Database access error!");
            e.printStackTrace();
        }
        return null;
    }
    //changed int to double for quantity to match database
    //added two more fields for INSERT INTO statement. Will finish implementation for provider name and contact
    public boolean saveProduct(Product product) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Product WHERE Barcode_Number = ?");
            statement.setInt(1, product.getProductID());

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) { // this product exists, update its fields
                statement = connection.prepareStatement("UPDATE Product SET Product_Name = ?, Quantity_Available = ?, " +
                        "Price_Per_Unit = ?, Provider_Name = ?, Provider_Contact = ?  WHERE Barcode_Number = ?");
                statement.setString(1, product.getName());
                statement.setInt(2, product.getQuantity());
                statement.setDouble(3, product.getPrice());
                statement.setInt(6, product.getProductID());
                statement.setString(4, product.getproviderName());
                statement.setString(5, product.getproviderContact());
            }
            else { // this product does not exist, use insert into
                statement = connection.prepareStatement("INSERT INTO Product VALUES (?, ?, ?, ?, ?, ?)");
                statement.setInt(1, product.getProductID());
                statement.setString(2, product.getName());
                statement.setInt(3, product.getQuantity());
                statement.setDouble(4, product.getPrice());
                statement.setString(5, product.getproviderName());
                statement.setString(6, product.getproviderContact());

            }
            statement.execute();
            resultSet.close();
            statement.close();
            return true;        // save successfully

        } catch (SQLException e) {
            System.out.println("Database access error!");
            e.printStackTrace();
            return false; // cannot save!
        }
    }

    public Order loadOrder(int id) {
        try {
            Order order = null;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Orders WHERE Order_ID = " + id);

            if (resultSet.next()) {
                order = new Order();
                order.setOrderID(resultSet.getInt("OrderID"));
                order.setCustomerName(resultSet.getString("Customer"));
                order.setPaymentChoice(resultSet.getString("PaymentChoice"));
                order.setSubtotal(resultSet.getDouble("Subtotal"));
                order.setTaxRate(resultSet.getDouble("TaxRate"));
                order.setTotalCost(resultSet.getDouble("TotalCost"));
                resultSet.close();
                statement.close();
            }

            // loading the order lines for this order
            resultSet = statement.executeQuery("SELECT * FROM OrderLine WHERE Order_ID = " + id);

            while (resultSet.next()) {
                OrderLine line = new OrderLine();
                line.setOrderID(resultSet.getInt(1));
                line.setProductID(resultSet.getInt(2));
                line.setProductName(resultSet.getString(3));
                line.setQuantity(resultSet.getDouble(4));
                line.setCost(resultSet.getDouble(5));
                order.addLine(line);
            }

            return order;

        } catch (SQLException e) {
            System.out.println("Database access error!");
            e.printStackTrace();
            return null;
        }
    }

    public boolean saveOrder(Order order) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Orders VALUES (?, ?, ?, ?, ?, ?)");
            statement.setInt(1, order.getOrderID());
            statement.setString(2, order.getCustomerName());
            statement.setString(3, order.getPaymentChoice());
            statement.setDouble(4, order.getSubtotal());
            statement.setDouble(5, order.getTaxRate());
            statement.setDouble(6, order.getTotalCost());

            statement.execute();    // commit to the database;
            statement.close();

            statement = connection.prepareStatement("INSERT INTO OrderLine VALUES (?, ?, ?, ?, ?)");
            for (OrderLine line: order.getLines()) { // store for each order line!
                statement.setInt(1, line.getOrderID());
                statement.setInt(2, line.getProductID());
                statement.setString(3, line.getProductName());
                statement.setDouble(4, line.getQuantity());
                statement.setDouble(5, line.getCost());

                statement.execute();    // commit to the database;
            }
            statement.close();
            return true; // save successfully!
        }
        catch (SQLException e) {
            System.out.println("Database access error!");
            e.printStackTrace();
            return false;
        }
    }

    public boolean loadPassword(Password pass) {

        try {

            PreparedStatement statement2 = connection.prepareStatement("SELECT * FROM Users WHERE User_ID = ? AND User_Password = ?");
            statement2.setString(1, pass.getUserId());
            statement2.setString(2, pass.getOldPassword());
            ResultSet resultSet = statement2.executeQuery();

            if (resultSet.next()) {
                resultSet.close();
                statement2.close();
                return true;
            }
            else {
                JOptionPane.showMessageDialog(null, "Invalid User ID or Old Password! Please try again.");
                return false;
            }

        } catch (SQLException e) {
            System.out.println("Database access error!");
            e.printStackTrace();
            return false;
        }

    }


    // new savePassword
    public boolean savePassword(Password pass) {
        try {
            //String query = "UPDATE Users set User_Password = " + pass + " where User_ID = " + userId;
            //statement.setString(1, userName);
            //statement.setString(2, pass);

            PreparedStatement statement = connection.prepareStatement("UPDATE Users set User_Password = ? where User_ID = ? AND User_Password = ?");

            statement.setString(1, pass.getNewPassword());
            statement.setString(2, pass.getUserId());
            statement.setString(3, pass.getOldPassword());

            statement.execute();    // commit to the database;
            statement.close();
            return true;
        }
        catch (SQLException e) {
            System.out.println("Database access error!");
            e.printStackTrace();
            return false;
        }
    }

    public Report loadReport() {
        try {
            Report report = new Report();
            String query = "SELECT COUNT(Order_ID) FROM Orders";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                report.setNumSales(resultSet.getInt(1));
            }
            query = "SELECT SUM(Total_Price) FROM Orders";

            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                report.setRevenue(resultSet.getInt(1));
            }


            query = "SELECT AVG(Total_Price) FROM Orders";

            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                report.setAvgSale(resultSet.getDouble(1));
            }
            query = "SELECT AVG(Num_Products) FROM Orders";

            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                report.setAvgSaleQuant(resultSet.getDouble(1));
            }
            query = "SELECT SUM(Num_Products) FROM Orders";

            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                report.setNumProducts(resultSet.getInt(1));
            }
            resultSet.close();
            statement.close();
            return report;
        } catch (SQLException e) {
            System.out.println("Database access error!");
            e.printStackTrace();
        }
        return null;
    }


    public int checkUser(String txtUserId, String txtPassword) {
        try {

            PreparedStatement statement2 = connection.prepareStatement("SELECT * FROM Users WHERE User_ID = ? AND User_Password = ?");
            statement2.setString(1, txtUserId);
            statement2.setString(2, txtPassword);
            ResultSet resultSet = statement2.executeQuery();

            if (resultSet.next()) {
                User person = new User();
                person.setUserID(resultSet.getString(1));
                person.setUserName(resultSet.getString(2));
                person.setPassword(resultSet.getString(3));
                person.setManager(resultSet.getString(5));
                resultSet.close();
                statement2.close();
                String test = person.isManager();
                if (test.contains("Yes")) {
                    return 2;
                }
                else {
                    return 1;
                }
            }
            else {
                JOptionPane.showMessageDialog(null, "Invalid Employee login! Please try again.");
                return 0;
            }

        } catch (SQLException e) {
            System.out.println("Database access error!");
            e.printStackTrace();
            return 0;
        }
    }


    public boolean saveUser(User employee) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Users VALUES (?, ?, ?, ?, ?)");
            statement.setString(1, employee.getUserID());
            statement.setString(2, employee.getUserName());
            statement.setString(3, employee.getPassword());
            statement.setString(4, null);
            statement.setString(5, employee.isManager());

            statement.execute();    // commit to the database;
            statement.close();

            return true; // save successfully!
        }
        catch (SQLException e) {
            System.out.println("Database access error!");
            e.printStackTrace();
            return false;
        }
    }
}
