package com.koshkin.android.testzba

import android.app.Application
import com.koshkin.android.testzba.data.repositories.BinRepositoryImp
import com.koshkin.android.testzba.domain.repositories.BinRepository

class CABApplication : Application() {
    private  val binRepository:BinRepositoryImp
        get() =ServiceLocator
}