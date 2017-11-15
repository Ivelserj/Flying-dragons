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
    static Texture dragonTexture;
    float speed;
    int fireCounter;
    int hp;
    Circle hitArea;

    public Dragon() {
        dragonTexture = new Texture(pictureWithDragon);
        position = new Vector2(100, 328);
        speed = 10.0f;
        fireCounter = 0;
        hp = dragonHit;
        hitArea = new Circle(position, ((int)(pictureWithDragonSize/2)));
    }

    public void takeDamage() {
        hp--;
        if (hp == 0) {
            gameOver();
        }
    }

    public void render(SpriteBatch batch) {
        batch.draw(dragonTexture, position.x, position.y);
    }

    public void update() {
        if (dragonIsLive){
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
            if (Gdx.input.isKeyPressed(Input.Keys.F)) {
                fireCounter++;
                if (fireCounter >= dragonFireRate) {
                    fireCounter = 0;
                    fire();
                }
            }
            if (Gdx.input.isTouched()) {
                if (position.x + ((int) (pictureWithDragonSize / 2)) > Gdx.input.getX()) {
                    position.x -= speed;
                }
                if (position.x + ((int) (pictureWithDragonSize / 2)) < Gdx.input.getX()) {
                    position.x += speed;
                }
                if (position.y + ((int) (pictureWithDragonSize / 2)) > screenWidth - Gdx.input.getY()) {
                    position.y -= speed;
                }
                if (position.y + ((int) (pictureWithDragonSize / 2)) < screenWidth - Gdx.input.getY()) {
                    position.y += speed;
                }
            }
            if (position.x < 0) {
                position.x = 0;
            }
            if (position.x > (screenWidth - pictureWithDragonSize)) {
                position.x = (screenWidth - pictureWithDragonSize);
            }
            if (position.y > screenHight) {
                position.y = -((int) (pictureWithDragonSize / 2));
            }
            if (position.y < -((int) (pictureWithDragonSize / 2))) {
                position.y = screenHight;
            }
        }
    }

        public void fire() {
            for (int i = 0; i < amountOfFire; i++) {
                if (!MyFisrtGame.fires[i].active) {
                    MyFisrtGame.fires[i].activate(position.x + ((int)((pictureWithDragonSize))), position.y + ((int)(pictureWithDragonSize/2)));
                    break;
                }
            }
    }
}

