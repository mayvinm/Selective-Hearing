import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Started by Cameron on March 5th
 * Completed by Ryan on 4/13
 */
public class RegisterScreen extends JPanel{
    private JFrame frame = new JFrame("Register");
    private JPanel masterPanel = new JPanel(new GridLayout(3, 1, 5, 30));
    private JPanel loginInfoPanel;
    private JPanel personalPanel; 
    private JButton submit = new JButton("Create Account");
    private JTextField firstName;
    private JTextField lastName;
    private JTextField emailAddress;
    private JTextField userName;
    private JPasswordField password;
    private String enteredUserName;
    private String enteredPassword;
    private String enteredFirstName;
    private String enteredLastName;
    private String enteredEmail;
    private String input;
    private DatabaseConnection registerHandler;
    public RegisterScreen(){
        //code to style submit button
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;
        JPanel button = new JPanel(new GridBagLayout());
        button.setBackground(new Color(65, 131, 126));
        button.add(submit, gbc);
        
        loginInfoPanel = createLoginInfoPanel();
        personalPanel = createPersonalInfoPanel();
        registerHandler = new DatabaseConnection();
        
        submit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                enteredUserName = userName.getText();
                enteredPassword = password.getText();
                enteredFirstName = firstName.getText();
                enteredLastName = lastName.getText();
                enteredEmail = emailAddress.getText();
                if(registerHandler.findAccount(enteredUserName)) {
                    JOptionPane.showMessageDialog(null, "Someone already chose this username. Be a little more original, will ya?", "Warning", JOptionPane.WARNING_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "You registered successfully!");
                    registerHandler.addAccount(new User(enteredFirstName, enteredLastName, enteredUserName, enteredEmail), enteredPassword);
                }
                frame.dispose();
                new LoginScreen();
            }
        });
        masterPanel.setBackground(new Color(65, 131, 126));
        masterPanel.add(loginInfoPanel);
        masterPanel.add(personalPanel);
        masterPanel.add(button);
        
        frame.add(masterPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.pack();
        frame.setVisible(true);
    }
    
    /*
     * Creates and populates the panel for the personal info section
     * of the registration screen. 
     */
    private JPanel createPersonalInfoPanel() {
        JPanel p = new JPanel(new GridBagLayout());
        p.setBackground(new Color(65, 131, 126));
        GridBagConstraints gbc = new GridBagConstraints();
        
        JLabel firstN = new JLabel("First Name");
        JLabel lastN = new JLabel("Last Name");
        JLabel email = new JLabel("Email Address");
        
        firstName = new JTextField(14);
        lastName = new JTextField(14);
        emailAddress = new JTextField(14);
        
        gbc.fill = GridBagConstraints.WEST;
        gbc.gridx = 0;
        gbc.gridy = 0;
        p.add(firstN, gbc);
        
        gbc.fill = GridBagConstraints.EAST;
        gbc.gridx = 1;
        gbc.gridy = 0;
        p.add(firstName, gbc);
        
        gbc.fill = GridBagConstraints.WEST;
        gbc.gridx = 0;
        gbc.gridy = 1;
        p.add(lastN, gbc);
        
        gbc.fill = GridBagConstraints.EAST;
        gbc.gridx = 1;
        gbc.gridy = 1;
        p.add(lastName, gbc);
        
        gbc.fill = GridBagConstraints.WEST;
        gbc.gridx = 0;
        gbc.gridy = 2;
        p.add(email, gbc);
        
        gbc.fill = GridBagConstraints.EAST;
        gbc.gridx = 1;
        gbc.gridy = 2;
        p.add(emailAddress, gbc);
        
        p.setBorder(BorderFactory.createTitledBorder("Personal Info"));
        
        return p;
    }
 
    /*
     * Creates and populates the panel for the login info section of the 
     * registration screen.
     */
    private JPanel createLoginInfoPanel() {
        JPanel p = new JPanel(new GridBagLayout());
        p.setBackground(new Color(65, 131, 126));
        GridBagConstraints gbc = new GridBagConstraints();
        JLabel uName = new JLabel("Username ");
        JLabel pWord = new JLabel("Password ");
        
        this.userName = new JTextField(10);
        this.password = new JPasswordField(10);
        
        gbc.fill = GridBagConstraints.WEST;
        gbc.gridx = 0;
        gbc.gridy = 0;
        p.add(uName, gbc);
        
        gbc.fill = GridBagConstraints.EAST;
        gbc.gridx = 1;
        gbc.gridy = 0;
        p.add(userName, gbc);
        
        gbc.fill = GridBagConstraints.WEST;
        gbc.gridx = 0;
        gbc.gridy = 1;
        p.add(pWord, gbc);
        
        gbc.fill = GridBagConstraints.EAST;
        gbc.gridx = 1;
        gbc.gridy = 1;
        p.add(password, gbc);
        
        p.setBorder(BorderFactory.createTitledBorder("Login Info"));
    
        return p;
    }
}