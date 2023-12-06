import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.Arrays;

public class LoginUI extends JFrame {
    private JLabel userLabel, passLabel;
    private JTextField username;
    private final String userCredential = "Admin";
    private final char[] passCredential = "admin".toCharArray();
    private JPasswordField password;
    private JButton submit, cancel;

    public LoginUI (){
        setTitle("Login");
        userLabel = new JLabel("UserName");
        userLabel.setBounds(150,150,150,30);
        username = new JTextField(10);
        username.setBounds(250,150,150,30);

        passLabel = new JLabel("Password");
        passLabel.setBounds(150, 230,150,30);
        password = new JPasswordField(15);
        password.setBounds(250,230,150,30);

        cancel = new JButton("Cancel");
        cancel.setBounds(90,300,100,40);

        submit = new JButton("Submit");
        submit.setBounds(420,300, 100,40);



        setLayout(null);
        add(userLabel);
        add(username);

        add(passLabel);
        add(password);

        add(cancel);
        add(submit);

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (username.getText().equals(userCredential)){
                        if(Arrays.equals(password.getPassword(),passCredential)){
                            HomeUI ui = new HomeUI();
                            ui.setSize(600,500);
                            ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            ui.setVisible(true);
                            setVisible(!isVisible());
                        }else {
                            JOptionPane.showMessageDialog(null,"Invalid Password");
                        }
                    }else{
                        JOptionPane.showMessageDialog(null,"Invalid UserName");
                    }
                } catch (RuntimeException ex){
                    throw new RuntimeException(ex);
                }
            }
        });





    }
}
