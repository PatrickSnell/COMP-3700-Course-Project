import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordController implements ActionListener {
    private PasswordView passwordView;
    private DataAdapter dataAdapter;

    public PasswordController(PasswordView passwordView, DataAdapter dataAdapter) {
        this.dataAdapter = dataAdapter;
        this.passwordView = passwordView;

        //passwordView.getBtnLoad().addActionListener(this);
        passwordView.getBtnSave().addActionListener(this);
    }


    public void actionPerformed(ActionEvent e) {
        //if (e.getSource() == productView.getBtnLoad())
        //    loadProduct();
        //else
        if (e.getSource() == passwordView.getBtnSave())
            savePassword();
    }

    private void savePassword() {
        String userID = passwordView.getTxtUserId().getText().trim();
        if (userID.length() == 0) {
            JOptionPane.showMessageDialog(null, "Invalid User ID!");
            return;
        }

        String oldpassword = passwordView.getTxtOldPassword().getText().trim();
        if (oldpassword.length() == 0) {
            JOptionPane.showMessageDialog(null, "Invalid password!");
            return;
        }

        String newpassword = passwordView.getTxtNewPassword().getText().trim();
        if (newpassword.length() == 0) {
            JOptionPane.showMessageDialog(null, "Invalid password!");
            return;
        }

        Password password = new Password();
        password.setUserId(userID);
        password.setOldPassword(oldpassword);
        password.setNewPassword(newpassword);

        // Store the password to the database
        dataAdapter.loadPassword(password);
        dataAdapter.savePassword(password);
    }

}