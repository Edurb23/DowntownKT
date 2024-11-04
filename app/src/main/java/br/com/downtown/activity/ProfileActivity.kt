package br.com.downtown.activity

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import br.com.downtown.R
import br.com.downtown.auth.RetroFit
import br.com.downtown.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileActivity : Activity() {

    private var token: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        actionBar?.hide()
        setContentView(R.layout.activity_perfil)

        val sharedPreferences = getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
        token = sharedPreferences.getString("jwt_token", null)

        if (token != null) {
            getUserInfo(token!!)
        } else {
            Toast.makeText(this, "Erro: Token não encontrado. Faça login novamente.", Toast.LENGTH_SHORT).show()
        }

        val editarButton: Button = findViewById(R.id.editarButton)
        editarButton.setOnClickListener {
            try {
                val intent = Intent(this, EditProfileActivity::class.java)
                startActivity(intent)
            } catch (e: Exception) {
                e.printStackTrace()
                Toast.makeText(this, "Erro ao abrir a tela de edição", Toast.LENGTH_SHORT).show()
            }
        }




        val backButton: ImageButton = findViewById(R.id.backButton)
        backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }


        val botaoExcluir: Button = findViewById(R.id.excluirButton)
        botaoExcluir.setOnClickListener {
            confirmarExclusao(token!!)
        }

        val botaoLogout: Button = findViewById(R.id.logoutButton)
        botaoLogout.setOnClickListener {
            logoutUser()
        }
    }

    private fun getUserInfo(token: String) {
        RetroFit.api.getUser("Bearer $token").enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful) {
                    val user = response.body()

                    val nameTextView: TextView = findViewById(R.id.nomeUsuario)
                    val emailTextView: TextView = findViewById(R.id.emailUsuario)

                    user?.let {
                        nameTextView.text = it.nome
                        emailTextView.text = it.email
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



    private fun logoutUser() {
        val sharedPreferences = getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
        sharedPreferences.edit().remove("jwt_token").apply()


        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun confirmarExclusao(token: String) {
        val dialogBuilder = AlertDialog.Builder(this)
        dialogBuilder.setMessage("Você tem certeza que quer deletar sua conta?")
            .setCancelable(false)
            .setPositiveButton("Sim") { dialog, id ->
                excluirUsuario(token)
            }
            .setNegativeButton("Não") { dialog, id ->
                dialog.dismiss()
            }
        val alert = dialogBuilder.create()
        alert.setTitle("Confirmar Exclusão")
        alert.show()
    }

    private fun excluirUsuario(token: String) {
        RetroFit.api.deleteUser("Bearer $token").enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    Toast.makeText(this@ProfileActivity, "Conta excluída com sucesso", Toast.LENGTH_SHORT).show()


                    val sharedPreferences = getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
                    sharedPreferences.edit().remove("jwt_token").apply()

                    val intent = Intent(this@ProfileActivity, LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this@ProfileActivity, "Erro ao excluir conta", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                Toast.makeText(this@ProfileActivity, "Erro ao excluir conta: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
