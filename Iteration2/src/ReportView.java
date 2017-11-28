import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.xml.crypto.Data;
import java.awt.*;

public class ReportView extends JFrame {

    private DefaultTableModel items = new DefaultTableModel(); // store information for the table!

    private JLabel panelRevenue = new JLabel();
    private JLabel panelNumSales = new JLabel();
    private JLabel panelMeanPerSale = new JLabel();
    private JLabel panelNumProductSold = new JLabel();
    private  JLabel panelRevenuePerSale = new JLabel();

    public ReportView() {



        this.setTitle("Business Report");
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.setSize(600, 200);

        this.getContentPane().add(panelNumSales);
        this.getContentPane().add(panelMeanPerSale);
        this.getContentPane().add(panelNumProductSold);
        this.getContentPane().add(panelRevenue);
        this.getContentPane().add(panelRevenuePerSale);


        /*items.addColumn("Number of Sales");
        items.addColumn("Mean Items per Sale");
        items.addColumn("Number of Products Solds");
        items.addColumn("Revenue");
        items.addColumn("Mean Revenue per Sale");*/




        JPanel panelButton = new JPanel();
        panelButton.setPreferredSize(new Dimension(400, 100));

       // this.getContentPane().add(panelButton);

    }




    public JLabel getPanelRevenue() {
        return panelRevenue;
    }

    public JLabel getPanelNumSales() {
        return panelNumSales;
    }

    public JLabel getPanelMeanPerSale() {
        return panelMeanPerSale;
    }

    public JLabel getPanelNumProductSold() {
        return panelNumProductSold;
    }

    public JLabel getPanelRevenuePerSale() {
        return panelRevenuePerSale;
    }
}
