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
import projectzombie.utils.Maths;
import projectzombie.game.Game;
import projectzombie.motor.ImageManager;
import projectzombie.motor.Window;
import projectzombie.utils.Animation;

/**
 *
 * @author repli
 */
public class Character extends GameObject {

    private ChrPhys fisicas;

    public Character(Rectangle colisionBox, Rectangle postionBox, byte estadoObjecto) {
        /*
        *   POSIBLES ESTADOS DE PERSONAJE(V2):
        *
        *   -static FRONT   -> 0    agrupados en 1
        *   -static LB      -> 4    agrupados en 2
        *   -static LEFT    -> 8    agrupados en 3
        *   -static LT      -> 12   agrupados en 4
        *   -static BACK    -> 16   agrupados en 5
        *   -static RT      -> 20   agrupados en 6
        *   -static RIGHT   -> 24   agrupados en 7
        *   -static RB      -> 28   agrupados en 8
        *
        *
        *
        *   -moving FRONT   -> 32   agrupados en 10
        *   -moving LB      -> 36   agrupados en 20
        *   -moving LEFT    -> 40   agrupados en 30
        *   -moving LT      -> 44   agrupados en 40
        *   -moving BACK    -> 48   agrupados en 50
        *   -moving RT      -> 52   agrupados en 60
        *   -moving RIGHT   -> 56   agrupados en 70
        *   -moving RB      -> 60   agrupados en 80
        
        //animaciones hasta pos 64-1
        *.........................
         */

        super(colisionBox, postionBox, estadoObjecto);
        this.hasColision = 1;
        fisicas = new ChrPhys();
        fisicas.velX = 0;
        fisicas.velY = 0;

    }
    private static final int pasoUpdate = (10 * Window.resize);

    private byte actualFrame = 0;
    private byte actualGroup = 1;

    private boolean transicio = false;

    /*
        Este metodo se lanza para cambiar de frame, tiene que valer tanto para
        estatico como para caminando.
     */
    private void nextFrame() {

        /*  Cuando se llege al anterior del siguiente
            fragmento de animación(transicio = true)
         */
        if (!transicio) {//no hay transición
            if ((actualFrame - 3) % 4 == 0) {//proximo frame toca reset al estadoObjeto
                actualFrame = (byte) Animation.nuevoFrameEstatico(actualFrame, baseFrame);
            } else {
                actualFrame = (byte) Animation.nuevoFrameEstatico(actualFrame);
            }
        } else {//toca transicion, se pasa al nuevo estadoObjeto
            actualFrame = (byte) Animation.nuevoFrameEstatico(actualFrame, baseFrame);
            transicio = false;
        }
    }

    public void update(short input) {

        if ((0b1000000000000000 & input) == 0b1000000000000000) {

            switch ((0b0000000000001111 & input)) {

                //Se mueve Izquierda
                case 0b1101:
                case 0b1:
                    fisicas.velX = (byte) -pasoUpdate;
                    fisicas.velY = 0;
                    if (actualGroup != 30) {
                        transicio = true;
                        actualFrame = 40;
                        actualGroup = 30;
                        baseFrame = 40;

                    }
                    break;

                //Se mueve Derecha    
                case 0b1110:
                case 0b10:
                    fisicas.velX = (byte) pasoUpdate;
                    fisicas.velY = 0;
                    if (actualGroup != 70) {
                        transicio = true;
                        actualFrame = 56;
                        actualGroup = 70;
                        baseFrame = 56;

                    }
                    break;

                //Se mueve Up    
                case 0b111:
                case 0b100:
                    fisicas.velY = (byte) (-pasoUpdate + 2);
                    fisicas.velX = 0;
                    if (actualGroup != 50) {
                        transicio = true;
                        actualFrame = 48;
                        actualGroup = 50;
                        baseFrame = 48;
                    }
                    break;

                //Se mueve Down    
                case 0b1011:
                case 0b1000:
                    fisicas.velY = (byte) pasoUpdate;
                    fisicas.velX = 0;
                    if (actualGroup != 10) {
                        transicio = true;
                        actualFrame = 32;
                        actualGroup = 10;
                        baseFrame = 32;

                    }
                    break;

                //Se mueve en Izquierda - Up    
                case 0b101:
                    fisicas.velY = (byte) (-pasoUpdate + 2);
                    fisicas.velX = (byte) ((byte)-pasoUpdate + 2);
                    if (actualGroup != 40) {
                        transicio = true;
                        actualFrame = 44;
                        actualGroup = 40;
                        baseFrame = 44;

                    }
                    break;

                //Se mueve en Izquierda - Down
                case 0b1001:
                    fisicas.velY = (byte) (pasoUpdate - 1);
                    fisicas.velX = (byte) (-pasoUpdate + 1);
                    if (actualGroup != 20) {
                        transicio = true;
                        actualFrame = 36;
                        actualGroup = 20;
                        baseFrame = 36;

                    }
                    break;

                //Se mueve en Derecha - Up    
                case 0b110:
                    fisicas.velY = (byte) (-pasoUpdate+2);
                    fisicas.velX = (byte) ((byte)+pasoUpdate-2);
                    if (actualGroup != 60) {
                        transicio = true;
                        actualFrame = 52;
                        actualGroup = 60;
                        baseFrame = 52;

                    }
                    break;

                //Se mueve en Derecha - Down    
                case 0b1010:
                    fisicas.velY = (byte) (+pasoUpdate-1);
                    fisicas.velX = (byte) (+pasoUpdate-1);
                    if (actualGroup != 80) {
                        transicio = true;
                        actualFrame = 60;
                        actualGroup = 80;
                        baseFrame = 60;

                    }
                    break;

                //No se Mueve nada    
                case 0b11:
                case 0b1100:
                case 0b1111:
                case 0:
                    //Frenado
                    if (fisicas.velX == 0 && fisicas.velY == 0) {
                        switch (actualGroup) {
                            case 10:
                                transicio = true;
                                actualGroup = 1;
                                actualFrame = 0;
                                baseFrame = 0;
                                break;
                            case 20:
                                transicio = true;
                                actualGroup = 2;
                                actualFrame = 4;
                                baseFrame = 4;

                                break;
                            case 30:
                                transicio = true;
                                actualGroup = 3;
                                actualFrame = 8;
                                baseFrame = 8;

                                break;
                            case 40:
                                transicio = true;
                                actualGroup = 4;
                                actualFrame = 12;
                                baseFrame = 12;

                                break;
                            case 50:
                                transicio = true;
                                actualGroup = 1;
                                actualFrame = 16;
                                baseFrame = 16;

                                break;
                            case 60:
                                transicio = true;
                                actualGroup = 2;
                                actualFrame = 20;
                                baseFrame = 20;

                                break;
                            case 70:
                                transicio = true;
                                actualGroup = 3;
                                actualFrame = 24;
                                baseFrame = 24;

                                break;
                            case 80:
                                transicio = true;
                                actualGroup = 4;
                                actualFrame = 28;
                                baseFrame = 28;

                                break;

                        }
                    }
//                    if (actualGroup == 1) {
//                        transicio = true;
//                        actualFrame = 0;
//                    }

                    fisicas.velX = Maths.normalize(fisicas.velX);
                    fisicas.velY = Maths.normalize(fisicas.velY);
                    break;
            }
            setLocation(this.positionBox.x += fisicas.velX, this.positionBox.y += fisicas.velY);
        } else {
            baseFrame = 0;
        }
    }

    /*
    private void drawingTest(Graphics gc) {

        gc.setColor(Color.CYAN);
        gc.fillRect(0, 0, 10, 10);

        gc.setColor(Color.ORANGE);
        gc.drawString(String.format("%016d", new BigInteger(Integer.toBinaryString(input))), 10, 10);
    }
     */
    //int pos = 0;
    @Override
    public void render() {
        if (ImageManager.allImages != null) {

            if (Game.contextoGrafico != null) {
                Game.contextoGrafico.drawImage(ImageManager.allImages[actualFrame], positionBox.x, positionBox.y, null);
                nextFrame();
            }
        }
    }

    @Override
    public void renderTest(Graphics gc) {
        gc.setColor(Color.BLUE);
        //drawingTest(gc);
        gc.fillRect(positionBox.x, positionBox.y, positionBox.width, positionBox.height);
        if (baseFrame == 0 || baseFrame == 16 || baseFrame == 20) //left
        {
            gc.fillPolygon(
                    new int[]{
                        positionBox.x - 16,
                        positionBox.x - 32,
                        positionBox.x - 16
                    },
                    new int[]{
                        positionBox.y,
                        positionBox.y + 32,
                        positionBox.y + 64
                    },
                    3);
        }

        if (baseFrame == 4 || baseFrame == 24 || baseFrame == 28) //right
        {
            gc.fillPolygon(
                    new int[]{
                        positionBox.x + 80,
                        positionBox.x + 96,
                        positionBox.x + 80
                    },
                    new int[]{
                        positionBox.y,
                        positionBox.y + 32,
                        positionBox.y + 64
                    },
                    3);
        }

        if (baseFrame == 8 || baseFrame == 16 || baseFrame == 24) //top
        {
            gc.fillPolygon(
                    new int[]{
                        positionBox.x,
                        positionBox.x + 32,
                        positionBox.x + 64
                    },
                    new int[]{
                        positionBox.y - 16,
                        positionBox.y - 32,
                        positionBox.y - 16
                    },
                    3);
        }

        if (baseFrame == 12 || baseFrame == 20 || baseFrame == 28) //down
        {
            gc.fillPolygon(
                    new int[]{
                        positionBox.x,
                        positionBox.x + 32,
                        positionBox.x + 64
                    },
                    new int[]{
                        positionBox.y + 80,
                        positionBox.y + 96,
                        positionBox.y + 80
                    },
                    3);
        }
    }

}
