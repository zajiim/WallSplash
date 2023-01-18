package com.neon.wallsplash.recyclerView

import android.view.View
import com.neon.wallsplash.models.Photo

interface WallpaperInteractionListener {
    fun onClickItem(data: Photo, view: View)
}