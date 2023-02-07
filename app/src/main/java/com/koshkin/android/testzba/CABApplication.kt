package com.koshkin.android.testzba

import android.app.Application
import com.koshkin.android.testzba.data.repositories.BinRepositoryImp
import com.koshkin.android.testzba.di.ServiceLocator
import com.koshkin.android.testzba.domain.usecases.DeleteBinCardUseCase
import com.koshkin.android.testzba.domain.usecases.GetRemoteBinUseCase
import com.koshkin.android.testzba.domain.usecases.GetSavedBinsUseCase
import com.koshkin.android.testzba.domain.usecases.SaveBinCardUseCase
import com.koshkin.android.testzba.presentation.mapperspr.BinEntityMapperPr

class CABApplication : Application() {
    private val binRepository: BinRepositoryImp
        get() = ServiceLocator.provideBinRepository(this)

    val deleteBinCardUseCase: DeleteBinCardUseCase
        get() = DeleteBinCardUseCase(binRepository)

    val getRemoteBinUseCase: GetRemoteBinUseCase
    get()= GetRemoteBinUseCase(binRepository)

    val getSavedBinsUseCase: GetSavedBinsUseCase
    get() = GetSavedBinsUseCase(binRepository)

    val savedBinsUseCase:SaveBinCardUseCase
    get() = SaveBinCardUseCase(binRepository)

    val binEntityMapperPr = BinEntityMapperPr()


}