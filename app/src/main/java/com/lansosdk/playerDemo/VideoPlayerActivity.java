package com.lansosdk.playerDemo;

import java.io.IOException;

import com.example.lansosdkplaydemo.R;
import com.lansosdk.videoeditor.MediaInfo;
import com.lansosdk.videoplayer.TextureRenderView;
import com.lansosdk.videoplayer.VPlayer;
import com.lansosdk.videoplayer.VideoPlayer;
import com.lansosdk.videoplayer.VideoPlayer.OnPlayerCompletionListener;
import com.lansosdk.videoplayer.VideoPlayer.OnPlayerPreparedListener;
import com.lansosdk.videoplayer.VideoPlayer.OnPlayerSeekCompleteListener;

import android.app.Activity;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Surface;
import android.view.View;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View.OnClickListener;
import android.widget.Toast;



public class VideoPlayerActivity extends Activity {
	   

	private TextureRenderView textureView;
    String videoPath=null;
  
    private static final boolean VERBOSE = false; 
    private static final String TAG = "VideoPlayerActivity";
    
    
    @Override  
    protected void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.player_layout);  
        
    	
        videoPath=getIntent().getStringExtra("videopath");

        MediaInfo info=new MediaInfo(videoPath);
        info.prepare();
        Log.i(TAG,"info:"+info.toString());
        
        
        
        textureView=(TextureRenderView)findViewById(R.id.surface1);
        textureView.setSurfaceTextureListener(new SurfaceTextureListener() {
			
			@Override
			public void onSurfaceTextureUpdated(SurfaceTexture surface) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width,
					int height) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public void onSurfaceTextureAvailable(SurfaceTexture surface, int width,
					int height) {
				// TODO Auto-generated method stub
				VPlayVideo(new Surface(surface));
			}
		});
        
    }  
    private Handler getTimeHandler=new  Handler();
    private Runnable  getTimeRunnable=new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			if(mVPlayer!=null){
				Log.i(TAG,"mVPlayer.getCurrentPosition()===>"+mVPlayer.getCurrentPosition());
				getTimeHandler.postDelayed(getTimeRunnable, 1000);
			}
		}
	};

    private VPlayer  mVPlayer=null;
    private void VPlayVideo(final Surface surface)
    {
          if (videoPath != null && mVPlayer==null){
        	  mVPlayer=new VPlayer(this);
        	  mVPlayer.setVideoPath(videoPath);
//        	  mVPlayer.setLooping(true);  //<-------------
              mVPlayer.setOnPreparedListener(new OnPlayerPreparedListener() {
    			
    			@Override
    			public void onPrepared(VideoPlayer mp) {
    				// TODO Auto-generated method stub
    						mVPlayer.setSurface(surface);
    					    textureView.setVideoSize(mp.getVideoWidth(), mp.getVideoHeight());
    				        textureView.requestLayout();
    				     
    				        mVPlayer.start();
    					}
    			});
              mVPlayer.setOnCompletionListener(new OnPlayerCompletionListener() {
				
				@Override
				public void onCompletion(VideoPlayer mp) {
					// TODO Auto-generated method stub
					Toast.makeText(getApplicationContext(), "视频播放完毕",Toast.LENGTH_LONG).show();
//					getTimeHandler.removeCallbacks(getTimeRunnable);
				}
			});
              
              mVPlayer.setOnSeekCompleteListener(new OnPlayerSeekCompleteListener() {
				
				@Override
				public void onSeekComplete(VideoPlayer mp) {
					// TODO Auto-generated method stub
					Toast.makeText(getApplicationContext(), "seek完成.",Toast.LENGTH_LONG).show();
				}
			});
              
        	  
          mVPlayer.prepareAsync();
        	  
          }else if(mVPlayer!=null){
        	  	mVPlayer.setSurface(surface);
          }
    }
   
    @Override  
    protected void onPause() {  
//       
        super.onPause();  
    }  
  
    @Override  
    protected void onDestroy() {  
        super.onDestroy();  
        
        if (mVPlayer!=null) {
        	mVPlayer.stop();
        	mVPlayer.release();
        	mVPlayer=null;  
        }
    }  
}
