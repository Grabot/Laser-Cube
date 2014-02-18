package com.games.Android.Laser_Cube.Load;

public class Check_Touch 
{
	
	private float touch_distance_x = 100;
	private float touch_distance_y = 100;

	public Check_Touch( )
	{
	}
	
	public void Check_Touched( float width, float height, float touchX, float touchY )
	{
			
        	touch_distance_x = new Vector ( width/2, height/2, 0 ).distance( new Vector ( touchX, (height/2), 0));
        	touch_distance_y = new Vector ( width/2, height/2, 0 ).distance( new Vector ( (width/2), touchY, 0));
        	
        	
        	
        	if (( touchX > ( width / 2) ) && ( touchY > ( height/2 )))
        	{
        		if( touch_distance_x > 0 )
        		{
        			touch_distance_x = ((touch_distance_x * -1) / (width / 175));
        		}
        		
        		if( touch_distance_y > 0)
        		{
        			touch_distance_y = ((touch_distance_y * -1) / (height / 98));
        		}
        	}
        	else if (( touchX > ( width / 2 )) && ( touchY < ( height / 2 )))
        	{
        		if( touch_distance_x > 0 )
        		{
        			touch_distance_x = ((touch_distance_x * -1) / (width / 175));
        		}
        		
        		touch_distance_y = (touch_distance_y / (height / 98));
        	}
        	else if (( touchX < ( width / 2 )) && ( touchY > ( height / 2 )))
        	{
        		if( touch_distance_y > 0)
        		{
        			touch_distance_y = ((touch_distance_y * -1) / (height / 98));
        		}
        		touch_distance_x = (touch_distance_x / (width / 175));
        	}
        	else if (( touchX < ( width / 2 )) && ( touchY < ( height / 2 )))
        	{
        		touch_distance_y = (touch_distance_y / (height / 98));
        		touch_distance_x = (touch_distance_x / (width / 175));
        	}
        	else
        	{
        	}
        	
	}
	
	public float Get_Touch_Distance_X()
	{
		return touch_distance_x;
	}
	
	public float Get_Touch_Distance_Y()
	{
		return touch_distance_y;
	}
	
}
