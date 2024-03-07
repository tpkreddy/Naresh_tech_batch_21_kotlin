package com.nareshittechnologies.fragmentsinandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun loadCalci(view: View) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainerView, CalculatorFragment())
            .commit()
    }
    fun loadDummy(view: View) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainerView, DummyToast())
            .commit()
    }
}

// TODO 1: Create two fragments