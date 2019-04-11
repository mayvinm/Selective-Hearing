import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
/**
 * Started by Cameron on March 5th
 * Edited by Cameron on April 1st
 */
public class loginScreen{
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    private JFrame frame = new JFrame("Log In");
    private JPanel panel = new JPanel();
    private JLabel username = new JLabel("Username: ");
    private JLabel password = new JLabel("Password: ");
    private JButton submit = new JButton("Submit");
    private JTextField userInput = new JTextField(10);
    private JTextField passInput = new JTextField(10); 
    public loginScreen(){
        connect();
        frame();
    }
    
    public void connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/asl", "root", "");
            stmt = conn.createStatement();
            //conn.close();
        }catch(Exception e){
            System.out.println(e);
        }
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
                try{
                    String user = userInput.getText().trim();
                    String pass = passInput.getText().trim();
                    String sql = "Select username, password From login Where username = '" + user + "'and password = '" + pass + "'";
                    rs = stmt.executeQuery(sql);
                    int count = 0;
                    while(rs.next()){
                        count = count + 1;
                
                    }
                    
                    if (count == 1){
                        JOptionPane.showMessageDialog(null, "User Found, Access Granted");
                        frame.dispose();
                        new Lesson();
                    }else if(count > 1){
                        JOptionPane.showMessageDialog(null, "Duplicate User, Access Denied");
                    }else{
                        JOptionPane.showMessageDialog(null, "User not Found!");
                    }
                }catch(Exception e){
                    
                }
            }
        });
    }
}
