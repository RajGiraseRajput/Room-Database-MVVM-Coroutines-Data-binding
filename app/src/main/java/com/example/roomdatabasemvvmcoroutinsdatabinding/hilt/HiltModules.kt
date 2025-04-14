package com.example.roomdatabasemvvmcoroutinsdatabinding.hilt

import android.content.Context
import com.example.roomdatabasemvvmcoroutinsdatabinding.repository.PersonRepository
import com.example.roomdatabasemvvmcoroutinsdatabinding.room.PersonDao
import com.example.roomdatabasemvvmcoroutinsdatabinding.room.PersonDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object HiltModules {

    @Provides
    @Singleton
    fun providerPersonDao(@ApplicationContext context: Context):PersonDao{
        return PersonDatabase.getInstance(context).getPersonDao()
    }

    @Provides
    @Singleton
    fun providerPersonRepo(personDao: PersonDao):PersonRepository{
        return PersonRepository(personDao)
    }

}