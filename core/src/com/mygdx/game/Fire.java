package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import static com.mygdx.game.AdditionalLibrary.*;

/**
 * Created by Ivelserj on 05.11.2017.
 */

public class Fire {

    Vector2 position;
    float speed;
    boolean active;
    Texture texture;

    public Fire() {
        texture = new Texture(pictureWithFire);
        active = false;
        position = new Vector2(0, 0);
        speed = 16.0f;
    }

    public void deactivate() {

        active = false;
    }

    public void activate(float x, float y) {
        active = true;
        position.set(x, y);
    }
    public void render(SpriteBatch batch) {
        batch.draw(texture, position.x - ((int) (fireSize/2)), position.y - ((int)(fireSize/2)));
    }

    public void update() {
        position.x += speed;
        if (position.x > screenWidth) {
            deactivate();
        }
    }
}
