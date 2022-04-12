package com.gaziev.domain.usecases.search

class SearchDataInObjectFieldsUseCase {

    fun search(list: List<Compared>, element: String): List<Compared> {
        val bufferList: MutableList<Compared> = mutableListOf()

        for (obj in list) {
            if (obj.equalsFields(element))
                bufferList.add(obj)
        }
        return if (bufferList.size > 0) bufferList else emptyList()
    }
}