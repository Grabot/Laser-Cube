package com.games.Android.Laser_Cube.Level10;

import com.games.Android.Laser_Cube.Main;
import com.games.Android.Laser_Cube.Load.Init_Renderer;
import com.games.Android.Laser_Cube.Load.Screen;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class Level10 implements Screen
{

	private Init_Renderer init;
	
	private int level = 0;
	
	private Renderer renderer;
	private Simulation simulation;
	
	private boolean game_finished = false;
	
	private Preferences prefs;
	
	
	public Level10( Application app, Init_Renderer init, Main main )
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
			prefs.putInteger("Level_10_Game", 2 );
			if( prefs.getInteger("Level_5_Game", 0) == 2)
			{
				
			}
			else
			{
				prefs.putInteger("Level_5_Game", 1 );
			}
			if( prefs.getInteger("Level_15_Game", 0) == 2)
			{
				
			}
			else
			{
				prefs.putInteger("Level_15_Game", 1 );
			}
			if( prefs.getInteger("Level_9_Game", 0) == 2)
			{
				
			}
			else
			{
				prefs.putInteger("Level_9_Game", 1 );
			}
			
			if( prefs.getInteger("Level_26_Game", 0) == 2)
			{
				
			}
			else
			{
				prefs.putInteger("Level_26_Game", 1 );
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