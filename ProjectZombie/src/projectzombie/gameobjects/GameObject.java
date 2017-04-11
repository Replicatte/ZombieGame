/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectzombie.gameobjects;

import java.awt.Rectangle;
import java.util.ArrayList;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

/**
 *
 * @author repli
 */
public class GameObject {

    protected byte hasColision;
    protected Rectangle colisionBox;
    protected Rectangle positionBox;

    protected byte estadoObjeto;

    public GameObject(Rectangle colisionBox, Rectangle postionBox, byte estadoObjecto) {
        this.colisionBox = colisionBox;
        this.positionBox = postionBox;
        this.estadoObjeto = estadoObjecto;
        this.hasColision = 0;
    }

    public void render(GraphicsContext gc) {
        //gc.drawImage(,positionBox.x,positionBox.y);
    }

    public void renderTest(GraphicsContext gc) {
//       if(gc != null){ //tarda más en sacar el condicional
        gc.setFill(Color.RED);
        gc.fillRect(this.positionBox.getX(), this.positionBox.getY(), 64, 64);
//       }
    }
    
    public void update(ArrayList<Byte> input){
        
    }
    
    public void update(){
        
    }
    public void update(short input){
        
    }
    
    public void update(double interval){
        
    }

    public void setLocation(int x, int y) {
        this.positionBox.setLocation(x, y);
    }

    public void setXLocation(int x) {
        this.positionBox.setLocation(x, this.positionBox.y);
    }

}
