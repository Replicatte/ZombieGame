/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectzombie.motor;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import projectzombie.game.GameInit;
import static projectzombie.game.GameInit.gcReady;

/**
 *
 * @author saulc
 */

public class Window extends JFrame{

    public static short input;
    
    public static Graphics gc;

    public static final int SCREEN_WIDTH = 1280;
    public static final int SCREEN_HEIGHT = 720;

    
    private Image buffer;
    private Graphics ctx;
    
    
    public static void main(String[] args) {
        input = (short)0b1000000000000000;
        try{
            new Window().setVisible(true);
            System.setProperty("sun.java2d.opengl", "true");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public Window(){
        
        addKeyListener(new MyKeyListener());
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        } );
        
        
        this.setTitle("ZombieProject");
        JPanel root = new JPanel();
        

        setContentPane(root);
        setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        
        System.out.println("VENTANA MOSTRADA");
        gcReady = true;
       
       
    }
    
    @Override
    public void update(Graphics g) {
        paint(g);
    }
    // repaint
    @Override 
    public void paint (Graphics g) {        
        g.drawImage(buffer, 0, 0, null);  
        buffer = createImage(SCREEN_WIDTH,SCREEN_HEIGHT);
        ctx = buffer.getGraphics();
        gc = ctx;
    }
    
    
    private void drawing(Graphics gc) {
        gc.setColor(Color.BLACK);
        gc.fillRect(0, 0, 100, 100);
        
        
        GameInit.darConextoGrafico(gc);
    }
    
    public Graphics graphicsContext(){
        return gc;
    }
    
    
    
    public class MyKeyListener extends WindowAdapter implements KeyListener {
        
        @Override
        public void keyTyped(KeyEvent ke) {


        }

        @Override
        public void keyPressed(KeyEvent ke) {
            switch(ke.getExtendedKeyCode()){
                case KeyEvent.VK_A://posicion 0 input
                    if((input & 0b1)== 0){
                        ++input;
                    }
                    break;
                case KeyEvent.VK_D://posicion 2 input
                    if((input & 0b10) == 0){
                        input += 2;
                    }
                    break;
                case KeyEvent.VK_W://posicion 3
                    if((input & 0b100) == 0){
                        input += 4;
                    }
                    break;
                case KeyEvent.VK_S://posicion 4
                    if((input & 0b1000) == 0){
                        input += 8;
                    }
                    break;
            }
        }

        @Override
        public void keyReleased(KeyEvent ke) {
            switch(ke.getKeyCode()){
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
            }
        }  
    } 
}
