package com.thiago.bankapp.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.thiago.bankapp.R
import com.thiago.bankapp.databinding.FragmentLoginBinding
import com.thiago.bankapp.viewmodel.UserViewModel

class LoginFragment : Fragment() {

    private lateinit var viewModel: UserViewModel
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = FragmentLoginBinding.inflate(inflater)

        viewModel = ViewModelProviders.of(activity!!).get(UserViewModel::class.java)

        binding.setLifecycleOwner(this)

        binding.userViewModel = viewModel

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        initListeners()
        initObserver()
    }

    private fun initListeners(){
        binding.loginButton.setOnClickListener(){view ->
            viewModel.getData()
        }
    }

    private fun desableListeners(){
        binding.loginButton.isEnabled = false
        binding.password.isEnabled = false
        binding.userId.isEnabled = false
    }

    private fun initObserver(){
        viewModel.dataRetrieved.observe(this, Observer {
            if(null != it){
                if(it == true){
                    Toast.makeText(activity, "logged", Toast.LENGTH_LONG).show()
                    desableListeners()
                    this.findNavController().navigate(R.id.action_loginFragment_to_detailFragment)
                }else{
                    Toast.makeText(activity, "failed", Toast.LENGTH_LONG).show()
                }
            }
        })
    }
}
