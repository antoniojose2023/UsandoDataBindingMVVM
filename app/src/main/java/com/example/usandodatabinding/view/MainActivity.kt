package com.example.usandodatabinding.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.usandodatabinding.R
import com.example.usandodatabinding.databinding.ActivityMainBinding
import com.example.usandodatabinding.model.Time
import com.example.usandodatabinding.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var dataBinding: ActivityMainBinding
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

        //Databinding
        dataBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main
        )

        dataBinding.time = Time(5, "Botafogo")
        dataBinding.onClick = OnClickTime()

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

    inner class OnClickTime(){
        fun exibirTime(view: View){
            Toast.makeText(applicationContext, "Você clicou aqui . . .", Toast.LENGTH_LONG).show()
        }
    }
}