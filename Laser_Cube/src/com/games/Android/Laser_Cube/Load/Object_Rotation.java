package com.games.Android.Laser_Cube.Load;

public class Object_Rotation 
{
	
	public Object_Rotation()
	{
		
	}
	
	public float[] Rotate_Colour_Changer_Update( int number_of_colour_changers, boolean[] colour_changers_rotated, float[] rotate_colour_changers )
    {
    	for( int i = 1; i <= number_of_colour_changers; i ++ )
    	{
        	if( colour_changers_rotated[i] )
        	{
        		if( rotate_colour_changers[i] >= 360 )
        		{
        			rotate_colour_changers[i] = 0;
        		}
        		
        		
        		if( rotate_colour_changers[i] == 0 || rotate_colour_changers[i] == 90 || rotate_colour_changers[i] == 180 || rotate_colour_changers[i] == 270 )
        		{
        			colour_changers_rotated[i] = false;
        		}
        		else
        		{
        			rotate_colour_changers[i] += 3;
        		}
        	}
    	}
    	
    	return rotate_colour_changers;
    }
	
	public float[] Rotate_Mirrors_Update( int number_of_mirrors, boolean[] mirrors_rotated, float[] rotate_mirrors )
    {
    	for( int i = 1; i <= number_of_mirrors; i ++ )
    	{
        	if( mirrors_rotated[i] )
        	{
        		if( rotate_mirrors[i] >= 360 )
        		{
        			rotate_mirrors[i] = 0;
        		}
        		
        		
        		if( rotate_mirrors[i] == 0 || rotate_mirrors[i] == 90 || rotate_mirrors[i] == 180 || rotate_mirrors[i] == 270 )
        		{
        			mirrors_rotated[i] = false;
        		}
        		else
        		{
        			rotate_mirrors[i] += 3;
        		}
        	}
    	}
    	
    	return rotate_mirrors;
    }
	
	
	public float[] Rotate_Cubes_Update( int number_of_cubes, boolean[] cubes_rotated, float[] rotate_cubes )
    {
    	for( int i = 1; i <= number_of_cubes; i ++ )
    	{
        	if( cubes_rotated[i] )
        	{
        		if( rotate_cubes[i] >= 360 )
        		{
        			rotate_cubes[i] = 0;
        		}
        		
        		
        		if( rotate_cubes[i] == 0 || rotate_cubes[i] == 90 || rotate_cubes[i] == 180 || rotate_cubes[i] == 270 )
        		{
        			cubes_rotated[i] = false;
        		}
        		else
        		{
        			rotate_cubes[i] += 3;
        		}
        	}
    	}
    	
    	return rotate_cubes;
    	
    }

}
