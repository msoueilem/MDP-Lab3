package Walmart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.course.assignment3.R

class Walmart_login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_walmart)
        supportActionBar?.hide()
    }
}