package br.com.downtown.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.downtown.R
import br.com.downtown.auth.RetroFit
import br.com.downtown.model.User
import br.com.downtown.model.UserResponse

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CadastroActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_cadastro)

        val nameField: EditText = findViewById(R.id.name)
        val emailField: EditText = findViewById(R.id.email)
        val passwordField: EditText = findViewById(R.id.password)

        val botaoVoltar: ImageButton = findViewById(R.id.backButton)
        botaoVoltar.setOnClickListener {
            finish()
        }

        val CriarButton: Button = findViewById(R.id.registerButton)
        CriarButton.setOnClickListener {
            val name = nameField.text.toString()
            val email = emailField.text.toString()
            val password = passwordField.text.toString()

            if (name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()) {
                registerUser(name, email, password)
            } else {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            }
        }

        val login: TextView = findViewById(R.id.alreadyHaveAccount)
        login.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun registerUser(name: String, email: String, password: String) {
        val user = User(name, email, password)

        RetroFit.api.registerUser(user).enqueue(object : Callback<UserResponse> {
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                if (response.isSuccessful && response.body()?.error == null) {

                    Toast.makeText(this@CadastroActivity, "Cadastro efetuado com sucesso", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@CadastroActivity, LoginActivity::class.java)
                    startActivity(intent)
                } else {

                    Toast.makeText(this@CadastroActivity, response.body()?.error ?: "Erro ao cadastrar", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                // Erro na requisição
                Toast.makeText(this@CadastroActivity, "Erro: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
