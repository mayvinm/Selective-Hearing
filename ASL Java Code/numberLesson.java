import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Started by Cameron on March 23rd
 */
public class numberLesson{
    private JFrame frame = new JFrame("Numbers Lesson");
    private JPanel panel = new JPanel();
    private JPanel newPanel = new JPanel();
    private JLabel text = new JLabel("What number is this?");
    private JButton contButton = new JButton("Continue");
    
    public numberLesson(){
        panel.setLayout(new FlowLayout(2));
        newPanel.setLayout(new BorderLayout());
        contButton.setPreferredSize( new Dimension(75, 45));
        
        contButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                frame.dispose();
                //new Lesson();
            }
        });
        
        panel.add(text);
        panel.add(numbers());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(panel);
        frame.add(contButton, BorderLayout.SOUTH);
        frame.setSize(300, 400);
        frame.setVisible(true);
    }
    
    public Component numbers(){//five spaces between A and B
        JLabel test = new JLabel("\nA. 12     B. 3\nC. 5     D. 20");
        return test;
    }
}
