import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GraphicsPanel extends JPanel {
    private BufferedImage background;
    private BufferedImage demo;
    private ArrayList<String> list;
    private boolean[] pressedKeys;
    private int num;

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
        num = 0;
        pressedKeys = new boolean[128];
        list = new ArrayList<String>();
        list.add("there's only one beer left");
        list.add("hghahghahusgasjgasgs");
        list.add("test");
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

        g.setColor(Color.BLACK);
        g.setFont(new Font("Yu Gothic UI", Font.BOLD, 100));
        g.drawString(list.get(num), 50, 850);
    }
    public void toggle(){
        num++;
        if (num >= list.size()){
            num = 0;
        }
    }
    // ----- KeyListener interface methods -----
    public void keyTyped(KeyEvent e) { } // unimplemented

    public void keyPressed(KeyEvent e) {
        // see this for all keycodes: https://stackoverflow.com/questions/15313469/java-keyboard-keycodes-list
        // A = 65, D = 68, S = 83, W = 87, left = 37, up = 38, right = 39, down = 40, space = 32, enter = 10
        int key = e.getKeyCode();
        pressedKeys[key] = true;
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        pressedKeys[key] = false;
    }

    // ----- MouseListener interface methods -----
    public void mouseClicked(MouseEvent e) { }  // unimplemented; if you move your mouse while clicking,
    // this method isn't called, so mouseReleased is best

    public void mousePressed(MouseEvent e) { } // unimplemented

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) { } // unimplemented

    public void mouseExited(MouseEvent e) { } // unimplemented

    // ACTIONLISTENER INTERFACE METHODS: used for buttons AND timers!
    public void actionPerformed(ActionEvent e) {

    }

}
