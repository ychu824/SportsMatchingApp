package edu.cmu.sportsmatching.data.model

data class User (
    val name: String,
    val email: String,
    val password: String? = null,
    val phone: String? = null,
)