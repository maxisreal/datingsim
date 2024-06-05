import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GraphicsPanel extends JPanel {
    private BufferedImage background;
    private BufferedImage demoface;
    private BufferedImage demo;
    private ArrayList<String> list;
    private int num;
    private Scanner scan;

    public GraphicsPanel() {
        try {
            background = ImageIO.read(new File("src/ddlcbg.jpg"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try {
            demoface = ImageIO.read(new File("src/demo.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        Scanner scan = new Scanner(System.in);
        num = 0;
        ArrayList<BufferedImage> dance = new ArrayList<>();
        for (int i = 0; i <= 24; i++) {
            String filename;
            if (i<10) {
                filename = "src/conga/frame_0" + i + "_delay-0.1s.gif";
            } else {
                filename = "src/conga/frame_" + i + "_delay-0.1s.gif";
            }
            try {
                dance.add(ImageIO.read(new File(filename)));
            }
            catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        demo = new Animation(dance, 66).getActiveFrame();
        list = new ArrayList<String>();
        loadWordsInto(list);
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

        g.drawImage(demoface, 1200+60+50, 15+35+40, null);
        g.drawImage(demo, 100, 100, null);

        g.setColor(Color.BLACK);
        g.setFont(new Font("Letter Gothic", Font.BOLD, 90));
        int a = 800;
        for (String line : list.get(num).split("\n")) {
           g.drawString(line, 30, a);
           a += 100;
        }
    }
    public void toggle(){
        num++;
        if (num >= list.size()){
            num = 0;
        }
    }
    private static void loadWordsInto(ArrayList<String> list) {
        try {
            Scanner input = new Scanner(new File("src\\onebeer.txt"));
            while (input.hasNext()) {
                String str = input.nextLine();
                int justright = 41;
                if (str.length() > justright) {
                    if (str.substring(0, 1).equals("\"")) {
                        list.add(str.substring(0, str.substring(0, justright-1).lastIndexOf(" ")) + "\n" + str.substring(str.substring(0, justright-1).lastIndexOf(" ")));
                    } else {
                        list.add(str.substring(0, str.substring(0, justright-1).lastIndexOf(" ")) + "\n" + str.substring(str.substring(0, justright-1).lastIndexOf(" ") + 1));
                    }
                } else {
                    list.add(str);
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
