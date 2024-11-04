package br.com.downtown.activity

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import br.com.downtown.R

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val sharedPreferences = getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
        val token = sharedPreferences.getString("jwt_token", null)


        val perfil: ImageView = findViewById(R.id.profileImage)
        perfil.setOnClickListener {
            if (token != null) {

                val intent = Intent(this, ProfileActivity::class.java)
                startActivity(intent)
            } else {

                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
        }


        val streetM: LinearLayout = findViewById(R.id.streetM)
        streetM.setOnClickListener {
            val intent = Intent(this, StreetMActivity::class.java)
            startActivity(intent)
        }

        val streetF: LinearLayout = findViewById(R.id.streetF)
        streetF.setOnClickListener {
            val intent = Intent(this, StreetFActivity::class.java)
            startActivity(intent)
        }

        val casualM: LinearLayout = findViewById(R.id.casualM)
        casualM.setOnClickListener {
            val intent = Intent(this, CasualMActivity::class.java)
            startActivity(intent)
        }

        val casualF: LinearLayout = findViewById(R.id.casualF)
        casualF.setOnClickListener {
            val intent = Intent(this, CasualFActivity::class.java)
            startActivity(intent)
        }
    }
}
