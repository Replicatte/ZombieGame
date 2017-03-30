/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectzombie.gameobjects;

import java.awt.Rectangle;
import java.util.ArrayList;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import projectzombie.Fisicas.ChrPhys;
import projectzombie.Utils.Maths;
import projectzombie.game.GameInit;

/**
 *
 * @author repli
 */
public class Zombie extends Enemie {
//     byte hasColision;
//     Rectangle colisionBox;
//     Rectangle positionBox;
//    
//     byte estadoObjecto;
    
    private ChrPhys fisicas;
    double value;
    public Zombie(Rectangle colisionBox, Rectangle postionBox, byte estadoObjecto) {
        super(colisionBox, postionBox, estadoObjecto);
        this.hasColision = 1;
        fisicas = new ChrPhys();
        fisicas.velX = 1;
        fisicas.velY = 1;
        value = postionBox.x;
    }

    @Override
    public void renderTest(GraphicsContext gc) {
        gc.setFill(Color.GREEN);
        gc.fillRect(this.positionBox.getX(), this.positionBox.getY(), this.positionBox.getWidth(), this.positionBox.getHeight());
    }
   int mod = 1;
    @Override
    public void update(double interval) {
        
            //Soles compte amb el postion.x de moment
            //value ==> positionBox.x en double
            value += (fisicas.velX * interval) * mod;
            positionBox.x = Math.round(Math.round(value));
            if(value > 1000){
                System.out.println("OutOfBorders");
                mod = -1;
            }else if(value<0){
                mod = 1;
            }
            this.setXLocation(positionBox.x);
        
    }
}
