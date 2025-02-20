package com.mastercoding.studentmanagerapp.ui.addedit

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.mastercoding.studentmanagerapp.R
import com.mastercoding.studentmanagerapp.data.local.Student
import com.mastercoding.studentmanagerapp.databinding.ActivityAddEditStudentBinding
import com.mastercoding.studentmanagerapp.ui.main.MainActivity
import com.mastercoding.studentmanagerapp.viewmodel.StudentViewModel

class AddEditStudentActivity : AppCompatActivity() {

    private lateinit var studentViewModel: StudentViewModel

    private lateinit var binding: ActivityAddEditStudentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddEditStudentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        studentViewModel = ViewModelProvider(this).get(StudentViewModel::class.java)

        binding.btnAdd.setOnClickListener {
            val name = binding.studentName.text.toString()
            val age = binding.studentAge.text.toString().toIntOrNull() ?: 0
            val email = binding.studentEmail.text.toString()
            val student = Student(name = name, age = age, email = email)

            studentViewModel.insert(student)

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}