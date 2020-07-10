package com.example.myapplication.Data

import androidx.room.Entity
import androidx.room.PrimaryKey

//practic 17
@Entity
class StudentsGroup {

    @PrimaryKey
    var groupId: String = ""
}