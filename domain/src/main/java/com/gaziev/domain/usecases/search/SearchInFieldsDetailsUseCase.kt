package com.gaziev.domain.usecases.search

import javax.inject.Inject

class SearchInFieldsDetailsUseCase<T : Compared> @Inject constructor() {

    fun search(list: List<T>, element: String): List<T> {
        val bufferList: MutableList<T> = mutableListOf()

        for (obj in list) {
            if (obj.equalsFields(element))
                bufferList.add(obj)
        }
        return if (bufferList.size > 0) bufferList else emptyList()
    }

}