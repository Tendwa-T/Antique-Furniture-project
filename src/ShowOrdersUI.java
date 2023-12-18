import com.sun.tools.jconsole.JConsoleContext;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;

public class ShowOrdersUI extends JFrame {
    private JLabel orderIDLabel, woodTypeLabel;
    public ShowOrdersUI(){
        setTitle(" Orders ");
        Font tlfont = new Font("", Font.BOLD,20);
        Font lbFont = new Font("",Font.PLAIN, 15);
        Font emFont = new Font("",Font.BOLD, 15);
        Font hdFont = new Font("", Font.ITALIC,18);

        orderIDLabel = new JLabel(" Order ID ");
        orderIDLabel.setFont(hdFont);
        orderIDLabel.setBounds(150,60,100,40);

        woodTypeLabel = new JLabel(" Wood Type ");
        woodTypeLabel.setFont(hdFont);
        woodTypeLabel.setBounds(300,60,100,40);

        DefaultListModel<String> model = new DefaultListModel<>();

        JList<String> resultList = new JList<>(model);


        setLayout(null);
        add(orderIDLabel);
        add(woodTypeLabel);


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/java_proj","root","Captainscabin"
            );
            ArrayList<String> orderIDList = new ArrayList<>();
            ArrayList<String> woodTypeList = new ArrayList<>();
            Statement statement = connection.createStatement();

            String sql = "SELECT * FROM CustomOrders";
            ResultSet result = statement.executeQuery(sql);
            while (result.next()){
                String orderID = result.getString("OrderID");
                String woodType = result.getString("woodType");
                orderIDList.add(orderID);
                woodTypeList.add(woodType);

                model.addElement("orderItem");
                System.out.println("OrderID: " + orderID);
                System.out.println("Wood type: " + woodType);

            }

            result.close();
            statement.close();
            connection.close();
        } catch (RuntimeException | SQLException | ClassNotFoundException ex){
            throw new RuntimeException(ex);
        }
    }
}
