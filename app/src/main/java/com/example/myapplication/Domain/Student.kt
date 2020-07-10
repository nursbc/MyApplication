package com.example.myapplication.Domain

import android.os.Parcel
import android.os.Parcelable
import java.util.*

class Student : Parcelable {

    var name : String = ""
    var description : String = ""
    var mark : Float = 0.0F
    var date: Date? = null
    var studentGroup: String = ""

    constructor(parcel: Parcel) : this() {
        name = parcel.readString().toString()
        description = parcel.readString().toString()
        mark = parcel.readFloat()
    }

    constructor()
    constructor(name: String, description : String, mark : Float)
    {
        this.name = name
        this.description = description
        this.mark = mark
    }

    constructor(name: String, description : String, mark : Float, date : Date?, studentGroup : String)
    {
        this.name = name
        this.description = description
        this.mark = mark
        this.date = date
        this.studentGroup = studentGroup
    }

    fun getnDate(): String {
        return date.toString()
    }
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(description)
        parcel.writeFloat(mark)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Student> {
        override fun createFromParcel(parcel: Parcel): Student {
            return Student(parcel)
        }

        override fun newArray(size: Int): Array<Student?> {
            return arrayOfNulls(size)
        }
    }

}