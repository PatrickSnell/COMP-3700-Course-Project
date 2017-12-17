import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagerScreen extends JFrame {

    private JButton btnManage   = new JButton("Add New Product");
    private JButton btnUpdate  = new JButton("Update Product");
    private JButton btnNewUser = new JButton("New User");
    private JButton btnBusinessReport = new JButton("Business Report");

    public ManagerScreen() {
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 300);

        btnManage.setPreferredSize(new Dimension(120, 50));
        btnUpdate.setPreferredSize(new Dimension(120, 50));
        btnNewUser.setPreferredSize(new Dimension(120, 50));
        btnBusinessReport.setPreferredSize(new Dimension(120, 50));


        JLabel title = new JLabel("Store Management System");
        title.setFont(new Font("Times New Roman", Font.BOLD, 24));
        JPanel panelTitle = new JPanel();
        panelTitle.add(title);
        this.getContentPane().add(panelTitle);

        JPanel panelButton = new JPanel();
        panelButton.add(btnManage);
        panelButton.add(btnUpdate);
        panelButton.add(btnNewUser);
        panelButton.add(btnBusinessReport);

        this.getContentPane().add(panelButton);


        btnManage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Application.getInstance().getProductView().setVisible(true);
            }
        });

        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Application.getInstance().getProductView().setVisible(true);
            }
        });

        btnNewUser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Application.getInstance().getNewUserView().setVisible(true);
            }
        });

        btnBusinessReport.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Application.getInstance().getReportView().setVisible(true);
            }
        });
    }
}
