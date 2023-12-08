package ir.mkv.sharedpreferencesexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ir.mkv.sharedpreferencesexample.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}