package com.koshkin.android.testzba.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.koshkin.android.testzba.data.entities.BinEntities


@Database(entities = [BinEntities::class], version = 1, exportSchema = false)
abstract class BinDataBase : RoomDatabase() {
    abstract fun binDao(): BinDao

    companion object {
        @Volatile
        private var INSTANCE: BinDataBase? = null

        fun getDataBase(appContext: Context): BinDataBase {
val tempInstance= INSTANCE
            if (tempInstance!=null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    appContext,BinDataBase::class.java,
                    BinDataBase::class.simpleName!!
                ).fallbackToDestructiveMigration().build()
                INSTANCE=instance
return instance
            }
        }
    }

}