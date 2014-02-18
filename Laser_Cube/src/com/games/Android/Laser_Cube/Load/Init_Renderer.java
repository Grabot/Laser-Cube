package com.games.Android.Laser_Cube.Load;

import java.util.ArrayList;

import com.games.Android.Laser_Cube.Load.Mesh.PrimitiveType;
import com.games.Android.Laser_Cube.Objects.Back_Button;
import com.games.Android.Laser_Cube.Objects.Block;
import com.games.Android.Laser_Cube.Objects.Colour_Changer;
import com.games.Android.Laser_Cube.Objects.Cube;
import com.games.Android.Laser_Cube.Objects.Fire_Button;
import com.games.Android.Laser_Cube.Objects.Laser;
import com.games.Android.Laser_Cube.Objects.Mirror;
import com.games.Android.Laser_Cube.Objects.Pause_Button;
import com.games.Android.Laser_Cube.Objects.Radiation_Tile;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;

public class Init_Renderer
{
	public static final String LOG = Init_Renderer.class.getSimpleName();

	Mesh background_mesh_menu;
	Mesh background_mesh_levels;

	Mesh wall_levels;
	Mesh wall_menu;
	
	Mesh[] cubes = new Mesh[151];
	Mesh[] laser_shot = new Mesh[10];
	Mesh[] cleared_levels = new Mesh[41];

	Mesh Fire_Button_Mesh;
	
	Mesh laser_shot_vertical;
	Mesh laser_shot_horizontal;
	
	Mesh pause_mesh;
	Mesh pause_button_pressed;
	Mesh help_screens;
	
	Texture Object_Atlas;
	Texture Levels_Atlas;
	Texture Levels_Cleared;
	
	Texture help_level_1;
	Texture help_level_2;
	Texture help_level_3;
	Texture help_level_4;
	Texture help_level_5;
	
	private Load_Meshes load_meshes;
	
	private float spot = 70;
	
	private int red = 1;
	private int green = 3;
	private int yellow = 5;
	
	public Init_Renderer()
	{
		if( Gdx.graphics.getWidth() > 820 || Gdx.graphics.getHeight() > 500 )
		{
			Object_Atlas = new Texture( Gdx.files.internal( "Objects_Atlas_big.png" ));
			Levels_Atlas = new Texture( Gdx.files.internal( "level_packed_40_big.png" ));
			Levels_Cleared = new Texture( Gdx.files.internal( "level_cleared_packed_10.png" ));
			help_level_1 = new Texture( Gdx.files.internal( "help_level_1_big.png" ));
			help_level_2 = new Texture( Gdx.files.internal( "help_level_2_big.png" ));
			help_level_3 = new Texture( Gdx.files.internal( "help_level_3_big.png" ));
			help_level_4 = new Texture( Gdx.files.internal( "help_level_4_big.png" ));
			help_level_5 = new Texture( Gdx.files.internal( "help_level_5_big.png" ));
		}
		else
		{
			Object_Atlas = new Texture( Gdx.files.internal( "Objects_Atlas_small.png" ));
			Levels_Atlas = new Texture( Gdx.files.internal( "level_packed_40_small.png" ));
			Levels_Cleared = new Texture( Gdx.files.internal( "level_cleared_packed_10.png" ));
			help_level_1 = new Texture( Gdx.files.internal( "help_level_1_small.png" ));
			help_level_2 = new Texture( Gdx.files.internal( "help_level_2_small.png" ));
			help_level_3 = new Texture( Gdx.files.internal( "help_level_3_small.png" ));
			help_level_4 = new Texture( Gdx.files.internal( "help_level_4_small.png" ));
			help_level_5 = new Texture( Gdx.files.internal( "help_level_5_small.png" ));
		}
		
		load_meshes = new Load_Meshes();
		
		cubes = load_meshes.Mesh_Cube();
        Fire_Button_Mesh = load_meshes.Mesh_Fire_Button();
        laser_shot = load_meshes.Mesh_Laser();
        background_mesh_levels = load_meshes.Mesh_Background();
        background_mesh_menu = load_meshes.Mesh_Background_Menu();
        wall_levels = load_meshes.Mesh_Wall();
        wall_menu = load_meshes.Mesh_Wall_Menu();
        pause_mesh = load_meshes.Mesh_Pause();
        cleared_levels = load_meshes.Mesh_Levels_Cleared();
        pause_button_pressed = load_meshes.Mesh_Transparent_Button();
        help_screens = load_meshes.Mesh_Help_Screen();
        
	}
	
	public void Bind_Object_Atlas()
	{
    	Object_Atlas.bind();
	}
	public void Bind_Level_Atlas()
	{
		Levels_Atlas.bind();
	}
	public void Bind_Cleared_Levels()
	{
        Levels_Cleared.bind();
	}
	
	
	public void laser_shot ( GL10 gl, ArrayList<Laser> lasers, int kleur )
    {
    	gl.glLoadIdentity();

    	for( int i = 0; i < lasers.size(); i++ )
        {

				gl.glEnable( GL10.GL_BLEND );
				gl.glBlendFunc( GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA );
				gl.glMatrixMode( GL10.GL_MODELVIEW );
				gl.glPushMatrix();
    			Laser laser = lasers.get(i);

            	
    			if( laser.vertical == true )
    			{
                	float laser_size = laser.laser_size;
                	
                    gl.glTranslatef( laser.position.x, (laser.position.y + laser_size), (laser.position.z - 2) );
                    gl.glScalef(1f, laser_size, 1f);
                    
                    if( kleur == 1 )
                    {
                    	laser_shot[3].render(PrimitiveType.TriangleFan);
                    }
                    else if( kleur == 3 )
                    {
                    	laser_shot[4].render(PrimitiveType.TriangleFan);
                    }
                    else if( kleur == 5 )
                    {
                    	laser_shot[5].render(PrimitiveType.TriangleFan);
                    }
    			}
    			else
    			{
                	float laser_size = laser.laser_size;
                	
                    gl.glTranslatef( (laser.position.x + laser_size), laser.position.y, (laser.position.z - 2) );
                    gl.glScalef(laser_size, 1f , 1f);
                    if( kleur == 1 )
                    {
                    	laser_shot[0].render(PrimitiveType.TriangleFan);
                    }
                    else if( kleur == 3 )
                    {
                    	laser_shot[1].render(PrimitiveType.TriangleFan);
                    }
                    else if( kleur == 5 )
                    {
                    	laser_shot[2].render(PrimitiveType.TriangleFan);
                    }
    			}
                gl.glPopMatrix();
                gl.glDisable( GL10.GL_BLEND );
            	gl.glLoadIdentity();
    	}
    	
    	
    }
	
	public void Pause_Screen( GL10 gl, boolean continue_button_touched, boolean reset_button_touched, boolean back_button_touched )
    {
    	gl.glLoadIdentity();
    	gl.glEnable( GL10.GL_BLEND );
		gl.glEnable( GL10.GL_CULL_FACE );
    	gl.glBlendFunc( GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA );
		gl.glMatrixMode( GL10.GL_MODELVIEW );
		gl.glPushMatrix();
        gl.glTranslatef( 0, 0, 0 );
        pause_mesh.render(PrimitiveType.Triangles);
        if( continue_button_touched )
        {
        	gl.glTranslatef( 0, 13, 0 );
            pause_button_pressed.render(PrimitiveType.Triangles);
        }
        else if( reset_button_touched )
        {
        	pause_button_pressed.render(PrimitiveType.Triangles);
        }
        else if( back_button_touched )
        {
        	gl.glTranslatef( 0, -13.5f, 0 );
            pause_button_pressed.render(PrimitiveType.Triangles);
        }
        gl.glPopMatrix();
        gl.glDisable( GL10.GL_BLEND );
        gl.glDisable( GL10.GL_CULL_FACE );
        gl.glLoadIdentity();
    }
	
	public void Build_Background( GL10 gl )
	{
		gl.glLoadIdentity();
		gl.glMatrixMode( GL10.GL_MODELVIEW );
		gl.glPushMatrix();
        gl.glRotatef( 0, 0, 0, 1);
        background_mesh_levels.render(PrimitiveType.TriangleStrip);
        gl.glPopMatrix();
        gl.glLoadIdentity();
	}
	
	public void Help_Screen( GL10 gl, int level )
	{
		gl.glLoadIdentity();
    	gl.glEnable( GL10.GL_BLEND );
		gl.glBlendFunc( GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA );
		gl.glMatrixMode( GL10.GL_MODELVIEW );
		gl.glPushMatrix();
        if( level == 1 )
        {
        	help_level_1.bind();
        }
        else if( level == 2 )
        {
        	help_level_2.bind();
        }
        else if( level == 3 )
        {
        	help_level_3.bind();
        }
        else if( level == 4 )
        {
        	help_level_4.bind();
        }
        else if( level == 5 )
        {
        	help_level_5.bind();
        }
        
        help_screens.render(PrimitiveType.TriangleStrip);
        gl.glPopMatrix();
        gl.glDisable( GL10.GL_BLEND );
        gl.glLoadIdentity();
	}
	
	public void Build_Background_Menu( GL10 gl, float shift )
	{
		gl.glLoadIdentity();
		gl.glMatrixMode( GL10.GL_MODELVIEW );
		gl.glPushMatrix();
		gl.glTranslatef( (shift * 0.967f), 0, 0);
        gl.glRotatef( 0, 0, 0, 1);
        background_mesh_menu.render(PrimitiveType.TriangleStrip);
        gl.glPopMatrix();
        gl.glLoadIdentity();
        
	}
	
	public void Build_Wall( GL10 gl )
	{
		gl.glLoadIdentity();
		gl.glMatrixMode( GL10.GL_MODELVIEW );
		gl.glPushMatrix();
        gl.glRotatef( 0, 0, 0, 1);
        wall_levels.render(PrimitiveType.Triangles);
        gl.glPopMatrix();
        gl.glLoadIdentity();
	}

	public void Build_Wall_Menu( GL10 gl, float shift )
    {
		gl.glLoadIdentity();
		gl.glMatrixMode( GL10.GL_MODELVIEW );
		gl.glPushMatrix();
		gl.glTranslatef( shift, 0 , 0 );
        gl.glRotatef( 0, 0, 0, 1);
        wall_menu.render(PrimitiveType.Triangles);
        gl.glPopMatrix();
        gl.glLoadIdentity();
	}
	
	public void Build_Mirror( GL10 gl, Mirror mirror, float rotate, boolean solid, int type )
    {
    	gl.glLoadIdentity();
        gl.glEnable( GL10.GL_CULL_FACE );
		gl.glMatrixMode( GL10.GL_MODELVIEW );
		gl.glPushMatrix();
        gl.glTranslatef( mirror.position.x,mirror.position.y, mirror.position.z );
        gl.glRotatef( rotate, 0, 0, 1);
        if( solid )
        {
	        if( type == 1 )
	        {
	        	cubes[11].render(PrimitiveType.Triangles);
	        }
	        else if( type == 2 )
	        {
	        	cubes[12].render(PrimitiveType.Triangles);
	        }
	        else if( type == 3 )
	        {
	        	cubes[13].render(PrimitiveType.Triangles);
	        }
	        else if( type == 4 )
	        {
	        	cubes[10].render(PrimitiveType.Triangles);
	        }
        }
        else
        {
        	if( type == 1 )
	        {
        		cubes[7].render(PrimitiveType.Triangles);
	        }
	        else if( type == 2 )
	        {
	        	cubes[8].render(PrimitiveType.Triangles);
	        }
	        else if( type == 3 )
	        {
	        	cubes[9].render(PrimitiveType.Triangles);
	        }
	        else if( type == 4 )
	        {
	        	cubes[6].render(PrimitiveType.Triangles);
	        }
        }
        gl.glPopMatrix();
        gl.glDisable( GL10.GL_CULL_FACE );
        gl.glLoadIdentity();
    }
	
	
	public void Build_Cube( GL10 gl, Cube cube, float rotate, int color, boolean solid )
    {
    	gl.glLoadIdentity();
        gl.glEnable( GL10.GL_CULL_FACE );
		gl.glMatrixMode( GL10.GL_MODELVIEW );
		gl.glPushMatrix();
        gl.glTranslatef( cube.position.x, cube.position.y, cube.position.z );
        gl.glRotatef( rotate, 0, 0, 1);
    	if( solid )
    	{
    		if( color == 1 )
    		{
    			//red
    			cubes[4].render(PrimitiveType.Triangles);
    		}
    		else if( color == 3 )
    		{
    			//green
    			cubes[3].render(PrimitiveType.Triangles);
    		}
    		else
    		{
    			//yellow
    			cubes[5].render(PrimitiveType.Triangles);
    		}
    	}
    	else
    	{
    		if( color == 1 )
    		{
    			//red
    			cubes[1].render(PrimitiveType.Triangles);
    		}
    		else if( color == 3 )
    		{
    			//green
    			cubes[0].render(PrimitiveType.Triangles);
    		}
    		else
    		{
    			//yellow
    			cubes[2].render(PrimitiveType.Triangles);
    		}
    	}
		
		gl.glPopMatrix();
        gl.glDisable( GL10.GL_CULL_FACE );
        gl.glLoadIdentity();
        
    }
	
	public void PauseButton( GL10 gl, Pause_Button pause_button, boolean touched )
    {            
		gl.glLoadIdentity();
        gl.glEnable( GL10.GL_BLEND );
        gl.glEnable( GL10.GL_CULL_FACE );
		gl.glBlendFunc( GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA );
		if( touched )
		{
			gl.glBlendFunc(GL10.GL_ONE_MINUS_DST_COLOR, GL10.GL_ZERO);
		}
		gl.glMatrixMode( GL10.GL_MODELVIEW );
		gl.glPushMatrix();
        gl.glTranslatef( pause_button.position.x, pause_button.position.y, pause_button.position.z );
        gl.glRotatef( 0, 0, 0, 1);
        cubes[24].render( PrimitiveType.Triangles );
        gl.glPopMatrix();
        gl.glDisable( GL10.GL_BLEND );
        gl.glDisable( GL10.GL_CULL_FACE );
        gl.glLoadIdentity();
    }
	
	public void Build_Return_Button( GL10 gl, Back_Button back_button, boolean touched )
    {            
		gl.glLoadIdentity();
        gl.glEnable( GL10.GL_BLEND );
        gl.glEnable( GL10.GL_CULL_FACE );
		gl.glBlendFunc( GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA );
		if( touched )
		{
			gl.glBlendFunc(GL10.GL_ONE_MINUS_DST_COLOR, GL10.GL_ZERO);
		}
		gl.glMatrixMode( GL10.GL_MODELVIEW );
		gl.glPushMatrix();
        gl.glTranslatef( back_button.position.x, back_button.position.y, back_button.position.z );
        gl.glRotatef( 0, 0, 0, 1);
        cubes[25].render( PrimitiveType.Triangles );
        gl.glPopMatrix();
        gl.glDisable( GL10.GL_BLEND );
        gl.glDisable( GL10.GL_CULL_FACE );
        gl.glLoadIdentity();
    }
	
	public void Build_Block( GL10 gl, Block block )
    {            
		gl.glLoadIdentity();
        gl.glEnable( GL10.GL_CULL_FACE );
		gl.glMatrixMode( GL10.GL_MODELVIEW );
		gl.glPushMatrix();
        gl.glTranslatef( block.position.x, block.position.y, block.position.z );
        gl.glRotatef( 0, 0, 0, 1);
        cubes[17].render( PrimitiveType.Triangles );
        gl.glPopMatrix();
        gl.glDisable( GL10.GL_CULL_FACE );
        gl.glLoadIdentity();
    }
    
    public void FireButton( GL10 gl, Fire_Button fire_button )
    {            
    	gl.glLoadIdentity();
		gl.glMatrixMode( GL10.GL_MODELVIEW );
		gl.glPushMatrix();
        gl.glTranslatef( fire_button.position.x, fire_button.position.y, fire_button.position.z );
        gl.glRotatef( 0, 0, 0, 1);
        Fire_Button_Mesh.render(PrimitiveType.Triangles);
        gl.glLoadIdentity();
    }
	
    
    public void Build_Colour_Changer( GL10 gl, Colour_Changer colour_changer_1, float rotate, int colour, boolean solid )
    {
    	gl.glLoadIdentity();
        gl.glEnable( GL10.GL_CULL_FACE );
		gl.glMatrixMode( GL10.GL_MODELVIEW );
		gl.glPushMatrix();
        gl.glTranslatef( colour_changer_1.position.x, colour_changer_1.position.y, colour_changer_1.position.z );
        gl.glRotatef( rotate, 0, 0, 1);
        if( solid )
        {
	        if( colour == red )
	        {
	        	//red
    			cubes[27].render(PrimitiveType.Triangles);
	        }
	        else if( colour == green )
	        {
	        	//green
    			cubes[26].render(PrimitiveType.Triangles);
	        }
	        else if( colour == yellow )
	        {
	        	//green
    			cubes[28].render(PrimitiveType.Triangles);
	        }
        }
        else
        {
        	if( colour == red )
	        {
        		//red
    			cubes[15].render(PrimitiveType.Triangles);
	        }
	        else if( colour == green )
	        {
	        	//green
    			cubes[14].render(PrimitiveType.Triangles);
	        }
	        else if( colour == yellow )
	        {
	        	//yellow
    			cubes[16].render(PrimitiveType.Triangles);
	        }
        }
        gl.glDisable( GL10.GL_CULL_FACE );
        gl.glLoadIdentity();
    }
    
    public void Build_Radiation_Tile( GL10 gl, Radiation_Tile radiation_tile, boolean radiation_tile_touch, int kleur )
    {
    	gl.glLoadIdentity();
        gl.glEnable( GL10.GL_CULL_FACE );
		gl.glMatrixMode( GL10.GL_MODELVIEW );
		gl.glPushMatrix();
        gl.glTranslatef( radiation_tile.position.x, radiation_tile.position.y, 0 );
        if ( radiation_tile_touch )
        {
        	if ( kleur == green )
        	{
        		//green
    			cubes[19].render(PrimitiveType.Triangles);
        	}
        	else if( kleur == red )
        	{
        		//yellow
    			cubes[21].render(PrimitiveType.Triangles);
        	}
        	else if( kleur == yellow )
        	{
        		//yellow
    			cubes[23].render(PrimitiveType.Triangles);
        	}
        }
        else
        {
        	if ( kleur == green )
        	{
        		//green
    			cubes[18].render(PrimitiveType.Triangles);
        	}
        	else if( kleur == red )
        	{
        		//red
    			cubes[20].render(PrimitiveType.Triangles);
        	}
        	else if( kleur == yellow )
        	{
        		//yellow
    			cubes[22].render(PrimitiveType.Triangles);
        	}
        }
        gl.glDisable( GL10.GL_CULL_FACE );
        gl.glLoadIdentity();
        
    }
    

	public void Build_Level( GL10 gl, Mirror mirror, int level, boolean touched, int state )
    {
		gl.glLoadIdentity();
        gl.glEnable( GL10.GL_BLEND );
        gl.glEnable( GL10.GL_CULL_FACE );
		gl.glBlendFunc( GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA );
		if( touched )
		{
			gl.glBlendFunc(GL10.GL_ONE_MINUS_DST_COLOR, GL10.GL_ZERO);
		}
		gl.glMatrixMode( GL10.GL_MODELVIEW );
		gl.glPushMatrix();
        gl.glTranslatef( mirror.position.x, mirror.position.y, 0 );
        if( state == 0 )
        {
        	cubes[28 + (level * 3)].render(PrimitiveType.Triangles);
        }
        else if( state == 1 )
        {
        	cubes[27 + (level * 3)].render(PrimitiveType.Triangles);
        }
        else if ( state == 2 )
        {
        	cubes[26 + (level * 3)].render(PrimitiveType.Triangles);
        }
        else if ( state == 3 )
        {
        	gl.glRotatef( 180, 0, 0, 1);
        	cubes[150].render(PrimitiveType.Triangles);
        }
        else if ( state == 4 )
        {
        	cubes[150].render(PrimitiveType.Triangles);
        }
        gl.glPopMatrix();
        gl.glDisable( GL10.GL_BLEND );
        gl.glDisable( GL10.GL_CULL_FACE );
        gl.glLoadIdentity();
    }
	
    
    public void game_won_screen( GL10 gl, int level )
    {

    	gl.glLoadIdentity();
    	gl.glEnable( GL10.GL_BLEND );
    	gl.glEnable( GL10.GL_CULL_FACE );
		gl.glBlendFunc( GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA );
		gl.glMatrixMode( GL10.GL_MODELVIEW );
		gl.glPushMatrix();
        cleared_levels[level].render(PrimitiveType.Triangles);
        gl.glPopMatrix();
        gl.glDisable( GL10.GL_CULL_FACE );
        gl.glDisable( GL10.GL_BLEND );
    	gl.glLoadIdentity();
    	
    }
    
	
}
