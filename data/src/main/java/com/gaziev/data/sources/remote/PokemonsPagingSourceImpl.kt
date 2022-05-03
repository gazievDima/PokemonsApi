package com.gaziev.data.sources.remote

import android.content.ContentValues.TAG
import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.gaziev.data.models.PokemonRemoteEntity
import com.gaziev.data.repository.mapper.Mapper
import com.gaziev.domain.models.PokemonRemoteDetails
import javax.inject.Inject

class PokemonsPagingSourceImpl @Inject constructor(
    private val source: PokemonsApiService,
    private val mapper: Mapper<PokemonRemoteEntity, PokemonRemoteDetails>
) : PagingSource<Int, PokemonRemoteDetails>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PokemonRemoteDetails> {
        val currentKey = params.key ?: 1
        val nextKey = currentKey + 1
        val response = source.getPagePokemonsCards(currentKey, params.loadSize)

        val list = mutableListOf<PokemonRemoteDetails>()
            response.data!!.forEach {
                list.add(mapper.mapTo(it))
            }

        return LoadResult.Page(
            data = list,
            prevKey = null,
            nextKey = nextKey
        )
    }

    override fun getRefreshKey(state: PagingState<Int, PokemonRemoteDetails>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}