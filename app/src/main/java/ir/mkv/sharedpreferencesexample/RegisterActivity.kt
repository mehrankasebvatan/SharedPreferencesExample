package ir.mkv.sharedpreferencesexample

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import ir.mkv.sharedpreferencesexample.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {

            inputUserName.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
                override fun afterTextChanged(s: Editable?) {
                    loUserName.error = null
                }
            })

            inputPassword.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
                override fun afterTextChanged(s: Editable?) {
                    loPassword.error = null
                }
            })


            btnRegister.setOnClickListener {
                if (inputUserName.text.toString().isEmpty()) loUserName.error =
                    getString(R.string.empty_error)
                else if (inputPassword.text.toString().isEmpty()) {
                    loUserName.error = null
                    loPassword.error = getString(R.string.empty_error)
                } else {
                    loUserName.error = null
                    loPassword.error = null
                    Toast.makeText(
                        this@RegisterActivity,
                        "Successful Register!",
                        Toast.LENGTH_SHORT
                    ).show()
                    PR["isRegistered"] = true
                    PR["userName"] = inputUserName.text.toString()
                    PR["password"] = inputPassword.text.toString()
                    startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
                    this@RegisterActivity.finish()
                }
            }
        }
    }
}