package br.com.downtown.activity

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Button
import br.com.downtown.R

class CasualMActivity : Activity() {

    @SuppressLint("MissingInflatedId", "WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        var view = View(this)
        setContentView(R.layout.activity_casual_masc)

        val botaoVoltar: Button = findViewById(R.id.backButton)
        botaoVoltar.setOnClickListener {
            finish()
        }




    }


}