package com.sdrss.githubtrandingrepoapp.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sdrss.githubtrandingrepoapp.R
import com.sdrss.githubtrandingrepoapp.binding.BindingActivity
import com.sdrss.githubtrandingrepoapp.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MainActivity : BindingActivity<ActivityMainBinding>() {

    override fun getLayoutResId(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.vm = getViewModel()  //set viewModel to binding variable of xml
        binding.lifecycleOwner = this  //set lifecycleOwner

    }
}
