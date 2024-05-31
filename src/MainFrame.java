import javax.swing.*;
import java.awt.event.KeyEvent;

public class MainFrame implements Runnable {
    private GraphicsPanel panel;
    private KeyHandler keys;

    public MainFrame() {
        JFrame frame = new JFrame("Intro to Animation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920, 1080);
        frame.setLocation(0, 0);

        // create and add panel
        panel = new GraphicsPanel();
        frame.add(panel);

        keys = new KeyHandler();
        frame.addKeyListener(keys);

        // display the frame
        frame.setVisible(true);

        // start thread, required for animation
        Thread thread = new Thread(this);
        thread.start();
    }

    // Runnable interface method
    public void run() {
        while (true) {
            panel.repaint();
            if (keys.isSpaceKeyReleased() || keys.isEnterKeyReleased()){
                panel.toggle();
            }
        }
    }
}
