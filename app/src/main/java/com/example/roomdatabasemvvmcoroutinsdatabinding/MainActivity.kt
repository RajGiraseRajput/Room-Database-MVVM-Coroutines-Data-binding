package com.example.roomdatabasemvvmcoroutinsdatabinding

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.example.roomdatabasemvvmcoroutinsdatabinding.adapter.PersonAdapter
import com.example.roomdatabasemvvmcoroutinsdatabinding.databinding.ActivityMainBinding
import com.example.roomdatabasemvvmcoroutinsdatabinding.room.PersonModel
import com.example.roomdatabasemvvmcoroutinsdatabinding.view_model.PersonViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val viewMode: PersonViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding

    val personAdapter = PersonAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

            viewMode.getAllPersons()

        val loadingDialog = showLoadingDialog() //  Show dialog here


        binding.roomRecycler.apply {
            adapter = personAdapter
        }

        binding.saveDataButton.setOnClickListener {

            val personModel = PersonModel(
                name = binding.personName.text.toString(),
                age = binding.personAge.text.toString().trim().toInt()
            )

            viewMode.insert(personModel)
        }

        viewMode.list.observe(this){
            it?.let {
                personAdapter.setContentList(it)
                loadingDialog.dismiss()
            }
        }

        personAdapter.setOnLongItemClickListener {
            viewMode.delete(it)
        }

    }
}