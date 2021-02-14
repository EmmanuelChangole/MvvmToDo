package echangole.com.mvvmtodo.ui.tasks

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import echangole.com.mvvmtodo.data.Task
import echangole.com.mvvmtodo.databinding.ItemTaskBinding

class TaskAdapter: ListAdapter<Task,TaskAdapter.TaskViewHolder>(DiffCallback())
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder
    {
        val binding= ItemTaskBinding.inflate(LayoutInflater.from(parent.context));
        return TaskViewHolder(binding)
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
       val currentItem=getItem(position)
        holder.bind(currentItem)
    }

    class TaskViewHolder(private val binding:ItemTaskBinding):RecyclerView.ViewHolder(binding.root)
    {
        fun bind(task:Task)
        {
            binding.apply {
                checkBoxComplete.isChecked=task.completed
                textViewName.text=task.name
                textViewName.paint.isStrikeThruText=task.completed
                labelPriority.isVisible=task.important


            }
        }


    }
    class DiffCallback:DiffUtil.ItemCallback<Task>()
    {
        override fun areItemsTheSame(oldItem: Task, newItem: Task)=oldItem.id==newItem.id

        override fun areContentsTheSame(oldItem: Task, newItem: Task) =
          oldItem == newItem

    }
}