import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreen extends JFrame {

    private JTextField txtUserId  = new JTextField(20);
    private JTextField txtPassword  = new JTextField(20);


    private JButton btnLogin = new JButton("Login");
    private JButton btnChangePassword   = new JButton("Change Password");
    private JButton btnChangePic  = new JButton("Change Picture");

    public LoginScreen () {
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 300);

        btnChangePassword.setPreferredSize(new Dimension(120, 50));
        btnLogin.setPreferredSize(new Dimension(120, 50));
        btnChangePic.setPreferredSize(new Dimension(120, 50));


        JLabel title = new JLabel("Login");
        title.setFont(new Font("Times New Roman", Font.BOLD, 24));
        JPanel panelTitle = new JPanel();
        panelTitle.add(title);
        this.getContentPane().add(panelTitle);


        JPanel panelUserID = new JPanel();
        panelUserID.add(new JLabel("User ID: "));
        panelUserID.add(txtUserId);
        this.getContentPane().add(panelUserID);

        JPanel panelPassword = new JPanel();
        panelPassword.add(new JLabel("Password: "));
        panelPassword.add(txtPassword);
        this.getContentPane().add(panelPassword);


        JPanel panelButton = new JPanel();
        panelButton.add(btnLogin);
        panelButton.add(btnChangePassword);
        panelButton.add(btnChangePic);

        this.getContentPane().add(panelButton);

        //Application.getInstance()

        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {


                String Uid = txtUserId.getText().trim();
                String pass = txtPassword.getText().trim();

                int testUser = Application.getInstance().getDataAdapter().checkUser(Uid, pass);
                if (testUser == 2) {
                    Application.getInstance().getMainScreen().setVisible(true);
                }
                else if (testUser == 1) {
                    Application.getInstance().getCashierView().setVisible(true);
                }
            }
        });


        btnChangePassword.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Application.getInstance().getPasswordScreen().setVisible(true);
            }
        });

        btnChangePic.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Application.getInstance().getPictureScreen().setVisible(true);
            }
        });

    }

    public JButton getBtnLogin() {
        return btnLogin;
    }

    public JButton getBtnChangePassword() {
        return btnChangePassword;
    }

    public JButton getBtnChagnePic() {
        return btnChangePic;
    }

    public JTextField getTxtUserId() {
        return txtUserId;
    }

    public JTextField getTxtPassword() {
        return txtPassword;
    }

    //public JTextField getTxtManager() {
    //    return txtManager;
    //}
}
