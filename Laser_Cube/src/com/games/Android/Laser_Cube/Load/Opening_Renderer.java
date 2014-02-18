package com.games.Android.Laser_Cube.Load;

import java.util.ArrayList;

import com.games.Android.Laser_Cube.Load.Mesh.PrimitiveType;
import com.games.Android.Laser_Cube.Objects.Opening_Tile_Animatie;
import com.games.Android.Laser_Cube.Objects.Play_Game_Animatie;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;

public class Opening_Renderer 
{

	Mesh opening_tile_mesh;
	Mesh play_game_mesh;
	
	Texture texture_tile_opening_animatie;
	Texture texture_play_game_tile_animatie;
	
	public Opening_Renderer()
	{
		
		texture_tile_opening_animatie = new Texture( Gdx.files.internal( "laser_cube_animation_4_pot.png" ));
		texture_play_game_tile_animatie = new Texture( Gdx.files.internal( "play_game_animation_6.png"));
		
		opening_tile_mesh = new Mesh( Gdx.gl10, 4 * 16, false, true, false );
        for( int row = 0; row < 2; row++ )
        {
                for( int column = 0; column < 2; column++ )
                {
			            opening_tile_mesh.texCoord( 0, 0 + row * 0.5f);
			            opening_tile_mesh.vertex( -45f, 15f, 6f );
			            opening_tile_mesh.texCoord( 1, 0 + row * 0.5f);
			            opening_tile_mesh.vertex( 45f, 15f, 6f );
			            opening_tile_mesh.texCoord( 1,  0.5f + row * 0.5f);
			            opening_tile_mesh.vertex( 45f, -15f, 6f);
			            opening_tile_mesh.texCoord( 0, 0.5f + row * 0.5f);
			            opening_tile_mesh.vertex( -45f, -15f, 6f); 
                }
        }
        
        play_game_mesh = new Mesh( Gdx.gl10, 4 * 16, false, true, false );
        for( int row = 0; row < 2; row++ )
        {
                for( int column = 0; column < 2; column++ )
                {
			            play_game_mesh.texCoord( 0, 0 + row * 0.5f);
			            play_game_mesh.vertex( -30f, 10f, 6f );
			            play_game_mesh.texCoord( 1, 0 + row * 0.5f);
			            play_game_mesh.vertex( 30f, 10f, 6f );
			            play_game_mesh.texCoord( 1,  0.5f + row * 0.5f);
			            play_game_mesh.vertex( 30f, -10f, 6f);
			            play_game_mesh.texCoord( 0, 0.5f + row * 0.5f);
			            play_game_mesh.vertex( -30f, -10f, 6f);
                }
        }
		
		
		Gdx.app.log( Init_Renderer.LOG, "Opening Meshes added" );
		
		
		
	}
	
	
	public void Dispose_All()
	{
		texture_tile_opening_animatie.dispose();
		texture_play_game_tile_animatie.dispose();
	}
    
    public void opening_tile_animatie( GL10 gl, ArrayList<Opening_Tile_Animatie> opening_tile_animaties )
    {
    	gl.glLoadIdentity();
		gl.glMatrixMode( GL10.GL_MODELVIEW );
		gl.glPushMatrix();
		texture_tile_opening_animatie.bind();
    	for( int i = 0; i < opening_tile_animaties.size(); i++ )
        {
    		Opening_Tile_Animatie opening_tile_animatie = opening_tile_animaties.get(i);
            gl.glTranslatef( (opening_tile_animatie.position.x) , opening_tile_animatie.position.y, opening_tile_animatie.position.z );
            gl.glRotatef( 0, 0, 0, 1);
            opening_tile_mesh.render(PrimitiveType.TriangleFan, (int)((opening_tile_animatie.aliveTime / 4f) * 15) * 4, 4);
            gl.glPopMatrix();
        }
    	gl.glPopMatrix();
        gl.glLoadIdentity();
    }
    
    
    public void play_game_animatie ( GL10 gl, ArrayList<Play_Game_Animatie> play_game_animaties, boolean play_game_touched )
    {
    	gl.glLoadIdentity();
    	gl.glEnable( GL10.GL_BLEND );
		gl.glBlendFunc( GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA );
		if( play_game_touched )
		{
			gl.glBlendFunc(GL10.GL_ONE_MINUS_DST_COLOR, GL10.GL_ZERO);
		}
		gl.glMatrixMode( GL10.GL_MODELVIEW );
		gl.glPushMatrix();
		texture_play_game_tile_animatie.bind();
    	for( int i = 0; i < play_game_animaties.size(); i++ )
        {
    		Play_Game_Animatie play_game_animatie = play_game_animaties.get(i);
            gl.glTranslatef( (play_game_animatie.position.x) , (play_game_animatie.position.y), (play_game_animatie.position.z) );
            gl.glRotatef( 0, 0, 0, 1);
            play_game_mesh.render(PrimitiveType.TriangleFan, (int)((play_game_animatie.aliveTime / 4f) * 15) * 4, 4);
            gl.glPopMatrix();
        }
    	gl.glPopMatrix();
        gl.glDisable( GL10.GL_BLEND );
        gl.glLoadIdentity();
    }
    
    
}
