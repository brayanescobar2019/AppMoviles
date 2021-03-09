package com.example.superheroes

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.graphics.drawable.toBitmap
import com.example.superheroes.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.btnSend.setOnClickListener {
            val intent = Intent(this, VerDatosActivity::class.java)
            val heroe:String = viewBinding.etHeroreName.text.toString()
            val power:Float = viewBinding.rbPower.rating
            val bitmap:Bitmap = viewBinding.ivPhoto.drawable.toBitmap()
            intent.putExtra(VerDatosActivity.HEROE_KEY, heroe)
            intent.putExtra(VerDatosActivity.POWER_KEY, power)
            intent.putExtra(VerDatosActivity.IMAGE_KEY, bitmap)
            startActivity(intent)
        }

        viewBinding.ivPhoto.setOnClickListener{
            val intentImplicito = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intentImplicito, 7)
        }

        // Video 1
        //viewBinding.btnSend.setOnClickListener {
        //    var heroe:String = getString(R.string.notification,viewBinding.etNameHero.text.toString())
        //    //Toast.makeText(this, "You send $heroe", Toast.LENGTH_LONG).show()
        //    Snackbar.make(it,heroe, Snackbar.LENGTH_LONG)
        //        .setAnchorView(R.id.btnSend)
        //        .show()
        //}
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 7 && resultCode== Activity.RESULT_OK) {
            val imagen:Bundle? = data?.extras
            val heroeImage:Bitmap? = imagen?.getParcelable<Bitmap>("data")
            viewBinding.ivPhoto.setImageBitmap(heroeImage)
        }
    }
}