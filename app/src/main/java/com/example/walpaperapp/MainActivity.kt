package com.example.walpaperapp

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView // Import ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    // Use 'var' to allow the variable to be changed.
    var currentImage = 0
    // It's good practice to have an array or list of your images.
    private val imageNames = arrayOf("pic0", "pic1", "pic2", "pic3") // Add all your image names here

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val nextButton = findViewById<ImageButton>(R.id.btn2)
        val prevButton = findViewById<ImageButton>(R.id.btn1)
        val imageDisplay = findViewById<ImageView>(R.id.image1) // Assuming you have an ImageView with this ID

        nextButton.setOnClickListener {
            // 1. Increment the integer index first.
            currentImage++
            // Optional: Loop back to the start if you reach the end.
            if (currentImage >= imageNames.size) {
                currentImage = 0
            }

            // 2. Get the resource ID for the new image name.
            val resourceId = resources.getIdentifier(imageNames[currentImage], "drawable", packageName)

            // 3. Set the image resource for your ImageView.
            imageDisplay.setImageResource(resourceId)
        }

        prevButton.setOnClickListener {
            // 1. Decrement the integer index first.
            currentImage--
            // Optional: Loop to the end if you go past the beginning.
            if (currentImage < 0) {
                currentImage = imageNames.size - 1
            }

            // 2. Get the resource ID for the new image name.
            val resourceId = resources.getIdentifier(imageNames[currentImage], "drawable", packageName)

            // 3. Set the image resource for your ImageView.
            imageDisplay.setImageResource(resourceId)
        }
    }
}
