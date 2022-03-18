package com.example.daniwebimplementlifecycleownerinservice

import android.content.Intent

import android.os.IBinder
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ServiceLifecycleDispatcher
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class MyLifecycleService: CustomLibraryService(), LifecycleOwner {
    private val mServiceLifecycleDispatcher = ServiceLifecycleDispatcher(this)

    override fun getLifecycle() = mServiceLifecycleDispatcher.lifecycle

    override fun onBind(p0: Intent?): IBinder? {
        mServiceLifecycleDispatcher.onServicePreSuperOnBind()
        return super.onBind(p0)
    }

    override fun onCreate() {
        mServiceLifecycleDispatcher.onServicePreSuperOnCreate()
        super.onCreate()
    }

    //Deprecated, but you might need to add this if targeting really old API.
    override fun onStart(intent: Intent?, startId: Int) {
        mServiceLifecycleDispatcher.onServicePreSuperOnStart()
        super.onStart(intent, startId)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        mServiceLifecycleDispatcher.onServicePreSuperOnStart()

        lifecycleScope.launch {  }

/*        Sample LiveData Usage
        data.observe(this){
            //Do work
        }*/

        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        mServiceLifecycleDispatcher.onServicePreSuperOnDestroy()
        super.onDestroy()
    }

}
