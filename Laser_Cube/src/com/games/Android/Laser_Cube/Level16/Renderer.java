package com.games.Android.Laser_Cube.Level16;

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
        init.Build_Radiation_Tile( gl, simulation.radiation_tiles.get(8), radiation_tile_touch[8], yellow );
        init.Build_Radiation_Tile( gl, simulation.radiation_tiles.get(9), radiation_tile_touch[9], yellow );
        init.Build_Radiation_Tile( gl, simulation.radiation_tiles.get(10), radiation_tile_touch[10], yellow );
        
        init.Build_Cube( gl, simulation.cubes.get(1), rotate_cubes[1], green, false );
        init.Build_Cube( gl, simulation.cubes.get(2), rotate_cubes[2], yellow, false );
        
        init.Build_Mirror( gl, simulation.mirrors.get(1), rotate_mirrors[1], false, single_refraction );
        init.Build_Mirror( gl, simulation.mirrors.get(2), rotate_mirrors[2], false, single_refraction );
        init.Build_Mirror( gl, simulation.mirrors.get(3), rotate_mirrors[3], false, single_refraction );
        init.Build_Mirror( gl, simulation.mirrors.get(4), rotate_mirrors[4], false, single_refraction );
        init.Build_Mirror( gl, simulation.mirrors.get(5), rotate_mirrors[5], false, single_refraction );
        init.Build_Mirror( gl, simulation.mirrors.get(6), rotate_mirrors[6], false, single_refraction );
        init.Build_Mirror( gl, simulation.mirrors.get(7), rotate_mirrors[7], false, single_refraction );
        init.Build_Mirror( gl, simulation.mirrors.get(8), rotate_mirrors[8], false, single_refraction );
        init.Build_Mirror( gl, simulation.mirrors.get(9), rotate_mirrors[9], false, single_refraction );
        init.Build_Mirror( gl, simulation.mirrors.get(10), rotate_mirrors[10], false, single_refraction );
        init.Build_Mirror( gl, simulation.mirrors.get(11), rotate_mirrors[11], false, single_refraction );
        init.Build_Mirror( gl, simulation.mirrors.get(12), rotate_mirrors[12], false, single_refraction );
        init.Build_Mirror( gl, simulation.mirrors.get(13), rotate_mirrors[13], false, single_refraction );
        init.Build_Mirror( gl, simulation.mirrors.get(14), rotate_mirrors[14], false, single_refraction );
        init.Build_Mirror( gl, simulation.mirrors.get(15), rotate_mirrors[15], false, double_refraction );
        
        init.Build_Block( gl, simulation.blocks.get(1) );
        init.Build_Block( gl, simulation.blocks.get(2) );
        init.Build_Block( gl, simulation.blocks.get(3) );
        init.Build_Block( gl, simulation.blocks.get(4) );
        init.Build_Block( gl, simulation.blocks.get(5) );
        init.Build_Block( gl, simulation.blocks.get(6) );
        init.Build_Block( gl, simulation.blocks.get(7) );
        init.Build_Block( gl, simulation.blocks.get(8) );
        init.Build_Block( gl, simulation.blocks.get(9) );
        init.Build_Block( gl, simulation.blocks.get(10) );
        init.Build_Block( gl, simulation.blocks.get(11) );
        init.Build_Block( gl, simulation.blocks.get(12) );
        init.Build_Block( gl, simulation.blocks.get(13) );
        init.Build_Block( gl, simulation.blocks.get(14) );
        init.Build_Block( gl, simulation.blocks.get(15) );
        init.Build_Block( gl, simulation.blocks.get(16) );
        init.Build_Block( gl, simulation.blocks.get(17) );
        init.Build_Block( gl, simulation.blocks.get(18) );
        init.Build_Block( gl, simulation.blocks.get(19) );
        init.Build_Block( gl, simulation.blocks.get(20) );
        init.Build_Block( gl, simulation.blocks.get(21) );
        init.Build_Block( gl, simulation.blocks.get(22) );
        init.Build_Block( gl, simulation.blocks.get(23) );
        init.Build_Block( gl, simulation.blocks.get(24) );
        init.Build_Block( gl, simulation.blocks.get(25) );
        init.Build_Block( gl, simulation.blocks.get(26) );
        
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
        	init.game_won_screen( gl, 16 );
        }
        
	}
	
}
