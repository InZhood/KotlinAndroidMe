package com.inzhood.androidme.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.inzhood.androidme.R
import com.inzhood.androidme.data.ImageAssets

import kotlinx.android.synthetic.main.fragment_body_part.*

class AndroidMeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_android_me)
        var headFragment = HeadPartFragment.newInstance()
        var bodyFragment = BodyPartFragment.newInstance()
        var legFragment = LegPartFragment.newInstance()

        // added after the mVars created
        //headFragment.setImageIdsList(ImageAssets.getHeads())
        // headFragmet initializes itself, later, can do this with remaining
        //bodyFragment.setImageIdsList(ImageAssets.getBodies())
        //legFragment.setImageIdsList(ImageAssets.getLegs())


        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.head_container, headFragment)
                .add(R.id.body_container, bodyFragment)
                .add(R.id.leg_container, legFragment)
                .commitNow()
        }
    }
}