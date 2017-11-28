import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrderController implements ActionListener {
    private OrderView orderView;
    private DataAdapter dataAdapter;

    public OrderController(OrderView view, DataAdapter dataAdapter) {
        this.dataAdapter = dataAdapter;
        this.orderView = view;
        view.returnToMainScreen().addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        Application.getInstance().getMainScreen().setVisible(true);
    }

    private void saveOrder() {
        int orderID;
        try {
            orderID = Integer.parseInt(orderView.getTxtOrderID().getText());
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid order ID!");
            return;
        }

        String customerName = orderView.getTxtCustomerName().getText().trim();

        if (customerName.length() == 0) {
            JOptionPane.showMessageDialog(null, "Invalid customer name!");
            return;
        }

        String paymentChoice = orderView.getTxtPaymentChoice().getText().trim();

        if (paymentChoice.length() == 0) {
            JOptionPane.showMessageDialog(null, "Invalid payment choice!");
            return;
        }


        double subtotal;
        try {
            subtotal = Double.parseDouble(orderView.getTxtSubtotal().getText());
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid subtotal!");
            return;
        }

        double taxRate;
        try {
            taxRate = Double.parseDouble(orderView.getTxtTaxRate().getText());
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid tax rate!");
            return;
        }

        double totalPrice;
        try {
            totalPrice = Double.parseDouble(orderView.getTxtTotalPrice().getText());
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid total price!");
            return;
        }

        Order order1 = new Order();
        order1.setOrderID(orderID);
        order1.setCustomerName(customerName);
        order1.setPaymentChoice(paymentChoice);
        order1.setSubtotal(subtotal);
        order1.setTaxRate(taxRate);
        order1.setTotalCost(totalPrice);

        dataAdapter.saveOrder(order1);
    }

}