package com.example.walpaperapp

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView // Import ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    // Use 'var' to allow the variable to be changed.
    private var currentImage = 0
    lateinit var image : ImageView
    // It's good practice to have an array or list of your images.
     var imageNames = arrayOf("girl", "pic1", "pic2", "pic3", "pic4", "pic5", "pic6", "pic8", "pic9", "pic10", "pic11") // Add all your image names here

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val nextButton = findViewById<ImageButton>(R.id.btn2)
        val prevButton = findViewById<ImageButton>(R.id.btn1)
        val imageName = findViewById<TextView>(R.id.textView)




        nextButton.setOnClickListener {
            // 1. Increment the integer index first
            //.
            var idcurrentImageString = "pic$currentImage"

            var idcurrentImageInt = resources.getIdentifier(idcurrentImageString, "id", packageName)
            image = findViewById(idcurrentImageInt)
            image.setImageResource(currentImage)
            image.alpha=0f
            currentImage=(11+currentImage+1)%11
//            image.animate().alpha(1f).setDuration(1000).start()
            var idimageToShowString = "pic$currentImage"
            var idimageToShowInt = resources.getIdentifier(idimageToShowString, "id", packageName)
            image = findViewById(idimageToShowInt)
//            image.animate().alpha(1f).setDuration(1000).start()
            image.alpha=1f
            //ImageString, "id", packageName)
            imageName.text = imageNames[currentImage]
//




//            currentImage++
//            // Optional: Loop back to the start if you reach the end.
//            if (currentImage >= imageNames.size) {
//                currentImage = 0
//            }
//
//            // 2. Get the resource ID for the new image name.
//            val resourceId = resources.getIdentifier(imageNames[currentImage], "drawable", packageName)
//
//            // 3. Set the image resource for your ImageView.
//            imageDisplay.setImageResource(resourceId)
        }
//
        prevButton.setOnClickListener {
            var idcurrentImageString = "pic$currentImage"

            var idcurrentImageInt = resources.getIdentifier(idcurrentImageString, "id", packageName)
            image = findViewById(idcurrentImageInt)
            image.setImageResource(currentImage)
            image.alpha=0f
            currentImage=(11+currentImage-1)%11
//            image.animate().alpha(1f).setDuration(1000).start()
            var idimageToShowString = "pic$currentImage"
            var idimageToShowInt = resources.getIdentifier(idimageToShowString, "id", packageName)
            image = findViewById(idimageToShowInt)
//            image.animate().alpha(1f).setDuration(1000).start()
            //ImageString, "id", packageName)
            image.alpha=1f



//            // 1. Decrement the integer index first.
//            currentImage--
//            // Optional: Loop to the end if you go past the beginning.
//            if (currentImage < 0) {
//                currentImage = imageNames.size - 1
//            }
//
//            // 2. Get the resource ID for the new image name.
//            val resourceId = resources.getIdentifier(imageNames[currentImage], "drawable", packageName)
//
//            // 3. Set the image resource for your ImageView.
//            imageDisplay.setImageResource(resourceId)
        }

    }
}
