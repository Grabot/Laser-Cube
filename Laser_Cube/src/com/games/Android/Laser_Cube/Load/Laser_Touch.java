package com.games.Android.Laser_Cube.Load;

import java.util.ArrayList;

import com.games.Android.Laser_Cube.Objects.Block;
import com.games.Android.Laser_Cube.Objects.Colour_Changer;
import com.games.Android.Laser_Cube.Objects.Cube;
import com.games.Android.Laser_Cube.Objects.Laser;
import com.games.Android.Laser_Cube.Objects.Mirror;
import com.games.Android.Laser_Cube.Objects.Radiation_Tile;

public class Laser_Touch 
{
	private boolean laser_fired = false;
	
	private int groen = 1;
    private int rood = 2;
    private int geel = 3;
    
    private int links = 11;
    private int boven = 12;
    private int rechts = 13;
    private int onder = 14;

    private int single_refraction = 21;
    private int double_refraction = 22;
    private int triple_refraction = 23;
    private int forward_refraction = 24;
    
	public boolean[] mirror_touch = new boolean[30];
	private float[] rotate_mirrors = new float[30];
	
	public boolean[] colour_changer_touch = new boolean[30];
	
	private int[] mirror_shape = new int[30];
	private int[] colour_changer_colour = new int[30];
	private int[] radiation_tiles_colour = new int[30];
	
	ArrayList<Cube> cubes;
	ArrayList<Mirror> mirrors;
	ArrayList<Radiation_Tile> radiation_tiles;
	ArrayList<Block> blocks;
	ArrayList<Colour_Changer> colour_changers;
	
	public ArrayList<Laser> green_lasers = new ArrayList<Laser>( );
	public ArrayList<Laser> red_lasers = new ArrayList<Laser>( );
	public ArrayList<Laser> yellow_lasers = new ArrayList<Laser>( );
	
	public boolean[] touched_radiation_tile = new boolean[30];
	
	private boolean[] radiation_tile_touch = new boolean[30];
	
	private int number_of_mirrors = 0;
    private int number_of_radiation_tiles = 0;
    private int number_of_colour_changers = 0;
    
    private boolean game_won = false;
    
	public Laser_Touch( ArrayList<Cube> cubes, ArrayList<Mirror> mirrors,  ArrayList<Radiation_Tile> radiation_tiles,  ArrayList<Block> blocks,  ArrayList<Colour_Changer> colour_changers, int[] mirror_shape, int[] colour_changer_colour, int[] radiation_tiles_colour )
	{
		this.cubes = cubes;
		this.mirrors = mirrors;
		this.radiation_tiles = radiation_tiles;
		this.blocks = blocks;
		this.colour_changers = colour_changers;
		this.mirror_shape = mirror_shape;
		this.colour_changer_colour = colour_changer_colour;
		this.radiation_tiles_colour = radiation_tiles_colour;
		
		if( mirrors == null )
		{
			number_of_mirrors = 0;
		}
		else
		{
			number_of_mirrors = ( mirrors.size() - 1 );
		}
		
		
		if( colour_changers == null )
		{
			number_of_colour_changers = 0;
		}
		else
		{
			number_of_colour_changers = ( colour_changers.size() - 1 );
		}
		
		if( radiation_tiles == null )
		{
			number_of_radiation_tiles = 0;
		}
		else
		{
			number_of_radiation_tiles = ( radiation_tiles.size() - 1 );
		}
		
		
		for( int k = 0; k < mirror_touch.length; k++ )
		{
			mirror_touch[k] = true;
		}
    	
    	for( int k = 0; k < colour_changer_touch.length; k++ )
		{
			colour_changer_touch[k] = true;
		}
    	
	}
	
	public void Initialize( float[] rotate_mirrors, ArrayList<Laser> green_lasers, ArrayList<Laser> red_lasers, ArrayList<Laser> yellow_lasers, boolean laser_fired )
	{
		this.rotate_mirrors = rotate_mirrors;
		
		this.green_lasers = green_lasers;
		this.red_lasers = red_lasers;
		this.yellow_lasers = yellow_lasers;
		
		this.laser_fired = laser_fired;
	}
	
	
	ArrayList<Laser> lasers_green_weg = new ArrayList<Laser>();
    public void UpdateShots_Green()
    {
    	lasers_green_weg.clear();
    	for( int i = 0; i < green_lasers.size(); i++ )
        {
    			Laser laser = green_lasers.get(i);
    			laser.Level( cubes, mirrors, radiation_tiles, blocks, colour_changers );
    			laser.update();
    			
    			for( int k = 1; k <= number_of_mirrors; k++ )
        		{
        			Refractions( laser, k, groen );
        		}
    			
    			for( int k = 1; k <= number_of_colour_changers; k++ )
    			{
    				Change_Colour( laser, k );
    			}
    			
    			for( int k = 0; k < radiation_tiles_colour.length; k++ )
    			{
    				if( radiation_tiles_colour[k] == groen )
    				{
    					if( laser.touched_radiation_tile[k] )
    					{
    						radiation_tile_touch[k] = true;
    					}
    				}
    			}
    			
    			if( laser.laser_weg )
    			{
    				lasers_green_weg.add(laser);
    			}
    			
    			for( int k = 0; k < lasers_green_weg.size(); k++ )   
                {
                    green_lasers.remove( lasers_green_weg.get(k) );
                }
    	}
    }
    
    ArrayList<Laser> lasers_red_weg = new ArrayList<Laser>();
    public void UpdateShots_Red()
    {
    	lasers_red_weg.clear();
    	for( int i = 0; i < red_lasers.size(); i++ )
        {
    			Laser laser = red_lasers.get(i);
    			laser.Level( cubes, mirrors, radiation_tiles, blocks, colour_changers );
    			laser.update();
    			
    			for( int k = 1; k <= number_of_mirrors; k++ )
        		{
        			Refractions( laser, k, rood );
        		}
    			
    			for( int k = 1; k <= number_of_colour_changers; k++ )
    			{
    				Change_Colour( laser, k );
    			}
    			
    			
    			for( int k = 0; k < radiation_tiles_colour.length; k++ )
    			{
    				if( radiation_tiles_colour[k] == rood )
    				{
    					if( laser.touched_radiation_tile[k] )
    					{
    						radiation_tile_touch[k] = true;
    					}
    				}
    			}
    			
    			if( laser.laser_weg )
    			{
    				lasers_red_weg.add(laser);
    			}
    			
    			for( int k = 0; k < lasers_red_weg.size(); k++ )   
                {
                    red_lasers.remove( lasers_red_weg.get(k) );
                }
    	}
    }
    
    ArrayList<Laser> lasers_yellow_weg = new ArrayList<Laser>();
    public void UpdateShots_Yellow()
    {
    	lasers_yellow_weg.clear();
    	for( int i = 0; i < yellow_lasers.size(); i++ )
        {
    			Laser laser = yellow_lasers.get(i);
    			laser.Level( cubes, mirrors, radiation_tiles, blocks, colour_changers );
    			laser.update();
    			
    			for( int k = 1; k <= number_of_mirrors; k++ )
        		{
        			Refractions( laser, k, geel );
        		}
    			
    			for( int k = 1; k <= number_of_colour_changers; k++ )
    			{
    				Change_Colour( laser, k );
    			}
    			
    			
    			for( int k = 0; k < radiation_tiles_colour.length; k++ )
    			{
    				if( radiation_tiles_colour[k] == geel )
    				{
    					if( laser.touched_radiation_tile[k] )
    					{
    						radiation_tile_touch[k] = true;
    					}
    				}
    			}
    			
    			if( laser.laser_weg )
    			{
    				lasers_yellow_weg.add(laser);
    			}
    			
    			for( int k = 0; k < lasers_yellow_weg.size(); k++ )   
                {
    				yellow_lasers.remove( lasers_yellow_weg.get(k) );
                }
    	}
    }
    
    
	private void Refractions( Laser laser, int k, int kleur )
    {

    	if( laser.touched_mirror_bottom[k] == true && mirror_touch[k] )
    	{

    				if( rotate_mirrors[k] == 0 )
    				{
						if( mirror_shape[k] == single_refraction )
						{
							Laser_Mirror_Add( laser, k, links, kleur, 1 );
                			mirror_touch[k] = false;
						}
						else if( mirror_shape[k] == double_refraction )
						{
							Laser_Mirror_Add( laser, k, links, kleur, 1 );
    						Laser_Mirror_Add( laser, k, rechts, kleur, 1 );
                			mirror_touch[k] = false;
						}
						else if( mirror_shape[k] == triple_refraction )
						{
							Laser_Mirror_Add( laser, k, links, kleur, 1 );
							Laser_Mirror_Add( laser, k, rechts, kleur, 1 );
							Laser_Mirror_Add( laser, k, boven, kleur, 1 );
							mirror_touch[k] = false;
						}
						else if( mirror_shape[k] == forward_refraction )
						{
						}
    				}
    				else if( rotate_mirrors[k] == 90 )
    				{
    					if( mirror_shape[k] == single_refraction )
						{
						}
						else if( mirror_shape[k] == double_refraction )
						{
							Laser_Mirror_Add( laser, k, links, kleur, 1 );
    						Laser_Mirror_Add( laser, k, boven, kleur, 1 );
                			mirror_touch[k] = false;
						}
						else if( mirror_shape[k] == triple_refraction )
						{
							Laser_Mirror_Add( laser, k, links, kleur, 1 );
							Laser_Mirror_Add( laser, k, rechts, kleur, 1 );
							Laser_Mirror_Add( laser, k, boven, kleur, 1 );
							mirror_touch[k] = false;
						}
						else if( mirror_shape[k] == forward_refraction )
						{
							Laser_Mirror_Add( laser, k, boven, groen, 1 );
							mirror_touch[k] = false;
						}
    				}
    				else if( rotate_mirrors[k] == 180 )
    				{
    					if( mirror_shape[k] == single_refraction )
						{
						}
						else if( mirror_shape[k] == double_refraction )
						{
						}
						else if( mirror_shape[k] == triple_refraction )
						{
							Laser_Mirror_Add( laser, k, links, kleur, 1 );
							Laser_Mirror_Add( laser, k, rechts, kleur, 1 );
							Laser_Mirror_Add( laser, k, boven, kleur, 1 );
							mirror_touch[k] = false;
						}
						else if( mirror_shape[k] == forward_refraction )
						{
						}
    				}
    				else if( rotate_mirrors[k] == 270 )
    				{
    					if( mirror_shape[k] == single_refraction )
						{
    						Laser_Mirror_Add( laser, k, rechts, kleur, 1 );
                			mirror_touch[k] = false;
						}
						else if( mirror_shape[k] == double_refraction )
						{
							Laser_Mirror_Add( laser, k, boven, kleur, 1 );
    						Laser_Mirror_Add( laser, k, rechts, kleur, 1 );
                			mirror_touch[k] = false;
						}
						else if( mirror_shape[k] == triple_refraction )
						{
							Laser_Mirror_Add( laser, k, links, kleur, 1 );
							Laser_Mirror_Add( laser, k, rechts, kleur, 1 );
							Laser_Mirror_Add( laser, k, boven, kleur, 1 );
							mirror_touch[k] = false;
						}
						else if( mirror_shape[k] == forward_refraction )
						{
							Laser_Mirror_Add( laser, k, boven, kleur, 1 );
							mirror_touch[k] = false;
						}
    				}
        		
    	}
    	
    	if( laser.touched_mirror_left[k] == true && mirror_touch[k] )
    	{
    			
        			if( rotate_mirrors[k] == 0 )
    				{
        				if( mirror_shape[k] == single_refraction )
						{
        					Laser_Mirror_Add( laser, k, onder, kleur, 1 );
                			mirror_touch[k] = false;
						}
						else if( mirror_shape[k] == double_refraction )
						{
							Laser_Mirror_Add( laser, k, onder, kleur, 1 );
    						Laser_Mirror_Add( laser, k, rechts, kleur, 1 );
                			mirror_touch[k] = false;
						}
						else if( mirror_shape[k] == triple_refraction )
						{
							Laser_Mirror_Add( laser, k, onder, kleur, 1 );
							Laser_Mirror_Add( laser, k, rechts, kleur, 1 );
							Laser_Mirror_Add( laser, k, boven, kleur, 1 );
							mirror_touch[k] = false;
						}
						else if( mirror_shape[k] == forward_refraction )
						{
							Laser_Mirror_Add( laser, k, rechts, kleur, 1 );
							mirror_touch[k] = false;
						}
    				}
    				else if( rotate_mirrors[k] == 90 )
    				{
    					if( mirror_shape[k] == single_refraction )
						{
    						Laser_Mirror_Add( laser, k, boven, kleur, 1 );
                			mirror_touch[k] = false;
						}
						else if( mirror_shape[k] == double_refraction )
						{
							Laser_Mirror_Add( laser, k, boven, kleur, 1 );
    						Laser_Mirror_Add( laser, k, onder, kleur, 1 );
                			mirror_touch[k] = false;
						}
						else if( mirror_shape[k] == triple_refraction )
						{
							Laser_Mirror_Add( laser, k, onder, kleur, 1 );
							Laser_Mirror_Add( laser, k, rechts, kleur, 1 );
							Laser_Mirror_Add( laser, k, boven, kleur, 1 );
							mirror_touch[k] = false;
						}
						else if( mirror_shape[k] == forward_refraction )
						{
						}
    				}
    				else if( rotate_mirrors[k] == 180 )
    				{
    					if( mirror_shape[k] == single_refraction )
						{
						}
						else if( mirror_shape[k] == double_refraction )
						{
							Laser_Mirror_Add( laser, k, boven, kleur, 1 );
    						Laser_Mirror_Add( laser, k, rechts, kleur, 1 );
                			mirror_touch[k] = false;
						}
						else if( mirror_shape[k] == triple_refraction )
						{
							Laser_Mirror_Add( laser, k, onder, kleur, 1 );
							Laser_Mirror_Add( laser, k, rechts, kleur, 1 );
							Laser_Mirror_Add( laser, k, boven, kleur, 1 );
							mirror_touch[k] = false;
						}
						else if( mirror_shape[k] == forward_refraction )
						{
							Laser_Mirror_Add( laser, k, rechts, kleur, 1 );
							mirror_touch[k] = false;
						}
    				}
    				else if( rotate_mirrors[k] == 270 )
    				{
    					if( mirror_shape[k] == single_refraction )
						{
						}
						else if( mirror_shape[k] == double_refraction )
						{
						}
						else if( mirror_shape[k] == triple_refraction )
						{
							Laser_Mirror_Add( laser, k, onder, kleur, 1 );
							Laser_Mirror_Add( laser, k, rechts, kleur, 1 );
							Laser_Mirror_Add( laser, k, boven, kleur, 1 );
							mirror_touch[k] = false;
						}
						else if( mirror_shape[k] == forward_refraction )
						{
						}
    				}
        			
        		
        		
    	}
    	
    	
    	if( laser.touched_mirror_top[k] == true && mirror_touch[k] )
    	{
    			
    				if( rotate_mirrors[k] == 0 )
    				{
    					if( mirror_shape[k] == single_refraction )
						{
						}
						else if( mirror_shape[k] == double_refraction )
						{
						}
						else if( mirror_shape[k] == triple_refraction )
						{
							Laser_Mirror_Add( laser, k, onder, kleur, 1 );
							Laser_Mirror_Add( laser, k, rechts, kleur, 1 );
							Laser_Mirror_Add( laser, k, links, kleur, 1 );
							mirror_touch[k] = false;
						}
						else if( mirror_shape[k] == forward_refraction )
						{
						}
    				}
    				else if( rotate_mirrors[k] == 90 )
    				{
    					if( mirror_shape[k] == single_refraction )
						{
    						Laser_Mirror_Add( laser, k, links, kleur, 1 );
                			mirror_touch[k] = false;
						}
						else if( mirror_shape[k] == double_refraction )
						{
							Laser_Mirror_Add( laser, k, links, kleur, 1 );
    						Laser_Mirror_Add( laser, k, onder, kleur, 1 );
                			mirror_touch[k] = false;
						}
						else if( mirror_shape[k] == triple_refraction )
						{
							Laser_Mirror_Add( laser, k, onder, kleur, 1 );
							Laser_Mirror_Add( laser, k, rechts, kleur, 1 );
							Laser_Mirror_Add( laser, k, links, kleur, 1 );
							mirror_touch[k] = false;
						}
						else if( mirror_shape[k] == forward_refraction )
						{
							Laser_Mirror_Add( laser, k, onder, kleur, 1 );
							mirror_touch[k] = false;
						}
    				}
    				else if( rotate_mirrors[k] == 180 )
    				{
    					if( mirror_shape[k] == single_refraction )
						{
    						Laser_Mirror_Add( laser, k, rechts, kleur, 1 );
                			mirror_touch[k] = false;
						}
						else if( mirror_shape[k] == double_refraction )
						{
							Laser_Mirror_Add( laser, k, links, kleur, 1 );
    						Laser_Mirror_Add( laser, k, rechts, kleur, 1 );
                			mirror_touch[k] = false;
						}
						else if( mirror_shape[k] == triple_refraction )
						{
							Laser_Mirror_Add( laser, k, onder, kleur, 1 );
							Laser_Mirror_Add( laser, k, rechts, kleur, 1 );
							Laser_Mirror_Add( laser, k, links, kleur, 1 );
							mirror_touch[k] = false;
						}
						else if( mirror_shape[k] == forward_refraction )
						{
						}
    				}
    				else if( rotate_mirrors[k] == 270 )
    				{
    					if( mirror_shape[k] == single_refraction )
						{
						}
						else if( mirror_shape[k] == double_refraction )
						{
							Laser_Mirror_Add( laser, k, onder, kleur, 1 );
    						Laser_Mirror_Add( laser, k, rechts, kleur, 1 );
                			mirror_touch[k] = false;
						}
						else if( mirror_shape[k] == triple_refraction )
						{
							Laser_Mirror_Add( laser, k, onder, kleur, 1 );
							Laser_Mirror_Add( laser, k, rechts, kleur, 1 );
							Laser_Mirror_Add( laser, k, links, kleur, 1 );
							mirror_touch[k] = false;
						}
						else if( mirror_shape[k] == forward_refraction )
						{
							Laser_Mirror_Add( laser, k, onder, kleur, 1 );
							mirror_touch[k] = false;
						}
    				}
    			
    	}
    	
    	if( laser.touched_mirror_right[k] == true && mirror_touch[k] )
    	{
    			
    				if( rotate_mirrors[k] == 0 )
    				{
    					if( mirror_shape[k] == single_refraction )
						{
						}
						else if( mirror_shape[k] == double_refraction )
						{
							Laser_Mirror_Add( laser, k, links, kleur, 1 );
    						Laser_Mirror_Add( laser, k, onder, kleur, 1 );
                			mirror_touch[k] = false;
						}
						else if( mirror_shape[k] == triple_refraction )
						{
							Laser_Mirror_Add( laser, k, onder, kleur, 1 );
							Laser_Mirror_Add( laser, k, boven, kleur, 1 );
							Laser_Mirror_Add( laser, k, links, kleur, 1 );
							mirror_touch[k] = false;
						}
						else if( mirror_shape[k] == forward_refraction )
						{
							Laser_Mirror_Add( laser, k, links, kleur, 1 );
							mirror_touch[k] = false;
						}
    				}
    				else if( rotate_mirrors[k] == 90 )
    				{
    					if( mirror_shape[k] == single_refraction )
						{
						}
						else if( mirror_shape[k] == double_refraction )
						{
						}
						else if( mirror_shape[k] == triple_refraction )
						{
							Laser_Mirror_Add( laser, k, onder, kleur, 1 );
							Laser_Mirror_Add( laser, k, boven, kleur, 1 );
							Laser_Mirror_Add( laser, k, links, kleur, 1 );
							mirror_touch[k] = false;
						}
						else if( mirror_shape[k] == forward_refraction )
						{
						}
    				}
    				else if( rotate_mirrors[k] == 180 )
    				{
    					if( mirror_shape[k] == single_refraction )
						{
    						Laser_Mirror_Add( laser, k, boven, kleur, 1 );
                			mirror_touch[k] = false;
						}
						else if( mirror_shape[k] == double_refraction )
						{
							Laser_Mirror_Add( laser, k, boven, kleur, 1 );
    						Laser_Mirror_Add( laser, k, links, kleur, 1 );
                			mirror_touch[k] = false;
						}
						else if( mirror_shape[k] == triple_refraction )
						{
							Laser_Mirror_Add( laser, k, onder, kleur, 1 );
							Laser_Mirror_Add( laser, k, boven, kleur, 1 );
							Laser_Mirror_Add( laser, k, links, kleur, 1 );
							mirror_touch[k] = false;
						}
						else if( mirror_shape[k] == forward_refraction )
						{
							Laser_Mirror_Add( laser, k, links, kleur, 1 );
							mirror_touch[k] = false;
						}
    				}
    				else if( rotate_mirrors[k] == 270 )
    				{
    					if ( mirror_shape[k] == single_refraction )
            			{
    						Laser_Mirror_Add( laser, k, onder, kleur, 1 );
                			mirror_touch[k] = false;
            			}
    					else if( mirror_shape[k] == double_refraction)
    					{
    						Laser_Mirror_Add( laser, k, onder, kleur, 1 );
    						Laser_Mirror_Add( laser, k, boven, kleur, 1 );
                			mirror_touch[k] = false;
    					}
    					else if( mirror_shape[k] == triple_refraction )
						{
							Laser_Mirror_Add( laser, k, onder, kleur, 1 );
							Laser_Mirror_Add( laser, k, boven, kleur, 1 );
							Laser_Mirror_Add( laser, k, links, kleur, 1 );
							mirror_touch[k] = false;
						}
    					else if( mirror_shape[k] == forward_refraction )
						{
						}
    				}
    	}
    }
	
	private void Change_Colour( Laser laser, int k )
    {
    	if( laser.touched_colour_changer_bottom[k] == true && colour_changer_touch[k] )
    	{
    		if( colour_changer_colour[k] == groen )
    		{
        			Laser_Mirror_Add( laser, k, boven, groen, 2 );

            		colour_changer_touch[k] = false;
    		}
    		else if( colour_changer_colour[k] == rood )
    		{
        			Laser_Mirror_Add( laser, k, boven, rood, 2 );
        			
            		colour_changer_touch[k] = false;
    		}
    		else if( colour_changer_colour[k] == geel )
    		{
    			Laser_Mirror_Add( laser, k, boven, geel, 2 );
    			
        		colour_changer_touch[k] = false;
    		}
    	}
    	
    	if( laser.touched_colour_changer_left[k] == true && colour_changer_touch[k] )
    	{
    		if( colour_changer_colour[k] == groen )
    		{
        			Laser_Mirror_Add( laser, k, rechts, groen, 2 );

            		colour_changer_touch[k] = false;
    		}
    		else if( colour_changer_colour[k] == rood )
    		{
        			Laser_Mirror_Add( laser, k, rechts, rood, 2 );
        			
            		colour_changer_touch[k] = false;
    		}
    		else if( colour_changer_colour[k] == geel )
    		{
    			Laser_Mirror_Add( laser, k, rechts, geel, 2 );
    			
        		colour_changer_touch[k] = false;
    		}
    	}
    	
    	if( laser.touched_colour_changer_top[k] == true && colour_changer_touch[k] )
    	{
    		if( colour_changer_colour[k] == groen )
    		{
        			Laser_Mirror_Add( laser, k, onder, groen, 2 );

            		colour_changer_touch[k] = false;
    		}
    		else if( colour_changer_colour[k] == rood )
    		{
        			Laser_Mirror_Add( laser, k, onder, rood, 2 );
        			
            		colour_changer_touch[k] = false;
    		}
    		else if( colour_changer_colour[k] == geel )
    		{
    			Laser_Mirror_Add( laser, k, onder, geel, 2 );
    			
        		colour_changer_touch[k] = false;
    		}
    	}
    	
    	if( laser.touched_colour_changer_right[k] == true && colour_changer_touch[k] )
    	{
    		if( colour_changer_colour[k] == groen )
    		{
        			Laser_Mirror_Add( laser, k, links, groen, 2 );

            		colour_changer_touch[k] = false;
    		}
    		else if( colour_changer_colour[k] == rood )
    		{
        			Laser_Mirror_Add( laser, k, links, rood, 2 );
        			
            		colour_changer_touch[k] = false;
    		}
    		else if( colour_changer_colour[k] == geel )
    		{
    			Laser_Mirror_Add( laser, k, links, geel, 2 );
    			
        		colour_changer_touch[k] = false;
    		}
    	}
    }
	
	
	private void Laser_Mirror_Add( Laser laser, int k, int richting, int kleur, int position )
    {
    	//naar links
		laser = new Laser();
		if( position == 1 )
		{
    		laser.position.set(mirrors.get(k).position.x, mirrors.get(k).position.y, 0);
		}
		else if( position == 2 )
		{
    		laser.position.set(colour_changers.get(k).position.x, colour_changers.get(k).position.y, 0);
		}
		
		if( kleur == groen )
		{
			green_lasers.add( laser );
		}
		else if( kleur == rood )
		{
			red_lasers.add( laser );
		}
		else if( kleur == geel )
		{
			yellow_lasers.add( laser );
		}
		
		if( richting == rechts )
		{
    		laser.direction( false, false );
		}
		else if( richting == links)
		{
    		laser.direction( false, true );
		}
		else if( richting == boven )
		{
			laser.direction( true, true );
		}
		else if( richting == onder )
		{
			laser.direction( true, false );
		}
		
    }
	
	
	
	public void Update_Energy()
    {
    	if ( laser_fired )
    	{
    		int radiation_tiles_on = 0;
    		
    		int number_laser_green = green_lasers.size();
    		int number_laser_red = red_lasers.size();
    		int number_laser_yellow = yellow_lasers.size();
    		
    		int number_lasers = ( number_laser_green + number_laser_red + number_laser_yellow );
    		
    		for( int i = 0; i <= number_of_radiation_tiles; i++ )
    		{
    			if( radiation_tile_touch[i] )
    			{
    				radiation_tiles_on += 1;
    			}
    		}
    		
    		if( radiation_tiles_on == number_of_radiation_tiles )
    		{
    			if ( number_lasers == 0 )
    			{
    				game_won = true;
    				laser_fired = false;
    			}
    		}
    		
    		if ( number_lasers == 0 )
    		{
    			
    			for( int k = 0; k < radiation_tile_touch.length; k++)
    			{
    				radiation_tile_touch[k] = false;
    			}
    			
    			for( int k = 0; k < mirror_touch.length; k++)
    			{
    				mirror_touch[k] = true;
    			}
    			
    			for( int k = 0; k < colour_changer_touch.length; k++ )
				{
					colour_changer_touch[k] = true;
				}
    			
				laser_fired = false;
    		}
    	}
    }
	
	
	
	public boolean[] radiation_tile_touch()
	{
		return radiation_tile_touch;
	}
	public ArrayList<Laser> green_lasers()
	{
		return green_lasers;
	}
	
	public ArrayList<Laser> red_lasers()
	{
		return red_lasers;
	}
	
	public ArrayList<Laser> yellow_lasers()
	{
		return yellow_lasers;
	}
	
	public boolean laser_fired()
	{
		return laser_fired;
	}
	
	public boolean game_won()
	{
		return game_won;
	}
}
