package com.games.Android.Laser_Cube.Load;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import com.badlogic.gdx.graphics.GL10;


public final class Mesh
{
        public enum PrimitiveType
        {
                Points,
                Lines,
                Triangles,
                LineStrip,
                TriangleStrip,
                TriangleFan
        }
        
        /** The gl instance **/  
        private GL10 gl;        
        
        /** vertex position buffer and array **/
        private float vertices[];
        private FloatBuffer vertexBuffer;
        
        /** color buffer and array **/
        private float colors[];
        private FloatBuffer colorBuffer;
        
        /** texture coordinate buffer and array **/
        private float texCoords[];
        private FloatBuffer texCoordBuffer;
        
        /** normal buffer and array **/
        private float normals[];
        private FloatBuffer normalBuffer;
        
        /** vertex index at which the next vertex gets inserted **/
        private int index = 0;
        
        /** number of vertices defined for the mesh **/
        private int numVertices = 0;
        
        /** is the mesh dirty? **/
        private boolean dirty = true;
        
        public Mesh( GL10 gl, int numVertices, boolean hasColors, boolean hasTextureCoordinates, boolean hasNormals )
        {
                this.gl = gl;
                vertices = new float[numVertices * 3];          
                vertexBuffer = allocateBuffer( numVertices * 3 );
                
                if( hasColors )
                {
                        colors = new float[numVertices * 4];
                        colorBuffer = allocateBuffer( numVertices * 4 );
                }
                
                if( hasTextureCoordinates )
                {
                        texCoords = new float[numVertices * 2];
                        texCoordBuffer = allocateBuffer( numVertices * 2 );
                }
                
                if( hasNormals )
                {
                        normals = new float[numVertices * 3];
                        normalBuffer = allocateBuffer( numVertices * 3 );
                }
        }
        
        /**
         * Allocates a direct FloatBuffer of the given size.
         * Sets order to native
         * @param size The size in number of floats
         * @return The FloatBuffer
         */
        private FloatBuffer allocateBuffer( int size )
        {
                ByteBuffer buffer = ByteBuffer.allocateDirect( size * 4 );
                buffer.order(ByteOrder.nativeOrder());
                return buffer.asFloatBuffer();
        }
        
        /**
         * updates the direct buffers in case the user
         */
        private void update( )
        {
                vertexBuffer.put(vertices);
                vertexBuffer.position(0);
                
                if( colors != null )
                {
                        colorBuffer.put( colors );
                        colorBuffer.position(0);
                }
                
                if( texCoords != null )
                {
                        texCoordBuffer.put( texCoords );
                        texCoordBuffer.position(0);
                }
                
                if( normals != null )
                {
                        normalBuffer.put( normals );
                        normalBuffer.position(0);
                }
                
                numVertices = index;
                index = 0;
                dirty = false;
        }
        
        /**
         * Returns the OpenGL constant for the given 
         * primitive type
         * @param type the type
         * @return the OpenGL constant
         */
        private int getPrimitiveType( PrimitiveType type )
        {
                if( type == PrimitiveType.Lines )
                        return GL10.GL_LINES;
                else
                if( type == PrimitiveType.Triangles )
                        return GL10.GL_TRIANGLES;
                else
                if( type == PrimitiveType.LineStrip)
                        return GL10.GL_LINE_STRIP;
                else            
                if( type == PrimitiveType.TriangleStrip)
                        return GL10.GL_TRIANGLE_STRIP;
                else
                if( type == PrimitiveType.Points )
                        return GL10.GL_POINTS;
                else            
                        return GL10.GL_TRIANGLE_FAN;
                
        }
        
        /**
         * Renders the mesh as the given type, starting at offset using
         * numVertices vertices.
         * @param type the type
         * @param offset the offset, in number of vertices
         * @param numVertices the number of vertices to use
         */
        public void render( PrimitiveType type, int offset, int numVertices )
        {
                if( dirty )
                        update();
                
                gl.glEnableClientState( GL10.GL_VERTEX_ARRAY );
                gl.glVertexPointer( 3, GL10.GL_FLOAT, 0, vertexBuffer );
                
                if( colors != null )
                {
                        gl.glEnableClientState( GL10.GL_COLOR_ARRAY );
                        gl.glColorPointer( 4, GL10.GL_FLOAT, 0, colorBuffer );
                }
                
                if( texCoords != null )
                {
                        gl.glEnableClientState( GL10.GL_TEXTURE_COORD_ARRAY );
                        gl.glTexCoordPointer( 2, GL10.GL_FLOAT, 0, texCoordBuffer );
                }
                
                if( normals != null )
                {
                        gl.glEnableClientState( GL10.GL_NORMAL_ARRAY );
                        gl.glNormalPointer( GL10.GL_FLOAT, 0, normalBuffer );
                }
                
                gl.glDrawArrays( getPrimitiveType( type ), offset, numVertices );
                
                gl.glDisableClientState(GL10.GL_VERTEX_ARRAY );
                if( colors != null )
                        gl.glDisableClientState(GL10.GL_COLOR_ARRAY );
                if( texCoords != null )
                        gl.glDisableClientState(GL10.GL_TEXTURE_COORD_ARRAY );
                if( normals != null )
                        gl.glDisableClientState(GL10.GL_NORMAL_ARRAY );
        }
        
        /**
         * Renders the mesh as the given type using as many vertices as have
         * been defined by calling vertex().
         * @param type the type
         */
        public void render( PrimitiveType type )
        {
                render( type, 0, numVertices );
        }
        
        /**
         * Defines the position of the current vertex. Before
         * you call this you have to call any other method like
         * color, normal and texCoord for the current vertex!
         * 
         * @param x the x coordinate
         * @param y the y coordinate
         * @param z the z coordinate
         */
        public void vertex( float x, float y, float z )
        {               
                dirty = true;
                int offset = index * 3;
                vertices[offset] = x;
                vertices[offset+1] = y;
                vertices[offset+2] = z;
                index++;                        
        }

        /**
         * Sets the color of the current vertex
         * 
         * @param r the red component
         * @param g the green component
         * @param b the blue component
         * @param a the alpha component
         */
        public void color( float r, float g, float b, float a )
        {
                dirty = true;
                int offset = index * 4;
                colors[offset] = r;
                colors[offset+1] = g;
                colors[offset+2] = b;
                colors[offset+3] = a;           
        }
        
        /**
         * Sets the normal of the current vertex
         * @param x the x component
         * @param y the y component
         * @param z the z component
         */
        public void normal( float x, float y, float z )
        {
                dirty = true;
                int offset = index * 3;
                normals[offset] = x;
                normals[offset+1] = y;
                normals[offset+2] = z;
        }

        /**
         * Sets the texture coordinates of the current vertex
         * @param s the s coordinate
         * @param t the t coordinate
         */
        public void texCoord( float s, float t )
        {
                dirty = true;
                int offset = index * 2;
                texCoords[offset] = s;
                texCoords[offset+1] = t;                
        }
        
        public void dispose()
        {
        }
}