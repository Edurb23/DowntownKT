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

class LoginActivity: AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_login)



        val emailField: EditText = findViewById(R.id.email)
        val passwordField: EditText = findViewById(R.id.password)

        val loginButton: Button = findViewById(R.id.loginButton)
        loginButton.setOnClickListener {
            val email = emailField.text.toString()
            val password = passwordField.text.toString()
            if (email.isNotEmpty() && password.isNotEmpty()) {
                val user = User(name = "", email = email, password = password)
                loginUser(user)
            } else {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            }



        }

        val createAccount: TextView = findViewById(R.id.createAccount)
        createAccount.setOnClickListener {
            val intent = Intent(this, CadastroActivity::class.java)
            startActivity(intent)
        }

        val Esqueceu: TextView = findViewById(R.id.forgotPassword)
        Esqueceu.setOnClickListener {
            val intent = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(intent)
        }

        val botaoVoltar: ImageButton = findViewById(R.id.backButton)
        botaoVoltar.setOnClickListener {
            finish()
        }



    }

    private fun loginUser(user: User) {
        // Fazendo a requisição de login usando o RetroFit
        RetroFit.api.loginUser(user).enqueue(object : Callback<UserResponse> {
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                if (response.isSuccessful) {
                    val userResponse = response.body()
                    if (userResponse?.message != null) {
                        Toast.makeText(this@LoginActivity, "Login efetuado com sucesso", Toast.LENGTH_SHORT).show()

                        // Navegar para a ProfileActivity após o login bem-sucedido
                        val intent = Intent(this@LoginActivity, ProfileActivity::class.java)
                        intent.putExtra("email", user.email)
                        intent.putExtra("name", "Nome do Usuário") // Ajuste conforme o nome do usuário retornado
                        startActivity(intent)
                    } else {
                        Toast.makeText(this@LoginActivity, "Falha no login", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this@LoginActivity, "Falha no login: ${response.errorBody()?.string()}", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                Toast.makeText(this@LoginActivity, "Erro: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }


}