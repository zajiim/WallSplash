package com.neon.wallsplash.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.neon.wallsplash.models.Photo
import com.neon.wallsplash.services.ApiServices

class PopularPagingSource (
    private val apiServices: ApiServices
): PagingSource<Int, Photo>() {
    override fun getRefreshKey(state: PagingState<Int, Photo>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Photo> {
        return try {
            val nextPage = params.key ?: CURRENT_PAGE_INDEX
            val responsePopular = apiServices.getPopularResponse(nextPage)
            LoadResult.Page (
                data = responsePopular.photos,
                prevKey = if(nextPage == 1) null else nextPage-1,
                nextKey = nextPage+1
//                nextKey = responseHome.page
            )

        } catch (e:Exception) {
            LoadResult.Error(e)
        }
    }

    companion object {
        private const val CURRENT_PAGE_INDEX = 1
    }

}