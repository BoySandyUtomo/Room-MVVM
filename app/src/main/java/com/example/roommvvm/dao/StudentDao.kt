package com.example.roommvvm.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.roommvvm.entity.Student

@Dao
//DAO digunakan untuk meletakkan query yg akan dipanggil dalam program
interface StudentDao {

    //menampilkan seluruh data dari tabel student
    @Query("Select * from student")
    fun getAll(): List<Student>


    //insert data ke tabel student
    @Insert
    fun insertStudent(item: Student)
}