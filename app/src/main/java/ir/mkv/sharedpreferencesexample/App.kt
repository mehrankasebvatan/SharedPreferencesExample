package ir.mkv.sharedpreferencesexample

import android.app.Application

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        PR.init(this)
    }

}