package com.gaziev.data.mapper.images

import com.gaziev.data.mapper.DefaultValues
import com.gaziev.data.models.ImagesLocalEntity
import com.gaziev.data.repository.Mapper
import com.gaziev.domain.models.ImagesLocalDetails
import com.gaziev.domain.models.ImagesRemoteDetails
import javax.inject.Inject

class ImagesRemoteLocalMapperImpl @Inject constructor() : Mapper<ImagesRemoteDetails, ImagesLocalDetails> {

    override fun mapTo(t: ImagesRemoteDetails): ImagesLocalDetails {
        return ImagesLocalDetails(
            small = t.small ?: DefaultValues.STRING_NO_IMAGE,
            large = t.large ?: DefaultValues.STRING_NO_IMAGE
        )
    }

    override fun mapFrom(v: ImagesLocalDetails): ImagesRemoteDetails {
        return ImagesRemoteDetails(
            small = v.small,
            large = v.large
        )
    }
}