package com.games.Android.Laser_Cube.Level23;

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
	private float[] rotate_colour_changers = new float[30];
	
	private int red = 1;
	private int green = 3;
	private int yellow = 5;
	
	private int number_of_mirrors = 3;
	
	private int single_refraction = 1;
	private int double_refraction = 2;
	private int triple_refraction = 3;
	private int forward_refraction = 4;
	
	public Renderer( Init_Renderer init )
	{
		
		this.init = init;
        Gdx.app.log( Renderer.LOG, "Level 14" );

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
        this.rotate_colour_changers = simulation.rotate_colour_changers();
        this.game_won = simulation.game_won();
        
        init.Bind_Object_Atlas();
        
        init.Build_Background( gl );
        
        init.Build_Wall( gl );
        
        init.FireButton( gl, simulation.fire_button );
        init.PauseButton( gl, simulation.pause_button, touched_pause_button );
        
        init.Build_Radiation_Tile( gl, simulation.radiation_tiles.get(1), radiation_tile_touch[1], green );
        init.Build_Radiation_Tile( gl, simulation.radiation_tiles.get(2), radiation_tile_touch[2], green );
        init.Build_Radiation_Tile( gl, simulation.radiation_tiles.get(3), radiation_tile_touch[3], green );
        init.Build_Radiation_Tile( gl, simulation.radiation_tiles.get(4), radiation_tile_touch[4], green );
        init.Build_Radiation_Tile( gl, simulation.radiation_tiles.get(5), radiation_tile_touch[5], green );
        init.Build_Radiation_Tile( gl, simulation.radiation_tiles.get(6), radiation_tile_touch[6], green );
        init.Build_Radiation_Tile( gl, simulation.radiation_tiles.get(7), radiation_tile_touch[7], green );
        init.Build_Radiation_Tile( gl, simulation.radiation_tiles.get(8), radiation_tile_touch[8], green );
       
        init.Build_Cube( gl, simulation.cubes.get(1), rotate_cubes[1], green, false );
        
        init.Build_Mirror( gl, simulation.mirrors.get(1), rotate_mirrors[1], false, single_refraction );
        init.Build_Mirror( gl, simulation.mirrors.get(2), rotate_mirrors[2], false, single_refraction );
        init.Build_Mirror( gl, simulation.mirrors.get(3), rotate_mirrors[3], false, single_refraction );
        init.Build_Mirror( gl, simulation.mirrors.get(4), rotate_mirrors[4], false, single_refraction );
        init.Build_Mirror( gl, simulation.mirrors.get(5), rotate_mirrors[5], false, double_refraction );
        init.Build_Mirror( gl, simulation.mirrors.get(6), rotate_mirrors[6], true, single_refraction );
        init.Build_Mirror( gl, simulation.mirrors.get(7), rotate_mirrors[7], true, single_refraction );
        init.Build_Mirror( gl, simulation.mirrors.get(8), rotate_mirrors[8], true, single_refraction );
        init.Build_Mirror( gl, simulation.mirrors.get(9), rotate_mirrors[9], true, single_refraction );
        init.Build_Mirror( gl, simulation.mirrors.get(10), rotate_mirrors[10], true, single_refraction );
        init.Build_Mirror( gl, simulation.mirrors.get(11), rotate_mirrors[11], true, single_refraction );
        init.Build_Mirror( gl, simulation.mirrors.get(12), rotate_mirrors[12], true, single_refraction );
        init.Build_Mirror( gl, simulation.mirrors.get(13), rotate_mirrors[13], true, single_refraction );
        init.Build_Mirror( gl, simulation.mirrors.get(14), rotate_mirrors[14], true, single_refraction );
        init.Build_Mirror( gl, simulation.mirrors.get(15), rotate_mirrors[15], true, single_refraction );
        init.Build_Mirror( gl, simulation.mirrors.get(16), rotate_mirrors[16], true, single_refraction );
        init.Build_Mirror( gl, simulation.mirrors.get(17), rotate_mirrors[17], true, single_refraction );
        init.Build_Mirror( gl, simulation.mirrors.get(18), rotate_mirrors[18], true, double_refraction );
        init.Build_Mirror( gl, simulation.mirrors.get(19), rotate_mirrors[19], true, single_refraction );
        init.Build_Mirror( gl, simulation.mirrors.get(20), rotate_mirrors[20], true, single_refraction );
        init.Build_Mirror( gl, simulation.mirrors.get(21), rotate_mirrors[21], true, single_refraction );
        init.Build_Mirror( gl, simulation.mirrors.get(22), rotate_mirrors[22], true, single_refraction );
        init.Build_Mirror( gl, simulation.mirrors.get(23), rotate_mirrors[23], true, single_refraction );
        init.Build_Mirror( gl, simulation.mirrors.get(24), rotate_mirrors[24], true, single_refraction );
        init.Build_Mirror( gl, simulation.mirrors.get(25), rotate_mirrors[25], true, single_refraction );
        init.Build_Mirror( gl, simulation.mirrors.get(26), rotate_mirrors[26], true, single_refraction );
        init.Build_Mirror( gl, simulation.mirrors.get(27), rotate_mirrors[27], true, single_refraction );
        init.Build_Mirror( gl, simulation.mirrors.get(28), rotate_mirrors[28], true, single_refraction );
        init.Build_Mirror( gl, simulation.mirrors.get(29), rotate_mirrors[29], true, double_refraction );
        
        
        init.laser_shot( gl, simulation.green_lasers, green );
        init.laser_shot( gl, simulation.red_lasers, red );
        init.laser_shot( gl, simulation.yellow_lasers, yellow );
        
        if( pause )
        {
        	init.Pause_Screen(gl, continue_button_touched, reset_button_touched, back_button_touched);
        }
        
        if( game_won )
        {
        	init.Bind_Cleared_Levels();
        	init.game_won_screen( gl, 23 );
        }
        
	}
}
