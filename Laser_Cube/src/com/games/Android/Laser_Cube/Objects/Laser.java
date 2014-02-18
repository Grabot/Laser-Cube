package com.games.Android.Laser_Cube.Objects;

import java.util.ArrayList;

import com.games.Android.Laser_Cube.Load.Vector;


public class Laser 
{
	private float level = 0;
	
	private float breedte =  85;
	private float hoogte = 45;
	
	public float laser_time_opening = 0.4f;
	public float laser_time_level1 = 1f;
	
	public float Speed = 2.5f;
	
	public Vector position = new Vector( );
	
	public boolean Weg = false;
	public boolean laser_weg = false;
	
	//up/down or left/right
	public boolean vertical = true;
	//when up/down up or down, when left/right left or right, true is up for up/down and left for left/right
	public boolean up_left = true;
	
	private float laser_y = 100;
	private float laser_x = 100;
	private float laser_y_end = 100;
	private float laser_x_end = 100;
	private float length_laser = 0;
	public float laser_size = 0f;
	
	
	private float[] distance_cube = new float[30];
	private float[] distance_mirror = new float[30];
	private float[] distance_block = new float[30];
	private float[] distance_radiation_tile = new float[30];
	private float[] distance_colour_changer = new float[30];
	
	
	private float distance_opening_tile = 100;
	
	public boolean touched_opening_tile = false;
	
	public boolean[] touched_radiation_tile = new boolean[30];
	public boolean[] touched_block = new boolean[30];
	
	//de 4 zijden van de mirrors
	public boolean[] touched_mirror_top = new boolean[30];
	public boolean[] touched_mirror_bottom = new boolean[30];
	public boolean[] touched_mirror_left = new boolean[30];
	public boolean[] touched_mirror_right = new boolean[30];
	
	public boolean[] touched_colour_changer_top = new boolean[30];
	public boolean[] touched_colour_changer_bottom = new boolean[30];
	public boolean[] touched_colour_changer_left = new boolean[30];
	public boolean[] touched_colour_changer_right = new boolean[30];

	private float stroom = 0;
	
	private int number_of_cubes = 0;
	private int number_of_mirrors = 0;
	private int number_of_radiation_tiles = 0;
	private int number_of_blocks = 0;
	private int number_of_colour_changers = 0;
	
	
	public void Level( ArrayList<Cube> cubes,  ArrayList<Mirror> mirrors, ArrayList<Radiation_Tile> radiation_tiles, ArrayList<Block> blocks, ArrayList<Colour_Changer> colour_changers )
	{
		reset_variabels();
		
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
		
		if( radiation_tiles == null )
		{
			number_of_radiation_tiles = 0;
		}
		else
		{
			number_of_radiation_tiles = ( radiation_tiles.size() - 1 );
		}
		
		if( blocks == null )
		{
			number_of_blocks = 0;
		}
		else
		{
			number_of_blocks = ( blocks.size() - 1 );
		}
	    
		if( colour_changers == null )
		{
			number_of_colour_changers = 0;
		}
		else
		{
			number_of_colour_changers = ( colour_changers.size() - 1 );
		}
		
		
		for( int i = 1; i <= number_of_cubes; i++ )
		{
			distance_cube[i] = cubes.get(i).position.distance( new Vector( laser_x, laser_y, 0 ));
		}
		
		for( int i = 1; i <= number_of_mirrors; i++ )
		{
			distance_mirror[i] = mirrors.get(i).position.distance( new Vector( laser_x, laser_y, 0 ));
		}
		
		for( int i = 1; i <= number_of_radiation_tiles; i++ )
		{
			distance_radiation_tile[i] = radiation_tiles.get(i).position.distance( new Vector( laser_x, laser_y, 0 ));
		}
		
		for( int i = 1; i <= number_of_blocks; i++ )
		{
			distance_block[i] = blocks.get(i).position.distance( new Vector( laser_x, laser_y, 0 ));
		}
		
		for( int i = 1; i <= number_of_colour_changers; i++ )
		{
			distance_colour_changer[i] = colour_changers.get(i).position.distance( new Vector( laser_x, laser_y, 0 ));
		}
		
		level = 1;
	}
	
	public void Opening_Screen( ArrayList<Mirror> mirrors )
	{
		reset_variabels();
		
		distance_mirror[1] = mirrors.get(1).position.distance( new Vector( laser_x, laser_y, 0));
		distance_mirror[2] = mirrors.get(2).position.distance( new Vector( laser_x, laser_y, 0));
		distance_mirror[3] = mirrors.get(3).position.distance( new Vector( laser_x, laser_y, 0));
		distance_mirror[4] = mirrors.get(4).position.distance( new Vector( laser_x, laser_y, 0));
		
		level = 8008;
	}
	
	
	
	private void reset_variabels()
	{
		for( int k = 0; k < 30; k++)
		{
			distance_mirror[k] = 100;
			distance_radiation_tile[k] = 100;
			distance_cube[k] = 100;
			distance_block[k] = 100;
			distance_colour_changer[k] = 100;
		}
	}
	
	public void direction (boolean vertical, boolean up_left)
	{
		this.vertical = vertical;
		this.up_left = up_left;
	}
	
	
	public void update()
	{
		
		//de laser gaat verticaal
		if( vertical )
		{
			laser_y = (position.y + (laser_size + laser_size));
			laser_y_end = ( position.y + laser_size );
			
			laser_x = position.x;
			
			length_laser = new Vector( laser_x, laser_y, 0).distance(new Vector(laser_x, laser_y_end, 0));
			//de laser gaat verticaal omhoog
			if ( up_left )
			{
				
				for( int i = 1; i < distance_cube.length; i++)
				{
					if( distance_cube[i] < 3 )
					{
						if(length_laser > 5)
						{
							Weg = true;
						}
					}
				}
				
				
				
				
				for( int i = 1; i < distance_mirror.length; i++)
				{
					if( distance_mirror[i] < 3)
					{
						touched_mirror_bottom[i] = true;
						
						if(length_laser > 5)
						{
							Weg = true;
						}
					}
					else
					{
						touched_mirror_bottom[i] = false;
					}
				}
				
				
				for( int i = 0; i < distance_radiation_tile.length; i++ )
				{
					if( distance_radiation_tile[i] < 3 )
					{
						touched_radiation_tile[i] = true;
					}
				}
				
				for( int i = 1; i < distance_colour_changer.length; i++)
				{
					if( distance_colour_changer[i] < 3)
					{
						touched_colour_changer_bottom[i] = true;
						
						if(length_laser > 5)
						{
							Weg = true;
						}
					}
					else
					{
						touched_colour_changer_bottom[i] = false;
					}
				}
				
				
				
				for( int i = 0; i < distance_block.length; i++ )
				{
					if( distance_block[i] < 3 )
					{
						touched_block[i] = true;
						
						if(length_laser > 5)
						{
							Weg = true;
						}
					}
				}
				
				
				
				
				
				if ( laser_y >= hoogte)
				{
					Weg = true;
				}
				else
				{
				}
				
				if ( Weg )
				{
				}
				else
				{
					laser_size += (1f * Speed);
				}
				
				if ( laser_y_end > laser_y )
				{
					laser_weg = true;
				}
				else
				{
					laser_weg = false;
				}
				
				
				
				if ( level == 8008 )
				{
					if( stroom > laser_time_opening )
					{
						position.y += (2f * Speed);
						laser_size -= (1f * Speed);
					}
					else
					{
						stroom += 0.01f;
					}
				}
				else
				{
					if( stroom > laser_time_level1 )
					{
						position.y += (2f * Speed);
						laser_size -= (1f * Speed);
					}
					else
					{
						stroom += 0.01f;
					}
				}
				
			}
			//de laser gaat verticaal omlaag
			else
			{
				
				
				for( int i = 0; i < distance_block.length; i++ )
				{
					if( distance_block[i] < 3 )
					{
						touched_block[i] = true;
						
						if(length_laser > 5)
						{
							Weg = true;
						}
						
					}
				}
				
				
				for( int i = 1; i < distance_cube.length; i++)
				{
					if( distance_cube[i] < 3 )
					{
						if(length_laser > 5)
						{
							Weg = true;
						}
					}
				}
				
				
				
				for( int i = 1; i < distance_mirror.length; i++)
				{
					if( distance_mirror[i] < 3)
					{
						touched_mirror_top[i] = true;
						
						if(length_laser > 5)
						{
							Weg = true;
						}
					}
					else
					{
						touched_mirror_top[i] = false;
					}
				}
				
				
				for( int i = 0; i < distance_radiation_tile.length; i++ )
				{
					if( distance_radiation_tile[i] < 3 )
					{
						touched_radiation_tile[i] = true;
					}
				}
				
				
				for( int i = 1; i < distance_colour_changer.length; i++)
				{
					if( distance_colour_changer[i] < 3)
					{
						touched_colour_changer_top[i] = true;
						
						if(length_laser > 5)
						{
							Weg = true;
						}
					}
					else
					{
						touched_colour_changer_top[i] = false;
					}
				}
				
				
				if ( laser_y <= -hoogte)
				{
					Weg = true;
				}
				else
				{
				}
				
				if ( Weg )
				{
				}
				else
				{
					laser_size -= (1f * Speed);
				}
				
				if ( laser_y_end < laser_y )
				{
					laser_weg = true;
				}
				else
				{
					laser_weg = false;
				}
				
				if ( level == 8008 )
				{
					if( stroom > laser_time_opening )
					{
						position.y -= (2f * Speed);
						laser_size += (1f * Speed);
					}
					else
					{
						stroom += 0.01f;
					}
				}
				else
				{
					if( stroom > laser_time_level1 )
					{
						position.y -= (2f * Speed);
						laser_size += (1f * Speed);
					}
					else
					{
						stroom += 0.01f;
					}
				}
			}
			//Log.d( " mirror ", " distance "  + laser_y );
		}
		
		else
		{
			laser_x = (position.x + (laser_size + laser_size));
			laser_x_end = ( position.x + laser_size );
			
			laser_y = position.y;
			
			length_laser = new Vector( laser_x, laser_y, 0).distance(new Vector(laser_x_end, laser_y, 0));
			//de laser gaat left (links)
			if( up_left )
			{
				
				
				for( int i = 0; i < distance_block.length; i++ )
				{
					if( distance_block[i] < 3 )
					{
						touched_block[i] = true;
						
						if(length_laser > 5)
						{
							Weg = true;
						}
					}
				}
				
				
				
				if (distance_opening_tile < 30 )
				{
					touched_opening_tile = true;
				}
				else
				{
					touched_opening_tile = false;
				}
				
				
				for( int i = 1; i < distance_cube.length; i++)
				{
					if( distance_cube[i] < 3 )
					{
						if(length_laser > 5)
						{
							Weg = true;
						}
					}
				}
				
				
				
				for( int i = 1; i < distance_mirror.length; i++)
				{
					if( distance_mirror[i] < 3)
					{
						touched_mirror_right[i] = true;
						
						if(length_laser > 5)
						{
							Weg = true;
						}
					}
					else
					{
						touched_mirror_right[i] = false;
					}
				}
				
				
				
				for( int i = 0; i < distance_radiation_tile.length; i++ )
				{
					if( distance_radiation_tile[i] < 3 )
					{
						touched_radiation_tile[i] = true;
					}
				}
				
				
				for( int i = 1; i < distance_colour_changer.length; i++)
				{
					if( distance_colour_changer[i] < 3)
					{
						touched_colour_changer_right[i] = true;
						
						if(length_laser > 5)
						{
							Weg = true;
						}
					}
					else
					{
						touched_colour_changer_right[i] = false;
					}
				}
				
				
				
				if ( laser_x >= breedte)
				{
					Weg = true;
				}
				else
				{
				}
				
				if ( Weg )
				{
				}
				else
				{
					laser_size += (1f * Speed);
				}
				
				if ( level == 8008 )
				{
					if( stroom > laser_time_opening )
					{
						position.x += (2f * Speed);
						laser_size -= (1f * Speed);
					}
					else
					{
						stroom += 0.01f;
					}
				}
				else
				{
					if( stroom > laser_time_level1 )
					{
						position.x += (2f * Speed);
						laser_size -= (1f * Speed);
					}
					else
					{
						stroom += 0.01f;
					}
					
				}
				
				if ( laser_x_end > laser_x )
				{
					laser_weg = true;
				}
				else
				{
					laser_weg = false;
				}
			}
			else
			{
				//de laser gaat naar rechts
				
				
				for( int i = 0; i < distance_block.length; i++ )
				{
					if( distance_block[i] < 3 )
					{
						touched_block[i] = true;
						
						if(length_laser > 5)
						{
							Weg = true;
						}
					}
				}
				
				
				for( int i = 1; i < distance_cube.length; i++)
				{
					if( distance_cube[i] < 3 )
					{
						if(length_laser > 5)
						{
							Weg = true;
						}
					}
				}
				
				
				for( int i = 1; i < distance_mirror.length; i++)
				{
					if( distance_mirror[i] < 3)
					{
						touched_mirror_left[i] = true;
						
						if(length_laser > 5)
						{
							Weg = true;
						}
					}
					else
					{
						touched_mirror_left[i] = false;
					}
				}
				
				
				for( int i = 0; i < distance_radiation_tile.length; i++ )
				{
					if( distance_radiation_tile[i] < 3 )
					{
						touched_radiation_tile[i] = true;
					}
				}
				
				for( int i = 1; i < distance_colour_changer.length; i++)
				{
					if( distance_colour_changer[i] < 3)
					{
						touched_colour_changer_left[i] = true;
						
						if(length_laser > 5)
						{
							Weg = true;
						}
					}
					else
					{
						touched_colour_changer_left[i] = false;
					}
				}
				
				
				
				if ( laser_x <= -breedte)
				{
					Weg = true;
				}
				else
				{
				}
				
				if ( Weg )
				{
				}
				else
				{
					laser_size -= (1f * Speed);
				}
				
				if ( level == 8008 )
				{
					if( stroom > laser_time_opening )
					{
						position.x -= (2f * Speed);
						laser_size += (1f * Speed);
					}
					else
					{
						stroom += 0.01f;
					}
					
				}
				else
				{
					if( stroom > laser_time_level1 )
					{
						position.x -= (2f * Speed);
						laser_size += (1f * Speed);
					}
					else
					{
						stroom += 0.01f;
					}
					
				}
				
				if ( laser_x_end < laser_x )
				{
					laser_weg = true;
				}
				else
				{
					laser_weg = false;
				}
			}
			
		}
		//Log.d( " mirror ", " distance "  + laser_y);
	}
	
	
	
}