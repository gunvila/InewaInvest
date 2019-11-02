package buu.informatics.s59161125.myprojectterminewsinvest

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import buu.informatics.s59161125.myprojectterminewsinvest.database.StockDatabase
import buu.informatics.s59161125.myprojectterminewsinvest.database.StockDatabaseModel
import kotlinx.coroutines.launch

class StockControllerModel(application: Application) : AndroidViewModel(application) {
    private val repository: StockControllerRepository
    val allStock: LiveData<List<StockDatabaseModel>>

    init {
        val foodListDao =
            StockDatabase.getDatabase(application.applicationContext).stockDatabaseDAO()
        repository = StockControllerRepository(foodListDao)
        allStock = repository.stockAll
    }

    fun insert(stock: StockDatabaseModel) = viewModelScope.launch {
        repository.insert(stock)
    }

    fun delete(item: String) = viewModelScope.launch {
        repository.delete(item)
    }
}