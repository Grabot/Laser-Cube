package com.games.Android.Laser_Cube.Load;

import com.badlogic.gdx.Gdx;

public class Load_Meshes 
{
	
	Mesh Fire_Button_Mesh;
	Mesh pause_mesh;
	Mesh pause_button_pressed;
	
	Mesh background_mesh_menu;
	Mesh background_mesh_levels;
	
	Mesh wall_levels;
	Mesh wall_menu;
	
	Mesh help_screens;
	
	Mesh[] cubes = new Mesh[151];
	Mesh[] laser_shot = new Mesh[10];
	Mesh[] cleared_levels = new Mesh[41];
	
    private float tex_x_0 = 0;
	private float tex_x_1 = 1;
	private float tex_y_0 = 0;
	private float tex_y_1 = 1;
	
	private float background_tex_x_0;
    private float background_tex_x_1;
	
	private float marble_tile_tex_x_0 = (768f/1024f);
	private float marble_tile_tex_x_1 = (896f/1024f);
	private float marble_tile_tex_y_0 = 0;
	private float marble_tile_tex_y_1 = (128f/1024f);
	
	private float wall_tile_tex_x_0 = (896f/1024f);
	private float wall_tile_tex_x_1 = 1;
	private float wall_tile_tex_y_0 = 0;
	private float wall_tile_tex_y_1 = (128f/1024f);
	
	private float transparent_background_tex_x_0 = (864f/1024f);
	private float transparent_background_tex_x_1 = (1024f/1024f);
	private float transparent_background_tex_y_0 = (255f/512f);
	private float transparent_background_tex_y_1 = (355f/512f);
	
	private float level_tekst_tex_x_0 = (766f/1024f);
	private float level_tekst_tex_x_1 = (1024f/1024f);
	private float level_tekst_tex_y_0 = (372f/512);
	private float level_tekst_tex_y_1 = (444f/512);
	
	private float cleared_tekst_tex_x_0 = (760f/1024f);
	private float cleared_tekst_tex_x_1 = (1024f/1024f);
	private float cleared_tekst_tex_y_0 = (454f/512);
	private float cleared_tekst_tex_y_1 = (512f/512);
	
	private float next_level_button_tex_x_0 = (675f/1024f);
	private float next_level_button_tex_x_1 = (848f/1024f);
	private float next_level_button_tex_y_0 = (0f/512f);
	private float next_level_button_tex_y_1 = (166f/512f);
	
	private float menu_button_tex_x_0 = (848f/1024f);
	private float menu_button_tex_x_1 = (1020f/1024f);
	private float menu_button_tex_y_0 = (0f/512f);
	private float menu_button_tex_y_1 = (166f/512f);
	
	private float level_cleared_number_tex_x_0 = 0;
	private float level_cleared_number_tex_x_1 = 0;
	private float level_cleared_number_tex_y_0 = 0;
	private float level_cleared_number_tex_y_1 = 0;
	
	private float increase_level_mesh = 0;
	
	private float background_x_edge = -87.04f;
	private float background_y_edge = -46.08f;
	
	private float wall_x_edge = -105;
	private float wall_y_edge = -55;
	
	private float wall_x_edge_menu = -285;
	private float wall_y_edge_menu = -55;
	
	private float background_x_edge_menu = -261.12f;
	
    private int regel = 0;
    
	private float tile_width = 10.23647f;
	private float tile_height = 10.24f;
	
	private float pause_screen_x_position = -30;
	private float pause_screen_y_position = -40;
	
	private float level = 0;
	private float row = 0;
	
	private float level_tile_size = 93f;
	
	public Load_Meshes()
	{
		for( int i = 0; i < cubes.length; i++ )
		{
			cubes[i] = new Mesh( Gdx.gl10, 30, false, true, false );
			if( i == 0 )
			{
				//laser shooter green move top
				tex_x_0 = 0;
				tex_x_1 = (128f/1024f);
				tex_y_0 = 0;
				tex_y_1 = (128f/1024f);
			}
			else if( i == 1 )
			{
				//laser shooter red move top
				tex_x_0 = (128f/1024f);
				tex_x_1 = (256f/1024f);
				tex_y_0 = 0;
				tex_y_1 = (128f/1024f);
			}
			else if( i == 2 )
			{
				//laser shooter yellow move top
				tex_x_0 = (256f/1024f);
				tex_x_1 = (384f/1024f);
				tex_y_0 = 0;
				tex_y_1 = (128f/1024f);
			}
			else if( i == 3 )
			{
				//laser shooter green solid top
				tex_x_0 = 0;
				tex_x_1 = (128f/1024f);
				tex_y_0 = (128f/1024f);
				tex_y_1 = (256f/1024f);
			}
			else if( i == 4 )
			{
				//laser shooter red solid top
				tex_x_0 = (128f/1024f);
				tex_x_1 = (256f/1024f);
				tex_y_0 = (128f/1024f);
				tex_y_1 = (256f/1024f);
			}
			else if( i == 5 )
			{
				//laser shooter yellow solid top
				tex_x_0 = (256f/1024f);
				tex_x_1 = (384f/1024f);
				tex_y_0 = (128f/1024f);
				tex_y_1 = (256f/1024f);
			}
			else if( i == 6 )
			{
				//forward refraction move
				tex_x_0 = 0;
				tex_x_1 = (128f/1024f);
				tex_y_0 = (256f/1024f);
				tex_y_1 = (384f/1024f);
			}
			else if( i == 7 )
			{
				//single refraction move
				tex_x_0 = (128f/1024f);
				tex_x_1 = (256f/1024f);
				tex_y_0 = (256f/1024f);
				tex_y_1 = (384f/1024f);
			}
			else if( i == 8 )
			{
				//double refraction move
				tex_x_0 = (256f/1024f);
				tex_x_1 = (384f/1024f);
				tex_y_0 = (256f/1024f);
				tex_y_1 = (384f/1024f);
			}
			else if( i == 9 )
			{
				//triple refraction move
				tex_x_0 = (512f/1024f);
				tex_x_1 = (640f/1024f);
				tex_y_0 = (256f/1024f);
				tex_y_1 = (384f/1024f);
			}
			else if( i == 10 )
			{
				//forward refraction solid
				tex_x_0 = 0;
				tex_x_1 = (128f/1024f);
				tex_y_0 = (384f/1024f);
				tex_y_1 = (512f/1024f);
			}
			else if( i == 11 )
			{
				//single refraction solid
				tex_x_0 = (128f/1024f);
				tex_x_1 = (256f/1024f);
				tex_y_0 = (384f/1024f);
				tex_y_1 = (512f/1024f);
			}
			else if( i == 12 )
			{
				//double refraction solid
				tex_x_0 = (256f/1024f);
				tex_x_1 = (384f/1024f);
				tex_y_0 = (384f/1024f);
				tex_y_1 = (512f/1024f);
			}
			else if( i == 13 )
			{
				//triple refraction solid
				tex_x_0 = (512f/1024f);
				tex_x_1 = (640f/1024f);
				tex_y_0 = (384f/1024f);
				tex_y_1 = (512f/1024f);
			}
			else if( i == 14 )
			{
				//colour changer green
				tex_x_0 = 0;
				tex_x_1 = (128f/1024f);
				tex_y_0 = (512f/1024f);
				tex_y_1 = (640f/1024f);
			}
			else if( i == 15 )
			{
				//colour changer red
				tex_x_0 = (128f/1024f);
				tex_x_1 = (256f/1024f);
				tex_y_0 = (512f/1024f);
				tex_y_1 = (640f/1024f);
			}
			else if( i == 16 )
			{
				//colour changer yellow
				tex_x_0 = (256f/1024f);
				tex_x_1 = (384f/1024f);
				tex_y_0 = (512f/1024f);
				tex_y_1 = (640f/1024f);
			}
			else if( i == 17 )
			{
				//block
				tex_x_0 = (896f/1024f);
				tex_x_1 = 1;
				tex_y_0 = 0;
				tex_y_1 = (128f/1024f);
			}
			else if( i == 18 )
			{
				//radiation tile green off
				tex_x_0 = (768f/1024f);
				tex_x_1 = (896f/1024f);
				tex_y_0 = (128f/1024f);
				tex_y_1 = (256f/1024f);
			}
			else if( i == 19 )
			{
				//radiation tile green on
				tex_x_0 = (896f/1024f);
				tex_x_1 = 1;
				tex_y_0 = (128f/1024f);
				tex_y_1 = (256f/1024f);
			}
			else if( i == 20 )
			{
				//radiation tile red off
				tex_x_0 = (768f/1024f);
				tex_x_1 = (896f/1024f);
				tex_y_0 = (256f/1024f);
				tex_y_1 = (384f/1024f);
			}
			else if( i == 21 )
			{
				//radiation tile red on
				tex_x_0 = (896f/1024f);
				tex_x_1 = 1;
				tex_y_0 = (256f/1024f);
				tex_y_1 = (384f/1024f);
			}
			else if( i == 22 )
			{
				//radiation tile yellow off
				tex_x_0 = (768f/1024f);
				tex_x_1 = (896f/1024f);
				tex_y_0 = (384f/1024f);
				tex_y_1 = (512f/1024f);
			}
			else if( i == 23 )
			{
				//radiation tile yellow on
				tex_x_0 = (896f/1024f);
				tex_x_1 = 1;
				tex_y_0 = (384f/1024f);
				tex_y_1 = (512f/1024f);
			}
			else if( i == 24 )
			{
				//pause button
				tex_x_0 = 0;
				tex_x_1 = (128f/1024f);
				tex_y_0 = (896f/1024f);
				tex_y_1 = 1;
			}
			else if( i == 25 )
			{
				//return button
				tex_x_0 = (128f/1024f);
				tex_x_1 = (256f/1024f);
				tex_y_0 = (896f/1024f);
				tex_y_1 = 1;
			}
			else if( i == 26 )
			{
				//colour changer solid green
				tex_x_0 = (640f/1024f);
				tex_x_1 = (768f/1024f);
				tex_y_0 = (256f/1024f);
				tex_y_1 = (384f/1024f);
			}
			else if( i == 27 )
			{
				//colour changer solid red
				tex_x_0 = (256f/1024f);
				tex_x_1 = (384f/1024f);
				tex_y_0 = (896f/1024f);
				tex_y_1 = 1;
			}
			else if( i == 28 )
			{
				//colour changer solid yellow
				tex_x_0 = (256f/1024f);
				tex_x_1 = (384f/1024f);
				tex_y_0 = (768f/1024f);
				tex_y_1 = (896f/1024f);
			}
			else if( i >= 29 && i <= 149 )
			{
				//level 1-40
				if(( i % 11 ) == 7 )
				{
					row++;
					level = 0;
				}
				
				tex_x_0 = ((level * level_tile_size)/1024f);
				tex_x_1 = ((level_tile_size + (level * level_tile_size))/1024f);
				tex_y_0 = (((row * level_tile_size) - level_tile_size)/1024f);
				tex_y_1 = ((row * level_tile_size)/1024f);
				
				level++;
			}
			else if( i == 150 )
			{
				//next section
				tex_x_0 = (896f/1024f);
				tex_x_1 = (1024f/1024f);
				tex_y_0 = (512f/1024f);
				tex_y_1 = (640f/1024f);
			}
			else
			{
				tex_x_0 = 0;
				tex_x_1 = 1;
				tex_y_0 = 0;
				tex_y_1 = 1;
			}
			//the top
			cubes[i].texCoord( tex_x_0, tex_y_1 );
			cubes[i].vertex( 5f, -5f, 6f );
			cubes[i].texCoord( tex_x_1, tex_y_1 );
			cubes[i].vertex( -5f, -5f, 6f );
			cubes[i].texCoord( tex_x_1, tex_y_0 );
			cubes[i].vertex( -5f, 5f, 6f);
			cubes[i].texCoord( tex_x_1, tex_y_0 );
			cubes[i].vertex( -5f, 5f, 6f);
			cubes[i].texCoord( tex_x_0, tex_y_0 );
			cubes[i].vertex( 5f, 5f, 6f);
			cubes[i].texCoord( tex_x_0, tex_y_1 );
			cubes[i].vertex( 5f, -5f, 6f);
			
			if( i == 0 )
			{
				//laser shooter green side
				tex_x_0 = (384f/1024f);
				tex_x_1 = (512f/1024f);
				tex_y_0 = 0;
				tex_y_1 = (128f/1024f);
			}
			else if( i == 1 )
			{
				//laser shooter red side
				tex_x_0 = (512f/1024f);
				tex_x_1 = (640f/1024f);
				tex_y_0 = 0;
				tex_y_1 = (128f/1024f);
			}
			else if( i == 2 )
			{
				//laser shooter yellow side
				tex_x_0 = (640f/1024f);
				tex_x_1 = (768f/1024f);
				tex_y_0 = 0;
				tex_y_1 = (128f/1024f);
			}
			else if( i == 3 )
			{
				//laser shooter green solid side
				tex_x_0 = (384f/1024f);
				tex_x_1 = (512f/1024f);
				tex_y_0 = (128f/1024f);
				tex_y_1 = (256f/1024f);
			}
			else if( i == 4 )
			{
				//laser shooter red solid side
				tex_x_0 = (512f/1024f);
				tex_x_1 = (640f/1024f);
				tex_y_0 = (128f/1024f);
				tex_y_1 = (256f/1024f);
			}
			else if( i == 5 )
			{
				//laser shooter yellow solid side
				tex_x_0 = (640f/1024f);
				tex_x_1 = (768f/1024f);
				tex_y_0 = (128f/1024f);
				tex_y_1 = (256f/1024f);
			}
			else if( i == 6 || i == 7 || i == 8 || i == 9 )
			{
				//refractions move
				tex_x_0 = (384f/1024f);
				tex_x_1 = (512f/1024f);
				tex_y_0 = (256f/1024f);
				tex_y_1 = (384f/1024f);
			}
			else if( i == 10 || i == 11 || i == 12 || i == 13 )
			{
				//refractions solid
				tex_x_0 = (384f/1024f);
				tex_x_1 = (512f/1024f);
				tex_y_0 = (384f/1024f);
				tex_y_1 = (512f/1024f);
			}
			else if( i == 14 )
			{
				//colour changer green side
				tex_x_0 = (384f/1024f);
				tex_x_1 = (512f/1024f);
				tex_y_0 = (512f/1024f);
				tex_y_1 = (640f/1024f);
			}
			else if( i == 15 )
			{
				//colour changer red side
				tex_x_0 = (512f/1024f);
				tex_x_1 = (640f/1024f);
				tex_y_0 = (512f/1024f);
				tex_y_1 = (640f/1024f);
			}
			else if( i == 16 )
			{
				//colour changer yellow side
				tex_x_0 = (640f/1024f);
				tex_x_1 = (768f/1024f);
				tex_y_0 = (512f/1024f);
				tex_y_1 = (640f/1024f);
			}
			else if( i == 17 || i == 150 )
			{
				//block
				tex_x_0 = (896f/1024f);
				tex_x_1 = 1;
				tex_y_0 = 0;
				tex_y_1 = (128f/1024f);
			}
			else if( i == 18 || i == 19 || i == 20 || i == 21 || i == 22 || i == 23 )
			{
				//radiation tiles
			}
			else if( i == 24 || i == 25 )
			{
				//pause button
				tex_x_0 = (896f/1024f);
				tex_x_1 = 1;
				tex_y_0 = 0;
				tex_y_1 = (128f/1024f);
			}
			else if( i == 26 )
			{
				//colour changer solid green side
				tex_x_0 = (640f/1024f);
				tex_x_1 = (768f/1024f);
				tex_y_0 = (384f/1024f);
				tex_y_1 = (512f/1024f);
			}
			else if( i == 27 )
			{
				//colour changer solid red side
				tex_x_0 = (768f/1024f);
				tex_x_1 = (896f/1024f);
				tex_y_0 = (512f/1024f);
				tex_y_1 = (640f/1024f);
			}
			else if( i == 28 )
			{
				//colour changer solid yellow side
				tex_x_0 = (256f/1024f);
				tex_x_1 = (384f/1024f);
				tex_y_0 = (640f/1024f);
				tex_y_1 = (768f/1024f);
			}
			else if( i >= 29 )
			{
				tex_x_0 = (930f/1024f);
				tex_x_1 = (1022f/1024f);
				tex_y_0 = (930f/1024f);
				tex_y_1 = (1022f/1024f);
			}
			else
			{
				tex_x_0 = 0;
				tex_x_1 = 1;
				tex_y_0 = 0;
				tex_y_1 = 1;
			}
			
			//the front
			cubes[i].texCoord( tex_x_1, tex_y_0 );
			cubes[i].vertex( -5f, -5f, 6f );
			cubes[i].texCoord( tex_x_0, tex_y_0 );
			cubes[i].vertex( 5f, -5f, 6f );
			cubes[i].texCoord( tex_x_1, tex_y_1 );
			cubes[i].vertex( -5f, -5f, 9f);
			cubes[i].texCoord( tex_x_0, tex_y_0 );
			cubes[i].vertex( 5f, -5f, 6f);
			cubes[i].texCoord( tex_x_0, tex_y_1 );
			cubes[i].vertex( 5f, -5f, 9f);
			cubes[i].texCoord( tex_x_1, tex_y_1 );
			cubes[i].vertex( -5f, -5f, 9f);
			
			//the back
			cubes[i].texCoord( tex_x_1, tex_y_0 );
			cubes[i].vertex( -5f, 5f, 6f );
			cubes[i].texCoord( tex_x_1, tex_y_1 );
			cubes[i].vertex( -5f, 5f, 9f );
			cubes[i].texCoord( tex_x_0, tex_y_0 );
			cubes[i].vertex( 5f, 5f, 6f);
			cubes[i].texCoord( tex_x_1, tex_y_1 );
			cubes[i].vertex( -5f, 5f, 9f);
			cubes[i].texCoord( tex_x_0, tex_y_1 );
			cubes[i].vertex( 5f, 5f, 9f);
			cubes[i].texCoord( tex_x_0, tex_y_0 );
			cubes[i].vertex( 5f, 5f, 6f);
	
			//the right
			cubes[i].texCoord( tex_x_1, tex_y_0 );
			cubes[i].vertex( -5f, 5f, 6f );
			cubes[i].texCoord( tex_x_0, tex_y_0 );
			cubes[i].vertex( -5f, -5f, 6f );
			cubes[i].texCoord( tex_x_1, tex_y_1 );
			cubes[i].vertex( -5f, 5f, 9f);
			cubes[i].texCoord( tex_x_0, tex_y_0 );
			cubes[i].vertex( -5f, -5f, 6f);
			cubes[i].texCoord( tex_x_0, tex_y_1 );
			cubes[i].vertex( -5f, -5f, 9f);
			cubes[i].texCoord( tex_x_1, tex_y_1 );
			cubes[i].vertex( -5f, 5f, 9f);
			
			//the left
			cubes[i].texCoord( tex_x_1, tex_y_0 );
			cubes[i].vertex( 5f, 5f, 6f );
			cubes[i].texCoord( tex_x_1, tex_y_1 );
			cubes[i].vertex( 5f, 5f, 9f );
			cubes[i].texCoord( tex_x_0, tex_y_0 );
			cubes[i].vertex( 5f, -5f, 6f);
			cubes[i].texCoord( tex_x_1, tex_y_1 );
			cubes[i].vertex( 5f, 5f, 9f);
			cubes[i].texCoord( tex_x_0, tex_y_1 );
			cubes[i].vertex( 5f, -5f, 9f);
			cubes[i].texCoord( tex_x_0, tex_y_0 );
			cubes[i].vertex( 5f, -5f, 6f);
		}
		
		background_mesh_levels = new Mesh( Gdx.gl10, 324, false, true, false );
        for( int i = 0; i < 19; i++ )
        {
        	if( i % 18 == 0 )
        	{
        		regel ++;
        		if( regel == 10 )
        		{
        			regel = 0;
        			break;
        		}
        	}
        	
        	if(( i % 2 ) == 0 )
        	{	
        		background_tex_x_0 = marble_tile_tex_x_0;
        		background_tex_x_1 = marble_tile_tex_x_0;
        	}
        	else
        	{
        		background_tex_x_0 = marble_tile_tex_x_1;
        		background_tex_x_1 = marble_tile_tex_x_1;
        	}
        	if(( regel % 2 ) == 0 )
        	{
        		i -= 1;
        	}
        	background_mesh_levels.texCoord( background_tex_x_0, marble_tile_tex_y_0 );
        	background_mesh_levels.vertex( (background_x_edge + (tile_width * i)), (background_y_edge + (tile_height * ((regel -1)))), 12f );
        	background_mesh_levels.texCoord( background_tex_x_1, marble_tile_tex_y_1 );
        	background_mesh_levels.vertex( (background_x_edge + (tile_width * i)), (background_y_edge + (tile_height * (regel))), 12f );
        	if(( regel % 2 ) == 0 )
        	{
        		i -= 1;
        	}
        }
        
        background_mesh_menu = new Mesh( Gdx.gl10, 630, false, true, false );
        for( int i = 0; i < 36; i++ )
        {
        	if( i % 35 == 0 )
        	{
        		regel ++;
        		if( regel == 10 )
        		{
        			regel = 0;
        			break;
        		}
        	}
        	
        	
        	if(( i % 2 ) == 0 )
        	{	
        		background_tex_x_0 = marble_tile_tex_x_0;
        		background_tex_x_1 = marble_tile_tex_x_0;
        	}
        	else
        	{
        		background_tex_x_0 = marble_tile_tex_x_1;
        		background_tex_x_1 = marble_tile_tex_x_1;
        	}
        	
        	if(( regel % 2 ) == 0 )
        	{
        		i -= 1;
        	}
        	background_mesh_menu.texCoord( background_tex_x_0, marble_tile_tex_y_0 );
        	background_mesh_menu.vertex( (background_x_edge_menu + (tile_width * i)), (background_y_edge + (tile_height * (regel-1))), 12f );
            background_mesh_menu.texCoord( background_tex_x_0, marble_tile_tex_y_1 );
            background_mesh_menu.vertex( (background_x_edge_menu + (tile_width * i)), (background_y_edge + (tile_height * (regel))), 12f );
            if(( regel % 2 ) == 0 )
        	{
        		i -= 1;
        	}
        }
        
        regel = 1;
        wall_levels = new Mesh( Gdx.gl10, 648, false, true, false );
        //the wall mesh, the long frontways facing side going sideways
        for( int i = 1; i < 21; i++ )
        {
        	if( i == 20 && regel == 11 )
        	{
        		regel = 1;
        		break;
        	}
        	
        	if( i == 20 )
        	{
        		i = 1;
        		regel = 11;
        		
        	}
    		wall_levels.texCoord( wall_tile_tex_x_1, wall_tile_tex_y_1 );
        	wall_levels.vertex(( wall_x_edge + (10 * i)), ( wall_y_edge + (10 * (regel - 1))), 6f );
            wall_levels.texCoord( wall_tile_tex_x_1, wall_tile_tex_y_0 );
            wall_levels.vertex(( wall_x_edge + (10 * i)), ( wall_y_edge + (10 * regel)), 6f );
            wall_levels.texCoord( wall_tile_tex_x_0, wall_tile_tex_y_0 );
        	wall_levels.vertex(( wall_x_edge + (10 * (i + 1))), ( wall_y_edge + (10 * regel)), 6f );
        	
        	wall_levels.texCoord( wall_tile_tex_x_0, wall_tile_tex_y_0 );
        	wall_levels.vertex(( wall_x_edge + (10 * (i + 1))), ( wall_y_edge + (10 * (regel))), 6f );
            wall_levels.texCoord( wall_tile_tex_x_0, wall_tile_tex_y_1 );
            wall_levels.vertex(( wall_x_edge + (10 * (i + 1))), ( wall_y_edge + (10 * (regel - 1))), 6f );
            wall_levels.texCoord( wall_tile_tex_x_1, wall_tile_tex_y_1 );
        	wall_levels.vertex(( wall_x_edge + (10 * (i))), ( wall_y_edge + (10 * (regel - 1))), 6f );
        }
        
        //the wall mesh, the short forward facing side going upwards
        for( int i = 1; i < 22; i++ )
        {
        	regel ++;
        	
    		wall_levels.texCoord( wall_tile_tex_x_1, wall_tile_tex_y_1 );
        	wall_levels.vertex(( wall_x_edge + (10 * i)), ( wall_y_edge + (10 * (regel - 1))), 6f );
            wall_levels.texCoord( wall_tile_tex_x_1, wall_tile_tex_y_0 );
            wall_levels.vertex(( wall_x_edge + (10 * i)), ( wall_y_edge + (10 * regel)), 6f );
            wall_levels.texCoord( wall_tile_tex_x_0, wall_tile_tex_y_0 );
        	wall_levels.vertex(( wall_x_edge + (10 * (i + 1))), ( wall_y_edge + (10 * regel)), 6f );
        	
        	wall_levels.texCoord( wall_tile_tex_x_0, wall_tile_tex_y_0 );
        	wall_levels.vertex(( wall_x_edge + (10 * (i + 1))), ( wall_y_edge + (10 * (regel))), 6f );
            wall_levels.texCoord( wall_tile_tex_x_0, wall_tile_tex_y_1 );
            wall_levels.vertex(( wall_x_edge + (10 * (i + 1))), ( wall_y_edge + (10 * (regel - 1))), 6f );
            wall_levels.texCoord( wall_tile_tex_x_1, wall_tile_tex_y_1 );
        	wall_levels.vertex(( wall_x_edge + (10 * i)), ( wall_y_edge + (10 * (regel - 1))), 6f );
        	
        	i--;
        	if( regel == 10 && i == 18 )
        	{
        		regel = 1;
        		break;
        	}
        	if( regel == 10 )
        	{
        		i = 18;
        		regel = 1;
        	}
        	
        }
        //the wall mesh, sides for the long sideways sides
        for( int i = 2; i < 20; i++ )
        {
        	
        	if( i == 19 && regel == 10 )
        	{
        		regel = 1;
        		break;
        	}
        	if( i == 19 )
        	{
        		i = 2;
        		regel = 10;
        	}
        	
	        wall_levels.texCoord( wall_tile_tex_x_1, wall_tile_tex_y_1 );
	    	wall_levels.vertex(( wall_x_edge + (10 * (i))), ( wall_y_edge + (10 * regel)), 6f );
	        wall_levels.texCoord( wall_tile_tex_x_1, wall_tile_tex_y_0 );
	        wall_levels.vertex(( wall_x_edge + (10 * (i))), ( wall_y_edge + (10 * regel)), 9f );
	        wall_levels.texCoord( wall_tile_tex_x_0, wall_tile_tex_y_0 );
	    	wall_levels.vertex(( wall_x_edge + (10 * (i + 1))), ( wall_y_edge + (10 * regel)), 9f );
	    	
	    	wall_levels.texCoord( wall_tile_tex_x_1, wall_tile_tex_y_1 );
	    	wall_levels.vertex(( wall_x_edge + (10 * (i))), ( wall_y_edge + (10 * regel)), 6f );
	        wall_levels.texCoord( wall_tile_tex_x_0, wall_tile_tex_y_1 );
	        wall_levels.vertex(( wall_x_edge + (10 * (i + 1))), ( wall_y_edge + (10 * regel)), 6f );
	        wall_levels.texCoord( wall_tile_tex_x_0, wall_tile_tex_y_0 );
	    	wall_levels.vertex(( wall_x_edge + (10 * (i + 1))), ( wall_y_edge + (10 * regel)), 9f );
        }
        //the wall mesh, sides for the short upward walls
        regel = 1;
        for( int i = 2; i < 21; i++ )
        {
        	regel++;
	    	if( regel == 11 && i == 2 )
	    	{
	    		regel = 2;
	    		i = 19;
	    	}
	    	
	    	if( regel == 11 && i == 19 )
	    	{
	    		break;
	    	}
	    	
	        wall_levels.texCoord( wall_tile_tex_x_1, wall_tile_tex_y_1 );
	    	wall_levels.vertex(( wall_x_edge + (10 * (i))), ( wall_y_edge + (10 * (regel - 1))), 9f );
	        wall_levels.texCoord( wall_tile_tex_x_1, wall_tile_tex_y_0 );
	        wall_levels.vertex(( wall_x_edge + (10 * (i))), ( wall_y_edge + (10 * regel)), 9f );
	        wall_levels.texCoord( wall_tile_tex_x_0, wall_tile_tex_y_0 );
	    	wall_levels.vertex(( wall_x_edge + (10 * (i))), ( wall_y_edge + (10 * regel)), 6f );
	    	
	    	wall_levels.texCoord( wall_tile_tex_x_1, wall_tile_tex_y_1 );
	    	wall_levels.vertex(( wall_x_edge + (10 * (i))), ( wall_y_edge + (10 * (regel - 1))), 9f );
	        wall_levels.texCoord( wall_tile_tex_x_0, wall_tile_tex_y_1 );
	        wall_levels.vertex(( wall_x_edge + (10 * (i))), ( wall_y_edge + (10 * (regel - 1))), 6f );
	        wall_levels.texCoord( wall_tile_tex_x_0, wall_tile_tex_y_0 );
	    	wall_levels.vertex(( wall_x_edge + (10 * (i))), ( wall_y_edge + (10 * regel)), 6f );
	    	i--;
	    	
        }
        
        regel = 1;
        wall_menu = new Mesh( Gdx.gl10, 1242, false, true, false );
        //the wall mesh, the long fronways facing side going sideways
        for( int i = 1; i < 41; i++ )
        {
        	if( i == 38 && regel == 11 )
        	{
        		regel = 1;
        		break;
        	}
        	if( i == 38 )
        	{
        		i = 1;
        		regel = 11;
        		
        	}
    		wall_menu.texCoord( wall_tile_tex_x_1, wall_tile_tex_y_1 );
        	wall_menu.vertex(( wall_x_edge_menu + (10 * i)), ( wall_y_edge_menu + (10 * (regel - 1))), 6f );
            wall_menu.texCoord( wall_tile_tex_x_1, wall_tile_tex_y_0 );
            wall_menu.vertex(( wall_x_edge_menu + (10 * i)), ( wall_y_edge_menu + (10 * regel)), 6f );
            wall_menu.texCoord( wall_tile_tex_x_0, wall_tile_tex_y_0 );
        	wall_menu.vertex(( wall_x_edge_menu + (10 * (i + 1))), ( wall_y_edge_menu + (10 * regel)), 6f );
        	
        	wall_menu.texCoord( wall_tile_tex_x_1, wall_tile_tex_y_1 );
        	wall_menu.vertex(( wall_x_edge_menu + (10 * i)), ( wall_y_edge_menu + (10 * (regel - 1))), 6f );
            wall_menu.texCoord( wall_tile_tex_x_0, wall_tile_tex_y_1 );
            wall_menu.vertex(( wall_x_edge_menu + (10 * (i + 1))), ( wall_y_edge_menu + (10 * (regel - 1))), 6f );
            wall_menu.texCoord( wall_tile_tex_x_0, wall_tile_tex_y_0 );
        	wall_menu.vertex(( wall_x_edge_menu + (10 * (i + 1))), ( wall_y_edge_menu + (10 * regel)), 6f );
        }
        //the wall mesh, the short forward facing side going upwards
        for( int i = 1; i < 42; i++ )
        {
        	regel ++;
        	
    		wall_menu.texCoord( wall_tile_tex_x_1, wall_tile_tex_y_1 );
        	wall_menu.vertex(( wall_x_edge_menu + (10 * i)), ( wall_y_edge_menu + (10 * (regel - 1))), 6f );
            wall_menu.texCoord( wall_tile_tex_x_1, wall_tile_tex_y_0 );
            wall_menu.vertex(( wall_x_edge_menu + (10 * i)), ( wall_y_edge_menu + (10 * regel)), 6f );
            wall_menu.texCoord( wall_tile_tex_x_0, wall_tile_tex_y_0 );
        	wall_menu.vertex(( wall_x_edge_menu + (10 * (i + 1))), ( wall_y_edge_menu + (10 * regel)), 6f );
        	
        	wall_menu.texCoord( wall_tile_tex_x_1, wall_tile_tex_y_1 );
        	wall_menu.vertex(( wall_x_edge_menu + (10 * i)), ( wall_y_edge_menu + (10 * (regel - 1))), 6f );
            wall_menu.texCoord( wall_tile_tex_x_0, wall_tile_tex_y_1 );
            wall_menu.vertex(( wall_x_edge_menu + (10 * (i + 1))), ( wall_y_edge_menu + (10 * (regel - 1))), 6f );
            wall_menu.texCoord( wall_tile_tex_x_0, wall_tile_tex_y_0 );
        	wall_menu.vertex(( wall_x_edge_menu + (10 * (i + 1))), ( wall_y_edge_menu + (10 * regel)), 6f );
        	i--;
        	if( regel == 10 && i == 36 )
        	{
        		regel = 1;
        		break;
        	}
        	if( regel == 10 && i == 18 )
        	{
        		regel = 1;
        		i = 36;
        	}
        	if( regel == 10 && i == 0 )
        	{
        		i = 18;
        		regel = 1;
        	}
        	
        }
        //the wall mesh, sides for the long sideways sides
        for( int i = 2; i < 40; i++ )
        {
        	
        	if( i == 37 && regel == 10 )
        	{
        		regel = 1;
        		break;
        	}
        	if( i == 37 )
        	{
        		i = 2;
        		regel = 10;
        	}
        	
	        wall_menu.texCoord( wall_tile_tex_x_1, wall_tile_tex_y_1 );
	    	wall_menu.vertex(( wall_x_edge_menu + (10 * (i))), ( wall_y_edge_menu + (10 * regel)), 6f );
	        wall_menu.texCoord( wall_tile_tex_x_1, wall_tile_tex_y_0 );
	        wall_menu.vertex(( wall_x_edge_menu + (10 * (i))), ( wall_y_edge_menu + (10 * regel)), 9f );
	        wall_menu.texCoord( wall_tile_tex_x_0, wall_tile_tex_y_0 );
	    	wall_menu.vertex(( wall_x_edge_menu + (10 * (i + 1))), ( wall_y_edge_menu + (10 * regel)), 9f );
	    	
	    	wall_menu.texCoord( wall_tile_tex_x_1, wall_tile_tex_y_1 );
	    	wall_menu.vertex(( wall_x_edge_menu + (10 * (i))), ( wall_y_edge_menu + (10 * regel)), 6f );
	        wall_menu.texCoord( wall_tile_tex_x_0, wall_tile_tex_y_1 );
	        wall_menu.vertex(( wall_x_edge_menu + (10 * (i + 1))), ( wall_y_edge_menu + (10 * regel)), 6f );
	        wall_menu.texCoord( wall_tile_tex_x_0, wall_tile_tex_y_0 );
	    	wall_menu.vertex(( wall_x_edge_menu + (10 * (i + 1))), ( wall_y_edge_menu + (10 * regel)), 9f );
        }
        //the wall mesh, sides for the short upward walls
        regel = 1;
        for( int i = 2; i < 41; i++ )
        {
        	regel++;
	    	if( regel == 11 && i == 2 )
	    	{
	    		regel = 2;
	    		i = 19;
	    	}
	    	
	    	if( regel == 11 && i == 19 )
	    	{
	    		regel = 2;
	    		i = 20;
	    	}
	    	
	    	if( regel == 11 && i == 20 )
	    	{
	    		regel = 2;
	    		i = 37;
	    	}
	    	
	    	if( regel == 11 && i == 37 )
	    	{
	    		break;
	    	}
	    	
	        wall_menu.texCoord( wall_tile_tex_x_1, wall_tile_tex_y_1 );
	    	wall_menu.vertex(( wall_x_edge_menu + (10 * (i))), ( wall_y_edge_menu + (10 * (regel - 1))), 9f );
	        wall_menu.texCoord( wall_tile_tex_x_1, wall_tile_tex_y_0 );
	        wall_menu.vertex(( wall_x_edge_menu + (10 * (i))), ( wall_y_edge_menu + (10 * regel)), 9f );
	        wall_menu.texCoord( wall_tile_tex_x_0, wall_tile_tex_y_0 );
	    	wall_menu.vertex(( wall_x_edge_menu + (10 * (i))), ( wall_y_edge_menu + (10 * regel)), 6f );
	    	
	    	wall_menu.texCoord( wall_tile_tex_x_1, wall_tile_tex_y_1 );
	    	wall_menu.vertex(( wall_x_edge_menu + (10 * (i))), ( wall_y_edge_menu + (10 * (regel - 1))), 9f );
	        wall_menu.texCoord( wall_tile_tex_x_0, wall_tile_tex_y_1 );
	        wall_menu.vertex(( wall_x_edge_menu + (10 * (i))), ( wall_y_edge_menu + (10 * (regel - 1))), 6f );
	        wall_menu.texCoord( wall_tile_tex_x_0, wall_tile_tex_y_0 );
	    	wall_menu.vertex(( wall_x_edge_menu + (10 * (i))), ( wall_y_edge_menu + (10 * regel)), 6f );
	    	i--;
	    	
        }
		
		for( int i = 0; i < 10; i++ )
		{

			laser_shot[i] = new Mesh( Gdx.gl10, 4, false, true, false );
			
			if( i == 0 || i == 3 )
			{
				//red horizontal
				tex_x_0 = (896f/1024f);
				tex_x_1 = (960f/1024f);
				tex_y_0 = (768f/1024f);
				tex_y_1 = 1;
			}
			else if( i == 1 || i == 4 )
			{
				//green horizontal
				tex_x_0 = (960f/1024f);
				tex_x_1 = 1;
				tex_y_0 = (768f/1024f);
				tex_y_1 = 1;
			}
			else if( i == 2 || i == 5 )
			{
				//yellow horizontal
				tex_x_0 = (832f/1024f);
				tex_x_1 = (896f/1024f);
				tex_y_0 = (768f/1024f);
				tex_y_1 = 1;
			}
			else
			{
				tex_x_0 = 0;
				tex_x_1 = 1;
				tex_y_0 = 0;
				tex_y_1 = 1;
			}
			
			if( i == 0 || i == 1 || i == 2 )
			{
				laser_shot[i].texCoord( tex_x_1, tex_y_0 );
				laser_shot[i].vertex( -1, 3, 9f );
				laser_shot[i].texCoord( tex_x_0, tex_y_0 );
				laser_shot[i].vertex( 1, 3, 9f );
				laser_shot[i].texCoord( tex_x_0, tex_y_1 );
				laser_shot[i].vertex( 1, -3, 9f);
				laser_shot[i].texCoord( tex_x_1, tex_y_1 );
				laser_shot[i].vertex( -1, -3, 9f);
			}
			else if( i == 3 || i == 4 || i == 5 )
			{
				laser_shot[i].texCoord( tex_x_1, tex_y_1 );
				laser_shot[i].vertex( -3, 1, 9f );
				laser_shot[i].texCoord( tex_x_1, tex_y_0 );
				laser_shot[i].vertex( 3, 1, 9f );
				laser_shot[i].texCoord( tex_x_0, tex_y_0 );
				laser_shot[i].vertex( 3, -1, 9f);
				laser_shot[i].texCoord( tex_x_0, tex_y_1 );
				laser_shot[i].vertex( -3, -1, 9f);
			}
			
			
		}
		
		
		Fire_Button_Mesh = new Mesh( Gdx.gl10, 54, false, true, false );
        Fire_Button_Mesh.texCoord( (256f/1024f), (640f/1024f) );
        Fire_Button_Mesh.vertex( -10f, 10f, 6f );
        Fire_Button_Mesh.texCoord( 0, (640f/1024f) );
        Fire_Button_Mesh.vertex( 10f, 10f, 6f );
        Fire_Button_Mesh.texCoord( 0, (896f/1024f) );
        Fire_Button_Mesh.vertex( 10f, -10f, 6f);
        Fire_Button_Mesh.texCoord( 0, (896f/1024f) );
        Fire_Button_Mesh.vertex( 10f, -10f, 6f);
        Fire_Button_Mesh.texCoord( (256f/1024f), (896f/1024f) );
        Fire_Button_Mesh.vertex( -10f, -10f, 6f);
        Fire_Button_Mesh.texCoord( (256f/1024f), (640f/1024f) );
        Fire_Button_Mesh.vertex( -10f, 10f, 6f);
        //the front
        Fire_Button_Mesh.texCoord( 1, 0 );
        Fire_Button_Mesh.vertex( -10f, -10f, 6f );
        Fire_Button_Mesh.texCoord( 1, (128f/1024f) );
        Fire_Button_Mesh.vertex( -10f, -10f, 9f );
        Fire_Button_Mesh.texCoord( (896f/1024f), 0 );
        Fire_Button_Mesh.vertex( 0f, -10f, 6f);
        Fire_Button_Mesh.texCoord( (896f/1024f), 0 );
        Fire_Button_Mesh.vertex( 0f, -10f, 6f);
        Fire_Button_Mesh.texCoord( (896f/1024f), (128f/1024f) );
        Fire_Button_Mesh.vertex( 0f, -10f, 9f);
        Fire_Button_Mesh.texCoord( 1, (128f/1024f) );
        Fire_Button_Mesh.vertex( -10f, -10f, 9f);
        Fire_Button_Mesh.texCoord( 1, 0 );
        Fire_Button_Mesh.vertex( 0f, -10f, 6f );
        Fire_Button_Mesh.texCoord( 1, (128f/1024f) );
        Fire_Button_Mesh.vertex( 0f, -10f, 9f );
        Fire_Button_Mesh.texCoord( (896f/1024f), 0 );
        Fire_Button_Mesh.vertex( 10f, -10f, 6f);
        Fire_Button_Mesh.texCoord( (896f/1024f), 0 );
        Fire_Button_Mesh.vertex( 10f, -10f, 6f);
        Fire_Button_Mesh.texCoord( (896f/1024f), (128f/1024f) );
        Fire_Button_Mesh.vertex( 10f, -10f, 9f);
        Fire_Button_Mesh.texCoord( 1, (128f/1024f) );
        Fire_Button_Mesh.vertex( 0f, -10f, 9f);
		//the back
        Fire_Button_Mesh.texCoord( 1, 0 );
        Fire_Button_Mesh.vertex( 0f, 10f, 6f );
        Fire_Button_Mesh.texCoord( 1, (128f/1024f) );
        Fire_Button_Mesh.vertex( 0f, 10f, 9f );
        Fire_Button_Mesh.texCoord( (896f/1024f), 0 );
        Fire_Button_Mesh.vertex( 10f, 10f, 6f);
        Fire_Button_Mesh.texCoord( (896f/1024f), 0 );
        Fire_Button_Mesh.vertex( 10f, 10f, 6f);
        Fire_Button_Mesh.texCoord( (896f/1024f), (128f/1024f) );
        Fire_Button_Mesh.vertex( 10f, 10f, 9f);
        Fire_Button_Mesh.texCoord( 1, (128f/1024f) );
        Fire_Button_Mesh.vertex( 0f, 10f, 9f);
        Fire_Button_Mesh.texCoord( 1, 0 );
        Fire_Button_Mesh.vertex( -10f, 10f, 6f );
        Fire_Button_Mesh.texCoord( 1, (128f/1024f) );
        Fire_Button_Mesh.vertex( -10f, 10f, 9f );
        Fire_Button_Mesh.texCoord( (896f/1024f), 0 );
        Fire_Button_Mesh.vertex( 0f, 10f, 6f);
        Fire_Button_Mesh.texCoord( (896f/1024f), 0 );
        Fire_Button_Mesh.vertex( 0f, 10f, 6f);
        Fire_Button_Mesh.texCoord( (896f/1024f), (128f/1024f) );
        Fire_Button_Mesh.vertex( 0f, 10f, 9f);
        Fire_Button_Mesh.texCoord( 1, (128f/1024f) );
        Fire_Button_Mesh.vertex( -10f, 10f, 9f);
		//the right
        Fire_Button_Mesh.texCoord( 1, 0 );
        Fire_Button_Mesh.vertex( -10f, 0f, 6f );
        Fire_Button_Mesh.texCoord( 1, (128f/1024f) );
        Fire_Button_Mesh.vertex( -10f, 0f, 9f );
        Fire_Button_Mesh.texCoord( (896f/1024f), 0 );
        Fire_Button_Mesh.vertex( -10f, -10f, 6f);
        Fire_Button_Mesh.texCoord( (896f/1024f), 0 );
        Fire_Button_Mesh.vertex( -10f, -10f, 6f);
        Fire_Button_Mesh.texCoord( (896f/1024f), (128f/1024f) );
        Fire_Button_Mesh.vertex( -10f, -10f, 9f);
        Fire_Button_Mesh.texCoord( 1, (128f/1024f) );
        Fire_Button_Mesh.vertex( -10f, 0f, 9f);
        Fire_Button_Mesh.texCoord( 1, 0 );
        Fire_Button_Mesh.vertex( -10f, 10f, 6f );
        Fire_Button_Mesh.texCoord( 1, (128f/1024f) );
        Fire_Button_Mesh.vertex( -10f, 10f, 9f );
        Fire_Button_Mesh.texCoord( (896f/1024f), 0 );
        Fire_Button_Mesh.vertex( -10f, 0f, 6f);
        Fire_Button_Mesh.texCoord( (896f/1024f), 0 );
        Fire_Button_Mesh.vertex( -10f, 0f, 6f);
        Fire_Button_Mesh.texCoord( (896f/1024f), (128f/1024f) );
        Fire_Button_Mesh.vertex( -10f, 0f, 9f);
        Fire_Button_Mesh.texCoord( 1, (128f/1024f) );
        Fire_Button_Mesh.vertex( -10f, 10f, 9f);
		//the left
        Fire_Button_Mesh.texCoord( 1, 0 );
        Fire_Button_Mesh.vertex( 10f, 10f, 6f );
        Fire_Button_Mesh.texCoord( 1, (128f/1024f) );
        Fire_Button_Mesh.vertex( 10f, 10f, 9f );
        Fire_Button_Mesh.texCoord( (896f/1024f), 0 );
        Fire_Button_Mesh.vertex( 10f, 0f, 6f);
        Fire_Button_Mesh.texCoord( (896f/1024f), 0 );
        Fire_Button_Mesh.vertex( 10f, 0f, 6f);
        Fire_Button_Mesh.texCoord( (896f/1024f), (128f/1024f) );
        Fire_Button_Mesh.vertex( 10f, 0f, 9f);
        Fire_Button_Mesh.texCoord( 1, (128f/1024f) );
        Fire_Button_Mesh.vertex( 10f, 10f, 9f);
        Fire_Button_Mesh.texCoord( 1, 0 );
        Fire_Button_Mesh.vertex( 10f, 0f, 6f );
        Fire_Button_Mesh.texCoord( 1, (128f/1024f) );
        Fire_Button_Mesh.vertex( 10f, 0f, 9f );
        Fire_Button_Mesh.texCoord( (896f/1024f), 0 );
        Fire_Button_Mesh.vertex( 10f, -10f, 6f);
        Fire_Button_Mesh.texCoord( (896f/1024f), 0 );
        Fire_Button_Mesh.vertex( 10f, -10f, 6f);
        Fire_Button_Mesh.texCoord( (896f/1024f), (128f/1024f) );
        Fire_Button_Mesh.vertex( 10f, -10f, 9f);
        Fire_Button_Mesh.texCoord( 1, (128f/1024f) );
        Fire_Button_Mesh.vertex( 10f, 0f, 9f);
        
        help_screens = new Mesh( Gdx.gl10, 6, false, true, false );
        help_screens.texCoord( 1, 0 );
        help_screens.vertex( -40f, 40, -8f );
        help_screens.texCoord( 0, 0 );
        help_screens.vertex( 40f, 40, -8f );
        help_screens.texCoord( 0, 1 );
        help_screens.vertex( 40f, -40f, -8f );
        help_screens.texCoord( 0, 1 );
        help_screens.vertex( 40f, -40f, -8f );
        help_screens.texCoord( 1, 1 );
        help_screens.vertex( -40f, -40f, -8f );
        help_screens.texCoord( 1, 0 );
        help_screens.vertex( -40f, 40, -8f );
        
        pause_button_pressed = new Mesh( Gdx.gl10, 6, false, true, false );
        pause_button_pressed.texCoord( (758f/1024f), (933f/1024f) );
        pause_button_pressed.vertex( -23.5f, -5, -8f );
        pause_button_pressed.texCoord( (390f/1024f), (933f/1024f) );
        pause_button_pressed.vertex( 23.5f, -5, -8f );
        pause_button_pressed.texCoord( (390f/1024f), (1016f/1024f) );
        pause_button_pressed.vertex( 23.5f, -14f, -8f );
        pause_button_pressed.texCoord( (390f/1024f), (1016f/1024f) );
        pause_button_pressed.vertex( 23.5f, -14f, -8f );
        pause_button_pressed.texCoord( (758f/1024f), (1016f/1024f) );
        pause_button_pressed.vertex( -23.5f, -14f, -8f );
        pause_button_pressed.texCoord( (758f/1024f), (933f/1024f) );
        pause_button_pressed.vertex( -23.5f, -5, -8f );
        
        regel = 0;
        pause_mesh = new Mesh( Gdx.gl10, 276, false, true, false );
        for( int i = 0; i < 7; i++ )
        {
        	if( i == 6 )
        	{
        		i = 0;
        		regel++;
        	}
        	
        	if( regel == 7 )
        	{
        		break;
        	}
        	
        	
	        pause_mesh.texCoord( wall_tile_tex_x_1, wall_tile_tex_y_0 );
	        pause_mesh.vertex( (pause_screen_x_position + (10 * i)), (pause_screen_y_position + (10 * (regel + 1))), 0f );
	        pause_mesh.texCoord( wall_tile_tex_x_0, wall_tile_tex_y_0 );
	        pause_mesh.vertex( (pause_screen_x_position + (10 * (i + 1))), (pause_screen_y_position + (10 * (regel + 1))), 0f );
	        pause_mesh.texCoord( wall_tile_tex_x_0, wall_tile_tex_y_1 );
	        pause_mesh.vertex( (pause_screen_x_position + (10 * (i + 1))), (pause_screen_y_position + (10 * regel)), 0f);
	        pause_mesh.texCoord( wall_tile_tex_x_0, wall_tile_tex_y_1 );
	        pause_mesh.vertex( (pause_screen_x_position + (10 * (i + 1))), (pause_screen_y_position + (10 * regel)), 0f );
	        pause_mesh.texCoord( wall_tile_tex_x_1, wall_tile_tex_y_1 );
	        pause_mesh.vertex( (pause_screen_x_position + (10 * i)), (pause_screen_y_position + (10 * regel)), 0f );
	        pause_mesh.texCoord( wall_tile_tex_x_1, wall_tile_tex_y_0 );
	        pause_mesh.vertex( (pause_screen_x_position + (10 * i)), (pause_screen_y_position + (10 * (regel + 1))), 0f);
        }
        
        pause_mesh.texCoord( 1f, (650f/1024f) );
        pause_mesh.vertex( -17f, 25f, -5f );
        pause_mesh.texCoord( (760f/1024f), (650f/1024f) );
        pause_mesh.vertex( 17f, 25f, -5f );
        pause_mesh.texCoord( (760f/1024f), (735f/1024f) );
        pause_mesh.vertex( 17f, 15f, -5f );
        pause_mesh.texCoord( (760f/1024f), (735f/1024f) );
        pause_mesh.vertex( 17f, 15f, -5f );
        pause_mesh.texCoord( 1f, (735f/1024f) );
        pause_mesh.vertex( -17f, 15f, -5f );
        pause_mesh.texCoord( 1f, (650f/1024f) );
        pause_mesh.vertex( -17f, 25f, -5f );
        
        pause_mesh.texCoord( (758f/1024f), (640f/1024f) );
        pause_mesh.vertex( -24f, 8.5f, -5f );
        pause_mesh.texCoord( (390f/1024f), (640f/1024f) );
        pause_mesh.vertex( 24f, 8.5f, -5f );
        pause_mesh.texCoord( (390f/1024f), (734f/1024f) );
        pause_mesh.vertex( 24f, -0.5f, -5f );
        pause_mesh.texCoord( (390f/1024f), (734f/1024f) );
        pause_mesh.vertex( 24f, -0.5f, -5f );
        pause_mesh.texCoord( (758f/1024f), (734f/1024f) );
        pause_mesh.vertex( -24f, -0.5f, -5f );
        pause_mesh.texCoord( (758f/1024f), (640f/1024f) );
        pause_mesh.vertex( -24f, 8.5f, -5f );
        
        pause_mesh.texCoord( (762f/1024f), (830f/1024f) );
        pause_mesh.vertex( -24f, -5, -5f );
        pause_mesh.texCoord( (390f/1024f), (830f/1024f) );
        pause_mesh.vertex( 24f, -5, -5f );
        pause_mesh.texCoord( (390f/1024f), (925f/1024f) );
        pause_mesh.vertex( 24f, -14f, -5f );
        pause_mesh.texCoord( (390f/1024f), (925f/1024f) );
        pause_mesh.vertex( 24f, -14f, -5f );
        pause_mesh.texCoord( (762f/1024f), (925f/1024f) );
        pause_mesh.vertex( -24f, -14f, -5f );
        pause_mesh.texCoord( (762f/1024f), (830f/1024f) );
        pause_mesh.vertex( -24f, -5, -5f );
        
        pause_mesh.texCoord( (758f/1024f), (735f/1024f) );
        pause_mesh.vertex( -24f, -19, -5f );
        pause_mesh.texCoord( (390f/1024f), (735f/1024f) );
        pause_mesh.vertex( 24f, -19, -5f );
        pause_mesh.texCoord( (390f/1024f), (830f/1024f) );
        pause_mesh.vertex( 24f, -28f, -5f );
        pause_mesh.texCoord( (390f/1024f), (830f/1024f) );
        pause_mesh.vertex( 24f, -28f, -5f );
        pause_mesh.texCoord( (758f/1024f), (830f/1024f) );
        pause_mesh.vertex( -24f, -28f, -5f );
        pause_mesh.texCoord( (758f/1024f), (735f/1024f) );
        pause_mesh.vertex( -24f, -19, -5f );
        
        for( int i = 0; i < cleared_levels.length; i++ )
        {
	        cleared_levels[i] = new Mesh( Gdx.gl10, 36, false, true, false );
	        cleared_levels[i].texCoord( transparent_background_tex_x_1, transparent_background_tex_y_0 );
	        cleared_levels[i].vertex( -50, 25, 0f );
	        cleared_levels[i].texCoord( transparent_background_tex_x_0, transparent_background_tex_y_0 );
	        cleared_levels[i].vertex( 50, 25, 0f );
	        cleared_levels[i].texCoord( transparent_background_tex_x_0, transparent_background_tex_y_1 );
	        cleared_levels[i].vertex( 50, -25, 0f);
	        cleared_levels[i].texCoord( transparent_background_tex_x_0, transparent_background_tex_y_1 );
	        cleared_levels[i].vertex( 50, -25, 0f);
	        cleared_levels[i].texCoord( transparent_background_tex_x_1, transparent_background_tex_y_1 );
	        cleared_levels[i].vertex( -50, -25, 0f);
	        cleared_levels[i].texCoord( transparent_background_tex_x_1, transparent_background_tex_y_0 );
	        cleared_levels[i].vertex( -50, 25, 0f);
	        
	        if( i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 6 || i == 7 || i == 8 || i == 9 )
	        {
	        	increase_level_mesh = 0;
	        }
	        else
	        {
	        	increase_level_mesh = 2;
	        }
	        
	        //tekst "level" part
	        cleared_levels[i].texCoord( level_tekst_tex_x_1, level_tekst_tex_y_0 );
	        cleared_levels[i].vertex( (9 + increase_level_mesh), 16, -15f );
	        cleared_levels[i].texCoord( level_tekst_tex_x_0, level_tekst_tex_y_0 );
	        cleared_levels[i].vertex( (32 + increase_level_mesh), 16, -15f );
	        cleared_levels[i].texCoord( level_tekst_tex_x_0, level_tekst_tex_y_1 );
	        cleared_levels[i].vertex( (32 + increase_level_mesh), 8, -15f);
	        cleared_levels[i].texCoord( level_tekst_tex_x_0, level_tekst_tex_y_1 );
	        cleared_levels[i].vertex( (32 + increase_level_mesh), 8, -15f);
	        cleared_levels[i].texCoord( level_tekst_tex_x_1, level_tekst_tex_y_1 );
	        cleared_levels[i].vertex( (9 + increase_level_mesh), 8, -15f);
	        cleared_levels[i].texCoord( level_tekst_tex_x_1, level_tekst_tex_y_0 );
	        cleared_levels[i].vertex( (9 + increase_level_mesh), 16, -15f);
	        
	        //tekst "cleared" part
	        cleared_levels[i].texCoord( cleared_tekst_tex_x_1, cleared_tekst_tex_y_0 );
	        cleared_levels[i].vertex( (-35 - increase_level_mesh), 16, -15f );
	        cleared_levels[i].texCoord( cleared_tekst_tex_x_0, cleared_tekst_tex_y_0 );
	        cleared_levels[i].vertex( (-2 - increase_level_mesh), 16, -15f );
	        cleared_levels[i].texCoord( cleared_tekst_tex_x_0, cleared_tekst_tex_y_1 );
	        cleared_levels[i].vertex( (-2 - increase_level_mesh), 8, -15f);
	        cleared_levels[i].texCoord( cleared_tekst_tex_x_0, cleared_tekst_tex_y_1 );
	        cleared_levels[i].vertex( (-2 - increase_level_mesh), 8, -15f);
	        cleared_levels[i].texCoord( cleared_tekst_tex_x_1, cleared_tekst_tex_y_1 );
	        cleared_levels[i].vertex( (-35 - increase_level_mesh), 8, -15f);
	        cleared_levels[i].texCoord( cleared_tekst_tex_x_1, cleared_tekst_tex_y_0 );
	        cleared_levels[i].vertex( (-35 - increase_level_mesh), 16, -15f);
	        
	        //next level button on level cleared
	        cleared_levels[i].texCoord( next_level_button_tex_x_1, next_level_button_tex_y_0 );
	        cleared_levels[i].vertex( -22, 1, -15f );
	        cleared_levels[i].texCoord( next_level_button_tex_x_0, next_level_button_tex_y_0 );
	        cleared_levels[i].vertex( -10, 1, -15f );
	        cleared_levels[i].texCoord( next_level_button_tex_x_0, next_level_button_tex_y_1 );
	        cleared_levels[i].vertex( -10, -11, -15f);
	        cleared_levels[i].texCoord( next_level_button_tex_x_0, next_level_button_tex_y_1 );
	        cleared_levels[i].vertex( -10, -11, -15f);
	        cleared_levels[i].texCoord( next_level_button_tex_x_1, next_level_button_tex_y_1 );
	        cleared_levels[i].vertex( -22, -11, -15f);
	        cleared_levels[i].texCoord( next_level_button_tex_x_1, next_level_button_tex_y_0 );
	        cleared_levels[i].vertex( -22, 1, -15f);
	        
	        //menu button on level cleared
	        cleared_levels[i].texCoord( menu_button_tex_x_1, menu_button_tex_y_0 );
	        cleared_levels[i].vertex( 10, 1, -15f );
	        cleared_levels[i].texCoord( menu_button_tex_x_0, menu_button_tex_y_0 );
	        cleared_levels[i].vertex( 22, 1, -15f );
	        cleared_levels[i].texCoord( menu_button_tex_x_0, menu_button_tex_y_1 );
	        cleared_levels[i].vertex( 22, -11, -15f);
	        cleared_levels[i].texCoord( menu_button_tex_x_0, menu_button_tex_y_1 );
	        cleared_levels[i].vertex( 22, -11, -15f);
	        cleared_levels[i].texCoord( menu_button_tex_x_1, menu_button_tex_y_1 );
	        cleared_levels[i].vertex( 10, -11, -15f);
	        cleared_levels[i].texCoord( menu_button_tex_x_1, menu_button_tex_y_0 );
	        cleared_levels[i].vertex( 10, 1, -15f);
	        
	        if( i == 1 )
	        {
	        	level_cleared_number_tex_x_0 = (0f/1024f);
	        	level_cleared_number_tex_x_1 = (54f/1024f);
	        	level_cleared_number_tex_y_0 = (0f/512f);
	        	level_cleared_number_tex_y_1 = (62f/512f);
	        }
	        else if( i == 2 )
	        {
	        	level_cleared_number_tex_x_0 = (54f/1024f);
	        	level_cleared_number_tex_x_1 = (104f/1024f);
	        	level_cleared_number_tex_y_0 = (0f/512f);
	        	level_cleared_number_tex_y_1 = (62f/512f);
	        }
	        else if( i == 3 )
	        {
	        	level_cleared_number_tex_x_0 = (106f/1024f);
	        	level_cleared_number_tex_x_1 = (157f/1024f);
	        	level_cleared_number_tex_y_0 = (0f/512f);
	        	level_cleared_number_tex_y_1 = (62f/512f);
	        }
	        else if( i == 4 )
	        {
	        	level_cleared_number_tex_x_0 = (160f/1024f);
	        	level_cleared_number_tex_x_1 = (214f/1024f);
	        	level_cleared_number_tex_y_0 = (0f/512f);
	        	level_cleared_number_tex_y_1 = (62f/512f);
	        }
	        else if( i == 5 )
	        {
	        	level_cleared_number_tex_x_0 = (216f/1024f);
	        	level_cleared_number_tex_x_1 = (270f/1024f);
	        	level_cleared_number_tex_y_0 = (0f/512f);
	        	level_cleared_number_tex_y_1 = (62f/512f);
	        }
	        else if( i == 6 )
	        {
	        	level_cleared_number_tex_x_0 = (274f/1024f);
	        	level_cleared_number_tex_x_1 = (325f/1024f);
	        	level_cleared_number_tex_y_0 = (0f/512f);
	        	level_cleared_number_tex_y_1 = (62f/512f);
	        }
	        else if( i == 7 )
	        {
	        	level_cleared_number_tex_x_0 = (325f/1024f);
	        	level_cleared_number_tex_x_1 = (372f/1024f);
	        	level_cleared_number_tex_y_0 = (0f/512f);
	        	level_cleared_number_tex_y_1 = (62f/512f);
	        }
	        else if( i == 8 )
	        {
	        	level_cleared_number_tex_x_0 = (374f/1024f);
	        	level_cleared_number_tex_x_1 = (426f/1024f);
	        	level_cleared_number_tex_y_0 = (0f/512f);
	        	level_cleared_number_tex_y_1 = (62f/512f);
	        }
	        else if( i == 9 )
	        {
	        	level_cleared_number_tex_x_0 = (428f/1024f);
	        	level_cleared_number_tex_x_1 = (480f/1024f);
	        	level_cleared_number_tex_y_0 = (0f/512f);
	        	level_cleared_number_tex_y_1 = (62f/512f);
	        }
	        else if( i == 10 )
	        {
	        	level_cleared_number_tex_x_0 = (0f/1024f);
	        	level_cleared_number_tex_x_1 = (100f/1024f);
	        	level_cleared_number_tex_y_0 = (63f/512f);
	        	level_cleared_number_tex_y_1 = (125f/512f);
	        }
	        else if( i == 11 )
	        {
	        	level_cleared_number_tex_x_0 = (102f/1024f);
	        	level_cleared_number_tex_x_1 = (203f/1024f);
	        	level_cleared_number_tex_y_0 = (63f/512f);
	        	level_cleared_number_tex_y_1 = (125f/512f);
	        }
	        else if( i == 12 )
	        {
	        	level_cleared_number_tex_x_0 = (204f/1024f);
	        	level_cleared_number_tex_x_1 = (304f/1024f);
	        	level_cleared_number_tex_y_0 = (63f/512f);
	        	level_cleared_number_tex_y_1 = (125f/512f);
	        }
	        else if( i == 13 )
	        {
	        	level_cleared_number_tex_x_0 = (306f/1024f);
	        	level_cleared_number_tex_x_1 = (408f/1024f);
	        	level_cleared_number_tex_y_0 = (63f/512f);
	        	level_cleared_number_tex_y_1 = (125f/512f);
	        }
	        else if( i == 14 )
	        {
	        	level_cleared_number_tex_x_0 = (408f/1024f);
	        	level_cleared_number_tex_x_1 = (510f/1024f);
	        	level_cleared_number_tex_y_0 = (63f/512f);
	        	level_cleared_number_tex_y_1 = (125f/512f);
	        }
	        else if( i == 15 )
	        {
	        	level_cleared_number_tex_x_0 = (0f/1024f);
	        	level_cleared_number_tex_x_1 = (102f/1024f);
	        	level_cleared_number_tex_y_0 = (126f/512f);
	        	level_cleared_number_tex_y_1 = (189f/512f);
	        }
	        else if( i == 16 )
	        {
	        	level_cleared_number_tex_x_0 = (108f/1024f);
	        	level_cleared_number_tex_x_1 = (208f/1024f);
	        	level_cleared_number_tex_y_0 = (126f/512f);
	        	level_cleared_number_tex_y_1 = (189f/512f);
	        }
	        else if( i == 17 )
	        {
	        	level_cleared_number_tex_x_0 = (210f/1024f);
	        	level_cleared_number_tex_x_1 = (306f/1024f);
	        	level_cleared_number_tex_y_0 = (126f/512f);
	        	level_cleared_number_tex_y_1 = (189f/512f);
	        }
	        else if( i == 18 )
	        {
	        	level_cleared_number_tex_x_0 = (306f/1024f);
	        	level_cleared_number_tex_x_1 = (408f/1024f);
	        	level_cleared_number_tex_y_0 = (126f/512f);
	        	level_cleared_number_tex_y_1 = (189f/512f);
	        }
	        else if( i == 19 )
	        {
	        	level_cleared_number_tex_x_0 = (408f/1024f);
	        	level_cleared_number_tex_x_1 = (508f/1024f);
	        	level_cleared_number_tex_y_0 = (126f/512f);
	        	level_cleared_number_tex_y_1 = (189f/512f);
	        }
	        else if( i == 20 )
	        {
	        	level_cleared_number_tex_x_0 = (0f/1024f);
	        	level_cleared_number_tex_x_1 = (103f/1024f);
	        	level_cleared_number_tex_y_0 = (189f/512f);
	        	level_cleared_number_tex_y_1 = (252f/512f);
	        }
	        else if( i == 21 )
	        {
	        	level_cleared_number_tex_x_0 = (103f/1024f);
	        	level_cleared_number_tex_x_1 = (206f/1024f);
	        	level_cleared_number_tex_y_0 = (189f/512f);
	        	level_cleared_number_tex_y_1 = (252f/512f);
	        }
	        else if( i == 22 )
	        {
	        	level_cleared_number_tex_x_0 = (206f/1024f);
	        	level_cleared_number_tex_x_1 = (308f/1024f);
	        	level_cleared_number_tex_y_0 = (189f/512f);
	        	level_cleared_number_tex_y_1 = (252f/512f);
	        }
	        else if( i == 23 )
	        {
	        	level_cleared_number_tex_x_0 = (308f/1024f);
	        	level_cleared_number_tex_x_1 = (410f/1024f);
	        	level_cleared_number_tex_y_0 = (189f/512f);
	        	level_cleared_number_tex_y_1 = (252f/512f);
	        }
	        else if( i == 24 )
	        {
	        	level_cleared_number_tex_x_0 = (410f/1024f);
	        	level_cleared_number_tex_x_1 = (514f/1024f);
	        	level_cleared_number_tex_y_0 = (189f/512f);
	        	level_cleared_number_tex_y_1 = (252f/512f);
	        }
	        else if( i == 25 )
	        {
	        	level_cleared_number_tex_x_0 = (0f/1024f);
	        	level_cleared_number_tex_x_1 = (104f/1024f);
	        	level_cleared_number_tex_y_0 = (253f/512f);
	        	level_cleared_number_tex_y_1 = (315f/512f);
	        }
	        else if( i == 26 )
	        {
	        	level_cleared_number_tex_x_0 = (104f/1024f);
	        	level_cleared_number_tex_x_1 = (206f/1024f);
	        	level_cleared_number_tex_y_0 = (253f/512f);
	        	level_cleared_number_tex_y_1 = (315f/512f);
	        }
	        else if( i == 27 )
	        {
	        	level_cleared_number_tex_x_0 = (207f/1024f);
	        	level_cleared_number_tex_x_1 = (305f/1024f);
	        	level_cleared_number_tex_y_0 = (253f/512f);
	        	level_cleared_number_tex_y_1 = (315f/512f);
	        }
	        else if( i == 28 )
	        {
	        	level_cleared_number_tex_x_0 = (306f/1024f);
	        	level_cleared_number_tex_x_1 = (407f/1024f);
	        	level_cleared_number_tex_y_0 = (253f/512f);
	        	level_cleared_number_tex_y_1 = (315f/512f);
	        }
	        else if( i == 29 )
	        {
	        	level_cleared_number_tex_x_0 = (408f/1024f);
	        	level_cleared_number_tex_x_1 = (510f/1024f);
	        	level_cleared_number_tex_y_0 = (253f/512f);
	        	level_cleared_number_tex_y_1 = (315f/512f);
	        }
	        else if( i == 30 )
	        {
	        	level_cleared_number_tex_x_0 = (0f/1024f);
	        	level_cleared_number_tex_x_1 = (103f/1024f);
	        	level_cleared_number_tex_y_0 = (316f/512f);
	        	level_cleared_number_tex_y_1 = (378f/512f);
	        }
	        else if( i == 31 )
	        {
	        	level_cleared_number_tex_x_0 = (104f/1024f);
	        	level_cleared_number_tex_x_1 = (205f/1024f);
	        	level_cleared_number_tex_y_0 = (316f/512f);
	        	level_cleared_number_tex_y_1 = (378f/512f);
	        }
	        else if( i == 32 )
	        {
	        	level_cleared_number_tex_x_0 = (206f/1024f);
	        	level_cleared_number_tex_x_1 = (307f/1024f);
	        	level_cleared_number_tex_y_0 = (316f/512f);
	        	level_cleared_number_tex_y_1 = (378f/512f);
	        }
	        else if( i == 33 )
	        {
	        	level_cleared_number_tex_x_0 = (308f/1024f);
	        	level_cleared_number_tex_x_1 = (409f/1024f);
	        	level_cleared_number_tex_y_0 = (316f/512f);
	        	level_cleared_number_tex_y_1 = (378f/512f);
	        }
	        else if( i == 34 )
	        {
	        	level_cleared_number_tex_x_0 = (410f/1024f);
	        	level_cleared_number_tex_x_1 = (514f/1024f);
	        	level_cleared_number_tex_y_0 = (316f/512f);
	        	level_cleared_number_tex_y_1 = (378f/512f);
	        }
	        else if( i == 35 )
	        {
	        	level_cleared_number_tex_x_0 = (0f/1024f);
	        	level_cleared_number_tex_x_1 = (102f/1024f);
	        	level_cleared_number_tex_y_0 = (379f/512f);
	        	level_cleared_number_tex_y_1 = (441f/512f);
	        }
	        else if( i == 36 )
	        {
	        	level_cleared_number_tex_x_0 = (103f/1024f);
	        	level_cleared_number_tex_x_1 = (206f/1024f);
	        	level_cleared_number_tex_y_0 = (379f/512f);
	        	level_cleared_number_tex_y_1 = (441f/512f);
	        }
	        else if( i == 37 )
	        {
	        	level_cleared_number_tex_x_0 = (207f/1024f);
	        	level_cleared_number_tex_x_1 = (306f/1024f);
	        	level_cleared_number_tex_y_0 = (379f/512f);
	        	level_cleared_number_tex_y_1 = (441f/512f);
	        }
	        else if( i == 38 )
	        {
	        	level_cleared_number_tex_x_0 = (307f/1024f);
	        	level_cleared_number_tex_x_1 = (408f/1024f);
	        	level_cleared_number_tex_y_0 = (379f/512f);
	        	level_cleared_number_tex_y_1 = (441f/512f);
	        }
	        else if( i == 39 )
	        {
	        	level_cleared_number_tex_x_0 = (410f/1024f);
	        	level_cleared_number_tex_x_1 = (512f/1024f);
	        	level_cleared_number_tex_y_0 = (379f/512f);
	        	level_cleared_number_tex_y_1 = (441f/512f);
	        }
	        else if( i == 40 )
	        {
	        	level_cleared_number_tex_x_0 = (0f/1024f);
	        	level_cleared_number_tex_x_1 = (102f/1024f);
	        	level_cleared_number_tex_y_0 = (442f/512f);
	        	level_cleared_number_tex_y_1 = (503f/512f);
	        }
	        else
	        {
	        	level_cleared_number_tex_x_0 = 0;
	        	level_cleared_number_tex_x_1 = 1;
	        	level_cleared_number_tex_y_0 = 0;
	        	level_cleared_number_tex_y_1 = 1;
	        }
	        //the number of the level that is cleared
	        cleared_levels[i].texCoord( level_cleared_number_tex_x_1, level_cleared_number_tex_y_0 );
	        cleared_levels[i].vertex( (0.5f - increase_level_mesh), 15.5f, -15f );
	        cleared_levels[i].texCoord( level_cleared_number_tex_x_0, level_cleared_number_tex_y_0 );
	        cleared_levels[i].vertex( (5.5f + increase_level_mesh), 15.5f, -15f );
	        cleared_levels[i].texCoord( level_cleared_number_tex_x_0, level_cleared_number_tex_y_1 );
	        cleared_levels[i].vertex( (5.5f + increase_level_mesh), 8.5f, -15f);
	        cleared_levels[i].texCoord( level_cleared_number_tex_x_0, level_cleared_number_tex_y_1 );
	        cleared_levels[i].vertex( (5.5f + increase_level_mesh), 8.5f, -15f);
	        cleared_levels[i].texCoord( level_cleared_number_tex_x_1, level_cleared_number_tex_y_1 );
	        cleared_levels[i].vertex( (0.5f - increase_level_mesh), 8.5f, -15f);
	        cleared_levels[i].texCoord( level_cleared_number_tex_x_1, level_cleared_number_tex_y_0 );
	        cleared_levels[i].vertex( (0.5f - increase_level_mesh), 15.5f, -15f);
        }
        
        
	}
	
	public Mesh Mesh_Fire_Button()
	{
		return Fire_Button_Mesh;
	}
	
	public Mesh Mesh_Background()
	{
		return background_mesh_levels;
	}
	
	public Mesh Mesh_Background_Menu()
	{
		return background_mesh_menu;
	}
	
	public Mesh Mesh_Wall()
	{
		return wall_levels;
	}
	
	public Mesh Mesh_Wall_Menu()
	{
		return wall_menu;
	}
	
	public Mesh Mesh_Pause()
	{
		return pause_mesh;
	}
	
	public Mesh Mesh_Transparent_Button()
	{
		return pause_button_pressed;
	}
	
	public Mesh Mesh_Help_Screen()
	{
		return help_screens;
	}

	public Mesh[] Mesh_Cube()
	{
		return cubes;
	}
	
	public Mesh[] Mesh_Laser()
	{
		return laser_shot;
	}
	
	public Mesh[] Mesh_Levels_Cleared()
	{
		return cleared_levels;
	}


}
