package com.example.mypratice_databinding_1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel: ViewModel() {
    val text_1 = MutableLiveData<String>("AAA")
}