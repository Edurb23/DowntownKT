package br.com.downtown.activity

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.downtown.R
import br.com.downtown.auth.RetroFit
import br.com.downtown.model.UpdateUser
import br.com.downtown.model.User
import br.com.downtown.model.UserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EditProfileActivity : AppCompatActivity() {

    private lateinit var nameField: EditText
    private lateinit var emailField: EditText
    private lateinit var saveButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_editar_perfil)

        nameField = findViewById(R.id.name)
        emailField = findViewById(R.id.email)
        saveButton = findViewById(R.id.saveButton)


        fetchUserProfile()



        val backButton: ImageButton = findViewById(R.id.backButton)
        backButton.setOnClickListener {
            finish()
        }


        saveButton.setOnClickListener {
            val newName = nameField.text.toString()
            val newEmail = emailField.text.toString()

            if (newName.isNotEmpty() && newEmail.isNotEmpty()) {
                updateUserProfile(newName, newEmail)
            } else {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            }
        }
    }


    private fun fetchUserProfile() {
        val sharedPreferences = getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
        val token = sharedPreferences.getString("jwt_token", null)

        if (token == null) {
            Toast.makeText(this, "Erro: Token não encontrado. Faça login novamente.", Toast.LENGTH_SHORT).show()
            return
        }


        RetroFit.api.getUser("Bearer $token").enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful) {
                    val user = response.body()
                    user?.let {
                        nameField.setText(it.nome)
                        emailField.setText(it.email)
                    }
                } else {
                    Toast.makeText(this@EditProfileActivity, "Erro ao obter informações do usuário", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                Toast.makeText(this@EditProfileActivity, "Erro: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }


    private fun updateUserProfile(nome: String, email: String) {
        val sharedPreferences = getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
        val token = sharedPreferences.getString("jwt_token", null)

        if (token == null) {
            Toast.makeText(this, "Erro: Token não encontrado. Faça login novamente.", Toast.LENGTH_SHORT).show()
            return
        }

        val updatedUser = UpdateUser(nome = nome, email = email)

        RetroFit.api.updateUser("Bearer $token", updatedUser).enqueue(object : Callback<UserResponse> {
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                if (response.isSuccessful) {

                    val userResponse = response.body()
                    if (userResponse != null) {
                        Toast.makeText(this@EditProfileActivity, "Perfil atualizado com sucesso", Toast.LENGTH_SHORT).show()
                    } else {

                        Toast.makeText(this@EditProfileActivity, "Perfil atualizado com sucesso", Toast.LENGTH_SHORT).show()
                    }
                    finish()
                } else {
                    Toast.makeText(this@EditProfileActivity, "Erro ao atualizar perfil", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                Toast.makeText(this@EditProfileActivity, "Erro: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
