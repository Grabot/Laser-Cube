package com.games.Android.Laser_Cube.Menu1;

import com.games.Android.Laser_Cube.Load.Init_Renderer;
import com.badlogic.gdx.graphics.GL10;

public class Renderer
{
	public static final String LOG = Renderer.class.getSimpleName();
	
	private Init_Renderer init;

	private int red = 1;
	private int green = 3;
	private int yellow = 5;
	
	private boolean[] touched = new boolean[50];
	
	private int[] state = new int[50];
	private boolean touched_back_button = false;
	private boolean touched_back_button_2 = false;
	
	private boolean next_section = false;
	private float shift = 0;
	
	public Renderer( Init_Renderer init )
	{
		this.init = init;
	}
	
	
	
	public void DrawImages( GL10 gl, Simulation simulation, Menu1 game )
	{
		
        this.touched = simulation.touched();
        this.touched_back_button = simulation.touched_back_button();
        this.touched_back_button_2 = simulation.touched_back_button_2();
        this.state = game.state();
        
        next_section = simulation.get_next_section();
        shift = simulation.get_shift();
        
        init.Bind_Object_Atlas();
        
        init.Build_Background_Menu( gl, shift );
        init.Build_Wall_Menu( gl, shift );
        init.Build_Return_Button( gl, simulation.back_button, touched_back_button );
        init.Build_Return_Button( gl, simulation.back_button_2, touched_back_button_2 );
        
        init.Build_Level( gl, simulation.mirror_42, 0, touched[42], 3);
        init.Build_Level( gl, simulation.mirror_41, 0, touched[41], 4);
        
        init.Bind_Level_Atlas();
        if( shift < 20 )
    	{ 
        	for( int i = 1; i <= 20; i++ )
        	{
        		init.Build_Level( gl, simulation.mirrors.get(i), i, touched[i], state[i] );
        	}
    	}
        else if( shift >= 20 && shift < 100 )
        {
        	for( int i = 1; i <= 40; i++ )
        	{
        		if( i == 24 || i == 25 || i == 29 || i == 30 || i == 34 || i == 35 || i == 39 || i == 40 )
        		{
        			
        		}
        		else
        		{
        			init.Build_Level( gl, simulation.mirrors.get(i), i, touched[i], state[i] );
        		}
        	}
        }
        else if( shift >= 100 && shift < 160 )
        {
        	for( int i = 1; i <= 40; i++ )
        	{
        		if( i == 1 || i == 2 || i == 3 || i == 8 || i == 13 || i == 18 || i == 7 || i == 12 || i == 17 || i == 6 || i == 11 || i == 16 )
        		{
        			
        		}
        		else
        		{
        			init.Build_Level( gl, simulation.mirrors.get(i), i, touched[i], state[i] );
        		}
        	}
        }
        else if( shift >= 160 )
        {
        	for( int i = 21; i <= 40; i++ )
        	{
        			init.Build_Level( gl, simulation.mirrors.get(i), i, touched[i], state[i] );
        	}
        }

        //init.Build_Level( gl, simulation.mirror_42, 0, false, 3);
        //init.Build_Level( gl, simulation.mirror_41, 0, false, 4);
	}
	
    public void dispose()
    {
    	//init.Dispose_Levels_Atlas();
    }
}
