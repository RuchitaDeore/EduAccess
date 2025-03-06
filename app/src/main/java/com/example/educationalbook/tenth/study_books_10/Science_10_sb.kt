package com.example.educationalbook.tenth.study_books_10

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.educationalbook.R
import com.google.ai.client.generativeai.GenerativeModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class Science_10_sb : AppCompatActivity() {
    var sb_sci: WebView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_science10_sb)

        sb_sci = findViewById(R.id.sci_pdf)

        sb_sci!!.getSettings().javaScriptEnabled = true
        sb_sci!!.setWebViewClient(WebViewClient())
        sb_sci!!.loadUrl("https://drive.google.com/file/d/1G3iivzKjc5eM4nLgjOhZR9DTvjHFT7ia/view?usp=drive_link")
        supportActionBar!!.hide()

        val sci10_ai = findViewById<EditText>(R.id.sci10_ai)
        val sci10_aibtn = findViewById<Button>(R.id.sci10_aibtn)
        val sci10_res = findViewById<TextView>(R.id.sci10_res)

        sci10_aibtn.setOnClickListener {
            val prompt = sci10_ai.text.toString()
            lifecycleScope.launch {
                try {
                    val generativeModel = GenerativeModel(
                        modelName = "gemini-2.0-flash",
                        apiKey = "AIzaSyCZ-W568tMbiDcsdUWtJMAMGGTIURm36kI"
                    )
                    val response = generativeModel.generateContent(prompt)
                    sci10_res.text = response.text
                }catch(e:Exception){
                    sci10_res.text = "error ${e.message}"
                }
            }
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}