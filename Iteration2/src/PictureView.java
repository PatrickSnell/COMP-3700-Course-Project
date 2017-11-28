import javax.swing.*;

public class PictureView extends JFrame{

    private JButton btnUpload = new JButton("Upload Picture");
    private JButton btnSave = new JButton("Save Picture");

    public PictureView() {
        this.setTitle("Change Picture");
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
        this.setSize(300, 300);

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

}
