package com.neon.wallsplash.recyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.neon.wallsplash.R
import com.neon.wallsplash.databinding.CategoryItemRowBinding
import com.neon.wallsplash.models.Category

class CategoryAdapter(private val categoryList: List<Category>): RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {


    inner class CategoryViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val binding = CategoryItemRowBinding.bind(view)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.category_item_row, parent, false)
        return  CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val currentCategory = categoryList[position]
        holder.binding.apply {
            tvCategory.text = currentCategory.categoryName
            Glide.with(holder.itemView.context)
                .load(currentCategory.imageUrl)
                .centerCrop()
                .error(R.drawable.ic_error)
                .into(ivCategory)
        }
    }

    override fun getItemCount(): Int = categoryList.size
}