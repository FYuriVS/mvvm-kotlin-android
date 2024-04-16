package com.yurivital.mvvm_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.yurivital.mvvm_example.databinding.ActivityMainBinding
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.buttonLogin.setOnClickListener {
            val email = binding.editEmail.text.toString()
            val password = binding.editPassword.text.toString()

            viewModel.doLogin(email, password)
        }

        setObserver()

    }

    private fun setObserver() {
        viewModel.welcome().observe(this) { welcome ->
            binding.textWelcome.text = welcome
        }

        viewModel.login().observe(this){login: Boolean ->
            if(login){
                Toast.makeText(applicationContext,"Sucesso!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(applicationContext,"Erro!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}