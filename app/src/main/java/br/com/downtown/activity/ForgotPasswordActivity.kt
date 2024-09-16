package br.com.downtown.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.downtown.R

class ForgotPasswordActivity: AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_esquecer_senha)

        val botaoRecuperar: Button = findViewById(R.id.sendButton)
       botaoRecuperar.setOnClickListener{
           val intent = Intent(this, MainActivity::class.java)
           startActivity(intent)
           Toast.makeText(this, "Um email foi enviado para a recuperação da senha", Toast.LENGTH_SHORT).show()
       }


    }
}