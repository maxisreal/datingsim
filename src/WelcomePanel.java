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

    public WelcomePanel(JFrame frame) {
        enclosingFrame = frame;
        try {
            img = ImageIO.read(new File("src/background.jpg"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        submitButton = new JButton("Play!");
        submitButton.setFont(new Font("Arial", Font.PLAIN, 40));
        submitButton.setForeground(Color.BLUE);
        submitButton.setBackground(new Color(216, 190, 216));
          // textField doesn't need a listener since nothing needs to happen when we type in text
        add(submitButton);
        submitButton.addActionListener(this);
        submitButton.setPreferredSize(new Dimension(150, 50));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img,0, 0, null);
        //https://stackoverflow.com/questions/10083913/how-to-rotate-text-with-graphics2d-in-java
        Graphics2D g2 = (Graphics2D) g;
        Font font = new Font("Elephant", Font.BOLD, 100);
        g2.setColor(Color.BLUE);
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.rotate(Math.toRadians(10), 50, 300);
        Font rotatedFont = font.deriveFont(affineTransform);
        g2.setFont(rotatedFont);
        g2.drawString("Dater: a very bad dating sim",50,200);
        submitButton.setLocation(1000, 500);
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
