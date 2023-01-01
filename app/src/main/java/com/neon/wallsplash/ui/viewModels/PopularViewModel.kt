package com.neon.wallsplash.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.neon.wallsplash.paging.PopularPagingSource
import com.neon.wallsplash.services.repository.MainRepository

class PopularViewModel: ViewModel() {
    private val repository = MainRepository()

    val popularPage = Pager(config = PagingConfig(pageSize = 60),
        pagingSourceFactory = {
            PopularPagingSource(repository.retroServices())
        }).flow.cachedIn(viewModelScope)
}