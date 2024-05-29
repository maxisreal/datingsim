import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GraphicsPanel extends JPanel {
    private BufferedImage background;
    private BufferedImage demo;

    public GraphicsPanel() {
        try {
            background = ImageIO.read(new File("src/ddlcbg.jpg"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try {
            demo = ImageIO.read(new File("src/demo.png"));
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
        //top frame side
        g.fillRect(1260, 15+35, 580, 70);
        //left frame side
        g.fillRect(1260, 15+35, 70, 575);
        //right frame side
        g.fillRect(1885-45-70, 15+35, 70, 575);
        //bottom frame side
        g.fillRect(1260, 660-70-30, 580, 70);
        //middle;
        g.fillRect(1200+60+70, 15+35+70, 400, 400);

        g.setColor(new Color(216, 190, 216));
        //top frame side
        g.fillRect(1220, 15, 665, 35);
        //bottom frame side
        g.fillRect(1220, 660-35, 665, 35);
        //left frame side
        g.fillRect(1220, 15, 40, 645);
        //right frame side
        g.fillRect(1885-45, 15, 45, 645);
        g.setColor(new Color(216, 190, 216));
        //left frame side
        g.fillRect(1200+60+70,15+35+70, 100, 440);
        //top frame side
        g.fillRect(1200+60+70,15+35+70, 440, 100);
        //bottom frame side
        g.fillRect(1200+60+70, 660-70-30-70-30, 440, 100);
        //right frame side
        g.fillRect(1885-45-70-100, 15+35+70, 100, 440);

        g.drawImage(demo, 1200+60+50, 15+35+40, null);
    }
}
