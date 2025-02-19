package com.mastercoding.studentmanagerapp.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface StudentDao {

    @Insert
    suspend fun insert(student: Student)

    @Update
    suspend fun update(student: Student)

    @Delete
    suspend fun delete(student: Student)

    @Query("SELECT * FROM students WHERE name LIKE :searchQuery")
    fun search(searchQuery: String): Flow<List<Student>>
    
    @Query("SELECT * FROM students ORDER BY id ASC")
    fun getAllStudents():Flow<List<Student>>
}