package my.com.toru.zaloraassess.ui

import android.arch.lifecycle.ViewModelProviders
import android.content.res.Configuration
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import my.com.toru.zaloraassess.R
import my.com.toru.zaloraassess.databinding.ActivityMainBinding
import my.com.toru.zaloraassess.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    lateinit var mainbinding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainbinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mainbinding.mainViewModel = ViewModelProviders.of(this@MainActivity).get(MainViewModel::class.java)
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
    }
}