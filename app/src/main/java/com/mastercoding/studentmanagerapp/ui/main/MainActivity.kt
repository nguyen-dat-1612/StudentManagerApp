package com.mastercoding.studentmanagerapp.ui.main

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mastercoding.studentmanagerapp.R
import com.mastercoding.studentmanagerapp.adapter.StudentAdapter
import com.mastercoding.studentmanagerapp.viewmodel.StudentViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var studentViewModel: StudentViewModel
    private lateinit var adapter: StudentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        studentViewModel = ViewModelProvider(this).get(StudentViewModel::class.java)
        adapter = StudentAdapter { student ->
            // Xử lý sự kiện khi click vào sinh viên
        }

        findViewById<RecyclerView>(R.id.recyclerView).apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = this@MainActivity.adapter
        }

        studentViewModel.allStudents.observe(this) { students ->
            adapter.submitList(students)
        }

        findViewById<Button>(R.id.addButton).setOnClickListener {
            // Mở màn hình thêm sinh viên
        }
    }
}