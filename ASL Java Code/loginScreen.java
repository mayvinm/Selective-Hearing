import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Started by Cameron on March 5th
 */
public class loginScreen{
    private JFrame frame = new JFrame("Log In");
    private JPanel panel = new JPanel(new GridLayout(4, 3));
    private JLabel text = new JLabel("Success");
    private JButton submit = new JButton("Submit");
    private String input;
    public loginScreen(){
        panel.setLayout(new BorderLayout());
        
        
        submit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                frame.dispose();
                new Lesson();
            }
        });
        
        
        JTextField txtInput = new JTextField("");
        txtInput.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                input = txtInput.getText(); //receive input
                System.out.println(input);
            }
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(txtInput, BorderLayout.NORTH);
        frame.add(submit, BorderLayout.SOUTH);
        frame.setSize(300, 400);
        frame.setVisible(true);
    }
}

