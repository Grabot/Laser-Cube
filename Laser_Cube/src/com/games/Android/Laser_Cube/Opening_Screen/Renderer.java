package com.games.Android.Laser_Cube.Opening_Screen;

import com.games.Android.Laser_Cube.Load.Init_Renderer;
import com.games.Android.Laser_Cube.Load.Opening_Renderer;
import com.badlogic.gdx.graphics.GL10;

public class Renderer
{
	public static final String LOG = Renderer.class.getSimpleName();
	
	private Init_Renderer init;
	private Opening_Renderer opening;

	private int red = 1;
	private int green = 3;
	private int yellow = 5;
	
	private boolean play_game_touched = false;
	
	public Renderer( Init_Renderer init, Opening_Renderer opening )
	{
		this.init = init;
		this.opening = opening;
	}
	
	public void DrawImages( GL10 gl, Simulation simulation )
	{
		
        this.play_game_touched = simulation.play_game_touched();
        
        init.Bind_Object_Atlas();
        
        init.Build_Background( gl );
        init.Build_Wall( gl );
        
        init.Build_Mirror( gl, simulation.mirrors.get(1), 270, false, 1 );
        init.Build_Mirror( gl, simulation.mirrors.get(2), 180, false, 1 );
        init.Build_Mirror( gl, simulation.mirrors.get(3), 90, false, 1 );
        init.Build_Mirror( gl, simulation.mirrors.get(4), 0, false, 1 );
        
        init.laser_shot( gl, simulation.lasers, green );
        
        opening.opening_tile_animatie( gl, simulation.opening_tile_animaties );
        opening.play_game_animatie( gl, simulation.play_game_animaties, play_game_touched );

	}
	
    public void dispose()
    {
    	//opening.Dispose_All();
    }
}
