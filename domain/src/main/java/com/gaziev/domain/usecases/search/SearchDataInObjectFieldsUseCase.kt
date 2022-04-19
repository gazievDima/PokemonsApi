package com.gaziev.domain.usecases.search

class SearchDataInObjectFieldsUseCase<T : Compared> {

    fun search(list: List<T>, element: String): List<T> {
        val bufferList: MutableList<T> = mutableListOf()

        for (obj in list) {
            if (obj.equalsFields(element))
                bufferList.add(obj)
        }
        return if (bufferList.size > 0) bufferList else emptyList()
    }

}