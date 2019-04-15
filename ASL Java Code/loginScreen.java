import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
/**
 * Started by Cameron on March 5th
 * Edited by Cameron on April 1st
 */
public class loginScreen{
    private DatabaseConnection loginHandler;
    private JFrame frame = new JFrame("Log In");
    private JPanel panel = new JPanel();
    private JLabel username = new JLabel("Username: ");
    private JLabel password = new JLabel("Password: ");
    private JButton submit = new JButton("Submit");
    private JTextField userInput = new JTextField(10);
    private JPasswordField passInput = new JPasswordField(10); 
    public loginScreen(){
    	loginHandler = new DatabaseConnection();
        frame();
    }
    
    public void frame(){
    	panel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;

        panel.add(username, gbc);
        panel.add(userInput, gbc);
        panel.add(password, gbc);
        panel.add(passInput, gbc);
        
        JPanel buttons = new JPanel(new GridBagLayout());
        buttons.add(submit, gbc);

        gbc.weighty = 1;
        panel.add(buttons, gbc);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        frame.setVisible(true);
        frame.setContentPane(panel);
        
        submit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                    String user = userInput.getText().trim();
                    String pass = passInput.getText().trim();
                    if(loginHandler.login(user, pass)) {
                    	new Lesson();
                    	frame.dispose();
                    }else {
                    	JOptionPane.showMessageDialog(null, "User name and password do not match!");
                    }
              
            }
        });
    }
}
