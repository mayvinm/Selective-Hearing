import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AlphaLessonFreeTrial{
    private JFrame frame = new JFrame("Alphabet Lesson");
    private JPanel panel = new JPanel();
    private JLabel message = new JLabel("<html><font size='5'><center>Welcome to the free trial! Learn all the letters of the Alphabet.<br/>" +
        "Click the button at the bottom when you are done.</font></center></html>");
    private JLabel a = new JLabel("<html><font size='6'>A</font></html>");
    private JLabel b = new JLabel("<html><font size='6'>B</font></html>");
    private JLabel c = new JLabel("<html><font size='6'>C</font></html>");
    private JLabel d = new JLabel("<html><font size='6'>D</font></html>");
    private JLabel e = new JLabel("<html><font size='6'>E</font></html>");
    private JLabel f = new JLabel("<html><font size='6'>F</font></html>");
    private JLabel g = new JLabel("<html><font size='6'>G</font></html>");
    private JLabel h = new JLabel("<html><font size='6'>H</font></html>");
    private JLabel i = new JLabel("<html><font size='6'>I</font></html>");
    private JLabel j = new JLabel("<html><font size='6'>J</font></html>");
    private JLabel k = new JLabel("<html><font size='6'>K</font></html>");
    private JLabel l = new JLabel("<html><font size='6'>L</font></html>");
    private JLabel m = new JLabel("<html><font size='6'>M</font></html>");
    private JLabel n = new JLabel("<html><font size='6'>N</font></html>");
    private JLabel o = new JLabel("<html><font size='6'>O</font></html>");
    private JLabel p = new JLabel("<html><font size='6'>P</font></html>");
    private JLabel q = new JLabel("<html><font size='6'>Q</font></html>");
    private JLabel r = new JLabel("<html><font size='6'>R</font></html>");
    private JLabel s = new JLabel("<html><font size='6'>S</font></html>");
    private JLabel t = new JLabel("<html><font size='6'>T</font></html>");
    private JLabel u = new JLabel("<html><font size='6'>U</font></html>");
    private JLabel v = new JLabel("<html><font size='6'>V</font></html>");
    private JLabel w = new JLabel("<html><font size='6'>W</font></html>");
    private JLabel x = new JLabel("<html><font size='6'>X</font></html>");
    private JLabel y = new JLabel("<html><font size='6'>Y</font></html>");
    private JLabel z = new JLabel("<html><font size='6'>Z</font></html>");
    private JButton endButton = new JButton("<html><font size='5'>Done</font></html>");
    public AlphaLessonFreeTrial(){
        panel.setLayout(new GridBagLayout());       
        panel.setBackground(new Color(65, 131, 126));
        endButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                JOptionPane.showMessageDialog(null, "You have completed your free trial!");
                frame.dispose();
                new RegisterScreen();
            }
        });
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(5, 0, 5, 0);
        
        panel.add(message, gbc);
        panel.add(new JLabel(new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/Alphabet/a.jpg")), gbc);
        panel.add(a, gbc);
        panel.add(new JLabel(new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/Alphabet/b.jpg")), gbc);
        panel.add(b, gbc);
        panel.add(new JLabel(new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/Alphabet/c.jpg")), gbc);
        panel.add(c, gbc);
        panel.add(new JLabel(new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/Alphabet/d.jpg")), gbc);
        panel.add(d, gbc);
        panel.add(new JLabel(new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/Alphabet/e.jpg")), gbc);
        panel.add(e, gbc);
        panel.add(new JLabel(new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/Alphabet/f.jpg")), gbc);
        panel.add(f, gbc);
        panel.add(new JLabel(new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/Alphabet/g.jpg")), gbc);
        panel.add(g, gbc);
        panel.add(new JLabel(new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/Alphabet/h.jpg")), gbc);
        panel.add(h, gbc);
        panel.add(new JLabel(new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/Alphabet/i.jpg")), gbc);
        panel.add(i, gbc);
        panel.add(new JLabel(new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/Alphabet/j.jpg")), gbc);
        panel.add(j, gbc);
        panel.add(new JLabel(new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/Alphabet/k.jpg")), gbc);
        panel.add(k, gbc);
        panel.add(new JLabel(new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/Alphabet/l.jpg")), gbc);
        panel.add(l, gbc);
        panel.add(new JLabel(new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/Alphabet/m.jpg")), gbc);
        panel.add(m, gbc);
        panel.add(new JLabel(new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/Alphabet/n.jpg")), gbc);
        panel.add(n, gbc);
        panel.add(new JLabel(new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/Alphabet/o.jpg")), gbc);
        panel.add(o, gbc);
        panel.add(new JLabel(new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/Alphabet/p.jpg")), gbc);
        panel.add(p, gbc);
        panel.add(new JLabel(new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/Alphabet/q.jpg")), gbc);
        panel.add(q, gbc);
        panel.add(new JLabel(new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/Alphabet/r.jpg")), gbc);
        panel.add(r, gbc);
        panel.add(new JLabel(new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/Alphabet/s.jpg")), gbc);
        panel.add(s, gbc);
        panel.add(new JLabel(new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/Alphabet/t.jpg")), gbc);
        panel.add(t, gbc);
        panel.add(new JLabel(new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/Alphabet/u.jpg")), gbc);
        panel.add(u, gbc);
        panel.add(new JLabel(new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/Alphabet/v.jpg")), gbc);
        panel.add(v, gbc);
        panel.add(new JLabel(new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/Alphabet/w.jpg")), gbc);
        panel.add(w, gbc);
        panel.add(new JLabel(new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/Alphabet/x.jpg")), gbc);
        panel.add(x, gbc);
        panel.add(new JLabel(new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/Alphabet/y.jpg")), gbc);
        panel.add(y, gbc);
        panel.add(new JLabel(new ImageIcon("C:/Users/cam36/Desktop/CSCI 401/ASL/Pictures/Alphabet/z.jpg")), gbc);
        panel.add(z, gbc);
        panel.add(endButton, gbc);
        
        JScrollPane scrPanel = new JScrollPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setContentPane(scrPanel);
        frame.pack();
        frame.setVisible(true);
    }
}
