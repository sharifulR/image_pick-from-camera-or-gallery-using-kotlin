package com.wbsoft.imagepick

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.FileProvider
import com.wbsoft.imagepick.databinding.ActivityMainBinding
import java.io.File

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var imageUri: Uri

    private val contract= registerForActivityResult(ActivityResultContracts.TakePicture()) { isSuccess ->
        binding.profileImgId.setImageURI(null)
        binding.profileImgId.setImageURI(imageUri)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding=ActivityMainBinding.inflate(layoutInflater)


        imageUri=takePicture()!!
        binding.linTakenPhoto.setOnClickListener {
            contract.launch(imageUri)
        }


        setContentView(binding.root)

    }
    private fun takePicture():Uri? {
        val imageFile = File(applicationContext.filesDir,"camera_photo.png")//fragment "requireContext()"
        return FileProvider.getUriForFile(
            applicationContext,
            "com.wbsoft.imagepick.fileProvider",
            imageFile
        )
    }
}