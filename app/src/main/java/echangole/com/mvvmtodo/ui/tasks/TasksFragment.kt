package echangole.com.mvvmtodo.ui.tasks

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import echangole.com.mvvmtodo.R
import echangole.com.mvvmtodo.databinding.FragmentTasksBinding

@AndroidEntryPoint
class TasksFragment:Fragment(R.layout.fragment_tasks )
{

    private val viewModel:TaskViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding=FragmentTasksBinding.bind(view)
        val taskAdapter=TaskAdapter()
        binding.apply {
            taskRecyclerView.apply{
                adapter=taskAdapter
                layoutManager=LinearLayoutManager(requireContext())
                setHasFixedSize(true)
            } }

       viewModel.task.observe(viewLifecycleOwner)
       {
           taskAdapter.submitList(it)
       }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
      inflater.inflate(R.menu.menu_fragment,menu)
        val searchItem=menu.findItem(R.id.action_search)
        val searchView=searchItem.actionView as SearchView



    }
}