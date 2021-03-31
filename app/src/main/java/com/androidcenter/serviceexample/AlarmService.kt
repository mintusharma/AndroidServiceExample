package com.androidcenter.serviceexample

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.provider.Settings
import kotlin.properties.Delegates

class AlarmService:Service() {

    private var startMode:Int = 0
    private val mIBinder: IBinder? = null
    private lateinit var player:MediaPlayer
    override fun onCreate() {
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        player=MediaPlayer.create(this,R.raw.chitthi)

        player.isLooping = true
        player.start()

        return START_STICKY
    }
    override fun onBind(intent: Intent?): IBinder? {
        return mIBinder
    }
    override fun onDestroy() {
        super.onDestroy()
        player.stop()
    }
}