package edu.cmu.sportsmatching.ui.signup

data class SignupFormState(
    val usernameError: Int? = null,
    val emailError: Int? = null,
    val passwordError: Int? = null,
    val retypeError: Int? = null,
    val phoneError: Int? = null,
    val isDataValid: Boolean = false
)