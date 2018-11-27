package my.com.toru.zaloraassess.ui

import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import my.com.toru.zaloraassess.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
    }
}