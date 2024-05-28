import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GraphicsPanel extends JPanel {
    private BufferedImage background;

    public GraphicsPanel() {
        try {
            background = ImageIO.read(new File("src/ddlcbg.jpg"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);  // just do this
        g.setColor(new Color(255,214,214));
        g.fillRect(0, 0, 1920, 1080);
        g.drawImage(background, 0, 0, null);
        g.setColor(Color.PINK);
        //top frame side
        g.fillRect(1200, 0 , 750, 15);
        //bottom frame side
        g.fillRect(1200, 660, 750, 15);
        //left frame side
        g.fillRect(1200, 0, 20, 660);
        //right frame side
        g.fillRect(1885, 0, 20, 660);
        g.setColor(new Color(216, 190, 216));
        g.fillRect(1220, 15, 665, 15);
    }
}
