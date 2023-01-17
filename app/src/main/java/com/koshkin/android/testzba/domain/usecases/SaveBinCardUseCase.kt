package com.koshkin.android.testzba.domain.usecases

import com.koshkin.android.testzba.domain.entities.BinCard
import com.koshkin.android.testzba.domain.repositories.BinRepository

class SaveBinCardUseCase(private val binRepository: BinRepository) {
    suspend operator fun invoke(binCard: BinCard) = binRepository.saveBinCard(binCard)
}