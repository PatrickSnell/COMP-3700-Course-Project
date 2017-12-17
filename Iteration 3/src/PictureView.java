
import javax.swing.*;

public class PictureView extends JFrame{

    private JTextField txtUserId  = new JTextField(10);
    private JTextField txtPassword  = new JTextField(10);
    private JButton btnUpload = new JButton("Upload Picture");
    private JButton btnSave = new JButton("Save Picture");

    public PictureView() {
        this.setTitle("Change Picture");
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
        this.setSize(300, 300);

        JPanel panelUserId = new JPanel();
        panelUserId.add(new JLabel("User ID: "));
        panelUserId.add(txtUserId);
        txtUserId.setHorizontalAlignment(JTextField.RIGHT);
        this.getContentPane().add(panelUserId);

        JPanel panelPassword = new JPanel();
        panelPassword.add(new JLabel("Password: "));
        panelPassword.add(txtPassword);
        txtPassword.setHorizontalAlignment(JTextField.RIGHT);
        this.getContentPane().add(panelPassword);


        JPanel panelButton = new JPanel();
        panelButton.add(btnUpload);
        this.getContentPane().add(panelButton);

        JPanel panelButton2 = new JPanel();
        panelButton2.add(btnSave);
        this.getContentPane().add(panelButton2);

    }

    public JButton getBtnSave() {
        return btnSave;
    }

    public JButton getBtnUpload() {
        return btnUpload;
    }

    public JTextField getTxtUserId() {
        return txtUserId;
    }

    public JTextField getTxtPassword() {
        return txtPassword;
    }

}