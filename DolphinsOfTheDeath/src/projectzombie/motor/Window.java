/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectzombie.motor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author saulc
 */
public class Window extends JFrame {

    public static short input = (short) 0b1000000000000000;
    
    private JPanel canvas;
    public static Graphics gc;

    public static int screen_width = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    public static int screen_height = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    public static double resize;

    public final static int target_width = 1920;
    public final static int target_height = 1080;

    private Image buffer = null;

    public static void main(String[] args) {
        try {
            new Window().setVisible(true);
            System.setProperty("sun.java2d.opengl", "true");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Window() {
        addKeyListener(new MyKeyListener());
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
        System.setProperty("sun.java2d.opengl", "true");

        this.setTitle("ZombieProject");
        this.canvas = new JPanel();
        setBackground(Color.yellow);
        setContentPane(this.canvas);
        setUndecorated(true);
        resize = ((double)screen_width) / target_width;
        setSize(Toolkit.getDefaultToolkit().getScreenSize());

        System.out.println("VENTANA MOSTRADA");

        //buffer = createImage(SCREEN_WIDTH,SCREEN_HEIGHT);
    }

    @Override
    public void update(Graphics g) {
        paint(g);
        //actualizar();
    }

    public void actualizar() {
        //this.canvas.getGraphics()
        if (buffer == null) {
            buffer = createImage(screen_width, screen_height);
            gc = buffer.getGraphics();
        } else {
            this.canvas.getGraphics().drawImage(buffer, 0, 0, null);
            gc.clearRect(0, 0, screen_width, screen_height);
        }
    }
    
    
    // repaint
    @Override
    public void paint(Graphics g) {
        if (buffer == null) {
            buffer = createImage(screen_width, screen_height);
            gc = buffer.getGraphics();
        } else {
            g.drawImage(buffer, 0, 0, null);
            gc.clearRect(0, 0, screen_width, screen_height);
        }
    }

    public Graphics graphicsContext() {
        
        return gc;
    }

    public class MyKeyListener extends WindowAdapter implements KeyListener {

        @Override
        public void keyTyped(KeyEvent ke) {
            
        }

        @Override
        public void keyPressed(KeyEvent ke) {
            
            if(ke.getKeyCode() == KeyEvent.VK_ESCAPE){
                System.exit(0);
            }
            
            switch (ke.getKeyCode()) {
                case KeyEvent.VK_A://posicion 0 input
                    if ((input & 0b1) == 0) {
                        ++input;
                    }
                    break;
                case KeyEvent.VK_D://posicion 2 input
                    if ((input & 0b10) == 0) {
                        input += 2;
                    }
                    break;
                case KeyEvent.VK_W://posicion 3
                    if ((input & 0b100) == 0) {
                        input += 4;
                    }
                    break;
                case KeyEvent.VK_S://posicion 4
                    if ((input & 0b1000) == 0) {
                        input += 8;
                    }
                    break;
                case KeyEvent.VK_SPACE://posicion 5
                    if ((input & 0b10000) == 0) {
                        input += 16;
                    }
                    break;
            }
        }

        @Override
        public void keyReleased(KeyEvent ke) {
            switch (ke.getKeyCode()) {
                case KeyEvent.VK_A://posicion 0 input
                    --input;
                    break;
                case KeyEvent.VK_D://posicion 2 input
                    input -= 2;
                    break;
                case KeyEvent.VK_W://posicion 3
                    input -= 4;
                    break;
                case KeyEvent.VK_S://posicion 4
                    input -= 8;
                    break;
                case KeyEvent.VK_SPACE:
                    input -= 16;
                    break;
            }
        }
    }
}
