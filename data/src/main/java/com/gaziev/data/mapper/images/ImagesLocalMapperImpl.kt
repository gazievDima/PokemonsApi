package com.gaziev.data.mapper.images

import com.gaziev.data.models.ImagesLocalEntity
import com.gaziev.data.repository.Mapper
import com.gaziev.domain.models.ImagesLocalDetails
import javax.inject.Inject

class ImagesLocalMapperImpl @Inject constructor() : Mapper<ImagesLocalEntity, ImagesLocalDetails> {

    override fun mapTo(t: ImagesLocalEntity): ImagesLocalDetails {
        return ImagesLocalDetails(
            small = t.small,
            large = t.large
        )
    }

    override fun mapFrom(v: ImagesLocalDetails): ImagesLocalEntity {
        return ImagesLocalEntity(
            small = v.small,
            large = v.large
        )
    }
}