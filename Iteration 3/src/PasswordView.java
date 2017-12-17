import javax.swing.*;

public class PasswordView extends JFrame{
    private JTextField txtUserId  = new JTextField(10);
    private JTextField txtOldPassword  = new JTextField(10);
    private JTextField txtNewPassword  = new JTextField(10);

    private JButton btnSave = new JButton("Save Password");

    public PasswordView() {
        this.setTitle("Change Password");
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
        this.setSize(500, 400);

        JPanel panelUsername = new JPanel();
        panelUsername.add(new JLabel("User ID: "));
        panelUsername.add(txtUserId);
        txtUserId.setHorizontalAlignment(JTextField.RIGHT);
        this.getContentPane().add(panelUsername);

        JPanel panelOldPassword = new JPanel();
        panelOldPassword.add(new JLabel("Old Password: "));
        panelOldPassword.add(txtOldPassword);
        txtOldPassword.setHorizontalAlignment(JTextField.RIGHT);
        this.getContentPane().add(panelOldPassword);

        JPanel panelNewPassword = new JPanel();
        panelNewPassword.add(new JLabel("New Password: "));
        panelNewPassword.add(txtNewPassword);
        txtNewPassword.setHorizontalAlignment(JTextField.RIGHT);
        this.getContentPane().add(panelNewPassword);

        JPanel panelButton = new JPanel();
        panelButton.add(btnSave);
        this.getContentPane().add(panelButton);


    }

    public JButton getBtnSave() {
        return btnSave;
    }

    public JTextField getTxtUserId() {
        return txtUserId;
    }

    public JTextField getTxtOldPassword() {
        return txtOldPassword;
    }

    public JTextField getTxtNewPassword() {
        return txtNewPassword;
    }

}