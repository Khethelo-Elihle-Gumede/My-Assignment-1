package com.example.myassignment1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myassignment1.ui.theme.MyAssignment1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val editTime = findViewById<EditText>(R.id.editTime)
        val btnSuggestion = findViewById<Button>(R.id.btnSuggest)
        val btnReset = findViewById<Button>(R.id.btnReset)
        val txtResult = findViewById<TextView>(R.id.txtResults)

        // Suggestion button
        btnSuggestion.setOnClickListener {
            val timeInput =
                editTime.text.toString().trim().lowercase()

            if (timeInput.isEmpty()) {
                txtResult.text = "Please enter the time of day."
                return@setOnClickListener
            }
            val suggestions = when (timeInput) {
                "morning" -> "Send a 'Good morning' text to a family member"
                "mid-morning" -> "Reach out to a  colleague with a quick 'Thank you.'"
                "afternoon" -> "Share a funny meme or interesting link with a friend"
                "snack time" , "afternoon snack" -> "Sens  a quick 'thinking of you' message"
                "dinner" -> "Call a friend or relative for a 5-minute catch-up"
                "night" , "after dinner" -> "Leave a thoughtful comment on a friend's post"
                else -> " Invalid input. Try: Morning, Afternoon, Dinner, Night."
            }

            txtResult.text = suggestions
        }

        //Reset button
        btnReset.setOnClickListener {
            editTime.text.clear()
            txtResult.text = "Your suggestions will appear here!"
        }
        }
    }




