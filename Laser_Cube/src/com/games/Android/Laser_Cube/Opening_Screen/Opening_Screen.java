package com.games.Android.Laser_Cube.Opening_Screen;

import com.games.Android.Laser_Cube.Load.Init_Renderer;
import com.games.Android.Laser_Cube.Load.Opening_Renderer;
import com.games.Android.Laser_Cube.Load.Screen;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;

public class Opening_Screen implements Screen
{

	private Init_Renderer init;
	private Opening_Renderer opening;
	
	
	private Renderer renderer;
	private Simulation simulation;
	
	private boolean game_finished = false;
	
	
	public Opening_Screen( Application app, Init_Renderer init, Opening_Renderer opening  )
	{
		this.init = init;
        
        simulation = new Simulation( this );
        renderer = new Renderer( init, opening );
	}

	
	@Override
	public void dispose() 
	{
		renderer.dispose();
	}

	@Override
	public void update( float delta, float touchX, float touchY, float width, float height, boolean touched_down, boolean fast_press, boolean pressed_back_button ) 
	{
		simulation.update( delta );
		simulation.variables( touchX, touchY, width, height, touched_down, pressed_back_button );
	}

	@Override
	public void render(Application app ) 
	{
		
		renderer.DrawImages( Gdx.gl10, simulation );
		
	}
	
	public void Game_Finished()
	{
		game_finished = true;
	}

	@Override
	public boolean isDone() 
	{
		return game_finished;
	}


	@Override
	public int level() 
	{
		return 0;
	}
	
}
