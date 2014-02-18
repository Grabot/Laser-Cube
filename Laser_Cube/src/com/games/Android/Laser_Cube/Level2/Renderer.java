package com.games.Android.Laser_Cube.Level2;

import com.games.Android.Laser_Cube.Load.Init_Renderer;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;

public class Renderer
{
	public static final String LOG = Renderer.class.getSimpleName();
	
	private Init_Renderer init;
	
	private boolean pause = false;
	
	private boolean continue_button_touched = false;
	private boolean back_button_touched = false;
	private boolean reset_button_touched = false;
	
	private boolean[] radiation_tile_touch = new boolean[30];
	
	private boolean touched_pause_button = false;
	
	private boolean game_won = false;

	private float rotate_cube_green = 0;
	
	private float[] rotate_mirrors = new float[30];
	private float[] rotate_cubes = new float[30];
	
	private int red = 1;
	private int green = 3;
	private int yellow = 5;
	
	private int number_of_mirrors = 1;
	
	private int single_refraction = 1;
	private int double_refraction = 2;
	private int triple_refraction = 3;
	private int forward_refraction = 4;
	
	private boolean help = true;
	
	public Renderer( Init_Renderer init )
	{
		
		this.init = init;
        Gdx.app.log( Renderer.LOG, "Level 2" );

	}
	
	
	
	public void DrawImages( GL10 gl, Simulation simulation )
	{
        
        this.rotate_cubes = simulation.rotate_cubes();
        this.rotate_mirrors = simulation.rotate_mirrors();
        this.pause = simulation.pause();
        
        this.continue_button_touched = simulation.continue_button_touched();
        this.back_button_touched = simulation.back_button_touched();
        this.reset_button_touched = simulation.reset_button_touched();
        this.touched_pause_button = simulation.touched_pause_button();
        this.radiation_tile_touch = simulation.radiation_tile_touch();
        this.game_won = simulation.game_won();
        this.help = simulation.get_help();
        
        init.Bind_Object_Atlas();
        
        init.Build_Background( gl );
        
        init.Build_Wall( gl );
        
        init.FireButton( gl, simulation.fire_button );
        init.PauseButton( gl, simulation.pause_button, touched_pause_button );
        
        init.Build_Radiation_Tile( gl, simulation.radiation_tiles.get(1), radiation_tile_touch[1], green );
        
        init.Build_Cube( gl, simulation.cubes.get(1), rotate_cubes[1], green, true );
        
        for( int i = 1; i <= number_of_mirrors ; i++ )
        {
            init.Build_Mirror( gl, simulation.mirrors.get(i), rotate_mirrors[i], false, single_refraction );
        }
        
        init.laser_shot( gl, simulation.green_lasers, green );
        
        
        
        if( pause )
        {
        	init.Pause_Screen(gl, continue_button_touched, reset_button_touched, back_button_touched);
        }
        
        if( help )
        {
        	init.Help_Screen( gl, 2 );
        }
        
        if( game_won )
        {
        	init.Bind_Cleared_Levels();
        	init.game_won_screen( gl, 2 );
        }
        
	}
}
