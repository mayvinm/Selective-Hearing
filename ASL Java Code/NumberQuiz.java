import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Started by Cameron on March 23rd
 * Edited by Cameron on April 1st, April 3rd, April 16th - 20th 
 */
public class NumberQuiz{
    private JFrame frame = new JFrame("Numbers Quiz");
    private JPanel panel = new JPanel();
    //br tag put the second part of the message on a new line, center tag centers the text, font tag increases font size, html tag required
    private JLabel message = new JLabel("<html><font size='5'><center>Welcome to the Numbers Quiz! Answer the questions on the following pages." + 
        "<br/>You will have 1 minute to complete each question. Click 'Submit and Check' once your answers are inputted." + 
        "<br/>The system will tell you if your answer is correct or not then move you to the next question. If you don't finish the fifth question " +
        "<br/>in time, you will have to restart the quiz. When you are ready, click 'Start'." +
        "<br/>Click 'Quit' if you want to go back to the Quiz page at anytime, but your current question will not be saved.</center></font></html>");
    private JButton startButton = new JButton("<html><font size='5'>Start</font></html>");
    private JButton quitButton = new JButton("<html><font size='5'>Quit</font></html>");
    public NumberQuiz(){
        frame();
        //disposes the frame and opens the quiz class
        quitButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                frame.dispose();
                new Quiz();
            }
        });
        //when clicked, disposes current frame and opens the first question class
        startButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                frame.dispose();
                new NumQuestionOne();
            }
        });
    }
    
    private void frame(){
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(65, 131, 126));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(5, 0, 5, 0);
        
        panel.add(message, gbc);
        
        JPanel buttons = new JPanel(new GridBagLayout());
        buttons.setBackground(new Color(65, 131, 126));
        buttons.add(startButton, gbc);
        buttons.add(quitButton, gbc);

        gbc.weighty = 1;
        panel.add(buttons, gbc);
        
        //JScrollPane scrPanel = new JScrollPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
