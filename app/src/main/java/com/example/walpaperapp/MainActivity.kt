package com.example.walpaperapp

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import kotlin.arrayOf

class MainActivity : AppCompatActivity() {
    private var currentImage = 0
    lateinit var image: ImageView

    // Image names matching your drawable resources
    private val imageNames = arrayOf(
        "Beautyfull girl" , "Nature" ,"Nature", "Nature", "Car", "Nature", "Nature", "Flower", "city", "Jhula", "Glaxy")
    // Array of ImageView IDs (must match your XML layout IDs)
    private val imageViewIds = arrayOf(
        R.id.image1, R.id.image2, R.id.image3, R.id.image4 , R.id.image5, R.id.image6, R.id.image7, R.id.image8, R.id.image9, R.id.image10, R.id.image11
    )





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val nextButton = findViewById<ImageButton>(R.id.btn2)
        val prevButton = findViewById<ImageButton>(R.id.btn1)
        val imageName = findViewById<TextView>(R.id.textView)

        // Initialize with first image visible
        updateImageDisplay(imageName)

        nextButton.setOnClickListener {
            // Hide current image
            hideCurrentImage()

            // Move to next image
            currentImage = (currentImage + 1) % imageNames.size

            // Show new image
            showCurrentImage()

            // Update text
            imageName.text = imageNames[currentImage]
        }

        prevButton.setOnClickListener {
            // Hide current image
            hideCurrentImage()

            // Move to previous image
            currentImage = if (currentImage - 1 < 0) imageNames.size - 1 else currentImage - 1

            // Show new image
            showCurrentImage()

            // Update text
            imageName.text = imageNames[currentImage]
        }
    }

    private fun hideCurrentImage() {
        image = findViewById(imageViewIds[currentImage])
        image.alpha = 0f
    }

    private fun showCurrentImage() {
        image = findViewById(imageViewIds[currentImage])
        image.alpha = 1f
    }

    private fun updateImageDisplay(textView: TextView) {
        showCurrentImage()
        textView.text = imageNames[currentImage]
    }
}
