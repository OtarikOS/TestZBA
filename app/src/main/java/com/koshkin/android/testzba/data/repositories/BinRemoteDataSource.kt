package com.koshkin.android.testzba.data.repositories

import com.koshkin.android.testzba.data.api.CardData
import com.koshkin.android.testzba.domain.entities.BinCard
import com.koshkin.android.testzba.domain.common.Result

interface BinRemoteDataSource {
    suspend fun getBinInfo(id: Int): Result<BinCard>
}