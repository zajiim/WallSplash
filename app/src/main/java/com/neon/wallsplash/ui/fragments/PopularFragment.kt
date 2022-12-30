package com.neon.wallsplash.ui.fragments


import com.neon.wallsplash.databinding.FragmentPopularBinding
import com.neon.wallsplash.recyclerView.HomeRecyclerViewAdapter
import com.neon.wallsplash.ui.fragments.base.BaseFragment

class PopularFragment : BaseFragment<FragmentPopularBinding>(
    FragmentPopularBinding::inflate
) {
    override var recyclerViewAdapter: HomeRecyclerViewAdapter
        get() = TODO("Not yet implemented")
        set(value) {}

    override fun initViewModel() {
        TODO("Not yet implemented")
    }

    override fun initRecyclerView() {
        TODO("Not yet implemented")
    }


}