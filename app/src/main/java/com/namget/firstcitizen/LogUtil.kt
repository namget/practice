package com.namget.firstcitizen
import android.app.Activity
import android.util.Log


fun Activity.loge(message : String){
    if(BuildConfig.DEBUG){
        Log.e(this::class.java.simpleName,message)
    }
}


fun Activity.logd(message : String){
    if(BuildConfig.DEBUG){
        Log.d(this::class.java.simpleName,message)
    }
}
