package com.example.roomdatabasemvvmcoroutinsdatabinding.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [PersonModel::class], version = 1, exportSchema = false)
abstract class PersonDatabase : RoomDatabase() {

    companion object{
        fun getInstance(context:Context) : PersonDatabase{
            return Room.databaseBuilder(context,PersonDatabase::class.java,"person_db")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build()
        }
    }

    abstract fun getPersonDao() : PersonDao

}