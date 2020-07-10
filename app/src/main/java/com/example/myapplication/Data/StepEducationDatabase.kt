package com.example.myapplication.Data

import androidx.room.Database
import androidx.room.RoomDatabase

//practic 17
@Database(entities = arrayOf(Student::class), version = 1)
abstract class StepEducationDatabase : RoomDatabase() {
    abstract fun getStudentDao(): StudentDao

}