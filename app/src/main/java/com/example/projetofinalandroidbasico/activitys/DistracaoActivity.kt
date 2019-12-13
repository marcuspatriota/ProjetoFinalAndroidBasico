package com.example.projetofinalandroidbasico.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.projetofinalandroidbasico.NewsListener
import com.example.projetofinalandroidbasico.NewsListenerIF
import com.example.projetofinalandroidbasico.R
import java.net.URL

class DistracaoActivity : AppCompatActivity() {

    private lateinit var newsListener: NewsListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_distracao)
        newsListener = NewsListener(this, object : NewsListenerIF {
            override fun onNewsCompleted(s: String) {

                //textView.text = s
            }
        })
    }


    override fun onStart() {
        super.onStart()
        newsListener.execute(
            URL("https://newsapi.org/v2/everything?q=bitcoin&apiKey=" +
                    "0de9f3f28697455cb2cfc87342657676")
        )
    }
}
