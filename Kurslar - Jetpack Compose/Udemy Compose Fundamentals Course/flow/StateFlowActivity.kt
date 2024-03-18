package com.example.composefundamentals.flow

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class StateFlowActivity : AppCompatActivity() {
    // !! KOTLIN FLOWS HOW TO USE IN XML

    private lateinit var viewModel: StateFlowViewModel
    private lateinit var viewModelFactory: StateFlowViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModelFactory = StateFlowViewModelFactory(125)
        viewModel = ViewModelProvider(this,viewModelFactory).get(StateFlowViewModel::class.java)

/*        lifecycleScope.launchWhenCreated {
            viewModel.flowTotal.collect{
                binding.resultTextView.text = it.toString()
            }
        }

        lifecycleScope.launchWhenCreated {
            viewModel.message.collect{
                Toast.makeText(this@MainActivity,it,Toast.LENGTH_LONG).show()
            }
        }

        binding.insertButton.setOnClickListener {
            viewModel.setTotal(binding.inputEditText.text.toString().toInt())
        }*/
    }
}