package com.koshkin.android.testzba.domain.usecases

import com.koshkin.android.testzba.data.entities.BinEntities
import com.koshkin.android.testzba.domain.entities.BinCard
import com.koshkin.android.testzba.domain.repositories.BinRepository
import com.koshkin.android.testzba.presentation.entitypr.BinEntityPr

class SaveBinCardUseCase(private val binRepository: BinRepository) {
    suspend operator fun invoke(binCard: BinEntities) = binRepository.saveBinCard(binCard)
}