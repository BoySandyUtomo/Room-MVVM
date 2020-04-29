package com.example.roommvvm.viewmodel

import android.app.Application
import android.graphics.Movie
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.roommvvm.data.AppDatabase
import com.example.roommvvm.entity.Student
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import timber.log.Timber

//class ini berfungsi sebagai menyimpan inputan dan mengatur data yg berhubungan dengan view
class NewStudentViewModel(application: Application) : AndroidViewModel(application) {

    //deklarasi variabel yg dibutuhkan
    private val mDb: AppDatabase? = AppDatabase.getInstance(application)
    private val allStudent = MutableLiveData<List<Student>>()

    //fungsi yg berguna untuk menyimpan data
    fun storeMovie(title: String) {

        //memasukkan data tabel studnet ke variabel
        val student = Student()

        //proses input ke filed name
        // data input diambil dari parameter yg dikirimkan melalui NewNameFragment
        student.name = title

        //untuk menjalankan query input yg ada dalam StudentDao
        GlobalScope.launch {
            mDb?.studentDao()?.insertStudent(student)
        }
    }

    //fungsi yg berguna untuk mengambil dan menampilkan data
    fun retrieveStudent(): LiveData<List<Student>> {

        //untuk menjalankan query select yg tersimpan dalam StudentDao
        GlobalScope.launch {
            val list = mDb?.studentDao()?.getAll()

            //memperlihatkan jumlah data dalam table student
            Timber.i("Data yang ada sejumlah {${list?.size}}")
            allStudent.postValue(list)
        }

        return allStudent
    }
}