package com.games.Android.Laser_Cube.Load;

import java.util.ArrayList;

import com.games.Android.Laser_Cube.Objects.Block;
import com.games.Android.Laser_Cube.Objects.Colour_Changer;
import com.games.Android.Laser_Cube.Objects.Cube;
import com.games.Android.Laser_Cube.Objects.Fire_Button;
import com.games.Android.Laser_Cube.Objects.Mirror;
import com.games.Android.Laser_Cube.Objects.Pause_Button;
import com.games.Android.Laser_Cube.Objects.Radiation_Tile;

public class Object_Touch 
{
	private int number_of_mirrors = 0;
	private int number_of_cubes = 0;
	private int number_of_colour_changers = 0;

	private float touch_distance_x = 0;
	private float touch_distance_y = 0;
	private boolean touched_down = false;;
	
	private boolean pause = false;
	private boolean fire_laser = false;
	
	private boolean touched_pause_button = false;
	private boolean touched_fire_button = false;
	
	private boolean reset_button_touched = false;
	private boolean continue_button_touched = false;
	private boolean back_button_touched = false;
	
	private boolean reset = false;
	private boolean back_to_menu = false;
	private boolean fast_press = false;
	private boolean button_pressed = false;
	private boolean pressed_back_button = false;
	
	private boolean[] mirror_finger = new boolean[30];
	private boolean[] mirrors_rotated = new boolean[30];
	
	private boolean[] cube_finger = new boolean[30];
	private boolean[] cubes_rotated = new boolean[30];
	
	private boolean[] colour_changer_finger = new boolean[30];
	private boolean[] colour_changers_rotated = new boolean[30];
	
	private float[] rotate_mirrors = new float[30];
	private boolean[] set_grid_mirror = new boolean[30];
	
	private float[] rotate_cubes = new float[30];
	private boolean[] set_grid_cube = new boolean[30];
	
	private float[] rotate_colour_changers = new float[30];
	private boolean[] set_grid_colour_changer = new boolean[30];
	
	private boolean[] mirror_solid = new boolean[30];
	private boolean[] cube_solid = new boolean[30];
	private boolean[] colour_changer_solid = new boolean[30];
	
	private Positioning positioning;
	
	ArrayList<Cube> cubes;
	ArrayList<Mirror> mirrors;
	ArrayList<Radiation_Tile> radiation_tiles;
	ArrayList<Block> blocks;
	ArrayList<Colour_Changer> colour_changers;
	
	private float[] touch_colour_changer_distance = new float[30];
	private float[] touch_mirror_distance = new float[30];
	private float[] touch_cube_distance = new float[30];
	
	public Object_Touch( ArrayList<Cube> cubes, ArrayList<Mirror> mirrors,  ArrayList<Radiation_Tile> radiation_tiles,  ArrayList<Block> blocks,  ArrayList<Colour_Changer> colour_changers, boolean[] mirror_solid, boolean[] cube_solid, boolean[] colour_changer_solid )
	{
		this.cubes = cubes;
		this.mirrors = mirrors;
		this.radiation_tiles = radiation_tiles;
		this.blocks = blocks;
		this.colour_changers = colour_changers;
		this.mirror_solid = mirror_solid;
		this.cube_solid = cube_solid;
		this.colour_changer_solid = colour_changer_solid;
		positioning = new Positioning();
		
		
		if( mirrors == null )
		{
			number_of_mirrors = 0;
		}
		else
		{
			number_of_mirrors = ( mirrors.size() - 1 );
		}
		
		
		if( cubes == null )
		{
			number_of_cubes = 0;
		}
		else
		{
			number_of_cubes = ( cubes.size() - 1 );
		}
		
		
		if( colour_changers == null )
		{
			number_of_colour_changers = 0;
		}
		else
		{
			number_of_colour_changers = ( colour_changers.size() - 1 );
		}
	}
	
	public void initialize_variables( float touch_distance_x, float touch_distance_y, boolean touched_down, boolean pressed_back_button, boolean fast_press, float[] rotate_mirrors, float[] rotate_cubes, float[] rotate_colour_changers )
	{
		this.touch_distance_x = touch_distance_x;
		this.touch_distance_y = touch_distance_y;
		
		this.touched_down = touched_down;
		
		this.pressed_back_button = pressed_back_button;
		
		this.fast_press = fast_press;
		
		this.rotate_mirrors = rotate_mirrors;
		this.rotate_cubes = rotate_cubes;
		this.rotate_colour_changers = rotate_colour_changers;
	
		reset = false;
		back_to_menu = false;
	}
	
	public void touched_essentials( Fire_Button fire_button, Pause_Button pause_button )
    {
		float touch_fire_button_distance = 0;
		float touch_pause_button_distance = 0;
		
		
    	touch_fire_button_distance = fire_button.position.distance( new Vector( touch_distance_x, touch_distance_y, -2.5f ));
        touch_pause_button_distance = pause_button.position.distance( new Vector ( touch_distance_x, touch_distance_y, -2.5f ));
    	
        if( touch_pause_button_distance < 10 && touched_down )
    	{
    		touched_pause_button = true;
    	}
		
		
		if( touch_fire_button_distance < 10 && touched_down )
    	{
    		touched_fire_button = true;
    	}
		
		if( touched_down )
		{
			
		}
		else
		{
			fire_laser = false;
			
			if( touched_pause_button )
			{
    			if( touch_pause_button_distance < 10 )
    	    	{
    	    			pause = true;
    	    	}
			}
			
			if( touched_fire_button )
			{
				
				if( touch_fire_button_distance < 10 )
            	{
            		fire_laser = true;
            	}
			}

			touched_pause_button = false;
			touched_fire_button = false;
		}
		
		if( pressed_back_button )
		{
			pause = true;
		}
    }
	
	
	public void touched_mirrors()
	{
        
		for( int i = 1; i <= number_of_mirrors; i++ )
    	{
			if( mirror_solid[i] == true )
			{
				
			}
			else
			{
	        	touch_mirror_distance[i] = mirrors.get(i).position.distance( new Vector( touch_distance_x, touch_distance_y, -2.5f ));
	        	
	    		
	    		if( (touch_mirror_distance[i] < 10) && fast_press )
	        	{
	        			mirrors_rotated[i] = true;
	        			rotate_mirrors[i] += 3;
	        	}
	    		
	        	if( touch_mirror_distance[i] < 10 && touched_down )
	        	{
	        		
	        		if( button_pressed )
	        		{
	        		}
	        		else
	        		{
	        			mirrors.get(i).position.z = -5;
	        			mirror_finger[i] = true;
	        			set_grid_mirror[i] = true;
	        			button_pressed = true;
	        		}
	        	}
	        	else
	        	{
	        			if( !touched_down )
	        			{
	        				mirrors.get(i).position.z = 0;
	        				mirror_finger[i] = false;
	        				mirror_finger[0] = true;
	        				button_pressed = false;
	
	        				if( set_grid_mirror[i] )
	        				{
	        					positioning.Mirrors_Grid( i, touched_down, cubes, mirrors, radiation_tiles, blocks, colour_changers  );
	        					set_grid_mirror[i] = false;
	        				}
	        			}
	        	}
			}
    	}
	}
	
	
	public void touched_cubes()
	{
		
		for( int i = 1; i <= number_of_cubes; i++ )
    	{
			if( cube_solid[i] == true )
			{
				
			}
			else
			{
	        	touch_cube_distance[i] = cubes.get(i).position.distance( new Vector( touch_distance_x, touch_distance_y, -2.5f ));
	        	
	    		
	    		if( (touch_cube_distance[i] < 10) && fast_press )
	        	{
	        			cubes_rotated[i] = true;
	        			rotate_cubes[i] += 3;
	        	}
	    		
	        	if( touch_cube_distance[i] < 10 && touched_down )
	        	{
	        		
	        		if( button_pressed )
	        		{
	        		}
	        		else
	        		{
	        			cubes.get(i).position.z = -5;
	        			cube_finger[i] = true;
	        			set_grid_cube[i] = true;
	        			button_pressed = true;
	        		}
	        	}
	        	else
	        	{
	        			if( !touched_down )
	        			{
	        				cubes.get(i).position.z = 0;
	        				cube_finger[i] = false;
	        				cube_finger[0] = true;
	        				button_pressed = false;
	        				
	        				if( set_grid_cube[i] )
	        				{
	        					positioning.Cubes_Grid( i, touched_down, cubes, mirrors, radiation_tiles, blocks, colour_changers  );
	        					set_grid_cube[i] = false;
	        				}
	        			}
	        	}
			}
    	}
	}
	
	public void touched_colour_changers()
	{
		
		for( int i = 1; i <= number_of_colour_changers; i++ )
    	{
			if( colour_changer_solid[i] == true )
			{
				
			}
			else
			{
	        	touch_colour_changer_distance[i] = colour_changers.get(i).position.distance( new Vector( touch_distance_x, touch_distance_y, -2.5f ));
	        	
	    		if( (touch_colour_changer_distance[i] < 10) && fast_press )
	        	{
	        			colour_changers_rotated[i] = true;
	        			rotate_colour_changers[i] += 3;
	        	}
	    		
	        	if( touch_colour_changer_distance[i] < 10 && touched_down )
	        	{
	        		
	        		if( button_pressed )
	        		{
	        		}
	        		else
	        		{
	        			colour_changers.get(i).position.z = -5;
	        			colour_changer_finger[i] = true;
	        			set_grid_colour_changer[i] = true;
	        			button_pressed = true;
	        		}
	        	}
	        	else
	        	{
	        			if( !touched_down )
	        			{
	        				colour_changers.get(i).position.z = 0;
	        				colour_changer_finger[i] = false;
	        				colour_changer_finger[0] = true;
	        				button_pressed = false;
	        				
	        				if( set_grid_colour_changer[i] )
	        				{
	        					positioning.Colour_Changers_Grid( i, touched_down, cubes, mirrors, radiation_tiles, blocks, colour_changers  );
	        					set_grid_colour_changer[i] = false;
	        				}
	        			}
	        	}
			}
    	}
	}
	
	
	public void pause_check()
	{
		float touch_continue_button = 0;
		float touch_back_button = 0;
		float touch_reset_button = 0;
		
    	touch_continue_button = new Vector( 0, 4, -15 ).distance( new Vector( touch_distance_x, touch_distance_y, -15f ));
    	touch_back_button = new Vector( 0, -26, -15 ).distance( new Vector( touch_distance_x, touch_distance_y, -15f ));
    	touch_reset_button = new Vector( 0, -11, -15 ).distance( new Vector( touch_distance_x, touch_distance_y, -15f ));
    	
    	if( touch_continue_button < 10 && touched_down )
    	{
    		if( !back_button_touched && !reset_button_touched )
    		{
        		continue_button_touched = true;
    		}
    	}
    	
    	if( touch_back_button < 10 && touched_down )
    	{
    		if( !continue_button_touched && !reset_button_touched )
    		{
        		back_button_touched = true;
    		}
    	}
    	
    	if( touch_reset_button < 10 && touched_down )
    	{
    		if( !continue_button_touched && !back_button_touched )
    		{
        		reset_button_touched = true;
    		}
    	}
    	
    	if( touched_down )
    	{
    	}
    	else
    	{
    		
    		if( touch_continue_button < 10 )
        	{
    			continue_button_touched = false;
    			pause = false;
        	}
    		
    		if( touch_back_button < 10 )
        	{
    			back_button_touched = false;
    			back_to_menu = true;
        		pause = false;
        	}
    		
    		if( touch_reset_button < 10 )
        	{
    			reset_button_touched = false;
    			
        		reset = true;
        		pause = false;
        	}
    		
    		continue_button_touched = false;
    		back_button_touched = false;
    		reset_button_touched = false;
    	}
    	

    	if( pressed_back_button )
    	{
    		back_to_menu = true;
    	}
	}
	
	
	public boolean pause()
	{
		return pause;
	}
	
	public boolean fire_laser()
	{
		return fire_laser;
	}
	
	public boolean touched_pause_button()
	{
		return touched_pause_button;
	}

	public boolean reset()
	{
		return reset;
	}
	
	public boolean back_to_menu()
	{
		return back_to_menu;
	}
	
	public boolean continue_button_touched()
	{
		return continue_button_touched;
	}
	
	public boolean back_button_touched()
	{
		return back_button_touched;
	}
	
	public boolean reset_button_touched()
	{
		return reset_button_touched;
	}
	
	public boolean[] mirror_finger()
	{
		return mirror_finger;
	}
	
	public boolean[] mirrors_rotated()
	{
		return mirrors_rotated;
	}
	
	public float[] rotate_mirrors()
	{
		return rotate_mirrors;
	}
	
	
	public boolean[] cube_finger()
	{
		return cube_finger;
	}
	
	public boolean[] cubes_rotated()
	{
		return cubes_rotated;
	}
	
	public float[] rotate_cubes()
	{
		return rotate_cubes;
	}
	
	
	public boolean[] colour_changer_finger()
	{
		return colour_changer_finger;
	}
	
	public boolean[] colour_changers_rotated()
	{
		return colour_changers_rotated;
	}
	
	public float[] rotate_colour_changers()
	{
		return rotate_colour_changers;
	}
	
}
