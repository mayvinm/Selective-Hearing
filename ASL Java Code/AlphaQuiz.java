import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AlphaQuiz{
    private JFrame frame = new JFrame("Alphabet Quiz");
    private JPanel panel = new JPanel();
    //br tag put the second part of the message on a new line, center tag centers the text, font tag increases font size, html tag required
    private JLabel message = new JLabel("<html><font size='5'><center>Welcome to the Alphabet Quiz! Select the name of the food/fruit shown." + 
        "<br/><center>You will have 1 minute to complete each question. Click 'Submit and Check' once your answers are inputted." + 
        "<br/>The system will tell you if your answer is correct or not then move you to the next question. When you are ready, click 'Start'." +
        "<br/>Click 'Quit' if you want to go back to the Quiz page at anytime, but your current question will not be saved.</center></font></html>");
    private JButton startButton = new JButton("<html><font size='5'>Start</font></html>");
    private JButton quitButton = new JButton("<html><font size='5'>Quit</font></html>");
    public AlphaQuiz(){
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
                new AlphaQuestionOne();
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
