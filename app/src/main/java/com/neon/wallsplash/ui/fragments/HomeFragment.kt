package com.neon.wallsplash.ui.fragments


import android.annotation.SuppressLint
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.neon.wallsplash.databinding.FragmentHomeBinding
import com.neon.wallsplash.models.Photo
import com.neon.wallsplash.recyclerView.RecyclerViewAdapter
import com.neon.wallsplash.recyclerView.WallpaperInteractionListener
import com.neon.wallsplash.ui.fragments.base.BaseFragment
import com.neon.wallsplash.ui.viewModels.HomeViewModel
import com.neon.wallsplash.utils.Constants
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


class HomeFragment : BaseFragment<FragmentHomeBinding>(
    FragmentHomeBinding::inflate
), WallpaperInteractionListener {
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
        binding.rvHomeFragment.layoutManager = layoutManager
        binding.rvHomeFragment.adapter = recyclerViewAdapter
    }

    override var recyclerViewAdapter: RecyclerViewAdapter =
        RecyclerViewAdapter( this)

    @SuppressLint("SuspiciousIndentation")
    override fun onClickItem(data: Photo, view: View) {
        val imageData = arrayOf(data.src.large)
            Navigation.findNavController(view)
                    .navigate(MainFragmentDirections.actionMainFragmentToDownloadFragment(imageData))
            }

    }

