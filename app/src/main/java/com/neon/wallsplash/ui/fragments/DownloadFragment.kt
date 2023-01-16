package com.neon.wallsplash.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.neon.wallsplash.R
import com.neon.wallsplash.databinding.FragmentDownloadBinding


class DownloadFragment : Fragment() {
    private lateinit var binding: FragmentDownloadBinding
    private val  args: DownloadFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentDownloadBinding.inflate(inflater)
        loadImage(args.imageData[0])
        addCallBack()
        return binding.root
    }

    private fun loadImage(url: String) {
        Glide.with(this)
            .load(url)
            .centerCrop()
            .error(R.drawable.ic_error)
            .into(binding.imgDownload)
    }

    private fun addCallBack() {
        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }


}