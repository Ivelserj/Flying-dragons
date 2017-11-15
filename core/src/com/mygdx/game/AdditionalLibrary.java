package com.mygdx.game;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Ivelserj on 08.11.2017.
 */

public class AdditionalLibrary {

    public static String gameName = "FLYING DRAGONS";
    // game screen size
    public static int screenHight = 720;
    public static int screenWidth = 1280;
    // description of the dragon
    static String pictureWithDragon = "toothless.png";
    static int pictureWithDragonSize = 250;
    static int dragonRangeOfFire = 300;
    static int dragonFireRate = 5;
    static int dragonHit = 5;
    // description of the clouds
    static String pictureWithCloud = "cloud.png";
    static int pictureWithCloudSize = 157;
    static int amountOfCloud = 20;
    // description of the fire
    static String pictureWithFire = "fire.png";
    static int pictureWithFireSize = 70;
    static int amountOfFire = 30;
    // description of the bat
    static String pictureWithBat = "bat.png";
    static int pictureWithBatSize = 100;
    static int amountOfBat = 10;
    // description of the witch
    static String pictureWithWitch = "witch.png";
    static int pictureWithWitchwitchSize = 100;
    static int amountOfWitch = 10;
    // parametr for death of dragon
    static boolean dragonIsLive = true;
    static boolean createClouds = true;
    static boolean createBats = true;
    static String pictureWithDefeatedDragon = "defeatedToothless.png";
    static String pictureGameOver = "gameOver.jpg";

    public static Object createObjects(Object[] object, int amountOfObject, String className) {
        for (int i = 0; i < amountOfObject; i++) {
            if (className.equals("Cloud")) object[i] = new Cloud();
            if (className.equals("Fire")) object[i] = new Fire();
            if (className.equals("Bat")) object[i] = new Bat();
        }
        return object;
    }

    public static void gameOver() {
        Background.backgroundTexture = new Texture(pictureGameOver);
        Dragon.dragonTexture = new Texture(pictureWithDefeatedDragon);
        dragonIsLive = false;
        createClouds = false;
        createBats = false;
    }
}
