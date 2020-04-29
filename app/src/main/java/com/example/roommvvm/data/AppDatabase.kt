package com.example.roommvvm.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roommvvm.dao.StudentDao
import com.example.roommvvm.entity.Student


//class ini digunakan untuk mendeklarasikan room database
@Database(entities = arrayOf(Student::class), version = 1)
abstract class AppDatabase : RoomDatabase() {

    //memasukkan data import StudentDao
    abstract fun studentDao(): StudentDao


    //companion object adalah tempat menyimpan segala object yg otomatis panggil dengan classnya langsung
    companion object {
        private var INSTANCE: AppDatabase? = null

        //fungsi untuk cek apakah database sudah ada atau belum dalam device,jika belum akan di buat
        fun getInstance(context: Context): AppDatabase? {

            //mengecek database sudah ada apa belum
            if (INSTANCE == null) {
                synchronized(AppDatabase::class) {

                    //menjalankan build database jika belum ada di dalam device
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        AppDatabase::class.java, "student-database")
                        .build()
                }
            }
            return INSTANCE
        }

        //sebuah query untuk mendestroy instance/database, tetapi tidak terpakai
        fun destroyInstance() {
            INSTANCE = null
        }
    }
}