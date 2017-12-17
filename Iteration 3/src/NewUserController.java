import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewUserController implements ActionListener {
    private NewUserView newUserView;
    private DataAdapter dataAdapter;

    public NewUserController(NewUserView newUserView, DataAdapter dataAdapter) {
        this.dataAdapter = dataAdapter;
        this.newUserView = newUserView;

        //passwordView.getBtnLoad().addActionListener(this);
        newUserView.getBtnSaveUser().addActionListener(this);
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newUserView.getBtnSaveUser())
            saveNewUser();
    }

    private void saveNewUser() {
        String UserId = newUserView.getTxtUserID().getText().trim();
        if (UserId.length() == 0) {
            JOptionPane.showMessageDialog(null, "Invalid User ID!");
            return;
        }

        String userName = newUserView.getTxtUserName().getText().trim();
        if (userName.length() == 0) {
            JOptionPane.showMessageDialog(null, "Invalid User Name!");
            return;
        }

        String password = newUserView.getTxtPassword().getText().trim();
        if (password.length() == 0) {
            JOptionPane.showMessageDialog(null, "Invalid Password!");
            return;
        }

        String isManager = newUserView.getTxtIsManager().getText().trim();
        if (isManager.length() == 0) {
            JOptionPane.showMessageDialog(null, "Invalid User Role!");
            return;
        }

        User employee = new User();
        employee.setUserID(UserId);
        employee.setUserName(userName);
        employee.setPassword(password);
        employee.setManager(isManager);


        // Store the user to the database
        dataAdapter.saveUser(employee);
    }
}