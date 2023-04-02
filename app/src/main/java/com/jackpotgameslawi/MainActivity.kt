package com.jackpotgameslawi

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.jackpotgameslawi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var phoneNumber: Number // Declare the phone number variable


    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.btnFootball10odds.setOnClickListener{
            val intent = Intent(this, Foot10Activity::class.java)
            startActivity(intent)
        }
        binding.btnSafepicks.setOnClickListener{
            val intent = Intent(this, SafepicksActivity::class.java)
            startActivity(intent)
        }
        binding.btnOverundertips.setOnClickListener{
            val intent = Intent(this, OverUnderActivity::class.java)
            startActivity(intent)
        }
        binding.btnFootball3odds.setOnClickListener{
            val intent = Intent(this,Foot3Activity::class.java)
            startActivity(intent)
        }
        binding.btnJackpottips.setOnClickListener {
            val intent = Intent(this, JackpotActivity::class.java)
            startActivity(intent)
        }
        binding.btnVip.setOnClickListener {

            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://wa.me/$phoneNumber")
            startActivity(intent)
        }
        // Set up a listener to retrieve the phone number from Firebase
        // Write a message to the database
        val database = Firebase.database
        val phoneNumberRef = database.getReference("phone_number")
        // Read from the database
        phoneNumberRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                phoneNumber = snapshot.value as Number // Retrieve the phone number from the database
            }

            override fun onCancelled(error: DatabaseError) {
                // Handle errors here
            }
        })
    }


}