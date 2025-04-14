package com.example.roomdatabasemvvmcoroutinsdatabinding.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PersonModel(
    val name : String,
    val age : Int,
    @PrimaryKey(autoGenerate = true)
    val aadharCardNumber : Int = 0
) {
}