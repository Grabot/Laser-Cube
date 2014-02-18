package com.games.Android.Laser_Cube.Opening_Screen;


import java.util.ArrayList;

import com.games.Android.Laser_Cube.Load.Check_Touch;
import com.games.Android.Laser_Cube.Load.Vector;
import com.games.Android.Laser_Cube.Objects.Laser;
import com.games.Android.Laser_Cube.Objects.Mirror;
import com.games.Android.Laser_Cube.Objects.Opening_Tile;
import com.games.Android.Laser_Cube.Objects.Opening_Tile_Animatie;
import com.games.Android.Laser_Cube.Objects.Play_Game;
import com.games.Android.Laser_Cube.Objects.Play_Game_Animatie;
import com.badlogic.gdx.Gdx;

public class Simulation 
{   
		private float emma = 100;
		private float watson = 100;
    
		public float breedte = 80;
		public float hoogte = 40;
		
	    private int links = 11;
	    private int boven = 12;
	    private int rechts = 13;
	    private int onder = 14;
		
		public ArrayList<Laser> lasers = new ArrayList<Laser>( );
		public ArrayList<Mirror> mirrors = new ArrayList<Mirror>( );
		public ArrayList<Opening_Tile_Animatie> opening_tile_animaties = new ArrayList<Opening_Tile_Animatie>( );
		public ArrayList<Play_Game_Animatie> play_game_animaties = new ArrayList<Play_Game_Animatie>( );
		
		public Opening_Tile opening_tile;
		public Play_Game play_game_title;
		
		Laser laser;
		Mirror mirror;
		
		Mirror mirror_1;
		Mirror mirror_2;
		Mirror mirror_3;
		Mirror mirror_4;
		
		public static final String LOG = Simulation.class.getSimpleName();
        
        
        private float touchX = 0;
        private float touchY = 0;
        
        private float width = 0;
        private float height = 0;
        
        private float number_laser = 0;
        
        private float touch_distance_x = 0;
        private float touch_distance_y = 0;
        
        private float touch_play_game_distance = 100;
        
        private boolean play_game_touched = false;
        
        private boolean start_playing_game = false;
        
        private boolean laser_fired = false;
        
        private boolean pressed_back_button = false;
        
        public boolean[] mirror_touch = new boolean[30];
        
        private boolean touched_down = false;
        
        int section = 0;
        
        private Opening_Screen game;
        
        private Check_Touch check_touch;
       
        
        public Simulation( Opening_Screen game )
        {
        		this.game = game;
                populate( );
        }
        
        public void populate( )
        {
        	
        		for( int k = 0; k < mirror_touch.length; k++ )
        		{
    				mirror_touch[k] = true;
        		}
        		
        		
        		mirrors.add(null);


                mirror_1 = new Mirror();
                mirror_1.position.set( 80, 40, 0 );
                mirrors.add(mirror_1);
                mirror_2 = new Mirror();
                mirror_2.position.set( 80, -40, 0 );
                mirrors.add(mirror_2);
                mirror_3 = new Mirror();
                mirror_3.position.set( -80, -40, 0 );
                mirrors.add(mirror_3);
                mirror_4 = new Mirror();
                mirror_4.position.set( -80, 40, 0 );
                mirrors.add(mirror_4);
                
                opening_tile = new Opening_Tile( new Vector( 0, 20, 0 ));
                play_game_title = new Play_Game( new Vector( 0, -15, 0 ));
                
                laser = new Laser();
		    	laser.position.set( -80, -40, 0);
		    	lasers.add( laser );
		    	laser.direction( true, true );
		    	
		    	check_touch = new Check_Touch();

                Gdx.app.log( Simulation.LOG, "Ship added" );
                

				play_game_touched = false;
				touch_play_game_distance = 100;
                
        }
        
        public void variables( float touchX, float touchY, float width, float height, boolean touched_down, boolean pressed_back_button ) 
        {
        	
    		this.width = width;
    		this.height = height;
    		
    		this.touchX = touchX;
    		this.touchY = touchY;
    		
    		this.touched_down = touched_down;
    		
    		this.pressed_back_button = pressed_back_button;
    		
    		if (opening_tile_animaties.size() <= 1)
            {
    			opening_tile_animaties.add( new Opening_Tile_Animatie( new Vector( 0, 20, 0 )));
            }
    		
    		if (play_game_animaties.size() <= 1)
            {
    			play_game_animaties.add( new Play_Game_Animatie( new Vector( 0, -15, 0 )));
            }
        }

        public void update( float delta )
        {
        	check_touch.Check_Touched( width, height, touchX, touchY );
        	touch_distance_x = check_touch.Get_Touch_Distance_X();
        	touch_distance_y = check_touch.Get_Touch_Distance_Y();
        	
        	
        	object_touch();
        	updateShots();
    		Update_Energy();
        	update_Opening_Tile( delta );   
        	update_Play_Game( delta );
        }
        
        
        ArrayList<Opening_Tile_Animatie> opening_tile_animatie_weg = new ArrayList<Opening_Tile_Animatie>( );
        public void update_Opening_Tile( float delta )
        {
        		opening_tile_animatie_weg.clear();
                for( int i = 0; i < opening_tile_animaties.size(); i++ )
                {
                        Opening_Tile_Animatie opening_tile_animatie = opening_tile_animaties.get(i);
                        opening_tile_animatie.update( delta );
                        if( opening_tile_animatie.aliveTime > Opening_Tile_Animatie.EXPLOSION_LIVE_TIME )
                        {
                        	opening_tile_animatie_weg.add( opening_tile_animatie );
                        }
                }
                
                for( int i = 0; i < opening_tile_animatie_weg.size(); i++ )
                {
                	opening_tile_animaties.remove( opening_tile_animatie_weg.get(i) );
                }
                
        }
        
        ArrayList<Play_Game_Animatie> play_game_animatie_weg = new ArrayList<Play_Game_Animatie>( );
        public void update_Play_Game( float delta )
        {
        	if( play_game_touched  )
        	{
        		play_game_animatie_weg.clear();
                for( int i = 0; i < play_game_animaties.size(); i++ )
                {
                        Play_Game_Animatie play_game_animatie = play_game_animaties.get(i);
                        play_game_animatie.update( delta );
                        if( play_game_animatie.aliveTime > Play_Game_Animatie.EXPLOSION_LIVE_TIME )
                        {
                        	play_game_animatie_weg.add( play_game_animatie );
                        }
                }
                
                for( int i = 0; i < play_game_animatie_weg.size(); i++ )
                {
                	play_game_animaties.remove( play_game_animatie_weg.get(i) );
                }
        	}
        }
        
        
        ArrayList<Laser> lasers_weg = new ArrayList<Laser>();
        private void updateShots()
        {
        	lasers_weg.clear();
        	for( int i = 0; i < lasers.size(); i++ )
            {
        			Laser laser = lasers.get(i);
        			laser.Opening_Screen( mirrors );
        			laser.update();
        			
        			for( int k = 1; k < 5; k++ )
            		{
            			
            			Refractions( laser, k );
            			
            		}
        			
        			
        			if( laser.laser_weg )
        			{
        				lasers_weg.add(laser);
        			}
        			
        			for( int k = 0; k < lasers_weg.size(); k++ )   
                    {
                        lasers.remove( lasers_weg.get(k) );
                    }
        	}
        }
        
        
        private void Refractions( Laser laser, int k )
        {

        	if( laser.touched_mirror_bottom[k] == true && mirror_touch[k] )
        	{

        			if ( k == 4 )
        			{
        				Laser_Mirror_Add( laser, k, links );

            			mirror_touch[k] = false;
            			mirror_touch[1] = true;
        			}
            		
        	}
        	
        	if( laser.touched_mirror_left[k] == true && mirror_touch[k] )
        	{
            		if ( k == 3 )
            		{
            			Laser_Mirror_Add( laser, k, boven );

            			mirror_touch[k] = false;
            			mirror_touch[4] = true;
            		}
            		
        	}
        	
        	if( laser.touched_mirror_top[k] == true && mirror_touch[k] )
        	{
        			if ( k == 2 )
        			{
        				Laser_Mirror_Add( laser, k, rechts );
        				
        				mirror_touch[k] = false;
            			mirror_touch[3] = true;
        			}
        	}
        	
        	if( laser.touched_mirror_right[k] == true && mirror_touch[k] )
        	{
        			if ( k == 1 )
        			{
            			Laser_Mirror_Add( laser, k, onder );
            			
            			mirror_touch[k] = false;
            			mirror_touch[2] = true;
        			}
            		
        	}
        }
        
        private void Laser_Mirror_Add( Laser laser, int k, int richting )
        {
        	//naar links
    		laser = new Laser();
    		laser.position.set(mirrors.get(k).position.x, mirrors.get(k).position.y, 0);
    		
    		lasers.add( laser );
    		
    		if( richting == rechts )
    		{
        		laser.direction( false, false );
    		}
    		else if( richting == links)
    		{
        		laser.direction( false, true );
    		}
    		else if( richting == boven )
    		{
    			laser.direction( true, true );
    		}
    		else if( richting == onder )
    		{
    			laser.direction( true, false );
    		}
    		
    		Gdx.app.log( Simulation.LOG, "laser " + lasers.size() + " add" );
        }
        
        
        
        
        private void Update_Energy()
        {
        	if ( laser_fired )
        	{
        		number_laser = lasers.size();


        		if ( number_laser == 0 )
        		{
        			for( int k = 0; k < mirror_touch.length; k++)
        			{
        				mirror_touch[k] = true;
        			}
        			
    				laser_fired = false;
        		}
        	}
        }
        


        private void object_touch()
        {
        	
        	touch_play_game_distance = play_game_title.position.distance( new Vector( touch_distance_x, touch_distance_y, 0 ));
        	
        	
        	if( touch_play_game_distance < 20 && touched_down)
        	{
        		play_game_touched = true;
        	}
        	
        	if( touched_down )
    		{
    		}
        	else
        	{
        		if( play_game_touched )
        		{
        			if( touch_play_game_distance < 20 )
        			{
        				start_playing_game = true;
                    	game.Game_Finished();
        			}

    				play_game_touched = false;
        		}
        	}
        	
        	if( pressed_back_button )
        	{
        		Gdx.app.exit();
        	}
        	
        }
        
        public boolean play_game_touched()
        {
        	return play_game_touched;
        }
}
