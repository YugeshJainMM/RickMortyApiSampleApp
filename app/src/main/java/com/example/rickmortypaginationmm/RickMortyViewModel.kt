package com.example.rickmortypaginationmm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.rickmortypaginationmm.model.Result
import com.example.rickmortypaginationmm.paging.CharactersPaging
import kotlinx.coroutines.flow.Flow

class RickMortyViewModel : ViewModel() {

    val character: Flow<PagingData<Result>> = Pager(PagingConfig(pageSize = 40)) {
        CharactersPaging()
    }.flow.cachedIn(viewModelScope)
}