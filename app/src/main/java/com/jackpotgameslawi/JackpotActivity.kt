package com.jackpotgameslawi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jackpotgameslawi.databinding.ActivityJackpotBinding

class JackpotActivity : AppCompatActivity() {
    private lateinit var binding: ActivityJackpotBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJackpotBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSportpesamega.setOnClickListener {
            val intent = Intent(this, SportpesaMegaActivity::class.java)
            startActivity(intent)
        }
        binding.btnBetikagrand.setOnClickListener {
            val intent = Intent(this, BetikaGrandActivity::class.java)
            startActivity(intent)
        }
        binding.btnBetikamid.setOnClickListener {
            val intent = Intent(this, BetikaMidActivity::class.java)
            startActivity(intent)
        }
        binding.btnSporty.setOnClickListener {
            val intent = Intent(this, SportybetActivity::class.java)
            startActivity(intent)
        }
        binding.btnSportpesamini.setOnClickListener {
            val intent = Intent(this, SportpesaMiniActivity::class.java)
            startActivity(intent)
        }
    }
}