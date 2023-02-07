package com.koshkin.android.testzba.data.db

import androidx.room.*
import com.koshkin.android.testzba.data.entities.BinEntities
import com.koshkin.android.testzba.domain.common.Result
import kotlinx.coroutines.flow.Flow

@Dao
interface BinDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
       suspend fun saveBin(bin:BinEntities)

    @Query("SELECT * FROM Bin")
    fun getSavedBins(): List<BinEntities>

    @Delete
    suspend fun deleteBin(Bin: BinEntities)
}