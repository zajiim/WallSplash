package com.neon.wallsplash.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.neon.wallsplash.databinding.FragmentMainBinding
import com.neon.wallsplash.ui.fragments.adapters.ViewPagerAdapter


class MainFragment : Fragment() {


    private val tabTitles = listOf("Home", "Popular", "Misc", "Categories")
    private val fragments = listOf(HomeFragment(), PopularFragment(), MiscellaneousFragment(), CategoriesFragment())
    private lateinit var binding: FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        initViewPager()
        initTabLayout()
        initToolBar()

        return binding.root
    }

    private fun initTabLayout() {
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()
    }

    private fun initViewPager() {
        val pagerAdapter = ViewPagerAdapter(context as FragmentActivity, fragments)
        binding.viewPager.adapter = pagerAdapter
        binding.viewPager.isUserInputEnabled = false
    }

    private fun initToolBar() {
        binding.toolbar.title = "WallSplash"
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)
    }



}