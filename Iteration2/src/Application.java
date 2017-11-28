import com.sun.org.apache.bcel.internal.generic.NEW;

import java.sql.*;

public class Application {

    private static Application instance;   // Singleton pattern

    public static Application getInstance() {
        if (instance == null) {
            instance = new Application();
        }
        return instance;
    }
    // Main components of this application

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    private DataAdapter dataAdapter;

    // Create the Product View and Controller here!

    private ProductView productView = new ProductView();

    private OrderView orderView = new OrderView();

    private CheckoutScreen checkoutScreen = new CheckoutScreen();

    private ManagerScreen managerScreen = new ManagerScreen();

    // new
    private LoginScreen loginScreen = new LoginScreen();

    private DataAdapter checkLogin;

    private PasswordView passwordScreen = new PasswordView();

    private PictureView pictureScreen = new PictureView();

    private ReportView reportView = new ReportView();

    private CashierView cashierView = new CashierView();

    private NewUserView newUserView = new NewUserView();

    public ManagerScreen getMainScreen() {
        return managerScreen;
    }

    public ProductView getProductView() {
        return productView;
    }

    public OrderView getOrderView() {
        return orderView;
    }

    public CheckoutScreen getCheckoutScreen() {
        return checkoutScreen;
    }

    public CashierView getCashierView() {
        return cashierView;
    }



    // New for Iteration 2
    public LoginScreen getLoginScreen() {
        return loginScreen;
    }

    public ReportView getReportView() {return reportView; }
/*
    public DataAdapter get() {
        return checkLogin;
    }*/

    public PasswordView getPasswordScreen() {
        return passwordScreen;
    }

    public PictureView getPictureScreen() {
        return pictureScreen;
    }

    public NewUserView getNewUserView() {
        return newUserView;
    }


    private ProductController productController;

    public ProductController getProductController() {
        return productController;
    }

    private OrderController orderController;

    public OrderController getOrderController() { return orderController; }

    private CheckoutController checkoutController;

    private PasswordController passwordController;

    public PasswordController getPasswordController() {
        return passwordController;
    }

    private ReportController reportController;

    public ReportController getReportController() {
        return reportController;
    }

    private LoginController loginController;

    public LoginController getLoginController() {
        return loginController;
    }

    private NewUserController newUserController;

    public NewUserController getNewUserController() {
        return newUserController;
    }

    public CheckoutController getCheckoutController() {
        return checkoutController;
    }

    public DataAdapter getDataAdapter() {
        return dataAdapter;
    }

    private void initializeDatabase(Statement stmt) throws SQLException {
        // create the tables and insert sample data here!

        stmt.execute("create table Product (ProductID int PRIMARY KEY, ProductName char(30), Price double, Quantity double)");
        //    stmt.execute("create table Order (ProductID int PRIMARY KEY, ProductName char(30), Price double, Quantity double)");


    }

    private Application() {
        // create SQLite database connection here!
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //connection for my local computer
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Store_Management_System","root","Bravesfan42");
        }
        catch (ClassNotFoundException ex) {
            System.out.println("Database could not be loaded");
            System.out.println(ex.getMessage());
            ex.printStackTrace();
//            System.exit(1);
        }

        catch (SQLException ex) {
            System.out.println("Database could not be loaded");
            System.out.println(ex.getSQLState() + ex.getMessage());
            System.exit(2);
        }

        // Create data adapter here!
        dataAdapter = new DataAdapter(connection);

        productController = new ProductController(productView, dataAdapter);

        checkoutController = new CheckoutController(checkoutScreen, dataAdapter);

        orderController = new OrderController(orderView, dataAdapter);

        passwordController = new PasswordController(passwordScreen, dataAdapter);

        reportController = new ReportController(reportView, dataAdapter);

        newUserController = new NewUserController(newUserView, dataAdapter);

    }

    /*
    public static void main(String[] args) {
        Application.getInstance().getLoginScreen().setVisible(true);
    }*/
    public static void main(String[] args) {
        Application.getInstance().getLoginScreen().setVisible(true);
    }
}
