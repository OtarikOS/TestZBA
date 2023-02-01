package com.koshkin.android.testzba.domain.usecases

import com.koshkin.android.testzba.data.entities.BinEntities
import com.koshkin.android.testzba.domain.entities.BinCard
import com.koshkin.android.testzba.domain.repositories.BinRepository

class DeleteBinCardUseCase(private val binRepository: BinRepository) {
    suspend operator fun invoke(binCard: BinEntities)=binRepository.deleteBinCard(binCard)
}