package echangole.com.mvvmtodo.ui.tasks

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import echangole.com.mvvmtodo.data.TaskDao
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flatMapLatest
import javax.inject.Inject

class TaskViewModel @ViewModelInject constructor(
        private val taskDao:TaskDao


) :ViewModel()
{
   val searchQuery= MutableStateFlow("")
    private val taskFlow=searchQuery.flatMapLatest {
        taskDao.getTasks(it)
    }
    val task=taskFlow.asLiveData()


}