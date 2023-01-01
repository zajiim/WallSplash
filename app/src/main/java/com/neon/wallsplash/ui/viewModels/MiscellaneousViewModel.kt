package com.neon.wallsplash.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.neon.wallsplash.paging.MiscellaneousPagingSource
import com.neon.wallsplash.services.repository.MainRepository

class MiscellaneousViewModel: ViewModel() {
    private val repository = MainRepository()

    val miscellaneousPage = Pager(config = PagingConfig(pageSize = 60),
        pagingSourceFactory = {
            MiscellaneousPagingSource(repository.retroServices())
        }).flow.cachedIn(viewModelScope)
}