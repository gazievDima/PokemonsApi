package com.gaziev.data.mapper

import com.gaziev.data.models.ImagesEntity
import com.gaziev.domain.models.ImagesDetails
import javax.inject.Inject

class ImagesRemoteMapper @Inject constructor() : IMapper<ImagesEntity, ImagesDetails>{

    override fun mapTo(t: ImagesEntity): ImagesDetails {
        return ImagesDetails(t.small, t.large)
    }

    override fun mapFrom(v: ImagesDetails): ImagesEntity {
        return ImagesEntity(v.small, v.large)
    }


}