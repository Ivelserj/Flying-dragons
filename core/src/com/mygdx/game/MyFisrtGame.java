package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import static com.mygdx.game.AdditionalLibrary.*;

/**
 * Created by Ivelserj on 05.11.2017.
 */

public class MyFisrtGame extends ApplicationAdapter {
	SpriteBatch batch;
	Background background;
	Cloud[] clouds;
	Bat[] bats;
	Dragon dragon;
	static Fire[] fires;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		background = new Background();

		clouds = new Cloud[amountOfCloud];
        clouds = (Cloud[]) createObjects(clouds, amountOfCloud, "Cloud");

		dragon = new Dragon();

		bats = new Bat[amountOfBat];
        bats = (Bat[]) createObjects(bats, amountOfBat, "Bat");

		fires = new Fire[amountOfFire];
        fires = (Fire[]) createObjects(fires, amountOfFire, "Fire");
	}

	@Override
	public void render() {
		update();
		batch.begin();
		background.render(batch);
		for (int i = 0; i < amountOfCloud; i++) {
			clouds[i].render(batch);
		}
		dragon.render(batch);
		for (int i = 0; i < amountOfBat; i++) {
			bats[i].render(batch);
		}
		for (int i = 0; i < amountOfFire; i++) {
			if (fires[i].active) {
				fires[i].render(batch);
			}
		}
		batch.end();
		}

	public void update() {
		for (int i = 0; i < amountOfCloud; i++) {
			clouds[i].update();
		}
		dragon.update();

		// hit on bat
		for (int i = 0; i < amountOfBat; i++) {
			bats[i].update();
		}
		for (int i = 0; i < amountOfFire; i++) {
			if (fires[i].active) {
				fires[i].update();
				for (int j = 0; j < amountOfBat; j++) {
					if (bats[j].hitArea.contains(fires[i].position)) {
						bats[j].takeDamage();
						fires[i].deactivate();
						break;
					}
				}
			}
		}
		// hit on dragon
//		for (int i = 0; i < amountOfBat; i++) {
//			bats[i].update();
//			if (bats[i].hitArea.contains(dragon.position)) {
//				dragon.takeDamage();
//				bats[i].recreate();
//				break;
//			}
//		}
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		background.dispose();
	}
}
