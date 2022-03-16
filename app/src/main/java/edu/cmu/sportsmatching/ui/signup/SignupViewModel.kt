package edu.cmu.sportsmatching.ui.signup

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import edu.cmu.sportsmatching.R
import edu.cmu.sportsmatching.data.SignupRepository
import edu.cmu.sportsmatching.ui.login.LoginResult
import edu.cmu.sportsmatching.data.Result
import edu.cmu.sportsmatching.ui.login.LoggedInUserView


class SignupViewModel(private val signupRepository: SignupRepository) : ViewModel() {

    private val _signupForm = MutableLiveData<SignupFormState>()
    val signupFormState: LiveData<SignupFormState> = _signupForm

    private val _signupResult = MutableLiveData<LoginResult>()
    val signupResult: LiveData<LoginResult> = _signupResult

    fun signup(name: String, email: String, password: String, phone: String) {
        val result = signupRepository.register(name, email, password, phone)

        if (result is Result.Success) {
            _signupResult.value =
                LoginResult(success = LoggedInUserView(result.data.displayName))
        } else {
            _signupResult.value = LoginResult(error = R.string.register_failed)
        }
    }

    fun signupDataChanged(name: String, email: String,
                          password: String, retype: String, phone: String) {
        if (name.isBlank()) {
            _signupForm.value = SignupFormState(usernameError = R.string.invalid_username)
        } else if (!isEmailValid(email)) {
            _signupForm.value = SignupFormState(emailError = R.string.invalid_email)
        } else if (!isPasswordValid(password)) {
            _signupForm.value = SignupFormState(passwordError = R.string.invalid_password)
        } else if (!isRetypePasswordValid(password, retype)) {
            _signupForm.value = SignupFormState(retypeError = R.string.invalid_retype)
        } else if (!isPhoneValid(phone)) {
            _signupForm.value = SignupFormState(phoneError = R.string.invalid_phone)
        } else {
          _signupForm.value = SignupFormState(isDataValid = true)
        }
    }

    // A placeholder username validation check
    private fun isEmailValid(email: String): Boolean {
        return if (email.contains('@')) {
            Patterns.EMAIL_ADDRESS.matcher(email).matches()
        } else {
            email.isNotBlank()
        }
    }

    // A placeholder phone validation check
    private fun isPhoneValid(phone: String): Boolean {
        return Patterns.PHONE.matcher(phone).matches()
    }

    // A placeholder password validation check
    private fun isPasswordValid(password: String): Boolean {
        return password.length > 5
    }

    // Check retype password
    private fun isRetypePasswordValid(password: String, retype: String): Boolean {
        return password == retype
    }

}