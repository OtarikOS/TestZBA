package com.koshkin.android.testzba.data.repositories

import com.koshkin.android.testzba.data.db.BinDao
import com.koshkin.android.testzba.data.entities.BinEntities
import com.koshkin.android.testzba.data.mappers.BinEntityMapper
import com.koshkin.android.testzba.domain.common.Result
import com.koshkin.android.testzba.domain.entities.BinCard
import com.koshkin.android.testzba.presentation.entitypr.BinEntityPr
import com.koshkin.android.testzba.presentation.mapperspr.BinEntityMapperPr
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class BinLocalDataSourceImp(
    private val binDao: BinDao,
    private val dispatcher: CoroutineDispatcher,
    private val binEntityMapper: BinEntityMapper
):BinLocalDataSource {
    override suspend fun saveBinCard(bin: BinEntities) = withContext(dispatcher){
        binDao.saveBin((bin))
    }

      override  suspend fun  deleteBinCard(bin: BinEntities) = withContext(dispatcher){
        binDao.deleteBin(bin)
    }

    override suspend fun getSavedBins():List<BinEntities>{
        return binDao.getSavedBins()
//        val savedBinFlow = binDao.getSavedBins()
//        return savedBinFlow.map { list: List<BinEntities> -> list.map { element->binEntityMapper.toBinCard(element) } }
    }
}