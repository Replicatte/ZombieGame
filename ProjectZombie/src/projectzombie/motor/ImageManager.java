/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectzombie.motor;

import java.awt.Image;
import static java.awt.Image.SCALE_DEFAULT;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

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
        allImages[0] = loadImg("recursos/prototipo/00_STATICS/FRONT_STAY/0000.png", IMG_SIZE, IMG_SIZE, true, false);
        allImages[1] = loadImg("recursos/prototipo/00_STATICS/FRONT_STAY/0010.png", IMG_SIZE, IMG_SIZE, true, false);
        allImages[2] = loadImg("recursos/prototipo/00_STATICS/FRONT_STAY/0020.png", IMG_SIZE, IMG_SIZE, true, false);
        allImages[3] = loadImg("recursos/prototipo/00_STATICS/FRONT_STAY/0030.png", IMG_SIZE, IMG_SIZE, true, false);

        //LEFT-BOTTOM
        allImages[4] = loadImg("recursos/prototipo/00_STATICS/LB_STAY/0000.png", IMG_SIZE, IMG_SIZE, true, false);
        allImages[5] = loadImg("recursos/prototipo/00_STATICS/LB_STAY/0010.png", IMG_SIZE, IMG_SIZE, true, false);
        allImages[6] = loadImg("recursos/prototipo/00_STATICS/LB_STAY/0020.png", IMG_SIZE, IMG_SIZE, true, false);
        allImages[7] = loadImg("recursos/prototipo/00_STATICS/LB_STAY/0030.png", IMG_SIZE, IMG_SIZE, true, false);

        //LEFT
        allImages[8] = loadImg("recursos/prototipo/00_STATICS/LEFT_STAY/0000.png", IMG_SIZE, IMG_SIZE, true, false);
        allImages[9] = loadImg("recursos/prototipo/00_STATICS/LEFT_STAY/0010.png", IMG_SIZE, IMG_SIZE, true, false);
        allImages[10] = loadImg("recursos/prototipo/00_STATICS/LEFT_STAY/0020.png", IMG_SIZE, IMG_SIZE, true, false);
        allImages[11] = loadImg("recursos/prototipo/00_STATICS/LEFT_STAY/0030.png", IMG_SIZE, IMG_SIZE, true, false);

        //LEFT-TOP
        allImages[12] = loadImg("recursos/prototipo/00_STATICS/LT_STAY/0000.png", IMG_SIZE, IMG_SIZE, true, false);
        allImages[13] = loadImg("recursos/prototipo/00_STATICS/LT_STAY/0010.png", IMG_SIZE, IMG_SIZE, true, false);
        allImages[14] = loadImg("recursos/prototipo/00_STATICS/LT_STAY/0020.png", IMG_SIZE, IMG_SIZE, true, false);
        allImages[15] = loadImg("recursos/prototipo/00_STATICS/LT_STAY/0030.png", IMG_SIZE, IMG_SIZE, true, false);

        //BACK
        allImages[16] = loadImg("recursos/prototipo/00_STATICS/BACK_STAY/0000.png", IMG_SIZE, IMG_SIZE, true, false);
        allImages[17] = loadImg("recursos/prototipo/00_STATICS/BACK_STAY/0010.png", IMG_SIZE, IMG_SIZE, true, false);
        allImages[18] = loadImg("recursos/prototipo/00_STATICS/BACK_STAY/0020.png", IMG_SIZE, IMG_SIZE, true, false);
        allImages[19] = loadImg("recursos/prototipo/00_STATICS/BACK_STAY/0030.png", IMG_SIZE, IMG_SIZE, true, false);

        //RIGHT-TOP
        allImages[20] = loadImg("recursos/prototipo/00_STATICS/RT_STAY/0000.png", IMG_SIZE, IMG_SIZE, true, false);
        allImages[21] = loadImg("recursos/prototipo/00_STATICS/RT_STAY/0010.png", IMG_SIZE, IMG_SIZE, true, false);
        allImages[22] = loadImg("recursos/prototipo/00_STATICS/RT_STAY/0020.png", IMG_SIZE, IMG_SIZE, true, false);
        allImages[23] = loadImg("recursos/prototipo/00_STATICS/RT_STAY/0030.png", IMG_SIZE, IMG_SIZE, true, false);

        //RIGHT
        allImages[24] = loadImg("recursos/prototipo/00_STATICS/RIGHT_STAY/0000.png", IMG_SIZE, IMG_SIZE, true, false);
        allImages[25] = loadImg("recursos/prototipo/00_STATICS/RIGHT_STAY/0010.png", IMG_SIZE, IMG_SIZE, true, false);
        allImages[26] = loadImg("recursos/prototipo/00_STATICS/RIGHT_STAY/0020.png", IMG_SIZE, IMG_SIZE, true, false);
        allImages[27] = loadImg("recursos/prototipo/00_STATICS/RIGHT_STAY/0030.png", IMG_SIZE, IMG_SIZE, true, false);

        //RIGHT-BOTTOM
        allImages[28] = loadImg("recursos/prototipo/00_STATICS/RB_STAY/0000.png", IMG_SIZE, IMG_SIZE, true, false);
        allImages[29] = loadImg("recursos/prototipo/00_STATICS/RB_STAY/0010.png", IMG_SIZE, IMG_SIZE, true, false);
        allImages[30] = loadImg("recursos/prototipo/00_STATICS/RB_STAY/0020.png", IMG_SIZE, IMG_SIZE, true, false);
        allImages[31] = loadImg("recursos/prototipo/00_STATICS/RB_STAY/0030.png", IMG_SIZE, IMG_SIZE);

        //------------------------------WALKING---------------------------------
        
        
        //FRONT_WALKING
        allImages[32] = loadImg("recursos/prototipo/01_ANIMATIONS/FRONT_WALK/0000.png", IMG_SIZE, IMG_SIZE, true, false);
        allImages[33] = loadImg("recursos/prototipo/01_ANIMATIONS/FRONT_WALK/0010.png", IMG_SIZE, IMG_SIZE, true, false);
        allImages[34] = loadImg("recursos/prototipo/01_ANIMATIONS/FRONT_WALK/0020.png", IMG_SIZE, IMG_SIZE, true, false);
        allImages[35] = loadImg("recursos/prototipo/01_ANIMATIONS/FRONT_WALK/0030.png", IMG_SIZE, IMG_SIZE, true, false);

        //LB_WALKING
        allImages[36] = loadImg("recursos/prototipo/01_ANIMATIONS/LB_WALK/0000.png", IMG_SIZE, IMG_SIZE, true, false);
        allImages[37] = loadImg("recursos/prototipo/01_ANIMATIONS/LB_WALK/0010.png", IMG_SIZE, IMG_SIZE, true, false);
        allImages[38] = loadImg("recursos/prototipo/01_ANIMATIONS/LB_WALK/0020.png", IMG_SIZE, IMG_SIZE, true, false);
        allImages[39] = loadImg("recursos/prototipo/01_ANIMATIONS/LB_WALK/0030.png", IMG_SIZE, IMG_SIZE, true, false);

        //LEFT_WALKING
        allImages[40] = loadImg("recursos/prototipo/01_ANIMATIONS/LEFT_WALK/0000.png", IMG_SIZE, IMG_SIZE, true, false);
        allImages[41] = loadImg("recursos/prototipo/01_ANIMATIONS/LEFT_WALK/0010.png", IMG_SIZE, IMG_SIZE, true, false);
        allImages[42] = loadImg("recursos/prototipo/01_ANIMATIONS/LEFT_WALK/0020.png", IMG_SIZE, IMG_SIZE, true, false);
        allImages[43] = loadImg("recursos/prototipo/01_ANIMATIONS/LEFT_WALK/0030.png", IMG_SIZE, IMG_SIZE, true, false);

        //LT_WALKING
        allImages[44] = loadImg("recursos/prototipo/01_ANIMATIONS/LT_WALK/0000.png", IMG_SIZE, IMG_SIZE, true, false);
        allImages[45] = loadImg("recursos/prototipo/01_ANIMATIONS/LT_WALK/0010.png", IMG_SIZE, IMG_SIZE, true, false);
        allImages[46] = loadImg("recursos/prototipo/01_ANIMATIONS/LT_WALK/0020.png", IMG_SIZE, IMG_SIZE, true, false);
        allImages[47] = loadImg("recursos/prototipo/01_ANIMATIONS/LT_WALK/0030.png", IMG_SIZE, IMG_SIZE, true, false);

        //BACK_WALKING
        allImages[48] = loadImg("recursos/prototipo/01_ANIMATIONS/BACK_WALK/0000.png", IMG_SIZE, IMG_SIZE, true, false);
        allImages[49] = loadImg("recursos/prototipo/01_ANIMATIONS/BACK_WALK/0010.png", IMG_SIZE, IMG_SIZE, true, false);
        allImages[50] = loadImg("recursos/prototipo/01_ANIMATIONS/BACK_WALK/0020.png", IMG_SIZE, IMG_SIZE, true, false);
        allImages[51] = loadImg("recursos/prototipo/01_ANIMATIONS/BACK_WALK/0030.png", IMG_SIZE, IMG_SIZE, true, false);

        //RT_WALKING
        allImages[52] = loadImg("recursos/prototipo/01_ANIMATIONS/RT_WALK/0000.png", IMG_SIZE, IMG_SIZE, true, false);
        allImages[53] = loadImg("recursos/prototipo/01_ANIMATIONS/RT_WALK/0010.png", IMG_SIZE, IMG_SIZE, true, false);
        allImages[54] = loadImg("recursos/prototipo/01_ANIMATIONS/RT_WALK/0020.png", IMG_SIZE, IMG_SIZE, true, false);
        allImages[55] = loadImg("recursos/prototipo/01_ANIMATIONS/RT_WALK/0030.png", IMG_SIZE, IMG_SIZE, true, false);

        //RIGHT_WALKING
        allImages[56] = loadImg("recursos/prototipo/01_ANIMATIONS/RIGHT_WALK/0000.png", IMG_SIZE, IMG_SIZE, true, false);
        allImages[57] = loadImg("recursos/prototipo/01_ANIMATIONS/RIGHT_WALK/0010.png", IMG_SIZE, IMG_SIZE, true, false);
        allImages[58] = loadImg("recursos/prototipo/01_ANIMATIONS/RIGHT_WALK/0020.png", IMG_SIZE, IMG_SIZE, true, false);
        allImages[59] = loadImg("recursos/prototipo/01_ANIMATIONS/RIGHT_WALK/0030.png", IMG_SIZE, IMG_SIZE, true, false);

        //RB_WALKING
        allImages[60] = loadImg("recursos/prototipo/01_ANIMATIONS/RB_WALK/0000.png", IMG_SIZE, IMG_SIZE, true, false);
        allImages[61] = loadImg("recursos/prototipo/01_ANIMATIONS/RB_WALK/0010.png", IMG_SIZE, IMG_SIZE, true, false);
        allImages[62] = loadImg("recursos/prototipo/01_ANIMATIONS/RB_WALK/0020.png", IMG_SIZE, IMG_SIZE, true, false);
        allImages[63] = loadImg("recursos/prototipo/01_ANIMATIONS/RB_WALK/0030.png", IMG_SIZE, IMG_SIZE, true, false);
    }

    private static Image loadImg(String ruta, int width, int height) {
        try {
            Image aux = ImageIO.read(new File("src/./" + ruta).getCanonicalFile());
            return aux.getScaledInstance(width, height, SCALE_DEFAULT);
        } catch (IOException ex) {
            System.out.println("src/../" + ruta);
            Logger.getLogger(ImageManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private static Image loadImg(String ruta, int width, int height, boolean si, boolean no) {
        return loadImg(ruta, width, height);
    }

}
