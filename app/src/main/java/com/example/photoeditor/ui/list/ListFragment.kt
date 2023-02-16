package com.example.photoeditor.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.photoeditor.databinding.FragmentListBinding
import com.example.photoeditor.paging.MainLoadStateAdapter
import com.example.photoeditor.ui.MainAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding

    private val adapter by lazy {
        MainAdapter(onItemClick = {
            val action = ListFragmentDirections.actionListFragmentToDetailFragment(it)
            findNavController().navigate(action)
        })
    }

    private val viewModel: ListViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentListBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val adapter = MainAdapter()
        binding.rvSpecies.adapter = adapter.withLoadStateFooter(
            MainLoadStateAdapter()
        )

        lifecycleScope.launch {
            viewModel.data.collectLatest {
                adapter.submitData(it)
            }
        }
    }
}