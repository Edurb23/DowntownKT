package br.com.downtown.activity

import android.widget.ImageButton


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button

import br.com.downtown.R

class CasualFActivity : Activity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var view = View(this)
        setContentView(R.layout.activity_casual_fem)


        val botaoVoltar: ImageButton = findViewById(R.id.backButton)
        botaoVoltar.setOnClickListener {
            finish()
        }



    }

}