package edu.cmu.sportsmatching

//import edu.cmu.sportsmatching.ui.login.LoginFragment
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentContainerView
import edu.cmu.sportsmatching.databinding.ActivityLoginBinding


class LoginActivity: AppCompatActivity() {

    companion object {
        private const val TAG = "LoginActivity"
    }
    private lateinit var binding: ActivityLoginBinding
    private lateinit var mFragmentContainerView: FragmentContainerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mFragmentContainerView = binding.fragmentContainerView

    }

}

