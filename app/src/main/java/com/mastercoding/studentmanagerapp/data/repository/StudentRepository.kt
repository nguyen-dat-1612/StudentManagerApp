package com.mastercoding.studentmanagerapp.data.repository

import com.mastercoding.studentmanagerapp.data.local.Student
import com.mastercoding.studentmanagerapp.data.local.StudentDao
import kotlinx.coroutines.flow.Flow

class StudentRepository(private val studentDao: StudentDao) {

    val allStudents: Flow<List<Student>> = studentDao.getAllStudents()

    suspend fun insert(student: Student) = studentDao.insert(student)

    suspend fun update(student: Student) = studentDao.update(student)

    suspend fun delete(student: Student) = studentDao.delete(student)

    fun search(query: String) = studentDao.search(query)
}