package com.example.rickmortypaginationmm.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.rickmortypaginationmm.model.Result
import com.example.rickmortypaginationmm.network.RickMortyClient.INSTANCE

class CharactersPaging : PagingSource<Int, Result>() {

    override fun getRefreshKey(state: PagingState<Int, Result>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {
        val pageNumber = params.key ?: 0

        val charactersResponse = INSTANCE.getAllCharacters(page = pageNumber)
        val characters = charactersResponse.results

        val prevKey = if (pageNumber > 0) pageNumber - 1 else null
        val nextKey = if (charactersResponse.info.next != null) pageNumber + 1 else null

        return LoadResult.Page(
            data = characters,
            prevKey = prevKey,
            nextKey = nextKey
        )
    }
}