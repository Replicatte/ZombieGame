/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectzombie.gameobjects;

import java.awt.Rectangle;
import java.math.BigInteger;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import projectzombie.Fisicas.ChrPhys;
import projectzombie.Utils.Maths;
import projectzombie.motor.Animation;
import projectzombie.motor.ImageManager;
import static projectzombie.motor.Window.input;

/**
 *
 * @author repli
 */
public class Character extends GameObject {

    private ChrPhys fisicas;

    public Character(Rectangle colisionBox, Rectangle postionBox, byte estadoObjecto) {
        /*
        *   POSIBLES ESTADOS DE PERSONAJE:
        *
        *   -static izq ->0
        *   -static der ->4
        *   -static top ->8
        *   -static down ->12
        
        *   -static izqtop ->16
        *   -static izqdown ->20
        *   -static dertop ->24
        *   -static derdown ->28
        *
        *
        *
        *   -moving izq1 ->1
        *   -moving izq2 ->2
        *   -moving izq3 ->3
        *   .........................
         */

        super(colisionBox, postionBox, estadoObjecto);
        this.hasColision = 1;
        fisicas = new ChrPhys();
        fisicas.velX = 0;
        fisicas.velY = 0;

    }
    private static final int pasoUpdate = 8;

    public void update(short input) {
        if ((0b1000000000000000 & input) == 0b1000000000000000) {

            switch ((0b0000000000001111 & input)) {

                //Se mueve Izquierda
                case 0b1101:
                case 0b1:
                    fisicas.velX = -pasoUpdate;
                    fisicas.velY = 0;
                    estadoObjeto = 0;
                    break;

                //Se mueve Derecha    
                case 0b1110:
                case 0b10:
                    fisicas.velX = pasoUpdate;
                    fisicas.velY = 0;
                    estadoObjeto = 4;
                    break;

                //Se mueve Up    
                case 0b111:
                case 0b100:
                    fisicas.velY = -pasoUpdate;
                    fisicas.velX = 0;
                    estadoObjeto = 8;
                    break;

                //Se mueve Down    
                case 0b1011:
                case 0b1000:
                    fisicas.velY = pasoUpdate;
                    fisicas.velX = 0;
                    estadoObjeto = 12;
                    break;

                //Se mueve en Izquierda - Up    
                case 0b101:
                    fisicas.velY = -pasoUpdate;
                    fisicas.velX = -pasoUpdate;
                    estadoObjeto = 16;
                    break;

                //Se mueve en Izquierda - Down
                case 0b1001:
                    fisicas.velY = pasoUpdate;
                    fisicas.velX = -pasoUpdate;
                    if (estadoObjeto < 20 || estadoObjeto > 23) {
                        estadoObjeto = 24;
                    } else {
                        estadoObjeto++;
                    }
                    break;

                //Se mueve en Derecha - Up    
                case 0b110:
                    fisicas.velY = -pasoUpdate;
                    fisicas.velX = +pasoUpdate;
                    if (estadoObjeto < 24 || estadoObjeto > 27) {
                        estadoObjeto = 24;
                    } else {
                        estadoObjeto++;
                    }
                    break;

                //Se mueve en Derecha - Down    
                case 0b1010:
                    fisicas.velY = +pasoUpdate;
                    fisicas.velX = +pasoUpdate;
                    estadoObjeto = 28;
                    break;

                //No se Mueve nada    
                case 0b11:
                case 0b1100:
                case 0b1111:
                case 0:
                    fisicas.velX = Maths.normalize(fisicas.velX);
                    fisicas.velY = Maths.normalize(fisicas.velY);
                    break;
            }
            setLocation(this.positionBox.x += fisicas.velX, this.positionBox.y += fisicas.velY);
        }
    }

    private void drawingTest(GraphicsContext gc) {

        gc.setFill(Color.AQUA);
        gc.fillRect(0, 0, 10, 10);

        gc.setFill(Color.DARKORANGE);
        gc.fillText(String.format("%016d", new BigInteger(Integer.toBinaryString(input))), 10, 10);
    }

    int pos = 0;

    @Override
    public void render(GraphicsContext gc) {
        if (ImageManager.allImages != null) {
//            switch (estadoObjeto) {
//                case ()
//            }
            if (pos > 2) {
                pos = 0;
            } else {
                pos = Animation.nuevoEstadoChar(pos);
            }
            gc.drawImage(ImageManager.allImages[pos], positionBox.x, positionBox.y);
        }
    }

    @Override
    public void renderTest(GraphicsContext gc) {
        gc.setFill(Color.BLUE);
        //drawingTest(gc);
        gc.fillRect(positionBox.getX(), positionBox.getY(), positionBox.getWidth(), positionBox.getHeight());
        if (estadoObjeto == 0 || estadoObjeto == 16 || estadoObjeto == 20) //left
        {
            gc.fillPolygon(
                    new double[]{
                        positionBox.getX() - 16,
                        positionBox.getX() - 32,
                        positionBox.getX() - 16
                    },
                    new double[]{
                        positionBox.getY(),
                        positionBox.getY() + 32,
                        positionBox.getY() + 64
                    },
                    3);
        }

        if (estadoObjeto == 4 || estadoObjeto == 24 || estadoObjeto == 28) //right
        {
            gc.fillPolygon(
                    new double[]{
                        positionBox.getX() + 80,
                        positionBox.getX() + 96,
                        positionBox.getX() + 80
                    },
                    new double[]{
                        positionBox.getY(),
                        positionBox.getY() + 32,
                        positionBox.getY() + 64
                    },
                    3);
        }

        if (estadoObjeto == 8 || estadoObjeto == 16 || estadoObjeto == 24) //top
        {
            gc.fillPolygon(
                    new double[]{
                        positionBox.getX(),
                        positionBox.getX() + 32,
                        positionBox.getX() + 64
                    },
                    new double[]{
                        positionBox.getY() - 16,
                        positionBox.getY() - 32,
                        positionBox.getY() - 16
                    },
                    3);
        }

        if (estadoObjeto == 12 || estadoObjeto == 20 || estadoObjeto == 28) //down
        {
            gc.fillPolygon(
                    new double[]{
                        positionBox.getX(),
                        positionBox.getX() + 32,
                        positionBox.getX() + 64
                    },
                    new double[]{
                        positionBox.getY() + 80,
                        positionBox.getY() + 96,
                        positionBox.getY() + 80
                    },
                    3);
        }
    }

}
