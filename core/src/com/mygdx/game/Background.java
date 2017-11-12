package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Ivelserj on 05.11.2017.
 */

public class Background {
    Texture texture;

    public Background() {
        texture = new Texture("sky.jpg");
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, 0, 0);
    }

    public void dispose() {
        texture.dispose();
    }
}