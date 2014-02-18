package com.games.Android.Laser_Cube.Level15;

import com.games.Android.Laser_Cube.Main;
import com.games.Android.Laser_Cube.Load.Init_Renderer;
import com.games.Android.Laser_Cube.Load.Screen;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class Level15 implements Screen
{

	private Init_Renderer init;
	
	private Renderer renderer;
	private Simulation simulation;
	
	private int level = 0;
	
	private boolean game_finished = false;
	
	private Preferences prefs;
	
	
	public Level15( Application app, Init_Renderer init, Main main )
	{
		this.init = init;
		
		prefs = Gdx.app.getPreferences("my-preferences");
        
        simulation = new Simulation( this, main );
        renderer = new Renderer( init );
	}

	
	@Override
	public void dispose() 
	{
	}

	@Override
	public void update( float delta, float touchX, float touchY, float width, float height, boolean touched_down, boolean fast_press, boolean pressed_back_button ) 
	{
		simulation.update( delta );
		simulation.variables( touchX, touchY, width, height, touched_down, fast_press, pressed_back_button );
	}

	@Override
	public void render(Application app ) 
	{
		
		renderer.DrawImages( Gdx.gl10, simulation );
		
	}
	
	public void Game_Finished( int level )
	{
		game_finished = true;
		this.level = level;
		if( simulation.game_won() )
		{
			prefs.putInteger("Level_15_Game", 2 );
			if( prefs.getInteger("Level_14_Game", 0) == 2)
			{
				
			}
			else
			{
				prefs.putInteger("Level_14_Game", 1 );
			}
			if( prefs.getInteger("Level_10_Game", 0) == 2)
			{
				
			}
			else
			{
				prefs.putInteger("Level_10_Game", 1 );
			}
			if( prefs.getInteger("Level_20_Game", 0) == 2)
			{
				
			}
			else
			{
				prefs.putInteger("Level_20_Game", 1 );
			}
			
			if( prefs.getInteger("Level_31_Game", 0) == 2)
			{
				
			}
			else
			{
				prefs.putInteger("Level_31_Game", 1 );
			}
			
			prefs.flush();
		}
	}

	@Override
	public boolean isDone() 
	{
		return game_finished;
	}


	@Override
	public int level() 
	{
		return level;
	}
	
}
