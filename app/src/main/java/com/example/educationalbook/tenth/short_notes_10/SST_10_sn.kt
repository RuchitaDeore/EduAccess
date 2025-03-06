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
import androidx.lifecycle.lifecycleScope
import com.example.educationalbook.R
import com.google.ai.client.generativeai.GenerativeModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class SST_10_sn : AppCompatActivity() {
    var sb_sst: WebView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sst10_sn)

        sb_sst = findViewById(R.id.sst_pdf)

        sb_sst!!.getSettings().javaScriptEnabled = true
        sb_sst!!.setWebViewClient(WebViewClient())
        sb_sst!!.loadUrl("https://drive.google.com/file/d/1G3iivzKjc5eM4nLgjOhZR9DTvjHFT7ia/view?usp=drive_link")
        supportActionBar!!.hide()

        val sst10_ai = findViewById<EditText>(R.id.sst10_ai)
        val sst10_aibtn = findViewById<Button>(R.id.sst10_aibtn)
        val sst10_res = findViewById<TextView>(R.id.sst10_res)

        sst10_aibtn.setOnClickListener {
            val prompt = sst10_ai.text.toString()
            lifecycleScope.launch {
                try {
                    val generativeModel = GenerativeModel(
                        modelName = "gemini-2.0-flash",
                        apiKey = "AIzaSyCZ-W568tMbiDcsdUWtJMAMGGTIURm36kI"
                    )
                    val response = generativeModel.generateContent(prompt)
                    sst10_res.text = response.text
                }catch(e:Exception){
                    sst10_res.text = "error ${e.message}"
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