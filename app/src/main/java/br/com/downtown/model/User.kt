package br.com.downtown.model

data class User(
    val nome: String,
    val email: String,
    val password: String
)

data class UpdateUser(
    val nome: String,
    val email: String
)


data class UserResponse(
    val error: String?,
    val message: String?,
    val token: String?
)
