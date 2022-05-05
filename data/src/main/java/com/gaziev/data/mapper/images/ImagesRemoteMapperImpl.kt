package com.gaziev.data.mapper.images

import com.gaziev.data.models.ImagesRemoteEntity
import com.gaziev.data.repository.Mapper
import com.gaziev.domain.models.ImagesRemoteDetails
import javax.inject.Inject

class ImagesRemoteMapperImpl @Inject constructor() : Mapper<ImagesRemoteEntity, ImagesRemoteDetails> {

    override fun mapTo(t: ImagesRemoteEntity): ImagesRemoteDetails {
        return ImagesRemoteDetails(
            small = t.small,
            large = t.large
        )
    }

    override fun mapFrom(v: ImagesRemoteDetails): ImagesRemoteEntity {
        return ImagesRemoteEntity(
            small = v.small,
            large = v.large
        )
    }


}