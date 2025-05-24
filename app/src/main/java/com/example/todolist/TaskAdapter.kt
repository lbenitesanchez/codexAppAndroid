package com.example.todolist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.model.Task

/**
 * Adapter for displaying tasks in a RecyclerView.
 */
class TaskAdapter(
    private val tasks: MutableList<Task>,
    private val onComplete: (Int) -> Unit,
    private val onDelete: (Int) -> Unit
) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.taskTitle)
        val completeButton: ImageButton = itemView.findViewById(R.id.completeButton)
        val deleteButton: ImageButton = itemView.findViewById(R.id.deleteButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_task, parent, false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = tasks[position]
        holder.title.text = task.title
        holder.title.apply {
            paint.isStrikeThruText = task.isCompleted
        }
        holder.completeButton.setOnClickListener { onComplete(position) }
        holder.deleteButton.setOnClickListener { onDelete(position) }
    }

    override fun getItemCount(): Int = tasks.size
}
