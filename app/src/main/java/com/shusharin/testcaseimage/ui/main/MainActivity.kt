package com.shusharin.testcaseimage.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.shusharin.testcaseimage.R
import com.shusharin.testcaseimage.ui.mainscreen.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment: Fragment = MainFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragment_container, fragment).commit()
    }
}