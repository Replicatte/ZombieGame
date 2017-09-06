/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectzombie.gameobjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import projectzombie.fisicas.ChrPhys;
import projectzombie.game.Camara;
import projectzombie.game.Game;
import projectzombie.motor.ImageManager;
import projectzombie.motor.Window;

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

    public Zombie(Rectangle colisionBox, Rectangle postionBox, byte estadoObjecto) {
        super(colisionBox, postionBox, estadoObjecto);
        this.hasColision = 1;
        fisicas = new ChrPhys();
        fisicas.velX = 4;
        fisicas.velY = 4;

    }

    @Override
    public void render() {
        Game.contextoGrafico.drawImage(ImageManager.allImages[actualFrame], positionBox.x - Camara.offsetX,
                    positionBox.y - Camara.offsetY, null);
    }
    
    
    @Override
    public void renderTest(Graphics gc) {
        gc.setColor(Color.GREEN);
        gc.fillRect(this.positionBox.x - Camara.offsetX, this.positionBox.y - Camara.offsetY, this.positionBox.width, this.positionBox.height);
    }
    
    int modX = 1;
    int modY = 1;

    @Override
    public void update(double interval) {

        if (positionBox.x > Window.screen_width - 64) {
            modX = -1;
        } else if (positionBox.x < 0) {
            modX = 1;
        }
        
        if (positionBox.y > Window.screen_height - 64) {
            modY = -1;
        } else if (positionBox.y < 0) {
            modY = 1;
        }
        
        //Provisional
        if(modX > 0) {
            if(modY > 0){
                actualFrame = 60;
            } else {
                actualFrame = 52;
            }
        } else {
            if(modY > 0) {
                actualFrame = 36;  
            } else {
                actualFrame = 44;
            }  
        }
        
        positionBox.x = positionBox.x + (fisicas.velX * modX);
        positionBox.y = positionBox.y + (fisicas.velY * modY);
        
        
        this.setLocation(positionBox.x, positionBox.y);
    }
}
