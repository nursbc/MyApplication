package com.example.myapplication

class StudentsSortUseCase {

    fun initiateSortStudentsByName(students: ArrayList<String>) : List<String>? {

        return students.sorted()
    }

    fun initiateSortStudentsRandom(students: ArrayList<String>) : List<String> {

        var temp : ArrayList<String> = ArrayList();

        for(s in students)
        {
            temp.add(students.random())
        }

        return temp
    }
}