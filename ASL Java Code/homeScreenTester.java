import java.awt.Graphics;
import java.awt.Image;
import javax.swing.*;
/**
 * Started by Cameron
 */
public class homeScreenTester{
    public static void main(String[] args){
        //Image picture = new ImageIcon("/Desktop/ASL/ASL_Logo.png").getImage();
        JFrame frame = new JFrame("ASL - American Sign Language");
        //JImageComponent image = new JImageComponent(
        //System.out.print(picture);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new homeScreen());
        frame.pack();
        frame.setVisible(true);
    }
}