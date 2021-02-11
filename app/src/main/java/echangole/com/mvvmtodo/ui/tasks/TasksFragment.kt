package echangole.com.mvvmtodo.ui.tasks

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import dagger.hilt.android.AndroidEntryPoint
import echangole.com.mvvmtodo.R

@AndroidEntryPoint
class TasksFragment:Fragment(R.layout.fragment_tasks )
{

    private val viewModel:TaskViewModel by viewModels()
}