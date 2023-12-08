package ir.mkv.sharedpreferencesexample

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ir.mkv.sharedpreferencesexample.databinding.ActivitySplashBinding
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        GlobalScope.launch() {
            delay(3000)
            if (PR["isRegistered", false]) startActivity(
                Intent(
                    this@SplashActivity,
                    LoginActivity::class.java
                )
            )
            else startActivity(Intent(this@SplashActivity, RegisterActivity::class.java))
            this@SplashActivity.finish()
        }

    }
}