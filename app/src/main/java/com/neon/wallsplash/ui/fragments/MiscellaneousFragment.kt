package com.neon.wallsplash.ui.fragments


import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.neon.wallsplash.databinding.FragmentMiscellaneousBinding
import com.neon.wallsplash.databinding.FragmentPopularBinding
import com.neon.wallsplash.models.Photo
import com.neon.wallsplash.recyclerView.RecyclerViewAdapter
import com.neon.wallsplash.recyclerView.WallpaperInteractionListener
import com.neon.wallsplash.ui.fragments.base.BaseFragment
import com.neon.wallsplash.ui.viewModels.HomeViewModel
import com.neon.wallsplash.ui.viewModels.MiscellaneousViewModel
import com.neon.wallsplash.ui.viewModels.PopularViewModel
import com.neon.wallsplash.utils.Constants
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MiscellaneousFragment : BaseFragment<FragmentMiscellaneousBinding>(
    FragmentMiscellaneousBinding::inflate
), WallpaperInteractionListener {
    private val viewModel: MiscellaneousViewModel by viewModels()
    override fun initViewModel() {
        lifecycleScope.launch {
            viewModel.miscellaneousPage.collectLatest {
                recyclerViewAdapter.submitData(it)
            }
        }
    }

    override fun initRecyclerView() {
        val layoutManager = GridLayoutManager(context, 2)
        binding.rvMiscellaneousFragment.layoutManager = layoutManager
        binding.rvMiscellaneousFragment.adapter = recyclerViewAdapter
    }

    override var recyclerViewAdapter: RecyclerViewAdapter =
        RecyclerViewAdapter(this)

    override fun onClickItem(data: Photo, view: View) {
        val imageData = arrayOf(data.src.large)
        Navigation.findNavController(view)
            .navigate(MainFragmentDirections.actionMainFragmentToDownloadFragment(imageData))
    }

}