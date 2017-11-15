package com.mygdx.game;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

import static com.mygdx.game.AdditionalLibrary.*;

/**
 * Created by Ivelserj on 05.11.2017.
 */

public class Bat {
    static Texture texture;
    Vector2 position;
    float speed;
    float scale;
    int hp;
    int maxHp;
    Circle hitArea;

    public Bat() {
        if (texture == null) {
            texture = new Texture(pictureWithBat);
        }
        position = new Vector2((float) Math.random() * screenWidth + screenWidth, (float) Math.random() * screenHight);
        speed = 1.0f + (3 - maxHp);
        hp = maxHp;
        scale = 1.f;
//        scale = 1.f + (float) Math.random() * maxHp;
        hitArea = new Circle(position, ((int)(pictureWithBatSize/2)));
    }

    public void recreate() {
        position.x = screenWidth * 2;
        position.y = (float) Math.random() * (screenHight - (scale));
        speed = 1.0f + (3 - maxHp);
        scale = 1.f;
//        scale = 0.8f + 1.2f * (float) Math.random();
        maxHp = 1 + (int) (Math.random() * 2);
        hp = maxHp;
        scale = 1.f;
//        scale = 1.f + (float) Math.random() * maxHp;
        hitArea.radius = ((int)(pictureWithBatSize/2));
    }

    public void takeDamage() {
        hp--;
        if (hp <= 0) {
            recreate();
        }
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, position.x - ((int)(pictureWithBatSize/2)), position.y - ((int)(pictureWithBatSize/2)), ((int)(pictureWithBatSize/2)), ((int)(pictureWithBatSize/2)), pictureWithBatSize, pictureWithBatSize, scale, scale, 0, 0, 0, pictureWithBatSize, pictureWithBatSize, false, false);
    }

    public void update() {
        if (createClouds) {
            position.x -= speed;
            if (position.x < -300) {
                recreate();
            }
            hitArea.setPosition(position);
        }
    }
}
