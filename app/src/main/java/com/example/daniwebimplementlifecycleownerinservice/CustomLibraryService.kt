package com.example.daniwebimplementlifecycleownerinservice

import android.app.Service
import android.content.Intent
import android.os.IBinder

//Making this open to simulate a library class
open class CustomLibraryService : Service() {
    //return null for tutorial only.
    override fun onBind(p0: Intent?): IBinder? = null
}