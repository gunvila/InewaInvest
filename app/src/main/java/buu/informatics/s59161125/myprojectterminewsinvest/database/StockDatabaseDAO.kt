package buu.informatics.s59161125.myprojectterminewsinvest.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface StockDatabaseDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(food: StockDatabaseModel)

    @Query("SELECT * FROM stock ORDER BY nameStock ASC")
    fun getAllStock(): LiveData<List<StockDatabaseModel>>


    @Query("DELETE  FROM stock WHERE nameStock = :name ")
    fun delete(name: String)


}