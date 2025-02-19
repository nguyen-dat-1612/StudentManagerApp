package com.mastercoding.studentmanagerapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.mastercoding.studentmanagerapp.data.local.Student
import com.mastercoding.studentmanagerapp.data.local.StudentDatabase
import com.mastercoding.studentmanagerapp.data.repository.StudentRepository
import kotlinx.coroutines.launch

class StudentViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: StudentRepository
    val allStudents: LiveData<List<Student>>

    init {
        val studentDao = StudentDatabase.getDatabase(application).studentDao()
        repository = StudentRepository(studentDao)
        allStudents = repository.allStudents.asLiveData()
    }

    fun insert(student: Student) {
        viewModelScope.launch { repository.insert(student) }
    }

    fun update(student: Student) {
        viewModelScope.launch { repository.update(student) }
    }

    fun delete(student: Student) {
        viewModelScope.launch { repository.delete(student) }
    }

    fun search(query: String): LiveData<List<Student>>  {
        return repository.search(query).asLiveData()
    }

}