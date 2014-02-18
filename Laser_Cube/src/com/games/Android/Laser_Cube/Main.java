package com.games.Android.Laser_Cube;


import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.math.Vector3;
import com.games.Android.Laser_Cube.Level1.Level1;
import com.games.Android.Laser_Cube.Level10.Level10;
import com.games.Android.Laser_Cube.Level11.Level11;
import com.games.Android.Laser_Cube.Level12.Level12;
import com.games.Android.Laser_Cube.Level13.Level13;
import com.games.Android.Laser_Cube.Level14.Level14;
import com.games.Android.Laser_Cube.Level15.Level15;
import com.games.Android.Laser_Cube.Level16.Level16;
import com.games.Android.Laser_Cube.Level17.Level17;
import com.games.Android.Laser_Cube.Level18.Level18;
import com.games.Android.Laser_Cube.Level19.Level19;
import com.games.Android.Laser_Cube.Level2.Level2;
import com.games.Android.Laser_Cube.Level20.Level20;
import com.games.Android.Laser_Cube.Level21.Level21;
import com.games.Android.Laser_Cube.Level22.Level22;
import com.games.Android.Laser_Cube.Level23.Level23;
import com.games.Android.Laser_Cube.Level24.Level24;
import com.games.Android.Laser_Cube.Level25.Level25;
import com.games.Android.Laser_Cube.Level26.Level26;
import com.games.Android.Laser_Cube.Level27.Level27;
import com.games.Android.Laser_Cube.Level28.Level28;
import com.games.Android.Laser_Cube.Level29.Level29;
import com.games.Android.Laser_Cube.Level30.Level30;
import com.games.Android.Laser_Cube.Level31.Level31;
import com.games.Android.Laser_Cube.Level32.Level32;
import com.games.Android.Laser_Cube.Level33.Level33;
import com.games.Android.Laser_Cube.Level34.Level34;
import com.games.Android.Laser_Cube.Level35.Level35;
import com.games.Android.Laser_Cube.Level36.Level36;
import com.games.Android.Laser_Cube.Level37.Level37;
import com.games.Android.Laser_Cube.Level38.Level38;
import com.games.Android.Laser_Cube.Level39.Level39;
import com.games.Android.Laser_Cube.Level40.Level40;
import com.games.Android.Laser_Cube.Level3.Level3;
import com.games.Android.Laser_Cube.Level4.Level4;
import com.games.Android.Laser_Cube.Level5.Level5;
import com.games.Android.Laser_Cube.Level6.Level6;
import com.games.Android.Laser_Cube.Level7.Level7;
import com.games.Android.Laser_Cube.Level8.Level8;
import com.games.Android.Laser_Cube.Level9.Level9;
import com.games.Android.Laser_Cube.Load.Init_Renderer;
import com.games.Android.Laser_Cube.Load.Opening_Renderer;
import com.games.Android.Laser_Cube.Load.Screen;
import com.games.Android.Laser_Cube.Menu1.Menu1;
import com.games.Android.Laser_Cube.Opening_Screen.Opening_Screen;

public class Main implements ApplicationListener, InputProcessor
{
	public static IReqHandler ExternalHandler;

	public Main(IReqHandler irh)
	{
		Main.ExternalHandler = irh;
	}
	
	// constant useful for logging
	public static final String LOG = Main.class.getSimpleName();
		
	private FPSLogger fpsLogger;
	
	Init_Renderer init;
	Opening_Renderer opening;
	
	private Screen screen;
	
	private float touchX = 0;
	private float touchY = 0;
	
	private float delta = 0;
	
	private boolean pressed_back_button = false;
	private boolean touched_down = false;
	
	private float width = 0;
	private float height = 0;
	
	private float just_touched = 0;
	
	private boolean fast_press = false;
	
	@Override
	public void create()
	{
		Main.ExternalHandler.showAds( false );
		Gdx.input.setInputProcessor(this);
        Gdx.input.setCatchBackKey(true);
        
		init = new Init_Renderer();
		opening = new Opening_Renderer();
		
		fpsLogger = new FPSLogger();

		screen = new Opening_Screen(Gdx.app, init, opening );
		
		Gdx.app.log( Main.LOG, "Creating game" );
	}

	@Override
	public void resize(int width, int height) 
	{
		this.width = width;
		this.height = height;
	}

	/** */
	@Override
	public void render()
	{
		Gdx.gl10.glViewport( 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight() );
		Gdx.gl10.glClearColor( 0f, 0f, 0f, 1f );
		Gdx.gl10.glClear( GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT );
		Gdx.gl10.glMatrixMode( GL10.GL_PROJECTION );
		Gdx.gl10.glEnable( GL10.GL_DEPTH_TEST );
		Gdx.gl10.glEnable( GL10.GL_TEXTURE_2D );
		Gdx.gl10.glLoadIdentity();
        float aspectRatio = (float)Gdx.graphics.getWidth() / Gdx.graphics.getHeight();
        Gdx.glu.gluPerspective( Gdx.gl10, 45.0f, aspectRatio, 0.1f, 500f );
        Gdx.glu.gluLookAt( Gdx.gl10, 0, 0, -120f, 0, 0, 0, 0, 1, 0 );
        Gdx.gl10.glMatrixMode( GL10.GL_MODELVIEW );
        Gdx.gl10.glLoadIdentity();
        
		fpsLogger.log();

		touch_update();
		
		Application app = Gdx.app;
		
		// update the screen
	    screen.update( delta, touchX, touchY, width, height, touched_down, fast_press, pressed_back_button );

	    pressed_back_button = false;
	    
	    // render the screen
	    screen.render(app);
	    
	    if (screen.isDone( )) 
	    {
	        // dispose the current screen
	    	
	        screen.dispose();
	        Gdx.app.log( Main.LOG, "number: " + screen.level() );
	        
	        if( screen.level() == 8008 )
	        {
	        	Main.ExternalHandler.showAds( false );
	        	screen = new Opening_Screen(Gdx.app, init, opening );
	        }
	        else
	        {
		    	if( screen.level() == 0 )
		    	{
		    		Main.ExternalHandler.showAds( true );
		    		screen = new Menu1( Gdx.app, init );
		    	}
		    	else if( screen.level() == 1 )
		    	{
			        screen = new Level1( Gdx.app, init, this );
		    	}
		    	else if( screen.level() == 2 )
		    	{
		    		screen = new Level2( Gdx.app, init, this );
		    	}
		    	else if( screen.level() == 3 )
		    	{
		    		screen = new Level3( Gdx.app, init, this );
		    	}
		    	else if( screen.level() == 4 )
		    	{
		    		screen = new Level4( Gdx.app, init, this );
		    	}
		    	else if( screen.level() == 5 )
		    	{
			        screen = new Level5( Gdx.app, init, this );
		    	}
		    	else if( screen.level() == 6 )
		    	{
		    		screen = new Level6( Gdx.app, init, this );
		    	}
		    	else if( screen.level() == 7 )
		    	{
		    		screen = new Level7( Gdx.app, init, this );
		    	}
		    	else if( screen.level() == 8 )
		    	{
		    		screen = new Level8( Gdx.app, init, this );
		    	}
		    	else if( screen.level() == 9 )
		    	{
		    		screen = new Level9( Gdx.app, init, this );
		    	}
		    	else if( screen.level() == 10 )
		    	{
		    		screen = new Level10( Gdx.app, init, this );
		    	}
		    	else if( screen.level() == 11 )
		    	{
		    		screen = new Level11( Gdx.app, init, this );
		    	}
		    	else if( screen.level() == 12 )
		    	{
		    		screen = new Level12( Gdx.app, init, this );
		    	}
		    	else if( screen.level() == 13 )
		    	{
		    		screen = new Level13( Gdx.app, init, this );
		    	}
		    	else if( screen.level() == 14 )
		    	{
		    		screen = new Level14( Gdx.app, init, this );
		    	}
		    	else if( screen.level() == 15 )
		    	{
		    		screen = new Level15( Gdx.app, init, this );
		    	}
		    	else if( screen.level() == 16 )
		    	{
		    		screen = new Level16( Gdx.app, init, this );
		    	}
		    	else if( screen.level() == 17 )
		    	{
		    		screen = new Level17( Gdx.app, init, this );
		    	}
		    	else if( screen.level() == 18 )
		    	{
		    		screen = new Level18( Gdx.app, init, this );
		    	}
		    	else if( screen.level() == 19 )
		    	{
		    		screen = new Level19( Gdx.app, init, this );
		    	}
		    	else if( screen.level() == 20 )
		    	{
		    		screen = new Level20( Gdx.app, init, this );
		    	}
		    	else if( screen.level() == 21 )
		    	{
		    		screen = new Level21( Gdx.app, init, this );
		    	}
		    	else if( screen.level() == 22 )
		    	{
		    		screen = new Level22( Gdx.app, init, this );
		    	}
		    	else if( screen.level() == 23 )
		    	{
		    		screen = new Level23( Gdx.app, init, this );
		    	}
		    	else if( screen.level() == 24 )
		    	{
		    		screen = new Level24( Gdx.app, init, this );
		    	}
		    	else if( screen.level() == 25 )
		    	{
		    		screen = new Level25( Gdx.app, init, this );
		    	}
		    	else if( screen.level() == 26 )
		    	{
		    		screen = new Level26( Gdx.app, init, this );
		    	}
		    	else if( screen.level() == 27 )
		    	{
		    		screen = new Level27( Gdx.app, init, this );
		    	}
		    	else if( screen.level() == 28 )
		    	{
		    		screen = new Level28( Gdx.app, init, this );
		    	}
		    	else if( screen.level() == 29 )
		    	{
		    		screen = new Level29( Gdx.app, init, this );
		    	}
		    	else if( screen.level() == 30 )
		    	{
		    		screen = new Level30( Gdx.app, init, this );
		    	}
		    	else if( screen.level() == 31 )
		    	{
		    		screen = new Level31( Gdx.app, init, this );
		    	}
		    	else if( screen.level() == 32 )
		    	{
		    		screen = new Level32( Gdx.app, init, this );
		    	}
		    	else if( screen.level() == 33 )
		    	{
		    		screen = new Level33( Gdx.app, init, this );
		    	}
		    	else if( screen.level() == 34 )
		    	{
		    		screen = new Level34( Gdx.app, init, this );
		    	}
		    	else if( screen.level() == 35 )
		    	{
		    		screen = new Level35( Gdx.app, init, this );
		    	}
		    	else if( screen.level() == 36 )
		    	{
		    		screen = new Level36( Gdx.app, init, this );
		    	}
		    	else if( screen.level() == 37 )
		    	{
		    		screen = new Level37( Gdx.app, init, this );
		    	}
		    	else if( screen.level() == 38 )
		    	{
		    		screen = new Level38( Gdx.app, init, this );
		    	}
		    	else if( screen.level() == 39 )
		    	{
		    		screen = new Level39( Gdx.app, init, this );
		    	}
		    	else if( screen.level() == 40 )
		    	{
		    		screen = new Level40( Gdx.app, init, this );
		    	}
	        }
	    }
	}
	

	private void touch_update()
	{
		
		if (Gdx.input.isTouched())
		{
			Vector3 touchPos = new Vector3();
			touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			
			touchX = touchPos.x;
			touchY = touchPos.y;
			
			touched_down = true;
			just_touched += 1;
			
		}
		else
		{
			touched_down = false;
			if( (just_touched < 10) && (just_touched != 0) )
			{
				fast_press = true;
				just_touched = 0;
			}
			else
			{
				fast_press = false;
			}
			just_touched = 0;
		}
		
		delta = Gdx.graphics.getDeltaTime();

	}
	
	@Override
	public void pause() 
	{
		
	}

	@Override
	public void resume() 
	{
		
	}

	@Override
	public void dispose() 
	{

	}

	@Override
	public boolean keyDown(int keycode) 
	{
		if( keycode == Keys.ESCAPE || keycode == Keys.BACK || keycode == Keys.ENTER )
		{
	         pressed_back_button = true;
	    }
		return false;
	}

	@Override
	public boolean keyUp(int keycode) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) 
	{
		// TODO Auto-generated method stub
		return false;
	}

}
