package com.neon.wallsplash.ui.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.neon.wallsplash.databinding.FragmentCategoriesBinding
import com.neon.wallsplash.recyclerView.CategoryAdapter
import com.neon.wallsplash.utils.ApiCategories


class CategoriesFragment : Fragment() {

    private lateinit var binding: FragmentCategoriesBinding
    private lateinit var recyclerViewAdapter: CategoryAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        binding = FragmentCategoriesBinding.inflate(inflater, container, false)
        initRecyclerViewAdapter()
        return binding.root
    }

    private fun initRecyclerViewAdapter() {
        val layoutManager = GridLayoutManager(context, 2)
        recyclerViewAdapter = CategoryAdapter(ApiCategories.categoriesList)
        binding.rvCategories.layoutManager = layoutManager
        binding.rvCategories.adapter = recyclerViewAdapter

    }
}