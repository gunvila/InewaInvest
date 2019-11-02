package buu.informatics.s59161125.myprojectterminewsinvest

import androidx.lifecycle.LiveData
import buu.informatics.s59161125.myprojectterminewsinvest.database.StockDatabaseDAO
import buu.informatics.s59161125.myprojectterminewsinvest.database.StockDatabaseModel

class StockControllerRepository(private val stockDAO: StockDatabaseDAO) {

    val stockAll: LiveData<List<StockDatabaseModel>> = stockDAO.getAllStock()

    fun insert(stock: StockDatabaseModel) {
        stockDAO.insert(stock)
    }

    fun delete(item: String){
        stockDAO.delete(item)
    }
}