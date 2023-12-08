package ir.mkv.sharedpreferencesexample

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import ir.mkv.sharedpreferencesexample.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
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
            btnLogin.setOnClickListener {
                if (inputUserName.text.toString().isEmpty()) loUserName.error =
                    getString(R.string.empty_error)
                else if (inputPassword.text.toString().isEmpty()) {
                    loUserName.error = null
                    loPassword.error = getString(R.string.empty_error)
                } else {
                    loUserName.error = null
                    loPassword.error = null
                    if (PR["userName", ""] == inputUserName.text.toString() &&
                        PR["password", ""] == inputPassword.text.toString()
                    ) {
                        Toast.makeText(
                            this@LoginActivity,
                            "Successful Login!",
                            Toast.LENGTH_SHORT
                        ).show()
                        startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                        this@LoginActivity.finish()

                    } else Toast.makeText(
                        this@LoginActivity,
                        getString(R.string.username_or_password_doesn_t_match), Toast.LENGTH_SHORT
                    ).show()

                }
            }
        }
    }
}