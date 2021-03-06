import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController implements ActionListener {
    private LoginScreen loginView;
    private DataAdapter dataAdapter; // to save and load product information

    public LoginController(LoginScreen loginView, DataAdapter dataAdapter) {
        this.dataAdapter = dataAdapter;
        this.loginView = loginView;

        loginView.getBtnLogin().addActionListener(this);
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginView.getBtnLogin())
            loadUser();
    }

    public boolean loadUser() {
        String userID = null;
        try {
            userID = String.valueOf(Integer.parseInt(loginView.getTxtUserId().getText()));
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid user ID! Please provide a valid user ID!");
            return false;
        }

        String password = loginView.getTxtPassword().getText().trim();
        if (password.length() == 0) {
            JOptionPane.showMessageDialog(null, "Invalid password!");
            return false;
        }

        return false;
    }


}
