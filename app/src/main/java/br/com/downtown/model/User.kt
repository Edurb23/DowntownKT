package br.com.downtown.model

data class User(
    val name: String,
    val email: String,
    val password: String
)
data class UserResponse(
    val error: String?,
    val message: String?
)
