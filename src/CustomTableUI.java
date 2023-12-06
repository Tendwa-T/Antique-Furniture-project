import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;


public class CustomTableUI extends JFrame {
    private JTextField widthField;
    private JTextField lengthField;

    private JTextField numOfDrawersField, numOfTablesField;
    private JButton createButton;
    private  JButton homeButton;
    private JComboBox choices;


    public CustomTableUI() {
        setTitle("Antique Furniture Kenya");
        String[] woodOptions = {"-choose-","Mahogany","Oak","Pine"};

        JLabel pageLabel = new JLabel("CUSTOM ORDER FORM");
        pageLabel.setSize(100,100);
        pageLabel.setBounds(180,20,250,50);


        widthField = new JTextField(10);
        widthField.setBounds(100,100, 150,30);
        JLabel widthLabel = new JLabel("Width: ");
        widthLabel.setBounds(10, 100, 100,30);


        lengthField = new JTextField(10);
        lengthField.setBounds(400, 100, 150,30);
        JLabel lengthLabel= new JLabel("Length: ");
        lengthLabel.setBounds(300, 100, 100,30);


        choices = new JComboBox(woodOptions);
        choices.setBounds(100, 150,150,30);
        JLabel woodType = new JLabel("Wood Type: ");
        woodType.setBounds(10,150,100,30);

        numOfDrawersField = new JTextField(10);
        numOfDrawersField.setBounds(400,150,150,30);
        JLabel numOfDrawers = new JLabel("No. of Drawers: ");
        numOfDrawers.setBounds(300,150,150,30);

        numOfTablesField = new JTextField(10);
        numOfTablesField.setBounds(400,200,150,30);
        JLabel numOfTables = new JLabel("No. of Drawers: ");
        numOfTables.setBounds(300,200,150,30);

        createButton = new JButton("Create Table");
        createButton.setBounds(300,300,150,40);

        homeButton = new JButton("Home");
        homeButton.setBounds(100,300,150,40);



        setLayout(null);
        add(pageLabel);
        add(widthLabel);
        add(widthField);

        add(lengthLabel);
        add(lengthField);

        add(woodType);
        add(choices);

        add(numOfDrawers);
        add(numOfDrawersField);

        add(numOfTables);
        add(numOfTablesField);

        add(createButton);
        add(homeButton);

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    float width = Float.parseFloat(widthField.getText());
                    float length = Float.parseFloat(lengthField.getText());
                    int numOfDrawers = Integer.parseInt(numOfDrawersField.getText());
                    String woodType = (String) choices.getItemAt(choices.getSelectedIndex());
                    int tablesCount = Integer.parseInt(numOfTablesField.getText());
                    String orderID = orderIDGen();

                    CustomTable table = new CustomTable(width, length, woodType, numOfDrawers);
                    table.getData();
                    table.discount(tablesCount);
                    FileWriter writer = new FileWriter("CustomTableDetails.txt",true);

                    writer.append("{" + "\n");
                    writer.append("Oder ID:").append(String.valueOf(orderID)).append("\n");
                    writer.append("Width: ").append(String.valueOf(width)).append("\n");
                    writer.append("Length: ").append(String.valueOf(length)).append("\n");
                    writer.append("Wood Type: ").append(woodType).append("\n");
                    writer.append("Number of Drawers: ").append(String.valueOf(numOfDrawers)).append("\n");
                    writer.append("}" + "\n");
                    writer.append("\n");
                    writer.close();



                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection connection = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/java_proj","root","Captainscabin"
                    );

                    Statement statement = connection.createStatement();

                    String sql = "INSERT INTO CustomOrders (OrderID, Width, length, woodtype, drawers ) VALUES ('"+ orderID +"'," + width + ", " + length + ", '" + woodType +"'," + numOfDrawers +" )";
                    statement.executeUpdate(sql);

                    statement.close();
                    connection.close();

                    InvoiceUI ui =new InvoiceUI(table, tablesCount);
                    ui.setSize(600,500);
                    ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    ui.setVisible(true);
                    setVisible(false);

                    // Handle the created table object here
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter numeric values for width, length, and number of drawers.");
                } catch (RuntimeException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }catch (IOException ex){
                    JOptionPane.showMessageDialog(null,"Error writing to file");
                } catch (ClassNotFoundException | SQLException ex) {
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


    private String orderIDGen(){
        int codeLength = 8;
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder randomCode = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < codeLength; i++) {
            int index = random.nextInt(characters.length());
            randomCode.append(characters.charAt(index));
        }

        return randomCode.toString();

    }
}
