import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class WelcomePanel extends JPanel implements ActionListener {

    private JButton submitButton;
    private JButton clearButton;
    private JFrame enclosingFrame;
    private BufferedImage img;
    private int a;

    public WelcomePanel(JFrame frame) {
        enclosingFrame = frame;
        /*try {
            goomba = ImageIO.read(new File("src/goomba.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        */
        submitButton = new JButton("Submit");
        clearButton = new JButton("Clear");
          // textField doesn't need a listener since nothing needs to happen when we type in text
        add(submitButton);
        add(clearButton);
        submitButton.addActionListener(this);
        clearButton.addActionListener(this);
        a = 0;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        a++;
        //https://stackoverflow.com/questions/10083913/how-to-rotate-text-with-graphics2d-in-java
        Graphics2D g2 = (Graphics2D) g;
        Font font = new Font("Elephant", Font.BOLD, 100);
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.rotate(Math.toRadians(a), 50, 200);
        Font rotatedFont = font.deriveFont(affineTransform);
        g2.setFont(rotatedFont);
        g2.drawString("Dating Simulator",50,200);
        g2.dispose();
    }

    // ACTIONLISTENER INTERFACE METHODS
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            if (button == submitButton) {
                MainFrame f = new MainFrame();
                enclosingFrame.setVisible(false);
            }
        }
    }
}
