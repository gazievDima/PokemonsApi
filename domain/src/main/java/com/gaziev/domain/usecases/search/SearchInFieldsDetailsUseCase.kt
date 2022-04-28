package com.gaziev.domain.usecases.search

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SearchInFieldsDetailsUseCase<T : Compared> @Inject constructor() {

    suspend fun search(list: List<T>, element: String): List<T> = withContext(Dispatchers.Default) {
        val bufferList: MutableList<T> = mutableListOf()

        for (obj in list) {
            if (obj.equalsFields(element))
                bufferList.add(obj)
        }

        return@withContext  if (bufferList.size > 0) bufferList else emptyList()
    }

}