package com.neon.wallsplash.ui.fragments


import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.neon.wallsplash.databinding.FragmentPopularBinding
import com.neon.wallsplash.recyclerView.HomeRecyclerViewAdapter
import com.neon.wallsplash.ui.fragments.base.BaseFragment
import com.neon.wallsplash.ui.viewModels.HomeViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class PopularFragment : BaseFragment<FragmentPopularBinding>(
    FragmentPopularBinding::inflate
) {
    private val viewModel: HomeViewModel by viewModels()
    override fun initViewModel() {
        lifecycleScope.launch {
            viewModel.homePage.collectLatest {
                recyclerViewAdapter.submitData(it)
            }
        }
    }

    override fun initRecyclerView() {
        val layoutManager = GridLayoutManager(context, 2)
        binding.rvPopularFragment.layoutManager = layoutManager
        binding.rvPopularFragment.adapter = recyclerViewAdapter
    }

    override var recyclerViewAdapter: HomeRecyclerViewAdapter =
        HomeRecyclerViewAdapter()

}