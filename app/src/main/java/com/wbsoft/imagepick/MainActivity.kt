package com.wbsoft.imagepick

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.FileProvider
import com.wbsoft.imagepick.databinding.ActivityMainBinding
import java.io.File

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val contract= registerForActivityResult(ActivityResultContracts.GetContent()) {
        binding.profileImgId.setImageURI(it)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding=ActivityMainBinding.inflate(layoutInflater)


        binding.linTakenPhoto.setOnClickListener {
            contract.launch("image/*")
        }


        setContentView(binding.root)

    }
}