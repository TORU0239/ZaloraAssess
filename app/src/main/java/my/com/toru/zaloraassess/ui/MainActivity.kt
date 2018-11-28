package my.com.toru.zaloraassess.ui

import android.content.res.Configuration
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import my.com.toru.zaloraassess.R
import my.com.toru.zaloraassess.databinding.ActivityMainBinding
import my.com.toru.zaloraassess.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    lateinit var mainbinding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainbinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mainbinding.mainViewModel = MainViewModel()
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
    }
}