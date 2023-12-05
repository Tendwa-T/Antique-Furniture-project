import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.PrivateKey;
import java.text.NumberFormat;

public class InvoiceUI extends JFrame {
    private JLabel areaLabel, areaValue,areaPrice;
    private JLabel drawerLabel, drawerVal, drawerPrice;
    private JLabel woodLabel,woodVal, woodPrice;
    private JLabel totalPriceLabel, totalPriceVal,totalPrice;
    private JLabel description, pageTitle, value, cost;
    private JLabel divider, divider1;
    private JTextField widthField, lengthField;

    private JButton home;




    public InvoiceUI(CustomTable table) {
        setTitle("Invoice");
        Font tlfont = new Font("", Font.BOLD,20);
        Font lbFont = new Font("",Font.PLAIN, 15);
        Font emFont = new Font("",Font.BOLD, 15);
        Font hdFont = new Font("", Font.ITALIC,18);
        NumberFormat format = NumberFormat.getNumberInstance();

        pageTitle = new JLabel("Invoice");
        pageTitle.setFont(tlfont);
        pageTitle.setBounds(250,10,100,40);

        description = new JLabel("Description ");
        description.setFont(hdFont);
        description.setBounds(100,60,100,40);

        value = new JLabel("Value");
        value.setFont(hdFont);
        value.setBounds(250, 60,100,40);

        cost = new JLabel("Cost");
        cost.setFont(hdFont);
        cost.setBounds(350,60,100,40);

        divider1 = new JLabel("***************************************************************************************************************");
        divider1.setBounds(0,30,700,40);

        divider = new JLabel("===============================================================================================================");
        divider.setBounds(0,250,700,40);

        areaLabel = new JLabel("Area: ");
        areaLabel.setBounds(150,120,100,40);
        areaLabel.setFont(lbFont);

        areaValue = new JLabel(String.valueOf(format.format(table.getArea())));
        areaValue.setBounds(250, 120,100, 40);

        areaPrice = new JLabel(String.valueOf(format.format(areaCost(table.getArea()))));
        areaPrice.setBounds(350,120,100,40);

        woodLabel = new JLabel("Wood: ");
        woodLabel.setBounds(150,170,100,40);
        woodLabel.setFont(lbFont);

        woodVal = new JLabel(table.getWoodType());
        woodVal.setBounds(250, 170, 100, 40);

        woodPrice = new JLabel(String.valueOf(format.format(woodCost(table.getWoodType()))));
        woodPrice.setBounds(350,170,100,40);

        drawerLabel = new JLabel("Drawers: ");
        drawerLabel.setBounds(150, 220,100,40);
        drawerLabel.setFont(lbFont);

        drawerVal = new JLabel(format.format(table.getNumOfDrawers()));
        drawerVal.setBounds(250,220,100,40);

        drawerPrice = new JLabel(String.valueOf(format.format(drawerCost(table.getNumOfDrawers()))));
        drawerPrice.setBounds(350,220,100,40);

        totalPriceLabel = new JLabel("Total Price");
        totalPriceLabel.setBounds(150,270,100,40);
        totalPriceLabel.setFont(emFont);

        totalPrice = new JLabel(String.valueOf(format.format(table.getPrice())));
        totalPrice.setBounds(350,270,100,40);

        home = new JButton("Home");
        home.setBounds(250,350,100,40);


        setLayout(null);
        add(pageTitle);
        add(description);
        add(value);
        add(cost);

        add(areaLabel);
        add(areaValue);
        add(areaPrice);

        add(woodLabel);
        add(woodVal);
        add(woodPrice);

        add(drawerLabel);
        add(drawerPrice);
        add(drawerVal);

        add(totalPriceLabel);
        add(totalPrice);
        add(divider);
        add(divider1);


        add(home);
        JOptionPane.showMessageDialog(null,"That's It for Your Java Project");

        home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try{
                    HomeUI ui = new HomeUI();
                    ui.setSize(600,500);
                    ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    ui.setVisible(true);
                    setVisible(false);
                } catch (RuntimeException ex){
                    throw new RuntimeException(ex);
                }
            }
        });

    }

    public InvoiceUI(Table table) {
        setTitle("Invoice");
        Font tlfont = new Font("", Font.BOLD,20);
        Font lbFont = new Font("",Font.PLAIN, 15);
        Font emFont = new Font("",Font.BOLD, 15);
        Font hdFont = new Font("", Font.ITALIC,18);
        NumberFormat format = NumberFormat.getNumberInstance();

        pageTitle = new JLabel("Invoice");
        pageTitle.setFont(tlfont);
        pageTitle.setBounds(250,10,100,40);

        description = new JLabel("Description ");
        description.setFont(hdFont);
        description.setBounds(100,60,100,40);

        value = new JLabel("Value");
        value.setFont(hdFont);
        value.setBounds(250, 60,100,40);

        cost = new JLabel("Cost");
        cost.setFont(hdFont);
        cost.setBounds(350,60,100,40);


        lengthField = new JTextField(10);
        lengthField.setText(String.valueOf(table.getLength()));
        lengthField.setBounds(250, 100, 80, 30);
        lengthField.setEditable(false);
        JLabel lengthLabel = new JLabel("Length: ");
        lengthLabel.setBounds(150, 100, 80, 30);


        widthField = new JTextField(10);
        widthField.setText(String.valueOf(table.getWidth()));
        widthField.setBounds(250, 150, 80, 30);
        widthField.setEditable(false);
        JLabel widthLabel = new JLabel("Width: ");
        widthLabel.setBounds(150, 150, 100, 30);


        divider1 = new JLabel("***************************************************************************************************************");
        divider1.setBounds(0,30,700,40);

        divider = new JLabel("===============================================================================================================");
        divider.setBounds(0,250,700,40);

        areaLabel = new JLabel("Area: ");
        areaLabel.setBounds(150,200,100,40);
        areaLabel.setFont(lbFont);

        areaValue = new JLabel(String.valueOf(format.format(table.getArea())));
        areaValue.setBounds(250, 200,100, 40);

        areaPrice = new JLabel(String.valueOf(format.format(areaCost(table.getArea()))));
        areaPrice.setBounds(350,200,100,40);


        totalPriceLabel = new JLabel("Total Price");
        totalPriceLabel.setBounds(150,300,100,40);
        totalPriceLabel.setFont(emFont);

        totalPrice = new JLabel(String.valueOf(format.format(table.getPrice())));
        totalPrice.setBounds(350,300,100,40);

        home = new JButton("Home");
        home.setBounds(250,350,100,40);


        setLayout(null);
        add(pageTitle);
        add(description);
        add(value);
        add(cost);

        add(lengthLabel);
        add(lengthField);
        add(widthLabel);
        add(widthField);

        add(areaLabel);
        add(areaValue);
        add(areaPrice);

        add(totalPriceLabel);
        add(totalPrice);

        add(divider);
        add(divider1);


        add(home);

        home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try{
                    HomeUI ui = new HomeUI();
                    ui.setSize(600,500);
                    ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    ui.setVisible(true);
                    setVisible(false);
                } catch (RuntimeException ex){
                    throw new RuntimeException(ex);
                }
            }
        });

    }
    public float areaCost(float area){
        if (area>9600){
            return (42500+((area-9600)*825));
        }
        return 42500;
    }
    public float woodCost(String wood){
        if(wood.equals("Mahogany")){
            return 3000;
        } else if (wood.equals("Oak")) {
            return 2015;
        }
        return 0;
    }

    public float drawerCost(int drawers){
        if(drawers>0){
            return (float) ((2500)+(2000*(drawers-1)));
        }
        return 0;
    }
}
