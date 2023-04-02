package com.jackpotgameslawi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.facebook.ads.AdSize
import com.facebook.ads.AdView
import com.facebook.ads.AudienceNetworkAds
import com.google.firebase.firestore.FirebaseFirestore
import com.jackpotgameslawi.Adapter.safePicksAdapter
import com.jackpotgameslawi.Model.game
import com.jackpotgameslawi.databinding.ActivitySafepicksBinding

class SafepicksActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySafepicksBinding
    private lateinit var adView: AdView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySafepicksBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actionBar = supportActionBar
        actionBar!!.title = "PICKS OF THE DAY"
        actionBar.setDisplayHomeAsUpEnabled(true)
        binding.recyclerSafepicks.apply {
            layoutManager = LinearLayoutManager(this@SafepicksActivity)
        }

        fetchsafegames()

    }

    private fun fetchsafegames() {
        FirebaseFirestore.getInstance().collection("SAFE-PICKS")
            .get()
            .addOnSuccessListener { documents->
                run {
                    for (document in documents){
                        val gameList = documents.toObjects(game::class.java)
                        binding.recyclerSafepicks.adapter = safePicksAdapter(this, gameList )
                    }
                }
            }
        AudienceNetworkAds.initialize(this)
        adView = AdView(this, "IMG_16_9_APP_INSTALL#YOUR_PLACEMENT_ID", AdSize.BANNER_HEIGHT_90)
        // Find the Ad Container
        val adContainer = binding.bannerContainer

// Add the ad view to your activity layout
        adContainer.addView(adView)

// Request an ad
        adView.loadAd()
    }
    override fun onDestroy() {
        adView.destroy()
        super.onDestroy()
    }
}