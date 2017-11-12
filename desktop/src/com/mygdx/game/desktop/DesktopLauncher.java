package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import static com.mygdx.game.AdditionalLibrary.*;
import com.mygdx.game.MyFisrtGame;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class DesktopLauncher {

	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = gameName;
		config.width = screenWidth;
		config.height = screenHight;
		new LwjglApplication(new MyFisrtGame(), config);
	}
}
