package com.neon.wallsplash.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.neon.wallsplash.paging.HomePagingSource
import com.neon.wallsplash.services.repository.MainRepository

class HomeViewModel: ViewModel() {
    private val repository = MainRepository()

    val homePage = Pager(config = PagingConfig(pageSize = 60),
    pagingSourceFactory = {
        HomePagingSource(repository.retroServices())
    }).flow.cachedIn(viewModelScope)
}