package com.e.este

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AddTaskListAdapter(val addTaskList: List<TodayTask>): RecyclerView.Adapter<AddTaskListAdapter.ViewHolder>(){

    inner class ViewHolder(val view: View): RecyclerView.ViewHolder(view){
        var taskTitle: TextView = view.findViewById(R.id.TV_add_task_title)

        fun bind(addTask: TodayTask){
            taskTitle.text = addTask.taskTitle
        }
    }

    @SuppressLint("InflateParams")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.task_for_adding_model, null, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(addTaskList[position])
    }

    override fun getItemCount(): Int = addTaskList.size
}