package com.gaziev.domain.usecases.search

import com.gaziev.domain.usecases.DispatcherDomain
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SearchInFieldsDetailsUseCase<T : Compared> @Inject constructor(
    private val dispatcher: DispatcherDomain
) {

    suspend fun search(list: List<T>, element: String): List<T> = withContext(dispatcher.inject()) {
        val bufferList: MutableList<T> = mutableListOf()

        for (obj in list) {
            if (obj.equalsFields(element))
                bufferList.add(obj)
        }

        return@withContext  if (bufferList.size > 0) bufferList else emptyList()
    }

}