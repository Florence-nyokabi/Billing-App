package flo.app.billiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class SignUpActivity : AppCompatActivity() {
    lateinit var tilUserName: TextInputLayout
    lateinit var etUserName: TextInputEditText
    lateinit var tilEmailAddress: TextInputLayout
    lateinit var etEmailAddress: TextInputEditText
    lateinit var tilPassword: TextInputLayout
    lateinit var etPassword: TextInputEditText
    lateinit var btnLogIn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        castingViews()
    }
    override fun onResume() {
        super.onResume()
        btnLogIn.setOnClickListener {
            val intent = Intent(this, LogInActivity::class.java)
            startActivity(intent)
        }
        btnLogIn.setOnClickListener{
            clearingErrors()
            validatingSignUp()
        }
    }
    private fun castingViews() {
        tilUserName = findViewById(R.id.tilUserName)
        etUserName = findViewById(R.id.etUserName)
        tilEmailAddress = findViewById(R.id.tilEmailAddress)
        etEmailAddress = findViewById(R.id.etEmailAddress)
        tilPassword = findViewById(R.id.tilPassword)
        etPassword = findViewById(R.id.etPassword)
        btnLogIn = findViewById(R.id.btnLogIn)
    }
    private fun validatingSignUp() {
        val userName = etUserName.text.toString()
        val emailAddress = etEmailAddress.text.toString()
        val password = etPassword.text.toString()
        var error = false

        if (userName.isBlank()) {
            tilUserName.error = "A user name is a must."
            error = true
        }

        if (emailAddress.isBlank()) {
            tilEmailAddress.error = "You should have an valid email address."
            error = true
        }
        if (password.isBlank()) {
            tilPassword.error = "Must have a strong password."
            error = true
        }

        if (!error){
            Toast.makeText(this, "$userName  $emailAddress", Toast.LENGTH_LONG).show()
        }
    }
    fun clearingErrors(){
        tilUserName.error = null
        tilEmailAddress.error = null
        tilPassword.error = null
    }
}