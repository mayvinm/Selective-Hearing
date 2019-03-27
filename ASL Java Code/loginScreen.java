import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
/**
 * Started by Cameron on March 5th
 * Edited by Cameron on March 25th
 */
public class loginScreen{
    public Connection conn;
    public Statement stmt;
    public ResultSet rs;
    private JFrame frame = new JFrame("Log In");
    private JPanel panel = new JPanel();
    private JLabel username = new JLabel("Username: ");
    private JLabel password = new JLabel("Password: ");
    private JButton submit = new JButton("Submit");
    private JTextField userInput = new JTextField(10);
    private JTextField passInput = new JTextField(10);
    private String input;
    public loginScreen(){
        //panel.setLayout(new BorderLayout());
        connect();
        frame();
        
        
        
        // txtInput.addActionListener(new ActionListener(){
            // public void actionPerformed(ActionEvent event){
                // input = txtInput.getText(); //receive input
                // System.out.println(input);
            // }
        // });
        
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
        
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.add(txtInput, BorderLayout.NORTH);
        //frame.add(submit, BorderLayout.SOUTH);
        frame.setSize(300, 400);
        frame.setVisible(true);
        panel.add(username);
        panel.add(userInput);
        panel.add(password);
        panel.add(passInput);
        panel.add(submit);
        frame.add(panel);
        
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
                    //kjb
                }
                //frame.dispose();
                //new Lesson();
            }
        });
    }
}
