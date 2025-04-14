package com.example.roomdatabasemvvmcoroutinsdatabinding.repository

import com.example.roomdatabasemvvmcoroutinsdatabinding.room.PersonDao
import com.example.roomdatabasemvvmcoroutinsdatabinding.room.PersonModel


class PersonRepository(val personDao: PersonDao) {

    suspend fun insert(personModel: PersonModel){
        personDao.insert(personModel)
    }

    suspend fun delete(personModel: PersonModel){
        personDao.delete(personModel)
    }

    suspend fun update(personModel: PersonModel){
        personDao.update(personModel)
    }

    suspend fun getAllPersons():List<PersonModel>{
        return personDao.getAllPerson()
    }

}