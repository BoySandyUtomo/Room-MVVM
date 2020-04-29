package com.example.roommvvm.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


//class yg digunakan untuk menentukan struktur dalam tabel student
@Entity
data class Student (
    //menentutukan primary key tabel (auto increment)
    @PrimaryKey(autoGenerate = true) var id: Int? = null,

    //untuk mendeklarasikan struktur tabel
    @ColumnInfo var name: String = ""
)