package com.mastercoding.studentmanagerapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mastercoding.studentmanagerapp.R
import com.mastercoding.studentmanagerapp.data.local.Student

class StudentAdapter(private val onItemClick: (Student) -> Unit) :
    ListAdapter<Student, StudentAdapter.StudentViewHolder>(DiffCallback()){


    inner class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(student: Student) {
            itemView.findViewById<TextView>(R.id.studentName).text = student.name
            itemView.findViewById<TextView>(R.id.studentAge).text = "Tuổi: ${student.age}"
            itemView.findViewById<TextView>(R.id.studentEmail).text = student.email
            itemView.setOnClickListener { onItemClick(student) }
        }

    }

    class DiffCallback : DiffUtil.ItemCallback<Student>() {
        override fun areItemsTheSame(oldItem: Student, newItem: Student) = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: Student, newItem: Student) = oldItem == newItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_student, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
    
}