import javax.swing.*;
import java.awt.*;
/**
 * Started by Cameron on March 5th
 */
public class loginScreen{
    private JFrame frame = new JFrame("Log In");
    private JPanel panel = new JPanel(new GridLayout(4, 3));
    private JLabel text = new JLabel("Success");
    public loginScreen(){
        panel.setLayout(new BorderLayout());
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(text);
        frame.setSize(300, 400);
        frame.setVisible(true);
    }
}
