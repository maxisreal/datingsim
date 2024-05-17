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
        clearButton = new JButton("Clear");
          // textField doesn't need a listener since nothing needs to happen when we type in text
        add(submitButton);
        add(clearButton);
        submitButton.addActionListener(this);
        clearButton.addActionListener(this);
        submitButton.setLocation(200, 200);
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
        affineTransform.rotate(Math.toRadians(20), 50, 300);
        Font rotatedFont = font.deriveFont(affineTransform);
        g2.setFont(rotatedFont);
        g2.drawString("placeholder text",50,200);
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
