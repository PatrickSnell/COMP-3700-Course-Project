import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReportController {
    private ReportView reportView;
    private DataAdapter dataAdapter;
    public Report report = new Report();

    public ReportController(ReportView view, DataAdapter dataAdapter) {
        this.dataAdapter = dataAdapter;
        this.reportView = view;

        loadReport();
    }



    public void loadReport() {
        //report = dataAdapter.loadReport();
        //reportView.getPanelRevenue().setText(String.valueOf(report.getPrice()));

        reportView.getPanelNumSales().setText("Number of Sales: " + report.getNumSales());
        reportView.getPanelMeanPerSale().setText("Mean Items per Sale: " + report.getAvgSaleQuant());
        reportView.getPanelNumProductSold().setText("Number of Products Sold: " + report.getNumProducts());
        reportView.getPanelRevenue().setText("Revenue: " + report.getRevenue());
        reportView.getPanelRevenuePerSale().setText("Mean Revenue per Sale: " + report.getAvgSale());

        //reportView.getPanel().setText("Lol");
        /*productView.getTxtProductName().setText(product.getName());
        productView.getTxtProductPrice().setText(String.valueOf(product.getPrice()));
        productView.getTxtProductQuantity().setText(String.valueOf(product.getQuantity()));
        productView.getTxtProvider().setText(String.valueOf(product.getproviderName()));
        productView.getTxtContact().setText(String.valueOf(product.getproviderContact()));*/
    }


}