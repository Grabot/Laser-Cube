package com.games.Android.Laser_Cube.Objects;

import com.badlogic.gdx.Gdx;
import com.games.Android.Laser_Cube.Load.Mesh;
import com.games.Android.Laser_Cube.Load.Vector;


public class Fire_Button
{

	Mesh Fire_Button_Mesh;
	
	public final Vector position = new Vector( );
	
	public Fire_Button(Vector position) 
    {
            this.position.set( position );
    }
	
}
