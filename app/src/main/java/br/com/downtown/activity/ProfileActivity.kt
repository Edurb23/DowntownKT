package br.com.downtown.activity

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.downtown.R
import br.com.downtown.auth.RetroFit
import br.com.downtown.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_perfil)

        // Recebe o email da LoginActivity
        val email = intent.getStringExtra("email")

        if (email != null) {
            // Faz a chamada da API para obter as informações do usuário
            getUserInfo(email)
        } else {
            Toast.makeText(this, "Erro: Email não encontrado", Toast.LENGTH_SHORT).show()
        }

        val botaoVoltar: Button = findViewById(R.id.voltarButton)
        botaoVoltar.setOnClickListener {
            finish()
        }




    }

    private fun getUserInfo(email: String) {
        // Faz a requisição à API passando o email como parâmetro
        RetroFit.api.getUserByEmail(email).enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful) {
                    val user = response.body()

                    // Referenciar os TextViews
                    val nameTextView: TextView = findViewById(R.id.nomeUsuario)
                    val emailTextView: TextView = findViewById(R.id.emailUsuario)

                    // Preencher os TextViews com as informações do usuário
                    user?.let {
                        nameTextView.text = "${it.name}"
                        emailTextView.text = "${it.email}"
                    }

                } else {
                    Toast.makeText(this@ProfileActivity, "Usuário não encontrado", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                Toast.makeText(this@ProfileActivity, "Erro ao buscar informações: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
