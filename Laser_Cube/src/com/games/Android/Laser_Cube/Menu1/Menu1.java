package com.games.Android.Laser_Cube.Menu1;

import com.games.Android.Laser_Cube.Load.Init_Renderer;
import com.games.Android.Laser_Cube.Load.Screen;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class Menu1 implements Screen
{

	private Init_Renderer init;
	
	private Renderer renderer;
	private Simulation simulation;
	
	private boolean game_finished = false;
	
	private int level = 0;
	
	private int Game_Level_1 = 1;
	private int Game_Level_2 = 1;
	private int Game_Level_3 = 1;
	private int Game_Level_4 = 1;
	private int Game_Level_5 = 0;
	private int Game_Level_6 = 0;
	private int Game_Level_7 = 0;
	private int Game_Level_8 = 0;
	private int Game_Level_9 = 1;
	private int Game_Level_10 = 1;
	private int Game_Level_11 = 1;
	private int Game_Level_12 = 1;
	private int Game_Level_13 = 0;
	private int Game_Level_14 = 0;
	private int Game_Level_15 = 0;
	private int Game_Level_16 = 0;
	private int Game_Level_17 = 0;
	private int Game_Level_18 = 0;
	private int Game_Level_19 = 0;
	private int Game_Level_20 = 0;
	private int Game_Level_21 = 1;
	private int Game_Level_22 = 1;
	private int Game_Level_23 = 1;
	private int Game_Level_24 = 1;
	private int Game_Level_25 = 0;
	private int Game_Level_26 = 0;
	private int Game_Level_27 = 0;
	private int Game_Level_28 = 0;
	private int Game_Level_29 = 1;
	private int Game_Level_30 = 1;
	private int Game_Level_31 = 1;
	private int Game_Level_32 = 1;
	private int Game_Level_33 = 0;
	private int Game_Level_34 = 0;
	private int Game_Level_35 = 0;
	private int Game_Level_36 = 0;
	private int Game_Level_37 = 0;
	private int Game_Level_38 = 0;
	private int Game_Level_39 = 0;
	private int Game_Level_40 = 0;
	
	private boolean help_level_1 = false;
	private boolean help_level_2 = false;
	private boolean help_level_3 = false;
	private boolean help_level_4 = false;
	private boolean help_level_5 = false;
	
	private int[] state = new int[50];
	
	private Preferences prefs;
	
	public Menu1( Application app, Init_Renderer init )
	{
		this.init = init;
		
		prefs = Gdx.app.getPreferences("my-preferences");
		
		Game_Level_1 = prefs.getInteger("Level_1_Game", 1 );
		Game_Level_2 = prefs.getInteger("Level_2_Game", 1 );
		Game_Level_3 = prefs.getInteger("Level_3_Game", 1 );
		Game_Level_4 = prefs.getInteger("Level_4_Game", 1 );
		Game_Level_5 = prefs.getInteger("Level_5_Game", 1 );
		Game_Level_6 = prefs.getInteger("Level_6_Game", 0 );
		Game_Level_7 = prefs.getInteger("Level_7_Game", 0 );
		Game_Level_8 = prefs.getInteger("Level_8_Game", 0 );
		Game_Level_9 = prefs.getInteger("Level_9_Game", 0 );
		Game_Level_10 = prefs.getInteger("Level_10_Game", 0 );
		Game_Level_11 = prefs.getInteger("Level_11_Game", 0 );
		Game_Level_12 = prefs.getInteger("Level_12_Game", 0 );
		Game_Level_13 = prefs.getInteger("Level_13_Game", 0 );
		Game_Level_14 = prefs.getInteger("Level_14_Game", 0 );
		Game_Level_15 = prefs.getInteger("Level_15_Game", 0 );
		Game_Level_16 = prefs.getInteger("Level_16_Game", 0 );
		Game_Level_17 = prefs.getInteger("Level_17_Game", 0 );
		Game_Level_18 = prefs.getInteger("Level_18_Game", 0 );
		Game_Level_19 = prefs.getInteger("Level_19_Game", 0 );
		Game_Level_20 = prefs.getInteger("Level_20_Game", 0 );
		
		if( prefs.getInteger("Level_5_Game", 0) == 2)
		{
			Game_Level_21 = prefs.getInteger("Level_21_Game", 1 );
		}
		else
		{
			Game_Level_21 = prefs.getInteger("Level_21_Game", 0 );
		}
		
		Game_Level_22 = prefs.getInteger("Level_22_Game", 0 );
		Game_Level_23 = prefs.getInteger("Level_23_Game", 0 );
		Game_Level_24 = prefs.getInteger("Level_24_Game", 0 );
		Game_Level_25 = prefs.getInteger("Level_25_Game", 0 );
		
		if( prefs.getInteger("Level_10_Game", 0) == 2)
		{
			Game_Level_26 = prefs.getInteger("Level_26_Game", 1 );
		}
		else
		{
			Game_Level_26 = prefs.getInteger("Level_26_Game", 0 );
		}
		
		Game_Level_27 = prefs.getInteger("Level_27_Game", 0 );
		Game_Level_28 = prefs.getInteger("Level_28_Game", 0 );
		Game_Level_29 = prefs.getInteger("Level_29_Game", 0 );
		Game_Level_30 = prefs.getInteger("Level_30_Game", 0 );
		
		if( prefs.getInteger("Level_15_Game", 0) == 2)
		{
			Game_Level_31 = prefs.getInteger("Level_31_Game", 1 );
		}
		else
		{
			Game_Level_31 = prefs.getInteger("Level_31_Game", 0 );
		}
		
		Game_Level_32 = prefs.getInteger("Level_32_Game", 0 );
		Game_Level_33 = prefs.getInteger("Level_33_Game", 0 );
		Game_Level_34 = prefs.getInteger("Level_34_Game", 0 );
		Game_Level_35 = prefs.getInteger("Level_35_Game", 0 );
		
		if( prefs.getInteger("Level_20_Game", 0) == 2)
		{
			Game_Level_36 = prefs.getInteger("Level_36_Game", 1 );
		}
		else
		{
			Game_Level_36 = prefs.getInteger("Level_36_Game", 0 );
		}
		
		Game_Level_37 = prefs.getInteger("Level_37_Game", 0 );
		Game_Level_38 = prefs.getInteger("Level_38_Game", 0 );
		Game_Level_39 = prefs.getInteger("Level_39_Game", 0 );
		Game_Level_40 = prefs.getInteger("Level_40_Game", 0 );
		
		help_level_1 = prefs.getBoolean("help_level_1", true );
		help_level_2 = prefs.getBoolean("help_level_2", true );
		help_level_3 = prefs.getBoolean("help_level_3", true );
		help_level_4 = prefs.getBoolean("help_level_4", true );
		help_level_5 = prefs.getBoolean("help_level_5", true );
		
		state[1] = Game_Level_1;
		state[2] = Game_Level_2;
		state[3] = Game_Level_3;
		state[4] = Game_Level_4;
		state[5] = Game_Level_5;
		state[6] = Game_Level_6;
		state[7] = Game_Level_7;
		state[8] = Game_Level_8;
		state[9] = Game_Level_9;
		state[10] = Game_Level_10;
		state[11] = Game_Level_11;
		state[12] = Game_Level_12;
		state[13] = Game_Level_13;
		state[14] = Game_Level_14;
		state[15] = Game_Level_15;
		state[16] = Game_Level_16;
		state[17] = Game_Level_17;
		state[18] = Game_Level_18;
		state[19] = Game_Level_19;
		state[20] = Game_Level_20;
		state[21] = Game_Level_21;
		state[22] = Game_Level_22;
		state[23] = Game_Level_23;
		state[24] = Game_Level_24;
		state[25] = Game_Level_25;
		state[26] = Game_Level_26;
		state[27] = Game_Level_27;
		state[28] = Game_Level_28;
		state[29] = Game_Level_29;
		state[30] = Game_Level_30;
		state[31] = Game_Level_31;
		state[32] = Game_Level_32;
		state[33] = Game_Level_33;
		state[34] = Game_Level_34;
		state[35] = Game_Level_35;
		state[36] = Game_Level_36;
		state[37] = Game_Level_37;
		state[38] = Game_Level_38;
		state[39] = Game_Level_39;
		state[40] = Game_Level_40;
        
        simulation = new Simulation( this );
        renderer = new Renderer( init );
	}

	
	@Override
	public void dispose() 
	{
	}

	@Override
	public void update( float delta, float touchX, float touchY, float width, float height, boolean touched_down, boolean fast_press, boolean pressed_back_button ) 
	{
		simulation.update( delta );
		simulation.variables( touchX, touchY, width, height, touched_down, pressed_back_button );
	}

	@Override
	public void render(Application app ) 
	{
		
		renderer.DrawImages( Gdx.gl10, simulation, this );
		
	}
	
	public void Game_Finished( int level )
	{
		this.level = level;
		game_finished = true;
		renderer.dispose();
	}

	@Override
	public boolean isDone() 
	{
		return game_finished;
	}


	@Override
	public int level() 
	{
		return level;
	}

	
	public int[] state()
	{
		return state;
	}
	
}
