import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PictureController implements ActionListener {
    private PictureView pictureView;
    private DataAdapter dataAdapter;

    public PictureController(PictureView pictureView, DataAdapter dataAdapter) {
        this.dataAdapter = dataAdapter;
        this.pictureView = pictureView;

        //passwordView.getBtnLoad().addActionListener(this);
        pictureView.getBtnSave().addActionListener(this);
    }


    public void actionPerformed(ActionEvent e) {
        //if (e.getSource() == productView.getBtnLoad())
        //    loadProduct();
        //else
        if (e.getSource() == pictureView.getBtnSave())
            savePicture();
    }

    private void savePicture() {
        String userID = pictureView.getTxtUserId().getText().trim();
        if (userID.length() == 0) {
            JOptionPane.showMessageDialog(null, "Invalid User ID!");
            return;
        }

        String password = pictureView.getTxtPassword().getText().trim();
        if (password.length() == 0) {
            JOptionPane.showMessageDialog(null, "Invalid password!");
            return;
        }

        User person = new User();
        person.setUserID(userID);
        person.setPassword(password);

        // Store the picture to the database
        //dataAdapter.savePicture(person);
    }

}