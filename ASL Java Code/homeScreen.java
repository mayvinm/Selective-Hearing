import java.*;
import javax.swing.*; //JButton, Jlabel, Jpanel
//import java.awt.*;
import java.awt.event.*; //actionlistener
/**
 * Started by Cameron
 */
public class homeScreen{
    private JPanel keyPanel, clearpanel;
    private JLabel loginLabel, registerLabel;
    private String appTitle;
    public homeScreen(String s){
        this.appTitle = s;
    }
    public void loginButton(){
    }
    public void registerButton(){
    }
    private class KeyListener implements ActionListener{
        //-----------------------------------------------------------------
        // Appends the key value to the display.
        //-----------------------------------------------------------------
        public void actionPerformed(ActionEvent event){
            JButton source = (JButton)event.getSource();
            loginLabel.setText(loginLabel.getText() + source.getText());
        }
    } 
}
