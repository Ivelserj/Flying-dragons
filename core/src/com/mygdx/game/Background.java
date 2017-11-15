package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Ivelserj on 05.11.2017.
 */

public class Background {
    static Texture backgroundTexture;

    public Background() {
        backgroundTexture = new Texture("sky.jpg");
    }

    public void render(SpriteBatch batch) {
        batch.draw(backgroundTexture, 0, 0);
    }

    public void dispose() {
        backgroundTexture.dispose();
    }
}