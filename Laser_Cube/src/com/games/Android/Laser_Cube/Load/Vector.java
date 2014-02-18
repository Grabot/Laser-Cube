package com.games.Android.Laser_Cube.Load;


public class Vector 
{
        public float x, y, z;
        
        public Vector( float x, float y, float z )
        {
                this.x = x;
                this.y = y;
                this.z = z;
        }
        
        public Vector( )
        {
                x = y = z = 0;
        }
        
        public Vector( Vector v )
        {
                set( v );
        }
        
        public void set( Vector v )
        {
                this.x = v.x;
                this.y = v.y;
                this.z = v.z;
        }
        
        public Vector add( Vector v )
        {
                this.x += v.x;
                this.y += v.y;
                this.z += v.z;
                return this;
        }
        
        public Vector sub( Vector v )
        {
                this.x -= v.x;
                this.y -= v.y;
                this.z -= v.z;
                return this;
        }

        public void set(float x, float y, float z)
        {       
                this.x = x;
                this.y = y;
                this.z = z;
        }

        public float distance(Vector v) 
        {       
                float a = v.x - x;
                float b = v.y - y;
                float c = v.z - z;
                
                
                return (float)Math.sqrt( a * a + b * b + c * c );
                
        }
}
