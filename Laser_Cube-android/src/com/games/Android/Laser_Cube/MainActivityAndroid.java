package com.games.Android.Laser_Cube;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;

public class MainActivityAndroid extends AndroidApplication implements IReqHandler  
{ 
	protected AdView adView;

    private final int SHOW_ADS = 1;
	private final int HIDE_ADS = 0;
	private final int SHOW_FULLADS = 3;
	private final int HIDE_FULLADS = 4;
	
    
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
    	super.onCreate(savedInstanceState);

        // Create the layout
        RelativeLayout layout = new RelativeLayout(this);

        // Do the stuff that initialize() would do for you
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);

        // Create the libgdx View
        View gameView = initializeForView(new Main(this), false);

        // Create and setup the AdMob view
        adView = new AdView(this, AdSize.BANNER, "xxxxxxxxxxxxxxx"); // Put in your secret key here
        adView.loadAd(new AdRequest());

        // Add the libgdx view
        layout.addView(gameView);

        // Add the AdMob view
        RelativeLayout.LayoutParams adParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        adParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        adParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);

        layout.addView(adView, adParams);

        // Hook it all up
        setContentView(layout);
    }

	protected Handler handler = new Handler() 
	{
		@Override
		public void handleMessage(Message msg) 
		{
			switch (msg.what) 
			{
				case SHOW_ADS: 
				{
					adView.setVisibility(View.VISIBLE);
					break;
				}
				case HIDE_ADS: {
					adView.setVisibility(View.GONE);
					break;
				}
			}
		}
	};

	public void showAds(boolean show) 
	{
		handler.sendEmptyMessage(show ? SHOW_ADS : HIDE_ADS);
	}
}