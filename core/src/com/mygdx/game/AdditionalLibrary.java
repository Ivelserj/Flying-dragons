package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class AdditionalLibrary {
    // game screen size
    public static String gameName = "Dragon riders";
    // game screen size
    public static int screenHight = 720;
    public static int screenWidth = 1280;
    // description of the dragon
    static String pictureWithDragon = "toothless.png";
    static int dragonSize = 290;
    static int rangOfFire = 100;
    static int dragonHit = 5;
    // description of the clouds
    static String pictureWithCloud = "cloud.png";
    static int cloudSize = 157;
    static int amountOfCloud = 20;
    // description of the fire
    static String pictureWithFire = "fire.png";
    static int fireSize = 70;
    static int amountOfFire = 30;
    // description of the bat
    static String pictureWithBat = "witch.png";
    static int batSize = 100;
    static int amountOfBat = 10;

    SpriteBatch batch;

    public static Object createObjects(Object[] object, int amountOfObject, String className) {
        for (int i = 0; i < amountOfObject; i++) {
            if (className.equals("Cloud")) object[i] = new Cloud();
            if (className.equals("Fire")) object[i] = new Fire();
            if (className.equals("Bat")) object[i] = new Bat();
        }
        return object;
    }
    public static int gameOver(){
        dragonSize = 0;
        return dragonSize;
    }

}
