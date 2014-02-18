package com.games.Android.Laser_Cube.Objects;

import com.games.Android.Laser_Cube.Load.Vector;


public class Opening_Tile_Animatie
{
	
	public static float EXPLOSION_LIVE_TIME = 1f;
    public float aliveTime = 0;
    public final Vector position = new Vector( );
    
    
	public Opening_Tile_Animatie( Vector position )
    {
            this.position.set( position );
    }
	
	public void update( float delta )
    {
            aliveTime += delta;
    }

}