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
        this.report = dataAdapter.loadReport();
        loadReport();
    }



    public void loadReport() {

        reportView.getPanelNumSales().setText("Number of Sales: " + report.getNumSales());
        reportView.getPanelMeanPerSale().setText("Mean Items per Sale: " + report.getAvgSaleQuant());
        reportView.getPanelNumProductSold().setText("Number of Products Sold: " + report.getNumProducts());
        reportView.getPanelRevenue().setText("Revenue: " + report.getRevenue());
        reportView.getPanelRevenuePerSale().setText("Mean Revenue per Sale: " + report.getAvgSale());

    }


}
