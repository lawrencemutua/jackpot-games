package com.jackpotgameslawi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.facebook.ads.*
import com.google.firebase.firestore.FirebaseFirestore
import com.jackpotgameslawi.Adapter.betikaAdapter
import com.jackpotgameslawi.Model.jackpot
import com.jackpotgameslawi.databinding.ActivitySportpesaMegaBinding

class SportpesaMegaActivity : AppCompatActivity() {
    private lateinit var adView: AdView
    private lateinit var interstitialAd: InterstitialAd
    private lateinit var binding: ActivitySportpesaMegaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySportpesaMegaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actionBar = supportActionBar
        actionBar!!.title = "Sportpesa Mega JP"
        actionBar.setDisplayHomeAsUpEnabled(true)

        binding.recyclerSportpesa.apply {
            layoutManager = LinearLayoutManager(this@SportpesaMegaActivity)
        }

        pickSportpesaGames()
    }

    private fun pickSportpesaGames() {
        FirebaseFirestore.getInstance().collection("megajp")
            .get()
            .addOnSuccessListener { documents->
                run {
                    for (document in documents){
                        val jackpotList = documents.toObjects(jackpot::class.java)
                        binding.recyclerSportpesa.adapter = betikaAdapter(this,jackpotList)
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


        interstitialAd = InterstitialAd(this, "IMG_16_9_APP_INSTALL#YOUR_PLACEMENT_ID")
        // Create listeners for the Interstitial Ad
        // Create listeners for the Interstitial Ad
        val interstitialAdListener: InterstitialAdListener = object : InterstitialAdListener {
            override fun onInterstitialDisplayed(ad: Ad) {
                // Interstitial ad displayed callback
                Log.e("TAG", "Interstitial ad displayed.")
            }

            override fun onInterstitialDismissed(ad: Ad) {
                // Interstitial dismissed callback
                Log.e("TAG", "Interstitial ad dismissed.")
            }

            override fun onError(ad: Ad, adError: AdError) {
                // Ad error callback
                Log.e("TAG", "Interstitial ad failed to load: " + adError.errorMessage)
            }

            override fun onAdLoaded(ad: Ad) {
                // Interstitial ad is loaded and ready to be displayed
                Log.d("TAG", "Interstitial ad is loaded and ready to be displayed!")
                // Show the ad
                interstitialAd!!.show()
            }

            override fun onAdClicked(ad: Ad) {
                // Ad clicked callback
                Log.d("TAG", "Interstitial ad clicked!")
            }

            override fun onLoggingImpression(ad: Ad) {
                // Ad impression logged callback
                Log.d("TAG", "Interstitial ad impression logged!")
            }
        }

        // For auto play video ads, it's recommended to load the ad
        // at least 30 seconds before it is shown
        interstitialAd!!.loadAd(
            interstitialAd!!.buildLoadAdConfig()
                .withAdListener(interstitialAdListener)
                .build()
        )
    }

}