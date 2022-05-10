package com.gaziev.data.sources.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.gaziev.data.models.PokemonRemoteEntity
import com.gaziev.data.models.PokemonsRetrofitEntity
import com.gaziev.data.repository.Mapper
import com.gaziev.domain.models.PokemonRemoteDetails
import retrofit2.HttpException
import java.io.IOException
import java.lang.Exception
import java.net.HttpURLConnection
import javax.inject.Inject

class PokemonsPagingSourceImpl @Inject constructor(
    private val source: PokemonsApiService,
    private val mapper: Mapper<PokemonRemoteEntity, PokemonRemoteDetails>
) : PagingSource<Int, PokemonRemoteDetails>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PokemonRemoteDetails> {
        val currentKey = params.key ?: 1
        val nextKey = currentKey + 1
        val list = mutableListOf<PokemonRemoteDetails>()

        return try {
            val response = source.getPagePokemonsCards(currentKey, params.loadSize)

            response.data?.forEach {
                list.add(mapper.mapTo(it))
            }

            LoadResult.Page(
                data = list,
                prevKey = null,
                nextKey = nextKey,
            )
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, PokemonRemoteDetails>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}