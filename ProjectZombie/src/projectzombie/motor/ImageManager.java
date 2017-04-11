/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectzombie.motor;

import javafx.scene.image.Image;

/**
 * Almacena imagenes y las pasa junto al constructor de los GameObjects para un
 * posterior render según el estado de objeto del juego :)
 *
 * @author Jesucristo de la programación
 */
public class ImageManager {

    //Deberiamos extender de algún tipo de EDA? y posteriormente pasarlo a algún
    // tipo de array de imagenes? 
    public static Image[] allImages;

    private final static int IMG_RESIZE = 2;
    private final static int IMG_SIZE = 64 * IMG_RESIZE;

    private final static int NUM_IMAGENES = 128;

    public static void generateImages() {
        allImages = new Image[NUM_IMAGENES];

        //FRONT
        allImages[0] = new Image("recursos/prototipo/00_STATICS/FRONT_STAY/0000.png", IMG_SIZE, IMG_SIZE, true, false);
        allImages[1] = new Image("recursos/prototipo/00_STATICS/FRONT_STAY/0010.png", IMG_SIZE, IMG_SIZE, true, false);
        allImages[2] = new Image("recursos/prototipo/00_STATICS/FRONT_STAY/0020.png", IMG_SIZE, IMG_SIZE, true, false);
        allImages[3] = new Image("recursos/prototipo/00_STATICS/FRONT_STAY/0030.png", IMG_SIZE, IMG_SIZE, true, false);

        //LEFT-BOTTOM
        allImages[4] = new Image("recursos/prototipo/00_STATICS/LB_STAY/0000.png", IMG_SIZE, IMG_SIZE, true, false);
        allImages[5] = new Image("recursos/prototipo/00_STATICS/LB_STAY/0010.png", IMG_SIZE, IMG_SIZE, true, false);
        allImages[6] = new Image("recursos/prototipo/00_STATICS/LB_STAY/0020.png", IMG_SIZE, IMG_SIZE, true, false);
        allImages[7] = new Image("recursos/prototipo/00_STATICS/LB_STAY/0030.png", IMG_SIZE, IMG_SIZE, true, false);

        //LEFT
        allImages[8] = new Image("recursos/prototipo/00_STATICS/LEFT_STAY/0000.png", IMG_SIZE, IMG_SIZE, true, false);
        allImages[9] = new Image("recursos/prototipo/00_STATICS/LEFT_STAY/0010.png", IMG_SIZE, IMG_SIZE, true, false);
        allImages[10] = new Image("recursos/prototipo/00_STATICS/LEFT_STAY/0020.png", IMG_SIZE, IMG_SIZE, true, false);
        allImages[11] = new Image("recursos/prototipo/00_STATICS/LEFT_STAY/0030.png", IMG_SIZE, IMG_SIZE, true, false);

        //LEFT-TOP
        allImages[12] = new Image("recursos/prototipo/00_STATICS/LT_STAY/0000.png", IMG_SIZE, IMG_SIZE, true, false);
        allImages[13] = new Image("recursos/prototipo/00_STATICS/LT_STAY/0010.png", IMG_SIZE, IMG_SIZE, true, false);
        allImages[14] = new Image("recursos/prototipo/00_STATICS/LT_STAY/0020.png", IMG_SIZE, IMG_SIZE, true, false);
        allImages[15] = new Image("recursos/prototipo/00_STATICS/LT_STAY/0030.png", IMG_SIZE, IMG_SIZE, true, false);

        //BACK
        allImages[16] = new Image("recursos/prototipo/00_STATICS/BACK_STAY/0000.png", IMG_SIZE, IMG_SIZE, true, false);
        allImages[17] = new Image("recursos/prototipo/00_STATICS/BACK_STAY/0010.png", IMG_SIZE, IMG_SIZE, true, false);
        allImages[18] = new Image("recursos/prototipo/00_STATICS/BACK_STAY/0020.png", IMG_SIZE, IMG_SIZE, true, false);
        allImages[19] = new Image("recursos/prototipo/00_STATICS/BACK_STAY/0030.png", IMG_SIZE, IMG_SIZE, true, false);

        //RIGHT-TOP
        allImages[20] = new Image("recursos/prototipo/00_STATICS/RT_STAY/0000.png", IMG_SIZE, IMG_SIZE, true, false);
        allImages[21] = new Image("recursos/prototipo/00_STATICS/RT_STAY/0010.png", IMG_SIZE, IMG_SIZE, true, false);
        allImages[22] = new Image("recursos/prototipo/00_STATICS/RT_STAY/0020.png", IMG_SIZE, IMG_SIZE, true, false);
        allImages[23] = new Image("recursos/prototipo/00_STATICS/RT_STAY/0030.png", IMG_SIZE, IMG_SIZE, true, false);

        //RIGHT
        allImages[24] = new Image("recursos/prototipo/00_STATICS/RIGHT_STAY/0000.png", IMG_SIZE, IMG_SIZE, true, false);
        allImages[25] = new Image("recursos/prototipo/00_STATICS/RIGHT_STAY/0010.png", IMG_SIZE, IMG_SIZE, true, false);
        allImages[26] = new Image("recursos/prototipo/00_STATICS/RIGHT_STAY/0020.png", IMG_SIZE, IMG_SIZE, true, false);
        allImages[27] = new Image("recursos/prototipo/00_STATICS/RIGHT_STAY/0030.png", IMG_SIZE, IMG_SIZE, true, false);

        //RIGHT-BOTTOM
        allImages[28] = new Image("recursos/prototipo/00_STATICS/RB_STAY/0000.png", IMG_SIZE, IMG_SIZE, true, false);
        allImages[29] = new Image("recursos/prototipo/00_STATICS/RB_STAY/0010.png", IMG_SIZE, IMG_SIZE, true, false);
        allImages[30] = new Image("recursos/prototipo/00_STATICS/RB_STAY/0020.png", IMG_SIZE, IMG_SIZE, true, false);
        allImages[31] = new Image("recursos/prototipo/00_STATICS/RB_STAY/0030.png", IMG_SIZE, IMG_SIZE, true, false);

    }

}
