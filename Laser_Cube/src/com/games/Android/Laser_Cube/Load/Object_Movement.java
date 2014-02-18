package com.games.Android.Laser_Cube.Load;

import java.util.ArrayList;

import com.games.Android.Laser_Cube.Objects.Colour_Changer;
import com.games.Android.Laser_Cube.Objects.Cube;
import com.games.Android.Laser_Cube.Objects.Mirror;

public class Object_Movement 
{

	private int speed_cubes = 50;
	public Object_Movement( )
	{
	}
	
	
	
	public void Move_Mirrors( boolean[] mirror_finger, float touch_distance_x, float touch_distance_y, float breedte, float hoogte, float delta, ArrayList<Mirror> mirrors  ) 
    {
			int number_mirror = 0;
			float touch_mirror_distance_x = 100;
			float touch_mirror_distance_y = 100;
			float emma = 0;
			float watson = 0;
			
			int number_of_mirrors = ( mirrors.size() - 1 );
			
			
			for( int i = 0; i <= number_of_mirrors; i++ )
    		{
    			if ( mirror_finger[i] )
    			{
    				number_mirror = i;
    			}
    		}
    		
			if ( number_mirror == 0 )
    		{
    			
    		}
    		else
    		{
    			touch_mirror_distance_x = (mirrors.get(number_mirror).position.x - touch_distance_x);
        		
    	    	if (touch_mirror_distance_x > speed_cubes)
    	    	{
    	    		touch_mirror_distance_x = speed_cubes;
    	    	}
    	    	else if (touch_mirror_distance_x < -speed_cubes)
    	    	{
    	    		touch_mirror_distance_x = -speed_cubes;
    	    	}
    	    	
    	    	
    	    	touch_mirror_distance_y = (mirrors.get(number_mirror).position.y - touch_distance_y);
    	    	
    	    	if (touch_mirror_distance_y > speed_cubes)
    	    	{
    	    		touch_mirror_distance_y = speed_cubes;
    	    	}
    	    	else if (touch_mirror_distance_y < -speed_cubes)
    	    	{
    	    		touch_mirror_distance_y = -speed_cubes;
    	    	}
    	    	
    	    	emma = touch_mirror_distance_x;
    			watson = touch_mirror_distance_y;
    	    	
    	    	mirrors.get(number_mirror).update_collision_wall( emma, watson, hoogte, breedte );
    	    	mirrors.get(number_mirror).update_fire_button_obstakel( emma, watson );
    	    	mirrors.get(number_mirror).update_pause_obstakel( emma, watson );
    			
    			if (( mirrors.get(number_mirror).obstakel_x_left && ( emma < 0 )) || ( mirrors.get(number_mirror).obstakel_x_right && ( emma > 0 )))
    			{
    			}
    			else
    			{
    				mirrors.get(number_mirror).position.x -= delta * 6 * emma;
    			}
    			
    			if (( mirrors.get(number_mirror).obstakel_y_up && ( watson < 0)) || ( mirrors.get(number_mirror).obstakel_y_down && (watson > 0)))
    			{
    			}
    			else
    			{
    				mirrors.get(number_mirror).position.y -= delta * 6 * watson;
    			}
    		}
    }
	
	
	
	public void Move_Cubes( boolean[] cube_finger, float touch_distance_x, float touch_distance_y, float breedte, float hoogte, float delta, ArrayList<Cube> cubes  ) 
    {
			int number_cube = 0;
			float touch_cube_distance_x = 100;
			float touch_cube_distance_y = 100;
			float emma = 0;
			float watson = 0;
			
			int number_of_cubes = ( cubes.size() - 1 );
			
			for( int i = 0; i <= number_of_cubes; i++ )
    		{
    			if ( cube_finger[i] )
    			{
    				number_cube = i;
    			}
    		}
    		
			if ( number_cube == 0 )
    		{
    			
    		}
    		else
    		{
    			touch_cube_distance_x = (cubes.get(number_cube).position.x - touch_distance_x);
        		
    	    	if (touch_cube_distance_x > speed_cubes)
    	    	{
    	    		touch_cube_distance_x = speed_cubes;
    	    	}
    	    	else if (touch_cube_distance_x < -speed_cubes)
    	    	{
    	    		touch_cube_distance_x = -speed_cubes;
    	    	}
    	    	
    	    	
    	    	touch_cube_distance_y = (cubes.get(number_cube).position.y - touch_distance_y);
    	    	
    	    	if (touch_cube_distance_y > speed_cubes)
    	    	{
    	    		touch_cube_distance_y = speed_cubes;
    	    	}
    	    	else if (touch_cube_distance_y < -speed_cubes)
    	    	{
    	    		touch_cube_distance_y = -speed_cubes;
    	    	}
    	    	
    	    	emma = touch_cube_distance_x;
    			watson = touch_cube_distance_y;
    	    	
    	    	cubes.get(number_cube).update_collision_wall( emma, watson, hoogte, breedte );
    	    	cubes.get(number_cube).update_fire_button_obstakel( emma, watson );
    	    	cubes.get(number_cube).update_pause_obstakel( emma, watson );
    			
    			if (( cubes.get(number_cube).obstakel_x_left && ( emma < 0 )) || ( cubes.get(number_cube).obstakel_x_right && ( emma > 0 )))
    			{
    			}
    			else
    			{
    				cubes.get(number_cube).position.x -= delta * 6 * emma;
    			}
    			
    			if (( cubes.get(number_cube).obstakel_y_up && ( watson < 0)) || ( cubes.get(number_cube).obstakel_y_down && (watson > 0)))
    			{
    			}
    			else
    			{
    				cubes.get(number_cube).position.y -= delta * 6 * watson;
    			}
    		}
    }
	
	
	public void Move_Colour_Changers( boolean[] colour_changer_finger, float touch_distance_x, float touch_distance_y, float breedte, float hoogte, float delta, ArrayList<Colour_Changer> colour_changers  ) 
    {
			int number_colour_changer = 0;
			float touch_colour_changer_distance_x = 100;
			float touch_colour_changer_distance_y = 100;
			float emma = 0;
			float watson = 0;
			
			int number_of_mirrors = ( colour_changers.size() - 1 );
			
			
			for( int i = 0; i <= number_of_mirrors; i++ )
    		{
    			if ( colour_changer_finger[i] )
    			{
    				number_colour_changer = i;
    			}
    		}
    		
			if ( number_colour_changer == 0 )
    		{
    			
    		}
    		else
    		{
    			touch_colour_changer_distance_x = (colour_changers.get(number_colour_changer).position.x - touch_distance_x);
        		
    	    	if (touch_colour_changer_distance_x > speed_cubes)
    	    	{
    	    		touch_colour_changer_distance_x = speed_cubes;
    	    	}
    	    	else if (touch_colour_changer_distance_x < -speed_cubes)
    	    	{
    	    		touch_colour_changer_distance_x = -speed_cubes;
    	    	}
    	    	
    	    	
    	    	touch_colour_changer_distance_y = (colour_changers.get(number_colour_changer).position.y - touch_distance_y);
    	    	
    	    	if (touch_colour_changer_distance_y > speed_cubes)
    	    	{
    	    		touch_colour_changer_distance_y = speed_cubes;
    	    	}
    	    	else if (touch_colour_changer_distance_y < -speed_cubes)
    	    	{
    	    		touch_colour_changer_distance_y = -speed_cubes;
    	    	}
    	    	
    	    	emma = touch_colour_changer_distance_x;
    			watson = touch_colour_changer_distance_y;
    	    	
    	    	colour_changers.get(number_colour_changer).update_collision_wall( emma, watson, hoogte, breedte );
    	    	colour_changers.get(number_colour_changer).update_fire_button_obstakel( emma, watson );
    	    	colour_changers.get(number_colour_changer).update_pause_obstakel( emma, watson );
    			
    			if (( colour_changers.get(number_colour_changer).obstakel_x_left && ( emma < 0 )) || ( colour_changers.get(number_colour_changer).obstakel_x_right && ( emma > 0 )))
    			{
    			}
    			else
    			{
    				colour_changers.get(number_colour_changer).position.x -= delta * 6 * emma;
    			}
    			
    			if (( colour_changers.get(number_colour_changer).obstakel_y_up && ( watson < 0)) || ( colour_changers.get(number_colour_changer).obstakel_y_down && (watson > 0)))
    			{
    			}
    			else
    			{
    				colour_changers.get(number_colour_changer).position.y -= delta * 6 * watson;
    			}
    		}
    }
}
