package com.example.educationalbook.tenth.short_notes_10

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
import com.example.educationalbook.R
import com.google.ai.client.generativeai.GenerativeModel
import kotlinx.coroutines.runBlocking

class English_10_sn : AppCompatActivity() {
    var sn_eng: WebView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_english10_sn)

        sn_eng = findViewById(R.id.eng_pdf)

        sn_eng!!.getSettings().javaScriptEnabled = true
        sn_eng!!.setWebViewClient(WebViewClient())
        sn_eng!!.loadUrl("https://drive.google.com/file/d/1G3iivzKjc5eM4nLgjOhZR9DTvjHFT7ia/view?usp=drive_link")
        supportActionBar!!.hide()

        val eg10_ai = findViewById<EditText>(R.id.eg10_ai)
        val eg10_aibtn = findViewById<Button>(R.id.eg10_aibtn)
        val eg10_res = findViewById<TextView>(R.id.eg10_res)

        eg10_aibtn.setOnClickListener {
            val prompt = eg10_ai.text.toString()
            val generativeModel = GenerativeModel(
                modelName = "gemini-pro",
                apiKey = "AIzaSyCZ-W568tMbiDcsdUWtJMAMGGTIURm36kI"
            )
            runBlocking {
                val response = generativeModel.generateContent(prompt)
                eg10_res.text = response.text
            }
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}