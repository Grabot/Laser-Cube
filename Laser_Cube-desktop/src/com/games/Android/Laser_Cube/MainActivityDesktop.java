package com.games.Android.Laser_Cube;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class MainActivityDesktop {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "Laser_Cube";
		cfg.useGL20 = false;
		cfg.width = 1000;
		cfg.height = 600;
		
		new LwjglApplication(new Main(), cfg);
	}
}
