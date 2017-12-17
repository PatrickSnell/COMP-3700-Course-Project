import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class OrderView extends JFrame{

    private JTextField txtOrderID  = new JTextField(10);
    private JTextField txtCustomerName  = new JTextField(30);
    private JTextField txtPaymentChoice  = new JTextField(10);
    private JTextField txtSubtotal  = new JTextField(10);
    private JTextField txtTaxRate  = new JTextField(10);
    private JTextField txtTotalPrice  = new JTextField(10);

    private JButton cashierScreen = new JButton("Return Home");
    private DefaultTableModel items = new DefaultTableModel();
    private JTable table = new JTable(items);
    DataAdapter dataAdapter;

    public OrderView() {
        this.setTitle("Order Details");
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.setSize(400, 600);
        items.addColumn("Order ID");
        items.addColumn("CustomerName");
        items.addColumn("Payment Choice");
        items.addColumn("Subtotal");
        items.addColumn("TaxRate");
        items.addColumn("TotalPrice");
        JPanel panelOrder = new JPanel();
        panelOrder.setPreferredSize(new Dimension(400, 450));
        panelOrder.setLayout(new BoxLayout(panelOrder, BoxLayout.PAGE_AXIS));
        table.setBounds(0, 0, 500, 350);
        panelOrder.add(table.getTableHeader());
        panelOrder.add(table);
        this.getContentPane().add(panelOrder);

        JPanel panelButton = new JPanel();
        panelButton.setPreferredSize(new Dimension(400, 100));
        panelButton.add(cashierScreen);
        this.getContentPane().add(panelButton);
    }
    public JButton returnToCashierScreen() {
        return cashierScreen;
    }

    public JTextField getTxtOrderID() {
        return txtOrderID;
    }

    public JTextField getTxtCustomerName() {
        return txtCustomerName;
    }

    public JTextField getTxtPaymentChoice() {
        return txtPaymentChoice;
    }

    public JTextField getTxtSubtotal() {
        return txtSubtotal;
    }

    public JTextField getTxtTaxRate() {
        return txtTaxRate;
    }

    public JTextField getTxtTotalPrice() {
        return txtTotalPrice;
    }

}