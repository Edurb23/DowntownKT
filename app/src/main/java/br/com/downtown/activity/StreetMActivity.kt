package br.com.downtown.activity

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.downtown.R
import com.google.android.gms.analytics.ecommerce.Product


class StreetMActivity: Activity() {


    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        var view = View(this)
        setContentView(R.layout.activity_street_masc)

        val botaoVoltar: ImageButton = findViewById(R.id.backButton)
        botaoVoltar.setOnClickListener {
            finish()
        }




    }

}