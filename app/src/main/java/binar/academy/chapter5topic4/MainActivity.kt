package binar.academy.chapter5topic4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import binar.academy.chapter5topic4.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // It will navigate to Login Form
        binding.btnMove.setOnClickListener {
            startActivity(Intent(this,LoginActivity :: class.java))
        }

        // Button switch to English language
        binding.ibEnglish.setOnClickListener {
            setLocale("en")
        }

        // Button switch to Indonesia language
        binding.ibIndonesian.setOnClickListener {
            setLocale("id")
        }
    }

    // Bilingual localization (English & Indonesian)
    fun setLocale(lang: String?) {
        val myLocale = Locale(lang)
        val res = resources
        val config = res.configuration
        config.locale = myLocale
        res.updateConfiguration(config, res.displayMetrics)
        startActivity(Intent(this, MainActivity :: class.java))
        finish()
    }
}