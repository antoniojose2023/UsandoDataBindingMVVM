package com.example.usandodatabinding.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.usandodatabinding.databinding.ActivityMainBinding
import com.example.usandodatabinding.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var mainViewModel: MainViewModel
    //private val mainViewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //mainViewModel = defaultViewModelProviderFactory.create(MainViewModel::class.java)
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        binding.btRecuperarTimes.setOnClickListener {
             //mainViewModel.getListTimes2()
        }

    }

    override fun onStart() {
        mainViewModel.getListTimes2().observe(this){ times ->
            var resultado = ""
            times.forEach{
                 resultado += "$it \n"
             }
            binding.tvResultado.text = resultado
        }
        super.onStart()
    }
}