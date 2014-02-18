package com.games.Android.Laser_Cube.Level32;


import java.util.ArrayList;

import com.games.Android.Laser_Cube.Main;
import com.games.Android.Laser_Cube.Load.Check_Touch;
import com.games.Android.Laser_Cube.Load.Laser_Touch;
import com.games.Android.Laser_Cube.Load.Object_Movement;
import com.games.Android.Laser_Cube.Load.Object_Rotation;
import com.games.Android.Laser_Cube.Load.Object_Touch;
import com.games.Android.Laser_Cube.Load.Vector;
import com.games.Android.Laser_Cube.Objects.Block;
import com.games.Android.Laser_Cube.Objects.Colour_Changer;
import com.games.Android.Laser_Cube.Objects.Cube;
import com.games.Android.Laser_Cube.Objects.Fire_Button;
import com.games.Android.Laser_Cube.Objects.Laser;
import com.games.Android.Laser_Cube.Objects.Mirror;
import com.games.Android.Laser_Cube.Objects.Pause_Button;
import com.games.Android.Laser_Cube.Objects.Radiation_Tile;
import com.badlogic.gdx.Gdx;

public class Simulation 
{   
		private float emma = 100;
		private float watson = 100;
    
		public float breedte = 80;
		public float hoogte = 40;
		
		private int single_refraction = 21;
	    private int double_refraction = 22;
	    private int triple_refraction = 23;
	    private int forward_refraction = 24;
		
		private int groen = 1;
	    private int rood = 2;
	    private int geel = 3;
	    
        private int number_of_mirrors = 0;
	    private int number_of_cubes = 0;
	    private int number_of_radiation_tiles = 0;
	    private int number_of_colour_changers = 0;
		
		public ArrayList<Cube> cubes = new ArrayList<Cube>( );
		public ArrayList<Laser> green_lasers = new ArrayList<Laser>( );
		public ArrayList<Laser> red_lasers = new ArrayList<Laser>( );
		public ArrayList<Laser> yellow_lasers = new ArrayList<Laser>( );
		public ArrayList<Mirror> mirrors = new ArrayList<Mirror>( );
		public ArrayList<Radiation_Tile> radiation_tiles = new ArrayList<Radiation_Tile>( );
		public ArrayList<Colour_Changer> colour_changers = new ArrayList<Colour_Changer>( );
		public ArrayList<Block> blocks = new ArrayList<Block>( );

		public static final String LOG = Simulation.class.getSimpleName();
		
		public Colour_Changer colour_changer_1;
		public Colour_Changer colour_changer_2;
		public Colour_Changer colour_changer_3;
		
        public Fire_Button fire_button;
        public Pause_Button pause_button;
        
        public Block block_1;
        public Block block_2;
        public Block block_3;
        public Block block_4;
        public Block block_5;
        public Block block_6;
        public Block block_7;
        public Block block_8;
        public Block block_9;
        
        public Cube cube_green_1;
        public Cube cube_green_2;
        public Cube cube_red;
        
        public Mirror mirror_1;
        public Mirror mirror_2;
        public Mirror mirror_3;
        public Mirror mirror_4;
        public Mirror mirror_5;
        public Mirror mirror_6;
        public Mirror mirror_7;
        public Mirror mirror_8;

        public Radiation_Tile radiation_tile_1;
        public Radiation_Tile radiation_tile_2;
        public Radiation_Tile radiation_tile_3;
        public Radiation_Tile radiation_tile_4;
        public Radiation_Tile radiation_tile_5;
        public Radiation_Tile radiation_tile_6;
        public Radiation_Tile radiation_tile_7;
        public Radiation_Tile radiation_tile_8;
        public Radiation_Tile radiation_tile_9;
        public Radiation_Tile radiation_tile_10;
        public Radiation_Tile radiation_tile_11;
        
        Laser laser;
        
        private float touchX = 0;
        private float touchY = 0;
        
        private float width = 0;
        private float height = 0;
        
        private float touch_distance_x = 0;
        private float touch_distance_y = 0;
        
        private float touch_next_button_distance = 100;
        private float touch_level_select_button_distance = 100;
        
        private float[] rotate_mirrors = new float[30];
        private float[] rotate_cubes = new float[30];
        private float[] rotate_colour_changers = new float[30];
        
        private boolean[] mirrors_rotated = new boolean[30];
        private boolean[] cubes_rotated = new boolean[30];
        private boolean[] colour_changers_rotated = new boolean[30];
        
        private boolean touched_down = false;
        
        private boolean reset = false;
        private boolean back_to_menu = false;
        
        private boolean pressed_back_button = false;

        private boolean[] mirror_finger = new boolean[30];
        private boolean[] cube_finger = new boolean[30];
        private boolean[] colour_changer_finger = new boolean[30];
        
        int section = 0;
        
        private boolean fast_press = false;
        
        private boolean game_won = false;
        private boolean pause = false;
        
        private boolean laser_fired = false;
        
        private boolean[] radiation_tile_touch = new boolean[30];
        
        public boolean[] mirror_touch = new boolean[30];
        public boolean[] colour_changer_touch = new boolean[30];
        
        private int[] mirror_shape = new int[30];
        private int[] colour_changer_colour = new int[30];
        private int[] radiation_tiles_colour = new int[30];

        private boolean[] mirror_solid = new boolean[30];
        private boolean[] cube_solid = new boolean[30];
        private boolean[] colour_changer_solid = new boolean[30];
        
        private Level32 level;
        
        private Object_Movement movement;
        private Object_Rotation rotation;
        private Check_Touch check_touch;
        private Object_Touch object_touch;
        private Laser_Touch laser_touch;
        
        private boolean wait = false;
        
        private boolean next_level_button_selected = false;
        private boolean menu_button_selected = false;
        
        private Main main;
        private boolean ad_check = true;
        
        public Simulation( Level32 level, Main main )
        {
        		
        		this.level = level;
        		this.main = main;
                populate( );
                
        }
        
        public void populate( )
        {
        	 
	        	for( int k = 0; k < mirror_touch.length; k++ )
				{
					mirror_touch[k] = true;
				}
	        	
	        	for( int l = 0; l < colour_changer_touch.length; l++ )
				{
					colour_changer_touch[l] = true;
				}
	        	
	        	for( int m = 0; m < mirrors_rotated.length; m++ )
				{
	        		mirrors_rotated[m] = false;
				}
	        	
	        	for( int n = 0; n < mirror_shape.length; n++ )
				{
	        		mirror_shape[n] = 0;
				}
	        	
	        	for( int o = 0; o < colour_changer_colour.length; o++ )
				{
	        		colour_changer_colour[o] = 0;
				}
	        	
	        	for( int p = 0; p < radiation_tiles_colour.length; p++ )
				{
	        		radiation_tiles_colour[p] = 0;
				}
	        	
	        	for( int q = 0; q < mirror_solid.length; q++ )
	        	{
	        		mirror_solid[q] = true;
	        	}
	        	
	        	for( int q = 0; q < cube_solid.length; q++ )
	        	{
	        		cube_solid[q] = true;
	        	}
	        	
	        	for( int q = 0; q < colour_changer_solid.length; q++ )
	        	{
	        		colour_changer_solid[q] = true;
	        	}
	        	
        	
        		cubes.add( null );
        		mirrors.add( null );
        		radiation_tiles.add( null );
        		colour_changers.add( null );
        		blocks.add( null );
        	
        		fire_button = new Fire_Button( new Vector( -75, -35, 0 ));
        		pause_button = new Pause_Button( new Vector( 80, 40, 0 ));

        		cube_green_1 = new Cube();
        		cube_green_1.position.set( 30, 20, 0 );
        		cubes.add(cube_green_1);
        		cube_green_2 = new Cube();
        		cube_green_2.position.set( -30, 0, 0 );
        		cubes.add(cube_green_2);
        		cube_red = new Cube();
        		cube_red.position.set( 0, -30, 0 );
        		cubes.add(cube_red);
        		
        		//green
        		radiation_tile_1 = new Radiation_Tile( new Vector( -80, -30, 0));
        		radiation_tiles.add( radiation_tile_1 );
        		radiation_tile_2 = new Radiation_Tile( new Vector( -70, 20, 0));
        		radiation_tiles.add( radiation_tile_2 );
        		radiation_tile_3 = new Radiation_Tile( new Vector( -60, -40, 0));
        		radiation_tiles.add( radiation_tile_3 );
        		radiation_tile_4 = new Radiation_Tile( new Vector( -60, 40, 0));
        		radiation_tiles.add( radiation_tile_4 );
        		radiation_tile_5 = new Radiation_Tile( new Vector( 0, 40, 0));
        		radiation_tiles.add( radiation_tile_5 );
        		radiation_tile_6 = new Radiation_Tile( new Vector( 50, 40, 0));
        		radiation_tiles.add( radiation_tile_6 );
        		radiation_tile_7 = new Radiation_Tile( new Vector( 50, -40, 0));
        		radiation_tiles.add( radiation_tile_7 );
        		radiation_tile_8 = new Radiation_Tile( new Vector( 60, -30, 0));
        		radiation_tiles.add( radiation_tile_8 );
        		radiation_tile_9 = new Radiation_Tile( new Vector( 70, 20, 0));
        		radiation_tiles.add( radiation_tile_9 );
        		
        		//red
        		radiation_tile_10 = new Radiation_Tile( new Vector( 40, 0, 0));
        		radiation_tiles.add( radiation_tile_10 );
        		radiation_tile_11 = new Radiation_Tile( new Vector( -40, 0, 0));
        		radiation_tiles.add( radiation_tile_11 );

        		mirror_1 = new Mirror();
        		mirror_1.position.set( 80, -10, 0 );
        		mirrors.add(mirror_1);
        		mirror_2 = new Mirror();
        		mirror_2.position.set( 50, 30, 0 );
        		mirrors.add(mirror_2);
        		mirror_3 = new Mirror();
        		mirror_3.position.set( 0, 30, 0 );
        		mirrors.add(mirror_3);
        		mirror_4 = new Mirror();
        		mirror_4.position.set( -50, 30, 0 );
        		mirrors.add(mirror_4);
        		mirror_5 = new Mirror();
        		mirror_5.position.set( -40, -20, 0 );
        		mirrors.add(mirror_5);
        		mirror_6 = new Mirror();
        		mirror_6.position.set( -80, -10, 0 );
        		mirrors.add(mirror_6);
        		mirror_7 = new Mirror();
        		mirror_7.position.set( -60, 20, 0 );
        		mirrors.add(mirror_7);
        		mirror_8 = new Mirror();
        		mirror_8.position.set( 20, -40, 0 );
        		mirrors.add(mirror_8);
        		
        		block_1 = new Block( new Vector( -10, 10, 0 ));
        		blocks.add( block_1 );
        		block_2 = new Block( new Vector( 0, 10, 0 ));
        		blocks.add( block_2 );
        		block_3 = new Block( new Vector( 10, 10, 0 ));
        		blocks.add( block_3 );
        		block_4 = new Block( new Vector( -10, 0, 0 ));
        		blocks.add( block_4 );
        		block_5 = new Block( new Vector( 0, 0, 0 ));
        		blocks.add( block_5 );
        		block_6 = new Block( new Vector( 10, 0, 0 ));
        		blocks.add( block_6 );
        		block_7 = new Block( new Vector( -10, -10, 0 ));
        		blocks.add( block_7 );
        		block_8 = new Block( new Vector( 0, -10, 0 ));
        		blocks.add( block_8 );
        		block_9 = new Block( new Vector( 10, -10, 0 ));
        		blocks.add( block_9 );
        		
        		mirror_shape[1] = single_refraction;
        		mirror_shape[2] = single_refraction;
        		mirror_shape[3] = single_refraction;
        		mirror_shape[4] = single_refraction;
        		mirror_shape[5] = double_refraction;
        		mirror_shape[6] = double_refraction;
        		mirror_shape[7] = triple_refraction;
        		mirror_shape[8] = triple_refraction;
        		
        		mirror_solid[1] = false;
        		mirror_solid[2] = false;
        		mirror_solid[3] = false;
        		mirror_solid[4] = false;
        		mirror_solid[5] = false;
        		mirror_solid[6] = false;
        		mirror_solid[7] = false;
        		mirror_solid[8] = false;
        		
        		cube_solid[1] = false;
        		cube_solid[2] = false;
        		cube_solid[3] = false;
        		
                radiation_tiles_colour[1] = groen;
                radiation_tiles_colour[2] = groen;
                radiation_tiles_colour[3] = groen;
                radiation_tiles_colour[4] = groen;
                radiation_tiles_colour[5] = groen;
                radiation_tiles_colour[6] = groen;
                radiation_tiles_colour[7] = groen;
                radiation_tiles_colour[8] = groen;
                radiation_tiles_colour[9] = groen;
                radiation_tiles_colour[10] = rood;
                radiation_tiles_colour[11] = rood;
        		
        		movement = new Object_Movement();
                rotation = new Object_Rotation();
                check_touch = new Check_Touch();
                object_touch = new Object_Touch( cubes, mirrors, radiation_tiles, blocks, colour_changers, mirror_solid, cube_solid, colour_changer_solid );
                laser_touch = new Laser_Touch( cubes, mirrors, radiation_tiles, blocks, colour_changers, mirror_shape, colour_changer_colour, radiation_tiles_colour );

                number_of_mirrors = ( mirrors.size() - 1 );
        	    number_of_cubes = ( cubes.size() - 1 );
        	    number_of_radiation_tiles = ( radiation_tiles.size() - 1 );
        	    number_of_colour_changers = ( colour_changers.size() - 1 );
        	    
        	    rotate_mirrors[1] = 90;
        	    rotate_mirrors[2] = 270;
        	    rotate_mirrors[3] = 90;
        	    rotate_mirrors[5] = 180;
        	    rotate_mirrors[6] = 270;
        	    
        	    rotate_cubes[2] = 90;
        	    
        }
        
        public void variables( float touchX, float touchY, float width, float height, boolean touched_down, boolean fast_press, boolean pressed_back_button ) 
        {
        	
    		this.width = width;
    		this.height = height;
    		
    		this.touchX = touchX;
    		this.touchY = touchY;
    		
    		this.touched_down = touched_down;
    		this.fast_press = fast_press;
    		
    		this.pressed_back_button = pressed_back_button;
        }

        public void update( float delta )
        {
        	Check_Touch();
        	
        	object_touch.initialize_variables( touch_distance_x, touch_distance_y, touched_down, pressed_back_button, fast_press, rotate_mirrors, rotate_cubes, rotate_colour_changers );
        	
        	if( pause )
        	{
        		if( ad_check == false )
        		{
        			main.ExternalHandler.showAds( true );
        			ad_check = true;
        		}
        		Pause_Actions();
        	}
        	else
        	{
        		
        		if( game_won )
        		{
        			if( ad_check == false )
            		{
            			main.ExternalHandler.showAds( true );
            			ad_check = true;
            		}
        			check_finish();
        		}
        		else
        		{
        			if( ad_check == true )
            		{
            			main.ExternalHandler.showAds( false );
            			ad_check = false;
            		}
                	Object_Touch();
                	
        			if( laser_fired)
        	    	{
        				Laser_Actions();
        	    	}
                	else
                	{
                		Movement( delta );
                	}
        		}
        	}
        }
        
        private void Movement( float delta )
        {
        	movement.Move_Mirrors( mirror_finger, touch_distance_x, touch_distance_y, breedte, hoogte, delta, mirrors );
        	movement.Move_Cubes( cube_finger, touch_distance_x, touch_distance_y, breedte, hoogte, delta, cubes );
        	movement.Move_Colour_Changers( colour_changer_finger, touch_distance_x, touch_distance_y, breedte, hoogte, delta, colour_changers );
        	rotate_mirrors = rotation.Rotate_Mirrors_Update( number_of_mirrors, mirrors_rotated, rotate_mirrors );
        	rotate_cubes = rotation.Rotate_Cubes_Update( number_of_cubes, cubes_rotated, rotate_cubes );
        	rotate_colour_changers = rotation.Rotate_Colour_Changer_Update( number_of_colour_changers, colour_changers_rotated, rotate_colour_changers );
        }
        
        private void Check_Touch()
        {
        	check_touch.Check_Touched( width, height, touchX, touchY );
        	if( touched_down )
        	{
                touch_distance_x = check_touch.Get_Touch_Distance_X();
                touch_distance_y = check_touch.Get_Touch_Distance_Y();
                wait = true;
        	}
        	else
        	{
        		if( wait)
        		{
        			touch_distance_x = check_touch.Get_Touch_Distance_X();
                    touch_distance_y = check_touch.Get_Touch_Distance_Y();
                    wait = false;
        		}
        		else
        		{
            		touch_distance_x = 500;
            		touch_distance_y = 500;
        		}
        	}
        }
        
        
        private void Laser_Actions()
        {
        	laser_touch.Initialize( rotate_mirrors, green_lasers, red_lasers, yellow_lasers, laser_fired );
			laser_touch.UpdateShots_Green();
			laser_touch.UpdateShots_Red();
			laser_touch.UpdateShots_Yellow();
			laser_touch.Update_Energy();
			green_lasers = laser_touch.green_lasers;
			red_lasers = laser_touch.red_lasers;
			yellow_lasers = laser_touch.yellow_lasers;
			
			radiation_tile_touch = laser_touch.radiation_tile_touch();
			
			laser_fired = laser_touch.laser_fired();
			
			game_won = laser_touch.game_won();
        }
        
        private void Pause_Actions()
        {
        	object_touch.pause_check();
    		back_to_menu = object_touch.back_to_menu();
        	reset = object_touch.reset();
    		pause = object_touch.pause();
    		
        	if( back_to_menu )
        	{
        		level.Game_Finished( 0 );
        	}
        	
        	if( reset )
        	{
        		cubes.get(1).position.set( new Vector( 30, 20, 0 ));
        		cubes.get(2).position.set( new Vector( -30, 0, 0 ));
        		cubes.get(3).position.set( new Vector( 0, -30, 0 ));
        		
        		mirrors.get(1).position.set( new Vector( 80, -10, 0 ));
        		mirrors.get(2).position.set( new Vector( 50, 30, 0 ));
        		mirrors.get(3).position.set( new Vector( 0, 30, 0 ));
        		mirrors.get(4).position.set( new Vector( -50, 30, 0 ));
        		mirrors.get(5).position.set( new Vector( -40, -20, 0 ));
        		mirrors.get(6).position.set( new Vector( -80, -10, 0 ));
        		mirrors.get(7).position.set( new Vector( -60, 20, 0 ));
        		mirrors.get(8).position.set( new Vector( 20, -40, 0 ));
        	}
        }


        private void check_finish()
        {
        	touch_next_button_distance = new Vector(-17, -5, 0).distance( new Vector ( touch_distance_x, touch_distance_y, 0 ));
        	touch_level_select_button_distance = new Vector( 17, -5, 0 ).distance( new Vector ( touch_distance_x, touch_distance_y, 0 ));

        	
        	if (touch_next_button_distance < 10 && touched_down)
        	{
        		next_level_button_selected = true;
        	}
        	
        	if (touch_level_select_button_distance < 10 && touched_down)
        	{
        		menu_button_selected = true;
        	}
        	
        	if( pressed_back_button )
        	{
        		level.Game_Finished( 0 );
        	}
        	
        	if( touched_down )
        	{
        		
        	}
        	else
        	{
        		if(( touch_next_button_distance < 10 && next_level_button_selected ))
        		{
        			next_level_button_selected = false;
        			level.Game_Finished( 33 );
        		}
        		
        		if(( touch_level_select_button_distance < 10 && menu_button_selected ))
        		{
            		menu_button_selected = false;
            		level.Game_Finished( 0 );
        		}
        		
        		next_level_button_selected = false;
        		menu_button_selected = false;
        	}
        	 
        }
        
        
        private void Object_Touch()
        {
        	object_touch.touched_essentials( fire_button, pause_button );
        	pause = object_touch.pause();
        	
        	object_touch.touched_mirrors();
        	
        	rotate_mirrors = object_touch.rotate_mirrors();
        	mirror_finger = object_touch.mirror_finger();
        	mirrors_rotated = object_touch.mirrors_rotated();
        	
        	object_touch.touched_cubes();
        	
        	rotate_cubes = object_touch.rotate_cubes();
        	cube_finger = object_touch.cube_finger();
        	cubes_rotated = object_touch.cubes_rotated();
        	
        	object_touch.touched_colour_changers();
        	
        	rotate_colour_changers = object_touch.rotate_colour_changers();
        	colour_changer_finger = object_touch.colour_changer_finger();
        	colour_changers_rotated = object_touch.colour_changers_rotated();
        	
        	
        	if( object_touch.fire_laser() )
			{
				
            		if( laser_fired == false )
        			{
        				laser_fired = true;
        			
        				for( int i = 1; i <= number_of_cubes; i++ )
        				{

            				if( rotate_cubes[i] == 0 )
            				{
                				laser = new Laser();
                		    	laser.position.set( cubes.get(i).position.x, cubes.get(i).position.y, 0 );
                		    	shoot_lasers( i );
                		    	laser.direction( true, true );
            				}
            				else if( rotate_cubes[i]  == 90 )
            				{
            					laser = new Laser();
                		    	laser.position.set( cubes.get(i).position.x, cubes.get(i).position.y, 0 );
                		    	shoot_lasers( i );
                		    	laser.direction( false, false );
            				}
            				else if( rotate_cubes[i]  == 180 )
            				{
            					laser = new Laser();
                		    	laser.position.set( cubes.get(i).position.x, cubes.get(i).position.y, 0 );
                		    	shoot_lasers( i );
                		    	laser.direction( true, false );
            				}
            				else if( rotate_cubes[i]  == 270 )
            				{
            					laser = new Laser();
            					laser.position.set( cubes.get(i).position.x, cubes.get(i).position.y, 0 );
            					shoot_lasers( i );
            					laser.direction( false, true );
            				}
            				Gdx.app.log( Simulation.LOG, "green laser " + green_lasers.size() + " add" );
        				}
        			}
			}
        	

        	if( pressed_back_button )
        	{
        		pause = true;
        	}
        	
        }
        
        
        private void shoot_lasers( int i )
        {
        	if( i == 1 )
	    	{
    		    green_lasers.add( laser );
	    	}
        	else if( i == 2 )
        	{
        		green_lasers.add( laser );
        	}
        	else if( i == 3 )
        	{
        		red_lasers.add( laser );
        	}
        }
        
        
        public float[] rotate_cubes()
        {
        	return rotate_cubes;
        }
        
        public float[] rotate_mirrors()
        {
        	return rotate_mirrors;
        }
        
        public float[] rotate_colour_changers()
        {
        	return rotate_colour_changers;
        }
        
        public boolean pause()
        {
        	return pause;
        }
        
        public boolean continue_button_touched()
        {
        	return object_touch.continue_button_touched();
        }
        
        public boolean back_button_touched()
        {
        	return object_touch.back_button_touched();
        }
        
        public boolean reset_button_touched()
        {
        	return object_touch.reset_button_touched();
        }
        
        public boolean touched_pause_button()
        {
        	return object_touch.touched_pause_button();
        }
        
        public boolean[] radiation_tile_touch()
        {
        	return radiation_tile_touch;
        }
        
        public boolean game_won()
        {
        	return game_won;
        }
        
}
