package buu.informatics.s59161125.myprojectterminewsinvest

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import buu.informatics.s59161125.myprojectterminewsinvest.service.ExchangeApi
import buu.informatics.s59161125.myprojectterminewsinvest.service.ExchangeProperty
import buu.informatics.s59161125.myprojectterminewsinvest.service.Rates
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class ExchangeViewModel : ViewModel() {

    private val _properties = MutableLiveData<List<Rates>>()

    val properties: LiveData<List<Rates>>
        get() = _properties


    private var viewModelJob = Job()

    private val coroutineScope = CoroutineScope(
        viewModelJob + Dispatchers.Main )
    init {
        geExchangeProperties()

    }

    private fun geExchangeProperties() {
        coroutineScope.launch {
            var getPropertiesDeferred =
                ExchangeApi.retrofitService.getProperties()

            try {
                var listResult = getPropertiesDeferred.await()
                Log.i("test","${listResult.date}")
                _properties.value = listOf(listResult.rates)
            } catch (e: Exception) {
                Log.i("error","${e.message}")
                _properties.value = ArrayList()

            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}