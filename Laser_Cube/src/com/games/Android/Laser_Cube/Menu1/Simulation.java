package com.games.Android.Laser_Cube.Menu1;


import java.util.ArrayList;

import com.games.Android.Laser_Cube.Load.Check_Touch;
import com.games.Android.Laser_Cube.Load.Vector;
import com.games.Android.Laser_Cube.Objects.Back_Button;
import com.games.Android.Laser_Cube.Objects.Cube;
import com.games.Android.Laser_Cube.Objects.Laser;
import com.games.Android.Laser_Cube.Objects.Mirror;
import com.badlogic.gdx.Gdx;

public class Simulation 
{   

		public float breedte = 80;
		public float hoogte = 40;
		
		private int number_of_mirrors = 42;
		
		public Back_Button back_button;
		public Back_Button back_button_2;
		
		public ArrayList<Laser> lasers = new ArrayList<Laser>( );
		public ArrayList<Mirror> mirrors = new ArrayList<Mirror>( );
		public ArrayList<Cube> cubes = new ArrayList<Cube>( );
		

		public Mirror mirror_1;
	    public Mirror mirror_2;
	    public Mirror mirror_3;
	    public Mirror mirror_4;
	    public Mirror mirror_5;
	    public Mirror mirror_6;
	    public Mirror mirror_7;
	    public Mirror mirror_8;
	    public Mirror mirror_9;
	    public Mirror mirror_10;
	    public Mirror mirror_11;
	    public Mirror mirror_12;
	    public Mirror mirror_13;
	    public Mirror mirror_14;
	    public Mirror mirror_15;
	    public Mirror mirror_16;
	    public Mirror mirror_17;
	    public Mirror mirror_18;
	    public Mirror mirror_19;
	    public Mirror mirror_20;
	    public Mirror mirror_21;
	    public Mirror mirror_22;
	    public Mirror mirror_23;
	    public Mirror mirror_24;
	    public Mirror mirror_25;
	    public Mirror mirror_26;
	    public Mirror mirror_27;
	    public Mirror mirror_28;
	    public Mirror mirror_29;
	    public Mirror mirror_30;
	    public Mirror mirror_31;
	    public Mirror mirror_32;
	    public Mirror mirror_33;
	    public Mirror mirror_34;
	    public Mirror mirror_35;
	    public Mirror mirror_36;
	    public Mirror mirror_37;
	    public Mirror mirror_38;
	    public Mirror mirror_39;
	    public Mirror mirror_40;
	    public Mirror mirror_41;
	    public Mirror mirror_42;
		
	    private float[] touch_mirror_distance = new float[50];
	    private boolean[] touched = new boolean[50];
	    private float touch_back_button_distance = 100;
	    private float touch_back_button_2_distance = 100;
	    private boolean touched_back_button = false;
	    private boolean touched_back_button_2 = false;
		
		public static final String LOG = Simulation.class.getSimpleName();
        
        
        private float touchX = 0;
        private float touchY = 0;
        
        private float width = 0;
        private float height = 0;
        
        private float touch_distance_x = 0;
        private float touch_distance_y = 0;
        
        public boolean[] mirror_touch = new boolean[30];
        
        private boolean touched_down = false;
        private boolean mirror_touched = false;
        
        private boolean pressed_back_button = false;
        
        int section = 0;
        
        private Menu1 game;
        
        private int[] state = new int[30];
       
        private Check_Touch check_touch;
        
        private boolean next_section = false;
        private boolean previous_section = false;
        private float shift = 0;
        
        private float shift_speed = 5f;
        
        
        public Simulation( Menu1 game )
        {
        		this.game = game;
                populate( );
        }
        
        public void populate( )
        {
        	
        		mirrors.add(null);
        		
	        	mirror_1 = new Mirror();
	            mirror_1.position.set( 60, 30, 0);
	            mirrors.add(mirror_1);
	            mirror_2 = new Mirror();
	            mirror_2.position.set( 30, 30, 0);
	            mirrors.add(mirror_2);
	            mirror_3 = new Mirror();
	            mirror_3.position.set( 0, 30, 0);
	            mirrors.add(mirror_3);
	            mirror_4 = new Mirror();
	            mirror_4.position.set( -30, 30, 0);
	            mirrors.add(mirror_4);
	            mirror_5 = new Mirror();
	            mirror_5.position.set( -60, 30, 0);
	            mirrors.add(mirror_5);
	            mirror_6 = new Mirror();
	            mirror_6.position.set( 60, 10, 0);
	            mirrors.add(mirror_6);
	            mirror_7 = new Mirror();
	            mirror_7.position.set( 30, 10, 0);
	            mirrors.add(mirror_7);
	            mirror_8 = new Mirror();
	            mirror_8.position.set( 0, 10, 0);
	            mirrors.add(mirror_8);
	            mirror_9 = new Mirror();
	            mirror_9.position.set( -30, 10, 0);
	            mirrors.add(mirror_9);
	            mirror_10 = new Mirror();
	            mirror_10.position.set( -60, 10, 0);
	            mirrors.add(mirror_10);
	            mirror_11 = new Mirror();
	            mirror_11.position.set( 60, -10, 0);
	            mirrors.add(mirror_11);
	            mirror_12 = new Mirror();
	            mirror_12.position.set( 30, -10, 0);
	            mirrors.add(mirror_12);
	            mirror_13 = new Mirror();
	            mirror_13.position.set( 0, -10, 0);
	            mirrors.add(mirror_13);
	            mirror_14 = new Mirror();
	            mirror_14.position.set( -30, -10, 0);
	            mirrors.add(mirror_14);
	            mirror_15 = new Mirror();
	            mirror_15.position.set( -60, -10, 0);
	            mirrors.add(mirror_15);
	            mirror_16 = new Mirror();
	            mirror_16.position.set( 60, -30, 0);
	            mirrors.add(mirror_16);
	            mirror_17 = new Mirror();
	            mirror_17.position.set( 30, -30, 0);
	            mirrors.add(mirror_17);
	            mirror_18 = new Mirror();
	            mirror_18.position.set( 0, -30, 0);
	            mirrors.add(mirror_18);
	            mirror_19 = new Mirror();
	            mirror_19.position.set( -30, -30, 0);
	            mirrors.add(mirror_19);
	            mirror_20 = new Mirror();
	            mirror_20.position.set( -60, -30, 0);
	            mirrors.add(mirror_20);
	            
	            mirror_21 = new Mirror();
	            mirror_21.position.set( -120, 30, 0);
	            mirrors.add(mirror_21);
	            mirror_22 = new Mirror();
	            mirror_22.position.set( -150, 30, 0);
	            mirrors.add(mirror_22);
	            mirror_23 = new Mirror();
	            mirror_23.position.set( -180, 30, 0);
	            mirrors.add(mirror_23);
	            mirror_24 = new Mirror();
	            mirror_24.position.set( -210, 30, 0);
	            mirrors.add(mirror_24);
	            mirror_25 = new Mirror();
	            mirror_25.position.set( -240, 30, 0);
	            mirrors.add(mirror_25);
	            mirror_26 = new Mirror();
	            mirror_26.position.set( -120, 10, 0);
	            mirrors.add(mirror_26);
	            mirror_27 = new Mirror();
	            mirror_27.position.set( -150, 10, 0);
	            mirrors.add(mirror_27);
	            mirror_28 = new Mirror();
	            mirror_28.position.set( -180, 10, 0);
	            mirrors.add(mirror_28);
	            mirror_29 = new Mirror();
	            mirror_29.position.set( -210, 10, 0);
	            mirrors.add(mirror_29);
	            mirror_30 = new Mirror();
	            mirror_30.position.set( -240, 10, 0);
	            mirrors.add(mirror_30);
	            mirror_31 = new Mirror();
	            mirror_31.position.set( -120, -10, 0);
	            mirrors.add(mirror_31);
	            mirror_32 = new Mirror();
	            mirror_32.position.set( -150, -10, 0);
	            mirrors.add(mirror_32);
	            mirror_33 = new Mirror();
	            mirror_33.position.set( -180, -10, 0);
	            mirrors.add(mirror_33);
	            mirror_34 = new Mirror();
	            mirror_34.position.set( -210, -10, 0);
	            mirrors.add(mirror_34);
	            mirror_35 = new Mirror();
	            mirror_35.position.set( -240, -10, 0);
	            mirrors.add(mirror_35);
	            mirror_36 = new Mirror();
	            mirror_36.position.set( -120, -30, 0);
	            mirrors.add(mirror_36);
	            mirror_37 = new Mirror();
	            mirror_37.position.set( -150, -30, 0);
	            mirrors.add(mirror_37);
	            mirror_38 = new Mirror();
	            mirror_38.position.set( -180, -30, 0);
	            mirrors.add(mirror_38);
	            mirror_39 = new Mirror();
	            mirror_39.position.set( -210, -30, 0);
	            mirrors.add(mirror_39);
	            mirror_40 = new Mirror();
	            mirror_40.position.set( -240, -30, 0);
	            mirrors.add(mirror_40);
	            
	            mirror_41 = new Mirror();
	            mirror_41.position.set( -80, 0, 0 );
	            mirrors.add( mirror_41 );
	            mirror_42 = new Mirror();
	            mirror_42.position.set( -100, 0, 0 );
	            mirrors.add( mirror_42 );
	            
	            back_button = new Back_Button( new Vector( 80, -40, 0 ));
	            back_button_2 = new Back_Button( new Vector( -100, -40, 0 ));

	            check_touch = new Check_Touch();
	            
	            this.state = game.state();
	            
                Gdx.app.log( Simulation.LOG, "Ship added" );
                
        }
        
        public void variables( float touchX, float touchY, float width, float height, boolean touched_down, boolean pressed_back_button ) 
        {
        	
    		this.width = width;
    		this.height = height;
    		
    		this.touchX = touchX;
    		this.touchY = touchY;
    		
    		this.touched_down = touched_down;
    		
    		this.pressed_back_button = pressed_back_button;
    		
        }

        public void update( float delta )
        {
        	
        	check_touch.Check_Touched( width, height, touchX, touchY );
        	touch_distance_x = check_touch.Get_Touch_Distance_X();
        	touch_distance_y = check_touch.Get_Touch_Distance_Y();
        	
        	Section_Update();
        	
        	object_touch();
        	
        }

        private void Section_Update()
        {
        	if( next_section )
        	{
        		shift += shift_speed;
        		for( int i = 1; i <= number_of_mirrors; i++ )
        		{
        			mirrors.get(i).position.x += shift_speed;
        		}
        		
        		back_button.position.x += shift_speed;
        		back_button_2.position.x += shift_speed;
        		
        		if( shift >= 180 )
        		{
        			next_section = false;
        		}
        	}
        	
        	if( previous_section )
        	{
        		shift -= shift_speed;
        		for( int i = 1; i <= number_of_mirrors; i++ )
        		{
        			mirrors.get(i).position.x -= shift_speed;
        		}
        		
        		back_button.position.x -= shift_speed;
        		back_button_2.position.x -= shift_speed;
        		
        		if( shift <= 0 )
        		{
        			previous_section = false;
        		}
        	}
        }
        
        private void object_touch()
        {
        	
        	touch_back_button_distance = back_button.position.distance( new Vector( touch_distance_x, touch_distance_y, 0 ));
        	touch_back_button_2_distance = back_button_2.position.distance( new Vector( touch_distance_x, touch_distance_y, 0 ));
        	

        	for( int i = 1; i <= number_of_mirrors; i++ )
        	{
        		
        		touch_mirror_distance[i] = mirrors.get(i).position.distance( new Vector( touch_distance_x, touch_distance_y, 0 ));
        	
        		
        		if( touch_mirror_distance[i] < 6 && touched_down )
        		{
        			if( !mirror_touched )
        			{
        				mirror_touched = true;
            			touched[i] = true;
        			}
        		}
        		
        		if( touched_down )
        		{
        			
        		}
        		else
        		{
        			
        			if( touched[i] )
        			{
        				if( touch_mirror_distance[i] < 6 )
        				{

    						if( i == 41 )
    						{
    							next_section = true;
    						}
    						
    						if( i == 42 )
    						{
    							previous_section = true;
    						}
    						
        					if( state[i] == 0 )
        					{
        						
        					}
        					else
        					{
                				game.Game_Finished(i);
        					}
        				}
        				touched[i] = false;
        				mirror_touched = false;
        			}
        			
        		}
        	}
        	
        	if( touch_back_button_distance < 6 && touched_down )
    		{
        		if( !mirror_touched )
    			{
        			mirror_touched = true;
            		touched_back_button = true;
    			}
    		}
        	
        	if( touch_back_button_2_distance < 6 && touched_down )
        	{
        		if( !mirror_touched )
        		{
        			mirror_touched = true;
        			touched_back_button_2 = true;
        		}
        	}
        	
        	if( touched_down )
    		{
    			
    		}
    		else
    		{
    			if( touched_back_button )
    			{
    				if( touch_back_button_distance < 10 )
    	    		{
    					game.Game_Finished( 8008 );
    	    		}
    				touched_back_button = false;
    				mirror_touched = false;
    			}
    			
    			if( touched_back_button_2 )
    			{
    				if( touch_back_button_2_distance < 10 )
    				{
    					game.Game_Finished( 8008 );
    				}
    				touched_back_button_2 = false;
    				mirror_touched = false;
    			}
    			
    		}
        	
        	if( pressed_back_button )
        	{
        		game.Game_Finished(8008);
        	}
        	
        }
        
        public boolean[] touched()
        {
        	return touched;
        }
        
        public boolean touched_back_button()
        {
        	 return touched_back_button;
        }
        
        public boolean touched_back_button_2()
        {
        	 return touched_back_button_2;
        }
        
        public boolean get_next_section()
        {
        	return next_section;
        }
        
        public float get_shift()
        {
        	return shift;
        }
}
