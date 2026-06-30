package com.sample.edgedetection.base

import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.sample.edgedetection.R

abstract class BaseActivity : AppCompatActivity() {

    protected val TAG = this.javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(provideContentViewId())
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        initPresenter()
        setupSystemBars()
        prepare()
    }

    /**
     * Configures the system bars to use solid colors and ensures the layout
     * respects the insets (so buttons are not covered by the navigation bar).
     */
    private fun setupSystemBars(
        statusBarColor: Int = resources.getColor(R.color.colorPrimary),
        navBarColor: Int = resources.getColor(R.color.colorPrimary)
    ) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // Remove any translucent flags that would cause overlapping
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = statusBarColor
            window.navigationBarColor = navBarColor
        }

        // Let the system apply the necessary padding for the status and navigation bars
        val contentView = findViewById<ViewGroup>(android.R.id.content)
        if (contentView.childCount > 0) {
            val rootView = contentView.getChildAt(0)
            rootView.fitsSystemWindows = true
        }
    }

    abstract fun provideContentViewId(): Int
    abstract fun initPresenter()
    abstract fun prepare()
}