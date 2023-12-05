import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StandardTableUI extends JFrame {
    private JTextField widthField;
    private JTextField lengthField;
    private JTextField woodTypeField;
    private JTextField numOfDrawersField;
    private JTextField price;
    private JButton generateInvButton;
    private JButton homeButton;

    public StandardTableUI(){
            Table table = new Table();

            setTitle("Antique Furniture Kenya");
            JLabel pageLabel = new JLabel("STANDARD ORDER FORM");
            pageLabel.setSize(100, 100);
            pageLabel.setBounds(180, 20, 250, 50);

            widthField = new JTextField(10);
            widthField.setText(String.valueOf(table.getWidth()));
            widthField.setBounds(100, 100, 150, 30);
            widthField.setEditable(false);
            JLabel widthLabel = new JLabel("Width: ");
            widthLabel.setBounds(10, 100, 100, 30);

            lengthField = new JTextField(10);
            lengthField.setText(String.valueOf(table.getLength()));
            lengthField.setBounds(400, 100, 150, 30);
            lengthField.setEditable(false);
            JLabel lengthLabel = new JLabel("Length: ");
            lengthLabel.setBounds(300, 100, 100, 30);

            numOfDrawersField = new JTextField(10);
            numOfDrawersField.setText("0");
            numOfDrawersField.setEditable(false);
            numOfDrawersField.setBounds(100, 150, 150, 30);
            JLabel drawers = new JLabel("No of Drawers: ");
            drawers.setBounds(10, 150, 100, 30);

            price = new JTextField(10);
            price.setText(String.valueOf(table.getPrice()));
            price.setBounds(400, 150, 150, 30);
            price.setEditable(false);
            JLabel priceLabel = new JLabel("Price: ");
            priceLabel.setBounds(300, 150, 150, 30);

            homeButton = new JButton("Home");
            homeButton.setBounds(100,200,150,40);

            generateInvButton = new JButton("Generate Invoice");
            generateInvButton.setBounds(300,200,150,40);

            setLayout(null);
            add(pageLabel);
            add(widthLabel);
            add(widthField);

            add(lengthLabel);
            add(lengthField);


            add(drawers);
            add(numOfDrawersField);

            add(priceLabel);
            add(price);

            add(generateInvButton);
            add(homeButton);

        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    HomeUI ui = new HomeUI();
                    ui.setSize(600,500);
                    ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    ui.setVisible(true);
                    setVisible(false);
                } catch (RuntimeException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        generateInvButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                InvoiceUI ui = new InvoiceUI(table);
                ui.setSize(600,500);
                ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                ui.setVisible(true);
                setVisible(!isVisible());
            }
        });
    }


}
