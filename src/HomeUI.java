import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeUI extends JFrame {
    private JButton standardTbl = new JButton("Standard Table");
    private JButton customTbl = new JButton(" Custom Table");

    public HomeUI(){
        setTitle("Antique Furniture Kenya");
        JLabel pageLabel = new JLabel("HOME PAGE");
        pageLabel.setSize(100,100);
        pageLabel.setBounds(220,20,250,50);

        customTbl.setBounds(300,200,150,40);
        standardTbl.setBounds(100,200,150,40);

        setLayout(null);
        add(pageLabel);

        add(customTbl);
        add(standardTbl);

        customTbl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    CustomTableUI ui = new CustomTableUI();
                    ui.setSize(600,500);
                    ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    ui.setVisible(true);
                    setVisible(false);
                }catch (RuntimeException ex){
                    throw new RuntimeException(ex);
                }
            }
        });

        standardTbl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try{
                    StandardTableUI ui = new StandardTableUI();
                    ui.setSize(600,500);
                    ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    ui.setVisible(true);
                } catch (RuntimeException ex){
                    throw new RuntimeException(ex);
                }
            }
        });
    }
}
