package com.example.mypratice_databinding_1

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.mypratice_databinding_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val viewModel by lazy {
        ViewModelProvider(this).get(MyViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.myViewModel = viewModel
        binding.lifecycleOwner = this

        binding.btnMain.setOnClickListener {
            viewModel.text_1.value = "CCC"
            Toast.makeText(this, "VM: ${viewModel.text_1.value}", Toast.LENGTH_SHORT).show()
        }
    }
}