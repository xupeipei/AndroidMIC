package com.android.audioservice;

/*主服务，监听耳机插拔事件，开机自启动，后台服务，耳机插入后打开MIC*/
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.IBinder;
import android.util.Log;

public class AudioService extends Service {
	
	private String TAG = "AUDIOSERVICE";
	private JackDetectReceiver headsetPlugReceiver = null;
	
	@SuppressWarnings("deprecation")
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		
		Log.i(TAG, "AudioService oncreate..............");
		super.onCreate();
		registerHeadsetPlugReceiver(); 
		/*detect heset*/
		AudioManager localAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
		
		if (localAudioManager.isWiredHeadsetOn()) {
			Log.i(TAG, "localAudioManager.isWiredHeadsetOn()");
			localAudioManager.setMicrophoneMute(false);
		}
		
		new MyThread().start(); 
	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		Log.i(TAG, "AudioService onbind.............");
		return null;
	}
	
	private void registerHeadsetPlugReceiver() {  
	        headsetPlugReceiver = new JackDetectReceiver();   
	        IntentFilter intentFilter = new IntentFilter();  
	        intentFilter.addAction("android.intent.action.HEADSET_PLUG");  
	        registerReceiver(headsetPlugReceiver, intentFilter);  
	 }  
	
    public class MyThread extends Thread {  
        public void run() {  
            while (!Thread.currentThread().isInterrupted()) {  
                try {  
                    Thread.sleep(1000);
                    Log.i(TAG, "THREAD...............");
                } catch (InterruptedException e) {  
                    e.printStackTrace();  
                }  
            }  
        }  
    }
}
