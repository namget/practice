package com.namget.firstcitizen

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

class KotlinPr : AppCompatActivity() {


    val view: View = View(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        view.setOnClickListener {
            println("hello world id : ${it.id}")
        }

    }
}