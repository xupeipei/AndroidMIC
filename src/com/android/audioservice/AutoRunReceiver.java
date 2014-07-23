package com.android.audioservice;

/*开机自动启动*/
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class AutoRunReceiver extends BroadcastReceiver {
	
	private String TAG = "AUDIOSERVICE";
	@Override
 	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		Log.i(TAG, "AutoRunReceiver...................");
	 	Intent mBootIntent = new Intent(context, AudioService.class);
	 	context.startService(mBootIntent);
	 	//context.startActivity(mBootIntent);
 	}
}
