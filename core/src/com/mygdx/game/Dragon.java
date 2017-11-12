package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

import static com.mygdx.game.AdditionalLibrary.*;

/**
 * Created by Ivelserj on 05.11.2017.
 */

public class Dragon {
    Vector2 position;
    Texture texture;
    float speed;
    int fireRate;
    int fireCounter;
    int hp;
    Circle hitArea;

    public Dragon() {
        texture = new Texture(pictureWithDragon);
        position = new Vector2(100, 328);
        speed = 10.0f;
        fireRate = 4;
        fireCounter = 0;
        hp = dragonHit;
        hitArea = new Circle(position, ((int)(dragonSize/2)));
    }

    public void takeDamage() {
        hp--;
        if (hp <= 0) {
            gameOver();
        }
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, position.x, position.y);
    }

    public void update() {
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            position.x -= speed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            position.x += speed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            position.y -= speed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            position.y += speed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.L)) {
            fireCounter++;
            if (fireCounter >= fireRate) {
                fireCounter = 0;
                 fire();
            }
        }
        if (Gdx.input.isTouched()) {
            if (position.x + ((int) (dragonSize / 2)) > Gdx.input.getX()) {
                position.x -= speed;
            }
            if (position.x + ((int) (dragonSize / 2)) < Gdx.input.getX()) {
                position.x += speed;
            }
            if (position.y + ((int) (dragonSize / 2)) > screenWidth - Gdx.input.getY()) {
                position.y -= speed;
            }
            if (position.y + ((int) (dragonSize / 2)) < screenWidth - Gdx.input.getY()) {
                position.y += speed;
            }
        }
        if (position.x < 0) {
            position.x = 0;
        }
        if (position.x > (screenWidth - dragonSize)) {
            position.x = (screenWidth - dragonSize);
        }
        if (position.y > screenHight) {
            position.y = -((int) (dragonSize / 2));
        }
        if (position.y < -((int) (dragonSize / 2))) {
            position.y = screenHight;
        }
    }

        public void fire() {
            for (int i = 0; i < amountOfFire; i++) {
                if (!MyFisrtGame.fires[i].active) {
                    MyFisrtGame.fires[i].activate(position.x + ((int)((dragonSize/3)*2)), position.y + ((int)(dragonSize/2)));
                    break;
                }
            }
    }
}

