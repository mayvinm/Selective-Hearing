import javax.swing.*;
import java.awt.*;
/**
 * Write a description of class loginScreen here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class loginScreen extends JPanel{
    private JFrame frame = new JFrame("Log In");
    private JPanel panel = new JPanel(new GridLayout(4, 3));
    private JLabel text = new JLabel("Success");
    public loginScreen(){
        setLayout(new BorderLayout());
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(text);
        frame.setSize(300, 400);
        frame.setVisible(true);
    }
}
