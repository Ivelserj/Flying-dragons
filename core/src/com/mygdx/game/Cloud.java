package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import static com.mygdx.game.AdditionalLibrary.*;

/**
 * Created by Ivelserj on 05.11.2017.
 */

public class Cloud {
    static Texture texture;
    Vector2 position;
    float speed;
    float scale;
    float transparency;

    public Cloud() {
        texture = new Texture(pictureWithCloud);
        position = new Vector2((float) Math.random() * screenWidth + screenWidth, (float) Math.random() * screenHight);
        scale = 2.0f * (float) (Math.random() * pictureWithCloudSize);
        speed = 0.3f * (float) (Math.random() * (scale));
        transparency = (float) Math.random();
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, position.x , position.y , scale, scale);
    }

    public void recreate() {
        position.x = screenWidth + (float) Math.random() * screenWidth;
        position.y = (float) Math.random() * screenHight;
        scale = 1.0f * (float) (Math.random() * pictureWithCloudSize);
        speed = 0.3f * (float) (Math.random() * (scale));
    }

    public void update() {
        position.x -= speed;
        if (position.x < - (pictureWithCloudSize * 2)) {
            recreate();
        }
    }
}