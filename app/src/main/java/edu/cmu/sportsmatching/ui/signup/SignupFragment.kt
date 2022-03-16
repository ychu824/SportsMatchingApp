package edu.cmu.sportsmatching.ui.signup

import android.app.Activity
import android.content.BroadcastReceiver
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import edu.cmu.sportsmatching.MainActivity
import edu.cmu.sportsmatching.R
import edu.cmu.sportsmatching.databinding.FragmentSignupBinding
import edu.cmu.sportsmatching.ui.login.LoggedInUserView
import edu.cmu.sportsmatching.ui.login.afterTextChanged

class SignupFragment : Fragment() {

    private lateinit var signupViewModel: SignupViewModel
    private lateinit var binding: FragmentSignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentSignupBinding.inflate(layoutInflater)
        val name = binding.signupName
        val email = binding.signupEmail
        val password = binding.signupPassword
        val retypePassword = binding.signupRetypePassword
        val phone = binding.signupPhone
        val register = binding.signupRegister

        signupViewModel = ViewModelProvider(this, SignupViewModelFactory())
            .get(SignupViewModel::class.java)

        signupViewModel.signupFormState.observe(this@SignupFragment, Observer {
            val signupState = it ?: return@Observer

            register.isEnabled = signupState.isDataValid

            if (signupState.usernameError != null) {
                name.error = getString(signupState.usernameError)
            }
            if (signupState.emailError != null) {
                email.error = getString(signupState.emailError)
            }
            if (signupState.passwordError != null) {
                password.error = getString(signupState.passwordError)
            }
            if (signupState.retypeError != null) {
                retypePassword.error = getString(signupState.retypeError)
            }
            if (signupState.phoneError != null) {
                phone.error = getString(signupState.phoneError)
            }
        })

        signupViewModel.signupResult.observe(this@SignupFragment, Observer {
            val signupResult = it ?: return@Observer

            if (signupResult.error != null) {
                showSignupFailed(signupResult.error)
                return@Observer
            }

            if (signupResult.success != null) {
                updateUiWithUser(signupResult.success)
            }

            activity?.setResult(Activity.RESULT_OK)
            activity?.finish()

            // Go to main activity if succeeded
            val intent = Intent(activity, MainActivity::class.java)
            startActivity(intent)
        })

        withAll(name, email, password, retypePassword, phone) {
            afterTextChanged {
                signupViewModel.signupDataChanged(name.text.toString(),
                    email.text.toString(), password.text.toString(), retypePassword.text.toString(),
                    phone.text.toString())
            }
        }

        register.setOnClickListener {
            signupViewModel.signup(name.text.toString(), email.text.toString(),
                password.text.toString(), phone.text.toString())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    private fun updateUiWithUser(model: LoggedInUserView) {
        val welcome = getString(R.string.welcome)
        val displayName = model.displayName
        // TODO : initiate successful logged in experience
        Toast.makeText(
            this.context,
            "$welcome $displayName",
            Toast.LENGTH_LONG
        ).show()
    }

    private fun showSignupFailed(@StringRes errorString: Int) {
        Toast.makeText(this.context, errorString, Toast.LENGTH_SHORT).show()
    }
}

/**
 * Extend with scope function with multiple objects
 */
inline fun<T, R> withAll(vararg receivers: T, block: T.() -> R) {
    for (receiver in receivers) {
        with(receiver) {
            block()
        }
    }
}