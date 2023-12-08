package ir.mkv.sharedpreferencesexample

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ir.mkv.sharedpreferencesexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            txt.text = getString(R.string.welcome, PR["userName", ""])

            txtLogout.setOnClickListener {
                startActivity(Intent(this@MainActivity, SplashActivity::class.java))
                this@MainActivity.finish()

            }
            txtDelete.setOnClickListener {
                PR["isRegistered"] = false
                PR["userName"] = ""
                PR["password"] = ""
                startActivity(Intent(this@MainActivity, SplashActivity::class.java))
                this@MainActivity.finish()
            }
        }


    }
}