import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
/**
 * Started by Cameron on March 5th
 * Edited by Cameron on April 1st
 */
public class LoginScreen{
    private DatabaseConnection loginHandler;
    private JFrame frame = new JFrame("Log In");
    private JPanel panel = new JPanel();
    private JLabel username = new JLabel("Username: ");
    private JLabel password = new JLabel("Password: ");
    private JButton submit = new JButton("Submit");
    private JTextField userInput = new JTextField(10);
    private JPasswordField passInput = new JPasswordField(10); 
    public LoginScreen(){
        loginHandler = new DatabaseConnection();
        frame();
    }
    
    private void frame(){
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(65, 131, 126));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(5, 0, 5, 0);

        panel.add(username, gbc);
        panel.add(userInput, gbc);
        panel.add(password, gbc);
        panel.add(passInput, gbc);
        
        JPanel buttons = new JPanel(new GridBagLayout());
        buttons.setBackground(new Color(65, 131, 126));
        buttons.add(submit, gbc);

        gbc.weighty = 1;
        panel.add(buttons, gbc);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(panel);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.pack();
        frame.setVisible(true);
        
        submit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                    String user = userInput.getText().trim();
                    String pass = passInput.getText().trim();
                    if(loginHandler.login(user, pass)) {
                        frame.dispose();
                        new Lesson();
                    }else {
                        JOptionPane.showMessageDialog(null, "Username and password do not match!");
                    }
            }
        });
    }
}