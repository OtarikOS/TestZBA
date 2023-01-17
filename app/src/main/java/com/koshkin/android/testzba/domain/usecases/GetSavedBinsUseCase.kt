package com.koshkin.android.testzba.domain.usecases

import com.koshkin.android.testzba.domain.repositories.BinRepository

class GetSavedBinsUseCase(private val binRepository: BinRepository) {
    suspend operator fun invoke()=binRepository.getSavedBins()
}