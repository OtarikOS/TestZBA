package com.koshkin.android.testzba.domain.usecases

import com.koshkin.android.testzba.domain.repositories.BinRepository

class GetRemoteBinUseCase(private  val binRepository: BinRepository) {
    suspend operator fun invoke(id:Int) = binRepository.getRemoteBin(id)
}