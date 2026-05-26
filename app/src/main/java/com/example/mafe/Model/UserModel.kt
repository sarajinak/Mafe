package com.example.mafe.Model

data class UserModel(
    val id: String="",
    val email: String="",
    val name: String="",
    val lastname: String="",
    val password: String="",
)
{
fun toMap(): Map<String, Any?> {
    return mapOf(
        "id" to id,
        "name" to name,
        "email" to email,
        "lastname" to lastname,
        "password" to password
    )
}
}