package com.example.superheroes

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.superheroes.databinding.ActivityMainBinding
import com.example.superheroes.databinding.ActivityVerDatosBinding

class VerDatosActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityVerDatosBinding
    companion object {
        const val HEROE_KEY = "heroe_key"
        const val POWER_KEY = "power_key"
        const val IMAGE_KEY = "image_key"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityVerDatosBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        val intent:Bundle = intent.extras!!
        viewBinding.tvSendName.text = intent.getString(HEROE_KEY)
        viewBinding.ratingBar.rating = intent.getFloat(POWER_KEY)
        viewBinding.sendPhoto.setImageBitmap(intent.getParcelable<Bitmap>(IMAGE_KEY))
    }
}