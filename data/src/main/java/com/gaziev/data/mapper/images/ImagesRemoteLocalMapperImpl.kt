package com.gaziev.data.mapper.images

import com.gaziev.data.models.ImagesLocalEntity
import com.gaziev.data.repository.Mapper
import com.gaziev.domain.models.ImagesLocalDetails
import com.gaziev.domain.models.ImagesRemoteDetails
import javax.inject.Inject

class ImagesRemoteLocalMapperImpl @Inject constructor() : Mapper<ImagesRemoteDetails, ImagesLocalDetails> {

    override fun mapTo(t: ImagesRemoteDetails): ImagesLocalDetails {
        return ImagesLocalDetails(
            small = t.small,
            large = t.large
        )
    }

    override fun mapFrom(v: ImagesLocalDetails): ImagesRemoteDetails {
        return ImagesRemoteDetails(
            small = v.small,
            large = v.large
        )
    }
}