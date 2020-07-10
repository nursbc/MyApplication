package com.example.myapplication.Data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

//practic 17
@Dao
public interface StudentDao {

    @Query("SELECT * FROM student")
    fun initiateGetAllStudents() : List<Student>

    @Query("SELECT * FROM studentsgroup")
    fun initiateGetAllGroups() : List<StudentsGroup>

    @Query("SELECT * FROM student WHERE name IS :nameId")
    fun initiateGetStudentById(nameId: String) : Student

    @Query("SELECT * FROM student WHERE studentGroup IS :groupId")
    fun initiateGetStudentsByGroup(groupId: String) : List<Student>

    @Delete
    fun initiateDeleteAllStudents(students : List<Student>)

    @Delete
    fun initiateDeleteAllGroups(groups : List<StudentsGroup>)

    @Delete
    fun initiateDeleteStudentById(student : Student)

    @Delete
    fun initiateDeleteGroupById(group : StudentsGroup)

    @Insert
    fun initiateInsertStudent(student: Student)

    @Insert
    fun initiateInsertStudents(students : List<Student>)

    @Insert
    fun initiateInsertGroup(group : StudentsGroup)

    @Insert
    fun initiateInsertGroups(groups : List<StudentsGroup>)

}