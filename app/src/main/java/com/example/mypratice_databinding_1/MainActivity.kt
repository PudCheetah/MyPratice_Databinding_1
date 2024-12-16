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
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MyViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //先聲明binding,viewModel
        binding = ActivityMainBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(MyViewModel::class.java)

        setContentView(binding.root)


        //將viewModel和布局文件中的變量關聯起來
        binding.myViewModel = viewModel
        //使系統能感知 Activity 的生命週期，從而監聽 LiveData 的變化並自動更新 UI
        binding.lifecycleOwner = this

        //按下按鈕後，會將ViewModel中的text_1值改為CCC
        binding.btnMain.setOnClickListener {
            viewModel.text_1.value = "CCC"
            Toast.makeText(this, "VM: ${viewModel.text_1.value}", Toast.LENGTH_SHORT).show()
        }
    }
}