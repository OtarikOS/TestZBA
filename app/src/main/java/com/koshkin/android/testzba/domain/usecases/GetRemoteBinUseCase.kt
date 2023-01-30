package com.koshkin.android.testzba.domain.usecases

import com.koshkin.android.testzba.data.repositories.BinRepositoryImp
import com.koshkin.android.testzba.domain.repositories.BinRepository

class GetRemoteBinUseCase(private  val binRepository: BinRepositoryImp) {
    suspend operator fun invoke(id:Int) = binRepository.getRemoteBin(id)
}