package com.games.Android.Laser_Cube.Objects;

import com.games.Android.Laser_Cube.Load.Vector;



public class Mirror 
{
	public float breedte = 79;
	public float hoogte = 39;
	
	float x_tilt = 0;
	float y_tilt = 0;

	public boolean obstakel_x_right = false;
	public boolean obstakel_x_left = false;
	public boolean obstakel_y_up = false;
	public boolean obstakel_y_down = false;
	public boolean mirror_hit_2 = false;
	public boolean mirror_hit_3 = false;
	
	public final float Snelheid = 6;
	
	
	public final Vector position = new Vector( );

	
	
	public void update_collision_wall( float x_tilt, float y_tilt, float hoogte, float breedte )
    {
		this.hoogte = hoogte;
		this.breedte = breedte;
		
		
    	if ( (position.x >= breedte) && (x_tilt <= 0) )
		{
			obstakel_x_left = true;
		}
		else if ( (position.x <= -breedte) && (x_tilt >= 0) )
		{
			obstakel_x_right = true;
		}
		else
		{
			obstakel_x_right = false;
			obstakel_x_left = false;
		}
    	
    	
    	if ( (position.y >= ( hoogte - 1 )) && (y_tilt <= 0) )
		{
			obstakel_y_up = true;
		}
		else if ( (position.y <= -hoogte) && (y_tilt >= 0) )
		{
			obstakel_y_down = true;
		}
		else
		{
			obstakel_y_up = false;
			obstakel_y_down = false;
		}
    }
	
	public void update_obstakel_mirror( float x_tile, float y_tilt, Mirror mirror)
	{
		
				if(((((position.x >= (mirror.position.x - 10)) && (position.x <= (mirror.position.x)))) && (x_tile <= 0)) && (( position.y >= (mirror.position.y - 9)) && ( position.y <= mirror.position.y + 9 )))
				{
					obstakel_x_left = true;
				}
				else if(((((position.x <= (mirror.position.x + 10)) && (position.x >= (mirror.position.x)))) && (x_tilt >= 0)) && (( position.y >= (mirror.position.y - 9)) && ( position.y <= mirror.position.y + 9)))
				{
					obstakel_x_right = true;
				}
				
				if ((( position.x >= (mirror.position.x - 9)) && (position.x <= (mirror.position.x + 9))) && ((( position.y <= (mirror.position.y + 10)) && (position.y >= (mirror.position.y))) && (y_tilt >= 0)))
				{
					obstakel_y_down = true;
				}
				else if ((( position.x >= (mirror.position.x - 9)) && (position.x <= (mirror.position.x + 9))) && (((position.y >= (mirror.position.y - 10)) && (position.y <= (mirror.position.y))) && (y_tilt <= 0)))
				{
					obstakel_y_up = true;
				}
	}
	
	
	public void update_pause_obstakel( float x_tilt, float y_tilt )
	{
		if(((position.x >= 69) && (x_tilt <= 0)) && position.y > 30 )
		{
			obstakel_x_left = true;
		}
		
		if(((position.y >= 29) && (y_tilt <= 0)) && position.x > 70)
		{
			obstakel_y_up = true;
		}
	}
	
	public void update_fire_button_obstakel( float x_tilt, float y_tilt )
	{
		if(((position.x <= -59) && (x_tilt >= 0)) && (position.y < -21))
		{
			obstakel_x_right = true;
		}
		
		
		if(((position.y < -20) && (y_tilt >=0 )) && (position.x <= -60))
		{
			obstakel_y_down = true;
		}
		
	}
	
	
	public boolean update_obstakel_cube( Cube cube)
	{
    		if( (position.x == cube.position.x) && (position.y == cube.position.y)  )
    		{
    			return true;
    		}
    		else
    		{
    			return false;
    		}
	}
	
	public boolean update_obstakel_mirror( Mirror mirror )
	{
    		if( (position.x == mirror.position.x) && (position.y == mirror.position.y)  )
    		{
    			return true;
    		}
    		else
    		{
    			return false;
    		}
	}
	
	public boolean update_obstakel_block( Block block )
	{
    		if( (position.x == block.position.x) && (position.y == block.position.y)  )
    		{
    			return true;
    		}
    		else
    		{
    			return false;
    		}
	}
	
	public boolean update_obstakel_colour_changer( Colour_Changer colour_changer )
	{
    		if( (position.x == colour_changer.position.x) && (position.y == colour_changer.position.y)  )
    		{
    			return true;
    		}
    		else
    		{
    			return false;
    		}
	}
	
	public boolean update_obstakel_radiation_tile( Radiation_Tile radiation_tile )
	{
    		if( (position.x == radiation_tile.position.x) || (position.x == radiation_tile.position.x - 1) || (position.x == radiation_tile.position.x + 1) || (position.x == radiation_tile.position.x - 2) || (position.x == radiation_tile.position.x + 2))
    		{
    			if( (position.y == radiation_tile.position.y) || (position.y == radiation_tile.position.y - 1) || (position.y == radiation_tile.position.y + 1) || (position.y == radiation_tile.position.y - 2) || (position.y == radiation_tile.position.y + 2 ))
    			{
        			return true;
    			}
    			else
    			{
    				return false;
    			}
    		}
    		else
    		{
    			return false;
    		}
	}
	
	
}
