/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectzombie.game;

import java.awt.Rectangle;
import projectzombie.motor.Window;

/**
 *
 * @author saulc
 */
public class Camara {
    public static int offsetX = 0;
    public static int offsetY = 0;
    private static Rectangle focus = null;
    
    public static void setFocus(Rectangle rect){
        focus = rect;
    }
    
    public static void actualOffset() {
        offsetX = focus.x + (focus.width >> 1) - (Window.screen_width >> 1);
        offsetY = focus.y + (focus.height >> 1) - (Window.screen_height >> 1);
    }
    
}
