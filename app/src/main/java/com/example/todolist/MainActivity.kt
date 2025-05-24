package com.example.todolist

import android.os.Bundle
import android.view.inputmethod.EditorInfo
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.model.Task
import com.google.android.material.textfield.TextInputEditText

/**
 * Main activity that handles adding, completing and deleting tasks.
 */
class MainActivity : AppCompatActivity() {

    private val tasks = mutableListOf<Task>()
    private lateinit var adapter: TaskAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = TaskAdapter(tasks, ::completeTask, ::deleteTask)
        findViewById<RecyclerView>(R.id.recyclerView).apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = this@MainActivity.adapter
        }

        findViewById<TextInputEditText>(R.id.inputTask).setOnEditorActionListener { textView, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                val title = textView.text.toString()
                if (title.isNotBlank()) {
                    addTask(title)
                    textView.text?.clear()
                }
                true
            } else {
                false
            }
        }
    }

    private fun addTask(title: String) {
        tasks.add(Task(title))
        adapter.notifyItemInserted(tasks.size - 1)
    }

    private fun completeTask(position: Int) {
        tasks[position].isCompleted = !tasks[position].isCompleted
        adapter.notifyItemChanged(position)
    }

    private fun deleteTask(position: Int) {
        tasks.removeAt(position)
        adapter.notifyItemRemoved(position)
    }
}
