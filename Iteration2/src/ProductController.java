import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductController implements ActionListener {
    private ProductView productView;
    private DataAdapter dataAdapter; // to save and load product information

    public ProductController(ProductView productView, DataAdapter dataAdapter) {
        this.dataAdapter = dataAdapter;
        this.productView = productView;

        productView.getBtnLoad().addActionListener(this);
        productView.getBtnSave().addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == productView.getBtnLoad())
            loadProduct();
        else
        if (e.getSource() == productView.getBtnSave())
            saveProduct();
    }

    private void saveProduct() {
        int productID;
        try {
            productID = Integer.parseInt(productView.getTxtProductID().getText());
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid product ID!");
            return;
        }

        double productPrice;
        try {
            productPrice = Double.parseDouble(productView.getTxtProductPrice().getText());
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid product price!");
            return;
        }

        int productQuantity;
        try {
            productQuantity = Integer.parseInt(productView.getTxtProductQuantity().getText());
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid product quantity!");
            return;
        }

        String productName = productView.getTxtProductName().getText().trim();

        if (productName.length() == 0) {
            JOptionPane.showMessageDialog(null, "Invalid product name!");
            return;
        }


        String providerName = productView.getTxtProvider().getText().trim();

        if (providerName.length() == 0) {
            JOptionPane.showMessageDialog(null, "Invalid provider!");
            return;
        }

        String providerContact = productView.getTxtContact().getText().trim();

        if (providerContact.length() == 0) {
            JOptionPane.showMessageDialog(null, "Invalid contact!");
            return;
        }

        Product product = new Product();
        product.setProductID(productID);
        product.setName(productName);
        product.setQuantity(productQuantity);
        product.setPrice(productPrice);
        product.setproviderName(providerName);
        product.setproviderContact(providerContact);


        // Store the product to the database

        dataAdapter.saveProduct(product);
    }

    private void loadProduct() {
        int productID = 0;
        try {
            productID = Integer.parseInt(productView.getTxtProductID().getText());
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid product ID! Please provide a valid product ID!");
            return;
        }

        Product product = dataAdapter.loadProduct(productID);

        if (product == null) {
            JOptionPane.showMessageDialog(null, "This product ID does not exist in the database!");
            return;
        }

        productView.getTxtProductName().setText(product.getName());
        productView.getTxtProductPrice().setText(String.valueOf(product.getPrice()));
        productView.getTxtProductQuantity().setText(String.valueOf(product.getQuantity()));
        productView.getTxtProvider().setText(String.valueOf(product.getproviderName()));
        productView.getTxtContact().setText(String.valueOf(product.getproviderContact()));
    }


}