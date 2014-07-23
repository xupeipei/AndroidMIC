package com.android.audioservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.util.Log;
import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

/*¼ì²â¶ú»ú²å²¥ÊÂ¼þ*/
public class JackDetectReceiver extends BroadcastReceiver {

	private static final String TAG = "AUDIOSERVICE";

	@Override
	public void onReceive(Context context, Intent intent) {
		AudioManager localAudioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
		// TODO Auto-generated method stub
	    if (intent.hasExtra("state")) {  
            if (intent.getIntExtra("state", 0) == 0) {      
            	/*headset not connected*/
            	Log.i(TAG, "headset disconnect...........");
            	if (!localAudioManager.isMicrophoneMute()) {
            		localAudioManager.setMicrophoneMute(true);
            	}
            } else if (intent.getIntExtra("state", 0) == 1) {  
            	/*headsest connected open mic*/
            	Log.i(TAG, "headset plug in...........");
            	if (localAudioManager.isMicrophoneMute()) {
            		localAudioManager.setMicrophoneMute(false);
            	}
            }  
       }  
	}
}
