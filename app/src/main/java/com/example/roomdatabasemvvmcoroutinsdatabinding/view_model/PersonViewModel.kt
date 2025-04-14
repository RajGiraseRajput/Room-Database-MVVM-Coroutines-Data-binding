package com.example.roomdatabasemvvmcoroutinsdatabinding.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomdatabasemvvmcoroutinsdatabinding.repository.PersonRepository
import com.example.roomdatabasemvvmcoroutinsdatabinding.room.PersonModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PersonViewModel @Inject constructor(private val personRepository: PersonRepository) : ViewModel() {

    private val _list = MutableLiveData<List<PersonModel>>()
    val list:LiveData<List<PersonModel>> = _list


    fun insert(personModel: PersonModel) = viewModelScope.launch {
        personRepository.insert(personModel)
        _list.postValue(personRepository.getAllPersons())
    }

    fun delete(personModel: PersonModel) = viewModelScope.launch {
        personRepository.delete(personModel)
        _list.postValue(personRepository.getAllPersons())
    }

    fun update(personModel: PersonModel) = viewModelScope.launch {
        personRepository.update(personModel)
        _list.postValue(personRepository.getAllPersons())
    }

    fun getAllPersons() = viewModelScope.launch {
        _list.postValue(personRepository.getAllPersons())
    }
}