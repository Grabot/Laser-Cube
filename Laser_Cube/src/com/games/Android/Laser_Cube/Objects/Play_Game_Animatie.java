package com.games.Android.Laser_Cube.Objects;

import com.games.Android.Laser_Cube.Load.Vector;


public class Play_Game_Animatie
{
	
	public static float EXPLOSION_LIVE_TIME = 1f;
    public float aliveTime = 0.4f;
    public final Vector position = new Vector( );
    
    
	public Play_Game_Animatie( Vector position )
    {
            this.position.set( position );
    }
	
	public void update( float delta )
    {
            aliveTime += delta;
    }

}