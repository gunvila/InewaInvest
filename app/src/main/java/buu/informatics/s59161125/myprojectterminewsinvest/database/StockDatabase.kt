package buu.informatics.s59161125.myprojectterminewsinvest.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(StockDatabaseModel::class), version = 1, exportSchema = false)
abstract class StockDatabase : RoomDatabase() {
    abstract fun stockDatabaseDAO(): StockDatabaseDAO

    companion object {
        @Volatile
        private var INSTANCE: StockDatabase? = null

        fun getDatabase(
            context: Context
        ): StockDatabase {

            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    StockDatabase::class.java,
                    "stock_database"
                ).allowMainThreadQueries()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}