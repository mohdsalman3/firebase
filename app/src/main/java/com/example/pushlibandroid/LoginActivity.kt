package com.example.pushlibandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pushlibandroid.databinding.ActivityLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val sharedPreferences:UserPreference by lazy { UserPreference(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.logoutBtn.setOnClickListener { loggedOut() }
        binding.appVersion.text = "2.0"
    }

    private fun loggedOut(){
        sharedPreferences.setLoginState(false)
        launchMainActivity()
        finish()
    }

    private fun launchMainActivity(){
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }
}