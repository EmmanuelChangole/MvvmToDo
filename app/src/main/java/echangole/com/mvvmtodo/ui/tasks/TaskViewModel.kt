package echangole.com.mvvmtodo.ui.tasks

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import echangole.com.mvvmtodo.data.TaskDao
import javax.inject.Inject

class TaskViewModel @ViewModelInject constructor(
        private val taskDao:TaskDao


) :ViewModel()
{

}