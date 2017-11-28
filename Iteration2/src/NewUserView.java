import javax.swing.*;

public class NewUserView extends JFrame{

    private JTextField txtUserId  = new JTextField(10);
    private JTextField txtUserName  = new JTextField(10);
    private JTextField txtPassword  = new JTextField(10);
    private JTextField txtIsManager  = new JTextField(10);

    private JButton btnSaveUser = new JButton("Save User");

    public NewUserView() {
        this.setTitle("New User View");
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
        this.setSize(500, 400);

        JPanel panelButton = new JPanel();
        panelButton.add(btnSaveUser);
        this.getContentPane().add(panelButton);

        JPanel panelUserID = new JPanel();
        panelUserID.add(new JLabel("User ID: "));
        panelUserID.add(txtUserId);
        txtUserId.setHorizontalAlignment(JTextField.RIGHT);
        this.getContentPane().add(panelUserID);

        JPanel panelUserName = new JPanel();
        panelUserName.add(new JLabel("User Name: "));
        panelUserName.add(txtUserName);
        this.getContentPane().add(panelUserName);

        JPanel panelPassword = new JPanel();
        panelPassword.add(new JLabel("Password: "));
        panelPassword.add(txtPassword);
        this.getContentPane().add(panelPassword);

        JPanel panelIsManager = new JPanel();
        panelIsManager.add(new JLabel("Is Manager (Type Yes or No): "));
        panelIsManager.add(txtIsManager);
        this.getContentPane().add(panelIsManager);

    }

    public JButton getBtnSaveUser() {
        return btnSaveUser;
    }

    public JTextField getTxtUserID() {
        return txtUserId;
    }

    public JTextField getTxtUserName() {
        return txtUserName;
    }

    public JTextField getTxtPassword() {
        return txtPassword;
    }

    public JTextField getTxtIsManager() {
        return txtIsManager;
    }

}