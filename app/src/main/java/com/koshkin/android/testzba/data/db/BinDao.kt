package com.koshkin.android.testzba.data.db

import androidx.room.*
import com.koshkin.android.testzba.data.entities.BinEntities
import kotlinx.coroutines.flow.Flow

@Dao
interface BinDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
       suspend fun saveBin(bin:BinEntities)

    @Query("SELECT * FROM Bin")
    fun getSavedBins(): List<BinEntities>

    @Delete
    suspend fun deleteBin(Bin: BinEntities)
}