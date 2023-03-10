package com.neon.wallsplash.recyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions
import com.neon.wallsplash.R
import com.neon.wallsplash.databinding.ItemRecyclerViewBinding
import com.neon.wallsplash.models.Photo
import com.neon.wallsplash.ui.fragments.MainFragmentDirections
import com.neon.wallsplash.utils.Constants

class RecyclerViewAdapter(private val listener: WallpaperInteractionListener): PagingDataAdapter<Photo, RecyclerViewAdapter.MyViewHolder>(DiffUtilCallBack()) {
    inner class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val binding = ItemRecyclerViewBinding.bind(view)

        fun bind(data: Photo) {
            Glide.with(itemView.context)
                .asBitmap()
                .load(data.src.large)
                .centerCrop()
                .transition(BitmapTransitionOptions.withCrossFade(80))
                .error(R.drawable.ic_error)
                .into(binding.imageView)


            itemView.setOnClickListener {
                listener.onClickItem(data, it)
//                val imageData = arrayOf(data.src.large)
//                when(navigationId) {
//                    Constants.NavigationIntent.FromHomeToDownload -> {
//                        Navigation.findNavController(v)
//                            .navigate(MainFragmentDirections.actionMainFragmentToDownloadFragment(imageData))
//                    }
//                }
            }
        }

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(getItem(position)!!)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_view, parent, false)
        return MyViewHolder(inflater)
    }

    class DiffUtilCallBack: DiffUtil.ItemCallback<Photo>() {
        override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean {
            return oldItem == newItem
        }

    }
}