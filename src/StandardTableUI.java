import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StandardTableUI extends JFrame {
    private JTextField widthField;
    public static Object tableObj;
    private JTextField lengthField;
    private JTextField numOfTableField;
    private int numOfTables;
    private JTextField numOfDrawersField;
    private JTextField price;
    private JButton generateInvButton, generateOrderButton;
    private JButton homeButton;

    public StandardTableUI(){
            setTitle("Antique Furniture Kenya");
            JLabel pageLabel = new JLabel("STANDARD ORDER FORM");
            pageLabel.setSize(100, 100);
            pageLabel.setBounds(180, 20, 250, 50);


            numOfTableField = new JTextField(10);
            numOfTableField.setBounds(100, 200, 150, 30);
            JLabel tableCount = new JLabel("No of Tables: ");
            tableCount.setBounds(10, 200, 200, 30);

            JLabel widthLabel = new JLabel("Width: ");
            widthLabel.setBounds(10, 100, 100, 30);

            JLabel lengthLabel = new JLabel("Length: ");
            lengthLabel.setBounds(300, 100, 100, 30);

            JLabel drawers = new JLabel("No of Drawers: ");
            drawers.setBounds(10, 150, 100, 30);

            JLabel priceLabel = new JLabel("Price: ");
            priceLabel.setBounds(300, 150, 150, 30);

            setLayout(null);
            add(numOfTableField);
            add(tableCount);

            add(pageLabel);

            add(widthLabel);

            add(lengthLabel);
            add(drawers);


            add(priceLabel);


            homeButton = new JButton("Home");
            homeButton.setBounds(50,300,100,40);

            generateInvButton = new JButton("Generate Invoice");
            generateInvButton.setBounds(350,300,150,40);

            generateOrderButton = new JButton("Generate order");
            generateOrderButton.setBounds(180,300,150,40);

            add(generateInvButton);
            add(homeButton);
            add(generateOrderButton);

            generateOrderButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    try {
                        Table table = new Table();
                        tableObj = table;
                        int numOfTables = Integer.parseInt(numOfTableField.getText());
                        table.discount(numOfTables);

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

                        generateInvButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent actionEvent) {
                                InvoiceUI ui = new InvoiceUI((Table) tableObj,numOfTables);
                                ui.setSize(600,500);
                                ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                ui.setVisible(true);
                                setVisible(!isVisible());
                            }
                        });
                    } catch (RuntimeException ex){
                        throw new RuntimeException(ex);
                    }
                }
            });

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


    }


}
