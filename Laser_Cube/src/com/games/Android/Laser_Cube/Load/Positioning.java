package com.games.Android.Laser_Cube.Load;

import java.util.ArrayList;

import com.games.Android.Laser_Cube.Objects.Block;
import com.games.Android.Laser_Cube.Objects.Colour_Changer;
import com.games.Android.Laser_Cube.Objects.Cube;
import com.games.Android.Laser_Cube.Objects.Mirror;
import com.games.Android.Laser_Cube.Objects.Radiation_Tile;

public class Positioning 
{

	public Positioning()
	{
		
	}
	
	public void Cubes_Grid( int cube, boolean touched_down, ArrayList<Cube> cubes, ArrayList<Mirror> mirrors, ArrayList<Radiation_Tile> radiation_tiles, ArrayList<Block> blocks, ArrayList<Colour_Changer> colour_changers )
    {
    	

		int number_of_cubes = 0;
		int number_of_mirrors = 0;
		int number_of_radiation_tiles = 0;
		int number_of_blocks = 0;
		int number_of_colour_changers = 0;
		
		
		if( cubes == null )
		{
			number_of_cubes = 0;
		}
		else
		{
			number_of_cubes = ( cubes.size() - 1 );
		}
		
		if( mirrors == null )
		{
			number_of_mirrors = 0;
		}
		else
		{
			number_of_mirrors = ( mirrors.size() - 1 );
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
		
		
    	if( cubes.get(cube) == null )
		{
		}
		else if( !touched_down )
		{
			for( int i = -80; i <= 80; i += 10)
			{
				if( (cubes.get(cube).position.x > i && cubes.get(cube).position.x < (i + 5) ) || (cubes.get(cube).position.x < i && cubes.get(cube).position.x > (i - 5) ) )
				{
					cubes.get(cube).position.x = i;
				}
			}
		
    		for( int l = -40; l <= 40; l += 10)
    		{
    			if( (cubes.get(cube).position.y > l && cubes.get(cube).position.y < (l + 5) ) || (cubes.get(cube).position.y < l && cubes.get(cube).position.y > (l - 5) ) )
    			{
    				cubes.get(cube).position.y = l;
    			}
    		}
    		
    		
    		for( int k = 1; k <= number_of_cubes; k++ )
    		{
    			if( cube != k )
    			{
    				if( cubes.get(cube).update_obstakel_cube( cubes.get(k) ))
	    			{
    					if( (cubes.get(cube).position.x == -80) && (cubes.get(cube).position.y != 40 && cubes.get(cube).position.y != -20) )
	    				{
    						int random = ((int) (Math.random() * 3));
    						
    						if( random == 0 )
	    					{
	    						cubes.get(cube).position.y += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						cubes.get(cube).position.y -= 10;
	    					}
	    					else
	    					{
	    						cubes.get(cube).position.x += 10;
	    					}
    						
	    				}
	    				else if( (cubes.get(cube).position.x == 80) && (cubes.get(cube).position.y != 30 && cubes.get(cube).position.y != -40) )
	    				{
	    					int random = ((int) (Math.random() * 3));
    						
    						if( random == 0 )
	    					{
	    						cubes.get(cube).position.y += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						cubes.get(cube).position.y -= 10;
	    					}
	    					else
	    					{
	    						cubes.get(cube).position.x -= 10;
	    					}
	    				}
	    				else if( (cubes.get(cube).position.y == 40) && (cubes.get(cube).position.x != 70 && cubes.get(cube).position.x != -80) )
	    				{
	    					int random = ((int) (Math.random() * 3));
    						
    						if( random == 0 )
	    					{
	    						cubes.get(cube).position.y -= 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						cubes.get(cube).position.x -= 10;
	    					}
	    					else
	    					{
	    						cubes.get(cube).position.x += 10;
	    					}
	    				}
	    				else if( (cubes.get(cube).position.y == -40) && (cubes.get(cube).position.x != -60 && cubes.get(cube).position.x != 80) )
	    				{
	    					int random = ((int) (Math.random() * 3));
    						
    						if( random == 0 )
	    					{
	    						cubes.get(cube).position.y += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						cubes.get(cube).position.x -= 10;
	    					}
	    					else
	    					{
	    						cubes.get(cube).position.x += 10;
	    					}
	    				}
	    				else if( cubes.get(cube).position.x == -80 && cubes.get(cube).position.y == 40)
	    				{
	    					int random = ((int) (Math.random() * 2));
    						
    						if( random == 0 )
	    					{
	    						cubes.get(cube).position.y -= 10;
	    					}
	    					else
	    					{
	    						cubes.get(cube).position.x += 10;
	    					}
	    				}
	    				else if( cubes.get(cube).position.x == 80 && cubes.get(cube).position.y == -40 )
	    				{
	    					int random = ((int) (Math.random() * 2));
    						
    						if( random == 0 )
	    					{
	    						cubes.get(cube).position.y += 10;
	    					}
	    					else
	    					{
	    						cubes.get(cube).position.x -= 10;
	    					}
	    				}
	    				else if( cubes.get(cube).position.x == -80 && cubes.get(cube).position.y == -20)
	    				{
	    					int random = ((int) (Math.random() * 2));
    						
    						if( random == 0 )
	    					{
	    						cubes.get(cube).position.y += 10;
	    					}
	    					else
	    					{
	    						cubes.get(cube).position.x += 10;
	    					}
	    				}
	    				else if( cubes.get(cube).position.x == -70 && cubes.get(cube).position.y == -20 )
	    				{
	    					int random = ((int) (Math.random() * 3));
	    					
	    					if( random == 0 )
	    					{
	    						cubes.get(cube).position.y += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						cubes.get(cube).position.x += 10;
	    					}
	    					else
	    					{
	    						cubes.get(cube).position.x -= 10;
	    					}
	    				}
	    				else if( cubes.get(cube).position.x == -60 && cubes.get(cube).position.y == -30 )
	    				{
	    					int random = ((int) (Math.random() * 3));
	    					
	    					if( random == 0 )
	    					{
	    						cubes.get(cube).position.x += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						cubes.get(cube).position.y -= 10;
	    					}
	    					else
	    					{
	    						cubes.get(cube).position.y += 10;
	    					}
	    				}
	    				else if( cubes.get(cube).position.x == -60 && cubes.get(cube).position.y == -40 )
	    				{
	    					int random = ((int) (Math.random() * 2));
	    					
	    					if( random == 0 )
	    					{
	    						cubes.get(cube).position.y += 10;
	    					}
	    					else
	    					{
	    						cubes.get(cube).position.x += 10;
	    					}
	    				}
	    				else if( cubes.get(cube).position.x == 70 && cubes.get(cube).position.y == 40 )
	    				{
	    					int random = ((int) (Math.random() * 2));
	    					
	    					if( random == 0 )
	    					{
	    						cubes.get(cube).position.y -= 10;
	    					}
	    					else
	    					{
	    						cubes.get(cube).position.x -= 10;
	    					}
	    				}
	    				else if( cubes.get(cube).position.x == 80 && cubes.get(cube).position.y == 30 )
	    				{
	    					int random = ((int) (Math.random() * 2));
	    					
	    					if( random == 0 )
	    					{
	    						cubes.get(cube).position.y -= 10;
	    					}
	    					else
	    					{
	    						cubes.get(cube).position.x -= 10;
	    					}
	    				}
	    				else
	    				{
	    					int random = ((int) (Math.random() * 4));
	    					
	    					if( random == 0 )
	    					{
	    						cubes.get(cube).position.y += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						cubes.get(cube).position.y -= 10;
	    					}
	    					else if( random == 2 )
	    					{
	    						cubes.get(cube).position.x += 10;
	    					}
	    					else if( random == 3 )
	    					{
	    						cubes.get(cube).position.x -= 10;
	    					}
	    				}
    					
	    				Cubes_Grid( cube, touched_down, cubes, mirrors, radiation_tiles, blocks, colour_changers );
	    			}
	    			
    			}
    		}
    		
    		for( int k = 1; k <= number_of_mirrors; k++ )
    		{
    				if( cubes.get(cube).update_obstakel_mirror( mirrors.get(k) ))
	    			{
    					if( (cubes.get(cube).position.x == -80) && (cubes.get(cube).position.y != 40 && cubes.get(cube).position.y != -20) )
	    				{
    						int random = ((int) (Math.random() * 3));
    						
    						if( random == 0 )
	    					{
	    						cubes.get(cube).position.y += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						cubes.get(cube).position.y -= 10;
	    					}
	    					else
	    					{
	    						cubes.get(cube).position.x += 10;
	    					}
    						
	    				}
	    				else if( (cubes.get(cube).position.x == 80) && (cubes.get(cube).position.y != 30 && cubes.get(cube).position.y != -40) )
	    				{
	    					int random = ((int) (Math.random() * 3));
    						
    						if( random == 0 )
	    					{
	    						cubes.get(cube).position.y += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						cubes.get(cube).position.y -= 10;
	    					}
	    					else
	    					{
	    						cubes.get(cube).position.x -= 10;
	    					}
	    				}
	    				else if( (cubes.get(cube).position.y == 40) && (cubes.get(cube).position.x != 70 && cubes.get(cube).position.x != -80) )
	    				{
	    					int random = ((int) (Math.random() * 3));
    						
    						if( random == 0 )
	    					{
	    						cubes.get(cube).position.y -= 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						cubes.get(cube).position.x -= 10;
	    					}
	    					else
	    					{
	    						cubes.get(cube).position.x += 10;
	    					}
	    				}
	    				else if( (cubes.get(cube).position.y == -40) && (cubes.get(cube).position.x != -60 && cubes.get(cube).position.x != 80) )
	    				{
	    					int random = ((int) (Math.random() * 3));
    						
    						if( random == 0 )
	    					{
	    						cubes.get(cube).position.y += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						cubes.get(cube).position.x -= 10;
	    					}
	    					else
	    					{
	    						cubes.get(cube).position.x += 10;
	    					}
	    				}
	    				else if( cubes.get(cube).position.x == -80 && cubes.get(cube).position.y == 40)
	    				{
	    					int random = ((int) (Math.random() * 2));
    						
    						if( random == 0 )
	    					{
	    						cubes.get(cube).position.y -= 10;
	    					}
	    					else
	    					{
	    						cubes.get(cube).position.x += 10;
	    					}
	    				}
	    				else if( cubes.get(cube).position.x == 80 && cubes.get(cube).position.y == -40 )
	    				{
	    					int random = ((int) (Math.random() * 2));
    						
    						if( random == 0 )
	    					{
	    						cubes.get(cube).position.y += 10;
	    					}
	    					else
	    					{
	    						cubes.get(cube).position.x -= 10;
	    					}
	    				}
	    				else if( cubes.get(cube).position.x == -80 && cubes.get(cube).position.y == -20)
	    				{
	    					int random = ((int) (Math.random() * 2));
    						
    						if( random == 0 )
	    					{
	    						cubes.get(cube).position.y += 10;
	    					}
	    					else
	    					{
	    						cubes.get(cube).position.x += 10;
	    					}
	    				}
	    				else if( cubes.get(cube).position.x == -70 && cubes.get(cube).position.y == -20 )
	    				{
	    					int random = ((int) (Math.random() * 3));
	    					
	    					if( random == 0 )
	    					{
	    						cubes.get(cube).position.y += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						cubes.get(cube).position.x += 10;
	    					}
	    					else
	    					{
	    						cubes.get(cube).position.x -= 10;
	    					}
	    				}
	    				else if( cubes.get(cube).position.x == -60 && cubes.get(cube).position.y == -30 )
	    				{
	    					int random = ((int) (Math.random() * 3));
	    					
	    					if( random == 0 )
	    					{
	    						cubes.get(cube).position.x += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						cubes.get(cube).position.y -= 10;
	    					}
	    					else
	    					{
	    						cubes.get(cube).position.y += 10;
	    					}
	    				}
	    				else if( cubes.get(cube).position.x == -60 && cubes.get(cube).position.y == -40 )
	    				{
	    					int random = ((int) (Math.random() * 2));
	    					
	    					if( random == 0 )
	    					{
	    						cubes.get(cube).position.y += 10;
	    					}
	    					else
	    					{
	    						cubes.get(cube).position.x += 10;
	    					}
	    				}
	    				else if( cubes.get(cube).position.x == 70 && cubes.get(cube).position.y == 40 )
	    				{
	    					int random = ((int) (Math.random() * 2));
	    					
	    					if( random == 0 )
	    					{
	    						cubes.get(cube).position.y -= 10;
	    					}
	    					else
	    					{
	    						cubes.get(cube).position.x -= 10;
	    					}
	    				}
	    				else if( cubes.get(cube).position.x == 80 && cubes.get(cube).position.y == 30 )
	    				{
	    					int random = ((int) (Math.random() * 2));
	    					
	    					if( random == 0 )
	    					{
	    						cubes.get(cube).position.y -= 10;
	    					}
	    					else
	    					{
	    						cubes.get(cube).position.x -= 10;
	    					}
	    				}
	    				else
	    				{
	    					int random = ((int) (Math.random() * 4));
	    					
	    					if( random == 0 )
	    					{
	    						cubes.get(cube).position.y += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						cubes.get(cube).position.y -= 10;
	    					}
	    					else if( random == 2 )
	    					{
	    						cubes.get(cube).position.x += 10;
	    					}
	    					else if( random == 3 )
	    					{
	    						cubes.get(cube).position.x -= 10;
	    					}
	    				}
    					
	    				Cubes_Grid( cube, touched_down, cubes, mirrors, radiation_tiles, blocks, colour_changers );
	    			}
	    			
    		}
    		
    		
    		for( int k = 1; k <= number_of_radiation_tiles; k++ )
    		{
    				if( cubes.get(cube).update_obstakel_radiation_tile( radiation_tiles.get(k) ))
	    			{
    					if( (cubes.get(cube).position.x == -80) && (cubes.get(cube).position.y != 40 && cubes.get(cube).position.y != -20) )
	    				{
    						int random = ((int) (Math.random() * 3));
    						
    						if( random == 0 )
	    					{
	    						cubes.get(cube).position.y += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						cubes.get(cube).position.y -= 10;
	    					}
	    					else
	    					{
	    						cubes.get(cube).position.x += 10;
	    					}
    						
	    				}
	    				else if( (cubes.get(cube).position.x == 80) && (cubes.get(cube).position.y != 30 && cubes.get(cube).position.y != -40) )
	    				{
	    					int random = ((int) (Math.random() * 3));
    						
    						if( random == 0 )
	    					{
	    						cubes.get(cube).position.y += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						cubes.get(cube).position.y -= 10;
	    					}
	    					else
	    					{
	    						cubes.get(cube).position.x -= 10;
	    					}
	    				}
	    				else if( (cubes.get(cube).position.y == 40) && (cubes.get(cube).position.x != 70 && cubes.get(cube).position.x != -80) )
	    				{
	    					int random = ((int) (Math.random() * 3));
    						
    						if( random == 0 )
	    					{
	    						cubes.get(cube).position.y -= 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						cubes.get(cube).position.x -= 10;
	    					}
	    					else
	    					{
	    						cubes.get(cube).position.x += 10;
	    					}
	    				}
	    				else if( (cubes.get(cube).position.y == -40) && (cubes.get(cube).position.x != -60 && cubes.get(cube).position.x != 80) )
	    				{
	    					int random = ((int) (Math.random() * 3));
    						
    						if( random == 0 )
	    					{
	    						cubes.get(cube).position.y += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						cubes.get(cube).position.x -= 10;
	    					}
	    					else
	    					{
	    						cubes.get(cube).position.x += 10;
	    					}
	    				}
	    				else if( cubes.get(cube).position.x == -80 && cubes.get(cube).position.y == 40)
	    				{
	    					int random = ((int) (Math.random() * 2));
    						
    						if( random == 0 )
	    					{
	    						cubes.get(cube).position.y -= 10;
	    					}
	    					else
	    					{
	    						cubes.get(cube).position.x += 10;
	    					}
	    				}
	    				else if( cubes.get(cube).position.x == 80 && cubes.get(cube).position.y == -40 )
	    				{
	    					int random = ((int) (Math.random() * 2));
    						
    						if( random == 0 )
	    					{
	    						cubes.get(cube).position.y += 10;
	    					}
	    					else
	    					{
	    						cubes.get(cube).position.x -= 10;
	    					}
	    				}
	    				else if( cubes.get(cube).position.x == -80 && cubes.get(cube).position.y == -20)
	    				{
	    					int random = ((int) (Math.random() * 2));
    						
    						if( random == 0 )
	    					{
	    						cubes.get(cube).position.y += 10;
	    					}
	    					else
	    					{
	    						cubes.get(cube).position.x += 10;
	    					}
	    				}
	    				else if( cubes.get(cube).position.x == -70 && cubes.get(cube).position.y == -20 )
	    				{
	    					int random = ((int) (Math.random() * 3));
	    					
	    					if( random == 0 )
	    					{
	    						cubes.get(cube).position.y += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						cubes.get(cube).position.x += 10;
	    					}
	    					else
	    					{
	    						cubes.get(cube).position.x -= 10;
	    					}
	    				}
	    				else if( cubes.get(cube).position.x == -60 && cubes.get(cube).position.y == -30 )
	    				{
	    					int random = ((int) (Math.random() * 3));
	    					
	    					if( random == 0 )
	    					{
	    						cubes.get(cube).position.x += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						cubes.get(cube).position.y -= 10;
	    					}
	    					else
	    					{
	    						cubes.get(cube).position.y += 10;
	    					}
	    				}
	    				else if( cubes.get(cube).position.x == -60 && cubes.get(cube).position.y == -40 )
	    				{
	    					int random = ((int) (Math.random() * 2));
	    					
	    					if( random == 0 )
	    					{
	    						cubes.get(cube).position.y += 10;
	    					}
	    					else
	    					{
	    						cubes.get(cube).position.x += 10;
	    					}
	    				}
	    				else if( cubes.get(cube).position.x == 70 && cubes.get(cube).position.y == 40 )
	    				{
	    					int random = ((int) (Math.random() * 2));
	    					
	    					if( random == 0 )
	    					{
	    						cubes.get(cube).position.y -= 10;
	    					}
	    					else
	    					{
	    						cubes.get(cube).position.x -= 10;
	    					}
	    				}
	    				else if( cubes.get(cube).position.x == 80 && cubes.get(cube).position.y == 30 )
	    				{
	    					int random = ((int) (Math.random() * 2));
	    					
	    					if( random == 0 )
	    					{
	    						cubes.get(cube).position.y -= 10;
	    					}
	    					else
	    					{
	    						cubes.get(cube).position.x -= 10;
	    					}
	    				}
	    				else
	    				{
	    					int random = ((int) (Math.random() * 4));
	    					
	    					if( random == 0 )
	    					{
	    						cubes.get(cube).position.y += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						cubes.get(cube).position.y -= 10;
	    					}
	    					else if( random == 2 )
	    					{
	    						cubes.get(cube).position.x += 10;
	    					}
	    					else if( random == 3 )
	    					{
	    						cubes.get(cube).position.x -= 10;
	    					}
	    				}
    					
	    				Cubes_Grid( cube, touched_down, cubes, mirrors, radiation_tiles, blocks, colour_changers );
	    			}
	    			
    		}
    		
    		
    		for( int k = 1; k <= number_of_blocks; k++ )
    		{
    				if( cubes.get(cube).update_obstakel_block( blocks.get(k) ))
	    			{
    					if( (cubes.get(cube).position.x == -80) && (cubes.get(cube).position.y != 40 && cubes.get(cube).position.y != -20) )
	    				{
    						int random = ((int) (Math.random() * 3));
    						
    						if( random == 0 )
	    					{
	    						cubes.get(cube).position.y += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						cubes.get(cube).position.y -= 10;
	    					}
	    					else
	    					{
	    						cubes.get(cube).position.x += 10;
	    					}
    						
	    				}
	    				else if( (cubes.get(cube).position.x == 80) && (cubes.get(cube).position.y != 30 && cubes.get(cube).position.y != -40) )
	    				{
	    					int random = ((int) (Math.random() * 3));
    						
    						if( random == 0 )
	    					{
	    						cubes.get(cube).position.y += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						cubes.get(cube).position.y -= 10;
	    					}
	    					else
	    					{
	    						cubes.get(cube).position.x -= 10;
	    					}
	    				}
	    				else if( (cubes.get(cube).position.y == 40) && (cubes.get(cube).position.x != 70 && cubes.get(cube).position.x != -80) )
	    				{
	    					int random = ((int) (Math.random() * 3));
    						
    						if( random == 0 )
	    					{
	    						cubes.get(cube).position.y -= 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						cubes.get(cube).position.x -= 10;
	    					}
	    					else
	    					{
	    						cubes.get(cube).position.x += 10;
	    					}
	    				}
	    				else if( (cubes.get(cube).position.y == -40) && (cubes.get(cube).position.x != -60 && cubes.get(cube).position.x != 80) )
	    				{
	    					int random = ((int) (Math.random() * 3));
    						
    						if( random == 0 )
	    					{
	    						cubes.get(cube).position.y += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						cubes.get(cube).position.x -= 10;
	    					}
	    					else
	    					{
	    						cubes.get(cube).position.x += 10;
	    					}
	    				}
	    				else if( cubes.get(cube).position.x == -80 && cubes.get(cube).position.y == 40)
	    				{
	    					int random = ((int) (Math.random() * 2));
    						
    						if( random == 0 )
	    					{
	    						cubes.get(cube).position.y -= 10;
	    					}
	    					else
	    					{
	    						cubes.get(cube).position.x += 10;
	    					}
	    				}
	    				else if( cubes.get(cube).position.x == 80 && cubes.get(cube).position.y == -40 )
	    				{
	    					int random = ((int) (Math.random() * 2));
    						
    						if( random == 0 )
	    					{
	    						cubes.get(cube).position.y += 10;
	    					}
	    					else
	    					{
	    						cubes.get(cube).position.x -= 10;
	    					}
	    				}
	    				else if( cubes.get(cube).position.x == -80 && cubes.get(cube).position.y == -20)
	    				{
	    					int random = ((int) (Math.random() * 2));
    						
    						if( random == 0 )
	    					{
	    						cubes.get(cube).position.y += 10;
	    					}
	    					else
	    					{
	    						cubes.get(cube).position.x += 10;
	    					}
	    				}
	    				else if( cubes.get(cube).position.x == -70 && cubes.get(cube).position.y == -20 )
	    				{
	    					int random = ((int) (Math.random() * 3));
	    					
	    					if( random == 0 )
	    					{
	    						cubes.get(cube).position.y += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						cubes.get(cube).position.x += 10;
	    					}
	    					else
	    					{
	    						cubes.get(cube).position.x -= 10;
	    					}
	    				}
	    				else if( cubes.get(cube).position.x == -60 && cubes.get(cube).position.y == -30 )
	    				{
	    					int random = ((int) (Math.random() * 3));
	    					
	    					if( random == 0 )
	    					{
	    						cubes.get(cube).position.x += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						cubes.get(cube).position.y -= 10;
	    					}
	    					else
	    					{
	    						cubes.get(cube).position.y += 10;
	    					}
	    				}
	    				else if( cubes.get(cube).position.x == -60 && cubes.get(cube).position.y == -40 )
	    				{
	    					int random = ((int) (Math.random() * 2));
	    					
	    					if( random == 0 )
	    					{
	    						cubes.get(cube).position.y += 10;
	    					}
	    					else
	    					{
	    						cubes.get(cube).position.x += 10;
	    					}
	    				}
	    				else if( cubes.get(cube).position.x == 70 && cubes.get(cube).position.y == 40 )
	    				{
	    					int random = ((int) (Math.random() * 2));
	    					
	    					if( random == 0 )
	    					{
	    						cubes.get(cube).position.y -= 10;
	    					}
	    					else
	    					{
	    						cubes.get(cube).position.x -= 10;
	    					}
	    				}
	    				else if( cubes.get(cube).position.x == 80 && cubes.get(cube).position.y == 30 )
	    				{
	    					int random = ((int) (Math.random() * 2));
	    					
	    					if( random == 0 )
	    					{
	    						cubes.get(cube).position.y -= 10;
	    					}
	    					else
	    					{
	    						cubes.get(cube).position.x -= 10;
	    					}
	    				}
	    				else
	    				{
	    					int random = ((int) (Math.random() * 4));
	    					
	    					if( random == 0 )
	    					{
	    						cubes.get(cube).position.y += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						cubes.get(cube).position.y -= 10;
	    					}
	    					else if( random == 2 )
	    					{
	    						cubes.get(cube).position.x += 10;
	    					}
	    					else if( random == 3 )
	    					{
	    						cubes.get(cube).position.x -= 10;
	    					}
	    				}
    					
	    				Cubes_Grid( cube, touched_down, cubes, mirrors, radiation_tiles, blocks, colour_changers );
	    			}
	    			
    		}
    		
    		
    		for( int k = 1; k <= number_of_colour_changers; k++ )
    		{
    				if( cubes.get(cube).update_obstakel_colour_changer( colour_changers.get(k) ))
	    			{
    					if( (cubes.get(cube).position.x == -80) && (cubes.get(cube).position.y != 40 && cubes.get(cube).position.y != -20) )
	    				{
    						int random = ((int) (Math.random() * 3));
    						
    						if( random == 0 )
	    					{
	    						cubes.get(cube).position.y += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						cubes.get(cube).position.y -= 10;
	    					}
	    					else
	    					{
	    						cubes.get(cube).position.x += 10;
	    					}
    						
	    				}
	    				else if( (cubes.get(cube).position.x == 80) && (cubes.get(cube).position.y != 30 && cubes.get(cube).position.y != -40) )
	    				{
	    					int random = ((int) (Math.random() * 3));
    						
    						if( random == 0 )
	    					{
	    						cubes.get(cube).position.y += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						cubes.get(cube).position.y -= 10;
	    					}
	    					else
	    					{
	    						cubes.get(cube).position.x -= 10;
	    					}
	    				}
	    				else if( (cubes.get(cube).position.y == 40) && (cubes.get(cube).position.x != 70 && cubes.get(cube).position.x != -80) )
	    				{
	    					int random = ((int) (Math.random() * 3));
    						
    						if( random == 0 )
	    					{
	    						cubes.get(cube).position.y -= 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						cubes.get(cube).position.x -= 10;
	    					}
	    					else
	    					{
	    						cubes.get(cube).position.x += 10;
	    					}
	    				}
	    				else if( (cubes.get(cube).position.y == -40) && (cubes.get(cube).position.x != -60 && cubes.get(cube).position.x != 80) )
	    				{
	    					int random = ((int) (Math.random() * 3));
    						
    						if( random == 0 )
	    					{
	    						cubes.get(cube).position.y += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						cubes.get(cube).position.x -= 10;
	    					}
	    					else
	    					{
	    						cubes.get(cube).position.x += 10;
	    					}
	    				}
	    				else if( cubes.get(cube).position.x == -80 && cubes.get(cube).position.y == 40)
	    				{
	    					int random = ((int) (Math.random() * 2));
    						
    						if( random == 0 )
	    					{
	    						cubes.get(cube).position.y -= 10;
	    					}
	    					else
	    					{
	    						cubes.get(cube).position.x += 10;
	    					}
	    				}
	    				else if( cubes.get(cube).position.x == 80 && cubes.get(cube).position.y == -40 )
	    				{
	    					int random = ((int) (Math.random() * 2));
    						
    						if( random == 0 )
	    					{
	    						cubes.get(cube).position.y += 10;
	    					}
	    					else
	    					{
	    						cubes.get(cube).position.x -= 10;
	    					}
	    				}
	    				else if( cubes.get(cube).position.x == -80 && cubes.get(cube).position.y == -20)
	    				{
	    					int random = ((int) (Math.random() * 2));
    						
    						if( random == 0 )
	    					{
	    						cubes.get(cube).position.y += 10;
	    					}
	    					else
	    					{
	    						cubes.get(cube).position.x += 10;
	    					}
	    				}
	    				else if( cubes.get(cube).position.x == -70 && cubes.get(cube).position.y == -20 )
	    				{
	    					int random = ((int) (Math.random() * 3));
	    					
	    					if( random == 0 )
	    					{
	    						cubes.get(cube).position.y += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						cubes.get(cube).position.x += 10;
	    					}
	    					else
	    					{
	    						cubes.get(cube).position.x -= 10;
	    					}
	    				}
	    				else if( cubes.get(cube).position.x == -60 && cubes.get(cube).position.y == -30 )
	    				{
	    					int random = ((int) (Math.random() * 3));
	    					
	    					if( random == 0 )
	    					{
	    						cubes.get(cube).position.x += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						cubes.get(cube).position.y -= 10;
	    					}
	    					else
	    					{
	    						cubes.get(cube).position.y += 10;
	    					}
	    				}
	    				else if( cubes.get(cube).position.x == -60 && cubes.get(cube).position.y == -40 )
	    				{
	    					int random = ((int) (Math.random() * 2));
	    					
	    					if( random == 0 )
	    					{
	    						cubes.get(cube).position.y += 10;
	    					}
	    					else
	    					{
	    						cubes.get(cube).position.x += 10;
	    					}
	    				}
	    				else if( cubes.get(cube).position.x == 70 && cubes.get(cube).position.y == 40 )
	    				{
	    					int random = ((int) (Math.random() * 2));
	    					
	    					if( random == 0 )
	    					{
	    						cubes.get(cube).position.y -= 10;
	    					}
	    					else
	    					{
	    						cubes.get(cube).position.x -= 10;
	    					}
	    				}
	    				else if( cubes.get(cube).position.x == 80 && cubes.get(cube).position.y == 30 )
	    				{
	    					int random = ((int) (Math.random() * 2));
	    					
	    					if( random == 0 )
	    					{
	    						cubes.get(cube).position.y -= 10;
	    					}
	    					else
	    					{
	    						cubes.get(cube).position.x -= 10;
	    					}
	    				}
	    				else
	    				{
	    					int random = ((int) (Math.random() * 4));
	    					
	    					if( random == 0 )
	    					{
	    						cubes.get(cube).position.y += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						cubes.get(cube).position.y -= 10;
	    					}
	    					else if( random == 2 )
	    					{
	    						cubes.get(cube).position.x += 10;
	    					}
	    					else if( random == 3 )
	    					{
	    						cubes.get(cube).position.x -= 10;
	    					}
	    				}
    					
	    				Cubes_Grid( cube, touched_down, cubes, mirrors, radiation_tiles, blocks, colour_changers );
	    			}
	    			
    		}

		}
    }
	
	
	
	
	public void Mirrors_Grid( int mirror, boolean touched_down, ArrayList<Cube> cubes, ArrayList<Mirror> mirrors, ArrayList<Radiation_Tile> radiation_tiles, ArrayList<Block> blocks, ArrayList<Colour_Changer> colour_changers )
    {
		
		
		int number_of_cubes = 0;
		int number_of_mirrors = 0;
		int number_of_radiation_tiles = 0;
		int number_of_blocks = 0;
		int number_of_colour_changers = 0;
		
		if( cubes == null )
		{
			number_of_cubes = 0;
		}
		else
		{
			number_of_cubes = ( cubes.size() - 1 );
		}
		
		if( mirrors == null )
		{
			number_of_mirrors = 0;
		}
		else
		{
			number_of_mirrors = ( mirrors.size() - 1 );
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
    	
    	if( mirrors.get(mirror) == null )
		{
		}
		else if( !touched_down )
		{
			for( int i = -80; i <= 80; i += 10)
			{
				if( (mirrors.get(mirror).position.x > i && mirrors.get(mirror).position.x < (i + 5) ) || (mirrors.get(mirror).position.x < i && mirrors.get(mirror).position.x > (i - 5) ) )
				{
					mirrors.get(mirror).position.x = i;
				}
			}
		
    		for( int l = -40; l <= 40; l += 10)
    		{
    			if( (mirrors.get(mirror).position.y > l && mirrors.get(mirror).position.y < (l + 5) ) || (mirrors.get(mirror).position.y < l && mirrors.get(mirror).position.y > (l - 5) ) )
    			{
    				mirrors.get(mirror).position.y = l;
    			}
    		}
    		
    		
    		for( int k = 1; k <= number_of_mirrors; k++ )
    		{
    			if( mirror != k )
    			{
    				if( mirrors.get(mirror).update_obstakel_mirror( mirrors.get(k) ))
	    			{
    					if( (mirrors.get(mirror).position.x == -80) && (mirrors.get(mirror).position.y != 40 && mirrors.get(mirror).position.y != -20) )
	    				{
    						int random = ((int) (Math.random() * 3));
    						
    						if( random == 0 )
	    					{
	    						mirrors.get(mirror).position.y += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						mirrors.get(mirror).position.y -= 10;
	    					}
	    					else
	    					{
	    						mirrors.get(mirror).position.x += 10;
	    					}
    						
	    				}
	    				else if( (mirrors.get(mirror).position.x == 80) && (mirrors.get(mirror).position.y != 30 && mirrors.get(mirror).position.y != -40) )
	    				{
	    					int random = ((int) (Math.random() * 3));
    						
    						if( random == 0 )
	    					{
	    						mirrors.get(mirror).position.y += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						mirrors.get(mirror).position.y -= 10;
	    					}
	    					else
	    					{
	    						mirrors.get(mirror).position.x -= 10;
	    					}
	    				}
	    				else if( (mirrors.get(mirror).position.y == 40) && (mirrors.get(mirror).position.x != 70 && mirrors.get(mirror).position.x != -80) )
	    				{
	    					int random = ((int) (Math.random() * 3));
    						
    						if( random == 0 )
	    					{
	    						mirrors.get(mirror).position.y -= 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						mirrors.get(mirror).position.x -= 10;
	    					}
	    					else
	    					{
	    						mirrors.get(mirror).position.x += 10;
	    					}
	    				}
	    				else if( (mirrors.get(mirror).position.y == -40) && (mirrors.get(mirror).position.x != -60 && mirrors.get(mirror).position.x != 80) )
	    				{
	    					int random = ((int) (Math.random() * 3));
    						
    						if( random == 0 )
	    					{
	    						mirrors.get(mirror).position.y += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						mirrors.get(mirror).position.x -= 10;
	    					}
	    					else
	    					{
	    						mirrors.get(mirror).position.x += 10;
	    					}
	    				}
	    				else if( mirrors.get(mirror).position.x == -80 && mirrors.get(mirror).position.y == 40)
	    				{
	    					int random = ((int) (Math.random() * 2));
    						
    						if( random == 0 )
	    					{
	    						mirrors.get(mirror).position.y -= 10;
	    					}
	    					else
	    					{
	    						mirrors.get(mirror).position.x += 10;
	    					}
	    				}
	    				else if( mirrors.get(mirror).position.x == 80 && mirrors.get(mirror).position.y == -40 )
	    				{
	    					int random = ((int) (Math.random() * 2));
    						
    						if( random == 0 )
	    					{
	    						mirrors.get(mirror).position.y += 10;
	    					}
	    					else
	    					{
	    						mirrors.get(mirror).position.x -= 10;
	    					}
	    				}
	    				else if( mirrors.get(mirror).position.x == -80 && mirrors.get(mirror).position.y == -20)
	    				{
	    					int random = ((int) (Math.random() * 2));
    						
    						if( random == 0 )
	    					{
	    						mirrors.get(mirror).position.y += 10;
	    					}
	    					else
	    					{
	    						mirrors.get(mirror).position.x += 10;
	    					}
	    				}
	    				else if( mirrors.get(mirror).position.x == -70 && mirrors.get(mirror).position.y == -20 )
	    				{
	    					int random = ((int) (Math.random() * 3));
	    					
	    					if( random == 0 )
	    					{
	    						mirrors.get(mirror).position.y += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						mirrors.get(mirror).position.x += 10;
	    					}
	    					else
	    					{
	    						mirrors.get(mirror).position.x -= 10;
	    					}
	    				}
	    				else if( mirrors.get(mirror).position.x == -60 && mirrors.get(mirror).position.y == -30 )
	    				{
	    					int random = ((int) (Math.random() * 3));
	    					
	    					if( random == 0 )
	    					{
	    						mirrors.get(mirror).position.x += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						mirrors.get(mirror).position.y -= 10;
	    					}
	    					else
	    					{
	    						mirrors.get(mirror).position.y += 10;
	    					}
	    				}
	    				else if( mirrors.get(mirror).position.x == -60 && mirrors.get(mirror).position.y == -40 )
	    				{
	    					int random = ((int) (Math.random() * 2));
	    					
	    					if( random == 0 )
	    					{
	    						mirrors.get(mirror).position.y += 10;
	    					}
	    					else
	    					{
	    						mirrors.get(mirror).position.x += 10;
	    					}
	    				}
	    				else if( mirrors.get(mirror).position.x == 70 && mirrors.get(mirror).position.y == 40 )
	    				{
	    					int random = ((int) (Math.random() * 2));
	    					
	    					if( random == 0 )
	    					{
	    						mirrors.get(mirror).position.y -= 10;
	    					}
	    					else
	    					{
	    						mirrors.get(mirror).position.x -= 10;
	    					}
	    				}
	    				else if( mirrors.get(mirror).position.x == 80 && mirrors.get(mirror).position.y == 30 )
	    				{
	    					int random = ((int) (Math.random() * 2));
	    					
	    					if( random == 0 )
	    					{
	    						mirrors.get(mirror).position.y -= 10;
	    					}
	    					else
	    					{
	    						mirrors.get(mirror).position.x -= 10;
	    					}
	    				}
	    				else
	    				{
	    					int random = ((int) (Math.random() * 4));
	    					
	    					if( random == 0 )
	    					{
	    						mirrors.get(mirror).position.y += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						mirrors.get(mirror).position.y -= 10;
	    					}
	    					else if( random == 2 )
	    					{
	    						mirrors.get(mirror).position.x += 10;
	    					}
	    					else if( random == 3 )
	    					{
	    						mirrors.get(mirror).position.x -= 10;
	    					}
	    				}
    					
	    				Mirrors_Grid( mirror, touched_down, cubes, mirrors, radiation_tiles, blocks, colour_changers );
	    			}
	    			
    			}
    		}
    		
    		for( int k = 1; k <= number_of_cubes; k++ )
    		{
    				if( mirrors.get(mirror).update_obstakel_cube( cubes.get(k) ))
	    			{
    					if( (mirrors.get(mirror).position.x == -80) && (mirrors.get(mirror).position.y != 40 && mirrors.get(mirror).position.y != -20) )
	    				{
    						int random = ((int) (Math.random() * 3));
    						
    						if( random == 0 )
	    					{
	    						mirrors.get(mirror).position.y += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						mirrors.get(mirror).position.y -= 10;
	    					}
	    					else
	    					{
	    						mirrors.get(mirror).position.x += 10;
	    					}
    						
	    				}
	    				else if( (mirrors.get(mirror).position.x == 80) && (mirrors.get(mirror).position.y != 30 && mirrors.get(mirror).position.y != -40) )
	    				{
	    					int random = ((int) (Math.random() * 3));
    						
    						if( random == 0 )
	    					{
	    						mirrors.get(mirror).position.y += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						mirrors.get(mirror).position.y -= 10;
	    					}
	    					else
	    					{
	    						mirrors.get(mirror).position.x -= 10;
	    					}
	    				}
	    				else if( (mirrors.get(mirror).position.y == 40) && (mirrors.get(mirror).position.x != 70 && mirrors.get(mirror).position.x != -80) )
	    				{
	    					int random = ((int) (Math.random() * 3));
    						
    						if( random == 0 )
	    					{
	    						mirrors.get(mirror).position.y -= 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						mirrors.get(mirror).position.x -= 10;
	    					}
	    					else
	    					{
	    						mirrors.get(mirror).position.x += 10;
	    					}
	    				}
	    				else if( (mirrors.get(mirror).position.y == -40) && (mirrors.get(mirror).position.x != -60 && mirrors.get(mirror).position.x != 80) )
	    				{
	    					int random = ((int) (Math.random() * 3));
    						
    						if( random == 0 )
	    					{
	    						mirrors.get(mirror).position.y += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						mirrors.get(mirror).position.x -= 10;
	    					}
	    					else
	    					{
	    						mirrors.get(mirror).position.x += 10;
	    					}
	    				}
	    				else if( mirrors.get(mirror).position.x == -80 && mirrors.get(mirror).position.y == 40)
	    				{
	    					int random = ((int) (Math.random() * 2));
    						
    						if( random == 0 )
	    					{
	    						mirrors.get(mirror).position.y -= 10;
	    					}
	    					else
	    					{
	    						mirrors.get(mirror).position.x += 10;
	    					}
	    				}
	    				else if( mirrors.get(mirror).position.x == 80 && mirrors.get(mirror).position.y == -40 )
	    				{
	    					int random = ((int) (Math.random() * 2));
    						
    						if( random == 0 )
	    					{
	    						mirrors.get(mirror).position.y += 10;
	    					}
	    					else
	    					{
	    						mirrors.get(mirror).position.x -= 10;
	    					}
	    				}
	    				else if( mirrors.get(mirror).position.x == -80 && mirrors.get(mirror).position.y == -20)
	    				{
	    					int random = ((int) (Math.random() * 2));
    						
    						if( random == 0 )
	    					{
	    						mirrors.get(mirror).position.y += 10;
	    					}
	    					else
	    					{
	    						mirrors.get(mirror).position.x += 10;
	    					}
	    				}
	    				else if( mirrors.get(mirror).position.x == -70 && mirrors.get(mirror).position.y == -20 )
	    				{
	    					int random = ((int) (Math.random() * 3));
	    					
	    					if( random == 0 )
	    					{
	    						mirrors.get(mirror).position.y += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						mirrors.get(mirror).position.x += 10;
	    					}
	    					else
	    					{
	    						mirrors.get(mirror).position.x -= 10;
	    					}
	    				}
	    				else if( mirrors.get(mirror).position.x == -60 && mirrors.get(mirror).position.y == -30 )
	    				{
	    					int random = ((int) (Math.random() * 3));
	    					
	    					if( random == 0 )
	    					{
	    						mirrors.get(mirror).position.x += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						mirrors.get(mirror).position.y -= 10;
	    					}
	    					else
	    					{
	    						mirrors.get(mirror).position.y += 10;
	    					}
	    				}
	    				else if( mirrors.get(mirror).position.x == -60 && mirrors.get(mirror).position.y == -40 )
	    				{
	    					int random = ((int) (Math.random() * 2));
	    					
	    					if( random == 0 )
	    					{
	    						mirrors.get(mirror).position.y += 10;
	    					}
	    					else
	    					{
	    						mirrors.get(mirror).position.x += 10;
	    					}
	    				}
	    				else if( mirrors.get(mirror).position.x == 70 && mirrors.get(mirror).position.y == 40 )
	    				{
	    					int random = ((int) (Math.random() * 2));
	    					
	    					if( random == 0 )
	    					{
	    						mirrors.get(mirror).position.y -= 10;
	    					}
	    					else
	    					{
	    						mirrors.get(mirror).position.x -= 10;
	    					}
	    				}
	    				else if( mirrors.get(mirror).position.x == 80 && mirrors.get(mirror).position.y == 30 )
	    				{
	    					int random = ((int) (Math.random() * 2));
	    					
	    					if( random == 0 )
	    					{
	    						mirrors.get(mirror).position.y -= 10;
	    					}
	    					else
	    					{
	    						mirrors.get(mirror).position.x -= 10;
	    					}
	    				}
	    				else
	    				{
	    					int random = ((int) (Math.random() * 4));
	    					
	    					if( random == 0 )
	    					{
	    						mirrors.get(mirror).position.y += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						mirrors.get(mirror).position.y -= 10;
	    					}
	    					else if( random == 2 )
	    					{
	    						mirrors.get(mirror).position.x += 10;
	    					}
	    					else if( random == 3 )
	    					{
	    						mirrors.get(mirror).position.x -= 10;
	    					}
	    				}
    					
	    				Mirrors_Grid( mirror, touched_down, cubes, mirrors, radiation_tiles, blocks, colour_changers );
	    			}
	    			
    		}
    		
    		
    		for( int k = 1; k <= number_of_radiation_tiles; k++ )
    		{
    				if( mirrors.get(mirror).update_obstakel_radiation_tile( radiation_tiles.get(k) ))
	    			{
    					if( (mirrors.get(mirror).position.x == -80) && (mirrors.get(mirror).position.y != 40 && mirrors.get(mirror).position.y != -20) )
	    				{
    						int random = ((int) (Math.random() * 3));
    						
    						if( random == 0 )
	    					{
	    						mirrors.get(mirror).position.y += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						mirrors.get(mirror).position.y -= 10;
	    					}
	    					else
	    					{
	    						mirrors.get(mirror).position.x += 10;
	    					}
    						
	    				}
	    				else if( (mirrors.get(mirror).position.x == 80) && (mirrors.get(mirror).position.y != 30 && mirrors.get(mirror).position.y != -40) )
	    				{
	    					int random = ((int) (Math.random() * 3));
    						
    						if( random == 0 )
	    					{
	    						mirrors.get(mirror).position.y += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						mirrors.get(mirror).position.y -= 10;
	    					}
	    					else
	    					{
	    						mirrors.get(mirror).position.x -= 10;
	    					}
	    				}
	    				else if( (mirrors.get(mirror).position.y == 40) && (mirrors.get(mirror).position.x != 70 && mirrors.get(mirror).position.x != -80) )
	    				{
	    					int random = ((int) (Math.random() * 3));
    						
    						if( random == 0 )
	    					{
	    						mirrors.get(mirror).position.y -= 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						mirrors.get(mirror).position.x -= 10;
	    					}
	    					else
	    					{
	    						mirrors.get(mirror).position.x += 10;
	    					}
	    				}
	    				else if( (mirrors.get(mirror).position.y == -40) && (mirrors.get(mirror).position.x != -60 && mirrors.get(mirror).position.x != 80) )
	    				{
	    					int random = ((int) (Math.random() * 3));
    						
    						if( random == 0 )
	    					{
	    						mirrors.get(mirror).position.y += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						mirrors.get(mirror).position.x -= 10;
	    					}
	    					else
	    					{
	    						mirrors.get(mirror).position.x += 10;
	    					}
	    				}
	    				else if( mirrors.get(mirror).position.x == -80 && mirrors.get(mirror).position.y == 40)
	    				{
	    					int random = ((int) (Math.random() * 2));
    						
    						if( random == 0 )
	    					{
	    						mirrors.get(mirror).position.y -= 10;
	    					}
	    					else
	    					{
	    						mirrors.get(mirror).position.x += 10;
	    					}
	    				}
	    				else if( mirrors.get(mirror).position.x == 80 && mirrors.get(mirror).position.y == -40 )
	    				{
	    					int random = ((int) (Math.random() * 2));
    						
    						if( random == 0 )
	    					{
	    						mirrors.get(mirror).position.y += 10;
	    					}
	    					else
	    					{
	    						mirrors.get(mirror).position.x -= 10;
	    					}
	    				}
	    				else if( mirrors.get(mirror).position.x == -80 && mirrors.get(mirror).position.y == -20)
	    				{
	    					int random = ((int) (Math.random() * 2));
    						
    						if( random == 0 )
	    					{
	    						mirrors.get(mirror).position.y += 10;
	    					}
	    					else
	    					{
	    						mirrors.get(mirror).position.x += 10;
	    					}
	    				}
	    				else if( mirrors.get(mirror).position.x == -70 && mirrors.get(mirror).position.y == -20 )
	    				{
	    					int random = ((int) (Math.random() * 3));
	    					
	    					if( random == 0 )
	    					{
	    						mirrors.get(mirror).position.y += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						mirrors.get(mirror).position.x += 10;
	    					}
	    					else
	    					{
	    						mirrors.get(mirror).position.x -= 10;
	    					}
	    				}
	    				else if( mirrors.get(mirror).position.x == -60 && mirrors.get(mirror).position.y == -30 )
	    				{
	    					int random = ((int) (Math.random() * 3));
	    					
	    					if( random == 0 )
	    					{
	    						mirrors.get(mirror).position.x += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						mirrors.get(mirror).position.y -= 10;
	    					}
	    					else
	    					{
	    						mirrors.get(mirror).position.y += 10;
	    					}
	    				}
	    				else if( mirrors.get(mirror).position.x == -60 && mirrors.get(mirror).position.y == -40 )
	    				{
	    					int random = ((int) (Math.random() * 2));
	    					
	    					if( random == 0 )
	    					{
	    						mirrors.get(mirror).position.y += 10;
	    					}
	    					else
	    					{
	    						mirrors.get(mirror).position.x += 10;
	    					}
	    				}
	    				else if( mirrors.get(mirror).position.x == 70 && mirrors.get(mirror).position.y == 40 )
	    				{
	    					int random = ((int) (Math.random() * 2));
	    					
	    					if( random == 0 )
	    					{
	    						mirrors.get(mirror).position.y -= 10;
	    					}
	    					else
	    					{
	    						mirrors.get(mirror).position.x -= 10;
	    					}
	    				}
	    				else if( mirrors.get(mirror).position.x == 80 && mirrors.get(mirror).position.y == 30 )
	    				{
	    					int random = ((int) (Math.random() * 2));
	    					
	    					if( random == 0 )
	    					{
	    						mirrors.get(mirror).position.y -= 10;
	    					}
	    					else
	    					{
	    						mirrors.get(mirror).position.x -= 10;
	    					}
	    				}
	    				else
	    				{
	    					int random = ((int) (Math.random() * 4));
	    					
	    					if( random == 0 )
	    					{
	    						mirrors.get(mirror).position.y += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						mirrors.get(mirror).position.y -= 10;
	    					}
	    					else if( random == 2 )
	    					{
	    						mirrors.get(mirror).position.x += 10;
	    					}
	    					else if( random == 3 )
	    					{
	    						mirrors.get(mirror).position.x -= 10;
	    					}
	    				}
    					
	    				Mirrors_Grid( mirror, touched_down, cubes, mirrors, radiation_tiles, blocks, colour_changers );
	    			}
	    			
    		}
    		
    		
    		for( int k = 1; k <= number_of_blocks; k++ )
    		{
    				if( mirrors.get(mirror).update_obstakel_block( blocks.get(k) ))
	    			{
    					if( (mirrors.get(mirror).position.x == -80) && (mirrors.get(mirror).position.y != 40 && mirrors.get(mirror).position.y != -20) )
	    				{
    						int random = ((int) (Math.random() * 3));
    						
    						if( random == 0 )
	    					{
	    						mirrors.get(mirror).position.y += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						mirrors.get(mirror).position.y -= 10;
	    					}
	    					else
	    					{
	    						mirrors.get(mirror).position.x += 10;
	    					}
    						
	    				}
	    				else if( (mirrors.get(mirror).position.x == 80) && (mirrors.get(mirror).position.y != 30 && mirrors.get(mirror).position.y != -40) )
	    				{
	    					int random = ((int) (Math.random() * 3));
    						
    						if( random == 0 )
	    					{
	    						mirrors.get(mirror).position.y += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						mirrors.get(mirror).position.y -= 10;
	    					}
	    					else
	    					{
	    						mirrors.get(mirror).position.x -= 10;
	    					}
	    				}
	    				else if( (mirrors.get(mirror).position.y == 40) && (mirrors.get(mirror).position.x != 70 && mirrors.get(mirror).position.x != -80) )
	    				{
	    					int random = ((int) (Math.random() * 3));
    						
    						if( random == 0 )
	    					{
	    						mirrors.get(mirror).position.y -= 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						mirrors.get(mirror).position.x -= 10;
	    					}
	    					else
	    					{
	    						mirrors.get(mirror).position.x += 10;
	    					}
	    				}
	    				else if( (mirrors.get(mirror).position.y == -40) && (mirrors.get(mirror).position.x != -60 && mirrors.get(mirror).position.x != 80) )
	    				{
	    					int random = ((int) (Math.random() * 3));
    						
    						if( random == 0 )
	    					{
	    						mirrors.get(mirror).position.y += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						mirrors.get(mirror).position.x -= 10;
	    					}
	    					else
	    					{
	    						mirrors.get(mirror).position.x += 10;
	    					}
	    				}
	    				else if( mirrors.get(mirror).position.x == -80 && mirrors.get(mirror).position.y == 40)
	    				{
	    					int random = ((int) (Math.random() * 2));
    						
    						if( random == 0 )
	    					{
	    						mirrors.get(mirror).position.y -= 10;
	    					}
	    					else
	    					{
	    						mirrors.get(mirror).position.x += 10;
	    					}
	    				}
	    				else if( mirrors.get(mirror).position.x == 80 && mirrors.get(mirror).position.y == -40 )
	    				{
	    					int random = ((int) (Math.random() * 2));
    						
    						if( random == 0 )
	    					{
	    						mirrors.get(mirror).position.y += 10;
	    					}
	    					else
	    					{
	    						mirrors.get(mirror).position.x -= 10;
	    					}
	    				}
	    				else if( mirrors.get(mirror).position.x == -80 && mirrors.get(mirror).position.y == -20)
	    				{
	    					int random = ((int) (Math.random() * 2));
    						
    						if( random == 0 )
	    					{
	    						mirrors.get(mirror).position.y += 10;
	    					}
	    					else
	    					{
	    						mirrors.get(mirror).position.x += 10;
	    					}
	    				}
	    				else if( mirrors.get(mirror).position.x == -70 && mirrors.get(mirror).position.y == -20 )
	    				{
	    					int random = ((int) (Math.random() * 3));
	    					
	    					if( random == 0 )
	    					{
	    						mirrors.get(mirror).position.y += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						mirrors.get(mirror).position.x += 10;
	    					}
	    					else
	    					{
	    						mirrors.get(mirror).position.x -= 10;
	    					}
	    				}
	    				else if( mirrors.get(mirror).position.x == -60 && mirrors.get(mirror).position.y == -30 )
	    				{
	    					int random = ((int) (Math.random() * 3));
	    					
	    					if( random == 0 )
	    					{
	    						mirrors.get(mirror).position.x += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						mirrors.get(mirror).position.y -= 10;
	    					}
	    					else
	    					{
	    						mirrors.get(mirror).position.y += 10;
	    					}
	    				}
	    				else if( mirrors.get(mirror).position.x == -60 && mirrors.get(mirror).position.y == -40 )
	    				{
	    					int random = ((int) (Math.random() * 2));
	    					
	    					if( random == 0 )
	    					{
	    						mirrors.get(mirror).position.y += 10;
	    					}
	    					else
	    					{
	    						mirrors.get(mirror).position.x += 10;
	    					}
	    				}
	    				else if( mirrors.get(mirror).position.x == 70 && mirrors.get(mirror).position.y == 40 )
	    				{
	    					int random = ((int) (Math.random() * 2));
	    					
	    					if( random == 0 )
	    					{
	    						mirrors.get(mirror).position.y -= 10;
	    					}
	    					else
	    					{
	    						mirrors.get(mirror).position.x -= 10;
	    					}
	    				}
	    				else if( mirrors.get(mirror).position.x == 80 && mirrors.get(mirror).position.y == 30 )
	    				{
	    					int random = ((int) (Math.random() * 2));
	    					
	    					if( random == 0 )
	    					{
	    						mirrors.get(mirror).position.y -= 10;
	    					}
	    					else
	    					{
	    						mirrors.get(mirror).position.x -= 10;
	    					}
	    				}
	    				else
	    				{
	    					int random = ((int) (Math.random() * 4));
	    					
	    					if( random == 0 )
	    					{
	    						mirrors.get(mirror).position.y += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						mirrors.get(mirror).position.y -= 10;
	    					}
	    					else if( random == 2 )
	    					{
	    						mirrors.get(mirror).position.x += 10;
	    					}
	    					else if( random == 3 )
	    					{
	    						mirrors.get(mirror).position.x -= 10;
	    					}
	    				}
    					
	    				Mirrors_Grid( mirror, touched_down, cubes, mirrors, radiation_tiles, blocks, colour_changers );
	    			}
	    			
    		}
    		
    		for( int k = 1; k <= number_of_colour_changers; k++ )
    		{
    				if( mirrors.get(mirror).update_obstakel_colour_changer( colour_changers.get(k) ))
	    			{
    					if( (mirrors.get(mirror).position.x == -80) && (mirrors.get(mirror).position.y != 40 && mirrors.get(mirror).position.y != -20) )
	    				{
    						int random = ((int) (Math.random() * 3));
    						
    						if( random == 0 )
	    					{
	    						mirrors.get(mirror).position.y += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						mirrors.get(mirror).position.y -= 10;
	    					}
	    					else
	    					{
	    						mirrors.get(mirror).position.x += 10;
	    					}
    						
	    				}
	    				else if( (mirrors.get(mirror).position.x == 80) && (mirrors.get(mirror).position.y != 30 && mirrors.get(mirror).position.y != -40) )
	    				{
	    					int random = ((int) (Math.random() * 3));
    						
    						if( random == 0 )
	    					{
	    						mirrors.get(mirror).position.y += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						mirrors.get(mirror).position.y -= 10;
	    					}
	    					else
	    					{
	    						mirrors.get(mirror).position.x -= 10;
	    					}
	    				}
	    				else if( (mirrors.get(mirror).position.y == 40) && (mirrors.get(mirror).position.x != 70 && mirrors.get(mirror).position.x != -80) )
	    				{
	    					int random = ((int) (Math.random() * 3));
    						
    						if( random == 0 )
	    					{
	    						mirrors.get(mirror).position.y -= 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						mirrors.get(mirror).position.x -= 10;
	    					}
	    					else
	    					{
	    						mirrors.get(mirror).position.x += 10;
	    					}
	    				}
	    				else if( (mirrors.get(mirror).position.y == -40) && (mirrors.get(mirror).position.x != -60 && mirrors.get(mirror).position.x != 80) )
	    				{
	    					int random = ((int) (Math.random() * 3));
    						
    						if( random == 0 )
	    					{
	    						mirrors.get(mirror).position.y += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						mirrors.get(mirror).position.x -= 10;
	    					}
	    					else
	    					{
	    						mirrors.get(mirror).position.x += 10;
	    					}
	    				}
	    				else if( mirrors.get(mirror).position.x == -80 && mirrors.get(mirror).position.y == 40)
	    				{
	    					int random = ((int) (Math.random() * 2));
    						
    						if( random == 0 )
	    					{
	    						mirrors.get(mirror).position.y -= 10;
	    					}
	    					else
	    					{
	    						mirrors.get(mirror).position.x += 10;
	    					}
	    				}
	    				else if( mirrors.get(mirror).position.x == 80 && mirrors.get(mirror).position.y == -40 )
	    				{
	    					int random = ((int) (Math.random() * 2));
    						
    						if( random == 0 )
	    					{
	    						mirrors.get(mirror).position.y += 10;
	    					}
	    					else
	    					{
	    						mirrors.get(mirror).position.x -= 10;
	    					}
	    				}
	    				else if( mirrors.get(mirror).position.x == -80 && mirrors.get(mirror).position.y == -20)
	    				{
	    					int random = ((int) (Math.random() * 2));
    						
    						if( random == 0 )
	    					{
	    						mirrors.get(mirror).position.y += 10;
	    					}
	    					else
	    					{
	    						mirrors.get(mirror).position.x += 10;
	    					}
	    				}
	    				else if( mirrors.get(mirror).position.x == -70 && mirrors.get(mirror).position.y == -20 )
	    				{
	    					int random = ((int) (Math.random() * 3));
	    					
	    					if( random == 0 )
	    					{
	    						mirrors.get(mirror).position.y += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						mirrors.get(mirror).position.x += 10;
	    					}
	    					else
	    					{
	    						mirrors.get(mirror).position.x -= 10;
	    					}
	    				}
	    				else if( mirrors.get(mirror).position.x == -60 && mirrors.get(mirror).position.y == -30 )
	    				{
	    					int random = ((int) (Math.random() * 3));
	    					
	    					if( random == 0 )
	    					{
	    						mirrors.get(mirror).position.x += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						mirrors.get(mirror).position.y -= 10;
	    					}
	    					else
	    					{
	    						mirrors.get(mirror).position.y += 10;
	    					}
	    				}
	    				else if( mirrors.get(mirror).position.x == -60 && mirrors.get(mirror).position.y == -40 )
	    				{
	    					int random = ((int) (Math.random() * 2));
	    					
	    					if( random == 0 )
	    					{
	    						mirrors.get(mirror).position.y += 10;
	    					}
	    					else
	    					{
	    						mirrors.get(mirror).position.x += 10;
	    					}
	    				}
	    				else if( mirrors.get(mirror).position.x == 70 && mirrors.get(mirror).position.y == 40 )
	    				{
	    					int random = ((int) (Math.random() * 2));
	    					
	    					if( random == 0 )
	    					{
	    						mirrors.get(mirror).position.y -= 10;
	    					}
	    					else
	    					{
	    						mirrors.get(mirror).position.x -= 10;
	    					}
	    				}
	    				else if( mirrors.get(mirror).position.x == 80 && mirrors.get(mirror).position.y == 30 )
	    				{
	    					int random = ((int) (Math.random() * 2));
	    					
	    					if( random == 0 )
	    					{
	    						mirrors.get(mirror).position.y -= 10;
	    					}
	    					else
	    					{
	    						mirrors.get(mirror).position.x -= 10;
	    					}
	    				}
	    				else
	    				{
	    					int random = ((int) (Math.random() * 4));
	    					
	    					if( random == 0 )
	    					{
	    						mirrors.get(mirror).position.y += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						mirrors.get(mirror).position.y -= 10;
	    					}
	    					else if( random == 2 )
	    					{
	    						mirrors.get(mirror).position.x += 10;
	    					}
	    					else if( random == 3 )
	    					{
	    						mirrors.get(mirror).position.x -= 10;
	    					}
	    				}
    					
	    				Mirrors_Grid( mirror, touched_down, cubes, mirrors, radiation_tiles, blocks, colour_changers );
	    			}
	    			
    		}

		}
    }
	
	
	
	
	
	
	
	
	public void Colour_Changers_Grid( int colour_changer, boolean touched_down, ArrayList<Cube> cubes, ArrayList<Mirror> mirrors, ArrayList<Radiation_Tile> radiation_tiles, ArrayList<Block> blocks, ArrayList<Colour_Changer> colour_changers )
    {
		
		
		int number_of_cubes = 0;
		int number_of_mirrors = 0;
		int number_of_radiation_tiles = 0;
		int number_of_blocks = 0;
		int number_of_colour_changers = 0;
		
		if( cubes == null )
		{
			number_of_cubes = 0;
		}
		else
		{
			number_of_cubes = ( cubes.size() - 1 );
		}
		
		if( mirrors == null )
		{
			number_of_mirrors = 0;
		}
		else
		{
			number_of_mirrors = ( mirrors.size() - 1 );
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
    	
    	if( colour_changers.get(colour_changer) == null )
		{
		}
		else if( !touched_down )
		{
			for( int i = -80; i <= 80; i += 10)
			{
				if( (colour_changers.get(colour_changer).position.x > i && colour_changers.get(colour_changer).position.x < (i + 5) ) || (colour_changers.get(colour_changer).position.x < i && colour_changers.get(colour_changer).position.x > (i - 5) ) )
				{
					colour_changers.get(colour_changer).position.x = i;
				}
			}
		
    		for( int l = -40; l <= 40; l += 10)
    		{
    			if( (colour_changers.get(colour_changer).position.y > l && colour_changers.get(colour_changer).position.y < (l + 5) ) || (colour_changers.get(colour_changer).position.y < l && colour_changers.get(colour_changer).position.y > (l - 5) ) )
    			{
    				colour_changers.get(colour_changer).position.y = l;
    			}
    		}
    		
    		
    		for( int k = 1; k <= number_of_colour_changers; k++ )
    		{
    			if( colour_changer != k )
    			{
    				if( colour_changers.get(colour_changer).update_obstakel_colour_changer( colour_changers.get(k) ))
	    			{
    					if( (colour_changers.get(colour_changer).position.x == -80) && (colour_changers.get(colour_changer).position.y != 40 && colour_changers.get(colour_changer).position.y != -20) )
	    				{
    						int random = ((int) (Math.random() * 3));
    						
    						if( random == 0 )
	    					{
	    						colour_changers.get(colour_changer).position.y += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						colour_changers.get(colour_changer).position.y -= 10;
	    					}
	    					else
	    					{
	    						colour_changers.get(colour_changer).position.x += 10;
	    					}
    						
	    				}
	    				else if( (colour_changers.get(colour_changer).position.x == 80) && (colour_changers.get(colour_changer).position.y != 30 && colour_changers.get(colour_changer).position.y != -40) )
	    				{
	    					int random = ((int) (Math.random() * 3));
    						
    						if( random == 0 )
	    					{
	    						colour_changers.get(colour_changer).position.y += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						colour_changers.get(colour_changer).position.y -= 10;
	    					}
	    					else
	    					{
	    						colour_changers.get(colour_changer).position.x -= 10;
	    					}
	    				}
	    				else if( (colour_changers.get(colour_changer).position.y == 40) && (colour_changers.get(colour_changer).position.x != 70 && colour_changers.get(colour_changer).position.x != -80) )
	    				{
	    					int random = ((int) (Math.random() * 3));
    						
    						if( random == 0 )
	    					{
	    						colour_changers.get(colour_changer).position.y -= 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						colour_changers.get(colour_changer).position.x -= 10;
	    					}
	    					else
	    					{
	    						colour_changers.get(colour_changer).position.x += 10;
	    					}
	    				}
	    				else if( (colour_changers.get(colour_changer).position.y == -40) && (colour_changers.get(colour_changer).position.x != -60 && colour_changers.get(colour_changer).position.x != 80) )
	    				{
	    					int random = ((int) (Math.random() * 3));
    						
    						if( random == 0 )
	    					{
	    						colour_changers.get(colour_changer).position.y += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						colour_changers.get(colour_changer).position.x -= 10;
	    					}
	    					else
	    					{
	    						colour_changers.get(colour_changer).position.x += 10;
	    					}
	    				}
	    				else if( colour_changers.get(colour_changer).position.x == -80 && colour_changers.get(colour_changer).position.y == 40)
	    				{
	    					int random = ((int) (Math.random() * 2));
    						
    						if( random == 0 )
	    					{
	    						colour_changers.get(colour_changer).position.y -= 10;
	    					}
	    					else
	    					{
	    						colour_changers.get(colour_changer).position.x += 10;
	    					}
	    				}
	    				else if( colour_changers.get(colour_changer).position.x == 80 && colour_changers.get(colour_changer).position.y == -40 )
	    				{
	    					int random = ((int) (Math.random() * 2));
    						
    						if( random == 0 )
	    					{
	    						colour_changers.get(colour_changer).position.y += 10;
	    					}
	    					else
	    					{
	    						colour_changers.get(colour_changer).position.x -= 10;
	    					}
	    				}
	    				else if( colour_changers.get(colour_changer).position.x == -80 && colour_changers.get(colour_changer).position.y == -20)
	    				{
	    					int random = ((int) (Math.random() * 2));
    						
    						if( random == 0 )
	    					{
	    						colour_changers.get(colour_changer).position.y += 10;
	    					}
	    					else
	    					{
	    						colour_changers.get(colour_changer).position.x += 10;
	    					}
	    				}
	    				else if( colour_changers.get(colour_changer).position.x == -70 && colour_changers.get(colour_changer).position.y == -20 )
	    				{
	    					int random = ((int) (Math.random() * 3));
	    					
	    					if( random == 0 )
	    					{
	    						colour_changers.get(colour_changer).position.y += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						colour_changers.get(colour_changer).position.x += 10;
	    					}
	    					else
	    					{
	    						colour_changers.get(colour_changer).position.x -= 10;
	    					}
	    				}
	    				else if( colour_changers.get(colour_changer).position.x == -60 && colour_changers.get(colour_changer).position.y == -30 )
	    				{
	    					int random = ((int) (Math.random() * 3));
	    					
	    					if( random == 0 )
	    					{
	    						colour_changers.get(colour_changer).position.x += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						colour_changers.get(colour_changer).position.y -= 10;
	    					}
	    					else
	    					{
	    						colour_changers.get(colour_changer).position.y += 10;
	    					}
	    				}
	    				else if( colour_changers.get(colour_changer).position.x == -60 && colour_changers.get(colour_changer).position.y == -40 )
	    				{
	    					int random = ((int) (Math.random() * 2));
	    					
	    					if( random == 0 )
	    					{
	    						colour_changers.get(colour_changer).position.y += 10;
	    					}
	    					else
	    					{
	    						colour_changers.get(colour_changer).position.x += 10;
	    					}
	    				}
	    				else if( colour_changers.get(colour_changer).position.x == 70 && colour_changers.get(colour_changer).position.y == 40 )
	    				{
	    					int random = ((int) (Math.random() * 2));
	    					
	    					if( random == 0 )
	    					{
	    						colour_changers.get(colour_changer).position.y -= 10;
	    					}
	    					else
	    					{
	    						colour_changers.get(colour_changer).position.x -= 10;
	    					}
	    				}
	    				else if( colour_changers.get(colour_changer).position.x == 80 && colour_changers.get(colour_changer).position.y == 30 )
	    				{
	    					int random = ((int) (Math.random() * 2));
	    					
	    					if( random == 0 )
	    					{
	    						colour_changers.get(colour_changer).position.y -= 10;
	    					}
	    					else
	    					{
	    						colour_changers.get(colour_changer).position.x -= 10;
	    					}
	    				}
	    				else
	    				{
	    					int random = ((int) (Math.random() * 4));
	    					
	    					if( random == 0 )
	    					{
	    						colour_changers.get(colour_changer).position.y += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						colour_changers.get(colour_changer).position.y -= 10;
	    					}
	    					else if( random == 2 )
	    					{
	    						colour_changers.get(colour_changer).position.x += 10;
	    					}
	    					else if( random == 3 )
	    					{
	    						colour_changers.get(colour_changer).position.x -= 10;
	    					}
	    				}
    					
	    				Colour_Changers_Grid( colour_changer, touched_down, cubes, mirrors, radiation_tiles, blocks, colour_changers );
	    			}
	    			
    			}
    		}
    		
    		for( int k = 1; k <= number_of_cubes; k++ )
    		{
    				if( colour_changers.get(colour_changer).update_obstakel_cube( cubes.get(k) ))
	    			{
    					if( (colour_changers.get(colour_changer).position.x == -80) && (colour_changers.get(colour_changer).position.y != 40 && colour_changers.get(colour_changer).position.y != -20) )
	    				{
    						int random = ((int) (Math.random() * 3));
    						
    						if( random == 0 )
	    					{
	    						colour_changers.get(colour_changer).position.y += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						colour_changers.get(colour_changer).position.y -= 10;
	    					}
	    					else
	    					{
	    						colour_changers.get(colour_changer).position.x += 10;
	    					}
    						
	    				}
	    				else if( (colour_changers.get(colour_changer).position.x == 80) && (colour_changers.get(colour_changer).position.y != 30 && colour_changers.get(colour_changer).position.y != -40) )
	    				{
	    					int random = ((int) (Math.random() * 3));
    						
    						if( random == 0 )
	    					{
	    						colour_changers.get(colour_changer).position.y += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						colour_changers.get(colour_changer).position.y -= 10;
	    					}
	    					else
	    					{
	    						colour_changers.get(colour_changer).position.x -= 10;
	    					}
	    				}
	    				else if( (colour_changers.get(colour_changer).position.y == 40) && (colour_changers.get(colour_changer).position.x != 70 && colour_changers.get(colour_changer).position.x != -80) )
	    				{
	    					int random = ((int) (Math.random() * 3));
    						
    						if( random == 0 )
	    					{
	    						colour_changers.get(colour_changer).position.y -= 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						colour_changers.get(colour_changer).position.x -= 10;
	    					}
	    					else
	    					{
	    						colour_changers.get(colour_changer).position.x += 10;
	    					}
	    				}
	    				else if( (colour_changers.get(colour_changer).position.y == -40) && (colour_changers.get(colour_changer).position.x != -60 && colour_changers.get(colour_changer).position.x != 80) )
	    				{
	    					int random = ((int) (Math.random() * 3));
    						
    						if( random == 0 )
	    					{
	    						colour_changers.get(colour_changer).position.y += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						colour_changers.get(colour_changer).position.x -= 10;
	    					}
	    					else
	    					{
	    						colour_changers.get(colour_changer).position.x += 10;
	    					}
	    				}
	    				else if( colour_changers.get(colour_changer).position.x == -80 && colour_changers.get(colour_changer).position.y == 40)
	    				{
	    					int random = ((int) (Math.random() * 2));
    						
    						if( random == 0 )
	    					{
	    						colour_changers.get(colour_changer).position.y -= 10;
	    					}
	    					else
	    					{
	    						colour_changers.get(colour_changer).position.x += 10;
	    					}
	    				}
	    				else if( colour_changers.get(colour_changer).position.x == 80 && colour_changers.get(colour_changer).position.y == -40 )
	    				{
	    					int random = ((int) (Math.random() * 2));
    						
    						if( random == 0 )
	    					{
	    						colour_changers.get(colour_changer).position.y += 10;
	    					}
	    					else
	    					{
	    						colour_changers.get(colour_changer).position.x -= 10;
	    					}
	    				}
	    				else if( colour_changers.get(colour_changer).position.x == -80 && colour_changers.get(colour_changer).position.y == -20)
	    				{
	    					int random = ((int) (Math.random() * 2));
    						
    						if( random == 0 )
	    					{
	    						colour_changers.get(colour_changer).position.y += 10;
	    					}
	    					else
	    					{
	    						colour_changers.get(colour_changer).position.x += 10;
	    					}
	    				}
	    				else if( colour_changers.get(colour_changer).position.x == -70 && colour_changers.get(colour_changer).position.y == -20 )
	    				{
	    					int random = ((int) (Math.random() * 3));
	    					
	    					if( random == 0 )
	    					{
	    						colour_changers.get(colour_changer).position.y += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						colour_changers.get(colour_changer).position.x += 10;
	    					}
	    					else
	    					{
	    						colour_changers.get(colour_changer).position.x -= 10;
	    					}
	    				}
	    				else if( colour_changers.get(colour_changer).position.x == -60 && colour_changers.get(colour_changer).position.y == -30 )
	    				{
	    					int random = ((int) (Math.random() * 3));
	    					
	    					if( random == 0 )
	    					{
	    						colour_changers.get(colour_changer).position.x += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						colour_changers.get(colour_changer).position.y -= 10;
	    					}
	    					else
	    					{
	    						colour_changers.get(colour_changer).position.y += 10;
	    					}
	    				}
	    				else if( colour_changers.get(colour_changer).position.x == -60 && colour_changers.get(colour_changer).position.y == -40 )
	    				{
	    					int random = ((int) (Math.random() * 2));
	    					
	    					if( random == 0 )
	    					{
	    						colour_changers.get(colour_changer).position.y += 10;
	    					}
	    					else
	    					{
	    						colour_changers.get(colour_changer).position.x += 10;
	    					}
	    				}
	    				else if( colour_changers.get(colour_changer).position.x == 70 && colour_changers.get(colour_changer).position.y == 40 )
	    				{
	    					int random = ((int) (Math.random() * 2));
	    					
	    					if( random == 0 )
	    					{
	    						colour_changers.get(colour_changer).position.y -= 10;
	    					}
	    					else
	    					{
	    						colour_changers.get(colour_changer).position.x -= 10;
	    					}
	    				}
	    				else if( colour_changers.get(colour_changer).position.x == 80 && colour_changers.get(colour_changer).position.y == 30 )
	    				{
	    					int random = ((int) (Math.random() * 2));
	    					
	    					if( random == 0 )
	    					{
	    						colour_changers.get(colour_changer).position.y -= 10;
	    					}
	    					else
	    					{
	    						colour_changers.get(colour_changer).position.x -= 10;
	    					}
	    				}
	    				else
	    				{
	    					int random = ((int) (Math.random() * 4));
	    					
	    					if( random == 0 )
	    					{
	    						colour_changers.get(colour_changer).position.y += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						colour_changers.get(colour_changer).position.y -= 10;
	    					}
	    					else if( random == 2 )
	    					{
	    						colour_changers.get(colour_changer).position.x += 10;
	    					}
	    					else if( random == 3 )
	    					{
	    						colour_changers.get(colour_changer).position.x -= 10;
	    					}
	    				}
    					
	    				Colour_Changers_Grid( colour_changer, touched_down, cubes, mirrors, radiation_tiles, blocks, colour_changers );
	    			}
	    			
    		}
    		
    		
    		for( int k = 1; k <= number_of_radiation_tiles; k++ )
    		{
    				if( colour_changers.get(colour_changer).update_obstakel_radiation_tile( radiation_tiles.get(k) ))
	    			{
    					if( (colour_changers.get(colour_changer).position.x == -80) && (colour_changers.get(colour_changer).position.y != 40 && colour_changers.get(colour_changer).position.y != -20) )
	    				{
    						int random = ((int) (Math.random() * 3));
    						
    						if( random == 0 )
	    					{
	    						colour_changers.get(colour_changer).position.y += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						colour_changers.get(colour_changer).position.y -= 10;
	    					}
	    					else
	    					{
	    						colour_changers.get(colour_changer).position.x += 10;
	    					}
    						
	    				}
	    				else if( (colour_changers.get(colour_changer).position.x == 80) && (colour_changers.get(colour_changer).position.y != 30 && colour_changers.get(colour_changer).position.y != -40) )
	    				{
	    					int random = ((int) (Math.random() * 3));
    						
    						if( random == 0 )
	    					{
	    						colour_changers.get(colour_changer).position.y += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						colour_changers.get(colour_changer).position.y -= 10;
	    					}
	    					else
	    					{
	    						colour_changers.get(colour_changer).position.x -= 10;
	    					}
	    				}
	    				else if( (colour_changers.get(colour_changer).position.y == 40) && (colour_changers.get(colour_changer).position.x != 70 && colour_changers.get(colour_changer).position.x != -80) )
	    				{
	    					int random = ((int) (Math.random() * 3));
    						
    						if( random == 0 )
	    					{
	    						colour_changers.get(colour_changer).position.y -= 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						colour_changers.get(colour_changer).position.x -= 10;
	    					}
	    					else
	    					{
	    						colour_changers.get(colour_changer).position.x += 10;
	    					}
	    				}
	    				else if( (colour_changers.get(colour_changer).position.y == -40) && (colour_changers.get(colour_changer).position.x != -60 && colour_changers.get(colour_changer).position.x != 80) )
	    				{
	    					int random = ((int) (Math.random() * 3));
    						
    						if( random == 0 )
	    					{
	    						colour_changers.get(colour_changer).position.y += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						colour_changers.get(colour_changer).position.x -= 10;
	    					}
	    					else
	    					{
	    						colour_changers.get(colour_changer).position.x += 10;
	    					}
	    				}
	    				else if( colour_changers.get(colour_changer).position.x == -80 && colour_changers.get(colour_changer).position.y == 40)
	    				{
	    					int random = ((int) (Math.random() * 2));
    						
    						if( random == 0 )
	    					{
	    						colour_changers.get(colour_changer).position.y -= 10;
	    					}
	    					else
	    					{
	    						colour_changers.get(colour_changer).position.x += 10;
	    					}
	    				}
	    				else if( colour_changers.get(colour_changer).position.x == 80 && colour_changers.get(colour_changer).position.y == -40 )
	    				{
	    					int random = ((int) (Math.random() * 2));
    						
    						if( random == 0 )
	    					{
	    						colour_changers.get(colour_changer).position.y += 10;
	    					}
	    					else
	    					{
	    						colour_changers.get(colour_changer).position.x -= 10;
	    					}
	    				}
	    				else if( colour_changers.get(colour_changer).position.x == -80 && colour_changers.get(colour_changer).position.y == -20)
	    				{
	    					int random = ((int) (Math.random() * 2));
    						
    						if( random == 0 )
	    					{
	    						colour_changers.get(colour_changer).position.y += 10;
	    					}
	    					else
	    					{
	    						colour_changers.get(colour_changer).position.x += 10;
	    					}
	    				}
	    				else if( colour_changers.get(colour_changer).position.x == -70 && colour_changers.get(colour_changer).position.y == -20 )
	    				{
	    					int random = ((int) (Math.random() * 3));
	    					
	    					if( random == 0 )
	    					{
	    						colour_changers.get(colour_changer).position.y += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						colour_changers.get(colour_changer).position.x += 10;
	    					}
	    					else
	    					{
	    						colour_changers.get(colour_changer).position.x -= 10;
	    					}
	    				}
	    				else if( colour_changers.get(colour_changer).position.x == -60 && colour_changers.get(colour_changer).position.y == -30 )
	    				{
	    					int random = ((int) (Math.random() * 3));
	    					
	    					if( random == 0 )
	    					{
	    						colour_changers.get(colour_changer).position.x += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						colour_changers.get(colour_changer).position.y -= 10;
	    					}
	    					else
	    					{
	    						colour_changers.get(colour_changer).position.y += 10;
	    					}
	    				}
	    				else if( colour_changers.get(colour_changer).position.x == -60 && colour_changers.get(colour_changer).position.y == -40 )
	    				{
	    					int random = ((int) (Math.random() * 2));
	    					
	    					if( random == 0 )
	    					{
	    						colour_changers.get(colour_changer).position.y += 10;
	    					}
	    					else
	    					{
	    						colour_changers.get(colour_changer).position.x += 10;
	    					}
	    				}
	    				else if( colour_changers.get(colour_changer).position.x == 70 && colour_changers.get(colour_changer).position.y == 40 )
	    				{
	    					int random = ((int) (Math.random() * 2));
	    					
	    					if( random == 0 )
	    					{
	    						colour_changers.get(colour_changer).position.y -= 10;
	    					}
	    					else
	    					{
	    						colour_changers.get(colour_changer).position.x -= 10;
	    					}
	    				}
	    				else if( colour_changers.get(colour_changer).position.x == 80 && colour_changers.get(colour_changer).position.y == 30 )
	    				{
	    					int random = ((int) (Math.random() * 2));
	    					
	    					if( random == 0 )
	    					{
	    						colour_changers.get(colour_changer).position.y -= 10;
	    					}
	    					else
	    					{
	    						colour_changers.get(colour_changer).position.x -= 10;
	    					}
	    				}
	    				else
	    				{
	    					int random = ((int) (Math.random() * 4));
	    					
	    					if( random == 0 )
	    					{
	    						colour_changers.get(colour_changer).position.y += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						colour_changers.get(colour_changer).position.y -= 10;
	    					}
	    					else if( random == 2 )
	    					{
	    						colour_changers.get(colour_changer).position.x += 10;
	    					}
	    					else if( random == 3 )
	    					{
	    						colour_changers.get(colour_changer).position.x -= 10;
	    					}
	    				}
    					
	    				Colour_Changers_Grid( colour_changer, touched_down, cubes, mirrors, radiation_tiles, blocks, colour_changers );
	    			}
	    			
    		}
    		
    		
    		for( int k = 1; k <= number_of_blocks; k++ )
    		{
    				if( colour_changers.get(colour_changer).update_obstakel_block( blocks.get(k) ))
	    			{
    					if( (colour_changers.get(colour_changer).position.x == -80) && (colour_changers.get(colour_changer).position.y != 40 && colour_changers.get(colour_changer).position.y != -20) )
	    				{
    						int random = ((int) (Math.random() * 3));
    						
    						if( random == 0 )
	    					{
	    						colour_changers.get(colour_changer).position.y += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						colour_changers.get(colour_changer).position.y -= 10;
	    					}
	    					else
	    					{
	    						colour_changers.get(colour_changer).position.x += 10;
	    					}
    						
	    				}
	    				else if( (colour_changers.get(colour_changer).position.x == 80) && (colour_changers.get(colour_changer).position.y != 30 && colour_changers.get(colour_changer).position.y != -40) )
	    				{
	    					int random = ((int) (Math.random() * 3));
    						
    						if( random == 0 )
	    					{
	    						colour_changers.get(colour_changer).position.y += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						colour_changers.get(colour_changer).position.y -= 10;
	    					}
	    					else
	    					{
	    						colour_changers.get(colour_changer).position.x -= 10;
	    					}
	    				}
	    				else if( (colour_changers.get(colour_changer).position.y == 40) && (colour_changers.get(colour_changer).position.x != 70 && colour_changers.get(colour_changer).position.x != -80) )
	    				{
	    					int random = ((int) (Math.random() * 3));
    						
    						if( random == 0 )
	    					{
	    						colour_changers.get(colour_changer).position.y -= 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						colour_changers.get(colour_changer).position.x -= 10;
	    					}
	    					else
	    					{
	    						colour_changers.get(colour_changer).position.x += 10;
	    					}
	    				}
	    				else if( (colour_changers.get(colour_changer).position.y == -40) && (colour_changers.get(colour_changer).position.x != -60 && colour_changers.get(colour_changer).position.x != 80) )
	    				{
	    					int random = ((int) (Math.random() * 3));
    						
    						if( random == 0 )
	    					{
	    						colour_changers.get(colour_changer).position.y += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						colour_changers.get(colour_changer).position.x -= 10;
	    					}
	    					else
	    					{
	    						colour_changers.get(colour_changer).position.x += 10;
	    					}
	    				}
	    				else if( colour_changers.get(colour_changer).position.x == -80 && colour_changers.get(colour_changer).position.y == 40)
	    				{
	    					int random = ((int) (Math.random() * 2));
    						
    						if( random == 0 )
	    					{
	    						colour_changers.get(colour_changer).position.y -= 10;
	    					}
	    					else
	    					{
	    						colour_changers.get(colour_changer).position.x += 10;
	    					}
	    				}
	    				else if( colour_changers.get(colour_changer).position.x == 80 && colour_changers.get(colour_changer).position.y == -40 )
	    				{
	    					int random = ((int) (Math.random() * 2));
    						
    						if( random == 0 )
	    					{
	    						colour_changers.get(colour_changer).position.y += 10;
	    					}
	    					else
	    					{
	    						colour_changers.get(colour_changer).position.x -= 10;
	    					}
	    				}
	    				else if( colour_changers.get(colour_changer).position.x == -80 && colour_changers.get(colour_changer).position.y == -20)
	    				{
	    					int random = ((int) (Math.random() * 2));
    						
    						if( random == 0 )
	    					{
	    						colour_changers.get(colour_changer).position.y += 10;
	    					}
	    					else
	    					{
	    						colour_changers.get(colour_changer).position.x += 10;
	    					}
	    				}
	    				else if( colour_changers.get(colour_changer).position.x == -70 && colour_changers.get(colour_changer).position.y == -20 )
	    				{
	    					int random = ((int) (Math.random() * 3));
	    					
	    					if( random == 0 )
	    					{
	    						colour_changers.get(colour_changer).position.y += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						colour_changers.get(colour_changer).position.x += 10;
	    					}
	    					else
	    					{
	    						colour_changers.get(colour_changer).position.x -= 10;
	    					}
	    				}
	    				else if( colour_changers.get(colour_changer).position.x == -60 && colour_changers.get(colour_changer).position.y == -30 )
	    				{
	    					int random = ((int) (Math.random() * 3));
	    					
	    					if( random == 0 )
	    					{
	    						colour_changers.get(colour_changer).position.x += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						colour_changers.get(colour_changer).position.y -= 10;
	    					}
	    					else
	    					{
	    						colour_changers.get(colour_changer).position.y += 10;
	    					}
	    				}
	    				else if( colour_changers.get(colour_changer).position.x == -60 && colour_changers.get(colour_changer).position.y == -40 )
	    				{
	    					int random = ((int) (Math.random() * 2));
	    					
	    					if( random == 0 )
	    					{
	    						colour_changers.get(colour_changer).position.y += 10;
	    					}
	    					else
	    					{
	    						colour_changers.get(colour_changer).position.x += 10;
	    					}
	    				}
	    				else if( colour_changers.get(colour_changer).position.x == 70 && colour_changers.get(colour_changer).position.y == 40 )
	    				{
	    					int random = ((int) (Math.random() * 2));
	    					
	    					if( random == 0 )
	    					{
	    						colour_changers.get(colour_changer).position.y -= 10;
	    					}
	    					else
	    					{
	    						colour_changers.get(colour_changer).position.x -= 10;
	    					}
	    				}
	    				else if( colour_changers.get(colour_changer).position.x == 80 && colour_changers.get(colour_changer).position.y == 30 )
	    				{
	    					int random = ((int) (Math.random() * 2));
	    					
	    					if( random == 0 )
	    					{
	    						colour_changers.get(colour_changer).position.y -= 10;
	    					}
	    					else
	    					{
	    						colour_changers.get(colour_changer).position.x -= 10;
	    					}
	    				}
	    				else
	    				{
	    					int random = ((int) (Math.random() * 4));
	    					
	    					if( random == 0 )
	    					{
	    						colour_changers.get(colour_changer).position.y += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						colour_changers.get(colour_changer).position.y -= 10;
	    					}
	    					else if( random == 2 )
	    					{
	    						colour_changers.get(colour_changer).position.x += 10;
	    					}
	    					else if( random == 3 )
	    					{
	    						colour_changers.get(colour_changer).position.x -= 10;
	    					}
	    				}
    					
	    				Colour_Changers_Grid( colour_changer, touched_down, cubes, mirrors, radiation_tiles, blocks, colour_changers );
	    			}
	    			
    		}
    		
    		for( int k = 1; k <= number_of_mirrors; k++ )
    		{
    				if( colour_changers.get(colour_changer).update_obstakel_mirror( mirrors.get(k) ))
	    			{
    					if( (colour_changers.get(colour_changer).position.x == -80) && (colour_changers.get(colour_changer).position.y != 40 && colour_changers.get(colour_changer).position.y != -20) )
	    				{
    						int random = ((int) (Math.random() * 3));
    						
    						if( random == 0 )
	    					{
	    						colour_changers.get(colour_changer).position.y += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						colour_changers.get(colour_changer).position.y -= 10;
	    					}
	    					else
	    					{
	    						colour_changers.get(colour_changer).position.x += 10;
	    					}
    						
	    				}
	    				else if( (colour_changers.get(colour_changer).position.x == 80) && (colour_changers.get(colour_changer).position.y != 30 && colour_changers.get(colour_changer).position.y != -40) )
	    				{
	    					int random = ((int) (Math.random() * 3));
    						
    						if( random == 0 )
	    					{
	    						colour_changers.get(colour_changer).position.y += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						colour_changers.get(colour_changer).position.y -= 10;
	    					}
	    					else
	    					{
	    						colour_changers.get(colour_changer).position.x -= 10;
	    					}
	    				}
	    				else if( (colour_changers.get(colour_changer).position.y == 40) && (colour_changers.get(colour_changer).position.x != 70 && colour_changers.get(colour_changer).position.x != -80) )
	    				{
	    					int random = ((int) (Math.random() * 3));
    						
    						if( random == 0 )
	    					{
	    						colour_changers.get(colour_changer).position.y -= 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						colour_changers.get(colour_changer).position.x -= 10;
	    					}
	    					else
	    					{
	    						colour_changers.get(colour_changer).position.x += 10;
	    					}
	    				}
	    				else if( (colour_changers.get(colour_changer).position.y == -40) && (colour_changers.get(colour_changer).position.x != -60 && colour_changers.get(colour_changer).position.x != 80) )
	    				{
	    					int random = ((int) (Math.random() * 3));
    						
    						if( random == 0 )
	    					{
	    						colour_changers.get(colour_changer).position.y += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						colour_changers.get(colour_changer).position.x -= 10;
	    					}
	    					else
	    					{
	    						colour_changers.get(colour_changer).position.x += 10;
	    					}
	    				}
	    				else if( colour_changers.get(colour_changer).position.x == -80 && colour_changers.get(colour_changer).position.y == 40)
	    				{
	    					int random = ((int) (Math.random() * 2));
    						
    						if( random == 0 )
	    					{
	    						colour_changers.get(colour_changer).position.y -= 10;
	    					}
	    					else
	    					{
	    						colour_changers.get(colour_changer).position.x += 10;
	    					}
	    				}
	    				else if( colour_changers.get(colour_changer).position.x == 80 && colour_changers.get(colour_changer).position.y == -40 )
	    				{
	    					int random = ((int) (Math.random() * 2));
    						
    						if( random == 0 )
	    					{
	    						colour_changers.get(colour_changer).position.y += 10;
	    					}
	    					else
	    					{
	    						colour_changers.get(colour_changer).position.x -= 10;
	    					}
	    				}
	    				else if( colour_changers.get(colour_changer).position.x == -80 && colour_changers.get(colour_changer).position.y == -20)
	    				{
	    					int random = ((int) (Math.random() * 2));
    						
    						if( random == 0 )
	    					{
	    						colour_changers.get(colour_changer).position.y += 10;
	    					}
	    					else
	    					{
	    						colour_changers.get(colour_changer).position.x += 10;
	    					}
	    				}
	    				else if( colour_changers.get(colour_changer).position.x == -70 && colour_changers.get(colour_changer).position.y == -20 )
	    				{
	    					int random = ((int) (Math.random() * 3));
	    					
	    					if( random == 0 )
	    					{
	    						colour_changers.get(colour_changer).position.y += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						colour_changers.get(colour_changer).position.x += 10;
	    					}
	    					else
	    					{
	    						colour_changers.get(colour_changer).position.x -= 10;
	    					}
	    				}
	    				else if( colour_changers.get(colour_changer).position.x == -60 && colour_changers.get(colour_changer).position.y == -30 )
	    				{
	    					int random = ((int) (Math.random() * 3));
	    					
	    					if( random == 0 )
	    					{
	    						colour_changers.get(colour_changer).position.x += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						colour_changers.get(colour_changer).position.y -= 10;
	    					}
	    					else
	    					{
	    						colour_changers.get(colour_changer).position.y += 10;
	    					}
	    				}
	    				else if( colour_changers.get(colour_changer).position.x == -60 && colour_changers.get(colour_changer).position.y == -40 )
	    				{
	    					int random = ((int) (Math.random() * 2));
	    					
	    					if( random == 0 )
	    					{
	    						colour_changers.get(colour_changer).position.y += 10;
	    					}
	    					else
	    					{
	    						colour_changers.get(colour_changer).position.x += 10;
	    					}
	    				}
	    				else if( colour_changers.get(colour_changer).position.x == 70 && colour_changers.get(colour_changer).position.y == 40 )
	    				{
	    					int random = ((int) (Math.random() * 2));
	    					
	    					if( random == 0 )
	    					{
	    						colour_changers.get(colour_changer).position.y -= 10;
	    					}
	    					else
	    					{
	    						colour_changers.get(colour_changer).position.x -= 10;
	    					}
	    				}
	    				else if( colour_changers.get(colour_changer).position.x == 80 && colour_changers.get(colour_changer).position.y == 30 )
	    				{
	    					int random = ((int) (Math.random() * 2));
	    					
	    					if( random == 0 )
	    					{
	    						colour_changers.get(colour_changer).position.y -= 10;
	    					}
	    					else
	    					{
	    						colour_changers.get(colour_changer).position.x -= 10;
	    					}
	    				}
	    				else
	    				{
	    					int random = ((int) (Math.random() * 4));
	    					
	    					if( random == 0 )
	    					{
	    						colour_changers.get(colour_changer).position.y += 10;
	    					}
	    					else if( random == 1 )
	    					{
	    						colour_changers.get(colour_changer).position.y -= 10;
	    					}
	    					else if( random == 2 )
	    					{
	    						colour_changers.get(colour_changer).position.x += 10;
	    					}
	    					else if( random == 3 )
	    					{
	    						colour_changers.get(colour_changer).position.x -= 10;
	    					}
	    				}
    					
	    				Colour_Changers_Grid( colour_changer, touched_down, cubes, mirrors, radiation_tiles, blocks, colour_changers );
	    			}
	    			
    		}

		}
    }
	
}
